package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Implements the specialized runtime environment for VTL.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment 
    extends net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment {
    
    @Override
    protected IExpressionVisitor createEvaluationProcessor() {
        return new TemplateLangExecution(this);
    }

    @Override
    protected void releaseEvaluationProcessor(IExpressionVisitor processor) {
        // nothing to do
    }

}
