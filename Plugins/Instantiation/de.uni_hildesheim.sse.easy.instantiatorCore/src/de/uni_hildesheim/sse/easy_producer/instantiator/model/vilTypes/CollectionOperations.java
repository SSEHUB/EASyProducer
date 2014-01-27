package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Defines basic collection operations. This cannot be done
 * in {@link Collection} as it is an interface.
 * 
 * @author Holger Eichelberger
 */
public class CollectionOperations {

    /**
     * Defines the equality operation based on {@link Collection#isEquals(Collection)}.
     * 
     * @param c1 the first collection to be compared
     * @param c2 the second collection to be compared
     * @return <code>true</code> if both collections are considered to be equal, <code>false</code> else
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean isEquals(Collection<?> c1, Collection<?> c2) {
        boolean result;
        if (null == c1) {
            result = (c2 == null);
        } else {
            result = c1.isEquals(c2);
        }
        return result;
    }

}
