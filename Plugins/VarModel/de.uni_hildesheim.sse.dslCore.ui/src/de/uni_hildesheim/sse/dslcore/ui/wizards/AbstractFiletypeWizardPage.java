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
package de.uni_hildesheim.sse.dslcore.ui.wizards;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;

/**
 * The "New" wizard page allows setting the container for the new file as well
 * as the file name. The page will only accept file name without the extension
 * OR with the correct file extension (cf. {@link IWizardPageDescriptor#getFileExtension()}).
 * @author El-Sharkawy
 */
public class AbstractFiletypeWizardPage extends WizardPage {
    private Text containerText;

    private Text fileText;

    private ISelection selection;
    private IWizardPageDescriptor descriptor;

    /**
     * Constructor for NewWizardPage's.
     * 
     * @param selection The current object selection, as specified at 
     * {@link org.eclipse.ui.IWorkbenchWizard
     * #init(org.eclipse.ui.IWorkbench, org.eclipse.jface.viewers.IStructuredSelection)}.
     * @param descriptor Configuration of the editor (file extension, image, description, contents to create, ...)
     */
    public AbstractFiletypeWizardPage(ISelection selection, IWizardPageDescriptor descriptor) {
        super("wizardPage", descriptor.getTitle(), descriptor.getImageDescriptor());
        setDescription(descriptor.getDescription());
        this.selection = selection;
        this.descriptor = descriptor;
    }

    /**
     * Creates the top level control for this dialog
     * page under the given parent composite.
     * <p>
     * Implementors are responsible for ensuring that
     * the created control can be accessed via <code>getControl</code>
     * </p>
     * @param parent the parent composite
     * @see IDialogPage#createControl(Composite)
     */
    public void createControl(Composite parent) {
        Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 3;
        layout.verticalSpacing = 9;
        Label label = new Label(container, SWT.NULL);
        label.setText("&Container:");

        containerText = new Text(container, SWT.BORDER | SWT.SINGLE);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        containerText.setLayoutData(gd);
        containerText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent exc) {
                dialogChanged();
            }
        });

        Button button = new Button(container, SWT.PUSH);
        button.setText("Browse...");
        button.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent exc) {
                handleBrowse();
            }
        });
        label = new Label(container, SWT.NULL);
        label.setText("&File name:");

        fileText = new Text(container, SWT.BORDER | SWT.SINGLE);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fileText.setLayoutData(gd);
        fileText.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent exc) {
                dialogChanged();
            }
        });
        initialize();
        dialogChanged();
        setControl(container);
    }

    /**
     * Tests if the current workbench selection is a suitable container to use.
     */

    private void initialize() {
        if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            IStructuredSelection ssel = (IStructuredSelection) selection;
            if (ssel.size() > 1) {
                return;
            }
            Object obj = ssel.getFirstElement();
            if (null != obj && !(obj instanceof IResource)) {
                // this works for IJavaProjects, but do not explicitly introduce a dependency to JDT here
                try {
                    Method meth = obj.getClass().getMethod("getProject", (Class<?>[]) null);
                    if (meth.getReturnType() == IProject.class) {
                        try {
                            obj = meth.invoke(obj, (Object[]) null);
                        } catch (InvocationTargetException e) {
                            // don't care - just no selection in GUI ;)
                        } catch (SecurityException e) {
                            // don't care - just no selection in GUI ;)
                        } catch (IllegalAccessException e) {
                            // don't care - just no selection in GUI ;)                            
                        }
                    }
                } catch (NoSuchMethodException e) {
                    //TODO log this message
                }
            }
            if (obj instanceof IResource) {
                IContainer container;
                if (obj instanceof IContainer) {
                    container = (IContainer) obj;
                } else {
                    container = ((IResource) obj).getParent();
                }
                containerText.setText(container.getFullPath().toString());
            }
        }
        fileText.setText(descriptor.getDefaultFileName());
    }

    /**
     * Uses the standard container selection dialog to choose the new value for
     * the container field.
     */

    private void handleBrowse() {
        ContainerSelectionDialog dialog = new ContainerSelectionDialog(getShell(), ResourcesPlugin.getWorkspace()
                        .getRoot(), false, "Select new file container");
        if (dialog.open() == ContainerSelectionDialog.OK) {
            Object[] result = dialog.getResult();
            if (result.length == 1) {
                containerText.setText(((Path) result[0]).toString());
            }
        }
    }

    /**
     * Ensures that both text fields are set.
     */

    private void dialogChanged() {
        IResource container = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(getContainerName()));
        String fileName = getFileName();

        if (getContainerName().length() == 0) {
            updateStatus("File container must be specified");
            return;
        }
        if (container == null || (container.getType() & (IResource.PROJECT | IResource.FOLDER)) == 0) {
            updateStatus("File container must exist");
            return;
        }
        if (!container.isAccessible()) {
            updateStatus("Project must be writable");
            return;
        }
        if (fileName.length() == 0) {
            updateStatus("File name must be specified");
            return;
        }
        if (fileName.replace('\\', '/').indexOf('/', 1) > 0) {
            updateStatus("File name must be valid");
            return;
        }
        int dotLoc = fileName.lastIndexOf('.');
        if (dotLoc != -1) {
            String ext = fileName.substring(dotLoc + 1);
            if (!ext.equalsIgnoreCase(descriptor.getFileExtension())) {
                updateStatus("File extension must be \"" + descriptor.getFileExtension() + "\"");
                return;
            }
        }
        updateStatus(null);
    }

    /**
     * Displays/Removes errors.
     * @param message An error message to display to the user, or <tt>null</tt> to delete it.
     */
    private void updateStatus(String message) {
        setErrorMessage(message);
        setPageComplete(message == null);
    }

    /**
     * The currently path/folder of the file to create.
     * @return The path/folder of the file to be create (maybe <tt>null</tt>).
     */
    public String getContainerName() {
        return containerText.getText();
    }

    /**
     * Returns the name of the file to create (including its file extension).
     * @return The name of the file to create (maybe <tt>null</tt>).
     */
    public String getFileName() {
        return fileText.getText();
    }
}