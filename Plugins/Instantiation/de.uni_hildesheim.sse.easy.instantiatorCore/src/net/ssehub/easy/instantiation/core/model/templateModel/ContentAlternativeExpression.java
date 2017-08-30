/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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

import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionIterator;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a content alternative expression.
 * 
 * @author Holger Eichelberger
 */
public class ContentAlternativeExpression extends InContentExpression {

    private Expression condition;
    private List<Expression> thenEx;
    private List<Expression> elseEx;
    
    /**
     * Creates a content alternative expression.
     * 
     * @param condition the condition of the alternative
     * @param thenEx the then expressions
     * @param elseEx the optional else expressions (may be <b>null</b>)
     * @throws VilException if creation fails
     */
    public ContentAlternativeExpression(Expression condition, List<Expression> thenEx, 
        List<Expression> elseEx) throws VilException {
        this.condition = condition;
        this.thenEx = thenEx;
        this.elseEx = elseEx;
        if (null == this.condition) {
            throw new VilException("No condition expression given/resolved", VilException.ID_INVALID_TYPE);
        }
        if (!TypeRegistry.booleanType().isAssignableFrom(this.condition.inferType())) {
            throw new VilException("Condition expression must evaluate to Boolean", VilException.ID_INVALID_TYPE);
        }
    }
    
    /**
     * Returns the condition.
     * 
     * @return the condition
     */
    public Expression getCondition() {
        return condition;
    }

    /**
     * Returns an expression iterator over then expressions.
     * 
     * @return the expression iterator
     */
    public IExpressionIterator thenEx() {
        return new IExpressionIterator() {
            
            @Override
            public int getExpressionsCount() {
                return getThenExpressionsCount();
            }
            
            @Override
            public Expression getExpression(int index) {
                return getThenExpression(index);
            }
        };
    }

    /**
     * Returns an expression iterator over else expressions.
     * 
     * @return the expression iterator
     */
    public IExpressionIterator elseEx() {
        return new IExpressionIterator() {
            
            @Override
            public int getExpressionsCount() {
                return getElseExpressionsCount();
            }
            
            @Override
            public Expression getExpression(int index) {
                return getElseExpression(index);
            }
        };
    }

    /**
     * Returns the number of then expression.
     * 
     * @return the number of expressions
     */
    public int getThenExpressionsCount() {
        return thenEx.size();
    }

    /**
     * Returns the number of else expression.
     * 
     * @return the number of expressions
     */
    public int getElseExpressionsCount() {
        return null == elseEx ? 0 : elseEx.size();
    }

    
    /**
     * Returns the specified then expression.
     * 
     * @param index the 0-based index of the expression
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getThenExpressionsCount()}</code>
     */
    public Expression getThenExpression(int index) {
        return thenEx.get(index);
    }

    /**
     * Returns the specified then expression.
     * 
     * @param index the 0-based index of the expression
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getThenExpressionsCount()}</code>
     */
    public Expression getElseExpression(int index) {
        if (null == elseEx) {
            throw new IndexOutOfBoundsException();
        }
        return elseEx.get(index);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitContentAlternativeExpression(this);
        } else {
            result = null;
        }
        return result;
    }

}
