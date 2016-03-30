package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Represents a statement which contains just of an expression.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionStatement {

    private Expression expression;

    /**
     * Creates an expression statement.
     * 
     * @param expression the expression
     */
    public ExpressionStatement(Expression expression) {
        this.expression = expression;
    }
    
    /**
     * Returns the expression.
     * 
     * @return the expression
     */
    public Expression getExpression() {
        return expression;
    }
    
    /**
     * Accepts the given visitor for visiting this instance.
     * 
     * @param visitor the visitor
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitExpressionStatement(this);
    }
    
    /**
     * Changes this statement by applying a conversion operation to {@link expression}.
     * 
     * @param op the conversion operation
     * @throws VilException in case that applying the conversion fails
     */
    public void applyConversionTo(OperationDescriptor op) throws VilException {
        if (null != op) {
            expression = new CallExpression(op, new CallArgument(expression));
            expression.inferType();
        }
    }

}
