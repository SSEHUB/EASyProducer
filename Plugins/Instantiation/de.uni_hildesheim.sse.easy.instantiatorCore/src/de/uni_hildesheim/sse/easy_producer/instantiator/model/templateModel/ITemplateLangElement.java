package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;

/**
 * Marks a language element of the VIL template language.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateLangElement {

    /**
     * Accepts the visitor for visiting.
     * 
     * @param visitor the visitor to be used
     * @return the result of visiting this instance (may be <b>null</b>)
     * @throws VilLanguageException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilLanguageException;

}
