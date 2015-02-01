package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;

/**
 * Provides mechanisms for loading, linking, referring, searching and storing adaptation language models
 * according to their name, their version and their location. The name was chosen according
 * to the established naming in the variability model implementation.
 * 
 * @author Holger Eichelberger
 */
public class RtVilModel extends ModelManagement<Script> {

    /**
     * Stores the singleton instance.
     */
    public static final RtVilModel INSTANCE = new RtVilModel();

    private static ImportResolver<Script> resolver = new DefaultImportResolver();
    
    /**
     * Singleton.
     */
    private RtVilModel() {
    }

    /**
     * Defines the new top-level resolver.
     * 
     * @param newResolver the new top-level resolver
     */
    public static void setResolver(ImportResolver<Script> newResolver) {
        if (null != newResolver) {
            resolver = newResolver;
        }
    }
    
    /**
     * Returns the top-level resolver.
     * 
     * @return the top-level resolver
     */
    public static ImportResolver<Script> getResolver() {
        return resolver;
    }
    
    @Override
    protected ImportResolver<Script> getTopLevelResolver() {
        return resolver;
    }

}
