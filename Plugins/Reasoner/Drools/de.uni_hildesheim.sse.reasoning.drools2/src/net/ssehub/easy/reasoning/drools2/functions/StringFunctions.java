package net.ssehub.easy.reasoning.drools2.functions;

/**
 * Wrapper (helper) class that holds Drools functions for String operations.
 * Functions: size()
 * @author Sizonenko
 *
 */
public class StringFunctions {

    /**
     * Implementation for the operation size().
     * @param str String.
     * @return Size of the string (int).
     */
    public static int size(String str) {
        return str.length();
    }
    
    /**
     * Implementation for the operation toInteger.
     * @param str String.
     * @return Integer value of the string.
     */
    public static int toInteger(String str) {
        return Integer.valueOf(str);
    }
    
    /**
     * Implementation for the operation toInteger.
     * @param str String.
     * @return Real value of the string.
     */
    public static double toReal(String str) {
        return Double.valueOf(str);
    }
    
    /**
     * Implementation for the operation concat.
     * @param str1 The first string.
     * @param str2 The second string.
     * @return Concatenated string.
     */
    public static String concat(String str1, String str2) {
        return str1.concat(str2);
    }
    
    /**
     * Implementation for the operation substring.
     * @param str1 String.
     * @param initialIndex The beginning index.
     * @param endIndex The ending index.
     * @return The substring.
     */
    public static String substring(String str1, int initialIndex, int endIndex) {
        return str1.substring(initialIndex, endIndex);
    }
    
    /**
     * Implementation for operation substitutes.
     * @param str1 Operand, string one
     * @param str2 Parameter one.
     * @param str3 Parameter Two.
     * @return Substituted string.
     */
    public static String substitutes(String str1, String str2, String str3) {
        str1 = str1.replaceAll(str2, str3);
        return str1;
    }
    
    /**
     * Implementation for the operation matches.
     * @param str1 String.
     * @param str2 regular expression (regex).
     * @return <b>True</b> if the regex. matches the string.
     */
    public static boolean matches(String str1, String str2) {
        return str1.matches(str2);
    }
}
