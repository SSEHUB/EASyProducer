package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a statement which contains just of an expression.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionStatement 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ExpressionStatement 
    implements ITemplateElement {

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
        return accept((de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVisitor) visitor);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return getExpression().inferType();
    }

}
