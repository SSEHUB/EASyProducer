package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;

/**
 * A simple tracer interface providing test support to the execution part.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer extends net.ssehub.easy.instantiation.core.model.expressions.ITracer {
    
    /**
     * Emits a trace string.
     * 
     * @param text the text to be emitted
     */
    public void trace(String text);

    /**
     * Emits a warning trace string.
     * 
     * @param text the text to be emitted
     */
    public void traceWarning(String text);

    /**
     * Emits an error trace string.
     * 
     * @param text the text to be emitted
     */
    public void traceError(String text);

    /**
     * Is called when a value of a variable is defined.
     * 
     * @param var the modified variable
     * @param field the field in <code>var</code>, may be <b>null</b>
     * @param value the actual value
     */
    public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value);

    /**
     * Traces a top-level execution exception, i.e., execution a VIL script or template failed.
     * 
     * @param exception the exception
     */
    public void traceExecutionException(VilException exception);
    
    /**
     * Enables or disables the tracer. By default, a tracer is enabled.
     * 
     * @param enable enable or disable
     */
    public void enable(boolean enable);

}
