package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

/**
 * A simple internal iterator/iterable for arrays.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
class ArrayIterable <T> implements Iterable<T> {
    
    private ArraySequence<T> wrapper;
    
    /**
     * Creates a new iterable.
     * 
     * @param array the array to iterate over
     */
    public ArrayIterable(T[] array) {
        wrapper = new ArraySequence<T>(array, (TypeDescriptor<?>[]) null);
    }
    
    @Override
    public Iterator<T> iterator() {
        return wrapper.iterator();
    }

}