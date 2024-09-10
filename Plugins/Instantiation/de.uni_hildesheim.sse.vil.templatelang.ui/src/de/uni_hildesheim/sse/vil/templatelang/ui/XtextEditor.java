package de.uni_hildesheim.sse.vil.templatelang.ui;

import java.io.Writer;
import java.net.URI;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.uni_hildesheim.sse.vil.AbstractXTextEditor;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlBundleId;
import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import net.ssehub.easy.dslCore.IResourceInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;

/**
 * A specific editor class for VTL.
 * 
 * Update: Hooks also into the initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data model.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
public class XtextEditor extends AbstractXTextEditor<LanguageUnit, Template> {
    
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
    
    @Override
    protected String getBundleId() {
        return VtlBundleId.ID;
    }

    @Override
    protected TranslationResult<Template> createModel(LanguageUnit root, URI uri) {
        return TemplateLangModelUtility.INSTANCE.createModel(root, uri, true);
    }

    @Override
    protected void updateModel(Template model, URI uri) {
        TemplateModel.INSTANCE.updateModel(model, uri);
    }

    @Override
    protected IResourceInitializer getResourceInitializer() {
        return TemplateLangModelUtility.getResourceInitializer();
    }

    @Override
    protected void print(TranslationResult<Template> result, Writer out) {
        TemplateLangModelUtility.INSTANCE.print(result, out, true, false);
    }

}