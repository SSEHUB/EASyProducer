package net.ssehub.easy.reasoning.core.model.datatypes;


/**
 * Defines a visitor interface for visitable {@link ReasonerDatatype}s.
 * @author El-Sharkawy
 *
 */
public interface IReasonerTypeVisitable {

    /**
     * Accepts a specialized visitor for creating a textual representation
     * of the identity of this type.
     *  
     * @param visitor the visitor to accept
     */
    public void accept(IReasonerTypeVisitor visitor);
}
