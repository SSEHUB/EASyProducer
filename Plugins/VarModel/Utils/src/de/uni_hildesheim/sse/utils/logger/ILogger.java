package de.uni_hildesheim.sse.utils.logger;

/**
 * Interface for concrete Loggers, which can be handled by the {@link EASyLoggerFactory}.
 * 
 * @author Sass
 *
 */
public interface ILogger {
    
    /**
     * Log an INFO message.
     * <p>
     * If the logger is currently enabled for the INFO message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void info(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an ERROR message.
     * <p>
     * If the logger is currently enabled for the ERROR message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void error(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an WARN message.
     * <p>
     * If the logger is currently enabled for the WARN message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void warn(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an DEBUG message.
     * <p>
     * If the logger is currently enabled for the DEBUG message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void debug(String msg, Class<?> clazz, String bundleName);
    
    /**
     * Log an EXCEPTION message.
     * <p>
     * If the logger is currently enabled for the EXCEPTION message
     * level then the given message is forwarded to all the
     * registered output Handler objects.
     * <p>
     * @param   msg     The string message (or a key in the message catalog)
     * @param   clazz   The class where the message was created
     * @param   bundleName  Name of the bundle where the message was created
     */
    public void exception(String msg, Class<?> clazz, String bundleName);
}
