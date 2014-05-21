package de.uni_hildesheim.sse.easy_producer.instantiator;

/**
 * Exception will be thrown if the instantiation process failed. 
 * @author kapeluch
 *
 */
@SuppressWarnings("serial")
public class InstantiatorException extends Exception {
    private String message;
    
    /**
     * Sole constructor for this class.
     * @param message The message of this exception.
     */
    public InstantiatorException(String message) {
        this.message = message;
    }
    
    @Override
    public String getLocalizedMessage() {
        return this.message;
    }
}
