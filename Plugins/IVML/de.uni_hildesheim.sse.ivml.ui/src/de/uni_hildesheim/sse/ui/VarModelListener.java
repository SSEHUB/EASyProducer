package de.uni_hildesheim.sse.ui;

import java.net.URI;

import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.IModelReloadListener;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * A <code>de.uni_hildesheim.sse.model.varModel.Project</code> listener, which
 * receives notifications about changes of the variability model and then forces
 * an update of the <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance
 * that is used to edit the corresponding document in which the variability
 * model is defined.
 * 
 * <b>Note</b> that receiving a change notification will also trigger updates of
 * other running editors via the
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.ModelChangeNotifier</code>.
 * 
 * @author kroeher
 * 
 */
public class VarModelListener extends AbstractModelChangeListener implements IModelReloadListener<Project>,
                IModelListener<Project> {

    /**
     * Constructs a variability model listener that updates a registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the
     * underlying <code>de.uni_hildesheim.sse.model.varModel.Project</code>
     * instance, which is edited in the registered editor, changes.
     */
    public VarModelListener() {
        isListening = false;
    }

    @Override
    public void notifyReplaced(Project oldModel, Project newModel) {
        // System.out.println("[VarModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }

    @Override
    public void notifyReloadFailed(Project model) {
        // System.out.println("[VarModelListener] Notify reload failed: " +
        // this);
        updateRegisteredEditor();
    }

    @Override
    public void unregister() {
        if (xtextEditor != null && underlyingModel != null) {
            if (underlyingModel instanceof Project) {
                Project varModel = (Project) underlyingModel;
                VarModel.INSTANCE.events().removeModelListener(varModel, this);
                VarModel.INSTANCE.events().removeModelReloadListener(varModel, this);
            }
        }
    }

    @Override
    protected boolean registerToUnderlyingModel(IModel underlyingModel) {
        boolean registerSuccessful = false;
        if (underlyingModel != null) {
            Project varModel = (Project) underlyingModel;
            VarModel.INSTANCE.events().addModelListener(varModel, this);
            VarModel.INSTANCE.events().addReloadListener(varModel, this);
            registerSuccessful = true;
            // System.out.println("[VarModelListener] Registration successful: "
            // + this);
        }
        return registerSuccessful;
    }

    @Override
    protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
        IModel variabilityModel = null;
        ModelInfo<Project> projectModelInfo = VarModel.INSTANCE.availableModels().getInfo(modelFileUri);
        if (projectModelInfo != null && projectModelInfo.getResolved() != null) {
            variabilityModel = projectModelInfo.getResolved();
            // System.out.println("[VarModelListener] VarModel found: " +
            // variabilityModel);
        } else {
            // System.out.println("[VarModelListener] Model not resolved!");
            if (xtextDocument != null && forceBuild) {
                // System.out.println("[VarModelListener] Build variability model!");
                buildModel(xtextDocument);
                // Do not force the build a second time!
                variabilityModel = getUnderlyingModel(modelFileUri, false);
            } /*
               * else { System.out.println(
               * "[VarModelListener] IVML document is null or no build forced!"
               * ); }
               */
        }
        return variabilityModel;
    }
    
}
