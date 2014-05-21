package de.uni_hildesheim.sse.model.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Provides methods to identify correct IVML identifiers.
 * 
 * @author Holger Eichelberger
 */
public class IvmlIdentifierCheck {

    /**
     * Stores reserved keywords and operator names.
     */
    private static final Set<String> RESERVED = new HashSet<String>();
    
    /**
     * Initializes {@link #RESERVED}.
     */
    static {
        // own fields
        hash(IvmlKeyWords.class.getDeclaredFields());
        // superclass fields
        hash(IvmlKeyWords.class.getFields());
    }
    
    /**
     * Hashes the names of all public constants in <code>fields</code>
     * into {@link #RESERVED}.
     * 
     * @param fields the fields to be hashed
     */
    private static final void hash(Field[] fields) {
        for (int f = 0; f < fields.length; f++) {
            Field field = fields[f];
            int mod = field.getModifiers();
            if (Modifier.isPublic(mod) && Modifier.isStatic(mod) && Modifier.isFinal(mod)) {
                try {
                    Object value = field.get(null);
                    if (null != value) {
                        RESERVED.add(value.toString());
                    }
                } catch (IllegalAccessException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(IvmlIdentifierCheck.class, Bundle.ID);
                }
            }
        }
    }
    
    /**
     * Returns whether the given <code>name</code> is a structurally and semantically 
     * valid identifier in IVML.
     * 
     * @param name the identifier to test (may be <b>null</b>)
     * @return <code>true</code> if <code>name</code> is a valid IVML identifier,
     *   <code>false</code> if <code>identifier</code> is <b>null</b> or not a valid
     *   IVML identifier
     * @see #isReservedName(String)
     * @see #isStructuralValidIdentifier(String)
     */
    public static final boolean isValidIdentifier(String name) {
        return isStructuralValidIdentifier(name) && !isReservedName(name);
    }

    /**
     * Returns whether the given <code>name</code> is a structural valid
     * identifier.
     * 
     * @param name the name to be checked
     * @return <code>true</code> if <code>name</code> is a reserved name, <code>false</code> else
     */
    public static final boolean isStructuralValidIdentifier(String name) {
        boolean ok;
        if (null == name || 0 == name.length()) {
            ok = false;
        } else {
            // preliminary check!!!
            ok = true;
            int size = name.length();
            for (int i = 0; ok && i < size; i++) {
                char ch = name.charAt(i);
                if (0 == i) {
                    ok = isLetter(ch) || ch == '_';
                } else {
                    ok = isLetter(ch) || Character.isDigit(ch) || ch == '_';
                }
            }
        }
        return ok;
    }
    
    /**
     * Returns whether the given character is a valid IVML identifier letter.
     * 
     * @param character the character to be checked
     * @return <code>true</code> if it is a character, <code>false</code> else
     */
    private static boolean isLetter(char character) {
        return ('a' <= character && character <= 'z' || 'A' <= character && character <= 'Z');
    }

    /**
     * Returns whether the given <code>name</code> is reserved.
     * 
     * @param name the name to be checked
     * @return <code>true</code> if <code>name</code> is a reserved name, <code>false</code> else
     */
    public static final boolean isReservedName(String name) {
        return null != name && RESERVED.contains(name);
    }

}
