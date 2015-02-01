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
public abstract class AbstractListWrapper<T> extends AbstractCollectionWrapper<T> implements Collection<T> {

    private List<T> list;
    private TypeDescriptor<? extends IVilType>[] params;

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param registry the type registry to use for the conversion of <code>param</code>
     * @param param the type parameter characterizing <T>
     */
    public AbstractListWrapper(List<T> list, TypeRegistry registry, Class<? extends IVilType> param) {
        this.list = list;
        this.params = registry.convert(param);
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public AbstractListWrapper(List<T> list, TypeDescriptor<? extends IVilType>... params) {
        this.list = list;
        this.params = params;
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
    protected TypeDescriptor<? extends IVilType>[] getParams() {
        return params;
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
        return list.iterator();
    }

    @Override
    public int size() {
        return null == list ? 0 : list.size();
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
    
    @Override
    public boolean equals(Object object) {
        return list.equals(object);
    }
    
    @Override
    public int hashCode() {
        return list.hashCode();
    }

}
