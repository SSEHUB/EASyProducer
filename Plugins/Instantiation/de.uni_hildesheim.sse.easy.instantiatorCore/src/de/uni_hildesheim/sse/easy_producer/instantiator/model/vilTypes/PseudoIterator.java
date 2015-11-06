package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.Iterator;

/**
 * Implements a pseudo class for iterators (handled internally).
 * 
 * @param <T> the element type
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_ITERATOR, equiv = Iterator.class)
public class PseudoIterator<T> implements IVilType, IStringValueProvider {

    public static final String STRING_VALUE = "<Iterator>";
    
    /**
     * Prevents external instantiation.
     */
    protected PseudoIterator() {
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return STRING_VALUE;
    }

}
