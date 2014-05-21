package de.uni_hildesheim.sse.utils.progress;

/**
 * Observes the progress of a longer lasting task.
 * 
 * @author Holger Eichelberger
 */
public abstract class ProgressObserver {

    /**
     * Denotes the empty subtask.
     */
    public static final ISubtask NO_SUBTASK = null;

    /**
     * Defines an observer which does nothing. Avoids a lot
     * of if-then-else constructs.
     */
    public static final ProgressObserver NO_OBSERVER = new ProgressObserver() {
        
        @Override
        public ITask registerTask(String task) {
            return null;
        }
        
        @Override
        public ISubtask registerSubtask(String subtask) {
            return null;
        }
        
        @Override
        public void notifyStart(ITask task, ISubtask subtask, int max) {
        }
        
        @Override
        public void notifyProgress(ITask task, ISubtask subtask, int step, int max) {
        }
        
        @Override
        public void notifyEnd(ITask task, ISubtask subtask) {
        }
    };
    
    /**
     * Marker interface for a task.
     * 
     * @author Holger Eichelberger
     */
    public interface ITask {
    }

    /**
     * Marker interface for a subtask.
     * 
     * @author Holger Eichelberger
     */
    public interface ISubtask {
    }

    /**
     * Registers a task for notify about processing progress.
     * 
     * @param task the name of the task
     * @return the task identification
     */
    public abstract ITask registerTask(String task);

    /**
     * Registers a subtask to notify about processing progress.
     * 
     * @param subtask the name of the sub task
     * @return the task identification
     */
    public abstract ISubtask registerSubtask(String subtask);

    /**
     * Notifies about starting a task.
     * 
     * @param task the identification of task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param max the intended maximum steps of the subtask
     */
    public void notifyStart(ITask task, int max) {
        notifyStart(task, NO_SUBTASK, max);
    }
    
    /**
     * Notifies about starting a (sub)task. Subtask notifications shall occur
     * after task notifications, i.e. nested.
     * 
     * @param task the identification of task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param subtask the subtask (may be {@link #NO_SUBTASK}) (initially 
     *   use {@link #registerSubtask(String)} for registering a sub task)
     * @param max the intended maximum steps of the subtask
     */
    public abstract void notifyStart(ITask task, ISubtask subtask, int max);

    /**
     * Notifies about processing a task or a subtask. 
     * 
     * @param task the identification of the task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param step the current step in 0&lt;=<code>step</code>&lt;=<code>max</code>
     * @param max the maximum number of steps, ignored if negative and value from
     *   start notification is used instead
     */
    public void notifyProgress(ITask task, int step, int max) {
        notifyProgress(task, NO_SUBTASK, step, max);
    }
    
    /**
     * Notifies about processing a task or a subtask. 
     * 
     * @param task the identification of the task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param step the current step in 0&lt;=<code>step</code>&lt;=<code>max</code>
     */
    public void notifyProgress(ITask task, int step) {
        notifyProgress(task, NO_SUBTASK, step, -1);
    }

    /**
     * Notifies about processing a task or a subtask. 
     * 
     * @param task the identification of the task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param subtask the identification of the subtask (may be {@link #NO_SUBTASK}, initially 
     *   use {@link #registerSubtask(String)} for registering a sub task)
     * @param step the current step in 0&lt;=<code>step</code>&lt;=<code>max</code>
     */
    public void notifyProgress(ITask task, ISubtask subtask, int step) {
        notifyProgress(task, subtask, step, -1);
    }

    /**
     * Notifies about processing a task or a subtask. 
     * 
     * @param task the identification of the task to notify about (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param subtask the identification of the subtask (may be {@link #NO_SUBTASK}, initially 
     *   use {@link #registerSubtask(String)} for registering a sub task)
     * @param step the current step in 0&lt;=<code>step</code>&lt;=<code>max</code>
     * @param max the maximum number of steps, ignored if negative and value from
     *   start notification is used instead
     */
    public abstract void notifyProgress(ITask task, ISubtask subtask, int step, int max);

    /**
     * Notifies about ending a (sub)task. Subtask notifications shall occur
     * before task notifications, i.e. correctly nested. Use the identifications
     * returned by {@link #registerTask(String)} and {@link #registerSubtask(String)}.
     * This method shall implicitly unregister the given task and/or subtask.
     * 
     * @param task the identification of the task which ends (initially 
     *   use {@link #registerTask(String)} for registering a task)
     */
    public void notifyEnd(ITask task) {
        notifyEnd(task, NO_SUBTASK);
    }

    /**
     * Notifies about ending a (sub)task. Subtask notifications shall occur
     * before task notifications, i.e. correctly nested. Use the identifications
     * returned by {@link #registerTask(String)} and {@link #registerSubtask(String)}.
     * This method shall implicitly unregister the given task and/or subtask.
     * 
     * @param task the identification of the task which ends (initially 
     *   use {@link #registerTask(String)} for registering a task)
     * @param subtask the identification of the subtask with <code>task</code>
     *   (may be <{@link #NO_SUBTASK}, if given, only the subtask is supposed to end, initially 
     *   use {@link #registerSubtask(String)} for registering a sub task)
     */
    public abstract void notifyEnd(ITask task, ISubtask subtask);

}
