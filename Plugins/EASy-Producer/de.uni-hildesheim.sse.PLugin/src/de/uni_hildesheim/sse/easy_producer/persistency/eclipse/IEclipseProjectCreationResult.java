package de.uni_hildesheim.sse.easy_producer.persistency.eclipse;

import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.
    IProjectCreationResult;

/**
 * An instance of this class will be returned after calling
 * <tt>EclipsePersistencer.createProject(String, File, String)</tt>.
 * @author El-Sharkawy
 *
 */
public interface IEclipseProjectCreationResult extends IProjectCreationResult {
    
    /**
     * Returns the eclipse handle for the newly created eclipse project.
     * @return The eclipse handle for the newly created eclipse project.
     */
    public IProject getIProject();

}
