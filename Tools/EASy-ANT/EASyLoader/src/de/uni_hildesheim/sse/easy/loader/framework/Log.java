package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.logging.Logger;

/**
 * Very simple logging support.
 * 
 * @author Holger Eichelberger
 */
public class Log {

    private static LoaderLogger logger = new JavaLoaderLogger();

    /**
     * Defines an interface for logging in the EASy loader. We cannot rely on the EASy logger as this is not known.
     * Further, we do not rely on other logger frameworks in order to avoid conflicts. They can be used by delegation.
     * 
     * @author Holger Eichelberger
     */
    public interface LoaderLogger {

        /**
         * Logs an error.
         * 
         * @param error the error text
         */
        public void error(String error);

        /**
         * Logs an error with exception.
         * 
         * @param error the error text
         * @param exception the exception to be added
         */
        public void error(String error, Exception exception);

        /**
         * Logs a warning.
         * 
         * @param warning the warning text
         */
        public void warn(String warning);

        /**
         * Emits a warning and adds the message of the given <code>exception</code>.
         * 
         * @param warning the warning text
         * @param exception the exception to be added
         */
        public void warn(String warning, Exception exception);

        /**
         * Logs an information message.
         * 
         * @param msg the message to be logged
         */
        public void info(String msg);

    }
    
    /**
     * Implements the default loader logger.
     * 
     * @author Holger Eichelberger
     */
    private static class JavaLoaderLogger implements LoaderLogger {
        
        private Logger javaLogger = java.util.logging.Logger.getLogger("EASyLoader");

        @Override
        public void error(String error) {
            javaLogger.severe(error);
        }

        @Override
        public void error(String error, Exception exception) {
            javaLogger.severe(error + ": " + exception.getMessage());
        }

        @Override
        public void warn(String warning) {
            javaLogger.warning(warning);
        }

        @Override
        public void warn(String warning, Exception exception) {
            javaLogger.warning(warning + ": " + exception.getMessage());
        }

        @Override
        public void info(String msg) {
            javaLogger.info(msg);
        }
        
    }

    /**
     * Returns the logger instance.
     * 
     * @return the logger instance
     */
    public static LoaderLogger getLogger() {
        return logger;
    }
    
    /**
     * Defines a new logger instance.
     * 
     * @param newLogger the new logger instance (ignored if <b>null</b>)
     */
    public static void setLogger(LoaderLogger newLogger) {
        if (null != newLogger) {
            logger = newLogger;
        }
    }
    
    /**
     * Logs an error.
     * 
     * @param error the error text
     */
    public static void error(String error) {
        logger.error(error);
    }
    
    /**
     * Logs an error with exception.
     * 
     * @param error the error text
     * @param exception the exception to be added
     */
    public static void error(String error, Exception exception) {
        logger.error(error, exception);
    }
    
    /**
     * Logs a warning.
     * 
     * @param warning the warning text
     */
    public static void warn(String warning) {
        logger.warn(warning);
    }

    /**
     * Emits a warning to the console and adds the message of the given <code>exception</code>.
     * 
     * @param warning the warning text
     * @param exception the exception to be added
     */
    public static void warn(String warning, Exception exception) {
        logger.warn(warning, exception);
    }
    
    /**
     * Logs an information message.
     * 
     * @param msg the message to be logged
     */
    public static void info(String msg) {
        logger.info(msg);
    }

}
