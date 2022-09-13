package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a statement which contains just of an expression.
 * 
 * @author Holger Eichelberger
 */
public class ExpressionStatement 
    extends net.ssehub.easy.instantiation.core.model.common.ExpressionStatement 
    implements ITemplateElement {

    private ILanguageElement parent;

    /**
     * Constructor for serialization.
     */ 
    public ExpressionStatement() {
        super(null);
    }
    
    /**
     * Creates an expression statement.
     * 
     * @param expression the expression
     * @param parent the parent template
     */
    public ExpressionStatement(Expression expression, ILanguageElement parent) {
        super(expression);
        this.parent = parent;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return accept((net.ssehub.easy.instantiation.core.model.common.IVisitor) visitor);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public boolean isLoop() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return getExpression().inferType();
    }

    @Override
    public ILanguageElement getParent() {
        return parent;
    }

    @Override
    public boolean endsWithContentStatement() {
        return false;
    }

}
