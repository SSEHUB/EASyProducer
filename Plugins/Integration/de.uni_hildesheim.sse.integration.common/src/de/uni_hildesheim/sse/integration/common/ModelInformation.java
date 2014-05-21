package de.uni_hildesheim.sse.integration.common;

import java.net.URI;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

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

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return info.getName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return Version.toString(info.getVersion());
    }

    /**
     * {@inheritDoc}
     */
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
