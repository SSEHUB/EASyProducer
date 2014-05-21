package de.uni_hildesheim.sse.reasoner.jess;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator for this class. <br/>
 * Starts and stops the whole plug-in.
 * 
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

    // checkstyle: stop exception type check 
    @Override
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;

//        JessR reasonerInstance = new JessR();
//        ServiceReference<?> serviceRef = context.getServiceReference(IReasonerRegistry.class.getName());
//        IReasonerRegistry registry = (IReasonerRegistry) Activator.context.getService(serviceRef);
//        registry.register(reasonerInstance);
//        System.out.println("Jess registered");
        
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }

    //checkstyle: resume exception type check 
    
    /**
     * Returns the bundle installation location.
     * 
     * @return the bundle installation location
     */
    public static final String getLocation() {
        Bundle[] bundles = context.getBundles();
        Bundle binary = null;
        for (int b = 0; null == binary && b < bundles.length; b++) {
            if ("JessReasoner.binary".equals(bundles[b].getSymbolicName())) {
                binary = bundles[b];
            }
        }
        String result = null;
        if (null != binary) {
            result = binary.getLocation();
        }
        return result;
    }
}
