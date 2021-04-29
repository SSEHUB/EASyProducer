package net.ssehub.easy.producer.ui.application;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;

/**
 * This class controls all aspects of the application's execution.
 * 
 * @author Holger Eichelberger
 */
public class Application implements IApplication {

    @Override
    public Object start(IApplicationContext context) {
        ResourcesMgmt.INSTANCE.enableBackgroundTasks(false);
        Display display = PlatformUI.createDisplay();
     // Commented out due to issues with new Eclipse and Java 64bit
//        P2Utils.ensureUpdateURI();
        try {
            Object toReturn = null;
            int returnCode = PlatformUI.createAndRunWorkbench(display, new ApplicationWorkbenchAdvisor());
            if (returnCode == PlatformUI.RETURN_RESTART) {
                saveWorkspace();
                toReturn = IApplication.EXIT_RESTART;
            } else {
                saveWorkspace();
                toReturn = IApplication.EXIT_OK;
            }
            return toReturn;
        } finally {
            display.dispose();
        }
    }
    
    /**
     * Saves the workspace before quitting the application.
     */
    private void saveWorkspace() {
        try {
            // save the full workspace before quit
            ResourcesPlugin.getWorkspace().save(true, new NullProgressMonitor());
        } catch (final CoreException e) {
            EASyLoggerFactory.INSTANCE.getLogger(this.getClass(), Bundle.ID).exception(e);
            // Can we use Dialogs here or is it to early?
//            Dialogs.showErrorDialog("While saving the workspace", e.getMessage());
        }
    }

    @Override
    public void stop() {
        if (!PlatformUI.isWorkbenchRunning()) {
            return;
        }

        final IWorkbench workbench = PlatformUI.getWorkbench();
        final Display display = workbench.getDisplay();
        display.syncExec(new Runnable() {

            public void run() {

                if (!display.isDisposed()) {
                    workbench.close();
                }
            }
        });
    }

}
