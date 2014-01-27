package de.uni_hildesheim.sse.reasoning.core.reasoner;

/**
 * A specific exception which may occur when assigning values
 * to attributes.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class AttributeException extends Exception {

    /**
     * Creates a new attribute exception.
     * 
     * @param message the message of the exception
     */
    public AttributeException(String message) {
        super(message);
    }
}
