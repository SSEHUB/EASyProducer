package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;

/**
 * Provides mechanisms for loading, linking, referring, searching and storing build models
 * according to their name, their version and their location. The name was chosen according
 * to the established naming in the variability model implementation.
 * 
 * @author Holger Eichelberger
 */
public class BuildModel extends ModelManagement<Script> {

    /**
     * Stores the singleton instance.
     */
    public static final BuildModel INSTANCE = new BuildModel();

    private static ImportResolver<Script> resolver = new DefaultImportResolver();
    
    /**
     * Singleton.
     */
    private BuildModel() {
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
