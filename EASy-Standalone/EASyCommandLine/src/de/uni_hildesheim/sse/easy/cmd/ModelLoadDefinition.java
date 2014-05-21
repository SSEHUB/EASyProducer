package de.uni_hildesheim.sse.easy.cmd;

import de.uni_hildesheim.sse.utils.modelManagement.IModelData;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * Datatype for loading a IModel, i.e. a {@link de.uni_hildesheim.sse.model.varModel.Project}
 * or {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script},
 * while using only String parameters.
 * @author El-Sharkawy
 *
 */
public class ModelLoadDefinition implements IModelData {

    private String modelName;
    private Version version;
    
    /**
     * Sole constructor for this datatype.
     * @param modelName The name of the IModel which shall be loaded (Must not be <tt>null</tt>).
     * @param version The Version of the IModel, which shall be loaded (can be <tt>null</tt>).
     * @throws VersionFormatException In case of format problems
     * @throws NullPointerException If the modelName is <tt>null</tt>. 
     */
    public ModelLoadDefinition(String modelName, String version) throws VersionFormatException {
        if (null == modelName) {
            throw new NullPointerException("Model name must not be null");
        }
        this.modelName = modelName;
        this.version = null != version ? new Version(version) : null;
    }
    
    @Override
    public String getName() {
        return modelName;
    }

    @Override
    public Version getVersion() {
        return version;
    }

}
