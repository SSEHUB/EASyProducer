package net.ssehub.easy.instantiation.core.model.vilTypes;

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
        super(array, false, (TypeDescriptor<?>[]) null);
    }

    @Override
    public boolean isEquals(Collection<?> elements) {
        return equals(this, elements);
    }

    @Override
    public Collection<T> selectByType(TypeDescriptor<?> type) {
        return null;
    }

    @Override
    public Collection<T> selectByKind(TypeDescriptor<?> type) {
        return null;
    }

    @Override
    public Collection<T> typeReject(TypeDescriptor<?> type) {
        return null;
    }

    @Override
    public Sequence<T> asSequence() {
        return null;
    }

    @Override
    public Set<T> asSet() {
        return null;
    }

}
