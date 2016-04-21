package net.ssehub.easy.producer.ui.core.instantiation;

import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.ITracer;

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
public class GuiTracerFactory extends TracerFactory {

    /**
     * The tracer factory instance. 
     */
    public static final TracerFactory INSTANCE = new GuiTracerFactory();

    /**
     * Constructs a new tracer factory and sets this instance
     * as the default tracer.
     */
    private GuiTracerFactory() {
        setDefaultInstance(this);
    }
    
    @Override
    protected ITracer createTemplateLanguageTracerImpl() {
        return VilTracer.INSTANCE;
    }

    @Override
    protected net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer
        createBuildLanguageTracerImpl() {
        
        return VilTracer.INSTANCE;
    }

    @Override
    protected IInstantiatorTracer createInstantiatorTracerImpl() {
        return VilTracer.INSTANCE;
    }
}
