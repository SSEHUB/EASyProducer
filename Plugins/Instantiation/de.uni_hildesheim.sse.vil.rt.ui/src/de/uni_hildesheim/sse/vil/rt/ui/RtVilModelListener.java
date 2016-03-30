package de.uni_hildesheim.sse.vil.rt.ui;

import java.net.URI;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.IModelReloadListener;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;

/**
 * A <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script</code>
 * listener, which receives notifications about changes of the build model and then forces
 * an update of the <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance that
 * is used to edit the corresponding document in which the script is defined.
 * 
 * <b>Note</b> that receiving a change notification will also trigger updates of other running editors
 * via the <code>de.uni_hildesheim.sse.dslcore.ui.editors.ModelChangeNotifier</code>.
 * 
 * @author kroeher
 *
 */
public class RtVilModelListener extends AbstractModelChangeListener implements IModelReloadListener<Script>, IModelListener<Script> {

    /**
     * Constructs a build model listener that updates a registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the underlying
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script</code>
     * instance, which is edited in the registered editor, changes.
     */
    public RtVilModelListener() {
        isListening = false;
    }
    
    @Override
    public void notifyReplaced(Script oldModel, Script newModel) {
        //System.out.println("[BuildModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }
    
    @Override
    public void notifyReloadFailed(Script model) {
        //System.out.println("[BuildModelListener] Notify reload failed: " + this);
        updateRegisteredEditor();
    }
    
    @Override
    public void unregister() {
        if (xtextEditor != null && underlyingModel != null) {
            if (underlyingModel instanceof Script) {
                Script script = (Script) underlyingModel;
                RtVilModel.INSTANCE.events().removeModelListener(script, this);
                RtVilModel.INSTANCE.events().removeModelReloadListener(script, this);
            }
        }
    }
    
    @Override
    protected boolean registerToUnderlyingModel(IModel underlyingModel) {
        boolean registerSuccessful = false;
        if (underlyingModel != null) {          
            Script vilScript = (Script) underlyingModel;
            RtVilModel.INSTANCE.events().addModelListener(vilScript, this);
            RtVilModel.INSTANCE.events().addReloadListener(vilScript, this);
            registerSuccessful = true;
            //System.out.println("[BuildModelListener] Registration successful: " + this);
        }
        return registerSuccessful;
    }
    
    @Override
    protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
        IModel vilScript = null;
        ModelInfo<Script> scriptModelInfo = RtVilModel.INSTANCE.availableModels().getInfo(modelFileUri);
        if (scriptModelInfo != null && scriptModelInfo.getResolved() != null) {
            vilScript = scriptModelInfo.getResolved();
            //System.out.println("[BuildModelListener] BuildModel found: " + vilScript);
        } else {
            //System.out.println("[BuildModelListener] Script not resolved!");
            if (xtextDocument != null && forceBuild) {
                //System.out.println("[BuildModelListener] Build script model!");
                buildModel(xtextDocument);
                // Do not force the build a second time!
                vilScript = getUnderlyingModel(modelFileUri, false);
            } /*else {
                System.out.println("[BuildModelListener] VIL document is null or no build forced!");
            }*/
        }
        return vilScript;
    }
    
}
