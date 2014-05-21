package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * Defines a specific exception issued when building up the model fails for some reason.
 * 
 * @author Holger Eichelberger
 */
public class VilLanguageException extends AbstractException {

    /**
     * Defines an identifier if something cannot be found.
     */
    public static final int ID_NOT_FOUND = 50000;

    /**
     * Defines an identifier if something with I/O goes wrong.
     */
    public static final int ID_IO = 50001;

    /**
     * Defines an identifier if something is constant.
     */
    public static final int ID_IS_CONSTANT = 50002;

    /**
     * Defines an identifier if something is wrong with the start rule.
     */
    public static final int ID_RUNTIME_STARTRULE = 50003;

    /**
     * Defines an identifier if something is wrong with the runtime parameter.
     */
    public static final int ID_RUNTIME_PARAMETER = 50004;

    /**
     * Defines an identifier if a Java extension class cannot be resolved.
     */
    public static final int ID_CANNOT_RESOLVE_JAVA_EXTENSION = 50005;

    /**
     * Defines an identifier if something goes into cycles while runtime.
     */
    public static final int ID_RUNTIME_CYCLE = 50006;

    /**
     * Defines an identifier if rules faild at runtime.
     */
    public static final int ID_RUNTIME_RULE_FAILED = 50007;

    /**
     * Defines an identifier if something is wrong a value to type assignment at runtime.
     */
    public static final int ID_RUNTIME_TYPE = 50008;

    /**
     * Defines an identifier if something is wrong with a resolvable element, such as a missing import (whyever).
     */
    public static final int ID_RUNTIME_NOT_RESOLVED = 50009;
    
    /**
     * For serialization.
     */
    private static final long serialVersionUID = 7163856811115265216L;

    /**
     * Creates a buildlang exception based on a given <code>message</code>.
     * 
     * @param message the message of the exception
     * @param id the identifier (see constants above)
     */
    public VilLanguageException(String message, int id) {
        super(message, id);
    }
    
    /**
     * Creates a buildlang exception from a message and an optional cause.
     * 
     * @param message the message of the exception
     * @param cause the originally causing exception
     * @param id the identifier (see constants above) 
     */
    public VilLanguageException(String message, Throwable cause, int id) {
        super(message, cause, id);
    }

    /**
     * Creates an exception from a known exception as cause.
     * Note that the identification from <code>cause</code> is taken over
     * as identification.
     * 
     * @param cause the causing exception 
     */
    public VilLanguageException(AbstractException cause) {
        super(cause);
    }
    
}
