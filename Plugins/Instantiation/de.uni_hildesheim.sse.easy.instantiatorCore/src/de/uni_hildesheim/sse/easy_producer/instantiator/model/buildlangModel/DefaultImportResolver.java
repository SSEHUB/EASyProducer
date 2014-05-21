package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;

/**
 * The default resolver for build language scripts. Don't store information in attributes!
 * 
 * @author Holger Eichelberger
 */
public class DefaultImportResolver extends de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver<Script> {

    @Override
    protected ImportResolver<Script> getTopResolver() {
        return BuildModel.getResolver();
    }

    @Override
    protected void setTopResolver(ImportResolver<Script> resolver) {
        BuildModel.setResolver(resolver);
    }

}
