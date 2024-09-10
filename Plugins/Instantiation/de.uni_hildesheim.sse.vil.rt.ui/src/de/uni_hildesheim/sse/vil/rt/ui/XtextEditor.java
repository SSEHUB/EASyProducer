package de.uni_hildesheim.sse.vil.rt.ui;

import java.io.Writer;
import java.net.URI;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.uni_hildesheim.sse.vil.AbstractXTextEditor;
import de.uni_hildesheim.sse.vil.rt.RtVilBundleId;
import de.uni_hildesheim.sse.vil.rt.RtVilModelUtility;
import de.uni_hildesheim.sse.vil.rt.rtVil.ImplementationUnit;
import net.ssehub.easy.dslCore.IResourceInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.RtVilModel;
import net.ssehub.easy.instantiation.rt.core.model.rtVil.Script;

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
            modelListener = new RtVilModelListener();
            modelListener.register(this);
        }
    }

    @Override
    protected String getBundleId() {
        return RtVilBundleId.ID;
    }

    @Override
    protected TranslationResult<Script> createModel(ImplementationUnit root, URI uri) {
        return RtVilModelUtility.INSTANCE.createRtModel(root, uri, true);
    }

    @Override
    protected void updateModel(Script model, URI uri) {
        RtVilModel.INSTANCE.updateModel(model, uri);
    }

    @Override
    protected IResourceInitializer getResourceInitializer() {
        return RtVilModelUtility.getResourceInitializer();
    }

    @Override
    protected void print(TranslationResult<Script> result, Writer out) {
        RtVilModelUtility.INSTANCE.print(result, out, true, false);
    }

}
