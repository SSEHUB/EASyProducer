package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IProjectCreationResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Result of {@link Persistencer#createProject(String, File, String, boolean)}.
 * @author El-Sharkawy
 *
 */
public class ProjectCreationResult implements IProjectCreationResult {

    private File projectFolder;
    
    private String projectID;
    
    private File varModelProjectLocation;
    
    private Project varModel;
    
    private Script mainBuildScript;
    
    /**
     * Sole constructor for this class.
     * @param projectFolder The location of the newly created project.
     * @param projectID The ID of the newly created project.
     * @param varModelProjectLocation The location of the (ivml) project file.
     * @param varModel The variability model of the newly created project.
     * @param mainBuildScript The main build script decriping how to instanciate the whole project.
     */
    public ProjectCreationResult(File projectFolder, String projectID, File varModelProjectLocation, Project varModel,
        Script mainBuildScript) {
        
        this.projectFolder = projectFolder;
        this.projectID = projectID;
        this.varModelProjectLocation = varModelProjectLocation;
        this.varModel = varModel;
        this.mainBuildScript = mainBuildScript;
    }

    @Override
    public final File getProjectFolder() {
        return projectFolder;
    }

    @Override
    public final String getProjectID() {
        return projectID;
    }

    @Override
    public final File getVarModelProjectPath() {
        return varModelProjectLocation;
    }
    
    /**
     * Setter for the varModelProjectLocation.
     * This method should only be used by sub classes.
     * @param varModelProjectLocation The new location of the varModel.
     */
    protected void setVarModelProjectPath(File varModelProjectLocation) {
        this.varModelProjectLocation = varModelProjectLocation;
    }

    @Override
    public Project getVarModel() {
        return varModel;
    }

    @Override
    public File getConfigFolder() {
        return PersistenceUtils.getLocationFile(getProjectFolder(), PathKind.IVML);
    }

    @Override
    public Script getBuildScript() {
        return mainBuildScript;
    }
}
