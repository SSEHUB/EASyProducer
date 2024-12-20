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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;

/**
 * Represents a Java annotation.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAnnotation implements IJavaCodeElement {

    private JavaCodeTypeSpecification type;
    private IJavaCodeElement annotated;
    private List<JavaCodeAnnotationArgument> arguments;
    private String nested;

    /**
     * Creates an annotation instance.
     * 
     * @param type the type of the annotation; the type is validated/potentially registered as import in the 
     *   containing artifact
     * @param annotated the annotated element
     */
    JavaCodeAnnotation(JavaCodeTypeSpecification type, IJavaCodeElement annotated) {
        this(type, null, annotated);
    }
    
    /**
     * Creates an annotation instance.
     * 
     * @param type the type of the annotation; the type is validated/potentially registered as import in the 
     *   containing artifact
     * @param nested a nested type qualification within {@code type}, may be empty or <b>null</b> for none
     * @param annotated the annotated element
     */
    JavaCodeAnnotation(JavaCodeTypeSpecification type, String nested, IJavaCodeElement annotated) {
        this.annotated = annotated;
        this.type = type;
        this.nested = nested;
        getArtifact().validateType(type);
    }
    
    @Invisible(inherit = true)
    @Override
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " " + type.getStringValue(comparator);
    }

    /**
     * Adds the default annotation argument (for the implicit/default "value" field).
     * @param value the value
     */
    public void addArgument(String value) {
        addArgument(null, value);
    }
    
    /**
     * Adds an annotation argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param value the String value
     */    
    public void addStringArgument(String value) {
        addArgument("\"" + StringEscapeUtils.escapeJava(value) + "\"");    
    }

    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     */
    public void addArgument(String name, String value) {
        addArgument(name, value, false);
    }
    
    /**
     * Adds an annotation argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the String value
     */    
    public void addStringArgument(String name, String value) {
        addArgument(name, "\"" + StringEscapeUtils.escapeJava(value) + "\"");    
    }

    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     * @param valueAsString shall the value be escaped and surrounded by quotes if not already given?
     */
    public void addArgument(String name, String value, boolean valueAsString) {
        addArgument(name, value, null, false, valueAsString);
    }
    
    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     * @param values the values of the argument (<b>null</b> to force {@code value})
     * @param splitLines splits values into separate lines
     * @param valueAsString shall the value be escaped and surrounded by quotes if not already given?
     */
    private void addArgument(String name, String value, List<String> values, boolean splitLines, 
        boolean valueAsString) {
        if (null == arguments) {
            arguments = new ArrayList<>();
        }
        if (null != value && valueAsString) {
            value = StringEscapeUtils.escapeJava(value);
            if (!value.startsWith("\"")) {
                value += "\"";
            }
            if (!value.endsWith("\"")) {
                value += "\"";
            }
        }
        IJavaCodeElement.add(arguments, new JavaCodeAnnotationArgument(name, value, values, splitLines, this));
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     * 
     * @param values the values as individual strings
     * @param valuesAsTypes shall the values be considered as types
     */
    public void addArgument(Sequence<String> values, boolean valuesAsTypes) {
        addArgument(null, values, valuesAsTypes);
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     * 
     * @param values the values as individual strings
     * @param splitLines splits values into separate lines
     * @param valuesAsTypes shall the values be considered as types
     */
    public void addArgument(Sequence<String> values, boolean splitLines, boolean valuesAsTypes) {
        addArgument(null, values, splitLines, valuesAsTypes);
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     *
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param values the values as individual strings
     * @param valuesAsTypes shall the values be considered as types
     */
    public void addArgument(String name, Sequence<String> values, boolean valuesAsTypes) {
        addArgument(name, values, false, valuesAsTypes);
    }
    
    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     *
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param values the values as individual strings
     * @param splitAndIndent splits value at "," and indents the individual values in individual lines
     * @param valuesAsTypes shall the values be considered as types
     */
    public void addArgument(String name, Sequence<String> values, boolean splitAndIndent, boolean valuesAsTypes) {
        List<String> tmp = new ArrayList<>();
        for (String s : values) {
            tmp.add(s);
            if (valuesAsTypes) {
                if (s.endsWith(".class")) { // usually the case
                    s = s.substring(0, s.length() - 6);
                    new JavaCodeTypeSpecification(s, annotated); // added automatically
                }
            }
        }
        addArgument(name, null, tmp, splitAndIndent, false);
    }

    @Override
    public void store(CodeWriter out) {
        storeNoLn(out);
        out.println();
    }

    /**
     * Stores this annotation to {@code out} but without final newline.
     * 
     * @param out the target code writer
     */
    public void storeNoLn(CodeWriter out) {
        out.printwi("@");
        out.print(type.getOutputTypeName());
        if (null != nested && nested.length() > 0) {
            out.print(".");
            out.print(nested);
        }
        if (null != arguments && !arguments.isEmpty()) {
            out.print("(");
            IJavaCodeElement.storeList(arguments, ", ", out);
            out.print(")");
        }
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return annotated.getArtifact();
    }

    @Override
    public IJavaCodeElement getParent() {
        return annotated;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        this.annotated = parent;
    }
    
    @Override
    public int getElementCount() {
        return (annotated instanceof JavaCodeParameterSpecification) ? 0 : 1;
    }

    /**
     * Returns the full type of the annotation.
     * 
     * @return the full type
     */
    public String getType() {
        return type.getType();
    }

}
