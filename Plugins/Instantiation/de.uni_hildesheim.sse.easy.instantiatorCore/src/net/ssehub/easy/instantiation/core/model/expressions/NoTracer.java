package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Implements a tracer which does noting.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends AbstractTracerBase {
    
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
