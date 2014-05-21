package de.uni_hildesheim.sse.reasoning.core.model;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;

/**
 * A factory for determining constraint type.
 * @author Sizonenko
 *
 */
public class ConstraintPatternFactory {

    private static ConstraintPattern cstType;
    
    /**
     * Method for analyzing constraint pattern and selecting an appropriate type.
     * @param cst Constraint to be analyzed.
     * @return Type of the analyzed constraint.
     */
    public static ConstraintPattern getConstraintPattern(ConstraintSyntaxTree cst) {        
        ConstraintPatternFinder patternFinder = new ConstraintPatternFinder(cst);
        if (!patternFinder.isValueAssignmentConstraint() && !patternFinder.isImpliesConstraint()) {
            cstType = ConstraintPattern.SIMPLE_VALIDATION;
        }
        if (patternFinder.isValueAssignmentConstraint() && !patternFinder.isImpliesConstraint()) {
            cstType = ConstraintPattern.SIMPLE_ASSIGNMENT;
        }
        if (!patternFinder.isValueAssignmentConstraint() && patternFinder.isImpliesConstraint()) {
            cstType = ConstraintPattern.IMPLIES_VALIDATION;
        }
        if (patternFinder.isValueAssignmentConstraint() && patternFinder.isImpliesConstraint()) {
            cstType = ConstraintPattern.IMPLIES_ASSIGNMENT;
        }
        return cstType;
    }
    
    /**
     * Method for identifying default assignment constraints.
     * @param cst Constraint to be analyzed.
     * @return true if constraint is a default value assignment constraint.
     */
    public static boolean isDefaultAssignmentConstraint(ConstraintSyntaxTree cst) {
        DefaultAssignmentPatternFinder patternFinder = new DefaultAssignmentPatternFinder(cst);
        return patternFinder.isDefaultAssignmentConstraint();
    }
}
