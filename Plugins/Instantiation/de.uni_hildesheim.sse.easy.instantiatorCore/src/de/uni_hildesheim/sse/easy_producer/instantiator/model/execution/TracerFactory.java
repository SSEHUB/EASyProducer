package de.uni_hildesheim.sse.easy_producer.instantiator.model.execution;

/**
 * A factory for the VIL language execution tracers.
 * 
 * @author Holger Eichelberger
 */
public abstract class TracerFactory {

    /**
     * Defines the default tracer.
     */
    public static final TracerFactory DEFAULT = new DefaultTracerFactory();
    private static TracerFactory instance = DEFAULT;
    
    /**
     * The default tracer factory returning tracer instances which do not trace
     * anything (NoTracer). New factories may be derived from this class.
     * 
     * @author Holger Eichelberger
     */
    public static class DefaultTracerFactory extends TracerFactory {

        @Override
        protected de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer 
        createTemplateLanguageTracerImpl() {
            return de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.NoTracer.INSTANCE;
        }

        @Override
        protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer 
        createBuildLanguageTracerImpl() {
            return de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.NoTracer.INSTANCE;
        }
        
    };
    
    /**
     * Defines a new tracer factory.
     * 
     * @param newInstance the new tracer factory (<b>null</b> is ignored)
     */
    public static void setInstance(TracerFactory newInstance) {
        if (null != newInstance) {
            instance = newInstance;
        }
    }
    
    /**
     * Returns the current tracer factory.
     * 
     * @return the current tracer factory
     */
    public static TracerFactory getInstance() {
        return instance;
    }
    
    /**
     * Creates a tracer for the VIL template language.
     * 
     * @return a tracer instance for the VIL template language (<b>null</b> will lead to the 
     *     corresponding result by {@link #DEFAULT}) 
     */
    protected abstract de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer 
    createTemplateLanguageTracerImpl();
    
    /**
     * Creates a tracer for the VIL build language.
     * 
     * @return a tracer instance for the VIL build language (<b>null</b> will lead to the 
     *     corresponding result by {@link #DEFAULT})
     */
    protected abstract de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer 
    createBuildLanguageTracerImpl();

    /**
     * Creates a tracer for the VIL template language.
     * 
     * @return a tracer instance for the VIL template language
     */
    public static de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer 
    createTemplateLanguageTracer() {
        de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer result;
        result = getInstance().createTemplateLanguageTracerImpl();
        if (null == result) {
            result = DEFAULT.createTemplateLanguageTracerImpl();
        }
        return result;
    }
    
    /**
     * Creates a tracer for the VIL build language.
     * 
     * @return a tracer instance for the VIL build language
     */
    public static de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer 
    createBuildLanguageTracer() {
        de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer result;
        result = getInstance().createBuildLanguageTracerImpl();
        if (null == result) {
            result = DEFAULT.createBuildLanguageTracerImpl();
        }
        return result;
    }
    
}
