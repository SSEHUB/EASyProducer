/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

import de.uni_hildesheim.sse.utils.internal.Bundle;

/**
 * Simple logger for logging into a specified file.
 * @author El-Sharkawy
 *
 */
public class FileLogger extends AbstractJavaLogger {
    private static FileLogger instance;
    
    private Handler fileHandler;
    private Logger logger = createLogger(FileLogger.class, null);
    
    /**
     * Creates an {@link ILogger} for logging into a specified file.
     * @param path The path of the file where the log file shall be written.
     * @param append If <tt>true</tt> log data will be appended to existing files,
     * otherwise existing files will be overwritten 
     * @throws  IOException if there are IO problems opening the files.
     * @throws  SecurityException  if a security manager exists and if
     *             the caller does not have <tt>LoggingPermission("control")</tt>.
     * @throws  IllegalArgumentException if pattern is an empty string
     */
    private FileLogger(String path, boolean append) throws SecurityException, IOException {
        fileHandler = new FileHandler(path, append);
        fileHandler.setFormatter(LOG_FORMATTER);
        logger.addHandler(fileHandler);
    }
    
    /**
     * Returns the singleton instance of this {@link ILogger} implementation.
     * @param path The path of the file where the log file shall be written.
     * @param append If <tt>true</tt> log data will be appended to existing files,
     * otherwise existing files will be overwritten 
     * @return The first successfully created logger, or <tt>null</tt> if no logger could be created, e.g.
     *     if no valid path was specified.
     */
    public static synchronized FileLogger getInstance(String path, boolean append) {
        if (null == instance) {
            try {
                instance = new FileLogger(path, append);
            } catch (SecurityException e) {
                EASyLoggerFactory.INSTANCE.getLogger(FileLogger.class, Bundle.ID).exception(e);
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(FileLogger.class, Bundle.ID).exception(e);
            }
        }
        
        return instance;
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

}
