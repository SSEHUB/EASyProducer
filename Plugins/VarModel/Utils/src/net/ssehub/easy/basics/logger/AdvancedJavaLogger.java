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

import java.util.logging.Handler;
import java.util.logging.Logger;

/**
 * Another {@link JavaLogger} implementation. This logger uses different handlers to simplify the debugging process.
 * @author El-Sharkawy
 *
 */
public class AdvancedJavaLogger extends AbstractJavaLogger {

    private Logger infoLoger;
    private Logger errorLoger;
    
    /**
     * Sole constructor for this class.
     */
    public AdvancedJavaLogger() {
        ConsoleHandler infoHandler = new ConsoleHandler();
        infoHandler.setConsole(System.out);
        infoLoger = createLogger("::info");
        infoLoger.addHandler(infoHandler);
        
        ConsoleHandler errorHandler = new ConsoleHandler();
        errorLoger = createLogger("::error");
        errorLoger.addHandler(errorHandler);
        
        /* 
         * Currently no logging into a file is implemented.
         * Please add this here if it is desired.
         */       
    }
    
    /**
     * Returns a {@link Logger} instance.
     * @param appendix An optional appendix (should be used if multiple loggers needed).
     * @return A {@link Logger}.
     */
    private static Logger createLogger(String appendix) {
        Logger logger = createLogger(AdvancedJavaLogger.class, appendix);
        
        Handler[] oldHandlers = logger.getHandlers();
        for (int i = 0; i < oldHandlers.length; i++) {
            logger.removeHandler(oldHandlers[i]);
        }
        
        return logger;
    }
    
    @Override
    public void info(String msg, Class<?> clazz, String bundleName) {
        infoLoger.info("[" + clazz.getSimpleName() + "] " + msg);
    }

    @Override
    public void error(String msg, Class<?> clazz, String bundleName) {
        errorLoger.severe("[" + clazz.getSimpleName() + "] " + msg);
    }

    @Override
    public void warn(String msg, Class<?> clazz, String bundleName) {
        errorLoger.warning("[" + clazz.getSimpleName() + "] " + msg);
    }
    
    @Override
    public void debug(String msg, Class<?> clazz, String bundleName) {
        infoLoger.log(DEBUG_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
    
    @Override
    public void exception(String msg, Class<?> clazz, String bundleName) {
        errorLoger.log(EXCEPTION_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
}
