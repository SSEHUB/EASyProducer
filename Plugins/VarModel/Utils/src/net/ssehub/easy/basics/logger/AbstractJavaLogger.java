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
package net.ssehub.easy.basics.logger;

import java.io.PrintStream;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;


/**
 * Super class for {@link ILogger}s using the {@link java.util.logging.Logger}.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractJavaLogger implements ILogger {

    public static final Level DEBUG_LEVEL = new DebugLevel();
    public static final Level EXCEPTION_LEVEL = new ExceptionLevel();
    protected static final LogFormatter LOG_FORMATTER = new LogFormatter();
    protected static final Level DEFAULT_LEVEL = Level.ALL;

    /**
     * Console Handler for the {@link JavaLogger} to allow the specification of the desired system console.
     * This logger will log per default to {@link System#err}.
     * @see ConsoleHandler#setConsole(PrintStream)
     * @author El-Sharkawy
     *
     */
    protected class ConsoleHandler extends Handler {
        private PrintStream console;
        
        /**
         * Constructs a new ConsoleHandler.
         */
        protected ConsoleHandler() {
            super();
            setConsole(System.err);
            setFormatter(LOG_FORMATTER);
            setLevel(DEFAULT_LEVEL);
        }

        @Override
        public void publish(LogRecord record) {
            if (isLoggable(record)) {
                String msg = null;
                if (null != getFormatter()) {
                    msg = getFormatter().format(record);
                } else {
                    msg = record.getMessage();
                }
                
                console.print(msg);
            }
        }

        @Override
        public void flush() {
            // Not needed
        }

        @Override
        public void close() throws SecurityException {
            // Not needed
        }
        
        /**
         * Sets the output console of this console logger.
         * @param console Must be {@link System#out} or {@link System#err}.
         */
        public void setConsole(PrintStream console) {
            if (console == System.out || console == System.err) {
                this.console = console;
            }
        }
        
    }
    
    /**
     * Returns a {@link Logger} instance.
     * @param loggerClass The class, where the logger is created/needed).
     * @param appendix An optional appendix (should be used if multiple loggers needed.
     * @return A {@link Logger}.
     */
    protected static final Logger createLogger(Class<? extends AbstractJavaLogger> loggerClass, String appendix) {
        String name = loggerClass.getSimpleName();
        if (null != appendix) {
            name += appendix;
        }
        
        Logger logger = Logger.getLogger(name);
        logger.setLevel(DEFAULT_LEVEL);
        logger.setUseParentHandlers(false);
        return logger;
    }
}
