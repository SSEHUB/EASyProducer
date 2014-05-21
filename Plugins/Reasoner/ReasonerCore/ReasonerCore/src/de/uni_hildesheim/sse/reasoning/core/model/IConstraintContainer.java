package de.uni_hildesheim.sse.reasoning.core.model;

import java.util.Set;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;

/**
 * Part of the {@link ReasonerModel}, holding all used constraints.
 * @author El-Sharkawy
 *
 */
public interface IConstraintContainer {

    /**
     * Method to return the number of all normal constraints.
     * @return Number of constraints.
     */
    public int getNormalConstraintCount();
    
    /**
     * Method to return a specific normal constraint.
     * @param index Numeric index of the value assignment constraint.
     * @return Number of constraints.
     */
    public ConstraintSyntaxTree getNormalConstraint(int index);
    
    /**
     * Method to return the number of internal constraints.
     * @return Number of constraints.
     */
    public int getInternalConstraintCount();
    
    /**
     * Method to return a specific internal constraint.
     * @param index Numeric index of the normal constraint.
     * @return Normal constraint definition.
     */
    public ConstraintSyntaxTree getInternalConstraint(int index);
    
    /**
     * Getter for all constraints.
     * Returns first the normal constraints and afterwards the internal constraints.
     * @param index a 0 based index to specify which constraint shall be returned.
     * @return A stored {@link ConstraintSyntaxTree} specified by the given index.
     * @see #getConflictingElement(int)
     */
    public ConstraintSyntaxTree getConstraint(int index);
    
    /**
     * Returns the conflicting {@link ModelElement} ({@link de.uni_hildesheim.sse.model.varModel.Constraint}
     * or {@link de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype})for a conflicting constraint.
     * The specified index must be the same index as used to get the
     * {@link de.uni_hildesheim.sse.model.varModel.Constraint} 
     * via the {@link #getConstraint(int)} method.
     * @param index A 0 based index to specify which {@link ModelElement} shall be returned.
     * @return The {@link ModelElement} from where the {@link ConstraintSyntaxTree} came from
     */
    public ModelElement getConflictingElement(int index);    
    
    /**
     * Returns a set of (toplevel) {@link ReasonerVariable}s used in a normal constraint.
     * @param index A 0 based index to specify for which constraint the {@link ReasonerVariable}s should be retrieved.
     * @return A Set of used {@link ReasonerVariable}s (maybe empty, but not <tt>null</tt>).
     */
    public Set<ReasonerVariable> getVariablesOfNormalConstraint(int index);
    
    /**
     * Returns a set of (toplevel) {@link ReasonerVariable}s used in a internal constraint.
     * @param index A 0 based index to specify for which constraint the {@link ReasonerVariable}s should be retrieved.
     * @return A Set of used {@link ReasonerVariable}s (maybe empty, but not <tt>null</tt>).
     */
    public Set<ReasonerVariable> getVariablesOfInternalConstraint(int index);

    /**
     * Returns a set of (toplevel) {@link ReasonerVariable}s used in a constraint.
     * @param index A 0 based index to specify for which constraint the {@link ReasonerVariable}s should be retrieved.
     * @return A Set of used {@link ReasonerVariable}s (maybe empty, but not <tt>null</tt>).
     */
    public Set<ReasonerVariable> getVariablesOfConstraint(int index);

    /**
     * Method to return the number of all constraints.
     * @return Number of constraints.
     */
    public int getConstraintCount();
  
   
}
