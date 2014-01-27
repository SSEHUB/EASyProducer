package test;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.EclipseResourceInitializer;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.reasoning.core.importResolver.ReasoningImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "TestIret"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;

    /**
     * The constructor.
     */
    public Activator() {
    }

    // checkstyle: stop exception type check
    
    /**
     * {@inheritDoc}
     */
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        // shall be done by EasY at startup!!
        ReasoningImportResolver.registerAsTopResolver();
        ModelUtility.setResourceInitializer(new EclipseResourceInitializer());
        try {
            File root = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
            File metaRoot = new File(root, ".metadata");
            VarModel.INSTANCE.locations().addExcludedLocation(metaRoot);
            VarModel.INSTANCE.locations().addLocation(root, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            // unclear
        }
    }

    /**
     * {@inheritDoc}
     */
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        super.stop(context);
    }
    
    // checkstyle: resume exception type check

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }

    /**
     * Returns an image descriptor for the image file at the given plug-in
     * relative path.
     * 
     * @param path
     *            the path
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }
}
