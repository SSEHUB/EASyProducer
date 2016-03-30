package net.ssehub.easy.producer.eclipse.persistency.eclipse;

import org.eclipse.core.resources.IProject;

import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;

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
