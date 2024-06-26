package net.ssehub.easy.producer.eclipse;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

/**
 * Subclass of Status for own EXCEPTION Status in eclipse logging.
 * 
 * @author Sass
 *
 */
public class ExceptionStatus extends Status {
    
    // severity the severity; one of OK, ERROR, INFO, WARNING, or CANCEL
    public static final int SEVERITY = IStatus.INFO;

    /**
     * Simplified constructor of a new status object; assumes that code is OK and exception 
     * is null. The created status has no children.
     * 
     * @param pluginId  the unique identifier of the relevant plug-in
     * @param message   a human-readable message, localized to the current locale
     */
    public ExceptionStatus(String pluginId, String message) {
        super(SEVERITY, pluginId, message);
    }

}
