package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;

/**
 * Defines a tracer interface for receiving information about runtime execution, e.g., for testing.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer {

    /**
     * Is called after a resolved call expression is actually executed. Do <b>not</b>
     * modify the parameters!
     * 
     * @param descriptor the descriptor to be called
     * @param callType the type of the call
     * @param args the actual arguments
     * @param result the result of the call
     */
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result);
    
    /**
     * Is called when the evaluation of an expression caused an execution failure.
     * 
     * @param expression the failing expression
     */
    public void failedAt(Expression expression);

}
