package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * A "instantiator" for VIL sequences.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("createIntegerSequence")
public class IntegerSequenceConstructors implements IVilType {

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
        Integer[] values;
        if (end < start) {
            values = new Integer[0];
        } else {
            values = new Integer[end - start  + 1];
            for (int i = 0; i < values.length; i++) {
                values[i] = start + i;
            }
        }
        TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
        param[0] = TypeRegistry.integerType();
        return new ArraySequence<Integer>(values, param);
    }
    
}
