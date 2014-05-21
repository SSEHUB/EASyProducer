package de.uni_hildesheim.sse.easy_producer.core.varMod.tracing;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer;

/**
 * Factory for the creation of VIL build language tracer and
 * VIL template language tracer.
 * 
 * This is used to send tracer messages about the execution of VIL
 * build scripts and templates to the GUI, in particule, the Eclipse
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
    protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer
    createBuildLanguageTracerImpl() {
        return TRACER;
    }
    
}
