package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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
    @ReturnGenerics(Integer.class)
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
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = TypeRegistry.integerType();
        return new ArraySequence<Integer>(values, param);
    }
    
}
