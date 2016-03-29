package de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ProjectContainer;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.model.Project;

/**
 * Top-layer class for persistent loading and saving of projects.
 * @author El-Sharkawy
 *
 */
public class PersistentProject {
    //Attributes
    /**
     * This array is for storing non ivml information.
     */
    private Model[] models;

    /**
     *This project holds all variability information related to the current project.
     */
    private ProjectContainer project;
    
    /**
     * This script should be the entry point for defining VIL build script.
     */
    private ScriptContainer mainBuildScript;
    
    /**
     * The location of the project.
     */
    private File location;
    
    /**
     * The ID of this project.
     * This id should be replaced by the qualified name of the project.
     */
    private String id;
    
    /**
     * The name of the (eclipse) project.
     */
    private String projectName;

    /**
     * Constructor for reading persistent information and transforming them into an object model.
     * @param location the location of the project.
     */
    public PersistentProject(File location) {
        this.location = location;
        project = null;
        createModels();
    }
    
    /**
     * Constructor for saving an already existing project.
     * @param project The IVML variability model which should be saved.
     * @param location the location of the project.
     * @param configFolder The folder storing the loaded project.
     * @param models Non ivml information which should also be saved
     */
    public PersistentProject(Project project, File location, File configFolder, Model... models) {
        this(location);
        this.project = new ProjectContainer(project, PersistenceUtils.getConfiguration(location));
        for (int i = 0; i < models.length; i++) {
            exchangeModel(models[i]);
        }
    }
    
    /**
     * This method creates empty {@link Model}s for storing persistent information.
     */
    private void createModels() {
        models = new Model[ModelType.values().length];
        for (int i = 0; i < models.length; i++) {
            models[i] = new Model(ModelType.values()[i]);
        }
    }
    
    /**
     * This method exchanges the given model with the corresponding model of the same type.
     * @param model The model which should be stored in this <code>PersistentProject</code>.
     */
    public void exchangeModel(Model model) {
        boolean found = false;
        for (int i = 0; !found && i < models.length; i++) {
            if (models[i].getModelType() == model.getModelType()) {
                models[i] = model; 
            }
        }
    }
    
    
    /**
     * Getter for the IVML variability model.
     * @return The ivml variability model or <code>null</code>,
     * if no variability model was found during persistent reading.
     */
    public ProjectContainer getProject() {
        return project;
    }
    
    /**
     * Getter for the main VIL build script model.
     * @return The VIL build script or <code>null</code>,
     * if no build script was found during persistent reading.
     */
    public ScriptContainer getMainBuildScript() {
        return mainBuildScript;
    }
    
    /**
     * Getter for the models of this project.
     * @param type The type of the desired model.
     * @return The desired model or <code>null</code> if no concrete model with the specified type could be resolved.
     */
    public Model getModel(ModelType type) {
        Model model = null;
        for (int i = 0; null == model && i < models.length; i++) {
            if (models[i].getModelType() == type) {
                model = models[i];
            }
        }
        
        return model;
    }
    
    /**
     * Returns the number of models.
     * 
     * @return The number of models.
     */
    public int getModelCount() {
        return models.length > 0 ? models.length : -1;
    }
    
    /**
     * Returns a model specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying model to be returned
     * @return all models of the project
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= size()</tt>)
     */
    public Model getModel(int index) {
        return models[index];
    }
    
    /**
     * Setter for the id.
     * @param id the id of this project.
     * @deprecated should be replaced by the ivml qualified name of the project.
     */
    @Deprecated
    public void setID(String id) {
        this.id = id;
    }
      
    /**
     * Getter for the ID of this project.
     * @return The ID of this project.
     */
    public String getID() {
        return id;
    }
    
    /**
     * Setter for the name of this (eclipse) project.
     * @param projectName The name of the (eclipse) project.
     */
    public void setName(String projectName) {
        this.projectName = projectName;
    }
    
    /**
     * Getter for the (eclipse) name of this project.
     * @return The name of this project.
     */
    public String getName() {
        return projectName;
    }
    
    /**
     * Fetter for the version of this project.
     * @return The version of this project or <code>null</code> if no version is specified.
     */
    public Version getVersion() {
        Version version = null;
        if (null != project) {
            version = project.getVersion();
        }
        
        return version;
    }
    
    /**
     * Setter for the ivml project, which should be read/saved.
     * @param project A ivml project (must not be <tt>null</tt>).
     * @param location The folder storing the loaded project.
     */
    public void setProject(Project project, Configuration location) {
        this.project = new ProjectContainer(project, location);
    }
    
    /**
     * Setter for the ivml project, which should be read/saved.
     * @param varModel A managed {@link Project} in a {@link ProjectContainer} (must not be <tt>null</tt>).
     */
    public void setVarModel(ProjectContainer varModel) {
        this.project = varModel;
    }
    
    /**
     * Setter for the main VIL build script file.
     * @param mainBuildScript The entry point for the build script definition (must not be <tt>null</tt>).
     * @param location The folder storing the loaded project.
     */
    public void setScript(Script mainBuildScript, Configuration location) {
        this.mainBuildScript = new ScriptContainer(mainBuildScript, location);
    }
    
    /**
     * Setter for the main VIL build script file.
     * @param mainBuildScript A managed {@link Script} in a {@link ScriptContainer} (must not be <tt>null</tt>).
     */
    public void setScript(ScriptContainer mainBuildScript) {
        this.mainBuildScript = mainBuildScript;
    }
    
    /**
     * Returns the location of the project.
     * 
     * @return the location
     */
    public File getLocation() {
        return location;
    }
}
