package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.IllegalFormatException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import net.ssehub.easy.instantiation.core.model.common.ExecutionLocal;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Implements a pseudo class for strings.
 * 
 * @author Holger Eichelberger
 */
@ClassMeta(name = Constants.TYPE_STRING, equiv = String.class)
public class PseudoString implements IVilType {

    @DefaultValue
    public static final String DEFAULT = "";
    
    /**
     * Prevents external instantiation.
     */
    protected PseudoString() {
    }
    
    /**
     * Represents the string concatenation operation.
     * 
     * @param s1 the first String to be considered
     * @param s2 the second String (as object)to be considered
     * @return s1 + s2
     */
    @OperationMeta(name = {Constants.ADDITION}, opType = OperationType.INFIX)
    public static String plus(String s1, Object s2) {
        String result;
        String s2Tmp = null == s2 ? null : s2.toString();
        if (null == s1) {
            result = s2Tmp;
        } else if (null == s2) {
            result = s1;
        } else {
            result = s1 + s2Tmp;
        }
        return result;
    }
    
    /**
     * Represents the string concatenation operation.
     * 
     * @param s1 the first String to be considered
     * @param s2 the second String (as object)to be considered
     * @return s1 + s2
     */
    public static String concat(String s1, Object s2) {
        return plus(s1, s2);
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
    @OperationMeta(name = {"length", "size"})
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
     * Splits this string around matches of the given Java regular expression.
 
     * @param string the string to be split
     * @param regEx the delimiting regular expression
     * @return the splitted string
     */
    @OperationMeta(returnGenerics = String.class)
    public static Sequence<String> split(String string, String regEx) {
        Sequence<String> result;
        if (null == string || null == regEx) {
            result = null;
        } else {
            String[] tmp = string.split(regEx);
            if (null == tmp) {
                tmp = new String[0];
            } 
            TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
            param[0] = TypeRegistry.stringType();
            result = new ArraySequence<String>(tmp, param);
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
     * @see #matchInteger(String)
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
     * Returns whether <code>string</code> represents an Integer value. (QVT)
     * 
     * @param string the string to test
     * @return <code>true</code> if <code>string</code> represents an Integer value, <code>false</code else>
     * @see #toInteger(String)
     */
    public static boolean matchInteger(String string) {
        boolean result;
        try {
            Integer.parseInt(string);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
    
    /**
     * Turns the given string into a double.
     * 
     * @param string the input string
     * @return the converted double (<b>null</b> if conversion is not possible)
     * @see #matchReal(String)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static Double toReal(String string) {
        Double result;
        if (null == string) {
            result = null;
        } else {
            try {
                result = Double.parseDouble(string);
            } catch (NumberFormatException e) {
                result = null; // lazy eval
            }
        }
        return result;
    }

    /**
     * Returns whether <code>string</code> represents a Real value. (QVT)
     * 
     * @param string the string to test
     * @return <code>true</code> if <code>string</code> represents a Real
     * @see #toReal(String)
     */
    public static boolean matchReal(String string) {
        boolean result;
        try {
            Double.parseDouble(string);
            result = true;
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }

    /**
     * Turns the given string into a Boolean. False is implicitly assumed for all
     * values that do not represent true.
     * 
     * @param string the input string
     * @return the converted Boolean (<b>null</b> if conversion is not possible)
     * @see #matchBoolean(String)
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static Boolean toBoolean(String string) {
        Boolean result;
        if (null != string) {
            result = "true".equalsIgnoreCase(string); // <-> matchBoolean
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns whether <code>string</code> represents a Boolean value. (QVT)
     * 
     * @param string the string to test
     * @return <code>true</code> if <code>string</code> represents a Boolean
     * @see #toBoolean(String)
     */
    public static boolean matchBoolean(String string) {
        return string.equalsIgnoreCase("true") || string.equalsIgnoreCase("false");
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
        int s = OclKeyWords.toJavaIndex(start);
        int e = OclKeyWords.toJavaIndex(end);
        if (null != in && s >= 0 && s < e && e <= in.length()) {
            result = in.substring(s, e);
        } else {
            result = in;
        }
        return result;
    }
    
    /**
     * Returns the specified substring of <code>in</code> from <code>start</code> to end of <code>in</code>.
     * 
     * @param in the string to be considered
     * @param start the inclusive start position
     * @return the substring (or <b>in</b> in case of any parameter problem)
     */
    public static String substring(String in, int start) {
        String result;
        int s = OclKeyWords.toJavaIndex(start);
        if (null != in && s >= 0 && s < in.length()) {
            result = in.substring(s);
        } else {
            result = in;
        }
        return result;
    }

    /**
     * Returns whether the given <code>string</code> has the given <code>prefix</code>. 
     * 
     * @param string the string to be considered
     * @param prefix the prefix
     * @return <code>true</code> if <code>string</code> starts with <code>prefix</code>, <code>false</code> else
     */
    public static boolean startsWith(String string, String prefix) {
        boolean result;
        if (null != string) {
            result = string.startsWith(prefix);
        } else {
            result = false;
        }
        return result;
    }

    /**
     * Returns whether the given <code>string</code> has the given <code>postfix</code>. 
     * 
     * @param string the string to be considered
     * @param postfix the postfix
     * @return <code>true</code> if <code>string</code> ends with <code>postfix</code>, <code>false</code> else
     */
    public static boolean endsWith(String string, String postfix) {
        boolean result;
        if (null != string) {
            result = string.endsWith(postfix);
        } else {
            result = false;
        }
        return result;
    }
    
    /**
     * Transforms the <code>string</code> by removing all leading and trailing spaces. (QVT)
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    public static String trim(String string) {
        return string.trim();
    }
    
    /**
     * Normalizes spaces, i.e., trims and replaces all internal multi-whitespaces by a single one. (QVT)
     * 
     * @param string the string to normalize
     * @return the normalized string
     */
    public static String normalizeSpace(String string) {
        String result = string.trim();
        do {
            result = result.replace("  ", " ");
        } while (result.indexOf("  ") >= 0);
        return result;
    }

    /**
     * Returns the substring of <code>string</code> before the (first) occurrence of
     * <code>match</code>. (QVT)
     * 
     * @param string the string to search within
     * @param match the string to match for
     * @return the substring before the match, an empty string in case of no match
     */
    public static String substringBefore(String string, String match) {
        String result;
        int pos = string.indexOf(match);
        if (pos >= 0) {
            result = string.substring(0, pos);
        } else {
            result = "";
        }
        return result;
    }

    /**
     * Returns the substring of <code>string</code> after the (first) occurrence of
     * <code>match</code>. (QVT)
     * 
     * @param string the string to search within
     * @param match the string to match for
     * @return the substring after the match, an empty string in case of no match
     */
    public static String substringAfter(String string, String match) {
        String result;
        int pos = string.indexOf(match);
        if (pos >= 0) {
            result = string.substring(pos + match.length());
        } else {
            result = "";
        }
        return result;
    }

    /**
     * Transforms all characters to upper case.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"toUpperCase", "toUpper"})
    public static String toUpperCase(String string) {
        return string.toUpperCase(ExecutionLocal.getCurrentLocale());
    }

    /**
     * Transforms all characters to lower case.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"toLowerCase", "toLower"})
    public static String toLowerCase(String string) {
        return string.toLowerCase(ExecutionLocal.getCurrentLocale());
    }

    /**
     * Turns the first character into an upper case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"firstToUpper", "firstToUpperCase"})
    public static String firstToUpperCase(String string) {
        return StringValueHelper.firstToUpperCase(string, ExecutionLocal.getCurrentLocale());
    }

    /**
     * Turns the first character into a lower case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"firstToLower", "firstToLowerCase"})
    public static String firstToLowerCase(String string) {
        return StringValueHelper.firstToLowerCase(string, ExecutionLocal.getCurrentLocale());
    }
    
    /**
     * Turns the last character into an upper case character (QVT).
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"lastToUpper", "lastToUpperCase"})
    public static String lastToUpperCase(String string) {
        return StringValueHelper.lastToUpperCase(string, ExecutionLocal.getCurrentLocale());
    }

    /**
     * Turns the last character into a lower case character.
     * 
     * @param string the string to be transformed
     * @return the transformed string
     */
    @OperationMeta(name = {"lastToLower", "lastToLowerCase"})
    public static String lastToLowerCase(String string) {
        return StringValueHelper.lastToLowerCase(string, ExecutionLocal.getCurrentLocale());
    }

    /**
     * Turns the given <code>string</code> into a (Java) programming language identifier by removing all
     * non identifier characters.
     * 
     * @param string the string to be turned into an identifier
     * @return the identifier (may be empty in the extreme case)
     * 
     * @see #matchIdentifier(String)
     */
    public static String toIdentifier(String string) {
        // see matchIdentifier
        StringBuilder tmp = new StringBuilder(string);
        deleteNonJavaIdentifierParts(tmp);
        return tmp.toString();
    }

    /**
     * Deletes non-Java identifier parts from <code>name</code>.
     * 
     * @param name the name to clean
     */
    private static void deleteNonJavaIdentifierParts(StringBuilder name) {
        for (int i = name.length() - 1; i >= 0; i--) {
            if (!Character.isJavaIdentifierPart(name.charAt(i))) {
                name.deleteCharAt(i);
            }
        }
    }

    /**
     * Turns the given <code>string</code> into a typical (Java) camel-case programming language identifier by 
     * turning all lower case characters after whitespaces into upper case characters and removing all non-Java
     * identifier parts (akin to {@link #toIdentifier(String)}.
     * 
     * @param string the string to be turned into an identifier
     * @return the identifier (may be empty in the extreme case)
     * 
     * @see #matchIdentifier(String)
     */
    public static String toCamelCaseIdentifier(String string) {
        // see matchIdentifier
        StringBuilder tmp = new StringBuilder(string);
        for (int i = tmp.length() - 1; i >= 0; i--) {
            char c = tmp.charAt(i);
            if (Character.isWhitespace(c) && i + 1 < tmp.length()) {
                char cNext = tmp.charAt(i + 1);
                if (Character.isLowerCase(cNext)) {
                    tmp.setCharAt(i + 1, Character.toUpperCase(cNext));
                }
            }
        }
        deleteNonJavaIdentifierParts(tmp);
        return tmp.toString();
    }
    
    /**
     * Returns whether <code>string</code> complies with the rules for a Java identifier. (QVT)
     * If <code>true</code>, {@link #toIdentifier(String)} returns <code>string</code>, 
     * else a string with all characters removed that are not allowed in a Java identifier.
     * 
     * @param string the string to be tested
     * @return <code>true</code> if <code>string</code> represents an identifier, <code>false</code> else
     */
    public static boolean matchIdentifier(String string) {
        // see toIdentifier
        boolean isIdentifier = true;
        for (int i = string.length() - 1; isIdentifier && i >= 0; i--) {
            isIdentifier = Character.isJavaIdentifierPart(string.charAt(i));
        }
        return isIdentifier;
    }

    /**
     * The last resort - converts any object to a String using {@link StringValueHelper}.
     * This operation is absolutely necessary as the operation resolution in 
     * {@link net.ssehub.easy.instantiation.core.model.expressions.AbstractCallExpression}
     * tries to find a matching operation with operand converted to String using this method.
     * 
     * @param any the object to be converted
     * @return the resulting value
     */
    @Conversion
    public static String convertAny(Object any) {
        return StringValueHelper.getStringValue(any, null);
    }

    /**
     * Tokenizes the given <code>string</code> along <code>delimiters</code>.
     * 
     * @param string the string to tokenize
     * @param delimiters the delimiters between two tokens. Delimiter characters themselves will not
     *     be treated as tokens.
     * @return the tokens in sequence of occurrence
     */
    @OperationMeta(returnGenerics = String.class)
    public static Sequence<String> tokenize(String string, String delimiters) {
        Sequence<String> result;
        if (null != string) {
            StringTokenizer tokenizer = new StringTokenizer(string, delimiters);
            String[] tmp = new String[tokenizer.countTokens()];
            int count = 0;
            while (tokenizer.hasMoreTokens()) {
                tmp[count++] = tokenizer.nextToken();
            }
            result = new ArraySequence<String>(tmp, String.class);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the string representation of <code>string</code> (OCL).
     * 
     * @param string the string to be turned into a string
     * @return the string value
     */
    @OperationMeta(opType = OperationType.FUNCTION)
    public static String toString(String string) {
        return string;
    }
    
    /**
     * Returns the first position of <code>part</code> in <code>string</code>. Find alias
     * is due to QVT.
     * 
     * @param string the string to search
     * @param part the part to search for
     * @return the first 0-based position or <code>-1</code> if <code>part</code> is not a 
     *     substring of <code>string</code>
     */
    @OperationMeta(name = {"indexOf", "find"})
    public static Integer indexOf(String string, String part) {
        Integer result = null;
        if (null != string && null != part) {
            result = OclKeyWords.toIvmlIndex(string.indexOf(part));
        }
        return result;
    }

    /**
     * Returns the last position of <code>part</code> in <code>string</code>. (QVT)
     * 
     * @param string the string to search
     * @param part the part to search for
     * @return the last 0-based position or <code>-1</code> if <code>part</code> is not a 
     *     substring of <code>string</code>
     */
    public static Integer rfind(String string, String part) {
        Integer result = null;
        if (null != string && null != part) {
            result = OclKeyWords.toIvmlIndex(string.lastIndexOf(part));
        }
        return result;
    }
    
    /**
     * Returns whether <code>string</code> is quoted by <code>quote</code>, i.e., 
     * starts and ends with <code>quote</code>. (QVT)
     * 
     * @param string the string to test
     * @param quote the quote string/character
     * @return <code>true</code> if <code>string</code> is quoted, <code>false</code> else
     */
    public static boolean isQuoted(String string, String quote) {
        return string.startsWith(quote) && string.endsWith(quote);
    }

    /**
     * Quotifies <code>string</code> by adding <code>quote</code> around <code>string</code>. (QVT)
     * 
     * @param string the string
     * @param quote the quote string/character
     * @return the quoted <code>string</code>
     */
    public static String quotify(String string, String quote) {
        return quote + string + quote;
    }

    /**
     * Unquotifies <code>string</code> if <code>quote</code> is {@link #isQuoted(String, String) quoted}. (QVT)
     * 
     * @param string the string
     * @param quote the quote string/character
     * @return the unquoted <code>string</code>, if not {@link #isQuoted(String, String) quoted} <code>string</code>
     */
    public static String unquotify(String string, String quote) {
        String result = string;
        if (isQuoted(result, quote)) {
            int qLen = quote.length();
            result = result.substring(qLen, result.length() - qLen);
        }
        return result;
    }

    /**
     * Returns the character at given position as String.
     * 
     * @param string the string to take the character from
     * @param index the 0-based index to return the character for
     * @return the character at <code>index</code> 
     */
    public static String at(String string, int index) {
        String result = null;
        int i = OclKeyWords.toJavaIndex(index);
        if (null != string && 0 <= i && i <= string.length()) {
            result = String.valueOf(string.charAt(i));
        }
        return result;
    }
    
    /**
     * Returns the name/version of the operating system.
     * 
     * @return the name of the operating system
     */
    public static String osName() {
        return System.getProperty("os.name");
    }
    
    /**
     * Returns the value of a JVM property.
     * 
     * @param key the property key
     * @param dflt the default value to be returned if the key is not defined
     * @return the value of the property, {@code dflt} if the property is not defined
     */
    public static String getProperty(String key, String dflt) {
        return System.getProperty(key, dflt);
    }
    
    /**
     * Returns whether two strings are equal ignoring cases for the current locale.
     * 
     * @param string1 the first string
     * @param string2 the second string
     * @return <code>true</code> if both strings are considered equal for the current locale, <code>false</code> else
     */
    public static boolean equalsIgnoreCase(String string1, String string2) {
        Locale locale = ExecutionLocal.getCurrentLocale();
        return string1.toLowerCase(locale).equals(string2.toLowerCase(locale));
    }

    /**
     * Returns whether <code>string1</code> is less than <code>string2</code> with respect to
     * the current locale.
     * 
     * @param string1 the first string
     * @param string2 the second string
     * @return whether <code>string1</code> is less than <code>string2</code>
     */
    @OperationMeta(name = "<", opType = OperationType.INFIX)
    public static boolean lessThan(String string1, String string2) {
        return ExecutionLocal.getCurrentCollator().compare(string1, string2) < 0;
    }

    /**
     * Returns whether <code>string1</code> is less than or equal <code>string2</code> with respect to
     * the current locale.
     * 
     * @param string1 the first string
     * @param string2 the second string
     * @return whether <code>string1</code> is less than or equal <code>string2</code>
     */
    @OperationMeta(name = "<=", opType = OperationType.INFIX)
    public static boolean lessThanEqual(String string1, String string2) {
        return ExecutionLocal.getCurrentCollator().compare(string1, string2) <= 0;
    }
    
    /**
     * Returns whether <code>string1</code> is greater than <code>string2</code> with respect to
     * the current locale.
     * 
     * @param string1 the first string
     * @param string2 the second string
     * @return whether <code>string1</code> is greater than <code>string2</code>
     */
    @OperationMeta(name = ">", opType = OperationType.INFIX)
    public static boolean greaterThan(String string1, String string2) {
        return ExecutionLocal.getCurrentCollator().compare(string1, string2) > 0;
    }
    
    /**
     * Returns whether <code>string1</code> is greater than or equal <code>string2</code> with respect to
     * the current locale.
     * 
     * @param string1 the first string
     * @param string2 the second string
     * @return whether <code>string1</code> is greater than or equal <code>string2</code>
     */
    @OperationMeta(name = ">=", opType = OperationType.INFIX)
    public static boolean greaterThanEqual(String string1, String string2) {
        return ExecutionLocal.getCurrentCollator().compare(string1, string2) >= 0;
    }

    /**
     * Returns the characters of a string.
     * 
     * @param string the string to be turned into characters
     * @return the characters of <code>string</code> as string sequence
     */
    @OperationMeta(returnGenerics = {String.class}, opType = OperationType.FUNCTION)
    public static Sequence<String> characters(String string) {
        String[] res = new String[string.length()];
        for (int i = 0; i < res.length; i++) {
            res[i] = String.valueOf(string.charAt(i));
        }
        Sequence<String> tmp = new ArraySequence<String>(res, String.class);
        return new UnmodifiableSequence<String>(tmp);
    }

    /**
     * Returns the type of <code>value</code>. "Overrides" {@link PseudoAny#getType(Object)}.
     * 
     * @param value the String to return the type for
     * @return the type of object (<b>null</b> if <code>ob</code> is <b>null</b>)
     */
    public static TypeDescriptor<?> getType(String value) {
        return TypeRegistry.stringType();
    }

    /**
     * Represents the equality operation for types vs. Strings (legacy). Use simple or
     * qualified name of type for comparison.
     * 
     * @param string the string to compare
     * @param type the type to compare
     * @return string == type.getName() || string == type.getQualifiedName()
     */
    @OperationMeta(name = Constants.EQUALITY, opType = OperationType.INFIX)
    public static boolean equals(String string, TypeDescriptor<?> type) {
        return type.getName().equals(string) || type.getQualifiedName().equals(string);
    }

    /**
     * Represents the un-equality operation for types vs. Strings (legacy). Use simple or
     * qualified name of type for comparison.
     * 
     * @param string the string to compare
     * @param type the type to compare
     * @return string != type.getName() && string != type.getQualifiedName()
     */
    @OperationMeta(name = {Constants.UNEQUALITY, Constants.UNEQUALITY_ALIAS}, opType = OperationType.INFIX)
    public static boolean notEquals(String string, TypeDescriptor<?> type) {
        return !equals(string, type);
    }
    
    /**
     * Fills <code>format</code> with values from <code>value</code>. Follows the QVT specification
     * of this operation as far as possible.
     * 
     * @param format the format in Java format specification, including %(x) for keys if <code>value</code> is a map
     * @param value the value - if sequence, assign the values to the positions of the format specification; if map, 
     *   replace %(key) by string representation; if value, just apply format.   
     * @return the formatted string, <b>null</b> in case of any formatting problems
     */
    public static String format(String format, Object value) {
        String result = null;
        if (value instanceof Map) {
            result = format(format, ((Map<?, ?>) value).toMappedMap());
        } else if (value instanceof java.util.Map) {
            result = formatImpl(format, (java.util.Map<?, ?>) value);
        } else if (value instanceof Sequence) {
            result = formatImpl(format, ((Sequence<?>) value).toMappedList());
        } else if (value instanceof List) {
            result = formatImpl(format, ((List<?>) value));
        } else if (value instanceof DecisionVariable) {
            result = formatImpl(format, ((DecisionVariable) value).getValue());
        } else {
            result = formatImpl(format, value);
        }
        return result;
    }
    
    /**
     * Implements the format operation for map values.
     * 
     * @param format the format operation
     * @param value the map value
     * @return the formatted string
     */
    private static String formatImpl(String format, java.util.Map<?, ?> value) {
        String result = format;
        for (java.util.Map.Entry<?, ?> entry : value.entrySet()) {
            result = result.replace("%(" + StringValueHelper.getStringValue(entry.getKey(), null) + ")", 
                StringValueHelper.getStringValue(entry.getValue(), null));
        }
        return result;
    }

    /**
     * Implements the format operation for list values.
     * 
     * @param format the format operation
     * @param values the list value(s)
     * @return the formatted string
     */
    private static String formatImpl(String format, List<?> values) {
        return formatImpl(format, values.toArray());
    }
    
    /**
     * Implements the generic format operation with exception handling.
     * 
     * @param format the format operation
     * @param values the values
     * @return the formatted string
     */
    private static String formatImpl(String format, Object... values) {
        String result;
        try {
            result = String.format(format, values);
        } catch (IllegalFormatException e) {
            result = null;
        }
        return result;
    }

}
