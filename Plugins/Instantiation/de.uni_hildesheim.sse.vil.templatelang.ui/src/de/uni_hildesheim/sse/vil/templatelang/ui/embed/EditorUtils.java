package de.uni_hildesheim.sse.vil.templatelang.ui.embed;

import java.io.File;
import java.net.URI;

import org.eclipse.swt.widgets.Composite;
import org.osgi.service.component.ComponentContext;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.ui.TemplateModelListener;
import de.uni_hildesheim.sse.vil.templatelang.ui.internal.TemplateLangActivator;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory.IEditorCreator;
import net.ssehub.easy.dslCore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.dslCore.ui.editors.EmbeddingHelper;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IHeader;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IModelEditorConfigurer;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Provides editor utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EditorUtils implements IEditorCreator, IModelEditorConfigurer {

    public static final String EXTENSION = TemplateLangModelUtility.INSTANCE.getExtension();
    
    /**
     * Creates an instance (public constructor required by OSGI-DS).
     */
    public EditorUtils() {
    }
    
    /**
     * Embeds an VTL editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @param the editor viewer
     */
    public static IEmbeddedEditor embedVtlEditor(final java.net.URI file, Composite parent) {
        TemplateLangActivator activator = TemplateLangActivator.getInstance();
        Injector injector = activator.getInjector(
            TemplateLangActivator.DE_UNI_HILDESHEIM_SSE_VIL_TEMPLATELANG_TEMPLATELANG);
        return EmbeddingHelper.embedEditor(file, parent, injector);
    }

    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        EditorEmbedderFactory.register(EXTENSION, this);
        if (ModelEditorConfigurer.EMBED_DEFAULT_EASY_EDITORS) {
            ModelEditorConfigurer.register(this);
        }
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        EditorEmbedderFactory.unregister(EXTENSION);
        if (ModelEditorConfigurer.EMBED_DEFAULT_EASY_EDITORS) {
            ModelEditorConfigurer.unregister(this);
        }
    }

    @Override
    public IEmbeddedEditor embedEditor(URI resourceURI, Composite composite) {
        return embedVtlEditor(resourceURI, composite);
    }

    @Override
    public String getEditorTitle(boolean editable) {
        return "Instantiation Template " + (editable ? "Editor" : "Viewer");
    }

    @Override
    public String getPageTitle(boolean editable) {
        return "Instantiation Template";
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public int getOrdinal() {
        return 2;
    }

    @Override
    public boolean hasHeader() {
        return false;
    }

    @Override
    public IHeader createHeader(Composite parent, Configuration config, File base, ModelInfo<?> info) {
        return null;
    }

    @Override
    public AbstractModelChangeListener getModelChangeListener() {
        return new TemplateModelListener();
    }

}
