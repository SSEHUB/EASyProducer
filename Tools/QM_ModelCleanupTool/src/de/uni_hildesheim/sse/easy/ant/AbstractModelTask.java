package de.uni_hildesheim.sse.easy.ant;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import de.uni_hildesheim.sse.easy.ant.modelcopy.ProjectUtilities;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.reasoning.core.impl.ReasonerRegistry;
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;
import net.ssehub.easy.varModel.validation.ValidationMessage;

/**
 * Common functionality for tasks manipulating the QM model.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractModelTask extends Task {
    
    private File sourceFolder;
    private File destinationFolder;
    private String mainProject;
    private boolean validate = true;
    private boolean verbose = true;
    private boolean allowDestDeletion = false;
    
    protected AbstractModelTask() {
        ReasonerRegistry.getInstance().register(new Reasoner());
    }
    
    /**
     * A folder containing artifacts to copy. Will consider sub folders.
     * @param sourceFolder A folder containing the source artifacts for copying.
     */
    public void setSourceFolder(String sourceFolder) {
        this.sourceFolder = new File(sourceFolder);
    }
    
    /**
     * The target folder where the copied models shall be stored.
     * @param destinationFolder The folder must exist and empty or not exist (must not be <code>null</code>).
     */
    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = new File(destinationFolder);
    }
    
    /**
     * Main Project, is needed for loading the projects in a correct order.
     * @param mainProject The starting point of the model to be copied, only its name.
     */
    public void setMainProject(String mainProject) {
        this.mainProject = mainProject;
    }
   
    /**
     * Enables/disables additional logging.
     * @param verbose <code>true</code> enables some debugging output (enabled by default), <code>false</code> disables it.
     */
    public void setVebose(boolean verbose) {
        this.verbose = verbose;
    }
    
    /**
     * Specifies if the destination maybe cleaned up during running the task (default is <code>false</code>).
     * @param allowDestDeletion <code>true</code> deletes the destination if it exists, <code>false</code> throws an error if
     * the destination exists.
     */
    public void setAllowDestDeletion(boolean allowDestDeletion) {
        this.allowDestDeletion = allowDestDeletion;
    }
    
    /**
     * Specifies if the result shall be validated
     * @param valitate <code>true</code> an inconsistent result will lead in an crash (default),
     * <code>false</code> prints errors but will not lead to a buid stop.
     */
    public void setValidate(boolean valitate) {
        this.validate = valitate;
    }

    /**
     * Returns the folder containing the source artifacts.
     * @return The source folder.
     */
    protected final File getSourceFolder() {
        return sourceFolder;
    }

    /**
     * Returns the target folder where the copied models shall be stored.
     * @return The destination folder.
     */
    protected final File getDestinationFolder() {
        return destinationFolder;
    }

    /**
     * Returns the the starting point of the model.
     * @return The main project.
     */
    protected final String getMainProject() {
        return mainProject;
    }

    /**
     * Returns whether additional debugging output is desired.
     * @return <code>true</code> output is desired.
     */
    protected final boolean getVebose() {
        return verbose;
    }
    
    /**
     * Specifies if the destination maybe cleaned up during running the task (default is <code>false</code>).
     * @return <code>true</code> folder may be deleted, <code>false</code> throw an error if destination exists.
     */
    protected final boolean getAllowDestDeletion() {
        return allowDestDeletion;
    }
    
    /**
     * Returns whether validation of the result should stop the build or only output an error.
     * @return <code>true</code> An flawed result will stop the whole built.
     */
    protected final boolean getValidate() {
        return validate;
    }
    
    
    /**
     * Prints a debug message if verbosity was enabled.
     * @param msg The message to print.
     */
    protected void debugMessage(String msg) {
        if (getVebose()) {
            System.out.println(msg);
        }
    }
    
    /**
     * Removed or adds a (temporary) folder for loading models from this locations.
     * @param modelManagement {@link VarModel#INSTANCE}, {@link BuildModel#INSTANCE}, or {@link TemplateModel#INSTANCE}
     * @param folder The folder to (un-)register
     * @param add <code>true</code> the folder will be added as possible location for models, <code>false</code> the folder
     *     will be removed.
     * @throws ModelManagementException If model files could not be parsed
     */
    protected void addOrRemoveLocation(ModelManagement<? extends IModel> modelManagement, File folder, boolean add)
        throws ModelManagementException {
        
        if (add) {
            modelManagement.locations().addLocation(folder, ProgressObserver.NO_OBSERVER);
        } else {
            modelManagement.locations().removeLocation(folder, ProgressObserver.NO_OBSERVER);
        }
    }
    
    /**
     * Loads the specified project from the location. <br/>
     * 
     * This adds the {@link #getSourceFolder()} to the {@link VarModel}. This should be undone at a later point.
     * @param folder The folder from where to load the project.
     * @param mainProjectName The starting point of the project.
     * @return The loaded project.
     * @throws ModelManagementException If IVML files could not be parsed
     * @throws IOException If files could not be copied.
     */
    protected Project loadProject(File folder, String mainProjectName) throws ModelManagementException, IOException {
        addOrRemoveLocation(VarModel.INSTANCE, folder, true);
        Project p = ProjectUtilities.loadProject(mainProjectName);
        debugMessage(p.getName() + " sucessfully loaded.");
        
        return p;
    }
    
    @Override
    public void execute() throws BuildException {
        // Print debug data
        debugMessage("Source folder: " + getSourceFolder().getAbsolutePath());
        debugMessage("Destination folder: " + getDestinationFolder().getAbsolutePath());
        debugMessage("Main model: " + getMainProject());
        
        // Setup
        debugMessage("Prepare destination folder: " + getDestinationFolder().getAbsolutePath());
        boolean createFolder = false;
        if (getDestinationFolder().exists() && getAllowDestDeletion()) {
            try {
                FileUtils.deleteDirectory(getDestinationFolder());
                createFolder = true;
            } catch (IOException e) {
                throw new BuildException("Destination folder \"" + getDestinationFolder().getAbsolutePath()
                    + "\" exists and could not be deleted. Cause: " + e.getMessage());
            }
        } else if (getDestinationFolder().exists() && !getAllowDestDeletion()
            && getDestinationFolder().listFiles().length > 0) {
            
            throw new BuildException("Destination folder \"" + getDestinationFolder().getAbsolutePath() + "\" exists and "
                + "is not empty.");
        }
        if (createFolder && !getDestinationFolder().mkdirs()) {
            throw new BuildException("Destination folder \"" + getDestinationFolder().getAbsolutePath()
                + "\" could not be created.");
        }
        
        doModelOperation();
        
        // Validate result
        debugMessage("Validate Result");
        try {
            VarModel.INSTANCE.locations().removeLocation(getSourceFolder(), ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.locations().addLocation(getDestinationFolder(), ProgressObserver.NO_OBSERVER);
            Project copiedProject = ProjectUtilities.loadProject(getMainProject());
            
            IvmlValidationVisitor validator = new IvmlValidationVisitor();
            copiedProject.accept(validator);
            if (validator.getErrorCount() > 0) {
                StringBuffer errMsg = new StringBuffer("Project \"");
                errMsg.append(getMainProject());
                errMsg.append("\" was copied, but the result contains inconsistencies:");
                for (int i = 0; i < validator.getMessageCount(); i++) {
                    ValidationMessage msg = validator.getMessage(i);
                    errMsg.append("\n - ");
                    errMsg.append(msg.getStatus().name());
                    errMsg.append(": ");
                    errMsg.append(msg.getDescription());
                }
                if (getValidate()) {
                    throw new BuildException(errMsg.toString());
                } else {
                    System.out.println(errMsg.toString());
                }
            }
        } catch (ModelManagementException e) {
            if (getValidate()) {
                throw new BuildException("Copied Project contains errors: " + e.getMessage());
            } else {
                System.out.println("Copied Project contains errors: " + e.getMessage());
            }
        } catch (IOException e) {
            if (getValidate()) {
                throw new BuildException("Copied Project contains IO errors: " + e.getMessage());
            } else {
                System.out.println("Copied Project contains IO errors: " + e.getMessage());
            }
        }
    }
    
    protected abstract void doModelOperation();
}
