package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Defines the type for the entire template language visitor. The subclassed
 * interfaces are intentionally separated in order to allow for splitting
 * the implementation.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateLangVisitor extends IVisitor, IExpressionVisitor {

}
