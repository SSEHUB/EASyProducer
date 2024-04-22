/*
ex * Copyright 2009-2020 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.basics.progress;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic, eclipse-like progress observer.
 * 
 * @author Holger Eichelberger
 */
public class BasicProgressObserver extends ProgressObserver {

    private IProgressMonitor monitor;
    private Task parent;
    private List<Task> subtasks = new ArrayList<Task>();

    /**
     * Representation of a task, which will be observed by the {@link IProgressMonitor}.
     * 
     * @author Holger Eichelberger
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
         */
        public int setCurrent(int current) {
            int result = current - this.current;
            this.current = current;
            return result;
        }

    }
    
    /**
     * Simple progress monitor interface.
     * 
     * @author Holger Eichelberger
     */
    public interface IProgressMonitor {

        /**
         * Sets the name of the current main task.
         * 
         * @param name the name
         */
        public void setTaskName(String name);
        
        /**
         * Begins the task with the given name.
         * 
         * @param name the name
         * @param max the maximum number of steps
         */
        public void beginTask(String name, int max);

        /**
         * Informs that the given step within the maximum number of steps of the actual task
         * has been completed.
         * 
         * @param step the step number
         */
        public void worked(int step);

        /**
         * Informs about executing a sub-task.
         * 
         * @param name the name of the sub-task
         */
        public void subTask(String name);
        
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
     * Sets this monitor to <b>null</b> if the current monitor is the same as the specified monitor.
     * @param monitor If the given monitor is the same monitor as the monitor of this observer instance
     * the monitor of this observer will be set to <b>null</b> otherwise will nothing happen.
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
        }
        return parent;
    }

    @Override
    public ISubtask registerSubtask(String subtask) {
        Task result = new Task(subtask);
        subtasks.add(result);
        monitor.subTask(subtask);
        return result;
    }

    @Override
    public void notifyStart(ITask task, ISubtask subtask, int max) {
        if (NO_SUBTASK == subtask) {
            if (null != parent && parent.equals(task)) {
                monitor.setTaskName(parent.getName());
                parent.setMax(max);
                monitor.beginTask(parent.getName(), max);
            }
        } else {
            int pos = subtasks.indexOf(subtask);
            if (pos >= 0) {
                Task t = subtasks.get(pos);
                t.setMax(max);
                monitor.subTask(t.getName());
            }
        }
    }

    @Override
    public void notifyProgress(ITask task, ISubtask subtask, int step, int max) {
        if (NO_SUBTASK == subtask || null == subtask) {
            if (null != parent && parent.equals(task)) {
                if (max > 0 && max != parent.max) {
                    parent.setMax(max);
                    monitor.beginTask(null, max);
                }
                parent.setCurrent(step);
                monitor.worked(step);
            }
        }
        // subtasks are not displayed
    }

    @Override
    public void notifyEnd(ITask task, ISubtask subtask) {
        if (NO_SUBTASK == subtask) {
            if (null != parent && parent.equals(task)) {
                monitor.worked(parent.max);
                parent = null;
            }
        } else {
            if (subtasks.contains(subtask)) {
                if (null != parent) {
                    monitor.setTaskName(parent.getName());
                }
                subtasks.remove(subtask);
            }
        }
    }


}
