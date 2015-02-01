package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Defines the VIL type "Map".
 *
 * @param <K> the key type of the map
 * @param <V> the value type of the map
 * 
 * @author Holger Eichelberger
 */
public class Map<K, V> implements IVilType, IStringValueProvider {

    private java.util.Map<Object, Object> map = new HashMap<Object, Object>();
    private TypeDescriptor<? extends IVilType>[] types;
    
    /**
     * Creates a new map.
     * 
     * @param types the parameter types of this map
     */
    Map(TypeDescriptor<? extends IVilType>[] types) {
        this(types, 0);
    }

    /**
     * Creates a new map.
     * 
     * @param types the parameter types of this map
     * @param size the initial size of this map
     */
    Map(TypeDescriptor<? extends IVilType>[] types, int size) {
        assert null != types && 2 == types.length;
        this.types = types;
        map = new HashMap<Object, Object>(size <= 0 ? 10 : size);
    }
    
    /**
     * Creates a map wrapper.
     * 
     * @param map the map to be wrapped
     * @param types the types in <code>map</code>
     */
    public Map(java.util.Map<Object, Object> map, TypeDescriptor<? extends IVilType>[] types) {
        assert null != types && 2 == types.length;
        this.types = types;
        this.map = map;
    }
    
    /**
     * Returns the value assigned to <code>key</code>.
     * 
     * @param key the key to search the value for
     * @return the value for key (may be <b>null</b>)
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(name = Constants.ARRAY_ACCESS)
    public V at(Object key) {
        V result;
        if (null == key) {
            result = null;
        } else {
            result = (V) map.get(key);
        }
        return result;
    }
    
    /**
     * Returns whether this map contains a mapping for the given <code>key</code>.
     * 
     * @param key the key to search for
     * @return <code>true</code> if key is included, <code>false</code> else
     */
    public boolean containsKey(Object key) {
        boolean result = false;
        if (null != key) {
            result = map.containsKey(key);
        }
        return result;
    }

    /**
     * Returns the value assigned to <code>key</code>.
     * 
     * @param key the key to search the value for
     * @return the value for key (may be <b>null</b>)
     */
    @OperationMeta(useGenericParameter = 1 )
    public V get(Object key) {
        return at(key);
    }
    
    /**
     * Adds a key-value pair to this map and overrides existing mappings.
     * 
     * @param key the key for the mapping (<b>null</b> is ignored)
     * @param value the value of the mapping
     */
    public void add(Object key, V value) {
        Object val = value;
        if (null != key) {
            if (2 == types.length) {
                if (types[1].isMap() && value instanceof Collection<?>) {
                    Collection<?> coll = (Collection<?>) value;
                    if (0 == coll.size()) {
                        TypeDescriptor<? extends IVilType>[] params = TypeDescriptor.createArray(2);
                        params[0] = types[0];
                        params[1] = types[1];
                        val = new Map<Object, Object>(params);
                    }
                }
            }
            map.put(key, val);
        }
    }
    
    /**
     * Removes the given <code>key</code> from the map.
     * 
     * @param key the key to be removed
     */
    public void remove(Object key) {
        if (null != key) {
            map.remove(key);
        }
    }

    /**
     * Returns the number of dimensions of <code>T</code>.
     * 
     * @return the number of dimensions
     */
    @Invisible(inherit = true)
    public int getDimensionCount() {
        return types.length;
    }
    
    /**
     * Returns the size of the map.
     * 
     * @return the size of the map
     */
    public int getSize() {
        return map.size();
    }
    
    /**
     * Returns the type of the specified dimension of <code>T</code>.
     * 
     * @param index the 0-based index of the dimension
     * 
     * @return the actual type of the dimension
     */
    @Invisible(inherit = true)
    public TypeDescriptor<? extends IVilType> getDimensionType(int index) {
        return types[index];
    }
       
    /**
     * Converts the given sequence into a map.
     * 
     * @param sequence the sequence to be converted
     * @return the resulting map
     * @throws ArtifactException in case that types or dimensions cannot be converted
     */
    @Conversion
    public static Map<?, ?> convert(Sequence<?> sequence) throws ArtifactException {
        int seqSize = sequence.size();
        if (seqSize > 0 && sequence.getDimensionCount() != 2) {
            throw new ArtifactException("sequence of dimension " + sequence.getDimensionCount() 
                + " cannot be converted into a map of dimension 2", ArtifactException.ID_INVALID_TYPE);
        }
        TypeDescriptor<? extends IVilType>[] types = TypeDescriptor.createArray(2);
        if (seqSize > 0) {
            types[0] = sequence.getDimensionType(0);
            types[1] = sequence.getDimensionType(1);
        } else {
            types[0] = TypeRegistry.anyType();
            types[1] = types[0];
        }
        Map<?, ?> result = new Map<Object, Object>(types, seqSize);
        for (int e = 0; e < seqSize; e++) {
            Object elt = sequence.get(e);
            if (elt instanceof Sequence) {
                Sequence<?> seq = (Sequence<?>) elt;
                if (2 != seq.size()) {
                    throw new ArtifactException("sequence in element " + e + "is not of size 2", 
                        ArtifactException.ID_INVALID_TYPE);
                }
                result.map.put(seq.get(0), seq.get(1));
            } else {
                throw new ArtifactException("element " + e + "is not a sequence", ArtifactException.ID_INVALID_TYPE);
            }
        }
        return result;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return getStringValue(map, comparator);
    }

    /**
     * Returns the string value of the given <code>map</code> .
     * 
     * @param map the map to be turned into a String
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @return the string value
     */
    @Invisible
    public static String getStringValue(java.util.Map<?, ?> map, StringComparator comparator) {
        StringBuilder tmp = new StringBuilder("{");
        if (null != comparator) {
            TreeMap<String, Object> sorter = new TreeMap<String, Object>(comparator);
            for (java.util.Map.Entry<?, ?> entry : map.entrySet()) {
                sorter.put(StringValueHelper.getStringValue(entry.getKey(), comparator), entry.getValue());
            }
            Iterator<java.util.Map.Entry<String, Object>> iter = sorter.entrySet().iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry<String, Object> entry = iter.next();
                tmp.append("{");
                tmp.append(entry.getKey());
                tmp.append(", ");
                tmp.append(StringValueHelper.getStringValue(entry.getValue(), comparator));
                tmp.append("}");
                if (iter.hasNext()) {
                    tmp.append(", ");
                }
            }
        } else {
            Iterator<?> iter = map.keySet().iterator();
            while (iter.hasNext()) {
                Object key = iter.next();
                Object value = map.get(key);
                tmp.append("{");
                tmp.append(StringValueHelper.getStringValue(key, comparator));
                tmp.append(", ");
                tmp.append(StringValueHelper.getStringValue(value, comparator));
                tmp.append("}");
                if (iter.hasNext()) {
                    tmp.append(", ");
                }
            }
        }
        tmp.append("}");
        return tmp.toString();
    }
    
    /**
     * Converts <code>value</code> to an empty map with parameter types from <code>type</code>, if
     * <code>type</code> is a map and <code>value</code> is an empty map instance. This is needed
     * for initialization.
     * 
     * @param type the (target) type to be checked
     * @param value the value to be checked
     * @return <code>value</code> or an empty map of the given types
     */
    @Invisible
    public static Object checkConvertEmpty(TypeDescriptor<? extends IVilType> type, Object value) {
        if (type.isMap() && value instanceof Map<?, ?> && 2 == type.getParameterCount()) {
            Map<?, ?> map = (Map<?, ?>) value;
            final TypeDescriptor<? extends IVilType> any = TypeRegistry.anyType();
            if (0 == map.getSize() && 2 == map.getDimensionCount() 
                && any == map.getDimensionType(0) && any == map.getDimensionType(1)) {
                TypeDescriptor<? extends IVilType>[] params = TypeDescriptor.createArray(2);
                params[0] = type.getParameterType(0);
                params[1] = type.getParameterType(1);
                value = new Map<Object, Object>(params);
            }
        }
        return value;
    }
    
    @Override
    public boolean equals(Object object) {
        return map.equals(object);
    }
    
    @Override
    public int hashCode() {
        return map.hashCode();
    }

}
