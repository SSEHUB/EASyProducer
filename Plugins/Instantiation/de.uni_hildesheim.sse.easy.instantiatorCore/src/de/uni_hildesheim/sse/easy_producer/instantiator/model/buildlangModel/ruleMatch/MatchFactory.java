package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ruleMatch;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * A factory to create the match expressions implemented in this package.
 * 
 * @author Holger Eichelberger
 */
public class MatchFactory {

    public static final MatchFactory INSTANCE = new MatchFactory();
    
    private static final TypeDescriptor <? extends IVilType> STRING = TypeRegistry.stringType();
    private static final TypeDescriptor <? extends IVilType> PATH = TypeRegistry.DEFAULT.getType(Path.class);
    private static final TypeDescriptor <? extends IVilType> ARTIFACT = TypeRegistry.artifactType();

    
    /**
     * Prevents external creation.
     */
    private MatchFactory() {
    }

    /**
     * Creates a rule match expression from <code>expr</code>.
     * 
     * @param expr the expression to be turned into a rule match expression
     * @return the resulting rule match expression (<b>null</b> if no creation is possible)
     * @throws ExpressionException in case of type problems
     */
    public AbstractRuleMatchExpression create(Expression expr) throws ExpressionException {
        // TODO use match expressions as prototypes for the decision here - deferred
        AbstractRuleMatchExpression result = null;
        TypeDescriptor<? extends IVilType> type = expr.inferType();
        if (STRING == type && expr instanceof ConstantExpression) {
            ConstantExpression cExpr = (ConstantExpression) expr;
            result = new StringMatchExpression(cExpr.getValue().toString());
        } else if (PATH.isAssignableFrom(type)) {
            result = new PathMatchExpression(expr);
        } else if (type.isCollection()) {
            result = new CollectionMatchExpression(expr);
        } else if (ARTIFACT.isAssignableFrom(type)) {
            result = new ArtifactMatchExpression(expr);
        } else if (expr instanceof AbstractRuleMatchExpression) {
            result = (AbstractRuleMatchExpression) expr;
        }
        return result;
    }

}
