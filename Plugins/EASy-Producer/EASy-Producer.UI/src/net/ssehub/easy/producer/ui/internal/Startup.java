package net.ssehub.easy.producer.ui.internal;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.producer.eclipse.observer.EclipseProgressObserver;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.producer.ui.core.instantiation.GuiTracerFactory;

/**
 * This class registers a startup mechanism for the plug-in, which enables the startup after the workbench was
 * initialized.
 * 
 * @author El-Sharkawy
 * 
 */
public class Startup implements IStartup {

    @Override
    public void earlyStartup() {
        IWorkbench workbench = PlatformUI.getWorkbench();
        workbench.getDisplay().syncExec(new Runnable() {
            public void run() {
                EclipseProgressObserver obs = new EclipseProgressObserver(); 
                // I would expect the following line to be part of the startup of EASy core
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(Startup.class,
                    "de.uni_hildesheim.sse.easy.ui");
                Activator.start();
                logger.info("Processing deferred VIL/VTL registrations ...");
                TypeRegistry.runDeferredRegistrations();
                logger.info("EASy-Producer is up and running...");
                Job job = new Job("EASy-Producer loading PL projects") {
                    
                    @Override
                    protected IStatus run(IProgressMonitor monitor) {
                        obs.register(monitor);
                        ResourcesMgmt.INSTANCE.findPLProjects(obs);
                        obs.unregister(monitor);
                        return Status.OK_STATUS;
                    }
                };
                job.schedule();
            }
        });
        // Register the observer for sending messages to the console of the running Eclipse-instance.
        TracerFactory.setDefaultInstance(GuiTracerFactory.INSTANCE);
    }
}
