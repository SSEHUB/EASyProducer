package net.ssehub.easy.reasoning.sseReasoner.functions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;

/**
 * Class contains variables that were assigned in a specific scope..
 * @author Sizonenko
 */
public class ScopeAssignments {
    
    private Map<IModelElement, Set<IDecisionVariable>> scopeAssignments;
    private transient Set<IDecisionVariable> currentScopeSet;
    
    /**
     * Sole constructor.
     */
    public ScopeAssignments() {
        scopeAssignments = new HashMap<IModelElement, Set<IDecisionVariable>>();
    }
    
    /**
     * Method for registering a variable that was assigned.
     * Call {@link #setCurrentScope(IModelElement)} before.
     *
     * @param variable Assigned variable.
     */
    public void addAssignedVariable(IDecisionVariable variable) {
        currentScopeSet.add(variable);            
    }
    
    /**
     * Method for determining if variable was assigned in the specific scope.
     * Call {@link #setCurrentScope(IModelElement)} before.
     * 
     * @param variable Variable under question.
     * @return True if variable already was assigned in this scope.
     */
    public boolean wasAssignedInThisScope(IDecisionVariable variable) {
        return currentScopeSet.contains(variable);
    }

    /**
     * Clears all assignments.
     */
    public void clear() {
        scopeAssignments.clear();
    }
    
    /**
     * Clears all scope assignments for {@code scope}.
     * 
     * @param scope the scope to clear
     */
    public void clearScopeAssignments(Project scope) {
        // currently the scope is not used, we clear everything
        for (Set<IDecisionVariable> set : scopeAssignments.values()) {
            set.clear();
        }
    }

    /**
     * Defines the current scope due to the parents of the given {@code constraint}.
     * 
     * @param constraint defining the current scope
     */
    public void setCurrentScope(Constraint constraint) {
        // if we need to switch to narrower scopes, e.g., compounds, do it transparently here
        setCurrentScope(constraint.getTopLevelParent()); 
    }

    /**
     * Defines the current scope.
     * 
     * @param currentScope the current scope
     */
    public void setCurrentScope(IModelElement currentScope) {
        currentScopeSet = scopeAssignments.get(currentScope);
        if (null == currentScopeSet) {
            currentScopeSet = new HashSet<IDecisionVariable>();
            scopeAssignments.put(currentScope, currentScopeSet);
        }
    }

}
