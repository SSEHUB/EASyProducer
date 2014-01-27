package de.uni_hildesheim.sse.easy_producer.instantiator.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;


/**
 * The activator for this class. <br/>
 * Starts and stops the whole plug-in.
 * 
 * @author El-Sharkawy
 *
 */
public class VelocityActivator implements BundleActivator {

    private static BundleContext context;

    /**
     * Getter for the context of this plug-in.
     * @return The context of this plug-in.
     */
    static BundleContext getContext() {
        return context;
    }

    // checkstyle: stop exception type check 
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        VelocityActivator.context = bundleContext;        
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        VelocityActivator.context = null;
    }

    //checkstyle: resume exception type check 
}
