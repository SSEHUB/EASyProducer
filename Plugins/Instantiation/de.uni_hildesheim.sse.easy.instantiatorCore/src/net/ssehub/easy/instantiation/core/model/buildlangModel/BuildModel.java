package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.ModelRepository;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.varModel.management.VarModel;

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
    
    /**
     * Refined model repository for IVML.
     * 
     * @author Holger Eichelberger
     */
    private static class VilModelRepository extends ModelRepository<Script> {

        /**
         * Creates a model repository.
         * 
         * @param modelMgmt the model management instance to delegate to
         */
        protected VilModelRepository(ModelManagement<Script> modelMgmt) {
            super(modelMgmt);
        }
        
        @Override
        public Script createModel(String modelName, List<Script> imports) {
            Script result = new Script(modelName);
            for (Script p : imports) {
                try {
                    ModelImport<Script> imp = new ModelImport<Script>(p.getName(), false, null, false);
                    imp.setResolved(p);
                    result.addImport(imp);
                } catch (ModelManagementException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(VarModel.class, Bundle.ID).error(
                        "While creating ad-hoc model " + modelName + ": " + e.getMessage());
                }
            }
            return result;
        }
        
    }

    @Override
    protected ModelRepository<Script> createRepository() {
        return new VilModelRepository(this);
    }

    @Override
    protected ImportResolver<Script> createResolver() {
        return new BuildLangImportResolver();
    }

}
