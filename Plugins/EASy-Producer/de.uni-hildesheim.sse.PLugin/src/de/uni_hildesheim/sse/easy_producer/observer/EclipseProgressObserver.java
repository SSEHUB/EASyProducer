package de.uni_hildesheim.sse.easy_producer.observer;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Observes the progress of a longer lasting task for the eclipse ui.
 * 
 * @author Holger Eichelberger
 */
public class EclipseProgressObserver extends ProgressObserver {

    private IProgressMonitor monitor;
    private Task parent;
    private List<Task> subtasks = new ArrayList<Task>();

    /**
     * Rerpesentation of a task, which will be observed by the {@link EclipseProgressObserver}.
     * @author Holger Eichelberger
     *
     */
    private static class Task implements ITask, ISubtask {

        private String name;
        private int max;
        private int current;

        /**
         * Sole constructor of this class.
         * @param name The name of the task which should be created.
         */
        public Task(String name) {
            this.name = name;
        }

        /**
         * Getter for the name.
         * @return The name of this task.
         */
        public String getName() {
            return name;
        }

        /**
         * Setter for the maximum of the task.
         * @param max An integer value greater than 0.
         */
        public void setMax(int max) {
            if (max > 0) {
                this.max = max;
            }
        }

        /**
         * Sets the current progress of the current task.
         * @param current The  number of already completed steps.
         * @return How many steps are still open to fulfill the current task.
         * @see #getRemainder()
         */
        public int setCurrent(int current) {
            int result = current - this.current;
            this.current = current;
            return result;
        }

        /**
         * Returns the progress of the current task.
         * @return How many steps are still open to fulfill the current task.
         */
        public int getRemainder() {
            return max - current;
        }

    }

    /**
     * Sets the monitor to this progress observer. <br>
     * Overwrites already set monitors.
     * @param monitor The monitor which should be added to this observer.
     */
    public void register(IProgressMonitor monitor) {
        this.monitor = monitor;
    }

    /**
     * Sets this monitor to <tt>null</tt> if the current monitor is the same as the specified monitor.
     * @param monitor If the given monitor is the same monitor as the monitor of this observer instance
     * the monitor of this observer will be set to <tt>null</tt> otherwise will nothing happen.
     */
    public void unregister(IProgressMonitor monitor) {
        if (this.monitor == monitor) {
            this.monitor = null;
        }
    }

    @Override
    public ITask registerTask(String task) {
        if (null == parent) {
            parent = new Task(task);
            return parent;
        } else {
            throw new IllegalArgumentException("only one task supported");
        }
    }

    @Override
    public ISubtask registerSubtask(String subtask) {
        Task result = new Task(subtask);
        subtasks.add(result);
        return result;
    }

    @Override
    public void notifyStart(ITask task, ISubtask subtask, int max) {
        if (NO_SUBTASK == subtask) {
            if (null == parent) {
                throw new IllegalArgumentException("no task registered");
            }
            if (parent.equals(task)) {
                monitor.setTaskName(parent.getName());
                parent.setMax(max);
                monitor.beginTask(parent.getName(), max);
            } else {
                throw new IllegalArgumentException("task not registered");
            }
        } else {
            int pos = subtasks.indexOf(subtask);
            if (pos >= 0) {
                Task t = subtasks.get(pos);
                t.setMax(max);
                monitor.subTask(t.getName());
            } else {
                throw new IllegalArgumentException("subtask not registered");
            }
        }
    }

    @Override
    public void notifyProgress(ITask task, ISubtask subtask, int step, int max) {
        if (NO_SUBTASK == subtask || null == subtask) {
            if (null == parent) {
                throw new IllegalArgumentException("no task registered");
            }
            if (parent.equals(task)) {
                if (max > 0) {
                    parent.setMax(max);
                }
                monitor.worked(parent.setCurrent(step));
            } else {
                throw new IllegalArgumentException("task not registered");
            }
        }
        // subtasks are not displayed
    }

    @Override
    public void notifyEnd(ITask task, ISubtask subtask) {
        if (NO_SUBTASK == subtask) {
            if (null == parent) {
                throw new IllegalArgumentException("no task registered");
            }
            if (parent.equals(task)) {
                monitor.worked(parent.getRemainder());
                parent = null;
            }
        } else {
            if (subtasks.contains(subtask)) {
                if (null == parent) {
                    throw new IllegalArgumentException("no task registered");
                }
                monitor.setTaskName(parent.getName());
                subtasks.remove(subtask);
            } else {
                throw new IllegalArgumentException("task not registered");
            }
        }
    }

}
