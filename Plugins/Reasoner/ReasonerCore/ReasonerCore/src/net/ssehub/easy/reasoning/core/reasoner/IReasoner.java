package net.ssehub.easy.reasoning.core.reasoner;

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * General interface for reasoner, which can be registered to the <tt>ReasonerRegistry</tt>. Please note that 
 * reasoner calls are intended to be state-less. Currently, management over successive reasoner calls on the same model
 * is out of scope. A reasoner shall not produce superfluous output. Use the output methods in {@link ReasoningResult} 
 * instead.
 * 
 * @author Patrick Jähne
 * @author Sascha El-Sharkawy
 * @author Holger Eichelberger
 */
public interface IReasoner {

    /**
     * Returns a descriptor stating common information about this reasoner.
     * 
     * @return the descriptor
     */
    public ReasonerDescriptor getDescriptor();

    /**
     * Updates the installation of this reasoner, e.g., in order to obtain a licensed reasoner version.
     * 
     * @param url The location of the implementation of the reasoner which should be upgraded
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this upgrade process.
     */
    public ReasoningResult upgrade(URI url, ProgressObserver observer);

    /**
     * Checks whether a given variability model (project) is satisfiable.
     * 
     * @param project The project which should be tested whether it is satisfiable.
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult isConsistent(Project project, ReasonerConfiguration reasonerConfiguration, 
            ProgressObserver observer);

    /**
     * Checks the configuration according to the given project structure and does not affect the configuration.
     * 
     * @param cfg The current configuration to reason on.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult check(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
         ProgressObserver observer);

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param cfg The configuration to reason on (may be modified as a side effect
     *        of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult propagate(Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer);

    /**
     * Initializes the configuration according to the given model and propagates values, if possible. Reasoners 
     * implementing this function and ensure complete and proper (!) initialization of IVML models shall explicitly 
     * declare {@link GeneralReasonerCapabilities#INCREMENTAL_REASONING}. This method shell obey 
     * {@link Configuration#getResolutionState()}.
     * 
     * @param cfg The configuration to reason on (may be modified as a side effect
     *        of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult initialize(Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer);

    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * 
     * @param cfg the configuration as a basis for the evaluation
     * @param constraints the constraints (expressions which evaluate to a boolean value)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public EvaluationResult evaluate(Configuration cfg, List<Constraint> constraints, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer);

    /**
     * Is called when a reasoner message is issued.
     * 
     * @param message
     *            the message sent
     */
    public void notify(IReasonerMessage message);
    
    /**
     * Creates a reasoner instance for repeated reasoning on the same model (no structural changes allowed
     * during two subsequent reasoning runs).
     * 
     * @param cfg the configuration as a basis for the evaluation
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return a reusable reasoner instance, return a {@link DelegatingReasonerInstance} on this reasoner to
     *     avoid null pointer checking.
     */
    public IReasonerInstance createInstance(Configuration cfg, ReasonerConfiguration reasonerConfiguration);

    /**
     * Creates the value for a certain IVML type/variable.
     * 
     * @param cfg the configuration to operate on (will not be modified)
     * @param var the variable to create the value for (may be <b>null</b> if {@code type} is given, may imply 
     *     additional constraints)
     * @param type the type to create the value for (may be <b>null</b> if {@code var} is given)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return the value creation result
     */
    public ValueCreationResult createValue(Configuration cfg, AbstractVariable var, IDatatype type, 
        ReasonerConfiguration reasonerConfiguration, ProgressObserver observer);
    
    /**
     * Defines the optional interceptor instance.
     * 
     * @param interceptor the interceptor
     */
    public void setInterceptor(IReasonerInterceptor interceptor);
    
}
