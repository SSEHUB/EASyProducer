package de.uni_hildesheim.sse.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

public class EclipseProgressObserver extends ProgressObserver {
	
	private IProgressMonitor monitor;
	private Task parent;
	private List<Task> subtasks = new ArrayList<Task>();
	
	private static class Task implements ITask, ISubtask {
		
		private String name;
		private int max;
		private int current;
		
		public Task(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setMax(int max) {
			if (max > 0) {
				this.max = max;
			}
		}
		
		public int setCurrent(int current) {
			int result = current - this.current;
			this.current = current;
			return result;
		}
		
		public int getRemainder() {
			return max - current;
		}
		
	}
	
	public void register(IProgressMonitor monitor) {
		this.monitor = monitor;
	}
	
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
			if (pos > 0) {
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
		if (NO_SUBTASK == subtask) {
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
