package de.uni_hildesheim.sse.reasoning.drools;

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
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(this.getClass(),
            "de.uni_hildesheim.sse.reasoning.drools");
        logger.info("Drools started ");
    }
    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
 // checkstyle: resume exception type check 
}
