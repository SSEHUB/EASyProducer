package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;

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

}
