package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Iterates over the operations of a {@link TypeDescriptor} (simplyify testing).
 * 
 * @author Holger Eichelberger
 */
class OperationsIterator implements Iterable<OperationDescriptor>, Iterator<OperationDescriptor> {

    private TypeDescriptor<?> descriptor;
    private int pos = 0;

    /**
     * Creates a new iterator.
     * 
     * @param descriptor the descriptor to iterate over
     */
    public OperationsIterator(TypeDescriptor<?> descriptor) {
        this.descriptor = descriptor;
    }
    
    @Override
    public boolean hasNext() {
        return pos < descriptor.getOperationsCount();
    }

    @Override
    public OperationDescriptor next() {
        return descriptor.getOperation(pos++);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<OperationDescriptor> iterator() {
        return this;
    }

}
