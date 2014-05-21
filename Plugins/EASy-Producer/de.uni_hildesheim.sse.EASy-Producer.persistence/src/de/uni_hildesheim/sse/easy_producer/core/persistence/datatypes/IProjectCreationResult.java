package de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * An instance of this class will be returned after calling
 * {@link IPersistencer#createProject(String, File, String, boolean)}.
 * @author El-Sharkawy
 *
 */
public interface IProjectCreationResult {
    
    /**
     * Returns the top level location of the newly created project.
     * @return The top level location of the newly created project.
     */
    public File getProjectFolder();
    
    /**
     * Returns the location of configuration files for the newly created project.
     * @return The location of configuration files for the newly created project.
     */
    public File getConfigFolder();
    
    /**
     * Returns the projectID of the newly created project.
     * @return The projectID of the newly created project.
     */
    public String getProjectID();
    
    /**
     * Returns the absolute path of the newly created VarModel project (ivml project).
     * @return The absolute path of the newly created VarModel project.
     */
    public File getVarModelProjectPath();
    
    /**
     * Returns the variability model of the newly created project. 
     * @return The variability model of the newly created project.
     */
    public Project getVarModel();
    
    /**
     * Returns the main build script for instantiating the whole project.
     * @return The starting point of the complete instantiation of the current project.
     */
    public Script getBuildScript();
}
