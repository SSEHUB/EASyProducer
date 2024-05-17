package net.ssehub.easy.standalone.cmd;

import net.ssehub.easy.basics.modelManagement.IModelData;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;

/**
 * Datatype for loading a IModel, i.e. an IVML project or a VIL script,
 * while using only String parameters.
 * @author El-Sharkawy
 *
 */
public class ModelLoadDefinition implements IModelData {

    private String modelName;
    private Version version;
    
    /**
     * Sole constructor for this datatype.
     * @param modelName The name of the IModel which shall be loaded (Must not be <code>null</code>).
     * @param version The Version of the IModel, which shall be loaded (can be <code>null</code>).
     * @throws VersionFormatException In case of format problems
     * @throws NullPointerException If the modelName is <code>null</code>. 
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
