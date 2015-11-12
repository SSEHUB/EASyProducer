package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.utils.modelManagement.AbstractImportResolverPoolManager;
import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.DefaultImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;

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

    /**
     * Singleton.
     */
    private BuildModel() {
    }

    @Override
    protected IPoolManager<ImportResolver<Script>> createResolverPoolManager() {
        return new AbstractImportResolverPoolManager<Script>() {

            @Override
            public ImportResolver<Script> create() {
                return new DefaultImportResolver<Script>();
            }

        };
    }

}
