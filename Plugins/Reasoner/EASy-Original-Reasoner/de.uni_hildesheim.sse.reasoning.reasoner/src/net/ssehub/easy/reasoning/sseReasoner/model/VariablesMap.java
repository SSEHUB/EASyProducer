package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;

/**
 * A holder for a map reflecting all variable and constraint relationship.
 * @author sizonenko
 *
 */
public class VariablesMap {
    
    private Map<AbstractVariable, Set<Constraint>> declConstraintMapping;

    /**
     * Sole constructor initializing the map.
     */
    public VariablesMap() {
        declConstraintMapping = new HashMap<AbstractVariable, Set<Constraint>>();
    }
    
    /**
     * Method for adding a relationship between variable and constraint.
     * @param declaration {@link AbstractVariable} to be added.
     * @param constraint {@link Constraint} that holds added {@link AbstractVariable}.
     */
    public void add(AbstractVariable declaration, Constraint constraint) {
        Set<Constraint> relevantConstraints = declConstraintMapping.get(declaration);
        if (null == relevantConstraints) {
            relevantConstraints = new HashSet<Constraint>();
            declConstraintMapping.put(declaration, relevantConstraints);
        }
        relevantConstraints.add(constraint); 
    }
    
    /**
     * Returns all constraints, where the specifies <tt>declaration</tt> was used inside.
     * @param declaration A declaration for which all constaints using this declaration should be returned.
     *   Must not be <tt>null</tt>.
     * @return The list of all constraints where the declaration was used, maybe <tt>null</tt> if it was never used.
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
    }
    
}
