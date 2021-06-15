package net.ssehub.easy.instantiation.core.model.common;

import net.ssehub.easy.instantiation.core.model.vilTypes.FieldDescriptor;

/**
 * Implements a no-action execution tracer.
 * 
 * @author Holger Eichelberger
 */
public class NoTracer extends net.ssehub.easy.instantiation.core.model.expressions.NoTracer 
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
    public void valueDefined(VariableDeclaration var, FieldDescriptor field, Object value) {
    }

    @Override
    public void traceExecutionException(VilException exception) {
    }

    @Override
    public void enable(boolean enable) {
    }

    @Override
    public void traceWarning(String text) {
    }

    @Override
    public void traceError(String text) {
    }

}
