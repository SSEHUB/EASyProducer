package net.ssehub.easy.instantiation.core.model.execution;

/**
 * A tracer for instantiators.
 * 
 * @author Holger Eichelberger
 */
public interface IInstantiatorTracer {

    /**
     * Trace a message (usually going to System.out in an instantiator).
     * 
     * @param message the message to be traced
     */
    public void traceMessage(String message);

    /**
     * Trace an error (usually going to System.err in an instantiator).
     * 
     * @param message the message to be traced
     */
    public void traceError(String message);
    
}
