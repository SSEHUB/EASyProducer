/*
 * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Wraps an expression with a formatting hint.
 * 
 * @author Holger Eichelberger
 */
public class HintedExpression extends Expression {

    private Expression expression;
    private String hint;

    /**
     * Creates a hinted expression.
     * 
     * @param expression the expression
     * @param hint the formatting hint
     */
    public HintedExpression(Expression expression, String hint) {
        this.expression = expression;
        this.hint = hint;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return expression.inferType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return expression.accept(visitor);
    }

    @Override
    public boolean replaceEmptyLine() {
        return expression.replaceEmptyLine();
    }

    @Override
    public String getFormattingHint() {
        return hint;
    }

}
