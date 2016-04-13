package net.ssehub.easy.varModel.confModel;

import net.ssehub.easy.varModel.model.AbstractVariable;

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
    
    /**
     * Resolves the element variable to a decision variable.
     * 
     * @param config the configuration to resolve on
     * @return the resolved decision variable (may be <b>null</b> if not resolvable)
     */
    public IDecisionVariable resolve(IConfiguration config);
    
}
