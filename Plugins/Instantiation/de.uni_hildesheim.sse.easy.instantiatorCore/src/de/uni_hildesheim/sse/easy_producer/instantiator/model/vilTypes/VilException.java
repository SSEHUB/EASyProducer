package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * An exception due to VIL types and execution of VIL operations.
 * 
 * @author Holger Eichelberger
 */
public class VilException extends AbstractException {

    /**
     * In case that an artifact type is already registered.
     */
    public static final int ID_ALREADY_REGISTERED = 40001;

    /**
     * In case that registering an artifact type fails due to incompatibilities with existing types.
     */
    public static final int ID_TYPE_INCOMPATIBILITY = 40002;

    /**
     * In case that registering an artifact operation was not found.
     */
    public static final int ID_NOT_FOUND = 40003;

    /**
     * In case that an operation returns no result.
     */
    public static final int ID_NO_RESULT = 40004;
    
    /**
     * In case that an operation execution fails.
     */
    public static final int ID_EXECUTION_ERROR = 40005;

    /**
     * In case that an operation execution fails due to security reasons.
     */
    public static final int ID_SECURITY_ERROR = 40006;

    /**
     * In case that relevant data is missing.
     */
    public static final int ID_MISSING_DATA = 40007;

    /**
     * In case that relevant data is invalid.
     */
    public static final int ID_INVALID_DATA = 40008;

    /**
     * In case that the class structure of an instantiator is invalid.
     */
    public static final int ID_INVALID_INSTANTIATOR = 40009;
    
    /**
     * Identification for serialization.
     */
    private static final long serialVersionUID = -6852602281027055671L;

    /**
     * Creates an exception based on a <code>message</code>.
     * 
     * @param message the message denoting the cause for the exception
     * @param id the unique identifier (for testing)
     */
    public VilException(String message, int id) {
        super(message, id);
    }
    
    /**
     * Creates an exception based on a given <code>cause</code>.
     * 
     * @param cause the cause for the exception
     * @param id the unique identifier (for testing)
     */
    public VilException(Throwable cause, int id) {
        super(cause.getMessage(), cause, id);
    }
    
}
