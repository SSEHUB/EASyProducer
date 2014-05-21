package de.uni_hildesheim.sse.translation;

/**
 * Defines error codes for messages used in unit testing.
 * 
 * @author Holger Eichelberger
 */
public class ErrorCodes extends de.uni_hildesheim.sse.dslCore.translation.ErrorCodes {

    /**
     * Operand of collection operation is not a collection.
     */
    public static final int LHS_NOT_COLLECTION = 20201;

    /**
     * Internal error, should not occur.
     */
    public static final int INTERNAL = 20204;

    /**
     * Resolving an element leads to an ambiguity.
     */
    public static final int AMBIGUITY = 20206;

    /**
     * Errors during attribution of elements (attributeTo).
     */
    public static final int ATTRIBUTION = 20208;

    /**
     * Prevents creating instances of this class.
     */
    private ErrorCodes() {
    }
}
