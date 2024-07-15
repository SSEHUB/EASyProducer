package de.uni_hildesheim.sse.ui;

import java.io.File;
import java.net.URI;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.osgi.framework.BundleContext;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.ivml.ui.internal.IvmlActivator;
import de.uni_hildesheim.sse.ui.embed.EditorUtils;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory;
import net.ssehub.easy.dslCore.ui.EditorEmbedderFactory.IEditorCreator;
import net.ssehub.easy.dslCore.ui.editors.AbstractModelChangeListener;
import net.ssehub.easy.dslCore.ui.editors.IEmbeddedEditor;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IHeader;
import net.ssehub.easy.dslCore.ui.editors.ModelEditorConfigurer.IModelEditorConfigurer;
import net.ssehub.easy.varModel.confModel.Configuration;

/**
 * Extends the generated activator.
 * 
 * @author Holger Eichelberger
 */
public class Activator extends IvmlActivator implements IEditorCreator, IModelEditorConfigurer {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.uni_hildesheim.sse.ivml.ui"; //$NON-NLS-1$
    public static final String EXTENSION = ModelUtility.INSTANCE.getExtension();

    public static Activator getInstance() {
        return (Activator) IvmlActivator.getInstance();
    }
    
    /**
     * Returns an image descriptor for the image file at the given
     * plug-in relative path
     *
     * @param path the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
    
    @Override
    public void start(BundleContext context) throws Exception {
        EditorEmbedderFactory.register(EXTENSION, this);
        if (ModelEditorConfigurer.EMBED_DEFAULT_EASY_EDITORS) {
            ModelEditorConfigurer.register(this);
        }
        super.start(context);
    }
    
    @Override
    public void stop(BundleContext context) throws Exception {
        EditorEmbedderFactory.unregister(EXTENSION);
        if (ModelEditorConfigurer.EMBED_DEFAULT_EASY_EDITORS) {
            ModelEditorConfigurer.unregister(this);
        }
        super.stop(context);
    }

    @Override
    public IEmbeddedEditor embedEditor(URI resourceURI, Composite composite) {
        return EditorUtils.embedIvmlEditor(resourceURI, composite);
    }

    @Override
    public String getEditorTitle(boolean editable) {
        return "Variability Model " + (editable ? "Editor" : "Viewer");
    }

    @Override
    public String getPageTitle(boolean editable) {
        return "Variability Model";
    }

    @Override
    public String getExtension() {
        return EXTENSION;
    }

    @Override
    public int getOrdinal() {
        return 0;
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
        return new VarModelListener();
    }

}
