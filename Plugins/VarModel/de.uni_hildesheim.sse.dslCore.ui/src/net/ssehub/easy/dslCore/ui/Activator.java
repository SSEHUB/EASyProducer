package net.ssehub.easy.dslCore.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "net.ssehub.easy.dslCore.ui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;
    private static ModelReloader modelReloader;
    
    /**
     * Handles a model reload requests, e.g., during builds.
     * 
     * @author Holger Eichelberger
     */
    public interface ModelReloader {

        /**
         * Handles a complete model reload process.
         * 
         * @param project the project to reload
         */
        public void reload(IProject project);
        
    }
    
    /**
     * The constructor.
     */
    public Activator() {
    }

    // checkstyle: stop exception type check
    
    @Override
    public void start(BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
    }

    @Override
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
     * Changes the model reloader, an instance that is consulted when the entire model
     * shall be re-loaded during a build process.
     * 
     * @param reloader the reloader, may be <b>null</b> for none
     */
    public static void setModelReloader(ModelReloader reloader) {
        modelReloader = reloader;
    }
    
    /**
     * Returns the model reloader, an instance that is consulted when the entire model
     * shall be re-loaded during a build process.
     * 
     * @return the reloader, may be <b>null</b> for none
     */
    public static ModelReloader getModelReloader() {
        return modelReloader;
    }

}
