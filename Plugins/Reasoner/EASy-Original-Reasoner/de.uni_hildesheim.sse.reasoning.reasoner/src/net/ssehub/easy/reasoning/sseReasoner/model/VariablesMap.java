package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.reasoning.core.reasoner.ConstraintList;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;

/**
 * Represents all variable and constraint relationships. This class consists of two three mappings:
 * 
 * <ol>
 *   <li>All variable declarations used in constraints ({@link #declConstraintMapping}).</li>
 *   <li>Constraint - decision variable relations
 *       <ol>
 *           <li>Constraint assigned to a constraint decision variable {{@link constraintVariableMap}}</li>
 *           <li>decision variables assigned to constraints, multiple in case of collections 
 *               ({@link #variableConstraintsMap}}</li>
 *       </ol>
 *   </li>
 * </ol>
 * 
 * Both kinds of relationships are maintained independently, whereby both constraint-decision variable relations 
 * are managed together to ensure consistency.
 * 
 * @author sizonenko
 * @author Holger Eichelberger 
 */
public class VariablesMap {
    
    private Map<AbstractVariable, Set<Constraint>> declConstraintMapping;
    private Map<Constraint, IDecisionVariable> constraintVariableMap = new HashMap<Constraint, IDecisionVariable>();
    private Map<IDecisionVariable, List<Constraint>> variableConstraintsMap 
        = new HashMap<IDecisionVariable, List<Constraint>>();

    /**
     * Sole constructor initializing the map.
     */
    public VariablesMap() {
        declConstraintMapping = new HashMap<AbstractVariable, Set<Constraint>>();
    }
    
    /**
     * Adds a relationship between variable and constraint.
     * 
     * @param declaration {@link AbstractVariable} to be added.
     * @param constraint {@link Constraint} that holds added {@code declaration}.
     */
    public void add(AbstractVariable declaration, Constraint constraint) {
        obtainConstraintSet(declaration).add(constraint); 
    }

    /**
     * Removes a relationship between variable and constraint.
     * 
     * @param declaration {@link AbstractVariable} to be removed.
     * @param constraint {@link Constraint} that holds added {@code declaration}.
     */
    public void remove(AbstractVariable declaration, Constraint constraint) {
        Set<Constraint> relevantConstraints = declConstraintMapping.get(declaration);
        if (relevantConstraints != null) {
            relevantConstraints.remove(constraint);
        }
    }
    
    /**
     * Returns the constraint set for <code>declaration</code>.
     * 
     * @param declaration the declaration
     * @return the constraint set (may be <b>null</b> for none)
     */
    private Set<Constraint> obtainConstraintSet(AbstractVariable declaration) {
        Set<Constraint> relevantConstraints = declConstraintMapping.get(declaration);
        if (null == relevantConstraints) {
            relevantConstraints = new HashSet<Constraint>();
            declConstraintMapping.put(declaration, relevantConstraints);
        }
        return relevantConstraints;
    }
    
    /**
     * Returns all constraints, where the specifies {@code declaration} was used inside.
     * @param declaration A declaration for which all constraints using this declaration should be returned.
     *   Must not be <b>null</b>.
     * @return The list of all constraints where the declaration was used, maybe <b>null</b> if it was never used.
     */
    public Set<Constraint> getRelevantConstraints(AbstractVariable declaration) {
        return declConstraintMapping.get(declaration);
    }

    /**
     * Number of all variables found in constraints (should be replacesd by other method detecting nuber of
     *  variables in the model).
     * @return Number of variables found in constaints.
     */
    public int getDeclarationSize() {
        return declConstraintMapping.size();
    }
    
    /**
     * Clears this instance for reuse.
     */
    public void clear() {
        declConstraintMapping.clear();
        variableConstraintsMap.clear();
        constraintVariableMap.clear();
    }

    /**
     * Relates all <code>constraints</code> to the declaration of <code>variable</code> and the declarations of 
     * all parent variables of <code>variable</code>.
     * 
     * @param variable the variable to relate to
     * @param constraints the constraints to relate
     */
    public void addAll(IDecisionVariable variable, ConstraintList constraints) {
        IConfigurationElement iter = variable;
        while (iter != null) {
            if (iter instanceof IDecisionVariable) {
                addAll(((IDecisionVariable) iter).getDeclaration(), constraints);
            }
            iter = iter.getParent();
        }
    }
    
    /**
     * Relates all <code>constraints</code> to <code>declaration</code>.
     * 
     * @param declaration the declaration to relate to
     * @param constraints the constraints to relate
     */
    public void addAll(AbstractVariable declaration, ConstraintList constraints) {
        constraints.toCollection(obtainConstraintSet(declaration));
    }

    // transitive removal over all parents
    /**
     * Unrelates all <code>constraints</code> from the declaration of <code>variable</code> and all declarations of 
     * parent variables of <code>variable</code>.
     * 
     * @param variable the variable to relate to
     * @param constraints the constraints to unrelate
     */
    public void removeAll(IDecisionVariable variable, Collection<Constraint> constraints) {
        IConfigurationElement iter = variable;
        while (iter != null) {
            if (iter instanceof IDecisionVariable) {
                removeAll(((IDecisionVariable) iter).getDeclaration(), constraints);
            }
            iter = iter.getParent();
        }
        for (Constraint cst : constraints) {
            IDecisionVariable var = constraintVariableMap.remove(cst);
            if (null != var) {
                variableConstraintsMap.remove(var);
            }
        }
    }

    /**
     * Unrelates all <code>constraints</code> from <code>declaration</code>.
     * 
     * @param declaration the declaration to relate to
     * @param constraints the constraints to relate
     */
    public void removeAll(AbstractVariable declaration, Collection<Constraint> constraints) {
        Set<Constraint> relevantConstraints = declConstraintMapping.get(declaration);
        if (null != relevantConstraints) {
            relevantConstraints.removeAll(constraints);
        }
    }
    
    /**
     * Registers <code>constraint</code> with constraint variable <code>variable</code>.
     * 
     * @param variable the variable
     * @param constraint the constraint
     */
    public void registerConstraint(IDecisionVariable variable, Constraint constraint) {
        constraintVariableMap.put(constraint, variable);
        List<Constraint> constraints = variableConstraintsMap.get(variable);
        if (null == constraints) {
            constraints = new ArrayList<Constraint>();
            variableConstraintsMap.put(variable, constraints);
        }
        constraints.add(constraint);
    }
    
    // TODO can we somehow integrate both sides, e.g., register also the abstractvariable via the declaration of 
    // a decision variable?
    
    /**
     * Unregisters a constraint from a decision variable.
     * 
     * @param variable the variable
     * @param constraint the constraint
     */
    public void unregisterConstraint(IDecisionVariable variable, Constraint constraint) {
        List<Constraint> constraints = getConstraintsForVariable(variable);
        if (null != constraints) {
            constraints.remove(constraint);
        }
    }
    
    /**
     * Returns the constraints registered for <code>variable</code>.
     * 
     * @param variable the variable
     * @return the constraints (may be <b>null</b>)
     */
    public List<Constraint> getConstraintsForVariable(IConfigurationElement variable) {
        return variableConstraintsMap.get(variable);
    }
    
    /**
     * Returns the decision variable for <code>constraint</code>.
     * 
     * @param constraint the constraint to return the assigned decision variable for
     * @return the decision variable or <b>null</b> for none
     */
    public IDecisionVariable getDecisionVariableForConstraint(Constraint constraint) {
        return constraintVariableMap.get(constraint);
    }
    
    /**
     * Copies all registrations from <code>map</code>.
     * 
     * @param map the map to copy from
     */
    public void copyFrom(VariablesMap map) {
        constraintVariableMap.putAll(map.constraintVariableMap);
        for (Map.Entry<IDecisionVariable, List<Constraint>> ent : map.variableConstraintsMap.entrySet()) {
            List<Constraint> tmp = new ArrayList<Constraint>(ent.getValue());
            variableConstraintsMap.put(ent.getKey(), tmp);
        }
        for (Map.Entry<AbstractVariable, Set<Constraint>> ent : map.declConstraintMapping.entrySet()) {
            Set<Constraint> tmp = new HashSet<Constraint>(ent.getValue());
            map.declConstraintMapping.put(ent.getKey(), tmp);
        }
    }

}
