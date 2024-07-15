package de.uni_hildesheim.sse.vil.buildlang.ui;

import java.net.URI;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.IModelReloadListener;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;

/**
 * A <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template</code>
 * listener, which receives notifications about changes of the template model and then forces
 * an update of the <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance that
 * is used to edit the corresponding document in which the template is defined.
 * 
 * <b>Note</b> that receiving a change notification will also trigger updates of other running editors
 * via the <code>de.uni_hildesheim.sse.dslcore.ui.editors.ModelChangeNotifier</code>.
 * 
 * @author kroeher
 *
 */
public class BuildlangModelListener extends AbstractModelChangeListener implements IModelReloadListener<Script>, IModelListener<Script>{

    /**
     * Constructs a model listener that updates a registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the underlying
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template</code>
     * instance, which is edited in the registered editor, changes.
     */
    public BuildlangModelListener() {
        isListening = false;
    }
    
    @Override
    public void notifyReplaced(Script oldModel, Script newModel) {
        //System.out.println("[TemplateModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }

    @Override
    public void notifyReloadFailed(Script model) {
        //System.out.println("[TemplateModelListener] Notify reloade failed: " + this);
        updateRegisteredEditor();
    }
    
    
    @Override
    public void unregister() {
        if (xtextEditor != null && underlyingModel != null) {
            if (underlyingModel instanceof Script) {
                Script vilScript = (Script) underlyingModel;
                BuildModel.INSTANCE.events().removeModelListener(vilScript, this);
                BuildModel.INSTANCE.events().removeModelReloadListener(vilScript, this);
            }
        }
    }
    
    @Override
    protected boolean registerToUnderlyingModel(IModel underlyingModel) {
        boolean registerSuccessful = false;
        if (underlyingModel instanceof Script) {          
            Script vilScript = (Script) underlyingModel;
            BuildModel.INSTANCE.events().addModelListener(vilScript, this);
            BuildModel.INSTANCE.events().addReloadListener(vilScript, this);
            registerSuccessful = true;
            //System.out.println("[TemplateModelListener] Registration successful: " + this);
        }
        return registerSuccessful;
    }
    
    @Override
    protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
        IModel vilScript = null;
        ModelInfo<Script> scriptModelInfo = BuildModel.INSTANCE.availableModels().getInfo(modelFileUri);
        if (scriptModelInfo != null && scriptModelInfo.getResolved() != null) {
            vilScript = scriptModelInfo.getResolved();
        } else {
            //System.out.println("[TemplateModelListener] Template not resolved!");
            if (xtextDocument != null && forceBuild) {
                //System.out.println("Build template model!");
                buildModel(xtextDocument);
                // Do not force the build a second time!
                vilScript = getUnderlyingModel(modelFileUri, false);
            } /*else {
                System.out.println("[TemplateModelListener] VTL document is null or no build forced!");
            }*/
        }
        return vilScript;
    }
    
}
