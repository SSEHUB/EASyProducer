package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * A specific expression to be thrown within an expression tree.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionException extends AbstractException {

    /**
     * Defines an identifier if something does not work properly during a system execution call.
     */
    public static final int ID_SYSTEM_EXEC = 50501;

    /**
     * Defines an identifier if something does not work properly during runtime.
     */
    public static final int ID_RUNTIME = 50502;

    /**
     * For serialization.
     */
    private static final long serialVersionUID = -4298546495453297920L;

    /**
     * Creates a expression exception based on a given <code>message</code>.
     * 
     * @param message the message of the exception
     * @param id the identifier (see constants above)
     */
    public ExpressionException(String message, int id) {
        super(message, id);
    }

    /**
     * Creates an expression exception from a throwable.
     * 
     * @param throwable the throwable representing cause and message
     * @param id the identifier (see constants above) 
     */
    public ExpressionException(Throwable throwable, int id) {
        super(throwable.getMessage(), throwable, id);
    }
    
    /**
     * Creates an expression exception from a message and an optional cause.
     * 
     * @param message the message of the exception
     * @param cause the originally causing exception
     * @param id the identifier (see constants above) 
     */
    public ExpressionException(String message, Throwable cause, int id) {
        super(message, cause, id);
    }
    
    /**
     * Creates an exception from a known exception as cause.
     * Note that the identification from <code>cause</code> is taken over
     * as identification.
     * 
     * @param cause the causing exception 
     */
    public ExpressionException(AbstractException cause) {
        super(cause);
    }
    
}
