package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * An exception which signals that a given value does not match the 
 * specified type.
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class ValueDoesNotMatchTypeException extends IvmlException {
    
    public static final int IS_NULL = 10200;
    public static final int NO_LITERAL = 10201;
    public static final int SLOT_MISMATCH = 10202;
    public static final int TYPE_MISMATCH = 10203;
    public static final int INTERNAL = 10204;
    public static final int NO_DATATYPE = 10205;
    public static final int IS_CONSTANT = 10206;
    
    /**
     * Error code for structured values.
     * This error code should be used if each values is valid, but not allowed in combination,
     * e.g. a <tt>SetValue</tt> with duplicates.
     */
    public static final int NOT_ALLOWED_VALUE_STRUCTURE = 10206;
    
    /**
     * Creates a new mismatch exception.
     * 
     * @param message the exception message
     * @param code a code representing the cause
     */
    public ValueDoesNotMatchTypeException(String message, int code) {
        super(message, code);
    }
    
    /**
     * Creates a new mismatch exception.
     * 
     * @param value the value which caused the exception
     * @param type the type <code>value</code> does not match to
     * @param code a code representing the cause
     */
    public ValueDoesNotMatchTypeException(Object value, String type, int code) {
        super("value '" + value + "' does not match type '" + type + "'", code);
    }

    /**
     * Creates a new mismatch exception.
     * 
     * @param value the value which caused the exception
     * @param type the type <code>value</code> does not match to
     * @param code a code representing the cause
     */
    public ValueDoesNotMatchTypeException(String value, IDatatype type, int code) {
        this(value, type.getName(), code);
    }

    /**
     * Creates a new mismatch exception.
     * 
     * @param valueString the value which caused the exception
     * @param value the value object in which caused the problem
     * @param code a code representing the cause
     */
    public ValueDoesNotMatchTypeException(String valueString, Value value, int code) {
        this(valueString, value.getType(), code);
    }
    
}
