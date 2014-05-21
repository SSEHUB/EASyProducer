package de.uni_hildesheim.sse.easy.ui.internal;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.uni_hildesheim.sse.easy.ui.project_management.ProjectUtils;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.InvalidProjectnameException;

/**
 * Toggles the EASY nature.
 * 
 * @author Holger Eichelberger
 */
public class ToggleEASyNatureAction implements IObjectActionDelegate {

    private Shell shell;
    private ISelection selection;

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = selection;
    }

    @Override
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        shell = targetPart.getSite().getShell();
    }
    
    @Override
    public void run(IAction action) {
        if (selection instanceof IStructuredSelection) {
            StringBuilder errors = new StringBuilder();
            for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
                Object element = it.next();
                IProject project = null;
                if (element instanceof IProject) {
                    project = (IProject) element;
                } else if (element instanceof IAdaptable) {
                    project = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
                }
                if (project != null) {
                    try {
                        ProjectUtils.toggleNature(project);
                    } catch (IOException e) {
                        if (errors.length() > 0) {
                            errors.append(", ");
                        }
                        errors.append(e.getMessage());
                    } catch (InvalidProjectnameException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
            if (errors.length() > 0) {
                MessageDialog.openError(shell, "Error while modifying natures", errors.toString());
            }
        }
    }

}
