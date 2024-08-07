package net.ssehub.easy.producer.eclipse.persistency;

import java.io.File;

import org.eclipse.core.resources.IProject;

import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.EclipsePersistencer;

/**
 * This class returns a correct {@link IPersistencer} instance as it is needed by the {@link EASyPersistencer}.
 * <ul>
 * <li>In case of a complete Eclipse Instance is running, the {@link EclipsePersistencer} is returned,
 * which loads projects inside of the workspace.</li>
 * <li>In case EASy is ran outside of Eclipse, e.g. as a command line tool, the normal {@link Persistencer} will
 * be returned.</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class PersistencerFactory {

    /**
     * Creates an {@link IPersistencer} instance.
     * @param projectFolder The toplevel folder of the complete project.
     * @param project the project instance to return a persistencer for, may be <b>null</b> then a default 
     *     one may be obtained
     * @return An {@link IPersistencer} depending on whether Eclipse is running or not.
     */
    public static IPersistencer getPersistencer(File projectFolder, IProject project) {
        IPersistencer persistencer = null;
        if (Environment.runsInEclipse()) {
            persistencer = new EclipsePersistencer(projectFolder, null, project);
        } else {
            PathEnvironment projectsWorkspace = new PathEnvironment(projectFolder.getParentFile());
            File easyConfigFile = PersistenceUtils.getLocationFile(projectFolder, PathKind.IVML);
            persistencer = new Persistencer(projectsWorkspace, projectFolder, easyConfigFile.getAbsolutePath(),
                ProgressObserver.NO_OBSERVER);
        }
        
        
        return persistencer;
    }
}
