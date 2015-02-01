package de.uni_hildesheim.sse.easy.loader;

/**
 * Indicates a failing execution.
 * 
 * @author Holger Eichelberger
 */
public class CommandExecutionException extends Exception {
    
    /**
     * For serialization.
     */
    private static final long serialVersionUID = 8474596974267621310L;

    /**
     * Creates a new execution exception.
     * 
     * @param cause the cause for the exception
     */
    public CommandExecutionException(Throwable cause) {
        super(cause.getMessage(), cause);
    }

}
