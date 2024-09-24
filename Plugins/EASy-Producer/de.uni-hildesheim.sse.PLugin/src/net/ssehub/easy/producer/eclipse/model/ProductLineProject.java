package net.ssehub.easy.producer.eclipse.model;

import java.io.File;

import org.eclipse.core.resources.IProject;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.producer.core.mgmt.GenericProductLineProject;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.eclipse.Activator;
import net.ssehub.easy.producer.eclipse.internal.ReasoningProgressObserver;
import net.ssehub.easy.producer.eclipse.persistency.EASyPersistencer;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.frontend.ReasoningProcess;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;

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
public class ProductLineProject extends GenericProductLineProject {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(
        ProductLineProject.class, Activator.PLUGIN_ID); 

    /**
     * This constructor is for the creation of a new product line project.
     * 
     * @param projectname The name of the new created product line project
     * @param projectLocation The top level location of the whole ProductLineProject
     */
    public ProductLineProject(String projectname, File projectLocation) {
        super(projectname, projectLocation);
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
        super(projectID, projectName, project, projectLocation, mainBuildScript);
    }

    /**
     * Saves the data of this project persistently to file system.
     */
    public void save() {      
        IProject project = null; // unclear how to get this here
        EASyPersistencer persistencer = new EASyPersistencer(getProjectLocation(), null, project);
        try {
            persistencer.save(this);
        } catch (PersistenceException e) {
            // TODO SE: Auto-generated catch block
            e.printStackTrace();
        }
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
        super.createNewModel(version);
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
