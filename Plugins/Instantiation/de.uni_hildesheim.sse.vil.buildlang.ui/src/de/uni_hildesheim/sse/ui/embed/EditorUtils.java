package de.uni_hildesheim.sse.ui.embed;

import java.io.File;
import java.net.URI;

import org.eclipse.swt.widgets.Composite;
import org.osgi.service.component.ComponentContext;

import com.google.inject.Injector;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.dslcore.ui.EditorEmbedderFactory;
import de.uni_hildesheim.sse.dslcore.ui.EditorEmbedderFactory.IEditorCreator;
import de.uni_hildesheim.sse.dslcore.ui.editors.AbstractModelChangeListener;
import de.uni_hildesheim.sse.dslcore.ui.editors.EmbeddingHelper;
import de.uni_hildesheim.sse.dslcore.ui.editors.IEmbeddedEditor;
import de.uni_hildesheim.sse.dslcore.ui.editors.ModelEditorConfigurer;
import de.uni_hildesheim.sse.dslcore.ui.editors.ModelEditorConfigurer.IHeader;
import de.uni_hildesheim.sse.dslcore.ui.editors.ModelEditorConfigurer.IModelEditorConfigurer;
import de.uni_hildesheim.sse.ui.BuildModelListener;
import de.uni_hildesheim.sse.ui.internal.VilBuildLanguageActivator;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Provides editor utility methods.
 * 
 * @author Holger Eichelberger
 */
public class EditorUtils implements IEditorCreator, IModelEditorConfigurer {

    public static final String EXTENSION = BuildLangModelUtility.INSTANCE.getExtension();

    /**
     * Creates an instance (public constructor required by OSGI-DS).
     */
    public EditorUtils() {
    }
    
    /**
     * Embeds an VIL editor for the given resource into the given <code>parent</code>.
     * 
     * @param file the file representing the resource
     * @param parent the parent UI component
     * @return the embedded editor (or <b>null</b> if embedding failed)
     */
    public static IEmbeddedEditor embedVilEditor(final java.net.URI file, Composite parent) {
        VilBuildLanguageActivator activator = VilBuildLanguageActivator.getInstance();
        Injector injector = activator.getInjector(VilBuildLanguageActivator.DE_UNI_HILDESHEIM_SSE_VILBUILDLANGUAGE);
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
        return embedVilEditor(resourceURI, composite);
    }

    @Override
    public String getEditorTitle(boolean editable) {
        return "Variability Instantiation " + (editable ? "Editor" : "Viewer");
    }

    @Override
    public String getPageTitle(boolean editable) {
        return "Instantiation Model";
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public int getOrdinal() {
        return 1;
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
        return new BuildModelListener();
    }

}
