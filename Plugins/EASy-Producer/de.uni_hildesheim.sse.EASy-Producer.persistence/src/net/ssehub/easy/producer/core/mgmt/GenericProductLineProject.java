package net.ssehub.easy.producer.core.mgmt;

import java.io.File;
import java.util.Observer;
import java.util.UUID;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.persistence.EASyPersistencer;
import net.ssehub.easy.producer.core.persistence.standard.EASyConfigFileImporter;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * This class holds all models, controllers and attributes (which are not stored in a model) related to one product lien
 * project.
 * 
 * @author El-Sharkawy
 * @author Hundt
 * @author Kapeluch
 * @author Brauch
 * @since 20.09.2011
 */
public class GenericProductLineProject extends PLPInfo {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        GenericProductLineProject.class, Activator.PLUGIN_ID); 

    /**
     * This constructor is for the creation of a new product line project.
     * 
     * @param projectname The name of the new created product line project
     * @param projectLocation The top level location of the whole ProductLineProject
     */
    public GenericProductLineProject(String projectname, File projectLocation) {
        super(UUID.randomUUID().toString(), projectname, "0", projectLocation);
        Project project = new Project(projectname);
        Version version = null;
        try {
            version = new Version("0");
        } catch (VersionFormatException e1) {
            // Should not occur
            LOGGER.exception(e1);
        }
        project.setVersion(version);
        ProjectContainer varModel = new ProjectContainer(project, PersistenceUtils.getConfiguration(projectLocation));
        setProject(varModel);
        createMainRule();
        SPLsManager.INSTANCE.addPLP(this);
    }    
    
    /**
     * This constructor is needed, if a saved plp is read by the persistence layer.
     * 
     * @param projectID The ID of the product line project
     * @param projectName The name of the product line project
     * @param project An already existent variability model for this {@link GenericProductLineProject}.
     * @param projectLocation The top level location of the whole ProductLineProject
     * @param mainBuildScript The main build script for building the project (starting point of the instantiation).
     */
    public GenericProductLineProject(String projectID, String projectName, ProjectContainer project,
        File projectLocation, ScriptContainer mainBuildScript) {
        
        super(projectID, projectName, Version.toString(project.getVersion()), projectLocation);
        setProject(project);
        setBuildScript(mainBuildScript);
        SPLsManager.INSTANCE.addPLP(this);
    }

    /**
     * Creates an PLP through a PLPInfo.
     * 
     * @param uuid the unique identifier
     * @param name the name of the project
     * @param version the version of the project
     * @param location the physical location of the PLP (may be <b>null</b>, shall not be <b>null</b> 
     *   in case of archived PLPs such as ones in JAR files)
     */
    protected GenericProductLineProject(String uuid, String name, String version, File location) {
        super(uuid, name, version, location);
    }
    
    /**
     * Creates an PLP through a PLPInfo.
     * 
     * @param uuid the unique identifier
     * @param name the name of the project
     * @param version the version of the project
     * @param configLocation the physical location of the configuration file
     * @param projectLocation the physical location of the PLP (may be <b>null</b>, shall not be <b>null</b> 
     *   in case of archived PLPs such as ones in JAR files)
     */
    protected GenericProductLineProject(String uuid, String name, String version, File configLocation, 
        File projectLocation) {
        super(uuid, name, version, configLocation);
    }
    
    /**
     * This method copies the variability model, configuration,
     * and instantiator settings of the predecessor projects to this project.
     */
    @Override
    public void pullConfigFromPredecessors() {
        // TODO SE: Remove this as far as Transformators are not longer needed.
        EASyConfigFileImporter importer = new EASyConfigFileImporter(this);
        // These list temporarily save the instantiators from all predecessors
        
        MemberIterator predecessors = getMemberController().predecessors();
        while (predecessors.hasNext()) {
            PLPInfo predecessorPLP = predecessors.next();
            
            
            // Copy (imported) ivml files
            // Insert a dot to hide imported folders
            importer.copyConfigFiles(predecessorPLP, "." + predecessorPLP.getProjectName());
        }
        
        //Refresh
        refresh();
        getConfiguration().refresh();
        configurationPulled();
    }

    /**
     * Saves the data of this project persistently to file system.
     */
    public void save() {      
        EASyPersistencer persistencer = new EASyPersistencer(getProjectLocation());
        try {
            persistencer.save(this);
        } catch (PersistenceException e) {
            // TODO SE: Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Registers given observer for every controller.
     * 
     * @param observer The Observer which should be registered for notification
     */
    public void registerObserver(Observer observer) {
        getMemberController().addObserver(observer);
    }

    /**
     * Unsubscribes given observer from notification for each controller.
     * 
     * @param observer The Observer which should be unsubscribed from notification
     * @since 20.10.2011
     */
    public void unRegisterObserver(Observer observer) {
        getMemberController().deleteObserver(observer);
    }

    /**
     * Checks whether instantiation should be possible. Checks whether at least one inherited instantiator has been
     * found and whether at least one associated predecessor is located in the current workspace. Note: a complete
     * Instantiation might still not be possible due to missing instantiator engines
     * 
     * @return true, if it should be possible
     */
    public boolean isTransformable() {
        return isTransformableVIL();
    }
    
    /**
     * Creates a new model for the project.
     * @param version The Version that is to be used for the new model.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public void createNewModel(Version version) throws PersistenceException {
        //Create File
        PersistenceUtils.createIVMLProject(getProjectName(), version, 
            getConfigLocation().getAbsolutePath());
        
        // Register new file at the VARMODEL
        try {
            VarModel.INSTANCE.updateModelInformation(getConfigLocation(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException exc) {
            LOGGER.exception(exc);
        }
    }
    
}
