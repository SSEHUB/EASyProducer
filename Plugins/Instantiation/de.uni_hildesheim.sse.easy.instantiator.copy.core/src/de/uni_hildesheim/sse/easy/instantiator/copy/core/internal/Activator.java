package de.uni_hildesheim.sse.easy.instantiator.copy.core.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator for this plug-in, controlling the lifecycle.
 * @author El-Sharkawy
 *
 */
public class Activator implements BundleActivator {

    private static BundleContext context;

    /**
     * Getter for the context of this plug-in.
     * @return The context of this plug-in.
     */
    static BundleContext getContext() {
        return context;
    }

    @Override
    // checkstyle: stop exception type check
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
 
    // checkstyle: stop exception type check
}
