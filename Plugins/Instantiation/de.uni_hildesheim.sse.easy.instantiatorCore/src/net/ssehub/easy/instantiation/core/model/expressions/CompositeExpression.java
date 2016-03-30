package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a composite expression.
 * 
 * @author Sass
 *
 */
public class CompositeExpression extends Expression {
    
    private List<Expression> expressionList;
    
    /**
     * Creates a new composite expression.
     * 
     * @param expressionList a list with expressions
     */
    public CompositeExpression(List<Expression> expressionList) {
        this.expressionList = expressionList;
    }
    
    /**
     * Returns a list of expressions.
     * 
     * @return list of expressions
     */
    public List<Expression> getExpressionList() {
        return expressionList;
    }

    /**
     * Adds a list of expressions.
     * 
     * @param expressionList list of expressions
     */
    public void setExpressionList(List<Expression> expressionList) {
        this.expressionList = expressionList;
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
