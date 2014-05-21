package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.IvmlException;

/**
 * Exception for invalid Constraints. Will be thrown if datatypes not match.
 * 
 * @author tebbje
 * @author Holger Eichelberger
 *
 */
@SuppressWarnings("serial")
public class CSTSemanticException extends IvmlException {

    public static final int TYPE_MISMATCH = 10100;
    public static final int UNKNOWN_OPERATION = 10101;
    public static final int CONTAINER_OPERATION = 10102;
    public static final int INTERNAL = 10103;
    public static final int UNKNOWN_ELEMENT = 10104;
    public static final int AMBIGUITY = 10105;
    public static final int ILLEGAL = 10106;
    
    /**
     * Creates a new exception instance.
     * 
     * @param message the message describing the problem
     * @param code a code representing the reason
     */
    public CSTSemanticException(String message, int code) {
        super(message, code); // TODO consider internationalization
    }

}
