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

/**
 * Represents a Java annotation.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAnnotation implements IJavaCodeElement {

    private JavaCodeTypeSpecification type;
    private IJavaCodeElement annotated;
    private List<JavaCodeAnnotationArgument> arguments;

    /**
     * Creates an annotation instance.
     * 
     * @param type the type of the annotation; the type is validated/potentially registered as import in the 
     *   containing artifact
     * @param annotated the annotated element
     */
    JavaCodeAnnotation(JavaCodeTypeSpecification type, IJavaCodeElement annotated) {
        this.annotated = annotated;
        this.type = type;
        getArtifact().validateType(type);
    }
    
    @Override
    public String getStringValue(StringComparator comparator) {
        return "JavaAnnotation " + type.getStringValue(comparator);
    }

    /**
     * Adds an annotation argument.
     * 
     * @param name the name
     * @param value the value
     */
    public void addArgument(String name, String value) {
        addArgument(name, value);
    }
    
    /**
     * Adds an annotation argument.
     * 
     * @param name the name
     * @param value the value
     * @param valueAsString shall the value be escaped and surrounded by quotes if not already given?
     */
    public void addArgument(String name, String value, boolean valueAsString) {
        if (null == arguments) {
            arguments = new ArrayList<>();
        }
        if (valueAsString) {
            value = StringEscapeUtils.escapeJava(value);
            if (!value.startsWith("\"")) {
                value += "\"";
            }
            if (!value.endsWith("\"")) {
                value += "\"";
            }
        }
        IJavaCodeElement.add(arguments, new JavaCodeAnnotationArgument(name, value, this));
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

}
