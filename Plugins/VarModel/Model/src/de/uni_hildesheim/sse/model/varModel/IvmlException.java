package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.utils.messages.IIdentifiable;

/**
 * A top level exception class for all IVML exceptions.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public abstract class IvmlException extends Exception implements IIdentifiable {

    private int code;
    
    /**
     * Create a new exception based on the given message.
     * 
     * @param message the message
     * @param code a code detailing the exception
     */
    public IvmlException(String message, int code) {
        super(message);
        this.code = code;
    }
    
    /**
     * Returns a numerical code representing the cause.
     * 
     * @return the numerical code
     */
    public int getCode() {
        return code;
    }

    /**
     * {@inheritDoc}
     */
    public int getId() {
        return code;
    }
    
}
