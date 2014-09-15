package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactTypes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.VilException;

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
    public abstract TypeDescriptor<? extends IVilType> getEntryType();
 
    /**
     * Determines the expected value on the left side (represented by this object) based on the actual value for the 
     * corresponding right side.
     * 
     * @param rhsExpr the (resolved) RHS expression
     * @param rhsValue the RHS value
     * @return the expected LHS value (<b>null</b> denotes no expectation)
     * @throws ArtifactException in case that determining the expected object fails
     */
    public abstract Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) 
        throws ArtifactException;
    
    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
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
     * @throws ExpressionException in case of visiting / evaluation errors
     */
    protected abstract Object accept(IMatchVisitor visitor) throws ExpressionException;
    
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
    public TypeDescriptor<? extends Collection<? extends IArtifact>> inferType() throws ExpressionException {
        // default implementation as most subtypes will just ensure the type but then be evaluated to an Object
        // (hopefully) of a collection
        try {
            TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
            param[0] = ArtifactTypes.artifactType();
            return ensureType(TypeRegistry.getCollectionType(param));
        } catch (VilException e) {
            throw new ExpressionException(e.getMessage(), ExpressionException.ID_INTERNAL); // shall not happen
        }
    }

    /**
     * Evaluates this expression. Some subtypes may define some kind of value resolution, e.g., for 
     * match expressions. This must be called before!
     * 
     * @param evaluator the expression evaluator (in case that an actual expression must be evaluated
     *   as part of this evaluation).
     * @return the evaluation result
     * @throws ExpressionException in case that evaluation fails
     */
    public abstract Collection<?> evaluate(IExpressionVisitor evaluator) throws ExpressionException;
    
    /**
     * Ensures a collection type for <code>type</code>.
     * @param type the type to be checked and ensured
     * @return the collection type
     * @throws ExpressionException in case that <code>type</code> cannot be converted into a collection type
     */
    @SuppressWarnings("unchecked")
    protected static TypeDescriptor<? extends Collection<? extends IArtifact>> ensureType(
        TypeDescriptor<? extends IVilType> type) throws ExpressionException {
        if (!type.isCollection()) {
            throw new ExpressionException(type.getVilName() + "is not a collection", 
                ExpressionException.ID_SEMANTIC);
        }
        if (type.getParameterCount() != 1) {
            throw new ExpressionException("collection in " + type.getVilName() + "is not generic over one type", 
                ExpressionException.ID_SEMANTIC);
        }
        if (!ArtifactTypes.artifactType().isAssignableFrom(type.getParameterType(0))) {
            throw new ExpressionException("collection in " + type.getVilName() + "is not generic over one type", 
                ExpressionException.ID_SEMANTIC);
        }
        TypeDescriptor<? extends Collection<? extends IArtifact>> result;
        try {
            result = (TypeDescriptor<? extends Collection<? extends IArtifact>>) type;
        } catch (ClassCastException e) { // just to be sure
            throw new ExpressionException(e.getMessage(), ExpressionException.ID_SEMANTIC);
        }
        return result;
    }

}
