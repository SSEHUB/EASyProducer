package net.ssehub.easy.varModel.logger;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.logger.ILogger;

/**
 * Logger for testing correct behavior of {@link net.ssehub.easy.basics.logger.LoggingLevel}s
 * inside the {@link EASyLoggerFactoryTest} test suite.
 * @author El-Sharkawy
 *
 */
class ListLogger implements ILogger {
    
    private List<String> infoMessages = new ArrayList<String>();
    private List<String> errorMessages = new ArrayList<String>();
    private List<String> warnMessages = new ArrayList<String>();
    private List<String> debugMessages = new ArrayList<String>();
    private List<String> exceptions = new ArrayList<String>();
    
    /**
     * Getter for the info messages.
     * @return All logged info messages, will not be <b>null</b>.
     */
    public List<String> getInfoMessages() {
        return infoMessages;
    }

    /**
     * Getter for the error messages.
     * @return All logged error messages, will not be <b>null</b>.
     */
    public List<String> getErrorMessages() {
        return errorMessages;
    }

    /**
     * Getter for the warning messages.
     * @return All logged warning messages, will not be <b>null</b>.
     */
    public List<String> getWarnMessages() {
        return warnMessages;
    }

    /**
     * Getter for the debug messages.
     * @return All logged debug messages, will not be <b>null</b>.
     */
    public List<String> getDebugMessages() {
        return debugMessages;
    }

    /**
     * Getter for the exceptions.
     * @return All logged exception messages, will not be <b>null</b>.
     */
    public List<String> getExceptions() {
        return exceptions;
    }
    
    @Override
    public void info(String msg, Class<?> clazz, String bundleName) {
        infoMessages.add(msg);
    }

    @Override
    public void error(String msg, Class<?> clazz, String bundleName) {
        errorMessages.add(msg);        
    }

    @Override
    public void warn(String msg, Class<?> clazz, String bundleName) {
        warnMessages.add(msg);                
    }

    @Override
    public void debug(String msg, Class<?> clazz, String bundleName) {
        debugMessages.add(msg);
    }

    @Override
    public void exception(String msg, Class<?> clazz, String bundleName) {
        exceptions.add(msg);
    }

}
