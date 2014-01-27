package de.uni_hildesheim.sse.easy_producer.persistency.eclipse;

import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Provides Eclipse-specific persistent utility methods.
 * This class mostly delegates to
 * {@link de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils}.
 * 
 * @author Holger Eichelberger
 */
public class PersistenceUtils {

    /**
     * Returns the EASy configuration location folder for the given 
     * <code>project</code>.
     * 
     * @param project the project to return the folder for
     * @return the folder; note that the existence of this folder is not guaranteed
     */
    public static final IFolder getConfigLocationFolder(IProject project) {
        String configFolder = de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils.getConfigLocation(
            project.getLocation().toFile());
        return project.getFolder(new Path(configFolder));
    }

    /**
     * Persists the location of the configuration folder.
     * 
     * @param project the project to return the folder for
     * @param location the (relative) location to be persisted
     * @throws IOException any I/O exception during persisting the location
     */
    public static final void storeConfigLocation(IProject project, String location) throws IOException {
        de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils.storeConfigLocation(
            project.getLocation().toFile(), location);
        try {
            project.refreshLocal(IProject.DEPTH_ONE, null);
        } catch (CoreException e) {
        }
    }
    
    /**
     * Turns a workspace-relative path into an absolute path.
     * 
     * @param path the workspace-relative path
     * @return the absolute path (<code>path</code> if it is not located in the workspace)
     */
    public static final IPath makeWsPathAbsolute(IPath path) {
        IResource projectPath = ResourcesPlugin.getWorkspace().getRoot().findMember(path);
        if (null != projectPath) {
            path = projectPath.getLocation();
        }
        return path;
    }
    
}
