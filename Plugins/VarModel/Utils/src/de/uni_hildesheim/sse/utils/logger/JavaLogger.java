package de.uni_hildesheim.sse.utils.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * This class is the ILogger implementation for java.util.logging.Logger.
 * 
 * @author Sass
 *
 */
public class JavaLogger extends AbstractJavaLogger {
    
    /**
     * Defines whether the log file should be appended or not.
     */
    private static final boolean APPEND = true;

    private static String defaultLogDirectory = System.getProperty("user.home") + "/EASy.log";
    private static ConsoleHandler consoleHandler;
    private static Handler fileHandler;
    private Logger logger = createLogger(JavaLogger.class, null);
    
    /**
     * Constructor to initialize the instance of the logger.
     * The log messages are printed to the console and to a log file.
     * By default the log directory is set to the user home directory.
     * Use the {@link #setLogDirectory(String) setLogDirectory} method to change the directory. 
     * To change the output format modify the {@link LogFormatter} class.
     * By default the logging level is set to ALL. In a productive environment the
     * level should be set to INFO.
     * Use the {@link EASyLoggerFactory#setLoggingLevel(LoggingLevel) setLogLevel} method to change the level.
     * 
     */
    public JavaLogger() {
        consoleHandler = new ConsoleHandler();
        try {
            fileHandler = new FileHandler(defaultLogDirectory, APPEND);
            fileHandler.setFormatter(LOG_FORMATTER);
        } catch (SecurityException e) {
            logger.severe(e.getMessage());
        } catch (IOException e) {
            logger.severe(e.getMessage());
        }
        logger.addHandler(consoleHandler);
        logger.addHandler(fileHandler);
    }

    /**
     * {@inheritDoc}
     */
    public void info(String msg, Class<?> clazz, String bundleName) {
        logger.info("[" + clazz.getSimpleName() + "] " + msg);
    }

    /**
     * {@inheritDoc}
     */
    public void error(String msg, Class<?> clazz, String bundleName) {
        logger.severe("[" + clazz.getSimpleName() + "] " + msg);
    }

    /**
     * {@inheritDoc}
     */
    public void warn(String msg, Class<?> clazz, String bundleName) {
        logger.warning("[" + clazz.getSimpleName() + "] " + msg);
    }
    
    /**
     * {@inheritDoc}
     */
    public void debug(String msg, Class<?> clazz, String bundleName) {
        logger.log(DEBUG_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
    
    /**
     * {@inheritDoc}
     */
    public void exception(String msg, Class<?> clazz, String bundleName) {
        logger.log(EXCEPTION_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
    
    /**
     * Sets the directory for the log file. Default directory is the user 
     * home directory (<code>System.getProperty("user.home")</code>).
     * The file name will be added automatically.
     * 
     * @param directory Directory where the log should be stored.
     */
    public void setLogDirectory(String directory) {
        defaultLogDirectory = directory + "/EASy.log";
    }
    
    /**
     * Each Logger and each Handler can have a filter associated with it. The Logger or 
     * Handler will call the isLoggable method to check if a given LogRecord should be 
     * published. If isLoggable returns false, the LogRecord will be discarded.
     * 
     * This method should only be used for jUnit testing since it suppresses logging.
     * 
     * @param filter The {@link Filter} that should be used. May be null.
     */
    public void setFilter(Filter filter) {
        logger.setFilter(filter);
    }
    
}
