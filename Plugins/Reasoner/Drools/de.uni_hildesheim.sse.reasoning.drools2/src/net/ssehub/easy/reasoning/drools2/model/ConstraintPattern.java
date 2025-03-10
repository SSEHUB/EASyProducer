package net.ssehub.easy.reasoning.drools2.model;

/**
 * Specifies which kind of constraint is it. Used for translation pattern selection.
 * @author Sizonenko
 *
 */
public enum ConstraintPattern {
    
    /**
     * a + 1 == 2; constraint.
     */
    SIMPLE_VALIDATION,
    
    /**
     * a = 1; constraint.
     */
    SIMPLE_ASSIGNMENT,
    
    /**
     * a > 1 implies b == 2; constraint.
     */
    IMPLIES_VALIDATION,
    
    /**
     * a > 1 implies b = 2; constraint.
     */
    IMPLIES_ASSIGNMENT;
}
