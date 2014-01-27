package de.uni_hildesheim.sse.easy_producer.model;

import java.beans.PropertyChangeSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observer;
import java.util.Set;
import java.util.UUID;

import de.uni_hildesheim.sse.easy_producer.Activator;
import de.uni_hildesheim.sse.easy_producer.contributions.Contributions;
import de.uni_hildesheim.sse.easy_producer.contributions.Contributions.CoreFunction;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.internal.ReasoningProgressObserver;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.MemberIterator;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.EASyConfigFileImporter;
import de.uni_hildesheim.sse.easy_producer.persistency.EASyPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.modelManagement.ProjectContainer;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerListener;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasoningProcess;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

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
    /**
     * Constant for the property change name.
     */
    private static final String PROP_NAME = "productlineModelChanged";
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        ProductLineProject.class, Activator.PLUGIN_ID); 

    /*
     * TODO SE: Check whether this property is still needed.
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

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
        ProjectContainer varModel = new ProjectContainer(project, getConfigLocation());
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
     * This function is only enabled if
     * {@link de.uni_hildesheim.sse.easy_producer.contributions.Contributions.CoreFunction#PULL_CONFIGURATION}
     * is enabled.
     * 
     * @throws VarModelConflictException
     * @since 23.07.2012
     */
    public void pullConfigFromPredecessors() {
        if (Contributions.isEnabled(CoreFunction.PULL_CONFIGURATION)) {
            File configLocation = EASyPersistencer.configLocation(getProjectLocation());
            File destinationPath = new File(configLocation.getPath());
            EASyConfigFileImporter importer = new EASyConfigFileImporter(destinationPath);
            // These list temporarily save the instantiators from all predecessors
            List<FileInstantiator> compareTransformators = new ArrayList<FileInstantiator>();
            
            MemberIterator predecessors = getMemberController().predecessors();
            while (predecessors.hasNext()) {
                PLPInfo predecessorPLP = predecessors.next();
                
                // Copy Instantiator settings
                compareTransformators.addAll(predecessorPLP.getInstantiatorController().getTransformators());
                
                //Copy (imported) ivml files
                File sourceLocation = EASyPersistencer.configLocation(predecessorPLP.getProjectLocation());
                File sourcePath = new File(sourceLocation.toString());
                // Insert a dot to hide imported folders
                importer.copyIVMLFiles(sourcePath, "." + predecessorPLP.getProjectName());
            }
    
            // compare this PTNs Decisions and Dependencies with the compareLists
            compareAndMerge(compareTransformators);
            
            //Refresh
            EASyPersistencer.refreshModels(this);
            getConfiguration().refresh();
            configurationPulled();
        }
    }

    /**
     * Compares and merges {@link FileInstantiator}s while pulling the configuration.
     * @param compareTransformators Pulled {@link FileInstantiator}s.
     */
    @SuppressWarnings("unchecked")
    private void compareAndMerge(List<FileInstantiator> compareTransformators) {
        HashSet<FileInstantiator> oldTransformators;

        oldTransformators = (HashSet<FileInstantiator>) getInstantiatorController().getTransformators().clone();
        
        // ------FileInstantiators--------------
        ArrayList<FileInstantiator> clonedInstantiators = new ArrayList<FileInstantiator>(compareTransformators.size());
        try {
            for (FileInstantiator i : compareTransformators) {
                FileInstantiator clone = (FileInstantiator) i.clone();
                // Check inheritance state
                clone.checkInheritance(getProject().getName());
                clonedInstantiators.add(clone);
            }
        } catch (CloneNotSupportedException e) {
            // cannot happen
        }
        getInstantiatorController().setFileTypeTransformers(clonedInstantiators);
        

        // ------ TRANSFORMATORS --------
        for (FileInstantiator oldT : oldTransformators) {
            getInstantiatorController().getTransformators().add(oldT);
        }

        propertyChangeSupport.firePropertyChange(PROP_NAME, false, true);
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
        getInstantiatorController().addObserver(observer);
        getMemberController().addObserver(observer);
    }

    /**
     * Unsubscribes given observer from notification for each controller.
     * 
     * @param observer The Observer which should be unsubscribed from notification
     * @since 20.10.2011
     */
    public void unRegisterObserver(Observer observer) {
        getInstantiatorController().deleteObserver(observer);
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
        return isTransformableOldStyle() || isTransformableVIL();
    }
    
    /**
     * Checks whether instantiation should be possible. Checks whether at least one inherited instantiator has been
     * found and whether at least one associated predecessor is located in the current workspace. Note: a complete
     * Instantiation might still not be possible due to missing instantiator engines
     * 
     * @see FileInstantiator#getOperationalPath()
     * @return true, if it should be possible
     */
    private boolean isTransformableOldStyle() {
        Set<FileInstantiator> inheritedInstantiators = getInstantiatorController().getInheritedInstantiators();
        boolean result = inheritedInstantiators.size() > 0;
        boolean found = false;
        if (result) {
            for (FileInstantiator instantiator : inheritedInstantiators) {
                if (ResourcesMgmt.INSTANCE.isPLPInWorkspace(instantiator.getPredecessor())) {
                    found = true;
                    // increase performance by skipping further tests
                    break;
                }
            }
        }
        /*
         * TODO: muss noch mal ordentlich gemacht werden...
         * Workaround für ScaleLog (Oder-Block)
         */
        return result && found || getInstantiatorController().getTransformators().size() > 0;
    }
    
    /**
     * Closes this project, which also removes this project from the {@link SPLsManager} and closes all editors.
     * This method shall be called if the related EASy/IProject will be removed/closed.
     */
    public void close() {
        projectClosed();
        
        /*
         * To avoid potential project reloads during the unload process,
         * first remove location for loading models and than unload the project
         */
        VarModel.INSTANCE.locations().removeLocation(getConfigLocation(), ProgressObserver.NO_OBSERVER);
        BuildModel.INSTANCE.locations().removeLocation(getConfigLocation(), ProgressObserver.NO_OBSERVER);
        TemplateModel.INSTANCE.locations().removeLocation(getConfigLocation(), ProgressObserver.NO_OBSERVER);
        try {
            VarModel.INSTANCE.unload(getProject(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            // TODO SE: Use logging here
            e.printStackTrace();
        }
            
        SPLsManager.INSTANCE.removePLP(getProjectID());
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
        ResourcesMgmt.INSTANCE.refreshProject(getProjectName());
    }
    
    @Override
    public void refresh() {
        super.refresh();
        EASyPersistencer.refreshModels(this); //TODO push up refresh of models (excluding the workspace).
    }
}
