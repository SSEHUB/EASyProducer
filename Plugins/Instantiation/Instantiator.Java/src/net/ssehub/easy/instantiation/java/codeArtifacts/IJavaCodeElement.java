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

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.templateModel.Formatting;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a java code element.
 * 
 * @author Holger Eichelberger
 */
public interface IJavaCodeElement extends IVilType, IStringValueProvider, Storable {

    public static final Comparator<IJavaCodeElement> KEY_COMPARATOR 
        = (e1, e2) -> e1.getSortKey().compareTo(e2.getSortKey());

    /**
     * Returns the containing artifact.
     * 
     * @return the artifact
     */
    public IJavaCodeArtifact getArtifact();
    
    /**
     * Explicitly adds an import to {@link #getArtifact()}.
     * 
     * @param imp the import (may be a wildcard), static can be set on the result
     * @return the existing or new code import
     */
    public default JavaCodeImport addImport(String imp) {
        return getArtifact().addImport(imp);
    }

    /**
     * Explicitly adds a static import to {@link #getArtifact()}.
     * 
     * @param imp the import (may be a wildcard)
     * @return the existing or new code import
     */
    public default JavaCodeImport addStaticImport(String imp) {
        return getArtifact().addStaticImport(imp);
    }

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
     * Adds this and contained elements on the same nesting level to {@code list}.
     * 
     * @param list the list to be modified as side effect
     */
    @Invisible(inherit = true)
    public default void addAll(List<IJavaCodeElement> list) {
        list.add(this);
    }
    
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
     * Returns whether this element is a class initializer.
     * 
     * @return {@code true} for initializer, {@code false} else
     */
    @Invisible(inherit = true)
    public default boolean isInitializer() {
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
     * Returns whether this element is a constructor.
     * 
     * @return {@code true} for constructor, {@code false} else
     */
    @Invisible(inherit = true)
    public default boolean isConstructor() {
        return false;
    }

    /**
     * Returns whether this element is a method.
     * 
     * @return {@code true} for method, {@code false} else
     */
    @Invisible(inherit = true)
    public default boolean isMethod() {
        return false;
    }
    
    /**
     * Returns a key for sorting.
     * 
     * @return the key
     */
    @Invisible(inherit = true)
    public default String getSortKey() {
        return "";
    }

    /**
     * Returns the result if we are in a tracer/testing.
     * 
     * @param comparator the comparator to use to make tracing output comparable
     * @return the tracer result
     */
    @Invisible(inherit = true)
    public default String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName();
    }
    
    @Invisible(inherit = true)
    @Override
    public default String getStringValue(StringComparator comparator) {
        if (null != comparator && comparator.inTracer()) { // for testing, short form for simplifying the traces
            return getTracerStringValue(comparator);
        } else {
            return toCode();
        }
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
        if (null != elements && elements.size() > 0) {
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

    /**
     * Returns a profile argument in terms of an enum constant.
     * 
     * @param <T> the enum type
     * @param cls the enum class
     * @param key the argument key/name to look for
     * @param dflt the default value, may be <b>null</b>
     * @return the value of the argument, may be {@code dflt}
     */
    static <T extends Enum<T>> T getFormattingArgument(Class<T> cls, String key, T dflt) {
        T result = dflt;
        try {
            result = Enum.valueOf(cls, Formatting.getFormattingConfiguration().getProfileArgument(key, 
                null != dflt ? dflt.name() : ""));
        } catch (IllegalArgumentException e) {
            // take default
        }
        return result;
    }
    
    /**
     * Sorts {@code list} according to {@code comparator}.
     * 
     * @param list the list to sort, may be <b>null</b> or empty
     * @param comparator the comparator, may be <b>null</b> for no sorting
     */
    static void sort(List<IJavaCodeElement> list, Comparator<IJavaCodeElement> comparator) {
        if (null != comparator && null != list && list.size() > 0) {
            Collections.sort(list, comparator);
        }
    }

}
