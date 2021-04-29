package net.ssehub.easy.producer.ui.application;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import net.ssehub.easy.producer.ui.internal.Activator;

/**
 * Public class for configuring the window of the Qualimaster-App.
 * 
 * @author Holger Eichelberger
 */
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

    /**
     * Calls super constructor thus sets the given
     * {@link IWorkbenchWindowConfigurer} for this application.
     * 
     * @param configurer
     *            The given {@link IWorkbenchWindowConfigurer}.
     */
    public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        super(configurer);
    }

    /**
     * Creates {@link ApplicationActionBarAdvisor} with given
     * {@link IActionBarConfigurer} configurer.
     * 
     * @param configurer
     *            Given {@link IActionBarConfigurer} configurer.
     * @return The {@link ApplicationActionBarAdvisor} for the given configurer.
     */
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        return new ApplicationActionBarAdvisor(configurer);
    }

    @Override
    public void preWindowOpen() {
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(600, 400));
        configurer.setShowCoolBar(false);
        configurer.setShowStatusLine(true);
        configurer.setTitle("EASy-Producer v" + Activator.getVersion());
    }

    @Override
    public void postWindowOpen() {
        getWindowConfigurer().getWindow().getShell().setMaximized(true);
        // Add QualiMaster-icon to the shell.
        getWindowConfigurer().getWindow().getShell().setImage(Activator.getImage(Activator.LOGO));
        getWindowConfigurer().getWindow().getShell().addShellListener(new ShellListener() {

            @Override
            public void shellIconified(ShellEvent event) {
            }

            @Override
            public void shellDeiconified(ShellEvent event) {
            }

            @Override
            public void shellDeactivated(ShellEvent event) {
            }

            @Override
            public void shellClosed(ShellEvent event) {
                IWorkspace ws = ResourcesPlugin.getWorkspace();
                try {
                    ws.save(true, new NullProgressMonitor());
                } catch (CoreException e) {
                    Dialogs.showErrorDialog("While saving the workspace", e.getMessage());
                }
            }

            @Override
            public void shellActivated(ShellEvent event) {
            }
        });
    }

    @Override
    public boolean preWindowShellClose() {
        try {
            // save the full workspace before quit
            ResourcesPlugin.getWorkspace().save(true, new NullProgressMonitor());
        } catch (final CoreException e) {
            Dialogs.showErrorDialog("While saving the workspace", e.getMessage());
        }
        return true;
    }

}
