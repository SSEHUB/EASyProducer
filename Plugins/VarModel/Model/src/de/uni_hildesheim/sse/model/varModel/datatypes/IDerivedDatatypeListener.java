package de.uni_hildesheim.sse.model.varModel.datatypes;


/**
 * Interface for <tt>DecisionVariableDeclaration</tt>s of {@link DerivedDatatype} to get informed
 * whenever the constraints of the related {@link DerivedDatatype} changes.
 * @author El-Sharkawy
 *
 */
public interface IDerivedDatatypeListener {
    
    /**
     * Causes the <tt>DecisionVariableDeclaration</tt> to generate new internal constraints based
     * on the new constraints stored inside the {@link DerivedDatatype} . 
     */
    public void constraintsChanged();

}
