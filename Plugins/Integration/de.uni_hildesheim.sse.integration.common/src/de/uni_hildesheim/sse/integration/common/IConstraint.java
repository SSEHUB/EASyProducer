package de.uni_hildesheim.sse.integration.common;

/**
 * Represents a constraint. As a constraint is read-only (created
 * by {@link IModel#createConstraint(String)}) no further
 * getters are provided.
 * 
 * @author Holger Eichelberger
 */
public interface IConstraint extends IModelElement {

    /**
     * Returns the name of the constraint.
     * 
     * @return the name, empty in case of unnamed constraints
     */
    public String getName();
    
    /**
     * Returns the textual representation of this constraint.
     * 
     * @return the textual representation in IVML syntax
     */
    public String toString();

}
