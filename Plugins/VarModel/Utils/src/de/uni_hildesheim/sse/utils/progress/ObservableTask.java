package de.uni_hildesheim.sse.utils.progress;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver.ISubtask;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver.ITask;

/**
 * Combines observable and task/subtask for convenient use.
 * 
 * @author Holger Eichelberger
 */
public class ObservableTask {

    private ITask task;
    private ISubtask subtask = ProgressObserver.NO_SUBTASK;
    private ProgressObserver observer;
    private int count = 0;

    /**
     * Creates a new observable top-level task. Notifies the observer about starting the task.
     * @param name the name of the task
     * @param max the maximum steps
     * @param observer the observer
     */
    public ObservableTask(String name, int max, ProgressObserver observer) {
        this(name, max, observer, null);
    }

    /**
     * Creates a new observable (sub) task. Notifies the observer about starting the task.
     * 
     * @param name the name of the task
     * @param max the maximum steps
     * @param observer the observer
     * @param task the parent task (may be <b>null</b>)
     */
    public ObservableTask(String name, int max, ProgressObserver observer, ITask task) {
        if (null == task) {
            this.task = observer.registerTask(name);
            subtask = ProgressObserver.NO_SUBTASK;
        } else {
            this.task = task;
            subtask = observer.registerSubtask(name);
        }
        this.observer = observer;
        this.observer.notifyStart(this.task, subtask, max);
    }
    
    /**
     * Creates a new observable sub task. Notifies the observer about starting the task. 
     * @param name the name of the sub task
     * @param max the maximum steps
     * @param parent The parent task
     */
    public ObservableTask(String name, int max, ObservableTask parent) {
        this(name, max, parent.observer, parent.task);
    }
    
    /**
     * Notifies the observer about progressing on step.
     */
    public void notifyProgress() {
        notifyProgress(1);
    }

    /**
     * Notifies the observer about progressing multiple steps.
     * 
     * @param steps the progressed steps
     */
    public void notifyProgress(int steps) {
        count += steps;
        observer.notifyProgress(task, subtask, count);
    }

    /**
     * Notifies the observer about ending this (sub)task.
     */
    public void notifyEnd() {
        observer.notifyEnd(task, subtask);
    }

}
