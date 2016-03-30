package net.ssehub.easy.reasoning.drools2.functions;

/**
 * Wrapper (helper) class that holds Drools def functions.
 * Functions: size()
 * @author Sizonenko
 *
 */
public class DefFunctions {

    /**
     * Implementation for the operation size().
     * @param value Object.
     * @return if value is null returns false.
     */
    public static boolean isDefined(Object value) {
        boolean isDefined = false;
        if ((Object) value != null) {
            isDefined = true;
        }
        return isDefined;
    }
    
    
}
