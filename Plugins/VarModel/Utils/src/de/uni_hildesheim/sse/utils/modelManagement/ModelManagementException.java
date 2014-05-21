package de.uni_hildesheim.sse.utils.modelManagement;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * An exception thrown by the model management itself typically
 * on global consistency issues.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ModelManagementException extends AbstractException {
    
    public static final int MODEL_INFO_INCONSISTENCY = 10500;
    public static final int MODEL_CYCLIC_IMPORT = 10501;
    public static final int MODEL_IMPORT_VERSION_CONFLICT = 10502;
    public static final int MODEL_LOAD_FAILURE = 10503;
    public static final int INTERNAL = 10599;
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public ModelManagementException(String message, int code) {
        super(message, code);
    }
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public ModelManagementException(StringBuilder message, int code) {
        super(message.toString(), code);
    }

}
