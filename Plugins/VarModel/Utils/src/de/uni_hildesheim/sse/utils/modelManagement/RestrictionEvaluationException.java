package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * An exception thrown when then evaluation of a restriction fails.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class RestrictionEvaluationException extends Exception {

    public static final int ID_INTERNAL = 10999;

    private int id;

    /**
     * Creates a restriction evaluation exception.
     *  
     * @param message the exception message
     * @param id an identification used for testing
     */
    public RestrictionEvaluationException(String message, int id) {
        this(message, id, null);
    }
    
    /**
     * Creates a restriction evaluation exception.
     *  
     * @param message the exception message
     * @param id an identification used for testing
     * @param cause the causing exception
     */
    public RestrictionEvaluationException(String message, int id, Exception cause) {
        super(message, cause);
        this.id = id;
    }
    
    /**
     * Returns the identification used for testing.
     * 
     * @return the identification
     */
    public int getId() {
        return id;
    }
    
}
