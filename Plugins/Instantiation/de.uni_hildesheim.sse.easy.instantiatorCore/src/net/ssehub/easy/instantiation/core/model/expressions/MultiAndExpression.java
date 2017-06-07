/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a multi-and expression.
 * 
 * @author Holger Eichelberger
 */
public class MultiAndExpression extends Expression {

    private AbstractCallExpression[] expressions;
    
    /**
     * Creates a multi-and expression.
     * 
     * @param expressions the individual expressions
     * @throws VilException if <code>expressions</code> or an expression within is <b>null</b>
     */
    public MultiAndExpression(AbstractCallExpression... expressions) throws VilException {
        if (null == expressions) {
            throw new VilException("No expression given", VilException.ID_INVALID);
        }
        for (int e = 0; e < expressions.length; e++) {
            if (null == expressions[e]) {
                throw new VilException("Expression missing", VilException.ID_INVALID);
            }
        }
        this.expressions = expressions;
    }

    /**
     * Returns the number of expressions represented by this expression.
     * 
     * @return the number of expressions
     */
    public int getExpressionCount() {
        return expressions.length;
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the 0-based index 
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index &gt;={@link #getExpressionCount()}</code>
     */
    public AbstractCallExpression getExpression(int index) {
        return expressions[index];
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        final TypeDescriptor<?> booleanType = TypeRegistry.booleanType();
        for (int e = 0; e < expressions.length; e++) {
            if (!booleanType.isAssignableFrom(expressions[e].inferType())) {
                throw new VilException("Expression at index " + e + " does not evaluate to Boolean", 
                    VilException.ID_INVALID_TYPE);
            }
        }
        return booleanType;
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitMultiAndExpression(this);
    }

}
