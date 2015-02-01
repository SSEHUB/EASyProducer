package de.uni_hildesheim.sse.dslcore.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

    // The plug-in ID
    public static final String PLUGIN_ID = "de.uni_hildesheim.sse.dslCore.ui"; //$NON-NLS-1$

    // The shared instance
    private static Activator plugin;
    
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

}
