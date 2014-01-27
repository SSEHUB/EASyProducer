package de.uni_hildesheim.sse.integration.common;

import java.util.List;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * A basic class providing access to models. Specific tool integrations
 * shall add specific methods on how to access or even create models.
 * 
 * @author Holger Eichelberger
 */
public abstract class IModelAccess {

    /**
     * Returns whether the model information matches this origin.
     * 
     * @param info the model information instance
     * @return <code>true</code> if the origins match, <code>false</code> else
     * @throws IllegalArgumentException in case that <code>info</code> is <b>null</b>
     *   or does not match to this implementation
     */

    protected boolean matchesOrigin(IModelInfo info) {
        checkInfo(info);
        return ((ModelInformation) info).getOrigin() == this;
    }

    /**
     * Checks the validity of <code>info</code>.
     * 
     * @param info the instance to check
     * @throws IllegalArgumentException in case that <code>info</code> is <b>null</b>
     *   or does not match to this implementation
     */
    protected void checkInfo(IModelInfo info) {
        if (null == info) {
            throw new IllegalArgumentException("model info must not be null");
        }
        if (!(info instanceof ModelInformation)) {
            throw new IllegalArgumentException("unknown implementation");
        }
    }

    /**
     * Returns the stored project information instance.
     * 
     * @param info the model information instance
     * @return the contained project information instance
     * @throws IllegalArgumentException in case that <code>info</code> is <b>null</b>
     *   or does not match to this implementation
     */
    protected ModelInfo<Project> getInfo(IModelInfo info) {
        checkInfo(info);
        return ((ModelInformation) info).getInstance();
    }
    
    /**
     * Factory method for creating a project information object.
     * 
     * @param info the project info instance to be wrapped
     * @param access the instance which created this object (for consistency reasons)
     * @return the created instance
     */
    protected IModelInfo createInfo(ModelInfo<Project> info, IModelAccess access) {
        return new ModelInformation(info, access);
    }
    
    /**
     * Obtains a project.
     * 
     * @param info the model information instance representing the project to obtain
     * @return the project instance
     * @throws ModelException in case of errors during obtaining/loading the model
     * @throws IllegalArgumentException in case that <code>info</code> is <b>null</b>
     *   or does not match to this implementation
     */
    protected Project obtainProject(IModelInfo info) throws ModelException {
        checkInfo(info);
        try {
            return VarModel.INSTANCE.load(((ModelInformation) info).getInstance());
        } catch (ModelManagementException e) {
            throw new ModelException(e.getMessage());
        }
    }
    
    /**
     * Returns the most recent (regarding its version number) model out of the given
     * set of models.
     * 
     * @param models the models to search within
     * @return the most recent model (may be <b>null</b> if <code>models</code> is empty)
     */
    public static IModelInfo getMostRecentModel(List<IModelInfo> models) {
        IModelInfo result = null;
        Version maxVer = null;
        for (int m = 0; m < models.size(); m++) {
            IModelInfo info = models.get(m);
            try {
                // parsing back is not nice :(
                Version ver = new Version(info.getVersion());
                if (null == maxVer || maxVer.compareTo(ver) > 0) {
                    maxVer = ver;
                    result = info;
                }
            } catch (VersionFormatException e) {
                if (null == maxVer) {
                    result = info;
                }
            }
        }
        return result;
    }

}
