package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * Defines the type for the entire template language visitor. The subclassed
 * interfaces are intentionally separated in order to allow for splitting
 * the implementation.
 * 
 * @author Holger Eichelberger
 */
public interface ITemplateLangVisitor extends IVisitor, IExpressionVisitor {

}
