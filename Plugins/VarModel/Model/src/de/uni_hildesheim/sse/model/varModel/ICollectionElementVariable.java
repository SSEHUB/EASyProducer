package de.uni_hildesheim.sse.model.varModel;

/**
 * Represents a (temporary) element of a collection as collection (by design decision) do
 * no have real contained variables.
 * 
 * @author Holger Eichelberger
 */
public interface ICollectionElementVariable {

    /**
     * The index of the element in the collection, i.e., the nested element.
     * 
     * @return the index
     */
    public int getIndex();
    
    /**
     * The base variable representing the collection.
     * 
     * @return the collection base variable
     */
    public AbstractVariable getBaseVariable();
    
}
