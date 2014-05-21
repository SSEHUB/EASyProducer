package de.uni_hildesheim.sse.model.validation;

import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A specific message for model validation purposes.
 * 
 * @author Holger Eichelberger
 */
public class ValidationMessage extends Message {
    
    /**
     * Denotes the case that contained element (reference) is null.
     */
    public static final int ELEMENT_IS_NULL = 10800;

    /**
     * Denotes the case that an identifier is invalid (see {@link IvmlIdentifierCheck}).
     */
    public static final int INVALID_IDENTIFIER = 10801;

    /**
     * Denotes the case that a type reference is null.
     */
    public static final int TYPE_IS_NULL = 10802;

    /**
     * Denotes the case that a parent reference is invalid, e.g., <b>null</b>.
     */
    public static final int INVALID_PARENT = 10803;

    /**
     * Denotes the case that a slot in a compound is used but not declared.
     */
    public static final int UNDECLARED_SLOT = 10804;

    /**
     * Denotes the case that an expression is missing.
     */
    public static final int MISSING_EXPRESSION = 10805;

    /**
     * Denotes a generic null pointer which shall not be present.
     */
    public static final int IS_NULL = 10806;

    /**
     * Denotes an illegal comment.
     */
    public static final int ILLEGAL_COMMENT = 10807;
    
    /**
     * Stores the type of the message (see constants above).
     */
    private int code;
    
    /**
     * Stores the cause of the message.
     */
    private Object cause;

    /**
     * Creates a validation message (without a model element as cause).
     * 
     * @param description the message description
     * @param status the status of the message
     * @param code an optional code identifying the specific kind of message 
     *   typically used while automated testing (use constants defined in this class)
     */
    public ValidationMessage(String description, Status status, int code) {
        this(description, status, null, code);
    }

    /**
     * Creates a validation message.
     * 
     * @param description the message description
     * @param status the status of the message
     * @param cause the element which caused the message (may be <b>null</b>)
     * @param code an optional code identifying the specific kind of message 
     *   typically used while automated testing (use constants defined in this class)
     */
    public ValidationMessage(String description, Status status, Object cause, int code) {
        super(description, status);
        this.code = code;
        this.cause = cause;
    }
    
    /**
     * Returns the code of this message.
     * 
     * @return the code identifying the kind of message, see constants in this class
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Returns the cause of this message.
     * 
     * @return the cause, may be <b>null</b>
     */
    public Object getCause() {
        return cause;
    }

}
