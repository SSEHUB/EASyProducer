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
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a java code element.
 * 
 * @author Holger Eichelberger
 */
public interface IJavaCodeElement extends IVilType, IStringValueProvider, Storable {
    
    /**
     * Returns the containing artifact.
     * 
     * @return the artifact
     */
    public IJavaCodeArtifact getArtifact();
    
    /**
     * Returns the parent.
     * 
     * @return the parent
     */
    public IJavaCodeElement getParent();
    
    /**
     * Changes the parent, e.g., after late addition of an element. This may lead to transitive adjustments of the
     * parents of contained elements.
     * 
     * @param parent the parent
     */
    @Invisible(inherit = true)
    public void setParent(IJavaCodeElement parent);
    
    /**
     * Returns whether this code element has a Javadoc comment.
     * 
     * @return {@code true} for comment, {@code false} else
     */
    @Invisible(inherit = true)
    public default boolean hasJavadocComment() {
        return false;
    }
    
    /**
     * Returns whether this element is an attribute.
     * 
     * @return {@code true} for attribute, {@code false} else
     */
    @Invisible(inherit = true)
    public default boolean isAttribute() {
        return false;
    }

    /**
     * Adds an element to {@code list} and returns the element.
     * 
     * @param <L> the list type
     * @param <E> the element type
     * @param list the list to modify
     * @param element the element
     * @return the element
     */
    static <L, E extends L> E add(List<L> list, E element) {
        list.add(element);
        return element;
    }

    /**
     * Adds an element to {@code list} and returns the element.
     * 
     * @param <L> the list type
     * @param <E> the element type
     * @param list the list to modify
     * @param element the element
     * @param pos the index position where to add {@code element}
     * @return the element
     */
    static <L, E extends L> E add(List<L> list, E element, int pos) {
        list.add(pos, element);
        return element;
    }

    /**
     * Appends a whitespace to {@code text} if {@code text} is not empty.
     * Does not add a whitespace if there is already one.
     * 
     * @param text the text to append to
     * @return {@code text} or {@code text} suffixed with whitespace
     * @see #appendSeparator(String, String)
     */
    static String appendWhitespace(String text) {
        if (text.endsWith(" ")) {
            return text;
        } else {
            return appendSeparator(text, " ");
        }
    }

    /**
     * Appends {@code separator} to {@code text} if {@code text} is not empty.
     * 
     * @param text the text to append to
     * @param separator the separator
     * @return {@code text} or {@code text} suffixed with {@code separator}
     */
    static String appendSeparator(String text, String separator) {
        if (text.length() > 0) {
            text += separator;
        }
        return text;
    }

    /**
     * Applies {@link IJavaCodeElement#store(CodeWriter)} to all elements of the list, joining them by "," as separator.
     * 
     * @param elements the elements to join
     * @param separator the separator
     * @param out the target code writer
     */
    static void storeList(List<? extends IJavaCodeElement> elements, String separator, CodeWriter out) {
        storeList("", elements, separator, out);
    }

    /**
     * Applies {@link IJavaCodeElement#store(CodeWriter)} to all elements of the list, joining them by "," as separator.
     * 
     * @param prefix part to be prepended
     * @param elements the elements to join
     * @param separator the separator
     * @param out the target code writer
     */
    static void storeList(String prefix, List<? extends IJavaCodeElement> elements, String separator, CodeWriter out) {
        if (null != elements) {
            if (prefix != null && prefix.length() > 0) {
                out.print(prefix);
            }
            for (int e = 0; e < elements.size(); e++) {
                if (e > 0) {
                    out.print(", ");
                }
                elements.get(e).store(out);
            }
        }
    }

    /**
     * Turns the given string elements to a string separated by {@code separator}.
     * 
     * @param elements the elements
     * @param separator the separator
     * @return the joined string
     */
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

    /**
     * Sets a parent instance via {@code setter} if {@code parent} complies with {@code cls}.
     * 
     * @param <T> the required type of the parent
     * @param parent the parent instance
     * @param cls the class stating the required type
     * @param setter the actual setter
     */
    static <T extends IJavaCodeElement> void setParent(IJavaCodeElement parent, Class<T> cls, Consumer<T> setter) {
        if (cls.isInstance(parent)) {
            setter.accept(cls.cast(parent));
        }
    }

}
