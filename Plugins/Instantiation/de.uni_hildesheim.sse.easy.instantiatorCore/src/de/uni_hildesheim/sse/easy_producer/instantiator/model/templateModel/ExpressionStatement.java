package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
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
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return accept((de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVisitor) visitor);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        try {
            return getExpression().inferType();
        } catch (ExpressionException e) {
            throw new VilLanguageException(e);
        }
    }

}
