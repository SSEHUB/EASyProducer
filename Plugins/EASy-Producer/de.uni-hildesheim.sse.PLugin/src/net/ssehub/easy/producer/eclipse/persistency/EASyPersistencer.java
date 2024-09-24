package net.ssehub.easy.producer.eclipse.persistency;

import java.io.File;

import org.eclipse.core.resources.IProject;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.observer.EclipseProgressObserver;
import net.ssehub.easy.varModel.model.Project;

/**
 * Abstraction Layer for saving/reading persistent EASy-Producer information.
 * @author El-Sharkawy
 *
 */
public class EASyPersistencer extends net.ssehub.easy.producer.core.persistence.EASyPersistencer {

    /**
     * Creates a specialized EASy persistencer without underlying project.
     * @param projectFolder The location of the {@link ProductLineProject}.
     */
    public EASyPersistencer(File projectFolder) {
        this(projectFolder, null, null);
    }

    /**
     * Creates a specialized EASy persistencer.
     * @param projectFolder The location of the {@link ProductLineProject}.
     * @param obs progress observer, may be {@link ProgressObserver#NO_OBSERVER} 
     * @param project the project instance to return a persistencer for, may be <b>null</b> then a default 
     *     one may be obtained
     */
    public EASyPersistencer(File projectFolder, EclipseProgressObserver obs, IProject project) {
        super(PersistencerFactory.getPersistencer(projectFolder, obs, project));
    }

    @Override
    protected ProductLineProject createPLP(String projectID, String projectName, ProjectContainer project,
        File projectLocation, ScriptContainer mainBuildScript) {
        return new ProductLineProject(projectID, projectName, project, projectLocation, mainBuildScript);
    }

    /**
     * (Re-)Loads all variability models of the specified {@link ProductLineProject} from the file system.
     * @param plp A {@link ProductLineProject} containing saved models which should be (re-) loaded from the file system
     */
    public static void refreshModels(PLPInfo plp) {
        ResourcesMgmt.INSTANCE.refreshProject(plp.getProjectName());
    }

    @Override
    public ProductLineProject populateEasyProject(String projectID, String projectName, File projectFolder, 
            Project ivmlModel) {
        return (ProductLineProject) super.populateEasyProject(projectID, projectName, projectFolder, ivmlModel);
    }

}
