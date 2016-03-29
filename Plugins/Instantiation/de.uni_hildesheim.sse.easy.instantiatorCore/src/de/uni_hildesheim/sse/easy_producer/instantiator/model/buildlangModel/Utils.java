package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ConstantExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.VariableExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;

/**
 * Some VTL utility methods.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    /**
     * Prevents external creation.
     */
    private Utils() {
    }

    /**
     * Creates a single restriction.
     * 
     * @param parent the parent object (usually the script)
     * @param operation the operation name to be executed
     * @param version the version to be compared
     * @return the restriction object
     * @throws RestrictionEvaluationException in case of expression problems
     */
    public static ExpressionVersionRestriction createSingleRestriction(Object parent, String operation, 
        Version version) throws RestrictionEvaluationException {
        try {
            TypeDescriptor<?> versionType = TypeRegistry.versionType();
            VariableDeclaration var = new VariableDeclaration("version", versionType);
            Expression verExpr = new ConstantExpression(versionType, version, TypeRegistry.DEFAULT);
            Expression expr = new CallExpression(parent, operation, new VariableExpression(var), verExpr);
            expr.inferType();
            return new ExpressionVersionRestriction(expr, var);
        } catch (VilException e) {
            throw new RestrictionEvaluationException(e.getMessage(), e.getId());
        }
    }

    /**
     * Returns the last expression of the given rule block.
     * 
     * @param block the block to search
     * @return the last expression
     */
    public static ExpressionStatement findLastExpressionStatement(IRuleBlock block) {
        ExpressionStatement expr = null;
        for (int e = block.getBodyElementCount() - 1; null == expr && e >= 0; e--) {
            IRuleElement elt = block.getBodyElement(e);
            if (elt instanceof ExpressionStatement) {
                expr = (ExpressionStatement) elt;
            }
        }
        return expr;
    }

    /**
     * Returns the last expression of the given rule block.
     * 
     * @param block the block to search
     * @return the last expression
     */
    public static Expression findLastExpression(IRuleBlock block) {
        ExpressionStatement stmt = findLastExpressionStatement(block);
        // before it was the last expression statement with null != expression
        return null == stmt ? null : stmt.getExpression();
    }
    
}
