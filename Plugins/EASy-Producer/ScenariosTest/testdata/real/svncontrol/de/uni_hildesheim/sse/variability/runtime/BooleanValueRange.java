/**
 * 
 */
package de.uni_hildesheim.sse.variability.runtime;

import java.util.Map;

/**
 * Defines the default boolean value range.
 * 
 * @author Holger Eichelberger
 * @since 1.00
 * @version 1.00
 */
public class BooleanValueRange extends ValueRange {

    /**
     * Defines the default instance of this class.
     * 
     * @since 1.00
     */
    public static final BooleanValueRange BOOLEAN_RANGE 
        = new BooleanValueRange();

    /**
     * The constructor for the default boolean instance, not 
     * intended to be visible from outside.
     * 
     * @since 1.00
     */
    private BooleanValueRange() {
    }
    
    /**
     * Checks the specified value for compliance to
     * this value range.
     * 
     * @param value the value to be checked
     * @return <code>true</code> if value complies to this
     *   value range, <code>false</code> else
     * 
     * @since 1.00
     */
    public boolean checkValue(Object value) {
        return Boolean.FALSE == value 
            || Boolean.TRUE == value 
            || Boolean.FALSE.toString().equals(value) 
            || Boolean.TRUE.toString().equals(value);
    }
    
    /**
     * Transforms a given object value to an object that complies
     * to this value range. This method is intended to convert
     * given (input) values to the values in decisions, i.e. to
     * transform e.g. a string to an appropriate (enum) value.
     * 
     * @param object the object to be transformed
     * @return an instances being compliant to this value range
     * 
     * @since 1.00
     */
    public Object toValue(Object object) {
        if (object == Boolean.TRUE) {
            return Boolean.TRUE;
        } 
        if (object == Boolean.FALSE) {
            return Boolean.FALSE;
        } 
        return Boolean.valueOf(object.toString());   
    }
    
    /**
     * Returns if this value range is binary (e.g. boolean).
     * 
     * @return <code>true</code> it this value range is binary, 
     *     <code>false</code> else
     * 
     * @since 1.00
     */
    public boolean isBinary() {
        return true;
    }
    
    /**
     * Returns if this value range is discrete (e.g. integer values).
     * 
     * @return <code>true</code> it this value range is discrete, 
     *     <code>false</code> if it is continuous
     * 
     * @since 1.00
     */
    public boolean isDiscrete() {
        return true;
    }
    
    /**
     * Returns all values if enumerable.
     * 
     * @return <b>null</b> if this value range is not enumerable 
     *     in a non-memory-exceeding consuming way, the values 
     *     of all values otherwise 
     * 
     * @since 1.00
     */
    public String[] getEnumValues() {
        return null;
    }
    
    /**
     * Adds all constants in this enum to the specified <code>mapping</code>
     * in order to produce preprocessor defines (constants) so that constant
     * names in preprocessor expressions can symbolically be mapped to the 
     * appropriate value returned by {@link #getPreprocessorValue(Object)}.
     * 
     * @param mapping to be modified as a side effect
     * 
     * @since 1.00
     */
    public void producePreprocessorDefines(Map<String, Object> mapping) {
        mapping.put("true", 1);
        mapping.put("TRUE", 1);
        mapping.put("false", 0);
        mapping.put("FALSE", 0);
    }
    
    /**
     * Returns how <code>value</code>will be represented for the 
     * preprocessor.
     *
     * @param value the value to be mapped
     * @return the preprocessor mapping
     * @throws IllegalArgumentException if there is no mapping
     * 
     * @since 1.00
     */
    public Object getPreprocessorValue(Object value) {
        if (!checkValue(value)) {
            throw new IllegalArgumentException(
                "Value does not match this value range");
        }
        Object result = 0;
        if (toValue(value) == Boolean.TRUE) {
            result = 1;
        }
        return result;
    }
    
    /**
     * Returns the (unique) name of this value range.
     * 
     * @return the (unique) name of this value range
     * 
     * @since 1.00
     */
    public String getName() {
        return "boolean value";
    }

}