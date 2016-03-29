package net.ssehub.easy.integration.common;

import java.net.URI;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.model.Project;

/**
 * Implements the model information object.
 * 
 * @author Holger Eichelberger
 */
public class ModelInformation implements IModelInfo {

    private ModelInfo<Project> info;
    private IModelAccess access;
    
    /**
     * Creates a model info instance.
     * 
     * @param info the project info instance to be wrapped
     * @param access the instance which created this object (for consistency reasons)
     */
    ModelInformation(ModelInfo<Project> info, IModelAccess access) {
        this.info = info;
        this.access = access;
    }

    @Override
    public String getName() {
        return info.getName();
    }

    @Override
    public String getVersion() {
        return Version.toString(info.getVersion());
    }

    @Override
    public URI getLocation() {
        return info.getLocation();
    }
    
    /**
     * Returns the implementing instance.
     * 
     * @return the implementing instance
     */
    ModelInfo<Project> getInstance() {
        return info;
    }
    
    /**
     * Returns the origin of this instance.
     * 
     * @return the origin
     */
    IModelAccess getOrigin() {
        return access;
    }

}
