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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.List;

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a java code element.
 * 
 * @author Holger Eichelberger
 */
public interface IJavaCodeElement extends IVilType, IStringValueProvider {
    
    /**
     * Stores the element at the current position in {@code out}.
     * 
     * @param out the output writer
     */
    @Invisible
    public void store(CodeWriter out);
    
    /**
     * Returns the containing artifact.
     * 
     * @return the artifact
     */
    public IJavaCodeArtifact getArtifact();

    static <L, E extends L> E add(List<L> list, E element) {
        list.add(element);
        return element;
    }

    static String appendWhitespace(String text) {
        return appendSeparator(text, "");
    }

    static String appendSeparator(String text, String separator) {
        if (text.length() > 0) {
            text += separator;
        }
        return text;
    }

    static void storeList(List<? extends IJavaCodeElement> elements, String separator, CodeWriter out) {
        storeList("", elements, separator, out);
    }

    static void storeList(String prefix, List<? extends IJavaCodeElement> elements, String separator, CodeWriter out) {
        if (null != elements) {
            if (prefix != null && prefix.length() > 0) {
                out.print("");
            }
            for (int e = 0; e < elements.size(); e++) {
                if (e > 0) {
                    out.print(", ");
                }
                elements.get(e).store(out);
            }
        }
    }

    static String toList(List<String> elements, String separator) {
        String result = "";
        if (null != elements) {
            for (int e = 0; e < elements.size(); e++) {
                if (e > 0) {
                    result += ", ";
                }
                result += elements.get(e);
            }
        }
        return result;
    }

}
