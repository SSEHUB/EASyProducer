package net.ssehub.easy.producer.eclipse.observer;

import org.eclipse.core.runtime.NullProgressMonitor;

import net.ssehub.easy.basics.progress.BasicProgressObserver;

/**
 * Observes the progress of a longer lasting task for the eclipse ui.
 * 
 * @author Holger Eichelberger
 */
public class EclipseProgressObserver extends BasicProgressObserver {

    private MyProgressMonitor monitor;
    
    /**
     * Wraps the eclipse progress monitor to the basic progress observer interface.
     * 
     * @author Holger Eichelberger
     */
    private static class MyProgressMonitor 
        implements net.ssehub.easy.basics.progress.BasicProgressObserver.IProgressMonitor {
        
        private org.eclipse.core.runtime.IProgressMonitor monitor;
        
        /**
         * Creates a wrapping instance.
         * 
         * @param monitor the eclipse monitor instance
         */
        private MyProgressMonitor(org.eclipse.core.runtime.IProgressMonitor monitor) {
            this.monitor = monitor;
        }
        
        /**
         * Returns the monitor instance.
         * 
         * @return the instance
         */
        private org.eclipse.core.runtime.IProgressMonitor getMonitor() {
            return monitor;
        }

        @Override
        public void setTaskName(String name) {
            monitor.setTaskName(name);
        }

        @Override
        public void beginTask(String name, int max) {
            monitor.beginTask(name, max);
        }

        @Override
        public void worked(int step) {
            monitor.worked(step);
        }

        @Override
        public void subTask(String name) {
            monitor.subTask(name);
        } 
        
    }

    /**
     * Sets the monitor to this progress observer. <br>
     * Overwrites already set monitors.
     * @param monitor The monitor which should be added to this observer.
     */
    public void register(org.eclipse.core.runtime.IProgressMonitor monitor) {
        this.monitor = new MyProgressMonitor(monitor);
        super.register(this.monitor);
    }

    /**
     * Sets this monitor to <code>null</code> if the current monitor is the same as the specified monitor.
     * @param monitor If the given monitor is the same monitor as the monitor of this observer instance
     * the monitor of this observer will be set to <code>null</code> otherwise will nothing happen.
     */
    public void unregister(org.eclipse.core.runtime.IProgressMonitor monitor) {
        if (null != this.monitor && this.monitor.getMonitor() == monitor) {
            super.unregister(this.monitor);
            this.monitor = null;
        }
    }

    /**
     * Returns the internal eclipse progress monitor if registered.
     * 
     * @return the monitor or {@link NullProgressMonitor}
     */
    public org.eclipse.core.runtime.IProgressMonitor getMonitor() {
        org.eclipse.core.runtime.IProgressMonitor result = null;
        if (null != this.monitor) {
            result = this.monitor.getMonitor();
        }
        if (null == result) {
            result = new NullProgressMonitor();
        }
        return result;
    }

}
