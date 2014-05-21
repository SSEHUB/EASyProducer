package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Implements a collection match expression.
 * 
 * @author Holger Eichelberger
 */
public class CollectionMatchExpression extends AbstractRuleMatchExpression {

    private Expression expression;
    private Object resolved;
    private TypeDescriptor<? extends Collection<? extends IArtifact>> type;
    
    /**
     * Creates a new collection match expression.
     * 
     * @param expression an expression which evaluates to a collection
     * @throws ExpressionException in case that the expression does not evaluate to a collection
     */
    public CollectionMatchExpression(Expression expression) throws ExpressionException {
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
    public TypeDescriptor<? extends IVilType> getEntryType() {
        return type.getParameterType(0);
    }

    @Override
    public TypeDescriptor<? extends Collection<? extends IArtifact>> inferType() throws ExpressionException {
        return type;
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws ExpressionException {
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
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws ExpressionException {
        Object value = expression.accept(evaluator);
        Collection<?> result;
        if (value instanceof Collection<?>) {
            result = (Collection<?>) value;
        } else {
            throw new ExpressionException("value is not a collection", ExpressionException.ID_INTERNAL);
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
