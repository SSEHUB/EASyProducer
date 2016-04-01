package de.uni_hildesheim.sse.vil.expressions.translation;

import java.util.List;

import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedName;
import de.uni_hildesheim.sse.vil.expressions.expressionDsl.QualifiedPrefix;

/**
 * Some utility methods.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Prevents creation from outside.
     */
    private Utils() {
    }

    /**
     * Returns a string representing a qualified name. (May change in future to
     * structured qualified names.)
     * 
     * @param name the qualified name
     * @return the corresponding string representation
     */
    public static String getQualifiedNameString(QualifiedPrefix name) {
        StringBuilder result = new StringBuilder();
        for (String s : name.getQname()) {
            result.append(s);
        }
        return result.toString();
    }
    
    /**
     * Returns whether the given qualified name is empty.
     * 
     * @param name the name to be checked
     * @return <code>true</code> if it is empty, <code>false</code> else
     */
    public static boolean isEmpty(QualifiedPrefix name) {
        List<String> qName = name.getQname();
        boolean isEmpty = qName.isEmpty();
        if (!isEmpty) {
            isEmpty = true;
            int count = qName.size();
            for (int p = 0; isEmpty && p < count; p++) {
                isEmpty = qName.get(p).isEmpty();
            }
        }
        return isEmpty;
    }
    
    /**
     * Returns a string representing a qualified name. (May change in future to
     * structured qualified names.)
     * 
     * @param name
     *            the qualified name
     * @return the corresponding string representation
     */
    public static String getQualifiedNameString(QualifiedName name) {
        StringBuilder result = new StringBuilder(getQualifiedNameString(name.getPrefix()));
        for (String s : name.getQname()) {
            result.append(s);
        }
        return result.toString();
    }

}
