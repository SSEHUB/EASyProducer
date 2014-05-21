package de.uni_hildesheim.sse.easy.instantiator.copy.core;

/**
 * File abstraction layer for project copy operations.
 * @author El-Sharkawy
 *
 */
public interface ICopyMechanism {

    /**
     * Is intended to use for workspacecopyoperations required by instantiation.
     * It provides two copy-mechanisms: 1 -
     * for JavaProjects with a mechanism to avoid conflicted references and update library classpath entries.<br>
     * It is generic and suitable for heterogenity. Every classpathentry is analyzed. If a classpthentry contains
     * sources, he is handled to remain references. Other folders are copied with a generic workspaceoperation. 2 - for
     * every other Eclipse Project a generic workspaceoperation is used.<br>
     * 
     * @param sourceProjectName - Project which folders shall be copied
     * @param targetProjectName - Project to where the data shall be copied to
     */
    public void copy(String sourceProjectName, String targetProjectName);
    
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
     * Returns the ID of the CopyMechanism, should be static.
     * 
     * @return The ID of the CopyMechanism
     */
    public abstract String getID();
    
    /**
     * Returns the (unique) Name of the CopyMechanism, should be static.
     * 
     * @return The Name of the CopyMechanism
     */
    public abstract String getName();
    
    /**
     * Getter whether the CopyMechanism adapts files and introduce name spaces.
     * @return <tt>true</tt> if name spaces are introduced, otherwise <tt>false</tt>.
     */
    public boolean useNameSpace();
}
