/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.varModel.validation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.datatypes.IVMLKeyWord;

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
        hash(IvmlKeyWords.class.getDeclaredFields(), false);
        // superclass fields (not all of them are reserved keywords in IVML).
        hash(IvmlKeyWords.class.getFields(), true);
    }
    
    /**
     * Hashes the names of all public constants in <code>fields</code>
     * into {@link #RESERVED}.
     * 
     * @param fields the fields to be hashed
     * @param checkAnnotation {@code false} each field will be added to {@link #RESERVED} which marks them as
     * reserved keyword, {@code true} only fields annotated with {@link IVMLKeyWord} will be added to
     * {@link #RESERVED}. This is useful for inherited keywords as not all of them are also reserved in IVML.
     */
    private static final void hash(Field[] fields, boolean checkAnnotation) {
        for (int f = 0; f < fields.length; f++) {
            Field field = fields[f];
            boolean add = !checkAnnotation || (null != field.getAnnotation(IVMLKeyWord.class));
            int mod = field.getModifiers();
            if (add && Modifier.isPublic(mod) && Modifier.isStatic(mod) && Modifier.isFinal(mod)) {
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
