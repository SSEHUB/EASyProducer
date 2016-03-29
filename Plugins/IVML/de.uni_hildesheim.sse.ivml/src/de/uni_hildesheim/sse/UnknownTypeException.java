package de.uni_hildesheim.sse;

import net.ssehub.easy.varModel.model.IvmlException;

/**
 * A specific exception thrown in case that a type cannot be resolved.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class UnknownTypeException extends IvmlException {

    public static final int CODE = 20001;

    /**
     * Creates an instance.
     * 
     * @param type
     *            the name of the type
     */
    public UnknownTypeException(String type) {
        super("type '" + type + "' cannot be resolved", CODE);
    }

}
