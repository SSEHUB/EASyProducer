package de.uni_hildesheim.sse.vil.templatelang.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;
import de.uni_hildesheim.sse.utils.modelManagement.IModelReloadListener;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlBundleId;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;

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
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyReplaced(Template oldModel, Template newModel) {
        //System.out.println("[TemplateModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyReloadFailed(Template model) {
        //System.out.println("[TemplateModelListener] Notify reloade failed: " + this);
        updateRegisteredEditor();
    }
    
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * {@inheritDoc}
     */
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
    
    /**
     * Parses the <code>de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit</code> which is defined
     * in the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance.
     * 
     * <b>Important:</b> Use this method if and only if the desired
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template</code> instance is
     * not available via <code>TemplateModel.INSTANCE.availableModels()</code>.
     * 
     * <b>Note:</b> The code of this method is copied from <code>de.uni_hildesheim.sse.vil.templatelang.ui.XtextEditor</code>.
     * 
     * @param doc the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance
     */
    private void buildModel(IXtextDocument doc) {
        if (doc != null) {
            doc.readOnly(new IUnitOfWork<LanguageUnit, XtextResource>() {
                public LanguageUnit exec(XtextResource resource) {
                    LanguageUnit root = (LanguageUnit) resource.getContents().get(0);
                    EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VtlBundleId.ID);
                    try {
                        BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic(root);
                        java.net.URI uri = null;
                        if (null != resource.getURI()) {
                            try {
                                uri = TemplateLangModelUtility.toNetUri(resource.getURI());
                            } catch (URISyntaxException e) {
                                logger.error("error translating '" + resource.getURI() + "' while saving:" 
                                    + e.getMessage());
                            }
                        }
                        TranslationResult<Template> result = TemplateLangModelUtility.INSTANCE.createModel(root, uri, true);
                        if (0 == result.getMessageCount()) {
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            PrintWriter pOut = new PrintWriter(out);
                            TemplateLangModelUtility.INSTANCE.print(result, pOut, true, false);
                            logger.info(out.toString());
                        } else {
                            ValidationUtils.processMessages(result, diagnostic);
                        }
                    } catch (Exception e) {
                        logger.exception(e);
                    }
                    return root;
                }
            }); 
        }
    }
}
