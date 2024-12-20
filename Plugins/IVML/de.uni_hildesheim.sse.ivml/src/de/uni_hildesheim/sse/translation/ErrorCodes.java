package de.uni_hildesheim.sse.translation;

/**
 * Defines error codes for messages used in unit testing.
 * 
 * @author Holger Eichelberger
 */
public class ErrorCodes extends net.ssehub.easy.dslCore.translation.ErrorCodes {

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
     * Error or warning due to a variable assignment. 
     */
    public static final int ASSIGNMENT = 20209;

    /**
     * Attempt to freeze the wrong type of elements. 
     */
    public static final int FREEZE = 20210;
    
    /**
     * Usage of warning function at wrong position.
     */
    public static final int WARNING_USAGE = 20211;
    
    /**
     * In case that dereferences are not possible.
     */
    public static final int DEREFERENCE = 20212;
    
    /**
     * In case that a constant shall be modified.
     */
    public static final int CONSTANT = 20213;
    
    /**
     * In case of refBy problems.
     */
    public static final int REF_BY = 20214;

    /**
     * In case of undesired explicit type qualifications.
     */
    public static final int TYPE_QUALIFICATION = 20215;

    /**
     * Usage of using different types where same types would be expected (comparison).
     */
    public static final int WARNING_DIFFERENT_TYPES = 20216;

    /**
     * Prevents creating instances of this class.
     */
    private ErrorCodes() {
    }
}
