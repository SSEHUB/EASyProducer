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

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactTypes;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a rule pre/post match condition (not a rule call in a pre condition). This
 * class supports iterating over the match results.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractRuleMatchExpression extends Expression {

    /**
     * Returns the entry type over which this match expression will be able to iterate.
     * 
     * @return the entry type
     */
    public abstract TypeDescriptor<?> getEntryType();
 
    /**
     * Determines the expected value on the left side (represented by this object) based on the actual value for the 
     * corresponding right side.
     * 
     * @param rhsExpr the (resolved) RHS expression
     * @param rhsValue the RHS value
     * @return the expected LHS value (<b>null</b> denotes no expectation)
     * @throws VilException in case that determining the expected object fails
     */
    public abstract Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) 
        throws VilException;
    
    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IMatchVisitor) {
            result = accept((IMatchVisitor) visitor);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
    /**
     * Accepts the given visitor for visiting.
     * 
     * @param visitor the match visitor used for visiting
     * @return the result of visiting (may be <b>null</b>)
     * @throws VilException in case of visiting / evaluation errors
     */
    protected abstract Object accept(IMatchVisitor visitor) throws VilException;
    
    /**
     * Returns whether this rule match expression may contribute to the fulfillment of 
     * <code>expression</code>.
     * 
     * @param expression the expression to be considered (typically a RHS expression, 
     *     while <i>this</i> is a LHS expression)
     * @return <code>true</code> if this rule may contribute, <code>false</code> else
     */
    public abstract boolean contributesTo(AbstractRuleMatchExpression expression);
    
    @Override // restrict allowed types
    public TypeDescriptor<? extends Collection<? extends IArtifact>> inferType() throws VilException {
        // default implementation as most subtypes will just ensure the type but then be evaluated to an Object
        // (hopefully) of a collection
        TypeDescriptor<?>[] param = TypeDescriptor.createArray(1);
        param[0] = ArtifactTypes.artifactType();
        return ensureType(TypeRegistry.getCollectionType(param));
    }

    /**
     * Evaluates this expression. Some subtypes may define some kind of value resolution, e.g., for 
     * match expressions. This must be called before!
     * 
     * @param evaluator the expression evaluator (in case that an actual expression must be evaluated
     *   as part of this evaluation).
     * @return the evaluation result
     * @throws VilException in case that evaluation fails
     */
    public abstract Collection<?> evaluate(IExpressionVisitor evaluator) throws VilException;
    
    /**
     * Ensures a collection type for <code>type</code>.
     * @param type the type to be checked and ensured
     * @return the collection type
     * @throws VilException in case that <code>type</code> cannot be converted into a collection type
     */
    @SuppressWarnings("unchecked")
    protected static TypeDescriptor<? extends Collection<? extends IArtifact>> ensureType(
        TypeDescriptor<?> type) throws VilException {
        if (!type.isCollection()) {
            throw new VilException(type.getVilName() + "is not a collection", 
                VilException.ID_SEMANTIC);
        }
        if (type.getGenericParameterCount() != 1) {
            throw new VilException("collection in " + type.getVilName() + "is not generic over one type", 
                VilException.ID_SEMANTIC);
        }
        if (!ArtifactTypes.artifactType().isAssignableFrom(type.getGenericParameterType(0))) {
            throw new VilException("collection in " + type.getVilName() + "is not generic over one type", 
                VilException.ID_SEMANTIC);
        }
        TypeDescriptor<? extends Collection<? extends IArtifact>> result;
        try {
            result = (TypeDescriptor<? extends Collection<? extends IArtifact>>) type;
        } catch (ClassCastException e) { // just to be sure
            throw new VilException(e.getMessage(), VilException.ID_SEMANTIC);
        }
        return result;
    }

}
