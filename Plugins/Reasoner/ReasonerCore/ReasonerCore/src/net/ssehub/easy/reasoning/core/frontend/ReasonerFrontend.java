package net.ssehub.easy.reasoning.core.frontend;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.Bundle;
import net.ssehub.easy.reasoning.core.impl.ReasonerHelper;
import net.ssehub.easy.reasoning.core.impl.ReasonerRegistry;
import net.ssehub.easy.reasoning.core.reasoner.DelegatingReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.GeneralReasonerCapabilities;
import net.ssehub.easy.reasoning.core.reasoner.IChainingReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerRegistry;
import net.ssehub.easy.reasoning.core.reasoner.ValueCreationResult;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult.ConstraintEvaluationResult;
import net.ssehub.easy.reasoning.core.reasoner.EvaluationResult.EvaluationPair;
import net.ssehub.easy.varModel.capabilities.DefaultReasonerAccess;
import net.ssehub.easy.varModel.capabilities.IReasonerCapability;
import net.ssehub.easy.varModel.capabilities.DefaultReasonerAccess.IDefaultReasonerProvider;
import net.ssehub.easy.varModel.confModel.AssignmentResolver;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationInitializerRegistry;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.confModel.ConfigurationInitializerRegistry.IConfigurationInitializer;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * The main interface to the reasoner core infrastructure. Models and configurations will be transparently passed to
 * matching reasoners.
 * 
 * @author Patrick J�hne
 * @author Sascha El-Sharkawy
 * @author Holger Eichelberger
 */
public class ReasonerFrontend {
    private static final String NO_REASONING_AVAILABE_MSG = "No reasoners are present.\n"
        + "Consequently, desired reasoning operation could not performed.";

    private static final ReasonerFrontend INSTANCE = new ReasonerFrontend();

    private ReasonerRegistry registry;
    private IReasoner reasonerHint;
    private int timeout = 0;

    /**
     * Implements the default reasoner provider.
     * 
     * @author Holger Eichelberger
     */
    private class DefaultReasonerProvider implements IDefaultReasonerProvider {

        @Override
        public boolean hasCapability(IReasonerCapability capability) {
            return hasReasonerCapability(capability);
        }

        @Override
        public void initialize(Configuration config, ProgressObserver observer) {
            propagate(config, null, observer);
        }
        
    }
    
    /**
     * Singleton constructor for this class.
     */
    private ReasonerFrontend() {
        registry = ReasonerRegistry.getInstance();
        DefaultReasonerAccess.setProvider(new DefaultReasonerProvider()); // called when a reasoner is registered
        Boolean fallback = Boolean.valueOf(
            System.getProperty("easy.configuration.useAssignmentResolver", "false").toLowerCase());
        if (!fallback) {
            installConfigurationInitializer();
        }
    }
    
    /**
     * Installs the configuration intializer.
     */
    private void installConfigurationInitializer() {
        ConfigurationInitializerRegistry.setInitializer(new IConfigurationInitializer() {
            
            private IConfigurationInitializer fallback = ConfigurationInitializerRegistry.getInitializer();
            
            @Override
            public List<net.ssehub.easy.basics.messages.Message> initializeConfiguration(
                Configuration config, ProgressObserver observer) {
                List<net.ssehub.easy.basics.messages.Message> result = null;
                IReasoner reasoner = canInitializeConfig(getActualReasoner(config, null, null));
                for (int r = 0; null == reasoner && r < registry.getReasonerCount(); r++) {
                    IReasoner tmp = registry.getReasoner(r);
                    if (isReadyForUse(tmp)) {
                        reasoner = canInitializeConfig(tmp);
                    }
                }
                boolean useFallback = false;
                if (null != reasoner) {
                    // default reasoner configuration
                    ReasonerConfiguration initCfg = new ReasonerConfiguration();
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info(
                        "Initializing configuration with reasoner: " + reasoner.getDescriptor().getName());
                    ReasoningResult tmp = reasoner.initialize(config, initCfg, observer); 
                    useFallback = tmp.reasoningUnsupported();
                    if (tmp.getMessageCount() > 0) {
                        result = new ArrayList<net.ssehub.easy.basics.messages.Message>();
                        for (int m = 0; m < tmp.getMessageCount(); m++) {
                            result.add(tmp.getMessage(m));
                        }
                    }
                } else {
                    useFallback = true;
                }
                if (useFallback) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info(
                        "Initializing configuration with fallback: " + fallback.getClass().getName());
                    result = fallback.initializeConfiguration(config, observer);
                }
                return result;
            }

            @Override
            public boolean supportsElementCopy() {
                // something else then the default mechanism available that takes over this task?
                ReasonerDescriptor pref = getPreferredReasoner();
                return null == pref ? false : pref.hasCapability(
                    GeneralReasonerCapabilities.CONFIGURATION_INITIALIZATION);
            }
            
            @Override
            public boolean resolveDefaultValue(IDecisionVariable variable) {
                // currently fallback only, may not resolve complex dependent default values
                return AssignmentResolver.resolveDefaultValue(variable); 
            }
            
        });
    }
    
    /**
     * Checks <code>reasoner</code> for {@link GeneralReasonerCapabilities#CONFIGURATION_INITIALIZATION}.
     * @param reasoner the reasoner to check
     * @return <code>reasoner</code> if <code>capability</code> is provided, <b>null</b> else
     * @see #checkForCapabilitiy(IReasoner, IReasonerCapability)
     */
    private static IReasoner canInitializeConfig(IReasoner reasoner) {
        return checkForCapabilitiy(reasoner, GeneralReasonerCapabilities.CONFIGURATION_INITIALIZATION);
    }
    
    /**
     * Checks <code>reasoner</code> for the given reasoner <code>capability</code>.
     * @param reasoner the reasoner to check
     * @param capability the capability to check for
     * @return <code>reasoner</code> if <code>capability</code> is provided, <b>null</b> else
     */
    private static IReasoner checkForCapabilitiy(IReasoner reasoner, IReasonerCapability capability) {
        IReasoner result = null;
        if (null != reasoner) {
            ReasonerDescriptor desc = reasoner.getDescriptor();
            if (null != desc) {
                if (desc.hasCapability(capability)) {
                    result = reasoner;
                }
            }
        }
        return result;
    }

    /**
     * Returns the singleton instance of this class.
     * @return The singleton instance of this class
     */
    public static final ReasonerFrontend getInstance() {
        return INSTANCE;
    }

    /**
     * Getter for the Reasoner registry, capable of handling multiple {@link IReasoner}s.
     * @return The {@link IReasonerRegistry} used by this frontend.
     */
    public IReasonerRegistry getRegistry() {
        return registry;
    }

    /**
     * Returns the actual and matching reasoner. Considers whether
     * the reasoner is ready for use via {@link ReasonerDescriptor#isReadyForUse()}.
     * 
     * @param configuration the configuration to reason on (may be <b>null</b>)
     * @param constraints the additional constraints to reason on (may be <b>null</b>)
     * @param reasonerConfiguration the configuration to be used for the specific reasoner call (may be <b>null</b>)
     * @return the actual reasoner (may be <b>null</b>)
     */
    private IReasoner getActualReasoner(Configuration configuration, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration) {
        IReasoner result = null;
        if (null != reasonerConfiguration) {
            ReasonerDescriptor descriptor = reasonerConfiguration.getDefaultResoner();
            if (null != descriptor) {
                result = registry.findReasoner(descriptor);
            }
        }
        if (null != reasonerHint) {
            if (isReadyForUse(reasonerHint)) {
                result = reasonerHint;
            }
        }
        for (int r = 0; null == result && r < registry.getReasonerCount(); r++) {
            IReasoner reasoner = registry.getReasoner(r);
            if (isReadyForUse(reasoner)) {
                result = reasoner;
            }
        }
        return result;
    }

    /**
     * Returns whether the given <code>reasoner</code> is ready for use.
     * 
     * @param reasoner the reasoner to check for
     * @return <code>true</code> if <code>reasoner</code> is ready for
     *   use, <code>false</code> else
     * @see ReasonerDescriptor#isReadyForUse()
     */
    private static boolean isReadyForUse(IReasoner reasoner) {
        boolean result = false;
        if (null != reasoner) {
            ReasonerDescriptor desc = reasoner.getDescriptor();
            if (null != desc) {
                result = desc.isReadyForUse();
            }
        }
        return result;
    }
    
    /**
     * Checks whether a given variability model (project) is satisfiable.
     * 
     * @param project
     *            The project which should be tested whether it is satisfiable.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {

        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(null, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.isConsistent(project, reasonerConfiguration, observer);
        } else {
            result = new ReasoningResult();
            Message warning = new Message(NO_REASONING_AVAILABE_MSG, null, Status.WARNING);
            result.addMessage(warning);
        }

        return result;
    }

    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * Takes the project from the configuration. Corresponding method with project and configuration may become
     * deprecated/disappear in future.
     * 
     * @param cfg
     *            The current configuration based on the given project.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @see #check(Configuration, ReasonerConfiguration, ProgressObserver)
     */
    public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(cfg, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.check(cfg, reasonerConfiguration, observer);
        } else {
            result = new ReasoningResult();
            Message warning = new Message(NO_REASONING_AVAILABE_MSG, null, Status.WARNING);
            result.addMessage(warning);
        }
        return result;        
    }

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * Takes the project from the configuration. Corresponding method with project and configuration may become
     * deprecated/disappear in future.
     * 
     * @param cfg
     *            The current configuration based on the given project. (may be modified as a side effect
     *            of value propagation)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @see #propagate(Configuration, ReasonerConfiguration, ProgressObserver)
     */
    public ReasoningResult propagate(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(cfg, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.propagate(cfg, reasonerConfiguration, observer);
        } else {
            result = new ReasoningResult();
            Message warning = new Message(NO_REASONING_AVAILABE_MSG, null, Status.WARNING);
            result.addMessage(warning);
        }
        return result;
    }

    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * Takes the project from the configuration. Corresponding method with project and configuration may become
     * deprecated/disappear in future.
     * 
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param constraints
     *            the constraints (expressions which must evaluate to <code>true</code>)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. The result pairs may be given in a different order than in
     *         <code>constraints</code>. <b>null</b> constraints are ignored and not returned as a result. Can have the
     *         status {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not
     *         support this operation.
     *         
     * @see #evaluate(Configuration, List, ReasonerConfiguration, ProgressObserver)
     */
    public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        EvaluationResult result = null;

        // partition into valid condition constraints, erroneous constraints, ignore null
        List<Constraint> erroneous = new ArrayList<Constraint>();
        List<Constraint> toEvaluate = new ArrayList<Constraint>();
        for (int i = 0; i < constraints.size(); i++) {
            Constraint constraint = constraints.get(i);
            if (null != constraint) {
                if (constraint.isBooleanConstraint()) {
                    toEvaluate.add(constraint);
                } else {
                    erroneous.add(constraint);
                }
            }
        }

        // evaluate
        IReasoner reasoner = getActualReasoner(cfg, toEvaluate, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.evaluate(cfg, toEvaluate, reasonerConfiguration, observer);
        }
        // construct result for erroneous
        if (null == result) {
            result = new EvaluationResult();
        }
        for (int i = 0; i < erroneous.size(); i++) {
            result.addEvaluationPair(new EvaluationPair(erroneous.get(i), ConstraintEvaluationResult.UNKNOWN));
        }
        return result;
    }

    /**
     * Returns the number of reasoners which are ready for use.
     * Contrary to {@link #getReasonersCount()}, this method counts only reasoners which can be used for reasoning.
     * This number is &le; to {@link #getReasonersCount()}.
     * 
     * @return the number of reasoners which are ready for use
     * @see #getReasonersCount()
     */
    public int getReadyForUseCount() {
        int count = 0;
        for (int r = 0; r < registry.getReasonerCount(); r++) {
            ReasonerDescriptor desc = registry.getReasoner(r).getDescriptor();
            if (null != desc && desc.isReadyForUse()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * Returns the number of available reasoners.
     * This method counts also reasoners which are installed but cannot be used for reasoning, e.g.
     * no license available.
     * 
     * @return the number of available reasoners
     * @see #getReadyForUseCount()
     */
    public int getReasonersCount() {
        return registry.getReasonerCount();
    }

    /**
     * Returns the descriptor for a specific reasoner.
     * 
     * @param index
     *            the index of the reasoner
     * @return the descriptor
     * @throws IndexOutOfBoundsException
     *             in case that <code>index&lt;0 || index&gt;={{@link #getReasonersCount()}</code>
     */
    public ReasonerDescriptor getReasonerDescriptor(int index) {
        return registry.getReasoner(index).getDescriptor();
    }

    /**
     * Updates a reasoner installation, e.g., in order to obtain a licensed reasoner version.
     * 
     * @param descriptor
     *            the descriptor of the reasoner to be updated
     * @param uri
     *            the URI where the data for the upgrade is located at
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @throws IllegalArgumentException
     *             in case of illegal arguments
     */
    public ReasoningResult upgradeReasoner(ReasonerDescriptor descriptor, URI uri, ProgressObserver observer) {
        ReasoningResult result = null;
        if (null != uri) {
            IReasoner reasoner = registry.findReasoner(descriptor);
            if (null != reasoner) {
                result = reasoner.upgrade(uri, observer);
            }
            if (null == result) {
                result = new ReasoningResult();
                result.addMessage(new Message("upgrade is not supported", null, Status.ERROR));
            }
        } else {
            result = new ReasoningResult();
            result.addMessage(new Message("invalid URL", null, Status.ERROR));
        }
        return result;
    }

    /**
     * Defines that the specified reasoner shall be used. Note that this method only defines a hint. In case of
     * automated selection of reasoners, this class may ignore the specified information. Please note that
     * this method stores the selected reasoner just within the reasoner frontend and does not persist this selection.
     * 
     * @param descriptor
     *            the descriptor denoting the reasoner (may be <b>null</b> for clearing an already set hint)
     * @throws IllegalArgumentException
     *             in case of illegal arguments
     */
    public void setReasonerHint(ReasonerDescriptor descriptor) {
        if (null == descriptor) {
            reasonerHint = null;
        } else {
            reasonerHint = findReasoner(descriptor);
        }
    }

    /**
     * Return whether the current reasoner hint has a specific capability. [convenience]
     * 
     * @param capability the capability to look for
     * @return <code>true</code> if the capability is provided, <code>false</code> else
     */
    public boolean hasReasonerCapability(IReasonerCapability capability) {
        return hasReasonerCapability(capability, null);
    }
    /**
     * Return whether the current reasoner hint has a specific capability. [convenience]
     * 
     * @param capability the capability to look for
     * @param reasonerConfiguration the configuration to consider (may be <b>null</b>)
     * @return <code>true</code> if the capability is provided, <code>false</code> else
     */
    public boolean hasReasonerCapability(IReasonerCapability capability, ReasonerConfiguration reasonerConfiguration) {
        boolean result = false;
        IReasoner reasoner = getActualReasoner(null, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.getDescriptor().hasCapability(capability);
        }
        return result;
    }

    /**
     * Returns the current reasoner hint.
     * 
     * @return the current reasoner hint, may be <b>null</b>;
     */
    public ReasonerDescriptor getReasonerHint() {
        ReasonerDescriptor result = null;
        if (null != reasonerHint) {
            result = reasonerHint.getDescriptor();
        }
        return result;
    }

    /**
     * Finds a reasoner and throws related exceptions.
     * 
     * @param descriptor
     *            the descriptor of the reasoner to find
     * @return the reasoner
     * @throws IllegalArgumentException
     *             in case of illegal arguments such as <b>null</b> or an unmatching descriptor
     */
    IReasoner findReasoner(ReasonerDescriptor descriptor) {
        if (null == descriptor) {
            throw new IllegalArgumentException("descriptor must not be null");
        }
        IReasoner reasoner = registry.findReasoner(descriptor);
        if (null == reasoner) {
            throw new IllegalArgumentException("descriptor does not fit to a registered reasoner");
        }
        return reasoner;
    }
    
    /**
     * Returns the first version with given <code>name</code> and <code>version</code>.
     * @param name the name of the reasoner as given in its descriptor
     * @param version the version of the reasoner as given in its descriptor (ignored if <b>null</b>)
     * @return the first reasoner matching the criteria 
     * @throws IllegalArgumentException in case of illegal arguments such as <b>null</b> or an unmatching descriptor
     */
    public IReasoner findReasoner(String name, String version) {
        if (null == name) {
            throw new IllegalArgumentException("name must not be null");
        }
        IReasoner reasoner = registry.findReasoner(name, version);
        if (null == reasoner) {
            throw new IllegalArgumentException("descriptor does not fit to a registered reasoner");
        }
        return reasoner;
    }
    
    /**
     * Registers a message listener.
     * 
     * @param listener the listener to register
     */
    public void register(IMessageListener listener) {
        registry.register(listener);
    }

    /**
     * Unregisters a message listener.
     * 
     * @param listener the listener to unregister
     */
    public void unregister(IMessageListener listener) {
        registry.unregister(listener);
    }

    /**
     * Checks whether at least one reasoner is present.
     * @return {@code true} if at least one reasoner is present and reasoning can be done, otherwise {@code false}
     */
    public boolean reasoningSupported() {
        return getReadyForUseCount() > 0;
    }
    
    /**
     * Changes the global timeout for reasoning.
     * 
     * @param timeout the global timeout in ms, shall be ignored if less negative or null
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the global timeout for reasoning.
     * 
     * @return the global timeout in ms, shall be ignored if less negative or null
     */
    public int getTimeout() {
        return timeout;
    }
    
    /**
     * Returns the preferred reasoner descriptor due to internal knowledge about the reasoner implementation status.
     * Currently, we rely on the the reasoner with the maximum number of supported capabilities (currently, the 
     * SSE-Reasoner). This method is particularly helpful for repeatable testing.
     * 
     * @return the preferred reasoner (may be <b>null</b> if there is none registered)
     * @see #setReasonerHint(ReasonerDescriptor)
     */
    public ReasonerDescriptor getPreferredReasoner() {
        ReasonerDescriptor result = null;
        int maxCapCount = 0;
        for (int r = 0; r < getReasonersCount(); r++) {
            ReasonerDescriptor desc = getReasonerDescriptor(r);
            int capCount = desc.getCapabilityCount();
            if (null == result || capCount > maxCapCount) {
                maxCapCount = capCount;
                result = desc;
            }
        }
        return result;
    }

    /**
     * Sets the actually preferred reasoner as {@link #setReasonerHint(ReasonerDescriptor) hint}.
     * 
     * @return the preferred reasoner (may be <b>null</b> if there is none registered)
     * @see #getPreferredReasoner()
     * @see #setReasonerHint(ReasonerDescriptor)
     */
    public ReasonerDescriptor setPreferredReasoner() {
        ReasonerDescriptor pref = getPreferredReasoner();
        if (null != pref) {
            setReasonerHint(pref);
        }
        return pref;
    }

    /**
     * Returns whether the reasoner registered for this <code>descriptor</code>
     * is a chaining reasoner.
     * 
     * @param descriptor the descriptor
     * @return <code>true</code> for chaining, <code>false</code> else
     */
    public boolean isChainingReasoner(ReasonerDescriptor descriptor) {
        return findReasoner(descriptor) instanceof IChainingReasoner;
    }

    /**
     * Creates a reasoner instance for repeated reasoning on the same model (no structural changes allowed
     * during two subsequent reasoning runs).
     * Takes the project from the configuration. Corresponding method with project and configuration may become
     * deprecated/disappear in future.
     * 
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return a reusable reasoner instance, return a {@link DelegatingReasonerInstance} on this reasoner to
     *     avoid null pointer checking.
     *@see #createInstance(Configuration, ReasonerConfiguration)
     */
    public IReasonerInstance createInstance(Configuration cfg, ReasonerConfiguration reasonerConfiguration) {
        IReasonerInstance result;
        IReasoner reasoner = getActualReasoner(cfg, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.createInstance(cfg, reasonerConfiguration);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Creates the value for a certain IVML type/variable.
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints, takes precedence over {@code type})
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer) {
        ValueCreationResult result;
        IReasoner reasoner = getActualReasoner(cfg, null, reasonerConfiguration);
        if (null == reasoner) {
            // use fallback via ValueFactory
            result = ReasonerHelper.createValue(cfg, var, type, reasonerConfiguration, observer);
        } else {
            result = reasoner.createValue(cfg, var, type, reasonerConfiguration, observer);
        }
        return result;
    }

}
