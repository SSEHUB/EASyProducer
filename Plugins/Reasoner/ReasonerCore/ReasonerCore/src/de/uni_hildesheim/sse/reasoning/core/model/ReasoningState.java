package de.uni_hildesheim.sse.reasoning.core.model;


/**
 * Assignment states needed by the reasoner.
 * Some of the assignment states can be mapped 1:1 to the
 * {@link de.uni_hildesheim.sse.model.confModel.AssignmentState}s.
 * However another differentiation is needed by the reasoner.
 * For this purpose, the reasoner should use the {@link ReasoningState}s instead of the
 * {@link de.uni_hildesheim.sse.model.confModel.AssignmentState}s.
 * @author El-Sharkawy
 *
 */
public enum ReasoningState {

    /**
     * The variable is unassigned.
     * Same meaning as {@link de.uni_hildesheim.sse.model.confModel.AssignmentState#UNDEFINED}.
     */
    UNASSIGNED,
    /**
     * The value of the variable is a <b>assigned</b> in the <b>same scope</b>.     
     */
    DEFAULT_SAME,
    /**
     * The value of the variable is a <b>assigned</b> in the <b>different (higher) scope</b>.     
     */
    DEFAULT_DIFFERENT,
    
    /**
     * The variables is frozen and cannot be changed anymore.
     * Same meaning as {@link de.uni_hildesheim.sse.model.confModel.AssignmentState#FROZEN}.
     */
    FIXED,
    
    /**
     * Temporary state while reasoning: A new value was set during the current reasoning
     * process.
     */
    DERIVED,
    
    /**
     * Temporary state while reasoning: The reasoner detected a conflict, e.g. two different
     * value propagations should be performed.
     */
    CONFLICT;
}
