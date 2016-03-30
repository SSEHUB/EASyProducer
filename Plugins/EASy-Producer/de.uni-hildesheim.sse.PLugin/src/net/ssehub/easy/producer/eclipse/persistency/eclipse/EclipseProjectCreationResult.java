package net.ssehub.easy.producer.eclipse.persistency.eclipse;

import java.io.File;

import org.eclipse.core.resources.IProject;

import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.standard.ProjectCreationResult;

/**
 * This result will be returned after calling the
 * <tt>EclipsePersistencer#createEASyProject(String, String, String...)</tt> method.
 * @author El-Sharkawy
 *
 */
public class EclipseProjectCreationResult extends ProjectCreationResult implements IEclipseProjectCreationResult {
    
    private IProject project;

    /**
     * Sole constructor for this class.
     * @param result A standard project creation result.
     * @param project The newly created eclipse project.
     */
    public EclipseProjectCreationResult(IProjectCreationResult result, IProject project) {
        super(result.getProjectFolder(), result.getProjectID(), result.getVarModelProjectPath(), result.getVarModel(),
            result.getBuildScript());
        
        this.project = project;
    }
    
    @Override
    public IProject getIProject() {
        return project;
    }

    @Override
    public void setVarModelProjectPath(File varModelProjectLocation) {
        super.setVarModelProjectPath(varModelProjectLocation);
    }
}
