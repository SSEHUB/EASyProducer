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

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Implements a collection match expression.
 * 
 * @author Holger Eichelberger
 */
public class CollectionMatchExpression extends AbstractRuleMatchExpression {

    private Expression expression;
    private transient Object resolved;
    private TypeDescriptor<? extends Collection<? extends IArtifact>> type;
    
    /**
     * Creates a new collection match expression.
     * 
     * @param expression an expression which evaluates to a collection
     * @throws VilException in case that the expression does not evaluate to a collection
     */
    public CollectionMatchExpression(Expression expression) throws VilException {
        this.type = ensureType(expression.inferType());
        this.expression = expression;
    }

    /**
     * Returns the collection expression.
     * 
     * @return the collection expression
     */
    public Expression getExpression() {
        return expression;
    }
    
    @Override
    public TypeDescriptor<?> getEntryType() {
        return type.getGenericParameterType(0);
    }

    @Override
    public TypeDescriptor<? extends Collection<? extends IArtifact>> inferType() throws VilException {
        return type;
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws VilException {
        return visitor.visitCollectionMatchExpression(this);
    }

    @Override
    public Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) {
        return resolved;
    }
    
    @Override
    public boolean contributesTo(AbstractRuleMatchExpression expression) {
        return false; // TODO implement
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws VilException {
        Object value = expression.accept(evaluator);
        Collection<?> result;
        if (value instanceof Collection<?>) {
            result = (Collection<?>) value;
        } else {
            throw new VilException("value is not a collection", VilException.ID_INTERNAL);
        }
        return result;
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
