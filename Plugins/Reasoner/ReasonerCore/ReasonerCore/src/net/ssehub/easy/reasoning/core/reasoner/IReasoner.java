package net.ssehub.easy.reasoning.core.reasoner;

import java.net.URI;
import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.Project;

/**
 * General interface for reasoner, which can be registered to the <tt>ReasonerRegistry</tt>. Please note that 
 * reasoner calls are intended to be state-less. Currently, management over successive reasoner calls on the same model
 * is out of scope.
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
     * @param project
     *            The project which should be tested whether it is satisfiable.
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
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project.
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult check(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
         ProgressObserver observer);

    /**
     * Checks the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project (may be modified as a side effect
     *            of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult propagate(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration, 
        ProgressObserver observer);

    /**
     * Initializes the configuration according to the given model and propagates values, if possible.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            The current configuration based on the given project (may be modified as a side effect
     *            of value propagation)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)                   
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public ReasoningResult initialize(Project project, Configuration cfg, ReasonerConfiguration reasonerConfiguration,
        ProgressObserver observer);

    /**
     * Evaluates a given list of constraints (in the sense of boolean conditions) which are related to and valid in the
     * context of the given project and configuration.
     * 
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param constraints
     *            the constraints (expressions which evaluate to a boolean value)
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @param observer an optional progress observer, shall be {@link ProgressObserver#NO_OBSERVER} if unused
     * @return The result of this reasoning step. Can have the status
     *     {@link net.ssehub.easy.basics.messages.Status#UNSUPPORTED} if the concrete reasoner does not support
     *     this operation.
     */
    public EvaluationResult evaluate(Project project, Configuration cfg, List<Constraint> constraints, 
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
     * @param project
     *            The project which serves as basis for the related configuration.
     * @param cfg
     *            the configuration as a basis for the evaluation
     * @param reasonerConfiguration the reasoner configuration to be used for reasoning (e.g. taken from the UI, 
     *        may be <b>null</b>)
     * @return a reusable reasoner instance, return a {@link DelegatingReasonerInstance} on this reasoner to
     *     avoid null pointer checking.
     */
    public IReasonerInstance createInstance(Project project, Configuration cfg, 
        ReasonerConfiguration reasonerConfiguration);

}
