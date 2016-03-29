package net.ssehub.easy.sseReasoner.functions;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Class contains variables that were assigned in a specific scope..
 * @author Sizonenko
 */
public class ScopeAssignments {
    
    private Set<IDecisionVariable> scopeAssignments; 
    
    /**
     * Sole constructor.
     */
    public ScopeAssignments() {
        scopeAssignments = new HashSet<IDecisionVariable>();
    }
    /**
     * Method for registering a variable that was assigned.
     * @param variable Assigned variable.
     */
    public void addAssignedVariable(IDecisionVariable variable) {
        if (variable.getState() == AssignmentState.DERIVED) {
            scopeAssignments.add(variable);            
        }
    }
    
    /**
     * Method for determining if variable was assigned in the specific scope.
     * @param variable Variable under question.
     * @return True if variable already was assigned in this scope.
     */
    public boolean wasAssignedInThisScope(IDecisionVariable variable) {
        boolean result = false;
        result = scopeAssignments.contains(variable);
        return result;
    }
    
    /**
     * Method for clearing all scope assignments.
     */
    public void clearScopeAssignments() {
        scopeAssignments.clear();
    }

}
