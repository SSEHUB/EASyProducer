package de.uni_hildesheim.sse.ui;

import java.io.Writer;
import java.net.URI;

import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;

import de.uni_hildesheim.sse.IvmlBundleId;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.ivml.VariabilityUnit;
import net.ssehub.easy.dslCore.IResourceInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.ui.editors.CommonXtextEditor;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * This class extends the official xText editor in order to hook into the saving
 * mechanism. The <code>afterSave</code> event provided by the xText Editor
 * Callback is not sufficient, as it is also called when a in an editor is
 * changed from outside and pushed back into the editor via the Eclipse refresh
 * mechanism.
 * 
 * Update: This class now extends the
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.CommonXtextEditor</code> which
 * in turn extends the official Xtext editor. This update hooks into the
 * initialization- and dispose-mechanism in order to register an
 * <code>de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener</code>
 * to this editor and receive notifications about changes in the underlying data
 * model.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
public class XtextEditor extends CommonXtextEditor<VariabilityUnit, Project> {

    @Override
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        super.init(site, input);
        /*
         * Create a new model listener in order to receive notification about
         * updates in the underlying data model.
         */
        if (modelListener == null) {
            modelListener = new VarModelListener();
            modelListener.register(this);
        }
    }
 
    @Override
    protected String getBundleId() {
        return IvmlBundleId.ID;
    }

    @Override
    protected TranslationResult<Project> createModel(VariabilityUnit root, URI uri) {        
        return ModelUtility.INSTANCE.createVarModel(root, uri, true);
    }

    @Override
    protected void updateModel(Project model, URI uri) {
        VarModel.INSTANCE.updateModel(model, uri);
    }

    @Override
    protected IResourceInitializer getResourceInitializer() {
        return ModelUtility.getResourceInitializer();
    }

    @Override
    protected void print(TranslationResult<Project> result, Writer out) {
        ModelUtility.INSTANCE.print(result, out, true, false);
    }
}