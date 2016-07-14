package net.ssehub.easy.instantiation.core;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;

/**
 * Stores data about the containing OSGi bundle (static bundle without activator).
 * 
 * @author Holger Eichelberger
 */
public class Bundle {
    
    /**
     * Stores the bundle ID.
     */
    public static final String ID = "net.ssehub.easy.instantiation.core";
    
    /**
     * Returns a logger instance for logging informations of this bundle. 
     * 
     * @param loggedClass The class to log (one of this bundle).
     * @return ILogger A logger instance for this specified class.
     */
    public static EASyLogger getLogger(Class<?> loggedClass) {
        return EASyLoggerFactory.INSTANCE.getLogger(loggedClass, ID);
    }

}
