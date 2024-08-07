package net.ssehub.easy.producer.eclipse.persistency.eclipse;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;

import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;

/**
 * Creates path environments in a generic way considering information from projects
 * such as relevant classpaths.
 * 
 * @author Holger Eichelberger
 */
public class PathEnvironmentFactory {

    /**
     * Handles a certain type of project. We introduced this interface 
     * in order to release dependencies. Otherwise, the specific types
     * of projects supported by EASy would have to be considered in this class.
     * 
     * @author Holger Eichelberger
     */
    public interface IProjectHandler {

        /**
         * Add the relevant path information from <code>project</code>
         * to <code>pathEnv</code>.
         * 
         * @param project the project containing the information to be added to <code>pathEnv</code>
         * @param pathEnv the path environment to be modified as a side effect
         */
        public void addPaths(IProject project, PathEnvironment pathEnv);
        
    }
    
    private static List<IProjectHandler> handlers = new ArrayList<IProjectHandler>();
    
    /**
     * Prevents this class from being instantiated from outside. [utility class/factory class]
     */
    private PathEnvironmentFactory() {
    }
    
    /**
     * Registers a project handler.
     * 
     * @param handler the handler to register
     */
    public static void registerHandler(IProjectHandler handler) {
        if (null != handler && !handlers.contains(handler)) {
            handlers.add(handler);
        }
    }

    /**
     * Unregisters a project handler.
     * 
     * @param handler the handler to unregister
     */
    public static void unregisterHandler(IProjectHandler handler) {
        if (null != handler) {
            handlers.remove(handler);
        }
    }
    
    /**
     * Creates a new path environment and takes project specific paths such as classpaths
     * into account. Calls {@link #updatePathEnvironment(PathEnvironment, IProject)}
     * on the new instance.
     * 
     * @param project the project to build the path environment for (may be <b>null</b>)
     * @return the path environment
     */
    public static PathEnvironment createPathEnvironment(IProject project) {
        IPath projectLocation = null != project ? project.getLocation() : null;
        IPath workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation();
        PathEnvironment pathEnv = null;
        if (null != projectLocation && !workspaceLocation.isPrefixOf(projectLocation)) {
            pathEnv = new PathEnvironment(projectLocation.removeLastSegments(1).toFile());
        } else {
            pathEnv = new PathEnvironment(EclipsePersistencer.WORKSPACE_FOLDER);
        }
        updatePathEnvironment(pathEnv, project);
        return pathEnv;
    }
    
    /**
     * Updates a given path environment with data from <code>project</code>.
     * This method takes the registered instances of {@link IProjectHandler} into account.
     * 
     * @param pathEnv the path environment to update
     * @param project the project to be considered
     */
    public static void updatePathEnvironment(PathEnvironment pathEnv, IProject project) {
        pathEnv.clear();
        if (null != project) {
            for (int h = 0; h < handlers.size(); h++) {
                handlers.get(h).addPaths(project, pathEnv);
            }
        }
    }

}
