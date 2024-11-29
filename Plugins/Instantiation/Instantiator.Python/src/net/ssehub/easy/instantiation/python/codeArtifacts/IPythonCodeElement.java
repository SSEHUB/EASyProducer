package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.templateModel.Formatting;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Declares a generic Python code element.
 * 
 * @author Kevin Schaperjahn
 */
public interface IPythonCodeElement extends IVilType, IStringValueProvider, Storable {

    public static final Comparator<IPythonCodeElement> KEY_COMPARATOR = (e1, e2) -> e1.getSortKey()
        .compareTo(e2.getSortKey());

    public IPythonCodeArtifact getArtifact();

    public IPythonCodeElement getParent();

    @Invisible(inherit = true)
    public void setParent(IPythonCodeElement parent);

    @Invisible(inherit = true)
    public default void addAll(List<IPythonCodeElement> list) {
        list.add(this);
    }

    @Invisible(inherit = true)
    public default boolean hasPythondocComment() {
        return false;
    }

    @Invisible(inherit = true)
    public default String getSortKey() {
        return "";
    }

    @Invisible(inherit = true)
    public default boolean isAttribute() {
        return false;
    }

    @Invisible(inherit = true)
    public default boolean isConstructor() {
        return false;
    }

    @Invisible(inherit = true)
    public default boolean isMethod() {
        return false;
    }

    @Invisible(inherit = true)
    public default String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName();
    }

    @Invisible(inherit = true)
    @Override
    public default String getStringValue(StringComparator comparator) {
        if (comparator != null && comparator.inTracer()) { // for testing, short
                                                           // form for
                                                           // simplifying the
                                                           // traces
            return getTracerStringValue(comparator);
        } else {
            return toCode();
        }
    }

    static <L, E extends L> E add(List<L> list, E element) {
        list.add(element);
        return element;
    }

    static <L, E extends L> E add(List<L> list, E element, int pos) {
        list.add(pos, element);
        return element;
    }

    static String appendWhitespace(String text) {
        if (text.endsWith(" ")) {
            return text;
        } else {
            return appendSeparator(text, " ");
        }
    }

    static String appendSeparator(String text, String separator) {
        if (text.length() > 0) {
            text += separator;
        }
        return text;
    }

    static void storeList(List<? extends IPythonCodeElement> elements, String separator, CodeWriter out) {
        storeList("", elements, separator, out);
    }

    static void storeList(String prefix, List<? extends IPythonCodeElement> elements, String separator,
        CodeWriter out) {
        if (elements != null && elements.size() > 0) {
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

    static String toList(List<String> elements, String separator) {
        String result = "";
        if (elements != null) {
            for (int e = 0; e < elements.size(); e++) {
                if (e > 0) {
                    result += ", ";
                }

                result += elements.get(e);
            }
        }

        return result;
    }

    static <T extends IPythonCodeElement> void setParent(IPythonCodeElement parent, Class<T> cls, Consumer<T> setter) {
        if (cls.isInstance(parent)) {
            setter.accept(cls.cast(parent));
        }
    }

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

    static void sort(List<IPythonCodeElement> list, Comparator<IPythonCodeElement> comparator) {
        if (comparator != null && list != null && list.size() > 0) {
            Collections.sort(list, comparator);
        }
    }
}