package de.uni_hildesheim.sse.easy.ant.pruning;

import java.io.IOException;

import org.apache.tools.ant.BuildException;

import de.uni_hildesheim.sse.easy.ant.AbstractModelTask;
import eu.qualimaster.easy.extension.modelop.ModelModifier;
import eu.qualimaster.easy.extension.modelop.ModelModifier.QMPlatformProvider;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Prunes the QM model for adaptation (removes frozen elements, which are not needed for adaption).
 * @author El-Sharkawy
 *
 */
public class AdaptationPruning extends AbstractModelTask implements QMPlatformProvider {

    private String validationError = null;
    
    /**
     * Constructor for the ant task.
     */
    public AdaptationPruning() {
        super();
    }
    
    /**
     * Constructor for the ant task.
     */
    public AdaptationPruning(String orgFolder, String cpyfolder, String mainProject) {
        super();
        setSourceFolder(orgFolder);
        setDestinationFolder(cpyfolder);
        setMainProject(mainProject);
        setAllowDestDeletion(true);
    }
    
    @Override
    protected void doModelOperation() {
        Project qmModel = null;
        try {
            qmModel = loadProject(getSourceFolder(), getMainProject());
        } catch (ModelManagementException e) {
            throw new BuildException(e);
        } catch (IOException e) {
            throw new BuildException(e);
        }
        
        // Locations needed for modifier
        try {
            addOrRemoveLocation(BuildModel.INSTANCE, getSourceFolder(), true);
            addOrRemoveLocation(TemplateModel.INSTANCE, getSourceFolder(), true);
            addOrRemoveLocation(RtVilModel.INSTANCE, getSourceFolder(), true);
        } catch (ModelManagementException e) {
            throw new BuildException(e);
        }
        ModelModifier modifier = new ModelModifier(getDestinationFolder(), qmModel, getSourceFolder(), this);
        modifier.createExecutor();
        try {
            addOrRemoveLocation(BuildModel.INSTANCE, getSourceFolder(), false);
            addOrRemoveLocation(TemplateModel.INSTANCE, getSourceFolder(), false);
            addOrRemoveLocation(RtVilModel.INSTANCE, getSourceFolder(), false);
        } catch (ModelManagementException e) {
            // Ignore exception and continue
        }
        
        if (null != validationError) {
            throw new BuildException(validationError);
        }
    }

    @Override
    public void reason(Configuration arg0) {
        // TODO SE: Currently not supported, model will only be validated using the validation visitor,
        // see parent class.
    }

    @Override
    public void showExceptionDialog(String title, Exception exc) {
        validationError = title + ": " + exc.getMessage();      
    }

}
