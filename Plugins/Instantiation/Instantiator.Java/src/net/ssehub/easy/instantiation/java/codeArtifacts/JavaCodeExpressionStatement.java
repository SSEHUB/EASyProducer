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
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * A statement containing an expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeExpressionStatement extends JavaCodeStatement {

    private JavaCodeExpression expression;

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param expression the contained expression
     */
    protected JavaCodeExpressionStatement(IJavaCodeElement parent, JavaCodeExpression expression) {
        super(parent);
        this.expression = expression;
        if (null != this.expression) {
            this.expression.setParent(this);
        }
    }
    
    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param expression the contained expression
     * @return the instance
     */
    public static JavaCodeExpressionStatement create(JavaCodeExpression expression) {
        return new JavaCodeExpressionStatement(null, expression);
    }

    /**
     * Creates a postfix expression statement.
     * 
     * @param parent the parent element
     * @param variable the variable name
     * @param increment increment or decrement
     * @return the postfix expression statement
     */
    static JavaCodeExpressionStatement createPostfixStatement(IJavaCodeElement parent, String variable, 
        boolean increment) {
        return new JavaCodeExpressionStatement(parent, new JavaCodePostfixExpression(null, variable, increment));
    }

    @Override
    public void store(CodeWriter out) {
        out.printIndent();
        expression.store(out);
        out.println(";");
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        expression.setParent(this);
    }    

    @Override
    public boolean isEmpty() {
        return null == expression || expression.isEmpty();
    }

    @Override
    public JavaCodeExpressionStatement replaceVariable(String oldName, String newName) {
        if (null != expression) {
            expression.replaceVariable(oldName, newName);
        }
        return this;
    }

    @Override
    public JavaCodeExpressionStatement replaceMethod(String oldName, String newName) {
        if (null != expression) {
            expression.replaceMethod(oldName, newName);
        }
        return this;
    }    

}
