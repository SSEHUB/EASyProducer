package de.uni_hildesheim.sse.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.VilBundleId;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;
import de.uni_hildesheim.sse.utils.modelManagement.IModelReloadListener;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit;

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
public class BuildModelListener extends AbstractModelChangeListener implements IModelReloadListener<Script>, IModelListener<Script> {

    /**
     * Constructs a build model listener that updates a registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance if the underlying
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script</code>
     * instance, which is edited in the registered editor, changes.
     */
    public BuildModelListener() {
        isListening = false;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyReplaced(Script oldModel, Script newModel) {
        //System.out.println("[BuildModelListener] Notify replaced: " + this);
        updateRegisteredEditor();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void notifyReloadFailed(Script model) {
        //System.out.println("[BuildModelListener] Notify reload failed: " + this);
        updateRegisteredEditor();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void unregister() {
        if (xtextEditor != null && underlyingModel != null) {
            if (underlyingModel instanceof Script) {
                Script script = (Script) underlyingModel;
                BuildModel.INSTANCE.events().removeModelListener(script, this);
                BuildModel.INSTANCE.events().removeModelReloadListener(script, this);
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
            Script vilScript = (Script) underlyingModel;
            BuildModel.INSTANCE.events().addModelListener(vilScript, this);
            BuildModel.INSTANCE.events().addReloadListener(vilScript, this);
            registerSuccessful = true;
            //System.out.println("[BuildModelListener] Registration successful: " + this);
        }
        return registerSuccessful;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    protected IModel getUnderlyingModel(URI modelFileUri, boolean forceBuild) {
        IModel vilScript = null;
        ModelInfo<Script> scriptModelInfo = BuildModel.INSTANCE.availableModels().getInfo(modelFileUri);
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
    
    /**
     * Parses the <code>de.uni_hildesheim.sse.vilBuildLanguage.ImplementationUnit</code> which is defined in
     * the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance.
     * 
     * <b>Important:</b> Use this method if and only if the desired
     * <code>de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script</code> instance is
     * not available via <code>BuildModel.INSTANCE.availableModels()</code>.
     * 
     * <b>Note:</b> The code of this method is copied from <code>de.uni_hildesheim.sse.ui.XtextEditor.onSave()</code>.
     * 
     * @param doc the <code>org.eclipse.xtext.ui.editor.model.IXtextDocument</code> of the registered
     * <code>de.uni_hildesheim.sse.ui.XtextEditor</code> instance
     */
    private void buildModel(IXtextDocument doc) {
        if (doc != null) {
            doc.readOnly(new IUnitOfWork<ImplementationUnit, XtextResource>() {
                public ImplementationUnit exec(XtextResource resource) {
                    ImplementationUnit root = (ImplementationUnit) resource.getContents().get(0);
                    EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), VilBundleId.ID);
                    try {
                        BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic(root);
                        java.net.URI uri = null;
                        if (null != resource.getURI()) {
                            try {
                                uri = BuildLangModelUtility.toNetUri(resource.getURI());
                            } catch (URISyntaxException e) {
                                logger.error("error translating '" + resource.getURI() + "' while saving:" 
                                    + e.getMessage());
                            }
                        }
                        TranslationResult<Script> result = BuildLangModelUtility.INSTANCE.createBuildModel(root, uri, true);
                        if (0 == result.getMessageCount()) {
                            ByteArrayOutputStream out = new ByteArrayOutputStream();
                            PrintWriter pOut = new PrintWriter(out);
                            BuildLangModelUtility.INSTANCE.print(result, pOut, true, false);
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
