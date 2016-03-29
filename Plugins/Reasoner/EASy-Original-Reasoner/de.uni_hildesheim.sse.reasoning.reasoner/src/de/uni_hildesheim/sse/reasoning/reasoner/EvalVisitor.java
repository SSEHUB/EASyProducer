package de.uni_hildesheim.sse.reasoning.reasoner;

import de.uni_hildesheim.sse.reasoning.reasoner.functions.ScopeAssignments;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.CompoundVariable;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfiguration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.cstEvaluation.IValueChangeListener;

/**
 * This class shall extend {@link EvaluationVisitor} for using it in the Reasoning plugin.
 * @author Sizonenko
 *
 */
public class EvalVisitor extends EvaluationVisitor {    
    
    private ScopeAssignments scopeAssignments;
    
    /**
     * Creates an evaluation visitor.
     */
    public EvalVisitor() {        
    }
    
    /**
     * Constructor for initializing superclass.
     * @param config the configuration to take already evaluated values from
     * @param assignmentState the state for the assignments (may be null if no assignment shall take place)
     * @param assignmentsOnly if true process only assignments, else process all constraints
     * @param listener listener a listener to notify some external mechanism about a changed variable
     */
    public EvalVisitor(IConfiguration config, IAssignmentState assignmentState, boolean assignmentsOnly, 
        IValueChangeListener listener) {
        super(config, assignmentState, assignmentsOnly, listener);
    }
    
    /**
     * Method for setting ScopeAssignments register to check if variable was already assigned in this scope.
     * @param scopeAssignments register.
     */
    public void setScopeAssignmnets(ScopeAssignments scopeAssignments) {
        this.scopeAssignments = scopeAssignments;
    }
    
    @Override
    protected IAssignmentState getTargetState(IDecisionVariable var) {
        IAssignmentState returnState = null;   
        if (var instanceof CompoundVariable) {
            CompoundVariable cmp = (CompoundVariable) var;
            returnState = assignmentState;
            for (int i = 0; i < cmp.getNestedElementsCount(); i++) {
                if (!isAssignable(cmp.getNestedElement(i), var)) {
                    returnState = null;
                    break;
                }
            }
        } else {
            if (isAssignable(var, null)) {
                returnState = assignmentState;
            }            
        }
        return returnState;
    }
    
    /**
     * Method for determining if variable is valid for value assignment.
     * @param var Variable to be checked.
     * @param compound Parent compound (might be null).
     * @return true if assignment is valid.
     */
    private boolean isAssignable(IDecisionVariable var, IDecisionVariable compound) {
        boolean isAssignable = false;
        IAssignmentState state = var.getState();
        if ((state == AssignmentState.UNDEFINED
            || state == AssignmentState.DEFAULT
            || !wasAssignedInThisScope(var, compound))
//            || !ScopeAssignments.wasAssignedInThisScope(var))
            && state != AssignmentState.FROZEN) {
            isAssignable = true;
        }   
        return isAssignable;        
    }
    
    /**
     * Method for determining if variable was already aasigned in this scope.
     * @param var Variable to be checked.
     * @param compound Parent compound (might be null).
     * @return true if assignment is valid.
     */
    private boolean wasAssignedInThisScope(IDecisionVariable var, IDecisionVariable compound) {
        boolean wasAssigned = false;
        if (compound == null) {
            wasAssigned = scopeAssignments.wasAssignedInThisScope(var);
        } else {
            wasAssigned =
                scopeAssignments.wasAssignedInThisScope(var) && scopeAssignments.wasAssignedInThisScope(compound);
        }
        return wasAssigned;        
    }
    
}
