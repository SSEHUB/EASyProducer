package de.uni_hildesheim.sse.utils.logger;

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
        infoLoger = createLogger(AdvancedJavaLogger.class, "::info");
        infoLoger.addHandler(infoHandler);
        
        ConsoleHandler errorHandler = new ConsoleHandler();
        errorLoger = createLogger(AdvancedJavaLogger.class, "::error");
        errorLoger.addHandler(errorHandler);
        
        /* 
         * Currently no logging into a file is implemented.
         * Please add this here if it is desired.
         */       
    }
    
    /**
     * {@inheritDoc}
     */
    public void info(String msg, Class<?> clazz, String bundleName) {
        infoLoger.info("[" + clazz.getSimpleName() + "] " + msg);
    }

    /**
     * {@inheritDoc}
     */
    public void error(String msg, Class<?> clazz, String bundleName) {
        errorLoger.severe("[" + clazz.getSimpleName() + "] " + msg);
    }

    /**
     * {@inheritDoc}
     */
    public void warn(String msg, Class<?> clazz, String bundleName) {
        errorLoger.warning("[" + clazz.getSimpleName() + "] " + msg);
    }
    
    /**
     * {@inheritDoc}
     */
    public void debug(String msg, Class<?> clazz, String bundleName) {
        infoLoger.log(DEBUG_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
    
    /**
     * {@inheritDoc}
     */
    public void exception(String msg, Class<?> clazz, String bundleName) {
        errorLoger.log(EXCEPTION_LEVEL, "[" + clazz.getSimpleName() + "] " + msg);
    }
}
