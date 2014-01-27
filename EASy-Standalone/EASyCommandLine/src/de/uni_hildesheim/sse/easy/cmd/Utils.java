package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.net.URI;
import java.util.List;

import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelData;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Command line utility functions.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
class Utils {

    /**
     * The pseudo bundle identification for logging.
     */
    public static final String BUNDLE_ID = "EASyCommandLine";
    
    /**
     * Prevents external creation.
     */
    private Utils() {
    }

    /**
     * Loads a model with the specified (model name, version) pair from the given {@link ModelManagement} instance.
     * The model will only be loaded, if it can be loaded from the given <tt>locations</tt>
     * (ordering of parameters will be considered).
     * 
     * @param modelMgmt The {@link ModelManagement} instance from where the {@link IModel} should be loaded from, i.e.
     *     {@link VarModel#INSTANCE} or {@link BuildModel#INSTANCE}.
     * @param modelDefinition A (model name, version) pair for specifying which {@link IModel} should be loaded.
     * @param locations A ordered list of locations from where the {@link IModel} should be loaded from.
     * @param <M> The specific model type, will be derived from the {@link ModelManagement} instance.
     *     Will be {@link Project} or {@link Script}.
     * @return A loaded {@link IModel} or <tt>null</tt>.
     * 
     * @throws ModelManagementException In case that the available information
     *     may become inconsistent due to this update
     */
    static<M extends IModel> M loadPreferredModel(ModelManagement<M> modelMgmt,
        IModelData modelDefinition, File... locations) throws ModelManagementException {
        
        ModelInfo<M> result = null;
        List<ModelInfo<M>> infos = modelMgmt.availableModels().getModelInfo(modelDefinition.getName(),
            modelDefinition.getVersion());
        
        if (null != infos && infos.size() > 0 && null != locations && locations.length > 0) {
            for (int i = 0; i < locations.length && null == result; i++) {
                File currentFile = locations[i];
                URI currentURI = currentFile.toURI();
                for (int j = 0; j < infos.size() && null == result; j++) {
                    ModelInfo<M> info = infos.get(j);
                    if (info.isContainedIn(currentURI)) {
                        result = info;
                    }
                }
            }
        }
        
        // Throws a ModelManagementException if result is null
        return modelMgmt.load(result);
    }

}
