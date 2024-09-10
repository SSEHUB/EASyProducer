/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.dslCore.ui.contentAssist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;

/**
 * Helpers for proposal provider.
 * 
 * @author Holger Eichelberger
 */
public class ProposalProviderUtilities {

    /**
     * Returns {@code value} if not <b>null</b>, {@code dflt} else.
     * 
     * @param value the value
     * @param dflt the default value
     * @return {@code value} or {@code dflt}
     */
    public static String safe(String value, String dflt) {
        return null == value ? dflt : value;
    }
    
    /**
     * Returns {@code value} if not <b>null</b>, "<Name>" else.
     * 
     * @param value the value
     * @return {@code value} or "<Name>"
     * @see #safe(String, String)
     */
    public static String safeName(String value) {
        return safe(value, "<Name>");
    }
    
    /**
     * Optionally negates {@code value} depending on {@code negate}.
     * 
     * @param value the value
     * @param negate negate {@code value} or return {@code value}
     * @return {@code value} or its negation
     */
    public static boolean negateOpt(boolean value, boolean negate) {
        return negate ? !value : value;
    }

    /**
     * Consumes whitespaces to the left of {@code pos} in {@code document}.
     * 
     * @param document the document
     * @param pos the start position
     * @return the text after consumption or {@code pos} if there is nothing to consume
     */
    public static int consumeLeftWhitespaces(IDocument document, int pos) {
        return consumeLeftWhitespaces(document, pos, false);
    }

    /**
     * Consumes non-whitespaces to the left of {@code pos} in {@code document}.
     * 
     * @param document the document
     * @param pos the start position
     * @return the text after consumption or {@code pos} if there is nothing to consume
     */
    public static int consumeLeftNonWhitespaces(IDocument document, int pos) {
        return consumeLeftWhitespaces(document, pos, true);
    }

    /**
     * Consumes (non-)whitespaces to the left of {@code pos} in {@code document}.
     * 
     * @param document the document
     * @param pos the start position
     * @param negate if {@code true} consume non-whitespaces, if {@code false} consume whitespaces
     * @return the text after consumption or {@code pos} if there is nothing to consume
     */
    private static int consumeLeftWhitespaces(IDocument document, int pos, boolean negate) {
        try {
            while (pos >= 0 && negateOpt(Character.isWhitespace(document.getChar(pos)), negate)) {
                pos--;
            }
        } catch (BadLocationException e) {
            // ignore
        }
        return pos;
    }

    /**
     * Consumes a given {@code text} to the left of {@code pos} in {@code document}.
     * 
     * @param document the document
     * @param pos the start position
     * @param text the text to consume
     * @return the text after consumption or {@code pos} if there is nothing to consume
     */
    public static int consumeLeftString(IDocument document, int pos, String text) {
        int tPos = text.length() - 1;
        try {
            while (tPos >= 0 && pos >= 0 && document.getChar(pos) == text.charAt(tPos)) {
                pos--;
            }
        } catch (BadLocationException e) {
            // ignore
        }
        return pos;
    }

    /**
     * Finds the type in a declaration syntax starting with {@code pos} at <i>default</i> in <i>type id = default</i>.
     * 
     * @param document the document to search
     * @param pos the position to start
     * @return the type if it can be found, an empty string else
     */
    public static String findDeclarationType(IDocument document, int pos) {
        String result = "";
        try {
            pos = consumeLeftWhitespaces(document, pos);
            pos = consumeLeftString(document, pos, "=");
            pos = consumeLeftWhitespaces(document, pos);
            pos = consumeLeftNonWhitespaces(document, pos);
            pos = consumeLeftWhitespaces(document, pos);
            int typeRight = pos + 1;
            pos = consumeLeftNonWhitespaces(document, pos);
            result = document.get(pos, typeRight - pos).trim();
        } catch (BadLocationException e) {
            // ignore
        }
        return result;
    }

}
