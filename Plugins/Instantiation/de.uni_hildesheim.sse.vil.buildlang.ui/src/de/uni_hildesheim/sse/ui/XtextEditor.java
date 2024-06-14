package de.uni_hildesheim.sse.ui;

import java.io.Writer;
import java.net.URI;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.VilBundleId;
import de.uni_hildesheim.sse.vil.AbstractXTextEditor;
import de.uni_hildesheim.sse.vil.buildlang.vilBuildLanguage.ImplementationUnit;
import net.ssehub.easy.dslCore.IResourceInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;

/**
 * A specific editor class for VIL.
 * 
 * Update: Hooks also into the initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data model.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
public class XtextEditor extends AbstractXTextEditor<ImplementationUnit, Script> {
        
    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        /* 
         * Create a new model listener in order to receive notification about updates
         * in the underlying data model.
         */
        if (modelListener == null) {            
            modelListener = new BuildModelListener();
            modelListener.register(this);
        }
    }

    @Override
    protected String getBundleId() {
        return VilBundleId.ID;
    }

    @Override
    protected TranslationResult<Script> createModel(ImplementationUnit root, URI uri) {
        return BuildLangModelUtility.INSTANCE.createBuildModel(root, uri, true);
    }

    @Override
    protected IResourceInitializer getResourceInitializer() {
        return BuildLangModelUtility.getResourceInitializer();
    }

    @Override
    protected void print(TranslationResult<Script> result, Writer out) {
        BuildLangModelUtility.INSTANCE.print(result, out, true, false);
    }

}
