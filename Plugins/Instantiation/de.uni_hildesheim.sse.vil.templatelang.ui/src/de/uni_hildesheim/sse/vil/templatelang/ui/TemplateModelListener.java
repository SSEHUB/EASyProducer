package de.uni_hildesheim.sse.vil.templatelang.ui;

import java.net.URI;

import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.IModelReloadListener;
import net.ssehub.easy.basics.modelManagement.ModelInfo;

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
public class TemplateModelListener extends AbstractModelChangeListener implements IModelReloadListener<Template>, IModelListener<Template>{

    /**
     * Constructs a template model listener that updates a registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the underlying
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template</code>
     * instance, which is edited in the registered editor, changes.
     */
    public TemplateModelListener() {
        isListening = false;
    }
    
    @Override
    public void notifyReplaced(Template oldModel, Template newModel) {
        //System.out.println("[TemplateModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }

    @Override
    public void notifyReloadFailed(Template model) {
        //System.out.println("[TemplateModelListener] Notify reloade failed: " + this);
        updateRegisteredEditor();
    }
    
    
    @Override
    public void unregister() {
        if (xtextEditor != null && underlyingModel != null) {
            if (underlyingModel instanceof Template) {
                Template template = (Template) underlyingModel;
                TemplateModel.INSTANCE.events().removeModelListener(template, this);
                TemplateModel.INSTANCE.events().removeModelReloadListener(template, this);
            }
        }
    }
    
    @Override
    protected boolean registerToUnderlyingModel(IModel underlyingModel) {
        boolean registerSuccessful = false;
        if (underlyingModel != null) {          
            Template vilTemplate = (Template) underlyingModel;
            TemplateModel.INSTANCE.events().addModelListener(vilTemplate, this);
            TemplateModel.INSTANCE.events().addReloadListener(vilTemplate, this);
            registerSuccessful = true;
            //System.out.println("[TemplateModelListener] Registration successful: " + this);
        }
        return registerSuccessful;
    }
    
    @Override
    protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
        IModel vilTemplate = null;
        ModelInfo<Template> scriptModelInfo = TemplateModel.INSTANCE.availableModels().getInfo(modelFileUri);
        if (scriptModelInfo != null && scriptModelInfo.getResolved() != null) {
            vilTemplate = scriptModelInfo.getResolved();
        } else {
            //System.out.println("[TemplateModelListener] Template not resolved!");
            if (xtextDocument != null && forceBuild) {
                //System.out.println("Build template model!");
                buildModel(xtextDocument);
                // Do not force the build a second time!
                vilTemplate = getUnderlyingModel(modelFileUri, false);
            } /*else {
                System.out.println("[TemplateModelListener] VTL document is null or no build forced!");
            }*/
        }
        return vilTemplate;
    }
    
}
