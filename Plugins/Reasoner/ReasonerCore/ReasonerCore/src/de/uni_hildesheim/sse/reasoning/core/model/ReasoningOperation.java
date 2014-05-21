package de.uni_hildesheim.sse.reasoning.core.model;

/**
 * Specifies which kind of reasoning should be performed by the reasoner.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public enum ReasoningOperation {
    
    /**
     * Checks whether the {@link de.uni_hildesheim.sse.model.varModel.Project} is satisfiable.
     */
    CONSITENCY_CHECK,
    
    /**
     * Checks whether the {@link de.uni_hildesheim.sse.model.confModel.Configuration} is valid, i.e.
     * all constraints are satisfied.
     */
    VALIDATION,
    
    /**
     * Performs as {@link #VALIDATION} and propagates values (only for variables
     * which are in state {@link ReasoningState#UNASSIGNED} or {@link ReasoningState#DEFAULT_DIFFERENT}.
     */
    PROPAGATION;

}
