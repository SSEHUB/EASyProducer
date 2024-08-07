package de.uni_hildesheim.sse.ui;

import net.ssehub.easy.basics.progress.BasicProgressObserver;

/**
 * Wrapping eclipse progress observer.
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
     * Sets this monitor to <b>null</b> if the current monitor is the same as the specified monitor.
     * @param monitor If the given monitor is the same monitor as the monitor of this observer instance
     * the monitor of this observer will be set to <b>null</b> otherwise will nothing happen.
     */
    public void unregister(org.eclipse.core.runtime.IProgressMonitor monitor) {
        if (null != this.monitor && this.monitor.getMonitor() == monitor) {
            super.unregister(this.monitor);
            this.monitor = null;
        }
    }

}
