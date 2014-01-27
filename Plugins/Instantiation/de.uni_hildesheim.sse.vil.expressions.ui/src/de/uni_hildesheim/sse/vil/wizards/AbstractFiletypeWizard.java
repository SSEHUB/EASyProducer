package de.uni_hildesheim.sse.vil.wizards;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.core.runtime.*;
import org.eclipse.jface.operation.*;
import java.lang.reflect.InvocationTargetException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.CoreException;
import java.io.*;
import org.eclipse.ui.*;
import org.eclipse.ui.ide.IDE;

/**
 * This is the common super class for wizards creating new variability definition/realization files.
 * 
 * @author El-Sharkawy
 */

public abstract class AbstractFiletypeWizard extends Wizard implements INewWizard {
    
    protected static final String LINEFEED = "\r\n";
    private AbstractFiletypeWizardPage page;
    private IWizardPageFactory pageCreator;
    private ISelection selection;
    private String pluginID;

    /**
     * Constructor for FiletypeWizard.
     * @param pageCreator A Factory for creating the individual page/content of the wizard.
     * @param pluginID The ID of the plug-in, where the concrete wizard is created (needed for error messages).
     */
    public AbstractFiletypeWizard(IWizardPageFactory pageCreator, String pluginID) {
        super();
        this.pageCreator = pageCreator;
        this.pluginID = pluginID;
        setNeedsProgressMonitor(true);
    }

    @Override
    public void addPages() {
        page = pageCreator.createPage(selection);
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        final String containerName = page.getContainerName();
        final String fileName = page.getFileName();
        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(IProgressMonitor monitor) throws InvocationTargetException {
                try {
                    doFinish(containerName, fileName, monitor);
                } catch (CoreException e) {
                    throw new InvocationTargetException(e);
                } finally {
                    monitor.done();
                }
            }
        };
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            return false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            return false;
        }
        return true;
    }

    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     */
    private void doFinish(String containerName, String fileName, IProgressMonitor monitor) throws CoreException {
        // create a sample file
        monitor.beginTask("Creating " + fileName, 2);
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IResource resource = root.findMember(new Path(containerName));
        if (!resource.exists() || !(resource instanceof IContainer)) {
            throwCoreException("Container \"" + containerName + "\" does not exist.");
        }
        // call this method to construct the initial project name based on the
        // file name
        IContainer container = (IContainer) resource;
        final IFile file = container.getFile(new Path(fileName));
        try {
            InputStream stream = openContentStream(constructInitialProjectName(fileName));
            if (file.exists()) {
                file.setContents(stream, true, true, monitor);
            } else {
                file.create(stream, true, monitor);
            }
            stream.close();
        } catch (IOException e) {
        }
        monitor.worked(1);
        monitor.setTaskName("Opening file for editing...");
        getShell().getDisplay().asyncExec(new Runnable() {
            public void run() {
                IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
                try {
                    IDE.openEditor(page, file, true);
                } catch (PartInitException e) {
                }
            }
        });
        monitor.worked(1);
    }

    /**
     * We will initialize file contents.
     * @param fileName the name of the file without the extension.
     */
    protected abstract InputStream openContentStream(String fileName);
    
    /**
     * Creates a core exception.
     * @param message
     * @throws CoreException
     */
    private void throwCoreException(String message) throws CoreException {
        IStatus status = new Status(IStatus.ERROR, pluginID, IStatus.OK, message, null);
        throw new CoreException(status);
    }

    @Override
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        this.selection = selection;
    }

    /**
     * Returns the file name without the file extension.
     * Needed for the {@link #openContentStream(String)} method.
     * @param filename The contents of the current file name dialog.
     * @return The file name without the file extension.
     */
    private String constructInitialProjectName(String filename) {
        return filename.split(pageCreator.getFileExtension())[0];
    }
}