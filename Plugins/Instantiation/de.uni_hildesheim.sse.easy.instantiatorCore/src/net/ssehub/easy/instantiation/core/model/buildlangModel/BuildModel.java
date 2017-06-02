package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelManagement;

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
    protected ImportResolver<Script> createResolver() {
        return new BuildLangImportResolver();
    }

}
