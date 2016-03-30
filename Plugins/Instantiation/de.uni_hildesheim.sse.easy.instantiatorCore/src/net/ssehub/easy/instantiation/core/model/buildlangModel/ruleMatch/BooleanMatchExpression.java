/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a Boolean match expression, i.e., a traditional pre- or postcondition.
 * 
 * @author Holger Eichelberger
 */
public class BooleanMatchExpression extends AbstractRuleMatchExpression {

    private Expression expression;
    private transient Object resolved;

    /**
     * Creates a new Boolean match expression.
     * 
     * @param expression an expression which evaluates to a Boolean
     * @throws VilException in case that the expression does not evaluate to a Boolean
     */
    public BooleanMatchExpression(Expression expression) throws VilException {
        if (TypeRegistry.booleanType() != expression.inferType()) {
            throw new VilException("expression does not evaluate to a Boolean", 
                VilException.ID_SEMANTIC);
        }
        this.expression = expression;        
    }
    
    @Override
    public TypeDescriptor<?> getEntryType() {
        return TypeRegistry.booleanType();
    }
    
    /**
     * Returns the actual Boolean expression.
     * 
     * @return the actual expression
     */
    public Expression getExpression() {
        return expression;
    }

    @Override
    public Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) throws VilException {
        return resolved;
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws VilException {
        return visitor.visitBooleanMatchExpression(this);
    }

    @Override
    public boolean contributesTo(AbstractRuleMatchExpression expression) {
        return false;
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws VilException {
        return null;
    }

    /**
     * Resolves the expression.
     * 
     * @param resolved the resolved object
     */
    void resolve(Object resolved) {
        this.resolved = resolved;
    }

}
