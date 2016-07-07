package net.ssehub.easy.instantiation.core.model.execution;

import java.util.HashMap;
import java.util.Map;

/**
 * A factory for the VIL language execution tracers. Basically, default tracer factory ({@link #getDefaultInstance()})
 * is static and initialized with {@link #DEFAULT}. However, as VIL can be executed in multiple
 * threads in parallel, this factory can also be used on a per-thread basis ({@link #getInstance()}.
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

    private static TracerFactory defaultFactory = DEFAULT;
    private static Map<Long, TracerFactory> instances = new HashMap<Long, TracerFactory>();

    /**
     * The default tracer factory returning tracer instances which do not trace
     * anything (NoTracer). New factories may be derived from this class.
     * 
     * @author Holger Eichelberger
     */
    public static class DefaultTracerFactory extends TracerFactory {

        @Override
        public net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
            createTemplateLanguageTracerImpl() {
            
            return net.ssehub.easy.instantiation.core.model.templateModel.NoTracer.INSTANCE;
        }

        @Override
        public net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
            createBuildLanguageTracerImpl() {
            
            return net.ssehub.easy.instantiation.core.model.buildlangModel.NoTracer.INSTANCE;
        }

        @Override
        public IInstantiatorTracer createInstantiatorTracerImpl() {
            return EMPTY_INSTANTIATOR_TRACER;
        }
        
    };
    
    /**
     * Returns the default instance.
     * 
     * @return the default instance
     */
    public static TracerFactory getDefaultInstance() {
        return defaultFactory;
    }
    
    /**
     * Defines the default instance.
     * 
     * @param factory the new default instance (ignored if <b>null</b>)
     */
    public static void setDefaultInstance(TracerFactory factory) {
        if (null != factory) {
            defaultFactory = factory;
        }
    }
    
    /**
     * Defines a new tracer factory for the current thread.
     * 
     * @param newInstance the new tracer factory (<b>null</b> deletes a previously defined instance)
     */
    public static void setInstance(TracerFactory newInstance) {
        long threadId = Thread.currentThread().getId();
        if (null != newInstance) {
            instances.put(threadId, newInstance);
        } else {
            instances.remove(threadId);
        }
    }
    
    /**
     * Returns the tracer factory for the current thread.
     * 
     * @return the current tracer factory, if there is none defined return {@link #defaultFactory}
     */
    public static TracerFactory getInstance() {
        TracerFactory result = instances.get(Thread.currentThread().getId());
        if (null == result) {
            result = defaultFactory;
        }
        return result;
    }
    
    /**
     * Creates a tracer for the VIL template language.
     * 
     * @return a tracer instance for the VIL template language (<b>null</b> will lead to the 
     *     corresponding result by {@link #DEFAULT}) 
     */
    public abstract net.ssehub.easy.instantiation.core.model.templateModel.ITracer 
        createTemplateLanguageTracerImpl();
    
    /**
     * Creates a tracer for the VIL build language.
     * 
     * @return a tracer instance for the VIL build language (<b>null</b> will lead to the 
     *     corresponding result by {@link #DEFAULT})
     */
    public abstract net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer 
        createBuildLanguageTracerImpl();
    
    /**
     * Creates a tracer for instantiators, i.e., to send messages to the VIL output.
     * 
     * @return the instantiator tracer
     */
    public abstract IInstantiatorTracer createInstantiatorTracerImpl();

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
