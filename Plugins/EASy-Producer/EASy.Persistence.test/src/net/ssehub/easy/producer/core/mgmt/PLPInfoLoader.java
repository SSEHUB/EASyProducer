package net.ssehub.easy.producer.core.mgmt;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;

/**
 * Helping class for testing.
 * This class helps to load the {@link PLPInfo} correctly.
 * @author El-Sharkawy
 *
 */
class PLPInfoLoader extends PLPInfo {
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(PLPInfoLoader.class
        , "de.uni_hildesheim.sse.easy_producer.core.test");
    
    /**
     * Constructor for loading {@link PLPInfo}s.
     * @param project The {@link PersistentProject} loaded by the
     * {@link net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer}
     * to load a {@link PLPInfo} for
     * testing.
     */
    PLPInfoLoader(PersistentProject project) {
        super(project.getID(), project.getName(), project.getVersion().getVersion(),
            project.getLocation());
        
        LOGGER.debug("IVML loaded with " + project.getProject().getModel().getElementCount() + " elements.");
        setProject(project.getProject());
        setBuildScript(project.getMainBuildScript());
        SPLsManager.INSTANCE.addPLP(this);
    }

    /**
     * Constructor for creating {@link PLPInfo}s.
     * @param result A {@link IProjectCreationResult} created by
     * {@link net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer
     * #createProject(String, java.io.File, String, boolean)}.
     */
    PLPInfoLoader(IProjectCreationResult result) {
        super(result.getProjectID(), result.getVarModel().getName(), result.getVarModel().getVersion().toString(),
            result.getProjectFolder());
        Configuration location = PersistenceUtils.getConfiguration(result.getProjectFolder());
        ProjectContainer varModel = new ProjectContainer(result.getVarModel(), location);
        ScriptContainer instantiationModel = new ScriptContainer(result.getBuildScript(), location);
        setProject(varModel);
        setBuildScript(instantiationModel);
        SPLsManager.INSTANCE.addPLP(this);
    }
}
