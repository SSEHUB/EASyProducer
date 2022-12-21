package net.ssehub.easy.instantiation.core.model.execution;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.basics.progress.ProgressObserver.ISubtask;
import net.ssehub.easy.basics.progress.ProgressObserver.ITask;
import net.ssehub.easy.instantiation.core.model.common.ITraceFilter;
import net.ssehub.easy.instantiation.core.model.common.NoTraceFilter;

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
    public static final Map<Thread, net.ssehub.easy.instantiation.core.model.templateModel.ITracer> 
        TEMPLATELANG_TRACERS = new HashMap<Thread, 
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer>();
    public static final Map<Thread, net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer> 
        BUILDLANG_TRACERS = new HashMap<Thread, 
        net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer>();
    public static final Map<ProgressObserver, TaskData> PROGRESS_OBSERVERS = new HashMap<ProgressObserver, TaskData>();

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
    private static ITraceFilter filter = NoTraceFilter.INSTANCE; // legacy

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
     * Defines the trace filter to applied on all created tracers.
     * 
     * @param fInstance the new trace filter, ignored if <b>null</b>
     * @return the filter before this call, may be <b>null</b>
     */
    public static ITraceFilter setTraceFilter(ITraceFilter fInstance) {
        ITraceFilter result = filter;
        if (null != fInstance) {
            filter = fInstance;
        }
        return result;
    }
    
    public static ITraceFilter getTraceFilter() {
        return filter;
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
        result.setTraceFilter(filter);
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
        result.setTraceFilter(filter);
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
    
    /**
     * Registers a build language tracer along with the current thread.
     * 
     * @param tracer the tracer, ignored if <b>null</b>
     * @see #unregisterBuildLanguageTracer(net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer)
     */
    public static void registerBuildLanguageTracer(
        net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer tracer) {
        if (null != tracer) {
            BUILDLANG_TRACERS.put(Thread.currentThread(), tracer);
        }
    }

    /**
     * Unregisters a build language tracer from the current thread.
     * 
     * @param tracer the tracer, ignored if <b>null</b>
     * @see #registerBuildLanguageTracer(net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer)
     */
    public static void unregisterBuildLanguageTracer(
        net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer tracer) {
        if (null != tracer) {
            BUILDLANG_TRACERS.remove(Thread.currentThread());
        }
    }

    /**
     * Returns the currently registered build language tracer for the current thread.
     * 
     * @return the currently registered build language tracer or <b>null</b> if there is none
     */
    public static net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer getRegisteredBuildLanguageTracer() {
        return BUILDLANG_TRACERS.get(Thread.currentThread());
    }

    /**
     * Registers a template language tracer along with the current thread.
     * 
     * @param tracer the tracer, ignored if <b>null</b>
     * @see #unregisterTemplateLanguageTracer(net.ssehub.easy.instantiation.core.model.templateModel.ITracer)
     */
    public static void registerTemplateLanguageTracer(
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer tracer) {
        if (null != tracer) {
            TEMPLATELANG_TRACERS.put(Thread.currentThread(), tracer);
        }
    }

    /**
     * Unregisters a template language tracer from the current thread.
     * 
     * @param tracer the tracer, ignored if <b>null</b>
     * @see #registerTemplateLanguageTracer(net.ssehub.easy.instantiation.core.model.templateModel.ITracer)
     */
    public static void unregisterTemplateLanguageTracer(
        net.ssehub.easy.instantiation.core.model.templateModel.ITracer tracer) {
        if (null != tracer) {
            TEMPLATELANG_TRACERS.remove(Thread.currentThread());
        }
    }

    /**
     * Returns the currently registered template language tracer for the current thread.
     * 
     * @return the currently registered template language tracer or <b>null</b> if there is none
     */
    public static net.ssehub.easy.instantiation.core.model.templateModel.ITracer getRegisteredTemplateLanguageTracer() {
        return TEMPLATELANG_TRACERS.get(Thread.currentThread());
    }
    
    /**
     * Stores information about the current task of a progress observer.
     * 
     * @author Holger Eichelberger
     */
    private static class TaskData {
        private ITask task;
        private String taskDescription;
        private Map<String, ISubtask> subtasks = new HashMap<String, ISubtask>();
        // can be extended to subtasks if needed
    }
    
    /**
     * Notifies the tracer about the actual progress in order to inform the user.
     * 
     * @param actual the actual step (negative disables display)
     * @param max the maximum number of steps (may vary over time, negative disables display)
     * @param description an optional description of the step (may be <b>null</b>)
     */
    public static void progress(int actual, int max, String description) {
        for (Map.Entry<ProgressObserver, TaskData> entry : PROGRESS_OBSERVERS.entrySet()) {
            ProgressObserver obs = entry.getKey();
            TaskData task = entry.getValue();
            boolean newTask = false;
            if (null == task) {
                newTask = true;
            } else if (null != description && !task.taskDescription.equals(description)) {
                // null == description -> keep task
                // not same description -> new task
                obs.notifyEnd(task.task);
                newTask = true;
            }
            if (newTask) {
                task = new TaskData();
                task.taskDescription = null == description ? "..." : description;
                task.task = obs.registerTask(task.taskDescription);
                entry.setValue(task);
            }
            obs.notifyProgress(task.task, actual, max);
        }
    }
    
    /**
     * Notifies about creation/progress of a subtask (just grabbing the actual task in all registered observers).
     * 
     * @param actual the actual number of steps in the sub task
     * @param max the maximum number of steps
     * @param taskName the name of the sub task
     */
    public static void progressSubTask(int actual, int max, String taskName) {
        for (Map.Entry<ProgressObserver, TaskData> entry : PROGRESS_OBSERVERS.entrySet()) {
            ProgressObserver obs = entry.getKey();
            TaskData task = entry.getValue();
            if (null != task) {
                ISubtask sub = task.subtasks.get(taskName);
                if (null == sub) {
                    sub = obs.registerSubtask(taskName);
                    task.subtasks.put(taskName, sub);
                }
                obs.notifyProgress(task.task, sub, actual, max);
                if (actual == max) {
                    obs.notifyEnd(task.task, sub);
                    task.subtasks.remove(taskName);
                }
            }
        }        
    }
    
    /**
     * Ensures that there is a task with the given {@code description} on all registered observers. Existing tasks will 
     * be kept.
     * 
     * @param description the task description
     */
    public static void ensureTasks(String description) {
        for (Map.Entry<ProgressObserver, TaskData> entry : PROGRESS_OBSERVERS.entrySet()) {
            ProgressObserver obs = entry.getKey();
            TaskData task = entry.getValue();
            if (null == task) {
                task = new TaskData();
                task.taskDescription = null == description ? "..." : description;
                task.task = obs.registerTask(task.taskDescription);
                entry.setValue(task);
            }
        }
    }
    
    /**
     * Closes existing tasks with the given {@code description} on all registered observers. Closed tasks will be set
     * to <b>null</b> on the respective observers.
     * 
     * @param description the description to look for
     */
    public static void closeTasks(String description) {
        for (Map.Entry<ProgressObserver, TaskData> entry : PROGRESS_OBSERVERS.entrySet()) {
            ProgressObserver obs = entry.getKey();
            TaskData task = entry.getValue();
            if (null != description && !task.taskDescription.equals(description)) {
                obs.notifyEnd(task.task);
                entry.setValue(null);
            }
        }        
    }
    
    /**
     * Registers the given progress reserver.
     * 
     * @param observer the observer (ignored if <b>null</b>)
     */
    public static void registerProgressObserver(ProgressObserver observer) {
        if (null != observer && !PROGRESS_OBSERVERS.containsKey(observer)) {
            PROGRESS_OBSERVERS.put(observer, null);
        }
    }

    /**
     * Unregisters the given progress observer.
     * 
     * @param observer the progress observer (ignored if <b>null</b>)
     */
    public static void unregisterProgressObserver(ProgressObserver observer) {
        if (null != observer) {
            TaskData task = PROGRESS_OBSERVERS.remove(observer);
            if (null != task && null != task.task) {
                observer.notifyEnd(task.task);
            }
        }
    }

}
