package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ContainerInitializerExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionEvaluator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionParser;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IRuntimeEnvironment;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ParenthesisExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.StringReplacer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ValueAssignmentExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VarModelIdentifierExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VilTypeExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * This class resolves match expressions if necessary.
 * 
 * @author Holger Eichelberger
 */
public class MatchResolver implements IExpressionVisitor, IMatchVisitor {

    private IRuntimeEnvironment environment;
    private IExpressionParser expressionParser; 
    private IExpressionVisitor evaluator;

    /**
     * Creates a match resolver.
     * 
     * @param environment the actual runtime environment
     * @param expressionParser the actual expression parser
     * @param evaluator the actual evaluator
     */
    public MatchResolver(IRuntimeEnvironment environment, IExpressionParser expressionParser, 
        IExpressionVisitor evaluator) {
        this.environment = environment;
        this.expressionParser = expressionParser;
        this.evaluator = evaluator;
    }
    
    /**
     * Resolves the given string.
     * 
     * @param string the string to be resolved
     * @return the resolved string
     * @throws ExpressionException in case that resolution fails
     */
    private String resolve(String string) throws ExpressionException {
        return StringReplacer.substitute(string, environment, expressionParser, evaluator);
    }
    
    @Override
    public Object visitPathMatchExpression(PathMatchExpression expression) throws ExpressionException {
        Object value = expression.getExpression().accept(this);
        if (value instanceof Path) {
            try {
                Path path = (Path) value;
                String text = resolve(path.getPath());
                Path resolved = Path.create(text);
                expression.resolve(resolved);
            } catch (ArtifactException e) {
                throw new ExpressionException(e);
            }
        } else {
            if (null != value) {
                throw new ExpressionException("does not evaluate to a path", ExpressionException.ID_RUNTIME);
            }
        }
        return null;
    }

    @Override
    public Object visitStringMatchExpression(StringMatchExpression expression) throws ExpressionException {
        try {
            String text = resolve(expression.getText());
            Path path = Path.create(text);
            expression.resolve(path);
        } catch (ArtifactException e) {
            throw new ExpressionException(e);
        }
        return null;
    }

    @Override
    public Object visitArtifactMatchExpression(ArtifactMatchExpression expression) throws ExpressionException {
        expression.resolve(expression.getExpression().accept(evaluator));
        return null;
    }

    @Override
    public Object visitCollectionMatchExpression(CollectionMatchExpression expression) throws ExpressionException {
        expression.resolve(expression.getExpression().accept(evaluator));
        return null;
    }

    @Override
    public Object visitParenthesisExpression(ParenthesisExpression par) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitCallExpression(CallExpression call) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitConstantExpression(ConstantExpression cst) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVarModelIdentifierExpression(VarModelIdentifierExpression identifier) 
        throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVilTypeExpression(VilTypeExpression typeExpression) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitVariableExpression(VariableExpression cst) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitExpression(Expression ex) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitValueAssignmentExpression(ValueAssignmentExpression ex) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitExpressionEvaluator(ExpressionEvaluator ex) throws ExpressionException {
        return null;
    }

    @Override
    public Object visitContainerInitializerExpression(ContainerInitializerExpression ex) throws ExpressionException {
        return null;
    }

}
