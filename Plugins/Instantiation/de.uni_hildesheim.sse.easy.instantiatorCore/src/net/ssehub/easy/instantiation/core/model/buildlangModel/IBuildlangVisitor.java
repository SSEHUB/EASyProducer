package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Defines the type for the entire buildlang visitor. The subclassed
 * interfaces are intentionally separated in order to allow for splitting
 * the implementation.
 * 
 * @author Holger Eichelberger
 */
public interface IBuildlangVisitor extends IVisitor, IExpressionVisitor {

}
