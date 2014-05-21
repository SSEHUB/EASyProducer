package de.uni_hildesheim.sse.integration.common.eclipse;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.PersistenceUtils;
import de.uni_hildesheim.sse.integration.common.IModelInfo;
import de.uni_hildesheim.sse.integration.common.ModelException;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * A basic class providing access to models. Specific tool integrations
 * shall add specific methods on how to access or even create models.
 * 
 * @author Holger Eichelberger
 */
public abstract class IModelAccess extends de.uni_hildesheim.sse.integration.common.IModelAccess {

    /**
     * Makes the given project-relative <code>path</code> absolute to the 
     * workspace root.
     * 
     * @param path the path to make absolute
     * @return the absolute path
     */
    public static IPath absoluteToWorkspaceRoot(IPath path) {
        return ResourcesPlugin.getWorkspace().getRoot().getLocation().append(path);
    }

    /**
     * Returns the most recent (regarding its version number) top-level model.
     * 
     * @param project the project to return the modle for
     * @return the most recent model (may be <b>null</b> if there is none)
     */
    public IModelInfo getMostRecentTopLevelModel(IProject project) {
        return getMostRecentModel(getAvailableModels(project));
    }
    
    /**
     * Returns the top-level models in <code>project</code> according to EASy
     * conventions.
     * 
     * @param project the project to return the default models for
     * @return the top-level models as considered by EASy
     */
    public List<IModelInfo> getTopLevelModels(IProject project) {
        String projectName = project.getName();
        List<IModelInfo> result = getAvailableModels(project);
        for (int r = result.size() - 1; r > 0; r--) {
            IModelInfo info = result.get(r);
            if (!info.getName().equals(projectName)) {
                result.remove(r);
            }
        }
        return result;
    }
    
    /**
     * Returns the models which are available for and visible from <code>project</code>.
     * The result of this method may change over time, e.g. when models are created.
     * 
     * @param project the project where to start searching / considering models
     * @return the model information objects representing available projects
     */
    public List<IModelInfo> getAvailableModels(IProject project) {
        List<IModelInfo> result = new ArrayList<IModelInfo>();
        if (project.exists()) {
            IFolder folder = PersistenceUtils.getLocationFolder(project, PathKind.IVML);
            IPath folderPath;
            if (!folder.exists()) {
                folderPath = project.getFullPath();
            } else {
                folderPath = folder.getFullPath();
            }
            URI uri = absoluteToWorkspaceRoot(folderPath).toFile().toURI();
            List<ModelInfo<Project>> pResult = VarModel.INSTANCE.availableModels().getVisibleModelInfo(uri);
            int count = pResult.size();
            for (int p = 0; p < count; p++) {
                result.add(createInfo(pResult.get(p), this));
            }
        }
        return result;
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
            return VarModel.INSTANCE.load(getInfo(info));
        } catch (ModelManagementException e) {
            throw new ModelException(e.getMessage());
        }
    }
    
    /**
     * Updates the available model information in <code>project</code>.
     * 
     * @param project the project to update the information for
     * @throws ModelException in case of errors during the update
     */
    public void updateModelInfo(IProject project) throws ModelException {
        File file = IModelAccess.absoluteToWorkspaceRoot(project.getFullPath()).toFile();
        try {
            VarModel.INSTANCE.updateModelInformation(file, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            throw new ModelException(e);
        }
    }
    
}
