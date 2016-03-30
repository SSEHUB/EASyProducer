package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;

/**
 * Represents a statement which contains just of an expression.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionStatement 
    extends net.ssehub.easy.instantiation.core.model.common.ExpressionStatement implements IRuleElement {

    /**
     * Creates an expression statement.
     * 
     * @param expression the expression
     */
    public ExpressionStatement(Expression expression) {
        super(expression);
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return accept((net.ssehub.easy.instantiation.core.model.common.IVisitor) visitor);
    }

}
