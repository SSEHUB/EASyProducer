package de.uni_hildesheim.sse.model.utils;

/**
 * Some java helper methods.
 * 
 * @author Holger Eichelberger
 */
public class JavaUtils {

    /**
     * Returns whether <code>string</code> is a valid Java identifier.
     * 
     * @param string the string to be tested
     * @return <code>true</code> if it is a valid Java identifier, <code>false</code> else
     */
    public static boolean isJavaIdentifier(String string) {
        boolean ok;
        if (string == null || string.length() == 0) {
            ok = false;
        } else {
            char[] c = string.toCharArray();
            ok = (Character.isJavaIdentifierStart(c[0]));
            for (int i = 1; ok && i < c.length; i++) {
                ok = Character.isJavaIdentifierPart(c[i]);
            }
        }
        return ok;
    }
    
}
