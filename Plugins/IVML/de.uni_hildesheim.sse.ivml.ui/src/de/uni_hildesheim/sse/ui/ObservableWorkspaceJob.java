package de.uni_hildesheim.sse.ui;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

public abstract class ObservableWorkspaceJob extends WorkspaceJob {

	private EclipseProgressObserver observer;
	
	public ObservableWorkspaceJob(String name) {
		super(name);
		observer = new EclipseProgressObserver();
	}
	
	public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
		IStatus result;
		observer.register(monitor);
		result = doJob();
		observer.unregister(monitor);
		return result;
	}
	
	protected abstract IStatus doJob() throws CoreException;
	
	public EclipseProgressObserver getObserver() {
		return observer;
	}
	
}
