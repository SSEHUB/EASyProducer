package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

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
