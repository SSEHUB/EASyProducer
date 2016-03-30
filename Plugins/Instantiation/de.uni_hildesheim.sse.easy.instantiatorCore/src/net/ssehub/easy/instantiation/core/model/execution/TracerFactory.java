package net.ssehub.easy.instantiation.core.model.execution;

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

    public static final IInstantiatorTracer EMPTY_INSTANTIATOR_TRACER = new IInstantiatorTracer() {

        @Override
        public void traceMessage(String message) {
            // do nothing
        }

        @Override
        public void traceError(String message) {
            // do nothing
        }
    };

    private static TracerFactory instance = DEFAULT;

    /**
     * The default tracer factory returning tracer instances which do not trace
     * anything (NoTracer). New factories may be derived from this class.
     * 
     * @author Holger Eichelberger
     */
    public static class DefaultTracerFactory extends TracerFactory {

        @Override
        protected net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
            createTemplateLanguageTracerImpl() {
            
            return net.ssehub.easy.instantiation.core.model.templateModel.NoTracer.INSTANCE;
        }

        @Override
        protected net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
            createBuildLanguageTracerImpl() {
            
            return net.ssehub.easy.instantiation.core.model.buildlangModel.NoTracer.INSTANCE;
        }

        @Override
        protected IInstantiatorTracer createInstantiatorTracerImpl() {
            return EMPTY_INSTANTIATOR_TRACER;
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
    protected abstract net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
        createTemplateLanguageTracerImpl();
    
    /**
     * Creates a tracer for the VIL build language.
     * 
     * @return a tracer instance for the VIL build language (<b>null</b> will lead to the 
     *     corresponding result by {@link #DEFAULT})
     */
    protected abstract net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
        createBuildLanguageTracerImpl();
    
    /**
     * Creates a tracer for instantiators, i.e., to send messages to the VIL output.
     * 
     * @return the instantiator tracer
     */
    protected abstract IInstantiatorTracer createInstantiatorTracerImpl();

    /**
     * Creates a tracer for the VIL template language.
     * 
     * @return a tracer instance for the VIL template language
     */
    public static net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
        createTemplateLanguageTracer() {
        
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer result;
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
    public static net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
        createBuildLanguageTracer() {
        
        net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer result;
        result = getInstance().createBuildLanguageTracerImpl();
        if (null == result) {
            result = DEFAULT.createBuildLanguageTracerImpl();
        }
        return result;
    }

    /**
     * Creates a tracer for instantiators.
     * 
     * @return a tracer for instantiators
     */
    public static IInstantiatorTracer createInstantiatorTracer() {
        IInstantiatorTracer result;
        result = getInstance().createInstantiatorTracerImpl();
        if (null == result) {
            result = DEFAULT.createInstantiatorTracerImpl();
        }
        return result;
    }

}
