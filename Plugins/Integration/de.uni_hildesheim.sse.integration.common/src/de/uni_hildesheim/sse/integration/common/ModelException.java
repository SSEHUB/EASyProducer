package de.uni_hildesheim.sse.integration.common;

/**
 * Thrown in case of illegal input to the IRET-IVML integration interface.
 *
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ModelException extends Exception {

    /**
     * Creates a new model exception.
     *
     * @param message the message causing the problem
     */
    public ModelException(String message) {
        super(message);
    }

    /**
     * Creates a new model exception.
     *
     * @param throwable the throwable carrying the description of the problem (message is taken)
     */
    public ModelException(Throwable throwable) {
       super(throwable.getMessage());
    }

}
