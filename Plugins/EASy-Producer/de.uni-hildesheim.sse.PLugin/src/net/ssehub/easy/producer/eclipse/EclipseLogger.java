package net.ssehub.easy.producer.eclipse;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;

import net.ssehub.easy.basics.logger.ILogger;

/**
 * ILogger implementation for eclipse logger.
 * 
 * @author Sass
 *
 */
public class EclipseLogger implements ILogger {
    
    private ILog logger;
    
    /**
     * Constructor to initialize the instance of the logger.
     * 
     * @param plugin    The Plugin from which the logger is called.
     */
    public EclipseLogger(Plugin plugin) {
        logger = plugin.getLog();
    }
    
    /**
     * {@inheritDoc}
     */
    public void info(String msg, Class<?> clazz, String bundleName) {
        msg = "[INFO] [" + clazz.getSimpleName() + "] " + msg;
        try {
            logger.log(new Status(IStatus.INFO, bundleName, msg));
        } catch (IllegalArgumentException e) { // illegal bundle
            System.out.println(msg);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void error(String msg, Class<?> clazz, String bundleName) {
        msg = "[ERROR] [" + clazz.getSimpleName() + "] " + msg;
        try {
            logger.log(new Status(IStatus.ERROR, bundleName, msg));
        } catch (IllegalArgumentException e) { // illegal bundle
            System.out.println(msg);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void warn(String msg, Class<?> clazz, String bundleName) {
        msg = "[WARNING] [" + clazz.getSimpleName() + "] " + msg;
        try {
            logger.log(new Status(IStatus.WARNING, bundleName, msg));        
        } catch (IllegalArgumentException e) { // illegal bundle
            System.out.println(msg);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void debug(String msg, Class<?> clazz, String bundleName) {
        msg = "[DEBUG] [" + clazz.getSimpleName() + "] " + msg;
        try {
            logger.log(new DebugStatus(bundleName, msg));        
        } catch (IllegalArgumentException e) { // illegal bundle
            System.out.println(msg);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void exception(String msg, Class<?> clazz, String bundleName) {
        msg = "[EXCEPTION] [" + clazz.getSimpleName() + "] " + msg;
        try {
            logger.log(new DebugStatus(bundleName, msg));
        } catch (IllegalArgumentException e) { // illegal bundle
            System.out.println(msg);
        }
    }

}
