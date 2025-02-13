package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Defines the type for the entire template language visitor. The subclassed
 * interfaces are intentionally separated in order to allow for splitting
 * the implementation.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateLangVisitor extends IVisitor, IExpressionVisitor {

    
    /**
     * Visits a builder block expression.
     * 
     * @param ex the expression
     * @return the result of visiting the given statement (may be <b>null</b>)
     * @throws VilException in case that visiting fails (e.g., execution)
     */
    public Object visitBuilderBlockExpression(BuilderBlockExpression ex) throws VilException;

}
