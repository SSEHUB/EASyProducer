package net.ssehub.easy.instantiation.core.model.expressions;

import java.util.Locale;

import net.ssehub.easy.instantiation.core.model.expressions.CallExpression.CallType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;

/**
 * Defines a tracer interface for receiving information about runtime execution, e.g., for testing.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer {

    /**
     * Is called before a resolved call expression is actually executed. Do <b>not</b>
     * modify the parameters!
     * 
     * @param descriptor the descriptor to be called
     * @param callType the type of the call
     * @param args the actual arguments
     */
    public void visitingCallExpression(OperationDescriptor descriptor, CallType callType, Object[] args);
    
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

    /**
     * Returns the current locale for evaluation.
     * 
     * @return the current locale
     */
    public Locale getLocale();
    
    /**
     * Changes the current locale.
     * 
     * @param locale the new locale (ignored if <b>null</b>) 
     */
    public void setLocale(Locale locale);

}
