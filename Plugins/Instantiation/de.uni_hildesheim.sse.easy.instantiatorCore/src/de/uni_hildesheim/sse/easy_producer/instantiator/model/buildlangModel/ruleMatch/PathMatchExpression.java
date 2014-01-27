package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Denotes the special expression regarding a path match.
 * 
 * @author Holger Eichelberger
 */
public class PathMatchExpression extends AbstractPathRuleMatchExpression {

    private Expression pathExpression;
    private Path resolved;

    /**
     * Creates a path match expression.
     * 
     * @param expression the path expression
     * @throws ExpressionException in case that the expression is invalid
     */
    public PathMatchExpression(Expression expression) throws ExpressionException {
        if (TypeRegistry.getType(Path.class) != expression.inferType()) {
            throw new ExpressionException("expression does not evaluate to a path", ExpressionException.ID_SEMANTIC);
        }
        this.pathExpression = expression;
    }
    
    /**
     * Returns the text used for creating the expression.
     * 
     * @return the text
     */
    public Expression getExpression() {
        return pathExpression;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> getEntryType() {
        return TypeRegistry.getType(IFileSystemArtifact.class);
    }


    @Override
    protected Object accept(IMatchVisitor visitor) throws ExpressionException {
        return visitor.visitPathMatchExpression(this);
    }

    /**
     * Sets the resolved value of the match expression, in particular in case of mixed expressions.
     * 
     * @param resolved the resolved path
     */
    void resolve(Path resolved) {
        this.resolved = resolved;
    }
    
    /**
     * Returns the resolved expression.
     * 
     * @return the resolved expression
     */
    public Path getResolved() {
        return resolved;
    }

    @Override
    public Collection<?> evaluate(IExpressionVisitor evaluator) throws ExpressionException {
        // requires resolve() before - must return a collection
        Collection<?> result;
        Path path = getResolved();
        if (null != path) {
            result = path.selectAll();    
        } else {
            result = null;
        }
        return result;
    }

}
