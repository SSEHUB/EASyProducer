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
    private static final StreamVilTracer TRACER = new StreamVilTracer();

    /**
     * Constructs a new tracer factory and sets this instance
     * as the default tracer.
     */
    private ConsoleTracerFactory() {
        super.setInstance(this);
    }
    
    @Override
    protected ITracer createTemplateLanguageTracerImpl() {
        return TRACER;
    }

    @Override
    protected net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer
        createBuildLanguageTracerImpl() {
        
        return TRACER;
    }

    @Override
    protected IInstantiatorTracer createInstantiatorTracerImpl() {
        return TRACER;
    }
    
}
