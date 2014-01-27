package de.uni_hildesheim.sse.easy_producer.observer;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

/**
 * A job that makes an atomic modification to the workspace.
 * @author Holger Eichelberger
 *
 */
public abstract class ObservableWorkspaceJob extends WorkspaceJob {

    private EclipseProgressObserver observer;

    /**
     * Sole constructor for this class.
     * @param name The name of this WorkspaceJob
     */
    public ObservableWorkspaceJob(String name) {
        super(name);
        observer = new EclipseProgressObserver();
    }
    
    @Override
    public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
        IStatus result;
        observer.register(monitor);
        result = doJob();
        observer.unregister(monitor);
        return result;
    }

    /**
     * The method which should be performed.
     * @return A status object represents the outcome of an operation.
     * @throws CoreException Can be thrown in case of an eclipse based failure.
     */
    protected abstract IStatus doJob() throws CoreException;

    /**
     * Returns the observer of this WorkspaceJob.
     * @return The observer of this WorkspaceJob
     */
    public EclipseProgressObserver getObserver() {
        return observer;
    }

}
