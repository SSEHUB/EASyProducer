package net.ssehub.easy.instantiation.core.model.tracing;

import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.ITracer;

/**
 * Factory for the creation of VIL build language tracer and
 * VIL template language tracer.
 * 
 * This is used to send tracer messages about the execution of VIL
 * build scripts and templates to the GUI, in particle, the Eclipse
 * console.
 * 
 * @author kroeher
 *
 */
public class ConsoleTracerFactory extends TracerFactory {

    /**
     * The tracer factory instance. 
     */
    public static final TracerFactory INSTANCE = new ConsoleTracerFactory();
    
    // we assume one instantiation at a time
    private StreamVilTracer tracer;

    /**
     * Constructs a new tracer factory and sets this instance
     * as the default factory.
     */
    private ConsoleTracerFactory() {
        tracer = new StreamVilTracer();
        setDefaultInstance(this);
    }

    /**
     * Constructs a new tracer factory which may emit tracer texts. Does not change the default
     * factory as opposed to {@link #ConsoleTracerFactory()}.
     * 
     * @param emitTraceText whether text passed to {@link #trace(String)} shall be emitted
     */
    public ConsoleTracerFactory(boolean emitTraceText) {
        tracer = new StreamVilTracer(emitTraceText);
    }
    
    @Override
    public ITracer createTemplateLanguageTracerImpl() {
        return tracer;
    }

    @Override
    public net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer
        createBuildLanguageTracerImpl() {
        return tracer;
    }

    @Override
    public IInstantiatorTracer createInstantiatorTracerImpl() {
        return tracer;
    }
    
}
