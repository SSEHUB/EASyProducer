package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Marks a language element of the VIL template language.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateLangElement extends ILanguageElement {

    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException;
    
}
