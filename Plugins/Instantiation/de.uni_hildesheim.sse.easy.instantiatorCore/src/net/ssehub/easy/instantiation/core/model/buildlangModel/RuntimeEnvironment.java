package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * A specific runtime environment containing the global OTHERPROJECTS variable.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment extends 
    net.ssehub.easy.instantiation.core.model.common.RuntimeEnvironment<VariableDeclaration, Script> {

    /**
     * Defines the other project variable, currently as a local set implementation using
     * a hash set. This variable is global across the entire execution starting at 
     * a certain script including imported scripts etc.
     */
    private OtherProjects otherProjects = new OtherProjects();

    /**
     * Creates a new runtime environment using the default type registry.
     */
    public RuntimeEnvironment() {
        super(VariableDeclaration.class);
    }

    /**
     * Creates a new runtime environment with a given type registry instance.
     * 
     * @param typeRegistry the type registry to use
     */
    public RuntimeEnvironment(TypeRegistry typeRegistry) {
        super(VariableDeclaration.class, typeRegistry);
    }

    /**
     * Returns the other projects variable (for package internal use only).
     * 
     * @return the other projects variable
     */
    OtherProjects getOtherProjects() {
        return otherProjects;
    }

    @Override
    protected IExpressionVisitor createEvaluationProcessor() {
        return new BuildlangExecution(this);
    }
    
    @Override
    protected void releaseEvaluationProcessor(IExpressionVisitor processor) {
        // nothing to do
    }

}
