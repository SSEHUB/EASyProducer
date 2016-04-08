package net.ssehub.easy.reasoning.drools2.model.datatypes;

import java.util.List;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;


/**
 * Representation of all constraints inside a compound.
 * @author Roman Sizonenko
 *
 */
public class CompoundType extends ReasonerDatatype {
        
    /**
     * List of constraints, which are defined inside the {@link Compound} and should be considered for all
     * instances of the compound.
     */
    private List<ConstraintSyntaxTree> compoundConstraints;
    
    /**
     * List of constraints, which are defined inside the {@link Compound} and should be considered for all
     * instances of the compound.
     */
    private List<Constraint> constraints;
    
    /**
     * Constructor for initializing.
     * @param compound The {@link Compound} datatype which is wrapped into this {@link ReasonerDatatype}.
     */
    public CompoundType(Compound compound) {
        super(compound);
        CompoundConstraintFinder finder = new CompoundConstraintFinder(compound);
        compoundConstraints = finder.getConstraints();     
        constraints = finder.getConstraintList();
    }
    
    /**
     * Getter for returning {@link Compound}.
     * @return Returns the {@link Compound} which holds the constraints.
     */
    @Override
    public Compound getType() {
        return (Compound) super.getType();
    }
    
    /**
     * Getter for returning all constraints of {@link Compound}.
     * @return A list of all constraints in the specified {@link Compound}.
     */
    public List<ConstraintSyntaxTree> getCompoundConstraints() {
        return compoundConstraints;
    }
    
    /**
     * Returns the number of constraints inside the related compound.
     * @return the number of stored constraints (should be greater or equal to 0).
     */
    public int getConstraintCount() {
        return compoundConstraints.size();
    }

    /**
     * Returns the {@link ConstraintSyntaxTree} at the specified position in this object.
     *
     * @param index A 0-based index of the element to return
     * @return the {@link ConstraintSyntaxTree} at the specified position in this object
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     * @see #getConstraintCount()
     */
    public ConstraintSyntaxTree getConstrain(int index) {
        return compoundConstraints.get(index);
    }
    
    /**
     * Returns constraint that failed.
     * @param index of {@link Constraint}.
     * @return {@link ModelElement} constraint that holds {@link ConstraintSyntaxTree}.
     */
    public ModelElement getConflictingConstrain(int index) {
        return constraints.get(index);
    }
    
    /**
     * Returns whether the given {@link Compound} has constraints.
     * @return <tt>true</tt> if at least one constraint was defined inside the compound, <tt>false</tt> otherwise.
     */
    @Override
    public boolean hasConstraints() {
        return !compoundConstraints.isEmpty();
    }
    
    /**
     * Add method for adding {@link ConstraintSyntaxTree} of a the {@link Compound} related to this object.
     * @param constraint {@link ConstraintSyntaxTree}.
     */
    void addCompoundConstraint(ConstraintSyntaxTree constraint) {
        this.compoundConstraints.add(constraint);
    }
    
    @Override
    public void accept(IReasonerTypeVisitor visitor) {
        visitor.visitCompoundType(this);
    }
}
