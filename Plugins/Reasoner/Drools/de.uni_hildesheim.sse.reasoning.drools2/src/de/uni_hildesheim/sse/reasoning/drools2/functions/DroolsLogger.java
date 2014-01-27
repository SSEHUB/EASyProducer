package de.uni_hildesheim.sse.reasoning.drools2.functions;


import de.uni_hildesheim.sse.reasoning.drools2.DroolsReasonerDescriptor;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Adapter/Wrapper for drools to enable logging via static methods.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class DroolsLogger {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(DroolsLogger.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
    /**
     * Log an INFO message.
     * <p>
     * If the logger is currently enabled for the INFO message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     */
    public static void info(String msg) {
        LOGGER.info(msg);
    }
    
    /**
     * Log an DEBUG message.
     * <p>
     * If the logger is currently enabled for the DEBUG message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     */
    public static void debug(String msg) {
        LOGGER.debug(msg);
    }
    
    /**
     * Log an WARN message.
     * <p>
     * If the logger is currently enabled for the WARN message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     */
    public static void warn(String msg) {
        LOGGER.warn(msg);
    }
    
    /**
     * Log an ERROR message.
     * <p>
     * If the logger is currently enabled for the ERROR message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     */
    public static void error(String msg) {
        LOGGER.error(msg);
    }
}
