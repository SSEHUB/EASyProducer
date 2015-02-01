package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.logging.Logger;

/**
 * Very simple logging support (was intended differently, now a simple frontend for a static Java logger).
 * 
 * @author Holger Eichelberger
 */
public class Log {

    private static final Logger LOGGER = java.util.logging.Logger.getLogger("EASyLoader");

    /**
     * Emits an error to the console.
     * 
     * @param error the error text
     */
    public static void error(String error) {
        LOGGER.severe(error);
    }
    
    /**
     * Emits an error to the console.
     * 
     * @param error the error text
     * @param exception the exception to be added
     */
    public static void error(String error, Exception exception) {
        LOGGER.severe(error + ": " + exception.getMessage());
    }

    
    /**
     * Emits a warning to the console.
     * 
     * @param warning the warning text
     */
    public static void warn(String warning) {
        LOGGER.warning(warning);
    }

    /**
     * Emits a warning to the console and adds the message of the given <code>exception</code>.
     * 
     * @param warning the warning text
     * @param exception the exception to be added
     */
    public static void warn(String warning, Exception exception) {
        LOGGER.warning(warning + ": " + exception.getMessage());
    }
    
    /**
     * Logs an information message.
     * 
     * @param msg the message to be logged
     */
    public static void info(String msg) {
        System.out.println(msg);
    }

}
