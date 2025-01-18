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
 * Represents a Java parenthesis expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeParenthesisExpression extends JavaCodeExpression {

    private JavaCodeExpression expression;

    /**
     * Creates a parenthesis expression.
     * 
     * @param parent the parent element
     * @param expression the nested expression
     */
    protected JavaCodeParenthesisExpression(IJavaCodeElement parent, JavaCodeExpression expression) {
        super(parent);
        this.expression = expression;
    }
    
    /**
     * Creates an unlinked parenthesis expression. {@link #setParent(IJavaCodeElement)} must be called afterwards.
     * 
     * @param expression the nested expression
     * @return the created expression
     */
    public static JavaCodeParenthesisExpression create(JavaCodeExpression expression) {
        return new JavaCodeParenthesisExpression(null, expression);
    }

    @Override
    public void store(CodeWriter out) {
        out.print("(");
        expression.store(out);
        out.print(")");
    }

}
