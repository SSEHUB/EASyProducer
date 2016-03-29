package net.ssehub.easy.sseReasoner.functions;


import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.sseReasoner.Descriptor;

/**
 * Adapter/Wrapper for drools to enable logging via static methods.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class ReasonerLogger {

    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(ReasonerLogger.class, Descriptor.BUNDLE_NAME);
    
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
