package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallExpression.CallType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;

/**
 * Implements a tracer which does noting.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer implements ITracer {
    
    public static final ITracer INSTANCE = new NoTracer();

    @Override
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args) {
    }
    
    @Override
    public void visitedCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args, Object result) {
    }

    @Override
    public void failedAt(Expression expression) {
    }

}
