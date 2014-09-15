package de.uni_hildesheim.sse.easy_producer.vtl;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.RandomDouble;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.RandomInteger;

/**
 * A default random extension for VTL.
 *
 * @author Holger Eichelberger
 */
public class Random {

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

}
