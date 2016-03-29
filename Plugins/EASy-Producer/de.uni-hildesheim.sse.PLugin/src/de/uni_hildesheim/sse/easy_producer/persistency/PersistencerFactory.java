package de.uni_hildesheim.sse.easy_producer.persistency;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.Persistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EclipsePersistencer;
import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.progress.ProgressObserver;

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
     * @return An {@link IPersistencer} depending on whether Eclipse is running or not.
     */
    public static IPersistencer getPersistencer(File projectFolder) {
        IPersistencer persistencer = null;
        if (Environment.runsInEclipse()) {
            persistencer = new EclipsePersistencer(projectFolder, null);
        } else {
            PathEnvironment projectsWorkspace = new PathEnvironment(projectFolder.getParentFile());
            File easyConfigFile = PersistenceUtils.getLocationFile(projectFolder, PathKind.IVML);
            persistencer = new Persistencer(projectsWorkspace, projectFolder, easyConfigFile.getAbsolutePath(),
                ProgressObserver.NO_OBSERVER);
        }
        
        
        return persistencer;
    }
}
