package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

/**
 * A simple tracer interface providing test support to the execution part.
 * 
 * @author Holger Eichelberger
 */
public interface ITracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ITracer {
    
    /**
     * Emits a trace string.
     * 
     * @param text the text to be emitted
     */
    public void trace(String text);

    /**
     * Is called when a value of a variable is defined.
     * 
     * @param var the modified variable
     * @param value the actual value
     */
    public void valueDefined(VariableDeclaration var, Object value);

    /**
     * Traces a top-level execution exception, i.e., execution a VIL script or template failed.
     * 
     * @param exception the exception
     */
    public void traceExecutionException(VilLanguageException exception);
    
}
