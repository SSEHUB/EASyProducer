package de.uni_hildesheim.sse.model.confModel;

/**
 * Marks visitable elements of a configuration.
 * 
 * @author Holger Eichelberger
 */
public interface IConfigurationVisitable {

    /**
     * Accepts and calls the given visitor.
     * 
     * @param visitor the visitor
     */
    public void accept(IConfigurationVisitor visitor);

}
