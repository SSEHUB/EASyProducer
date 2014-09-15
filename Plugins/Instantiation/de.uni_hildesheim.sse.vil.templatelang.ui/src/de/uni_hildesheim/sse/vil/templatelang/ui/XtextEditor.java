package de.uni_hildesheim.sse.vil.templatelang.ui;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.validation.ValidationUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.vil.AbstractXTextEditor;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlBundleId;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;

/**
 * A specific editory class for VTL.
 * 
 * Update: Hooks also into the initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data model.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
public class XtextEditor extends AbstractXTextEditor<LanguageUnit> {
    
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
            modelListener = new TemplateModelListener();
            modelListener.register(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onSave() {
        IXtextDocument doc = getDocument();
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
