package net.ssehub.easy.producer.core.persistence;

/**
 * Exception for errors occuring during save/load operations.
 * @author El-Sharkawy
 *
 */@SuppressWarnings("serial")
public class PersistenceException extends Exception {

    /**
     * Constructor for this class for transforming one exception into a <code>PersistenceException</code>.
     * @param cause The origin exception which should be transformed.
     */
    public PersistenceException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Constructor for this class for creating an exception with a specified error message.
     * @param message The detail message.
     * The detail message is saved for later retrieval by the {@link Exception#getMessage()} method.
     */
    public PersistenceException(String message) {
        super(message);
    }
}
