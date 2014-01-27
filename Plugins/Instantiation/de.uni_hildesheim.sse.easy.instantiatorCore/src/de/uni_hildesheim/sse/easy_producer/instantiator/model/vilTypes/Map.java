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
    @SuppressWarnings("unused")
    private Map(TypeDescriptor<? extends IVilType>[] types) {
        this(types, 0);
    }

    /**
     * Creates a new map.
     * 
     * @param types the parameter types of this map
     * @param size the initial size of this map
     */
    private Map(TypeDescriptor<? extends IVilType>[] types, int size) {
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
     * Returns the value assigned to <code>key</code>.
     * 
     * @param key the key to search the value for
     * @return the value for key (may be <b>null</b>)
     */
    public V get(Object key) {
        return at(key);
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
        if (sequence.getDimensionCount() != 2) {
            throw new ArtifactException("sequence of dimension " + sequence.getDimensionCount() 
                + "cannot be conerted into a map of dimension 2", ArtifactException.ID_INVALID_TYPE);
        }
        int seqSize = sequence.size();
        TypeDescriptor<? extends IVilType>[] types = TypeDescriptor.createArray(2);
        types[0] = sequence.getDimensionType(0);
        types[1] = sequence.getDimensionType(1);
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

}
