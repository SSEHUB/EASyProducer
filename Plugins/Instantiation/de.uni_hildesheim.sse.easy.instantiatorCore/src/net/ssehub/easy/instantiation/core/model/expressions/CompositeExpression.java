package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a composite expression.
 * 
 * @author Sass
 * @author Holger Eichelberger
 */
public class CompositeExpression extends Expression implements IExpressionIterator {
    
    private List<Expression> expressionList;

    /**
     * Constructor for serialization.
     */
    CompositeExpression() {
    }
    
    /**
     * Creates a new composite expression.
     * 
     * @param expressionList a list with expressions
     */
    public CompositeExpression(List<Expression> expressionList) {
        this.expressionList = expressionList;
    }

    /**
     * Creates a new composite expression.
     * 
     * @param expressions the expressions
     */
    public CompositeExpression(Expression... expressions) {
        expressionList = new ArrayList<Expression>(expressions.length);
        for (int e = 0; e < expressions.length; e++) {
            expressionList.add(expressions[e]);
        }
    }

    /**
     * Returns the number of expression.
     * 
     * @return the number of expressions
     */
    public int getExpressionsCount() {
        return expressionList.size();
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the 0-based index of the expression
     * @return the expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getExpressionsCount()}</code>
     */
    public Expression getExpression(int index) {
        return expressionList.get(index);
    }

    /**
     * Replaces the specified expression. Handle with care!
     * 
     * @param index the 0-based index of the expression
     * @param expr the replacing expression
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getExpressionsCount()}</code>
     */
    public void setExpression(int index, Expression expr) {
        expressionList.set(index, expr);
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.stringType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitCompositeExpression(this);
    }


}
