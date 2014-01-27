package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;

/**
 * The default resolver for template language scripts. Don't store information in attributes!
 * 
 * @author Holger Eichelberger
 */
public class DefaultImportResolver extends de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver<Template> {

    @Override
    protected ImportResolver<Template> getTopResolver() {
        return TemplateModel.getResolver();
    }

    @Override
    protected void setTopResolver(ImportResolver<Template> resolver) {
        TemplateModel.setResolver(resolver);
    }
    
}
