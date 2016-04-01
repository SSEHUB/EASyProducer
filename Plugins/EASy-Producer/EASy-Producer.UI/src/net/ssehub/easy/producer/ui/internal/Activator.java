package net.ssehub.easy.producer.ui.internal;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.ui.ConfigurationEditorFactory;
import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;
import net.ssehub.easy.producer.ui.productline_editor.ConfigurationTableEditorFactory;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "net.ssehub.easy.producer.ui"; //$NON-NLS-1$

    /**
     * The shared instance.
     */
    private static Activator plugin;
    
    /**
     * The constructor.
     */
    public Activator() {
    }

    /**
     * The <code>AbstractUIPlugin</code> implementation of this <code>Plugin</code> method refreshes the plug-in
     * actions.<br/>
     * This instance is created.
     * 
     * @param context the bundle context for this plug-in
     * @exception Exception if this plug-in did not start up properly
     */
    //checkstyle: stop exception type check 
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        VilArgumentProvider.add(new VilClasspathProvider("classpath"));
        EASyPreferenceStore.loadOnStart();
        TopLevelModelAccessor.register(IvmlModelAccessor.EXTENSION, IvmlModelAccessor.INSTANCE);
        TopLevelModelAccessor.register(VilModelAccessor.EXTENSION, VilModelAccessor.INSTANCE);
        ConfigurationEditorFactory.setCreator(new ConfigurationTableEditorFactory());
    }

    /**
     * The <code>AbstractUIPlugin</code> implementation of this
     * <code>Plugin</code> method saves this plug-in's preference
     * and dialog stores and shuts down its image registry (if they are in use).
     * 
     * @param context the bundle context for this plug-in
     * @exception Exception if this plug-in did not start up properly
     */
    @Override
    public void stop(BundleContext context) throws Exception {
        plugin = null;
        TopLevelModelAccessor.unregister(IvmlModelAccessor.EXTENSION);
        TopLevelModelAccessor.unregister(VilModelAccessor.EXTENSION);
        super.stop(context);
    }

    /**
     * Returns the shared instance.
     *
     * @return the shared instance
     */
    public static Activator getDefault() {
        return plugin;
    }    
    //checkstyle: resume exception type check 

    /**
     * Returns an image descriptor for the image file at the given plug-in relative path.
     * 
     * @param path the path of the image inside <b>this plug-in</b>.
     * @return the image descriptor
     */
    public static ImageDescriptor getImageDescriptor(String path) {
        return imageDescriptorFromPlugin(PLUGIN_ID, path);
    }

}
