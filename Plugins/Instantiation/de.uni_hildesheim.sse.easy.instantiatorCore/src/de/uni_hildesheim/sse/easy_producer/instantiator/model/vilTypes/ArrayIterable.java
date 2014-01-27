package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * A simple internal iterator/iterable for arrays.
 * 
 * @author Holger Eichelberger
 *
 * @param <T> the element type
 */
class ArrayIterable <T> extends AbstractArrayWrapper<T> {
    
    /**
     * Creates a new iterable.
     * 
     * @param array the array to iterate over
     */
    public ArrayIterable(T[] array) {
        super(array, (TypeDescriptor<? extends IVilType>[]) null);
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return equals(this, elements);
    }

}
