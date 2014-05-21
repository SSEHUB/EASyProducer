package de.uni_hildesheim.sse.variability.runtime;

import java.util.HashMap;

/**
 * A generic storage class to hold target platform specific
 * information while processing the variability glue code.
 * 
 * @author Holger Eichelberger
 * @since 1.00
 */
public class ProcessingState {
    
    /**
     * Stores the data.
     * 
     * @since 1.00
     */
    private static final java.util.Map<String, Object> STATE 
        = new HashMap<String, Object>();

    /**
     * Prevents this class from being instantiated from outside.
     * 
     * @since 1.00
     */
    private ProcessingState() {
    }
    
    /**
     * Adds a key to this storage. Existing keys will
     * not be overwritten.
     * 
     * @param key the arbitrary key to be set
     * 
     * @since 1.00
     */
    public static void setKey(String key) {
        if (!STATE.containsKey(key)) {
            STATE.put(key, null);
        }
    }

    /**
     * Adds a key to this storage. Existing keys will
     * not be overwritten.
     * 
     * @param key the arbitrary key to be set
     * @param value the value to set
     * 
     * @since 1.00
     */
    public static void setKey(String key, Object value) {
        if (!STATE.containsKey(key)) {
            STATE.put(key, value);
        }
    }
    
    /**
     * Returns if this storage has the specified key.
     * 
     * @param key the arbitrary key to be queried for
     * @return <code>true</code> if the key is present,
     *   <code>false</code> else
     * 
     * @since 1.00
     */
    public static boolean hasKey(String key) {
        return STATE.containsKey(key);   
    }

    /**
     * Returns if this storage has the specified key.
     * 
     * @param key the arbitrary key to be queried for
     * @param value the value to check for
     * @return <code>true</code> if the key is present 
     *   and the value is identical, <code>false</code> else
     * 
     * @since 1.00
     */
    public static boolean hasKey(String key, Object value) {
        return STATE.containsKey(key) && matchValue(STATE.get(key), value);   
    }
    
    /**
     * Returns if two values match (considering <b>null</b>).
     * 
     * @param v1 the first value to be considered
     * @param v2 the second value to be considered
     * @return <code>true</code> if the values match, 
     *     <code>false</code> else
     *     
     * @since 1.00
     */
    private static boolean matchValue(Object v1, Object v2) {
        boolean result = false;
        if (null == v1) {
            result = (v2 == null);
        } else {
            result = v1.equals(v2);
        }
        return result;
    }

    /**
     * Returns if this storage has the specified key.
     * 
     * @param key the arbitrary key to be queried for
     * @param value the value to check for
     * @return <code>true</code> if the key is present 
     *   and the value does not match, <code>false</code> else
     * 
     * @since 1.00
     */
    public static boolean hasKeyButNotValue(String key, Object value) {
        return STATE.containsKey(key) && !matchValue(STATE.get(key), value);   
    }
    
    /**
     * Removes a key from this storage.
     * 
     * @param key the arbitrary key to be set
     * 
     * @since 1.00
     */
    public static void removeKey(String key) {
        STATE.remove(key);
    }

}
