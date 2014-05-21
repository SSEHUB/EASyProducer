package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Defines an element which can be visited by the {@link IDatatypeVisitor}.
 * 
 * @author Holger Eichelberger
 */
public interface IDatatypeVisitable {

    /**
     * Accepts a specialized visitor for creating a textual representation
     * of the identity of this type.
     *  
     * @param visitor the visitor to accept
     */
    public void accept(IDatatypeVisitor visitor);

}
