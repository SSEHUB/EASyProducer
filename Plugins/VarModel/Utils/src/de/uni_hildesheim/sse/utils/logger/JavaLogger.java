/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import java.util.logging.Filter;
import java.util.logging.Logger;

/**
 * This class is the ILogger implementation for java.util.logging.Logger.
 * 
 * @author Sass
 *
 */
public class JavaLogger extends AbstractJavaLogger {
    
    private static ConsoleHandler consoleHandler;
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
        logger.addHandler(consoleHandler);
    }

    @Override
    public void info(String msg, Class<?> clazz, String bundleName) {
        logger.info("[" + clazz.getSimpleName() + "] " + msg);
    }

    @Override
    public void error(String msg, Class<?> clazz, String bundleName) {
        logger.severe("[" + clazz.getSimpleName() + "] " + msg);
    }

    @Override
    public void warn(String msg, Class<?> clazz, String bundleName) {
        logger.warning("[" + clazz.getSimpleName() + "] " + msg);
    }
    
    @Override
    public void debug(String msg, Class<?> clazz, String bundleName) {
        logger.log(DEBUG_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
    
    @Override
    public void exception(String msg, Class<?> clazz, String bundleName) {
        logger.log(EXCEPTION_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
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
