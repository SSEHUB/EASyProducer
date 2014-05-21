/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.utils.logger;

/**
 * Factory for the current logger. The current logger is encapsulated in EASyLogger to 
 * provide simple access. For an example of the usage of this class see the 
 * {@link de.uni_hildesheim.sse.utils.logger containing package}.
 * 
 * @author Sass
 *
 */
public class EASyLoggerFactory {
    
    public static final EASyLoggerFactory INSTANCE = new EASyLoggerFactory();
    
    /**
     * This constant value should be set to:
     * <ul>
     * <li><tt>false</tt>: For a release.</li>
     * <li><tt>true</tt>: For development.</li>
     * </ul>
     */
    public static final boolean DEBUG = true;

    private static final String LOGGING_LEVEL_PROPERTY = "de.uni_hildesheim.sse.easy.logging.level";
    
    private ILogger logger;
    
    private LoggingLevel level;

    /**
     * Logger instance for logging in plug-ins of the EASy-Producer.
     * 
     * @author Sass
     * @author El-Sharkawy
     *
     */
    public class EASyLogger {
        private String bundleName;
        private Class<?> clazz;
        
        /**
         * Sole constructor of this class.
         * Creates an wrapper/adapter which uses the {@link ILogger} instance of the {@link EASyLoggerFactory}.
         * 
         * @param clazz The class where the logging is done
         * @param bundleName The name of the plug-in containing the logged class (can be <tt>null</tt>).
         */
        private EASyLogger(Class<?> clazz, String bundleName) {
            this.clazz = clazz;
            this.bundleName = bundleName;
        }
        
        /**
         * Log an INFO message.
         * <p>
         * If the logger is currently enabled for the INFO message
         * level then the given message is forwarded to all the
         * registered output Handler objects.
         * <p>
         * @param   msg     The string message (or a key in the message catalog)
         */
        public void info(String msg) {
            if (level.ordinal() <= LoggingLevel.INFO.ordinal()) {
                logger.info(msg, clazz, bundleName);
            }
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
        public void error(String msg) {
            if (level.ordinal() <= LoggingLevel.ERROR.ordinal()) {
                logger.error(msg, clazz, bundleName);
            }
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
        public void warn(String msg) {
            if (level.ordinal() <= LoggingLevel.WARN.ordinal()) {
                logger.warn(msg, clazz, bundleName);
            }
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
        public void debug(String msg) {
            if (level == LoggingLevel.DEBUG) {
                logger.debug(msg, clazz, bundleName);
            }
        }
        
        /**
         * Log an EXCEPTION message.
         * <p>
         * If the logger is currently enabled for the EXCEPTION message
         * level then the given message is forwarded to all the
         * registered output Handler objects.
         * <p>
         * @param   exception     The exception message
         */
        public void exception(Exception exception) {
            if (level != LoggingLevel.OFF) {
                logger.exception(exception.getMessage(), clazz, bundleName);
                if (level == LoggingLevel.DEBUG) {
                    exception.printStackTrace();
                }
            }
        }
    }   
    
    /**
     * Singleton constructor for Logger.
     * 
     */
    private EASyLoggerFactory() {
        if (DEBUG) {
            level = determineLevel(LoggingLevel.DEBUG);
            setLogger(new AdvancedJavaLogger());
        } else {
            level = determineLevel(LoggingLevel.WARN);
            setLogger(new JavaLogger());
        }
    }
    
    /**
     * Checks whether a property was passed to the JVM for specifying a {@link LoggingLevel}.
     * This method is part of the {@link EASyLoggerFactory#EASyLoggerFactory()} (constructor).
     * @param defaultLevel The default {@link LoggingLevel} which should be used, if no logging property
     *     was passed to the Java VM.
     * @return Returns the specified {@link LoggingLevel} or {@link LoggingLevel#WARN}
     * if no one was specified via a property. 
     */
    private static LoggingLevel determineLevel(LoggingLevel defaultLevel) {
        LoggingLevel level = defaultLevel;
        String property = System.getProperty(LOGGING_LEVEL_PROPERTY);
        if (null != property) {
            try {
                level = LoggingLevel.valueOf(property);
            } catch (IllegalArgumentException exc) {
                /* 
                 * Logging would be nice, but this cannot be done as this is called during the
                 * constructor call of the logger.
                 */
            }
        }
        
        return level;
    }

    /**
     * Returns a logger instance for logging informations, warnings, and errors in a concrete class.
     * This logger instance should not be passed to other classes. 
     * 
     * @param clazz The class to log.
     * @param bundleName The name of the plug-in containing the logged class (can be <tt>null</tt>).
     * @return ILogger A logger instance for this specified class and plug-in.
     */
    public EASyLogger getLogger(Class<?> clazz, String bundleName) {
        return new EASyLogger(clazz, bundleName);
    }

    /**
     * Sets an {@link ILogger}. This {@link ILogger} will be used inside the {@link #getLogger(Class, String)}
     * method for creating concrete logger instances. Also all already created loggers will be updated automatically. 
     * 
     * @param logger The new {@link ILogger} which shall be used to log all info, warnings, and errors.
     *     Must not be <tt>null</tt>.
     */
    public void setLogger(ILogger logger) {
        this.logger = logger;
    }

    /**
     * Returns the {@link LoggingLevel} that is used by the logger.
     * 
     * @return The logging level that is set.
     */
    public LoggingLevel getLoggingLevel() {
        return level;
    }
    
    /**
     * Sets an {@link LoggingLevel}.
     * 
     * @param loggingLevel The new {@link LoggingLevel} which shall be used to log.
     */
    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.level = loggingLevel;
    }
}
