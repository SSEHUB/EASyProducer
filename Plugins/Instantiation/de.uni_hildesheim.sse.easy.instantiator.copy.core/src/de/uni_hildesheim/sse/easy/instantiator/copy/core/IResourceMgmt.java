package de.uni_hildesheim.sse.easy.instantiator.copy.core;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;

/**
 * Filesystem abstraction layer.
 * @author El-Sharkawy
 *
 */
public interface IResourceMgmt {
    
    /**
     * Refreshes the files and folders in the package explorer view for the given project.
     * @param projectname The name of the project to be refreshed.
     */
    public void refreshProject(String projectname);
    
    /**
     * Checks for a given name, whether a PLP with said name is located in the current workspace.
     * 
     * @param name the name of the project to check
     * @return true if the project is a plp and located in the workspace
     */
    public boolean isPLPInWorkspace(String name);
    
    /**
     * Returns a representation of the current used workspace.
     * 
     * @return A representation of the current used workspace
     */
    public IWorkspace getWorkspace();
    
    /**
     * Returns a representation of the selected project.
     * 
     * @param projectname The name of the project, which should be returned.
     * @return A representation of the selected project
     */
    public IProject getProject(String projectname);
    
    /**
     * Returns the source folder, which should be used for copying files.
     * @return The source folder of the current project, where to place copied files.
     * 
     * @deprecated remove as soon as copy mechanisms and legacy instantiations are removed
     */
    @Deprecated
    public String getMainSourceFolder();
    
    /**
     * Returns the resources folder, which should be used for copying files.
     * @return The resources folder of the current project, where to place copied files.
     * 
     * @deprecated remove as soon as copy mechanisms and legacy instantiations are removed
     */
    @Deprecated
    public String getResourcesFolder();
    
    /**
     * Returns the config folder, which should be ignored during instantiation.
     * @return The config folder of the current project.
     * 
     * @deprecated remove as soon as copy mechanisms and legacy instantiations are removed
     */
    @Deprecated
    public String getConfigFolder();
}
