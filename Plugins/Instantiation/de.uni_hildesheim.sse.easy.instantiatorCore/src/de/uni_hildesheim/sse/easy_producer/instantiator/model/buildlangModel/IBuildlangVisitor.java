package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * Defines the type for the entire buildlang visitor. The subclassed
 * interfaces are intentionally separated in order to allow for splitting
 * the implementation.
 * 
 * @author Holger Eichelberger
 */
public interface IBuildlangVisitor extends IVisitor, IExpressionVisitor {

}
