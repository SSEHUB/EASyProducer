package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

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
    private TypeDescriptor<? extends IVilType>[] params;

    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param registry the type registry to use for the conversion of <code>param</code>
     * @param param the type parameter characterizing <T>
     */
    public AbstractArrayWrapper(T[] array, TypeRegistry registry, Class<? extends IVilType> param) {
        this.array = array;
        this.params = registry.convert(param);
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param array the wrapped array
     * @param params the type parameter characterizing <T>
     */
    public AbstractArrayWrapper(T[] array, TypeDescriptor<? extends IVilType>... params) {
        this.array = array;
        this.params = params;
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
     * Returns the params for further use.
     * 
     * @return the params
     */
    protected TypeDescriptor<? extends IVilType>[] getParams() {
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
    
    /**
     * Returns the parameter for further use.
     * 
     * @return the parameter
     */
    protected TypeDescriptor<? extends IVilType>[] getParameter() {
        return params;
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
                throw new UnsupportedOperationException();
            }

        };
    }

    @Override
    public int size() {
        return null == array ? 0 : array.length;
    }

    @Override
    public int getDimensionCount() {
        return null == params ? 0 : params.length;
    }

    @Override
    public TypeDescriptor<? extends IVilType> getDimensionType(int index) {
        if (null == params) {
            throw new IndexOutOfBoundsException();
        }
        return params[index];
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
     * @param decrement the decrement for decreasing the capactiy
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
        return array.equals(object);
    }
    
    @Override
    public int hashCode() {
        return array.hashCode();
    }

}
