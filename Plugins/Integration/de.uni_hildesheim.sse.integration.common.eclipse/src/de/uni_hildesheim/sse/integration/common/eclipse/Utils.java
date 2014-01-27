package de.uni_hildesheim.sse.integration.common.eclipse;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;

/**
 * Common utility method for Eclipse-based tool integrations.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Returns whether the given project exists.
     * 
     * @param name the name of the project to be created.
     * @return <code>true</code> if the project exists, <code>false</code> else
     */
    public final boolean projectExists(String name) {
        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
        return project.exists();
    }
    
}
