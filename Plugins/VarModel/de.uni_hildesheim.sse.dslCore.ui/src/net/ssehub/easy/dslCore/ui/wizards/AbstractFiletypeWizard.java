/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.dslCore.ui.wizards;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

/**
 * This is the common super class for wizards creating new variability definition/realization files.
 * 
 * @author El-Sharkawy
 */

public abstract class AbstractFiletypeWizard extends Wizard implements INewWizard {
    
    protected static final String LINEFEED = "\r\n";
    protected static final String INDENTION = "    ";
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
        
        boolean successful = true;
        try {
            getContainer().run(true, false, op);
        } catch (InterruptedException e) {
            successful = false;
        } catch (InvocationTargetException e) {
            Throwable realException = e.getTargetException();
            MessageDialog.openError(getShell(), "Error", realException.getMessage());
            successful = false;
        }
        return successful;
    }

    /**
     * The worker method. It will find the container, create the file if missing
     * or just replace its contents, and open the editor on the newly created
     * file.
     * @param containerName The path/folder of the file to be create.
     * @param fileName The file of to create inside the container.
     * @param monitor a progress monitor, must not be <tt>null</tt>.
     * @throws CoreException if this method fails. Reasons include:
     * <ul>
     * <li> This resource does not exist.</li>
     * <li> The corresponding location in the local file system
     *       is occupied by a directory.</li>
     * <li> The workspace is not in sync with the corresponding location
     *       in the local file system and <code>force </code> is <code>false</code>.</li>
     * <li> Resource changes are disallowed during certain types of resource change 
     *       event notification. See <code>IResourceChangeEvent</code> for more details.</li>
     * <li> The file modification validator disallowed the change.</li>
     * </ul>
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
     * @return the Contents to insert in the newly created file.
     */
    protected abstract InputStream openContentStream(String fileName);
    
    /**
     * Creates a core exception.
     * @param message a human-readable message
     * @throws CoreException The Exception which shall be created by this helper method.
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