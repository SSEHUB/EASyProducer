package de.uni_hildesheim.sse.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.dslcore.ui.editors.CommonXtextEditor;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * This class extends the official xText editor in order to hook into
 * the saving mechanism. The <code>afterSave</code> event provided
 * by the xText Editor Callback is not sufficient, as it is also called
 * when a in an editor is changed from outside and pushed back into 
 * the editor via the Eclipse refresh mechanism.
 * 
 * Update: This class now extends the
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.CommonXtextEditor</code>
 * which in turn extends the official Xtext editor. This update hooks into
 * the initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data model.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
public class XtextEditor extends CommonXtextEditor {
	
    /**
     * {@inheritDoc}
     */
	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		/* 
		 * Create a new model listener in order to receive notification about updates
		 * in the underlying data model.
		 */
		if (modelListener == null) {			
			modelListener = new VarModelListener();
			modelListener.register(this);
		}
	}
	
    /**
     * {@inheritDoc}
     */
    @Override
    public void doSaveAs() {
        super.doSaveAs();
        onSave();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doSave(IProgressMonitor progressMonitor) {
        super.doSave(progressMonitor);
        onSave();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doRevertToSaved() {
        super.doRevertToSaved();
        onSave();
    }

    /**
     * Builds up the IVML model on saving the document in the editor.
     */
    private void onSave() {
        IXtextDocument doc = getDocument();
        doc.readOnly(new IUnitOfWork<VariabilityUnit, XtextResource>() {
            public VariabilityUnit exec(XtextResource resource) {
                VariabilityUnit root = (VariabilityUnit) resource.getContents().get(0);
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), IvmlBundleId.ID);
                try {
                    BasicDiagnostic diagnostic = Diagnostician.INSTANCE.createDefaultDiagnostic(root);
                    java.net.URI uri = null;
                    if (null != resource.getURI()) {
                        try {
                            uri = ModelUtility.toNetUri(resource.getURI());
                        } catch (URISyntaxException e) {
                            logger.error("error translating '" + resource.getURI() + "' while saving:" 
                                + e.getMessage());
                        }
                    }
                    TranslationResult<Project> result = ModelUtility.INSTANCE.createVarModel(root, uri, true);
                    if (0 == result.getMessageCount()) {
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        PrintWriter pOut = new PrintWriter(out);
                        ModelUtility.INSTANCE.print(result, pOut, true, false);
                        logger.info(out.toString());
                    } else {
                        ValidationUtils.processMessages(result, diagnostic);
                    }
                } catch (Exception e) {
                    logger.error("while saving IVML:" + e.getMessage());
                    e.printStackTrace();
                }
                return root;
            }
        });
    }
}
