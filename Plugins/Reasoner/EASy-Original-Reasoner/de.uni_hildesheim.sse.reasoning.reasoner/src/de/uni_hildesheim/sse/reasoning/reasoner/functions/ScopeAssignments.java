package de.uni_hildesheim.sse.reasoning.reasoner.functions;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * Class contains variables that were assigned in a specific scope..
 * @author Sizonenko
 */
public class ScopeAssignments {
    
    private static final Set<IDecisionVariable> SCOPE_ASSIGNMENTS = new HashSet<IDecisionVariable>(); 
    
    /**
     * Method for registering a variable that was assigned.
     * @param variable Assigned variable.
     */
    public static void addAssignedVariable(IDecisionVariable variable) {
        if (variable.getState() == AssignmentState.DERIVED) {
            SCOPE_ASSIGNMENTS.add(variable);            
        }
    }
    
    /**
     * Method for determining if variable was assigned in the specific scope.
     * @param variable Variable under question.
     * @return True if variable already was assigned in this scope.
     */
    public static boolean wasAssignedInThisScope(IDecisionVariable variable) {
        boolean result = false;
        result = SCOPE_ASSIGNMENTS.contains(variable);
        return result;
    }
    
    /**
     * Method for clearing all scope assignments.
     */
    public static void clearScopeAssignments() {
        SCOPE_ASSIGNMENTS.clear();
    }

}
