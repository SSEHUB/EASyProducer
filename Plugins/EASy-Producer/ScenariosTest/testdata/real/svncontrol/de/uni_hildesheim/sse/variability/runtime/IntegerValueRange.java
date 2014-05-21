/**
 * 
 */
package de.uni_hildesheim.sse.variability.runtime;

import java.util.Map;

/**
 * Defines the value range of usual integer numbers.
 * 
 * @author Holger Eichelberger
 * @since 1.00
 * @version 1.00
 */
public class IntegerValueRange extends ValueRange {

    /**
     * Defines the default positive integer range.
     * 
     * @since 1.00
     */
    public static final IntegerValueRange POSITIVE_INTEGER_RANGE 
        = new IntegerValueRange(1, Integer.MAX_VALUE, "positive integer value");
    
    /**
     * Defines the complete integer range.
     * 
     * @since 1.00
     */
    public static final IntegerValueRange COMPLETE_INTEGER_RANGE 
        = new IntegerValueRange();

    /**
     * Stores the name of this value range.
     * 
     * @since 1.00
     */
    private String name;
    
    /**
     * Stores the minimum value in this integer range.
     * 
     * @since 1.00
     */
    private int min;

    /**
     * Stores the maximum value in this integer range.
     * 
     * @since 1.00
     */
    private int max;
    
    /**
     * A constructor for the whole integer range.
     * 
     * @since 1.00
     */
    private IntegerValueRange() {
        this(Integer.MIN_VALUE, Integer.MAX_VALUE, "integer value");
    }

    /**
     * A constructor for a subset of the range of integer numbers.
     * 
     * @param min the minimum (inclusive) value of the new range
     * @param max the maximum (inclusive) value of the new range
     * @param name the name of this range
     * 
     * @since 1.00
     */
    public IntegerValueRange(int min, int max, String name) {
        if (min > max) {
            throw new IllegalArgumentException("illegal integer range");
        }
        this.min = min;
        this.max = max;
        this.name = name;
    }

    /**
     * Returns the minimum value in this integer range.
     * 
     * @return the minimum (inclusive) value 
     * 
     * @since 1.00
     */
    public int getMin() {
        return min;
    }

    /**
     * Returns the maximum value in this integer range.
     * 
     * @return the maximum (inclusive) value 
     * 
     * @since 1.00
     */
    public int getMax() {
        return max;
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
        boolean ok;
        if (value instanceof String) {
            try {
                value = Integer.parseInt(value.toString());
            } catch (NumberFormatException e) {
            }
        }
        if (value instanceof Integer) {
            Number nVal = (Integer) value;
            ok = min <= nVal.intValue() && nVal.intValue() <= max;
        } else {
            ok = false;
        }
        return ok;
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
        return Integer.parseInt(object.toString());
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
        return 1 == max - min;
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
        return value;
    }
    
    /**
     * Returns the (unique) name of this value range.
     * 
     * @return the (unique) name of this value range
     * 
     * @since 1.00
     */
    public String getName() {
        return name;
    }

}