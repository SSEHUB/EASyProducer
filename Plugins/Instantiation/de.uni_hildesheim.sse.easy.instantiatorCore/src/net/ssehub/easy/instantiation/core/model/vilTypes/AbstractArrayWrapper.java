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
public abstract class AbstractArrayWrapper<T> extends AbstractCollectionWrapper<T> implements Collection<T> {

    private T[] array;
    private TypeDescriptor<?>[] params;
    private TypeDescriptor<?> type;

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param set does this type  represent a set or a sequence
     * @param registry the type registry to use for the conversion of <code>param</code>
     * @param param the type parameter characterizing <T>
     */
    public AbstractArrayWrapper(T[] array, TypeRegistry registry, boolean set, Class<?> param) {
        this.array = array;
        this.params = registry.convert(param);
        this.type = constructType(this.params, set);
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param set does this type represent a set or a sequence
     * @param params the type parameter characterizing <T>
     */
    public AbstractArrayWrapper(T[] array, boolean set, TypeDescriptor<?>... params) {
        this.array = array;
        this.params = params;
        this.type = constructType(this.params, set);
    }
    
    /**
     * Returns the array for further use.
     * 
     * @return the array
     */
    protected T[] getArray() {
        return array;
    }
    
    /**
     * Returns the generic parameter for further use.
     * 
     * @return the generic parameter
     */
    protected TypeDescriptor<?>[] getGenericParameter() {
        return params;
    }
    
    /**
     * Removes duplicates from the given array.
     * 
     * @param <T> the element type
     * 
     * @param elements the elements to remove duplicates from (may be <b>null</b>)
     * @return an array of elements without duplicates, may be <b>null</b> if elements is <b>null</b>
     */
    @SuppressWarnings("unchecked")
    protected static <T> T[] removeDuplicates(T[] elements) {
        T[] result;
        if (null == elements) {
            result = null;
        } else {
            List<T> tmp = new ArrayList<T>(); // 2 collections - preserve sequence
            java.util.Set<T> known = new HashSet<T>();
            for (int e = 0; e < elements.length; e++) {
                T element = elements[e];
                if (!known.contains(element)) {
                    tmp.add(element);
                    known.add(element);
                }
            }
            result = (T[]) tmp.toArray();
        }
        return result;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int pos = 0;

            @Override
            public boolean hasNext() {
                return null != array && pos < array.length;
            }

            @Override
            public T next() {
                return array[pos++];
            }
            
            @Override
            public void remove() {
                throw new UnsupportedOperationException("remove");
            }

        };
    }

    @Override
    public int size() {
        return null == array ? 0 : array.length;
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
    
    /**
     * Extends the capacity by <code>increment</code>.
     * 
     * @param increment the increment
     */
    protected void extendCapacity(int increment) {
        if (increment > 0) {
            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Object[array.length + increment];
            System.arraycopy(array, 0, tmp, 0, array.length);
            array = tmp;
        }
    }
    
    /**
     * Decreases the capacity.
     * 
     * @param decrement the decrement for decreasing the capacity
     */
    protected void decreaseCapacity(int decrement) {
        if (decrement > 0 && array.length - decrement >= 0) {
            @SuppressWarnings("unchecked")
            T[] tmp = (T[]) new Object[array.length - decrement];
            if (tmp.length > 0) {
                System.arraycopy(array, 0, tmp, 0, tmp.length);
            }
            array = tmp;
        }
    }

    @Override
    public boolean equals(Object object) {
        return null == array ? object == null : array.equals(object);
    }
    
    @Override
    public int hashCode() {
        return null == array ? super.hashCode() : array.hashCode();
    }

    /**
     * Turns the array into a list for mapping to external Java types.
     * 
     * @return the list
     */
    @Invisible
    public java.util.List<T> toMappedList() {
        java.util.List<T> result;
        if (null != array) {
            result = new ArrayList<T>(array.length);
            for (int i = 0; i < array.length; i++) {
                result.add(array[i]);
            }
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
        if (null != array) {
            result = new HashSet<T>(array.length);
            for (int i = 0; i < array.length; i++) {
                result.add(array[i]);
            }
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Removes the first occurrence of the given element from this sequence.
     * 
     * @param element the element to be removed
     * @return <code>true</code> of the element was removed, <code>false</code> else
     */
    public boolean remove(T element) {
        int shift = 0;
        if (null != element) {
            T[] array = getArray();
            for (int t = 0; t < array.length; t++) {
                boolean found = false;
                if (0 == shift) {
                    if (null == element) {
                        found = array[t] == null;
                    } else if (element.equals(array[t])) {
                        found = true;
                    }
                    if (found) {
                        shift++;
                    }
                }
                if (shift > 0 && t - shift > 0) {
                    array[t - shift] = array[t];
                }
            }
            if (shift > 0) {
                decreaseCapacity(1);
            }
        }
        return shift > 0;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        array = (T[]) new Object[0];        
    }

}
