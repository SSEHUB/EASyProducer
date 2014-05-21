package de.uni_hildesheim.sse.utils.modelManagement;

import de.uni_hildesheim.sse.utils.messages.AbstractException;


/**
 * A version format exception.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class VersionFormatException extends AbstractException {
    
    public static final int INVALID_VERSION = 10400;
    
    /**
     * Creates a new version format exception based on a message.
     * 
     * @param message the error message 
     * @param code a code representing the reason
     */
    public VersionFormatException(String message, int code) {
        super(message, code);
    }

}
