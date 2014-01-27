package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.List;

/**
 * Implements an array wrapper for the VIL sequence type which does not allow sequence
 * reordering {@link #allowSequenceAdjustment()}.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
public class FixedListSequence<T> extends ListSequence<T> {

    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param param the only type parameter characterizing <T>
     */
    public FixedListSequence(List<T> list, Class<? extends IVilType> param) {
        super(list, TypeRegistry.convert(param));
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public FixedListSequence(List<T> list, Class<? extends IVilType>... params) {
        super(list, TypeRegistry.convert(params));
    }
    
    /**
     * Creates a new array collection wrapper.
     * 
     * @param list the wrapped list
     * @param params the type parameter characterizing <T>
     */
    public FixedListSequence(List<T> list, TypeDescriptor<? extends IVilType>... params) {
        super(list, params);
    }
    
    @Override
    public boolean allowSequenceAdjustment() {
        return false;
    }

}
