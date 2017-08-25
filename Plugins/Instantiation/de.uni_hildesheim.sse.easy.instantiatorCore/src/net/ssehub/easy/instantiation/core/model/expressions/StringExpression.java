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
package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents an expression within a string to be used for resolved content statements and strings. Basically,
 * this class represents "$v" or "${v}", which cannot be expressed as constant-variable-constant as the constants
 * would be "quoted" by Strings.
 * 
 * @author Holger Eichelberger
 */
public class StringExpression extends Expression {

    private Expression expr;
    private boolean nested;
    
    /**
     * Creates a string expression.
     * 
     * @param expr the contained expression. Shall not be a constant expression representing a string.
     * @param nested whether the expression is nested, e.g., in ${x} or plain, e.g. $x
     */
    public StringExpression(Expression expr, boolean nested) {
        this.expr = expr;
        this.nested = nested;
    }
    
    /**
     * Returns the contained expression.
     * 
     * @return the contained expression.
     */
    public Expression getExpression() {
        return expr;
    }
    
    /**
     * Returns whether the expression is nested.
     * 
     * @return <code>true</code> for nested, <code>false</code> else
     */
    public boolean isNested() {
        return nested;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.stringType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitStringExpression(this);
    }

}
