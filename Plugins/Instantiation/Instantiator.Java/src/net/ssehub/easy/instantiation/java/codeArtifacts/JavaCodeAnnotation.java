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
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
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
     * 
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(Object value) {
        return addArgument(null, value);
    }
    
    /**
     * Adds an annotation argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param value the String value
     * @return <b>this</b> for chaining
     */    
    public JavaCodeAnnotation addStringArgument(String value) {
        addArgument("\"" + StringEscapeUtils.escapeJava(value) + "\"");    
        return this;
    }

    /**
     * Adds the given sequence of values as the default (array) annotation argument.
     * 
     * @param values the values
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(Sequence<?> values) {
        return addArgument(null, values);
    }
    
    /**
     * Adds the given sequence of values as a array annotation argument.
     * 
     * @param name the name
     * @param values the values
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(String name, Sequence<?> values) {
        ensureArguments();
        List<JavaCodeExpression> tmp = new ArrayList<>();
        for (Object o : values) {
            o = IVilType.convertVilValue(o);
            tmp.add(new JavaCodeTextExpression(this, o == null ? "" : o.toString()));
        }
        IJavaCodeElement.add(arguments, new JavaCodeAnnotationArgument(name, null, tmp, false, this));
        return this;
    }

    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(String name, Object value) {
        return addArgument(name, value, false);
    }
    
    /**
     * Adds an annotation argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the String value
     * @return <b>this</b> for chaining
     */    
    public JavaCodeAnnotation addStringArgument(String name, String value) {
        return addArgument(name, "\"" + StringEscapeUtils.escapeJava(value) + "\"");    
    }
    
    /**
     * Adds an annotation argument representing an array initializer.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     * @return the array initializer for adding values
     */    
    public JavaCodeArrayInitializerExpression addArrayArgument(String name, boolean lineBreaks) {
        JavaCodeArrayInitializerExpression result = new JavaCodeArrayInitializerExpression(this, lineBreaks);
        ensureArguments();
        arguments.add(new JavaCodeAnnotationArgument(name, result, null, lineBreaks, this));
        return result;
    }

    /**
     * Adds an annotation argument representing an array initializer as default argument.
     * 
     * @param lineBreaks add line breaks/indents between subsequent values, except for the last
     * @return the array initializer for adding values
     */  
    public JavaCodeArrayInitializerExpression addArrayArgument(boolean lineBreaks) {
        return addArrayArgument(null, lineBreaks);
    }

    /**
     * Adds the default annotation argument as class name, adding ".class" if {@code cls} is not ending with ".class".
     * Cares for importing {@code cls}, if annotation is created in context of a parent java code element.
     * 
     * @param cls the class name
     * @return <b>this</b> for chaining
     */    
    public JavaCodeAnnotation addClassArgument(String cls) {
        return addClassArgument(null, cls);
    }

    /**
     * Adds an annotation argument as class name, adding ".class" if {@code cls} is not ending with ".class".
     * Cares for importing {@code cls}, if annotation is created in context of a parent java code element.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param cls the class name
     * @return <b>this</b> for chaining
     */    
    public JavaCodeAnnotation addClassArgument(String name, String cls) {
        if (cls.endsWith(".class")) {
            cls = cls.substring(0, cls.length() - 6);
        }
        JavaCodeTypeSpecification type = JavaCodeTypeSpecification.toClassType(cls, this);
        if (null != type) {
            addArgument(name, type.getOutputTypeName() + ".class");
        }
        return this;
    }

    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     * @param valueAsString shall the value be escaped and surrounded by quotes if not already given?
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(String name, Object value, boolean valueAsString) {
        return addArgument(name, value, null, false, valueAsString);
    }

    /**
     * Ensures that the argument list is initialized.
     */
    private void ensureArguments() {
        if (null == arguments) {
            arguments = new ArrayList<>();
        }
    }
    
    /**
     * Adds an annotation argument.
     * 
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param value the value
     * @param values the values of the argument (<b>null</b> to force {@code value})
     * @param splitLines splits values into separate lines
     * @param valueAsString shall the value be escaped and surrounded by quotes if not already given?
     * @return <b>this</b> for chaining
     */
    private JavaCodeAnnotation addArgument(String name, Object value, List<JavaCodeExpression> values, 
        boolean splitLines, boolean valueAsString) {
        ensureArguments();
        value = IVilType.convertVilValue(value);
        String stringValue = value == null ? null : value.toString();
        JavaCodeExpression v = null;
        if (null != stringValue && valueAsString) {
            v = new JavaCodeStringExpression(this, stringValue);
        } else {
            v = new JavaCodeTextExpression(this, stringValue);
        }
        IJavaCodeElement.add(arguments, new JavaCodeAnnotationArgument(name, v, values, splitLines, this));
        return this;
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     * 
     * @param values the values as individual strings
     * @param valuesAsTypes shall the values be considered as types
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(Sequence<String> values, boolean valuesAsTypes) {
        return addArgument(null, values, valuesAsTypes);
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     * 
     * @param values the values as individual strings
     * @param splitLines splits values into separate lines
     * @param valuesAsTypes shall the values be considered as types
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(Sequence<String> values, boolean splitLines, boolean valuesAsTypes) {
        return addArgument(null, values, splitLines, valuesAsTypes);
    }

    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     *
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param values the values as individual strings
     * @param valuesAsTypes shall the values be considered as types
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(String name, Sequence<String> values, boolean valuesAsTypes) {
        return addArgument(name, values, false, valuesAsTypes);
    }
    
    /**
     * Adds an array argument consisting of multiple values for the implicit/default field "value".
     *
     * @param name the annotation field name (may be empty or <b>null</b> for the implicit/default "value" field).
     * @param values the values as individual strings
     * @param splitAndIndent splits value at "," and indents the individual values in individual lines
     * @param valuesAsTypes shall the values be considered as types
     * @return <b>this</b> for chaining
     */
    public JavaCodeAnnotation addArgument(String name, Sequence<String> values, boolean splitAndIndent, 
        boolean valuesAsTypes) {
        List<JavaCodeExpression> tmp = new ArrayList<>();
        for (String s : values) {
            tmp.add(new JavaCodeTextExpression(this, s));
            if (valuesAsTypes) {
                if (s.endsWith(".class")) { // usually the case
                    s = s.substring(0, s.length() - 6);
                    new JavaCodeTypeSpecification(s, annotated); // added automatically
                }
            }
        }
        return addArgument(name, null, tmp, splitAndIndent, false);
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
