package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;

/**
 * A default random extension for VTL.
 *
 * @author Holger Eichelberger
 */
public class DefaultVtlJavaExtension {

    /**
     * Returns a random double number.
     * 
     * @return a random double number
     */
    public static double random() {
        return RandomDouble.random();
    }

    /**
     * Returns a random integer number.
     * 
     * @return a random integer number
     */
    public static int randomInteger() {
        return RandomInteger.randomInteger();
    }

    /**
     * Returns a random integer number between 0 and <code>max</code> (exclusive).
     * 
     * @param max the maximum (exclusive) value
     * @return the random integer number
     */
    public static int randomInteger(int max) {
        return RandomInteger.randomInteger(max);
    }
    
    /**
     * Creates a sequence from <code>start</code> to <code>end</code>.
     * <b>Caution:</b> This is currently a real enumeration intended for simple loops. To be more efficient,
     * a wrapper implementation for the range from <code>start</code> to <code>end</code> shall be implemented 
     * and used instead.
     * 
     * @param start the start integer
     * @param end the end integer
     * @return a random double number
     */
    @OperationMeta(returnGenerics = Integer.class)
    public static Sequence<Integer> createIntegerSequence(int start, int end) {
        return IntegerSequenceConstructors.createIntegerSequence(start, end);
    }

}
