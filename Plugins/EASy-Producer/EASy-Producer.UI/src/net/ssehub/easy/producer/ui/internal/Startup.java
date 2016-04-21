package net.ssehub.easy.producer.ui.internal;

import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
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
                // I would expect the following line to be part of the startup of EASy core
                EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(Startup.class,
                    "de.uni_hildesheim.sse.easy.ui");
                logger.info("EASy-Producer 2.0 is up and running...");
                ResourcesMgmt.INSTANCE.findPLProjects();
            }
        });
        // Register the observer for sending messages to the console of the running Eclipse-instance.
        TracerFactory.setDefaultInstance(GuiTracerFactory.INSTANCE);
    }
}
