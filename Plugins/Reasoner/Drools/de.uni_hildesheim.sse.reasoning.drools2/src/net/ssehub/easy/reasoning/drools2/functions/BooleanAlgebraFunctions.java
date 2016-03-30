package net.ssehub.easy.reasoning.drools2.functions;

/**
 * Wrapper (helper) class that holds Drools functions for Boolean Algebra operations.
 * Functions: XOR
 * @author Sizonenko
 *
 */
public class BooleanAlgebraFunctions {

    /**
     * Implementation for operation XOR.
     * @param param1 The first parameter (boolean).
     * @param param2 The second parameter (boolean).
     * @return returns the XOR of the two passed params.
     */
    public static boolean xor(boolean param1, boolean param2) {
        boolean result;
        if (param1 == param2) {
            result = false;
        } else {
            result = true;
        }
        return result;
    }
}
