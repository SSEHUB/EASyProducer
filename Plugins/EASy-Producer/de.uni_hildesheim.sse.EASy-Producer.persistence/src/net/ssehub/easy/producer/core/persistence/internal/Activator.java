package net.ssehub.easy.producer.core.persistence.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.producer.core.persistence.standard.EASyInitializer;



/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator implements BundleActivator {

    // The plug-in ID
    public static final String PLUGIN_ID = "net.ssehub.easy.producer.core";
    
    private static BundleContext context;

    /**
     * The constructor.
     */
    public Activator() {
        EASyInitializer.setInitializer();       
        TracerFactory.setInstance(ConsoleTracerFactory.INSTANCE);
    }

    /**
     * Getter for the context of this plug-in.
     * @return The context of this plug-in.
     */
    static BundleContext getContext() {
        return context;
    }
    
    //checkstyle: stop exception type check
    
    /**
     * {@inheritDoc}
     */
    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
    }

    /**
     * {@inheritDoc}
     */
    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
    }
    //checkstyle: resume exception type check
    
    /**
     * Simplification of {@link EASyLoggerFactory#getLogger(Class, String)} to retrieve a logger used within
     * this plug-in.
     * @param clazz The class to log.
     * @return A logger instance for this specified class and plug-in.
     */
    public static EASyLogger getLogger(Class<?> clazz) {
        return EASyLoggerFactory.INSTANCE.getLogger(clazz, PLUGIN_ID);
    }
}
