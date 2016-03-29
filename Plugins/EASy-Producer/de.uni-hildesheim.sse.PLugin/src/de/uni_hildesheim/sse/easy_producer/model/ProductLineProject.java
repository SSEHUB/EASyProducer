package de.uni_hildesheim.sse.easy_producer.model;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import de.uni_hildesheim.sse.easy_producer.Activator;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.MemberIterator;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.EASyConfigFileImporter;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ProjectContainer;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.internal.ReasoningProgressObserver;
import de.uni_hildesheim.sse.easy_producer.persistency.EASyPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.frontend.ReasoningProcess;
import net.ssehub.easy.reasoning.core.model.ReasoningOperation;
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
public class ProductLineProject extends PLPInfo {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        ProductLineProject.class, Activator.PLUGIN_ID); 

    /**
     * This constructor is for the creation of a new product line project.
     * 
     * @param projectname The name of the new created product line project
     * @param projectLocation The top level location of the whole ProductLineProject
     */
    public ProductLineProject(String projectname, File projectLocation) {
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
     * @param project An already existent variability model for this {@link ProductLineProject}.
     * @param projectLocation The top level location of the whole ProductLineProject
     * @param mainBuildScript The main build script for building the project (starting point of the instantiation).
     */
    public ProductLineProject(String projectID, String projectName, ProjectContainer project,
        File projectLocation, ScriptContainer mainBuildScript) {
        
        super(projectID, projectName, Version.toString(project.getVersion()), projectLocation);
        setProject(project);
        setBuildScript(mainBuildScript);
        SPLsManager.INSTANCE.addPLP(this);
    }
    
    /**
     * Sets the given projectIDs as predecessor projects of this project.
     * @param predecessorIDs A list of predecessors projects.
     * @return <tt>true</tt> if at least one ID was removed or added, <tt>false</tt> otherwise.
     */
    public boolean setPredecessors(List<String> predecessorIDs) {
        boolean changed = false;
        
        // Add all selected Predecessors to this PTN
        if (predecessorIDs != null) {

            // handle removed predecessors
            Iterator<String> iterator = getMemberController().getPredecessorIDs().iterator();
            Set<String> newPredecessorsAsSet = new HashSet<String>(predecessorIDs);
            while (iterator.hasNext()) {
                String oldPredcessorID = iterator.next();
                if (!newPredecessorsAsSet.contains(oldPredcessorID)) {
                    getMemberController().removePredecessor(oldPredcessorID);
                    changed = true;
                }
            }

            // add all new predecessors
            Set<String> currentPredecessors = getMemberController().getPredecessorIDs();
            for (String predecessor : predecessorIDs) {
                if (currentPredecessors.contains(predecessor)) {
                    changed = true;
                }
                getMemberController().addPredecessor(predecessor);
            }
        }
        
        if (changed) {
            createMainRule();
        }
        
        return changed;
    }
    
    /**
     * This method copies the variability model, configuration,
     * and instantiator settings of the predecessor projects to this project.
     * 
     * @throws VarModelConflictException
     * @since 23.07.2012
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
        EASyPersistencer.refreshModels(this);
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
     * @see FileInstantiator#getOperationalPath()
     * @return true, if it should be possible
     */
    public boolean isTransformable() {
        return isTransformableVIL();
    }
    
    @Override
    public void reason(ReasoningOperation desiredOperation,
        IReasonerListener listener) {
        
        if (null != ResourcesMgmt.INSTANCE.getWorkspace()) {
            ReasoningProcess process = createReasoningProcess(desiredOperation, listener);
            new ReasoningProgressObserver(process);
        } else {
            super.reason(desiredOperation, listener);
        }
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
        
        //Refresh files 
        refreshArtifacts();
    }
    
    @Override
    public void refresh() {
        super.refresh();
        EASyPersistencer.refreshModels(this); //TODO push up refresh of models (excluding the workspace).
    }

    /**
     * Refreshes all artifacts on file level.
     */
    public void refreshArtifacts() {
        ResourcesMgmt.INSTANCE.refreshProject(getProjectName());
    }
    
}
