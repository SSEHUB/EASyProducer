package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArraySet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements an artifact match expression.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactMatchExpression extends AbstractRuleMatchExpression {

    private Expression expression;
    private Object resolved;
    
    /**
     * Creates a new collection match expression.
     * 
     * @param expression an expression which evaluates to a collection
     * @throws ExpressionException in case that the expression does not evaluate to a collection
     */
    public ArtifactMatchExpression(Expression expression) throws ExpressionException {
        if (!TypeRegistry.artifactType().isAssignableFrom(expression.inferType())) {
            throw new ExpressionException("expression does not evaluate to an artifact", 
                ExpressionException.ID_SEMANTIC);
        }
        this.expression = expression;
    }
    
    /**
     * Returns the artifact expression.
     * 
     * @return the artifact expression
     */
    public Expression getExpression() {
        return expression;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> getEntryType() {
        return TypeRegistry.artifactType();
    }

    @Override
    public Object determineExpected(AbstractRuleMatchExpression rhsExpr, Object rhsValue) {
        return resolved;
    }

    @Override
    protected Object accept(IMatchVisitor visitor) throws ExpressionException {
        return visitor.visitArtifactMatchExpression(this);
    }

    @Override
    public boolean contributesTo(AbstractRuleMatchExpression expression) {
        return false; // TODO implement
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws ExpressionException {
        // requires resolution by matchResolver before - must return a collection
        Object value = expression.accept(evaluator);
        Collection<?> result;
        if (value instanceof FileArtifact) {
            FileArtifact[] resultArray = new FileArtifact[1];
            resultArray[0] = (FileArtifact) value;
            TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
            param[0] = getEntryType();
            result = new ArraySet<FileArtifact>(resultArray, param);
        } else if (value instanceof IArtifact) {
            IArtifact[] resultArray = new IArtifact[1];
            resultArray[0] = (IArtifact) value;
            TypeDescriptor<? extends IVilType>[] param = TypeDescriptor.createArray(1);
            param[0] = getEntryType();
            result = new ArraySet<IArtifact>(resultArray, param);
        } else {
            throw new ExpressionException("artifact match expression value is not of type Artifact", 
                ExpressionException.ID_INTERNAL);
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
