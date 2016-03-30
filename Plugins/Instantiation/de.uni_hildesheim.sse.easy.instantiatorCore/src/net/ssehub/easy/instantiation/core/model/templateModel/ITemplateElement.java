package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Marks a language element which may occur in a (sub-)template.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateElement extends ITemplateLangElement {

    /**
     * Returns whether this element is a block (opposite is a single statement).
     * 
     * @return <code>true</code> if it is a block, <code>false</code> else
     */
    public boolean isBlock();
    
    /**
     * Infers the type of this language element.
     * 
     * @return the type of this language element
     * @throws VilException in case that type errors occur
     */
    public TypeDescriptor<?> inferType() throws VilException;
    
}
