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
 * Represents a ternary expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTernaryExpression extends JavaCodeExpression {
    
    private JavaCodeExpression condition;
    private JavaCodeExpression ifEx;
    private JavaCodeExpression elseEx;

    /**
     * Creates a ternary expression.
     * 
     * @param parent the parent element
     * @param condition the condition expression
     * @param ifEx the if expression
     * @param elseEx the then expression
     */
    protected JavaCodeTernaryExpression(IJavaCodeElement parent, String condition, String ifEx, String elseEx) {
        super(parent);
        this.condition = new JavaCodeTextExpression(this, condition);
        this.ifEx = new JavaCodeTextExpression(this, ifEx);
        this.elseEx = new JavaCodeTextExpression(this, elseEx);
    }

    /**
     * Creates a ternary expression.
     * 
     * @param parent the parent element
     * @param condition the condition expression
     * @param ifEx the if expression
     * @param elseEx the then expression
     */
    protected JavaCodeTernaryExpression(IJavaCodeElement parent, JavaCodeExpression condition, JavaCodeExpression ifEx, 
        JavaCodeExpression elseEx) {
        super(parent);
        this.condition = condition;
        this.ifEx = ifEx;
        this.elseEx = elseEx;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param condition the condition expression
     * @param ifEx the if expression
     * @param elseEx the then expression
     * @return the instance
     */
    public static JavaCodeTernaryExpression create(JavaCodeExpression condition, JavaCodeExpression ifEx, 
        JavaCodeExpression elseEx) {
        return new JavaCodeTernaryExpression(null, condition, ifEx, elseEx);
    }
    
    /**
     * Changes the value expression of the if part (transitively adjusting the parents of {@code ex} as 
     * side effect) .
     * 
     * @param ex the if expression
     */
    public void setIf(JavaCodeExpression ex) {
        ex.setParent(this);
        this.ifEx = ex;
    }

    /**
     * Changes the value expression of the else part (transitively adjusting the parents of {@code ex} as 
     * side effect) .
     * 
     * @param ex the if expression
     */
    public void setElseEx(JavaCodeExpression ex) {
        ex.setParent(this);
        this.elseEx = ex;
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        setParent(ifEx, this);
        setParent(elseEx, this);
    }

    @Override
    public void store(CodeWriter out) {
        condition.store(out);
        out.print(" ? ");
        ifEx.store(out);
        out.print(" : ");
        elseEx.store(out);
    }

}
