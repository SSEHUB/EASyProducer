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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents postfix increment and decrement expressions.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodePostfixExpression extends JavaCodeExpression {

    private String variable;
    private boolean increment;

    /**
     * Creates a raw text instance.
     * 
     * @param parent the parent element
     * @param variable the variable name
     * @param increment increment or decrement
     */
    protected JavaCodePostfixExpression(IJavaCodeElement parent, String variable, boolean increment) {
        super(parent);
        this.variable = variable;
        this.increment = increment;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param variable the variable name
     * @param increment increment or decrement
     * @return the instance
     */
    public static JavaCodePostfixExpression create(String variable, boolean increment) {
        return new JavaCodePostfixExpression(null, variable, increment);
    }

    @Override
    public void store(CodeWriter out) {
        out.print(variable);
        if (increment) {
            out.print("++");
        } else {
            out.print("--");
        }
    }

}