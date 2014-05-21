package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.NoTracer 
    implements ITracer {

    /**
     * Prevents external instantiation.
     */
    protected NoTracer() {
    }
    
    @Override
    public void trace(String text) {
    }

    @Override
    public void valueDefined(VariableDeclaration var, Object value) {
    }

    @Override
    public void traceExecutionException(VilLanguageException exception) {
    }

}
