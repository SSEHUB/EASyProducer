package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;

/**
 * A random "instantiator" for VIL.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("randomInteger")
public class RandomInteger implements IVilType {

    /**
     * Returns a random integer number.
     * 
     * @return a random integer number
     */
    public static int randomInteger() {
        int result;
        if (RandomDouble.isInTests()) {
            result = 1;
        } else {
            result = Constants.RANDOM.nextInt();
        }
        return result;
    }

    /**
     * Returns a random integer number between 0 and <code>max</code> (exclusive).
     * 
     * @param max the maximum (exclusive) value
     * @return the random integer number
     */
    public static int randomInteger(int max) {
        int result;
        if (RandomDouble.isInTests()) {
            result = Math.max(0, max - 1);
        } else {
            result = Constants.RANDOM.nextInt(max);
        }
        return result;
    }
    
}
