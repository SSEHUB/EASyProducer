package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

/**
 * Implements a pseudo class for strings.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_STRING, equiv = String.class)
public class PseudoString implements IVilType {

    /**
     * Prevents external instantiation.
     */
    protected PseudoString() {
    }
    
    /**
     * Represents the string concatenation operation.
     * 
     * @param s1 the first String to be considered
     * @param s2 the second String to be considered
     * @return s1 + s2
     */
    @OperationMeta(name = Constants.ADDITION, opType = OperationType.INFIX)
    public static String concat(String s1, String s2) {
        String result;
        if (null == s1) {
            result = s2;
        } else if (null == s2) {
            result = s1;
        } else {
            result = s1 + s2;
        }
        return result;
    }
    
    /**
     * Represents the equality operation for Strings.
     * 
     * @param s1 the first boolean to be considered
     * @param s2 the second boolean to be considered
     * @return s1 == s2
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(String s1, String s2) {
        return (s1 == null && s2 == null) || (s1 != null && s1.equals(s2));
    }
    
    /**
     * Represents the unequality operation for Strings.
     * 
     * @param s1 the first boolean to be considered
     * @param s2 the second boolean to be considered
     * @return s1 != s2
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS }, opType = OperationType.INFIX)
    public static boolean unequals(String s1, String s2) {
        return (s1 == null && s2 == null) || (s1 != null && !s1.equals(s2));
    }
    
    /**
     * The length of the string.
     * 
     * @param string the string to return the length for
     * @return the length of the string
     */
    public static int length(String string) {
        return null == string ? 0 : string.length();
    }
    
    /**
     * Returns whether <code>string</code> matches the given regular expression.
     * 
     * @param string the string to be considered
     * @param regEx the (Java) regular expression
     * @return <code>true</code> if it matches, <code>false</code> else
     */
    public static boolean matches(String string, String regEx) {
        boolean result;
        if (null != string && null != regEx) {
            result = string.matches(regEx);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Replaces all occurrences of <code>regEx</code> in <code>string</code> by 
     * <code>replacement</code>.
     * 
     * @param string the string to be considered as basis
     * @param regEx the Java regular expression to be replaced
     * @param replacement the replacement string
     * @return the modified string
     */
    public static String substitute(String string, String regEx, String replacement) {
        return string.replaceAll(regEx, replacement);
    }

    /**
     * Replaces all occurrences of <code>search</code> in <code>string</code> by 
     * <code>replacement</code>.
     * 
     * @param string the string to be considered as basis
     * @param search the search string to be replaced
     * @param replacement the replacement string
     * @return the modified string
     */
    public static String replace(String string, String search, String replacement) {
        return string.replace(search, replacement);
    }
    
    /**
     * Turns the given string into an integer.
     * 
     * @param string the input string
     * @return the converted integer (<b>null</b> if conversion is not possible)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static Integer toInteger(String string) {
        Integer result;
        try {
            result = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            result = null; // lazy eval
        }
        return result;
    }

    /**
     * Turns the given string into a double.
     * 
     * @param string the input string
     * @return the converted double (<b>null</b> if conversion is not possible)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static Double toReal(String string) {
        Double result;
        try {
            result = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            result = null; // lazy eval
        }
        return result;
    }

    /**
     * Returns the specified substring of <code>in</code>.
     * 
     * @param in the string to be considered
     * @param start the inclusive start position
     * @param end the exclusive end position
     * @return the substring (or <b>in</b> in case of any parameter problem)
     */
    public static String substring(String in, int start, int end) {
        String result;
        if (null != in && start >= 0 && start < end && end <= in.length() - 1) {
            result = in.substring(start, end);
        } else {
            result = in;
        }
        return result;
    }

    /**
     * Transforms all characters to upper case.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String toUpperCase(String string) {
        return string.toUpperCase();
    }

    /**
     * Transforms all characters to lower case.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String toLowerCase(String string) {
        return string.toLowerCase();
    }

    /**
     * Turns the first character into an upper case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String firstToUpperCase(String string) {
        return StringValueHelper.firstToUpperCase(string);
    }

    /**
     * Turns the first character into a lower case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String firstToLowerCase(String string) {
        return StringValueHelper.firstToLowerCase(string);
    }

    /**
     * Turns the given <code>string</code> into a typical (Java) programming language identifier by removing all
     * non identifier characters.
     * 
     * @param string the string to be turned into an identifier
     * @return the identifier (may be empty in the extreme case)
     */
    public static String toIdentifier(String string) {
        StringBuilder tmp = new StringBuilder(string);
        for (int i = tmp.length() - 1; i >= 0; i--) {
            if (!Character.isJavaIdentifierPart(tmp.charAt(i))) {
                tmp.deleteCharAt(i);
            }
        }
        return tmp.toString();
    }

    /**
     * The last resort - converts any object to a String using {@link StringValueHelper}.
     * This operation is absolutely necessary as the operation resolution in 
     * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression}
     * tries to find a matching operation with operand converted to String using this method.
     * 
     * @param any the object to be converted
     * @return the resulting value
     */
    @Conversion
    public static String convertAny(Object any) {
        return StringValueHelper.getStringValue(any, null);
    }
    
}
