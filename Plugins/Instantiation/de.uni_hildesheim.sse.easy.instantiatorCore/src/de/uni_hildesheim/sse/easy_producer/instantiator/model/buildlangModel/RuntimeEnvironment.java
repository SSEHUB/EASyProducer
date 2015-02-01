package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * A specific runtime environment containing the global OTHERPROJECTS variable.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment extends 
    de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment {

    /**
     * Defines the other project variable, currently as a local set implementation using
     * a hash set. This variable is global across the entire execution starting at 
     * a certain script including imported scripts etc.
     */
    private OtherProjects otherProjects = new OtherProjects();

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
