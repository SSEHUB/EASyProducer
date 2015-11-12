package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver;
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

    /**
     * Singleton.
     */
    private RtVilModel() {
    }

    @Override
    protected ImportResolver<Script> createResolver() {
        return new DefaultImportResolver<Script>();
    }

}
