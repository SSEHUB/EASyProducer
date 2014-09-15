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
