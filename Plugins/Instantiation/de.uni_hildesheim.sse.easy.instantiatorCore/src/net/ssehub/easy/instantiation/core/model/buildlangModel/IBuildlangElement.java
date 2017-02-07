package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * The top-level interface for the build language specific model elements.
 * 
 * @author Holger Eichelberger
 */
public interface IBuildlangElement extends ILanguageElement {
    
    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException;
    
}
