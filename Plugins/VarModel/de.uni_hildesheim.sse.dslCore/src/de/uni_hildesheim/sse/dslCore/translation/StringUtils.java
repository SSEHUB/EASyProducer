/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.dslCore.translation;

import org.eclipse.xtext.util.Strings;

/**
 * Some string utility functions.
 * 
 * @author Holger Eichelberger
 */
public class StringUtils {

    /**
     * Convert a string by removing trailing and leading string terminal
     * signs. This is required, as due to the nature of the VIL template 
     * language we will not rely on automatic conversion by xText.
     * 
     * @param string the string to be converted (may be <b>null</b>)
     * @return the same string but without the first and the last character (<b>null</b> 
     *     if <code>string</code> is <b>null</b>)
     */
    public static String convertString(String string) {
        String result;
        if (null == string) {
            result = null;
        } else {
            if ((string.startsWith("\"") && string.endsWith("\"")) 
                || (string.startsWith("'") && string.endsWith("'"))) {
                result = Strings.convertFromJavaString(string.substring(1, string.length() - 1), true);
            } else {
                result = string;
            }
        }
        return result;
    }
    
    /**
     * Converts a string value into a printable string.
     * 
     * @param string the string value
     * @return the printable string (<b>null</b> if <code>string</code> is <b>null</b>)
     */
    public static String convertToString(String string) {
        String result;
        if (null == string) {
            result = null;
        } else {
            result = "\"" + Strings.convertToJavaString(string) + "\"";
        }
        return result;
    }

}
