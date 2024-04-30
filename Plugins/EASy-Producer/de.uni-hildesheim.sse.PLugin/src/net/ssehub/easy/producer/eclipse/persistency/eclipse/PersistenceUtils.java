package net.ssehub.easy.producer.eclipse.persistency.eclipse;

import java.io.File;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;

/**
 * Provides Eclipse-specific persistent utility methods.
 * This class mostly delegates to
 * {@link net.ssehub.easy.producer.core.persistence.PersistenceUtils}.
 * 
 * @author Holger Eichelberger
 */
public class PersistenceUtils {

    /**
     * Returns the location of the given <code>project</code> as a file.
     * 
     * @param project the project to return the folder for
     * @return the project location
     */
    public static final File getProjectLocation(IProject project) {
        return project.getLocation().toFile();
    }
    
    /**
     * Returns the specified location folder for the given <code>project</code>. This is a convenience 
     * method for {@link Configuration#getPath(PathKind, int)}.
     * 
     * @param project the project to return the folder for
     * @param kind the path kind
     * @return the folder; note that the existence of this folder is not guaranteed
     */
    public static final IFolder getLocationFolder(IProject project, PathKind kind) {
        Configuration config = getConfiguration(project);
        return project.getFolder(new Path(config.getPath(kind, 0)));
    }
    
    /**
     * Returns the (cached) configuration for the given project (in terms of a <code>projectFolder</code>).
     * 
     * @param project the project to return the folder for
     * @return the configuration of the project
     */
    public static final Configuration getConfiguration(IProject project) {
        return net.ssehub.easy.producer.core.persistence.PersistenceUtils.getConfiguration(
            getProjectLocation(project));
    }
    
    /**
     * Closes a project, i.e., removes its configuration from the internal cache.
     * 
     * @param project the project to return the folder for
     */
    public static final void closeProject(IProject project) {
        net.ssehub.easy.producer.core.persistence.PersistenceUtils.closeProject(getProjectLocation(project));
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
