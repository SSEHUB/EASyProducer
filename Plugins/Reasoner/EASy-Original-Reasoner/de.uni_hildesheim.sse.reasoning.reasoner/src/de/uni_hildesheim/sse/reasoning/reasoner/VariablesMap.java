package de.uni_hildesheim.sse.reasoning.reasoner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * A holder for a map reflecting all variable and constraint relationship.
 * @author sizonenko
 *
 */
class VariablesMap {
    
    private Map<AbstractVariable, Set<Constraint>> declConstraintMapping;
//    private Map<IDatatype, Set<Constraint>> typeConstraintMapping;


    /**
     * Sole constructor initializing the map.
     */
    VariablesMap() {
        declConstraintMapping = new HashMap<AbstractVariable, Set<Constraint>>();
    }
    
    /**
     * Method for adding a relationship between variable and constraint.
     * @param declaration {@link AbstractVariable} to be added.
     * @param constraint {@link Constraint} that holdes added {@link AbstractVariable}.
     */
    void add(AbstractVariable declaration, Constraint constraint) {
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
    Set<Constraint> getRelevantConstraints(AbstractVariable declaration) {
        return declConstraintMapping.get(declaration);
    }

    /**
     * Number of all variables found in constraints (should be replacesd by other method detecting nuber of
     *  variables in the model).
     * @return Number of variables found in constaints.
     */
    int getDeclarationSize() {
        // TODO get rid of this
        return declConstraintMapping.size();
    }
}
