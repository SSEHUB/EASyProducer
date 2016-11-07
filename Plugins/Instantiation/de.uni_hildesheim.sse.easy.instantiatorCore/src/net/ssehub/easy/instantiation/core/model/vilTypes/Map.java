package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.ExpressionEvaluator;

/**
 * Defines the VIL type "Map".
 *
 * @param <K> the key type of the map
 * @param <V> the value type of the map
 * 
 * @author Holger Eichelberger
 */
public class Map<K, V> implements IVilGenericType, IStringValueProvider {

    private java.util.Map<Object, Object> map = new HashMap<Object, Object>();
    private TypeDescriptor<?>[] generics;
    private TypeDescriptor<?> type;
    
    /**
     * Creates a new map.
     * 
     * @param types the parameter types of this map
     */
    Map(TypeDescriptor<?>[] types) {
        this(types, 0);
    }

    /**
     * Creates a new map.
     * 
     * @param types the parameter types of this map
     * @param size the initial size of this map
     */
    Map(TypeDescriptor<?>[] types, int size) {
        assert null != types && 2 == types.length;
        this.generics = types;
        try {
            this.type = TypeRegistry.getMapType(types);
        } catch (VilException e) {
            this.type = TypeRegistry.DEFAULT.findType(Map.class);
        }
        map = new HashMap<Object, Object>(size <= 0 ? 10 : size);
    }
    
    /**
     * Creates a map wrapper.
     * 
     * @param map the map to be wrapped
     * @param types the types in <code>map</code>
     */
    public Map(java.util.Map<Object, Object> map, TypeDescriptor<?>[] types) {
        assert null != types && 2 == types.length;
        this.generics = types;
        this.map = map;
        try {
            this.type = TypeRegistry.getMapType(types);
        } catch (VilException e) {
            this.type = TypeRegistry.DEFAULT.findType(Map.class);
        }
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
     * Returns the value assigned to <code>key</code>, if there is none <code>deflt</code>.
     * 
     * @param key the key to search the value for
     * @param deflt the default value if <code>key</code> does not exist 
     * @return the value for key (<code>deflt</code> if no key-value mapping is defined)
     */
    @OperationMeta(useGenericParameter = 1 )
    public V get(Object key, V deflt) {
        V result = deflt;
        if (containsKey(key)) {
            result = at(key);
        }
        return result;
    }

    /**
     * Returns the keys of this map.
     * 
     * @return the keys
     */
    public Set<K> keys() {
        return getKeys();
    }
    
    /**
     * Returns the keys of this map.
     * 
     * @return the keys
     */
    @SuppressWarnings("unchecked")
    public Set<K> getKeys() {
        Set<K> result = new SetSet<K>(new HashSet<K>());
        for (Object o : map.keySet()) {
            result.add((K) o);
        }
        return new UnmodifiableSet<K>(result);
    }

    /**
     * Returns the values of this map.
     * 
     * @return the values
     */
    @OperationMeta(useGenericParameter = 1)
    public Set<V> values() {
        return getValues();
    }

    /**
     * Returns the values of this map.
     * 
     * @return the values
     */
    @SuppressWarnings("unchecked")
    @OperationMeta(useGenericParameter = 1)
    public Set<V> getValues() {
        Set<V> result = new SetSet<V>(new HashSet<V>());
        for (Object o : map.keySet()) {
            result.add((V) o);
        }
        return new UnmodifiableSet<V>(result);
    }

    /**
     * Adds a key-value pair to this map and overrides existing mappings.
     * 
     * @param key the key for the mapping (<b>null</b> is ignored)
     * @param value the value of the mapping
     */
    @OperationMeta(genericArgument = {0, 1 })
    public void add(Object key, V value) {
        Object val = value;
        if (null != key) {
            if (2 == generics.length) {
                if (generics[1].isMap() && value instanceof Collection<?>) {
                    Collection<?> coll = (Collection<?>) value;
                    if (0 == coll.size()) {
                        TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
                        params[0] = generics[0];
                        params[1] = generics[1];
                        val = new Map<Object, Object>(params);
                    }
                }
                if (generics[1].isMap() && value instanceof Map<?, ?>) {
                    Map<?, ?> map = (Map<?, ?>) value;
                    if (0 == map.getSize() && isAnyMap(map) && !isAnyMap(this)) {
                        TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
                        params[0] = generics[1].getGenericParameterType(0);
                        params[1] = generics[1].getGenericParameterType(1);
                        val = new Map<Object, Object>(params);
                    }
                }
            }
            map.put(key, val);
        }
    }

    /**
     * Returns whether <code>map</code> is an <Any,Any> map.
     * 
     * @param map the map to test
     * @return <code>true</code> if it is an <Any,Any> map, <code>false</code> else
     */
    private static final boolean isAnyMap(Map<?, ?> map) {
        return isAny(map.generics[0]) && isAny(map.generics[1]);
    }
    
    /**
     * Returns whether <code>type</code> is Any.
     * 
     * @param type the type to test
     * @return <code>true</code> if <code>type</code> is Any, <code>false</code> else
     */
    private static final boolean isAny(TypeDescriptor<?> type) {
        return TypeRegistry.equals(TypeRegistry.anyType(), type);        
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
     * Clears all entries.
     */
    public void clear() {
        map.clear();
    }

    /**
     * Returns the number of dimensions of <code>T</code>.
     * 
     * @return the number of dimensions
     */
    @Invisible(inherit = true)
    public int getDimensionCount() {
        return generics.length;
    }
    

    @Override
    public TypeDescriptor<?> getType() {
        return type;
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
    public TypeDescriptor<?> getDimensionType(int index) {
        return generics[index];
    }
       
    /**
     * Converts the given sequence into a map.
     * 
     * @param sequence the sequence to be converted
     * @return the resulting map
     * @throws VilException in case that types or dimensions cannot be converted
     */
    @Conversion
    public static Map<?, ?> convert(Sequence<?> sequence) throws VilException {
        int seqSize = sequence.size();
        if (seqSize > 0 && sequence.getGenericParameterCount() != 2) {
            throw new VilException("sequence of dimension " + sequence.getGenericParameterCount() 
                + " cannot be converted into a map of dimension 2", VilException.ID_INVALID_TYPE);
        }
        TypeDescriptor<?>[] types = TypeDescriptor.createArray(2);
        if (seqSize > 0) {
            types[0] = sequence.getGenericParameterType(0);
            types[1] = sequence.getGenericParameterType(1);
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
                    throw new VilException("sequence in element " + e + "is not of size 2", 
                        VilException.ID_INVALID_TYPE);
                }
                result.map.put(seq.get(0), seq.get(1));
            } else {
                throw new VilException("element " + e + "is not a sequence", 
                    VilException.ID_INVALID_TYPE);
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
    public static Object checkConvertEmpty(TypeDescriptor<?> type, Object value) {
        if (type.isMap() && value instanceof Map<?, ?> && 2 == type.getGenericParameterCount()) {
            Map<?, ?> map = (Map<?, ?>) value;
            final TypeDescriptor<?> any = TypeRegistry.anyType();
            if (0 == map.getSize() && 2 == map.getDimensionCount() 
                && any == map.getDimensionType(0) && any == map.getDimensionType(1)) {
                TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
                params[0] = type.getGenericParameterType(0);
                params[1] = type.getGenericParameterType(1);
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
    
    /**
     * Converts back to a map for utilizing this with external classes.
     * 
     * @return the internal map
     */
    @Invisible
    public java.util.Map<Object, Object> toMap() {
        java.util.Map<Object, Object> result;
        if (null != map) {
            result = new HashMap<Object, Object>();
            result.putAll(map);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Sorts values in this map according to keys.
     * 
     * @param evaluator the evaluator
     * @return the map values sorted according to the keys
     * @throws VilException in case that evaluating fails
     */
    @OperationMeta(useGenericParameter = 1)
    public Sequence<V> sortByKeys(ExpressionEvaluator evaluator) throws VilException {
        List<K> sortedKeys = AbstractCollectionWrapper.sortImpl(keys().iterator(), evaluator);
        List<V> result = new ArrayList<V>(sortedKeys.size());
        for (K key : sortedKeys) {
            result.add(get(key));
        }
        return new ListSequence<V>(result, generics[1]); // see assertion in constructor
    }

    @Override
    @Invisible
    public String toString() {
        return map.toString();
    }

    /**
     * Translates this VIL map to a Java map.
     * 
     * @return the translated map
     */
    @Invisible
    public java.util.Map<K, V> toMappedMap() {
        java.util.Map<K, V> result = new HashMap<K, V>();
        for (K k : keys()) {
            result.put(k, get(k));
        }
        return result;
    }

}
