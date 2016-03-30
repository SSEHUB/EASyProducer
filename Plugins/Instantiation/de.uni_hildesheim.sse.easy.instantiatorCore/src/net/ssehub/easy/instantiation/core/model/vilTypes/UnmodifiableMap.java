package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Represents an unmodifiable map. This is just a runtime type.
 * 
 * @param <K> the key type of the map
 * @param <V> the value type of the map

 * @author Holger Eichelberger
 */
public class UnmodifiableMap<K, V> extends Map<K, V> {

    /**
     * Creates a map wrapper.
     * 
     * @param map the map to be wrapped
     * @param types the types in <code>map</code>
     */
    public UnmodifiableMap(java.util.Map<Object, Object> map, TypeDescriptor<?>[] types) {
        super(map, types);
    }
    
    /**
     * Adds a key-value pair to this map and overrides existing mappings.
     * 
     * @param key the key for the mapping (<b>null</b> is ignored)
     * @param value the value of the mapping
     */
    public void add(Object key, V value) {
        // do nothing, unmodifiable
    }
    
    /**
     * Removes the given <code>key</code> from the map.
     * 
     * @param key the key to be removed
     */
    public void remove(Object key) {
        // do nothing, unmodifiable
    }

}
