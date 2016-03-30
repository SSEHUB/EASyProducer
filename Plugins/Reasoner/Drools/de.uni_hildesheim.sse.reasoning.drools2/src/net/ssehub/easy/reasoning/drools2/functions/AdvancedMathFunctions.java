package net.ssehub.easy.reasoning.drools2.functions;

/**
 * Wrapper (helper) class that holds Drools functions for Advanced math operations.
 * Functions: min, max, div, mod, abs, floor, round
 * @author Sizonenko
 *
 */
public class AdvancedMathFunctions {

    /**
     * Implementation for operation min.
     * @param first Parameter one (int).
     * @param second Parameter two (int).
     * @return Minimum of two given parameters (int).
     */
    public static int min(int first, int second) {
        int result; 
        if (first <= second) {
            result = first;
        } else {
            result = second;
        } 
        return result;
    }
    
    /**
     * Implementation for operation max.
     * @param first Parameter one (int).
     * @param second Parameter two (int).
     * @return Minimum of two given parameters (int).
     */
    public static int max(int first, int second) {
        int result;
        if (first >= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation min.
     * @param first Parameter one (double).
     * @param second Parameter two (double).
     * @return Minimum of two given parameters (double).
     */
    public static double min(double first, double second) {
        double result;
        if (first <= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation max.
     * @param first Parameter one (double).
     * @param second Parameter two (double).
     * @return Minimum of two given parameters (double).
     */
    public static double max(double first, double second) {
        double result;
        if (first >= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation min.
     * @param first Parameter one (double).
     * @param second Parameter two (int).
     * @return Minimum of two given parameters (double).
     */
    public static double min(double first, int second) {
        double result;
        if (first <= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation max.
     * @param first Parameter one (double).
     * @param second Parameter two (int).
     * @return Minimum of two given parameters (double).
     */
    public static double max(double first, int second) {
        double result;
        if (first >= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation min.
     * @param first Parameter one (int).
     * @param second Parameter two (double).
     * @return Minimum of two given parameters (double).
     */
    public static double min(int first, double second) {
        double result;
        if (first <= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operation max.
     * @param first Parameter one (int).
     * @param second Parameter two (double).
     * @return Minimum of two given parameters (double).
     */
    public static double max(int first, double second) {
        double result;
        if (first >= second) {
            result = first;
        } else {
            result = second;
        }
        return result;
    }
    
    /**
     * Implementation for operations abs.
     * @param number parameter (int).
     * @return absolute value (int).
     */
    public static int abs(int number) {
        
        return Math.abs(number);
    }
    
    /**
     * Implementation for operations abs.
     * @param number parameter (double).
     * @return absolute value (double).
     */
    public static double abs(double number) {
        
        return Math.abs(number);
    }
    
    /**
     * Implementation for the operation floor.  
     * @param number parameter (double).
     * @return floor of the number (int).
     */
    public static int floor(double number) {
        return (int) Math.floor(number);
    }
    
    /**
     * Implementation for operation round.     
     * @param number parameter (double).
     * @return round (integer).
     */
    public static int round(double number) {
        return (int) Math.round(number);
    }
    
    /**
     * Implementation for operation mod.
     * @param first first parameter (int).
     * @param second second parameter (int).
     * @return modulus, an integer value.
     */
    public static int mod(int first, int second) {
        int mod = first % second;
        return mod;
    }
    
    /**
     * Implementation for operation mod.
     * @param first first parameter (int).
     * @param second second parameter (double).
     * @return modulus, a double value.
     */
    public static double mod(int first, double second) {
        double mod = first % second;
        return mod;
    }
    
    /**
     * Implementation for operation mod.
     * @param first first parameter (dobule).
     * @param second second parameter (int).
     * @return modulus, a double value.
     */
    public static double mod(double first, int second) {
        double mod = first % second;
        return mod;
    }
    
    /**
     * Implementation for operation mod.
     * @param first first parameter (double).
     * @param second second parameter (double).
     * @return modulus, a double value.
     */
    public static double mod(double first, double second) {
        double mod = first % second;
        return mod;
    }
    
    /**
     * Implementation for operation div.
     * @param first first parameter (int).
     * @param second second parameter (int).
     * @return The number of times that second fits completely within the first (int)
     */
    public static double div(int first, int second) {
        int div = first / second;
        return div;
    }
}
