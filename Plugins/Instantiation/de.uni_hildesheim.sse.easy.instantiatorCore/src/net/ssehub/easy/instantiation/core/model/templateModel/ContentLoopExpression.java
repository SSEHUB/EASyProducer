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
 * Implements a content loop expression.
 * 
 * @author Holger Eichelberger
 */
public class ContentLoopExpression extends InContentExpression implements IExpressionIterator {

    private VariableDeclaration iterator;
    private Expression init;
    private Expression separator;
    private Expression endSeparator;
    private List<Expression> body;
    
    /**
     * Creates a content loop expression.
     * 
     * @param iterator the iterator
     * @param init the initialization expression (shall/cannot be assigned to <code>iterator</code> as collection)
     * @param separator the optional element separator (may be <b>null</b>)
     * @param endSeparator the optional end separator (may be <b>null</b>)
     * @param body the loop body
     * @throws VilException if creation fails
     */
    public ContentLoopExpression(VariableDeclaration iterator, Expression init, Expression separator, 
        Expression endSeparator, List<Expression> body) throws VilException {
        this.iterator = iterator;
        this.init = init;
        this.separator = separator;
        this.endSeparator = endSeparator;
        assertSeparatorEx(this.separator, "Separator");
        assertSeparatorEx(this.endSeparator, "End separator");
        this.body = body;
    }

    /**
     * Asserts that a separator expression evaluates to a String.
     * 
     * @param ex the expression, may be <b>null</b> (ignored then)
     * @param text text prefix if type assertion fails
     * @throws VilException in case that obtaining the type fails
     */
    private void assertSeparatorEx(Expression ex, String text) throws VilException {
        if (null != ex && !TypeRegistry.stringType().isAssignableFrom(ex.inferType())) {
            throw new VilException(text + " expression must evaluate to String", VilException.ID_INVALID_TYPE);
        }
    }
    
    /**
     * Returns the iterator declaration.
     * 
     * @return the iterator declaration
     */
    public VariableDeclaration getIterator() {
        return iterator;
    }
    
    /**
     * Returns the initialization expression.
     * 
     * @return the initialization expression
     */
    public Expression getInit() {
        return init;
    }
    
    /**
     * Returns the optional separator expression.
     * 
     * @return the expression or <b>null</b>
     */
    public Expression getSeparator() {
        return separator;
    }
    
    /**
     * Returns the optional end separator expression.
     * 
     * @return the expression or <b>null</b>
     */
    public Expression getEndSeparator() {
        return endSeparator;
    }
    
    /**
     * Returns the number of body expression.
     * 
     * @return the number of expressions
     */
    @Override
    public int getExpressionsCount() {
        return body.size();
    }

    /**
     * Returns the specified body expression.
     * 
     * @param index the 0-based index of the expression
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getBodyExpressionsCount()}</code>
     */
    @Override
    public Expression getExpression(int index) {
        return body.get(index);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitContentLoopExpression(this);
        } else {
            result = null;
        }
        return result;
    }
    
}
