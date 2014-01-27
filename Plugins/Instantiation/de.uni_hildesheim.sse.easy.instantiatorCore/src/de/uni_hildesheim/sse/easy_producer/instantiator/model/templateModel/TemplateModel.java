package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;

/**
 * Provides mechanisms for loading, linking, referring, searching and storing template models
 * according to their name, their version and their location. The name was chosen according
 * to the established naming in the variability model implementation.
 * 
 * @author Holger Eichelberger
 */
public class TemplateModel extends ModelManagement<Template> {

    /**
     * Stores the singleton instance.
     */
    public static final TemplateModel INSTANCE = new TemplateModel();

    private static ImportResolver<Template> resolver = new DefaultImportResolver();

    /**
     * Singleton.
     */
    private TemplateModel() {
    }
    
    /**
     * Defines the new top-level resolver.
     * 
     * @param newResolver the new top-level resolver
     */
    public static void setResolver(ImportResolver<Template> newResolver) {
        if (null != newResolver) {
            resolver = newResolver;
        }
    }
    
    /**
     * Returns the top-level resolver.
     * 
     * @return the top-level resolver
     */
    public static ImportResolver<Template> getResolver() {
        return resolver;
    }

    
    @Override
    protected ImportResolver<Template> getTopLevelResolver() {
        return resolver;
    }

}
