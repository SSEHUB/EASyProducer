package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * The top-level interface for the build language specific model elements.
 * 
 * @author Holger Eichelberger
 */
public interface IBuildlangElement {
    
    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException;

}
