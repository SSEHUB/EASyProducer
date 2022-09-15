package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.DefaultImportResolver;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.ModelRepository;
import net.ssehub.easy.varModel.management.VarModel;

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
    
    /**
     * Refined model repository for IVML.
     * 
     * @author Holger Eichelberger
     */
    private static class RtVilModelRepository extends ModelRepository<Script> {

        /**
         * Creates a model repository.
         * 
         * @param modelMgmt the model management instance to delegate to
         */
        protected RtVilModelRepository(ModelManagement<Script> modelMgmt) {
            super(modelMgmt);
        }
        
        @Override
        public Script createModel(String modelName, List<Script> imports) {
            Script result = new Script(modelName);
            for (Script p : imports) {
                try {
                    ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script> imp 
                        = new ModelImport<net.ssehub.easy.instantiation.core.model.buildlangModel.Script>(
                            p.getName(), false, null, false);
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
        return new RtVilModelRepository(this);
    }

    @Override
    protected ImportResolver<Script> createResolver() {
        return new DefaultImportResolver<Script>();
    }

}
