package net.ssehub.easy.producer.ui.internal;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.ui.ConfigurationEditorFactory;
import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;
import net.ssehub.easy.producer.ui.productline_editor.ConfigurationTableEditorFactory;
import net.ssehub.easy.producer.ui.project_management.EclipseProjectConfigurationDescriptor;
import net.ssehub.easy.producer.ui.project_management.JavaProjectConfigurationDescriptor;
import net.ssehub.easy.producer.ui.project_management.ProjectConfigurationRegistry;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    /**
     * The plug-in ID.
     */
    public static final String PLUGIN_ID = "net.ssehub.easy.producer.ui"; //$NON-NLS-1$

    public static final String PRE = "icons/";
    public static final String ERROR = PRE + "error.png";
    public static final String WARNING = PRE + "warning.png";
    public static final String LOGO = PRE + "logo_icon.png";
    
    /**
     * The shared instance.
     */
    private static Activator plugin;
    private static boolean started;
    private static boolean stopped;
    
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
        start();
    }

    /**
     * Start code for RCP application.
     */
    public static void start() {
        if (!started) {
            started = true;
            ProjectConfigurationRegistry.registerProjectDescriptor(new JavaProjectConfigurationDescriptor());
            ProjectConfigurationRegistry.registerProjectDescriptor(new EclipseProjectConfigurationDescriptor());
            VilArgumentProvider.add(new VilClasspathProvider("classpath"));
            EASyPreferenceStore.loadOnStart();
            TopLevelModelAccessor.register(IvmlModelAccessor.EXTENSION, IvmlModelAccessor.INSTANCE);
            TopLevelModelAccessor.register(VilModelAccessor.EXTENSION, VilModelAccessor.INSTANCE);
            ConfigurationEditorFactory.setCreator(new ConfigurationTableEditorFactory());
        }
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
        stop();
        super.stop(context);
    }
    
    /**
     * Stop code for RCP application.
     */
    public static void stop() {
        if (!stopped) {
            stopped = true;
            TopLevelModelAccessor.unregister(IvmlModelAccessor.EXTENSION);
            TopLevelModelAccessor.unregister(VilModelAccessor.EXTENSION);
        }
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
    
    /**
     * Get icon by path.
     * 
     * @param path the path to the image/icon
     * @return the image/icon
     */
    public static Image getImage(String path) {
        URL url = Activator.class.getClassLoader().getResource(path);
        return ImageDescriptor.createFromURL(url).createImage();
    }
    
    /**
     * Returns the EASy logger for the specified class.
     * 
     * @param cls the class to return the logger for
     * @return the logger
     */
    public static EASyLogger getLogger(Class<?> cls) {
        return EASyLoggerFactory.INSTANCE.getLogger(cls, PLUGIN_ID);        
    }
    
    /**
     * Returns the version of the specified bundle as specified in its manifest.
     * 
     * @return The version in the following format: <code>&lt;number&gt;.&lt;number&gt;.&lt;number&gt;</code>
     */
    public static String getVersion() {
        Bundle bundle = Platform.getBundle(PLUGIN_ID);
        return (null != bundle) ? bundle.getVersion().toString() : "<unknown version>"; 
    }

}
