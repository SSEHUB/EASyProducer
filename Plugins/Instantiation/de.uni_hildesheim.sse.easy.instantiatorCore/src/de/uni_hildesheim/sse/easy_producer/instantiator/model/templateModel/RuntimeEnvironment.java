package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * Implements the specialized runtime environment for VTL.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment 
    extends de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment {
    
    @Override
    protected IExpressionVisitor createEvaluationProcessor() {
        return new TemplateLangExecution(this);
    }

    @Override
    protected void releaseEvaluationProcessor(IExpressionVisitor processor) {
        // nothing to do
    }

}
