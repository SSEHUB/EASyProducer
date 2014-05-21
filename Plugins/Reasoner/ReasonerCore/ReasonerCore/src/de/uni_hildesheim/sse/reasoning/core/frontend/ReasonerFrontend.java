package de.uni_hildesheim.sse.reasoning.core.frontend;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.impl.ReasonerRegistry;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult.ConstraintEvaluationResult;
import de.uni_hildesheim.sse.reasoning.core.reasoner.EvaluationResult.EvaluationPair;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerRegistry;
import de.uni_hildesheim.sse.reasoning.core.reasoner.Message;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * The main interface to the reasoner core infrastructure. Models and configurations will be transparently passed to
 * matching reasoners.
 * 
 * @author Patrick Jähne
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
     * Singleton constructor for this class.
     */
    private ReasonerFrontend() {
        registry = ReasonerRegistry.getInstance();
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
     * @param project
     *            the project to reason on
     * @param configuration
     *            the configuration to reason on (may be <b>null</b>)
     * @param constraints
     *            the additional constraints to reason on (may be <b>null</b>)
     * @param reasonerConfiguration the configuration to be used for the specific reasoner call           
     * @return the actual reasoner (may be <b>null</b>)
     */
    private IReasoner getActualReasoner(Project project, Configuration configuration, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration) {
        IReasoner result = null;
        // TODO SE: handle multiple reasoners
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
        if (null == result) {
            for (int r = 0; r < registry.getReasonerCount(); r++) {
                IReasoner reasoner = registry.getReasoner(r);
                if (isReadyForUse(reasoner)) {
                    result = reasoner;
                }
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
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #isConsistent(Project, ReasonerConfiguration, ProgressObserver)} instead
     */
    @Deprecated
    public ReasoningResult isConsistent(Project project) {
        return isConsistent(project, ProgressObserver.NO_OBSERVER);
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
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {

        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(project, null, null, reasonerConfiguration);
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
     * Checks whether a given variability model (project) is satisfiable.
     * 
     * @param project
     *            The project which should be tested whether it is satisfiable.
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #isConsistent(Project, ReasonerConfiguration, ProgressObserver)} instead
     */
    @Deprecated
    public ReasoningResult isConsistent(Project project, ProgressObserver observer) {
        return isConsistent(project, null, observer);
    }

    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project.
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #check(Project, Configuration, ReasonerConfiguration, ProgressObserver)} instead
     */
    @Deprecated
    public ReasoningResult check(Project project, Configuration cfg) {
        return check(project, cfg, ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project.
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #check(Project, Configuration, ReasonerConfiguration, ProgressObserver)}
     */
    @Deprecated
    public ReasoningResult check(Project project, Configuration cfg, ProgressObserver observer) {
        return check(project, cfg, null, observer);
    }
    
    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(project, cfg, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.check(project, cfg, reasonerConfiguration, observer);
        } else {
            result = new ReasoningResult();
            Message warning = new Message(NO_REASONING_AVAILABE_MSG, null, Status.WARNING);
            result.addMessage(warning);
        }
        return result;
    }

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project. (may be modified as a side effect
     *            of value propagation)
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #propagate(Project, Configuration, ProgressObserver)} instead
     */
    @Deprecated
    public ReasoningResult propagate(Project project, Configuration cfg) {
        return propagate(project, cfg, ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project. (may be modified as a side effect
     *            of value propagation)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     * @deprecated use {@link #propagate(Project, Configuration, ReasonerConfiguration, ProgressObserver)}
     */
    @Deprecated
    public ReasoningResult propagate(Project project, Configuration cfg, ProgressObserver observer) {
        return propagate(project, cfg, null, observer);
    }

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project. (may be modified as a side effect
     *            of value propagation)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return The result of this reasoning step. Can have the status
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer) {
        ReasoningResult result = null;
        IReasoner reasoner = getActualReasoner(project, cfg, null, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.propagate(project, cfg, reasonerConfiguration, observer);
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
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param constraints
     *            the constraints (expressions which must evaluate to <code>true</code>)
     * @return The result of this reasoning step. The result pairs may be given in a different order than in
     *         <code>constraints</code>. <b>null</b> constraints are ignored and not returned as a result. Can have the
     *         status {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not
     *         support this operation.
     * @deprecated use {@link #evaluate(Project, Configuration, List, ProgressObserver)} instead
     */
    @Deprecated
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints) {
        return evaluate(project, cfg, constraints, ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param constraints
     *            the constraints (expressions which must evaluate to <code>true</code>)
     * @param observer a progress observer indicating the progress, use {@link ProgressObserver#NO_OBSERVER} if no
     *        progress shall be indicated           
     * @return The result of this reasoning step. The result pairs may be given in a different order than in
     *         <code>constraints</code>. <b>null</b> constraints are ignored and not returned as a result. Can have the
     *         status {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not
     *         support this operation.
     * @deprecated use {@link #evaluate(Project, Configuration, List, ReasonerConfiguration, ProgressObserver)}
     */
    @Deprecated
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints, 
        ProgressObserver observer) {
        return evaluate(project, cfg, constraints, null, observer);
    }
    
    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
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
     *         status {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not
     *         support this operation.
     */
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints, 
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
        IReasoner reasoner = getActualReasoner(project, cfg, toEvaluate, reasonerConfiguration);
        if (null != reasoner) {
            result = reasoner.evaluate(project, cfg, toEvaluate, reasonerConfiguration, observer);
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
     *     {@link de.uni_hildesheim.sse.utils.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
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
     * automated selection of reasoners, this class may ignore the specified information.
     * 
     * @param descriptor
     *            the descriptor denoting the reasoner
     * @throws IllegalArgumentException
     *             in case of illegal arguments
     */
    public void setReasonerHint(ReasonerDescriptor descriptor) {
        reasonerHint = findReasoner(descriptor);
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
    private IReasoner findReasoner(ReasonerDescriptor descriptor) {
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
     * @return <tt>true</tt> if at least one reasoner is present and reasoning can be done, otherwise <tt>false</tt>
     */
    public boolean reasoningSupported() {
        return getReadyForUseCount() > 0;
    }
    
    /**
     * Changes the global timeout for reasoning.
     * 
     * @param timeout the global timeout, shall be ignored if less negative or null
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Returns the global timeout for reasoning.
     * 
     * @return the global timeout, shall be ignored if less negative or null
     */
    public int getTimeout() {
        return timeout;
    }    
}
