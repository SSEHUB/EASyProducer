package net.ssehub.easy.instantiation.core.model.templateModel;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.DefaultImportResolver;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.ModelRepository;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.management.VarModel;

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

    /**
     * Singleton.
     */
    private TemplateModel() {
    }
    
    /**
     * Refined model repository for IVML.
     * 
     * @author Holger Eichelberger
     */
    private static class VtlModelRepository extends ModelRepository<Template> {

        /**
         * Creates a model repository.
         * 
         * @param modelMgmt the model management instance to delegate to
         */
        protected VtlModelRepository(ModelManagement<Template> modelMgmt) {
            super(modelMgmt);
        }
        
        @Override
        public Template createModel(String modelName, List<Template> imports) {
            Template result;
            TemplateDescriptor descriptor = new TemplateDescriptor();
            try {
                result = new Template(modelName, null, descriptor, TypeRegistry.DEFAULT);
                for (Template p : imports) {
                    try {
                        ModelImport<Template> imp = new ModelImport<Template>(p.getName(), false, null, false);
                        imp.setResolved(p);
                        result.addImport(imp);
                    } catch (ModelManagementException e) {
                        EASyLoggerFactory.INSTANCE.getLogger(VarModel.class, Bundle.ID).error(
                            "While creating ad-hoc model " + modelName + ": " + e.getMessage());
                    }
                }
            } catch (VilException e) {
                result = null;
                EASyLoggerFactory.INSTANCE.getLogger(VarModel.class, Bundle.ID).error(
                    "While creating ad-hoc model " + modelName + ": " + e.getMessage());
            }
            return result;
        }
        
    }

    @Override
    protected ModelRepository<Template> createRepository() {
        return new VtlModelRepository(this);
    }

    @Override
    protected ImportResolver<Template> createResolver() {
        return new DefaultImportResolver<Template>();
    }

}
