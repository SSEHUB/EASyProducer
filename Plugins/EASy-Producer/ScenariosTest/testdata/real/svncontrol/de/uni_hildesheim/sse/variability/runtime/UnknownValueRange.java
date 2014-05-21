/**
 * 
 */
package de.uni_hildesheim.sse.variability.runtime;

import java.util.Map;

public class UnknownValueRange extends ValueRange {

    /**
     * Defines the default instance of this class.
     * 
     * @since 1.00
     */
    public static final UnknownValueRange UNKNOWN_RANGE 
        = new UnknownValueRange();

    /**
     * The constructor for the default boolean instance, not 
     * intended to be visible from outside.
     * 
     * @since 1.00
     */
    private UnknownValueRange() {
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
        return true;
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
        return object;   
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
        return false;
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
        return false;
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
        return null;
    }
    
    /**
     * Returns the (unique) name of this value range.
     * 
     * @return the (unique) name of this value range
     * 
     * @since 1.00
     */
    public String getName() {
        return "unknown value";
    }

}