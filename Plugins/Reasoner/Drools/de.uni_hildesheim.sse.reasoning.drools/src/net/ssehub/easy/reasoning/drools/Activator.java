package net.ssehub.easy.reasoning.drools;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;

/**
 * The activator for this class. <br/>
 * Starts and stops the whole plug-in.
 * 
 * @author Phani Saripalli
 *
 */
public class Activator implements BundleActivator {

    public static final String BUNDLE_ID = "net.ssehub.easy.reasoning.drools";
    
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
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), BUNDLE_ID);
        logger.info("Drools started ");
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
 // checkstyle: resume exception type check 
}
