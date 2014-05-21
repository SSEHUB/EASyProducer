package de.uni_hildesheim.sse.model.varModel;

/**
 * Defines an exception type thrown by the {@link ModelQuery} class.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ModelQueryException extends IvmlException {

    public static final int AMBIGUITY = 10150;
    public static final int ACCESS_ERROR = 10151;
    public static final int MISMATCHED_IMPORT = 10152;
    public static final int UNMATCHED_IMPORT = 10153;
    
    /**
     * Creates a new model query exception.
     * 
     * @param message the message
     * @param code the related code
     */
    public ModelQueryException(String message, int code) {
        super(message, code);
    }
    
}
