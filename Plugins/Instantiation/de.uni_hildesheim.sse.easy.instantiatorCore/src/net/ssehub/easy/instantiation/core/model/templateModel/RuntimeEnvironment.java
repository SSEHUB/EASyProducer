package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;

/**
 * Implements the specialized runtime environment for VTL.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment 
    extends net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment<VariableDeclaration, Template> {
    
    /**
     * Creates a new runtime environment using the default type registry.
     */
    public RuntimeEnvironment() {
        super(VariableDeclaration.class);
    }
    
    @Override
    protected IExpressionVisitor createEvaluationProcessor() {
        return new TemplateLangExecution(this);
    }

    @Override
    protected void releaseEvaluationProcessor(IExpressionVisitor processor) {
        // nothing to do
    }

}
