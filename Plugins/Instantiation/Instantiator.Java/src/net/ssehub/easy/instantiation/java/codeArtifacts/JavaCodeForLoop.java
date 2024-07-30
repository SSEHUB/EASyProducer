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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a for-loop.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeForLoop extends JavaCodeBlock {

    private JavaCodeTypeSpecification type;
    private String variableName;
    private String expression;
    private String initializer;
    private String condition;
    private String update;
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param parent the parent instance
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     */
    public JavaCodeForLoop(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        String expression) {
        super(parent, true, true);
        this.type = type;
        this.variableName = variableName;
        this.expression = null == expression ? "" : expression;
    }

    /**
     * Creates a traditional for-loop.
     * 
     * @param parent the parent instance
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     */
    public JavaCodeForLoop(IJavaCodeElement parent, JavaCodeTypeSpecification type, String variableName, 
        String initializer, String condition, String update) {
        super(parent, true, true);
        this.type = type;
        this.variableName = variableName;
        this.initializer = initializer;
        this.condition = condition;
        this.update = update;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("for (");
        boolean hasVariable = variableName != null && !variableName.isEmpty();
        if (hasVariable) {
            type.store(out);
            out.print(" ");
            out.print(variableName);
        }
        if (null != expression) {
            out.print(" : ");
            out.print(expression);
        } else {
            if (hasVariable && null != initializer && !initializer.isEmpty()) {
                out.print(" = ");
                out.print(initializer);
            }
            out.print(";");
            if (null != condition) {
                out.print(" ");
                out.print(condition);
            }
            out.print(";");
            if (null != update) {
                out.print(" ");
                out.print(update);
            }
        }
        out.print(")");
        super.store(out);
    }

}
