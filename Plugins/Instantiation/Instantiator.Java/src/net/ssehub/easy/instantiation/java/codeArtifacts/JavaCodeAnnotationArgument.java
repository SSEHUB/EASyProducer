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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a argument in a {@link JavaCodeAnnotation annotation}.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeAnnotationArgument implements IJavaCodeElement {

    private String name;
    private JavaCodeExpression value;
    private JavaCodeAnnotation annotation;
    private boolean splitLines;
    private List<JavaCodeExpression> values;

    /**
     * Creates an annotation argument.
     * 
     * @param name the name of the argument (may be empty or <b>null</b> for default)
     * @param value the value of the argument
     * @param values the values of the argument (<b>null</b> to force {@code value})
     * @param splitLines splits values into separate lines
     * @param annotation the annotated annotation
     */
    JavaCodeAnnotationArgument(String name, JavaCodeExpression value, List<JavaCodeExpression> values, 
        boolean splitLines, JavaCodeAnnotation annotation) {
        this.name = name;
        this.annotation = annotation;
        this.splitLines = splitLines;
        this.value = value;
        this.values = values;
    }
    
    @Invisible(inherit = true)
    @Override
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " (" + (hasName() ? name + "=" : "") 
            + (null != values ? values : value) + ")";
    }
    
    /**
     * Returns whether this annotation has an explicit field name or whether it targets "value".
     * 
     * @return {@code true} for name, {@code false} for no explicit name, i.e. "value"
     */
    public boolean hasName() {
        return name != null && name.length() > 0; 
    }

    @Override
    public void store(CodeWriter out) {
        if (hasName()) {
            out.print(name);
            out.print(" = ");
        }
        if (null != values) {
            boolean split = splitLines && values.size() > 1;
            boolean first = true;
            out.print("{");
            if (split) {
                out.println();
                out.increaseIndent();
            }
            for (JavaCodeExpression v: values) {
                if (!first) {
                    out.print(", ");
                    if (split) {
                        out.println();
                    }
                }
                if (split) {
                    out.printIndent();
                }
                v.store(out);
                first = false;
            }
            if (split) {
                out.decreaseIndent();
            }
            out.print("}");
        } else {
            value.store(out);
        }
    }
    
    @Override
    public int getElementCount() {
        int result = 0;
        if (null != values) {
            if (splitLines && values.size() > 1) {
                result += values.size();
            }
        }
        return result;
    }

    @Override
    public IJavaCodeArtifact getArtifact() {
        return annotation.getArtifact();
    }

    @Override
    public IJavaCodeElement getParent() {
        return annotation;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        IJavaCodeElement.setParent(parent, JavaCodeAnnotation.class, p -> this.annotation = p);
    }

}
