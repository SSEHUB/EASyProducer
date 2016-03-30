package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Implements an array wrapper for the VIL collection type.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public abstract class AbstractListWrapper<T> extends AbstractCollectionWrapper<T> implements Collection<T> {

    private List<T> list;
    private TypeDescriptor<?> type;
    private TypeDescriptor<?>[] params;

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param set does this type represent a set or a sequence
     * @param registry the type registry to use for the conversion of <code>param</code>
     * @param param the type parameter characterizing <T>
     */
    public AbstractListWrapper(List<T> list, TypeRegistry registry, boolean set, Class<?> param) {
        this.list = list;
        this.params = registry.convert(param);
        this.type = constructType(this.params, set);
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param set does this type represent a set or a sequence
     * @param params the type parameter characterizing <T>
     */
    public AbstractListWrapper(List<T> list, boolean set, TypeDescriptor<?>... params) {
        this.list = list;
        this.params = params;
        this.type = constructType(this.params, set);
    }
    
    /**
     * Removes duplicates from the given list.
     * 
     * @param <T> the element type
     * 
     * @param elements the elements to remove duplicates from (may be <b>null</b>)
     * @return a list of elements without duplicates, may be <b>null</b> if elements is <b>null</b>
     */
    protected static <T> List<T> removeDuplicates(List<T> elements) {
        List<T> result;
        if (null == elements) {
            result = null;
        } else {
            result = new ArrayList<T>(); // 2 collections - preserve sequence
            java.util.Set<T> known = new HashSet<T>();
            int size = elements.size();
            for (int e = 0; e < size; e++) {
                T element = elements.get(e);
                if (!known.contains(element)) {
                    result.add(element);
                    known.add(element);
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the list for further use.
     * 
     * @return the list
     */
    protected List<T> getList() {
        return list;
    }
    
    /**
     * Returns the params for further use.
     * 
     * @return the params
     */
    protected TypeDescriptor<?>[] getGenericParameter() {
        return params;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public int size() {
        return null == list ? 0 : list.size();
    }

    @Override
    public int getGenericParameterCount() {
        return null == params ? 0 : params.length;
    }

    @Override
    public TypeDescriptor<?> getGenericParameterType(int index) {
        if (null == params) {
            throw new IndexOutOfBoundsException();
        }
        return params[index];
    }
    
    @Override
    public TypeDescriptor<?> getType() {
        return type;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return StringValueHelper.getStringValue(this, comparator);
    }

    @Override
    public boolean allowSequenceAdjustment() {
        return true;
    }
    
    @Override
    public boolean equals(Object object) {
        return list.equals(object);
    }
    
    @Override
    public int hashCode() {
        return list.hashCode();
    }

    /**
     * Turns the array into a list for mapping to external Java types.
     * 
     * @return the list
     */
    @Invisible
    public java.util.List<T> toMappedList() {
        java.util.List<T> result;
        if (null != list) {
            result = new ArrayList<T>(list.size());
            result.addAll(list);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Turns the array into a set for mapping to external Java types.
     * 
     * @return the list
     */
    @Invisible
    public java.util.Set<T> toMappedSet() {
        java.util.Set<T> result;
        if (null != list) {
            result = new HashSet<T>(list.size());
            result.addAll(list);
        } else {
            result = null;
        }
        return result;
    }

    @Override
    @Invisible
    public String toString() {
        return list.toString();
    }

}
