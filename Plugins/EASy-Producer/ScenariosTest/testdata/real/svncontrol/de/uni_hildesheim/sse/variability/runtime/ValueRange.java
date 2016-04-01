/**
 * 
 */
package de.uni_hildesheim.sse.variability.runtime;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Defines a value range used to constrain the values a concrete
 * decision can take.
 * 
 * @author Holger Eichelberger
 * @since 1.00
 * @version 1.00
 */
public abstract class ValueRange {
    
    /**
     * Stores all instances of value ranges.
     * 
     * @since .100
     */
    private static final List<ValueRange> RANGES = new ArrayList<ValueRange>();
    
    /**
     * Creates a new value range and registers this instance
     * to {@link #RANGES}.
     * 
     * @since 1.00
     */
    protected ValueRange() {
        register(this);
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
    public abstract boolean checkValue(Object value);
    
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
    public abstract Object toValue(Object object);
    
    /**
     * Returns if this value range is binary (e.g. boolean).
     * 
     * @return <code>true</code> it this value range is binary, 
     *     <code>false</code> else
     * 
     * @since 1.00
     */
    public abstract boolean isBinary();
    
    /**
     * Returns if this value range is discrete (e.g. integer values).
     * 
     * @return <code>true</code> it this value range is discrete, 
     *     <code>false</code> if it is continuous
     * 
     * @since 1.00
     */
    public abstract boolean isDiscrete();
    
    /**
     * Returns all values if enumerable.
     * 
     * @return <b>null</b> if this value range is not enumerable 
     *     in a non-memory-exceeding consuming way, the values 
     *     of all values otherwise 
     * 
     * @since 1.00
     */
    public abstract String[] getEnumValues();
    
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
    public abstract void producePreprocessorDefines(
        Map<String, Object> mapping);

    /**
     * Returns how <code>value</code>will be represented for the 
     * preprocessor.
     *
     * @param value the value to be mapped
     * @return the preprocessor mapping
     * 
     * @since 1.00
     */
    public abstract Object getPreprocessorValue(Object value);
    
    /**
     * Returns the (unique) name of this value range.
     * 
     * @return the (unique) name of this value range
     * 
     * @since 1.00
     */
    public abstract String getName();
    
    // --------------------- static / plugins --------------------------
    
    /**
     * Registers the specified value range.
     * 
     * @param range the range to be registered (must not be <b>null</b>)
     * 
     * @since 1.00
     */
    private static final void register(ValueRange range) {
        if (null != range && !RANGES.contains(range)) {
            RANGES.add(range);
        }
    }
    
    /**
     * Returns the number of registered value ranges.
     * 
     * @return the number of registered value ranges
     * 
     * @since 1.00
     */
    public static final int getRegisteredCount() {
        return RANGES.size();
    }
    
    /**
     * Returns an iterator on all registered value ranges.
     * 
     * @return an iterator on all registered value ranges
     * 
     * @since 1.00
     */
    public static final Iterator<ValueRange> registeredRanges() {
        return RANGES.iterator();
    }
    
    /**
     * Returns the specified registered value range.
     * 
     * @param index the index of the value range to be returned
     * @return the related value range
     * @throws ArrayIndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getRegisteredCount()}</code>
     * 
     * @since 1.00
     */
    public static final ValueRange getRegisteredRange(int index) {
        return RANGES.get(index);
    }
    
    /**
     * Returns the index of the specified (registered) value range.
     * 
     * @param range the range to be searched for
     * @return <code>-1</code> if <code>range</code> was not registered,
     *     the index value otherwise
     * 
     * @since 1.00
     */
    public static final int indexOf(ValueRange range) {
        return RANGES.indexOf(range);
    }
    
    /**
     * Returns the value range identified by its name. Intended
     * from mapping UI input back to objects (if ever needed).
     * 
     * @param name the name of the value range to be returned
     * @return the related registered value range or <b>null</b>
     *     otherwise
     * 
     * @since 1.00
     */
    public static final ValueRange valueOf(String name) {
        ValueRange result = null;
        for (int i = 0; null == result && i < RANGES.size(); i++) {
            if (RANGES.get(i).getName().equals(name)) {
                result = RANGES.get(i);
            }
        }
        return result;
    }
    
    /**
     * Registers the default value ranges statically (currently
     * no dynamic class loading realized).
     * 
     * @since 1.00
     */
    static {
        register(BooleanValueRange.BOOLEAN_RANGE);
        register(IntegerValueRange.COMPLETE_INTEGER_RANGE);
        register(IntegerValueRange.POSITIVE_INTEGER_RANGE);
        register(UnknownValueRange.UNKNOWN_RANGE);
    }
    
}