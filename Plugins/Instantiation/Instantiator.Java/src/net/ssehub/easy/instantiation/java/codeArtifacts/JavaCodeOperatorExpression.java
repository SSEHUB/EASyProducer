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
 * Represents a binary operation expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeOperatorExpression extends JavaCodeExpression {

    private String operator;
    private JavaCodeExpression first;
    private JavaCodeExpression second;

    /**
     * Creates a raw text instance.
     * 
     * @param parent the parent element
     * @param first the first operand
     * @param operator the operator
     * @param second the second operand (may be <b>null</b> to skip operator and second operand)
     */
    protected JavaCodeOperatorExpression(IJavaCodeElement parent, JavaCodeExpression first, String operator, 
        JavaCodeExpression second) {
        super(parent);
        this.operator = operator.trim();
        this.first = first;
        this.second = second;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param first the first operand
     * @param operator the operator
     * @param second the second operand (may be <b>null</b> to skip operator and second operand)
     * @return the instance
     */
    public static JavaCodeOperatorExpression create(JavaCodeExpression first, String operator, 
        JavaCodeExpression second) {
        return new JavaCodeOperatorExpression(null, first, operator, second);
    }

    /**
     * Creates a chain of operands.
     * 
     * @param operator the operator for all chain elements
     * @param operands the operands in terms of a pseudo-argument list
     * @return the first operator in chain
     */
    public static JavaCodeOperatorExpression create(String operator, JavaCodeArgumentListExpression operands) {
        return create(operator, operands, false);
    }
    
    /**
     * Creates a chain of operands.
     * 
     * @param operator the operator for all chain elements
     * @param operands the operands in terms of a pseudo-argument list
     * @param addParentheses add parentheses for the later/following operands
     * @return the first operator in chain
     */
    public static JavaCodeOperatorExpression create(String operator, JavaCodeArgumentListExpression operands, 
        boolean addParentheses) {
        JavaCodeOperatorExpression result = null;
        for (IJavaCodeElement op : operands.arguments()) {
            if (op instanceof JavaCodeExpression) {
                JavaCodeOperatorExpression tmp = new JavaCodeOperatorExpression(result, (JavaCodeExpression) op, 
                    operator, null);
                if (null == result) {
                    result = tmp;
                } else {
                    result.second = addParentheses ? new JavaCodeParenthesisExpression(result, tmp) : tmp;
                    result = tmp;
                }
            }
        }
        return result;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        first.setParent(this);
        second.setParent(this);
    }
    
    @Override
    public void store(CodeWriter out) {
        first.store(out);
        if (second != null) {
            out.print(" ");
            out.print(operator);
            out.print(" ");
            second.store(out);
        }
    }

}
