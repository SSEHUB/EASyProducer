package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Iterator;

/**
 * Implements a pseudo class for iterators (handled internally).
 * 
 * @param <T> the element type
 * @author Holger Eichelberger
 */
@ClassEquivalentTo(Iterator.class)
@ClassMeta(name = Constants.TYPE_ITERATOR)
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
    
    // currently no get type as internal 

}
