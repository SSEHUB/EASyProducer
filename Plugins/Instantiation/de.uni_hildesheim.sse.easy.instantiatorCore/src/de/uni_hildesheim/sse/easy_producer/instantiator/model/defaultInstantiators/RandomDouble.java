package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Constants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * A random "instantiator" for VIL.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("random")
public class RandomDouble implements IVilType {

    // enables tests to switch to a fixed number.
    private static boolean tests = false;
    
    /**
     * Allows to set the test flag.
     * 
     * @param inTests whether we are running tests and constant numbers shall be returned
     * @return the value before setting the flag
     */
    @Invisible
    public static boolean setInTests(boolean inTests) {
        boolean old = tests;
        tests = inTests;
        return old;
    }
    
    /**
     * Returns whether we are in test mode.
     * 
     * @return whether we are running tests and constant numbers shall be returned
     */
    static boolean isInTests() {
        return tests;
    }
    
    /**
     * Returns a random double number.
     * 
     * @return a random double number
     */
    public static double random() {
        double result;
        if (tests) {
            result = 0.1;
        } else {
            result = Constants.RANDOM.nextDouble();
        }
        return result;
    }
    
}
