package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a parenthesis expression.
 * 
 * @author Holger Eichelberger
 */
public class ParenthesisExpression extends Expression {

    private Expression expr;
    
    /**
     * Creates a new parenthesis expression.
     * 
     * @param expr the expression within the parenthesis
     */
    public ParenthesisExpression(Expression expr) {
        this.expr = expr;
    }
    
    /**
     * Returns the expression within the parenthesis.
     * 
     * @return the expression
     */
    public Expression getExpr() {
        return expr;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return expr.inferType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitParenthesisExpression(this);
    }

}
