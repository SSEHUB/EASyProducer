/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.ui.productline_editor.commands;

import java.util.function.Supplier;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.eclipse.EASyUtils;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;

/**
 * An abstract PLP command handler.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractPlpHandler extends AbstractHandler {

    /**
     * Denotes a selected PLP.
     * 
     * @author Holger Eichelberger
     */
    protected static class SelectedPLP {
        private PLPInfo plp;
        private IProject project;
        
        /**
         * Creates an instance.
         * 
         * @param plp the PLP, may be <b>null</b> for the selected project is an Eclipse, but not a PLP project
         * @param project the selected project, shall not be <b>null</b>
         */
        protected SelectedPLP(PLPInfo plp, IProject project) {
            this.plp = plp;
            this.project = project;
        }
        
        /**
         * Returns the PLP.
         * 
         * @return the PLP, may be <b>null</b> for the selected project is an Eclipse, but not a PLP project
         */
        public PLPInfo getPLP() {
            return plp;
        }

        /**
         * Returns the selected project.
         * 
         * @return the selected project, shall not be <b>null</b>
         */
        public IProject getProject() {
            return project;
        }

    }
    
    /**
     * Returns the PLPInfo of the current active workbench window selection.
     * 
     * @return the selection, potentially with {@link SelectedPLP#getPLP()} being <b>null</b> if the the selected 
     *     project is not an EASy-Project or the entire result being <b>null</b> if there is no selection, the selected 
     */
    protected static SelectedPLP getPLPInfo() {
        SelectedPLP result = null;
        ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ISelection selection = selectionService.getSelection();
        if (selection instanceof IStructuredSelection) {    
            Object firstElement = ((IStructuredSelection) selection).getFirstElement();   
            if (firstElement instanceof IAdaptable) {
                IProject selectedProject = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
                IFile configfile = EASyUtils.findEasyConfig(selectedProject);
                String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(configfile, null);
                PLPInfo plp = SPLsManager.INSTANCE.getPLP(projectID);
                result = new SelectedPLP(plp, selectedProject);
            }
        }
        return result;
    }
    
    /**
     * Returns the EASy config file of the current active workbench window selection.
     * 
     * @return the selection being <b>null</b> if there is no selection or no EASy project
     */
    protected static IFile getEasyConfigFile() {
        IFile configfile = null;
        ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ISelection selection = selectionService.getSelection();
        if (selection instanceof IStructuredSelection) {    
            Object firstElement = ((IStructuredSelection) selection).getFirstElement();   
            if (firstElement instanceof IAdaptable) {
                IProject selectedProject = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
                configfile = EASyUtils.findEasyConfig(selectedProject);
            }
        }
        return configfile;
    }    
    
    /**
     * Shows a warning dialog if there is no selectedPLP and {@code shellSupplier} is given.
     * 
     * @param selected the selected PLP with PLP/project information, may be <b>null</b> or contained PLP may be 
     *   <b>null</b> for warning dialog
     * @param shellSupplier function to provide a shell, may be <b>null</b> for not opening a dialog
     */
    protected static void showNoPLPWarning(SelectedPLP selected, Supplier<Shell> shellSupplier) {
        if ((null == selected || selected.getPLP() == null) && null != shellSupplier) {
            MessageDialog.openWarning(shellSupplier.get(), "No PLP project", 
                "Cannot perform operation as project is no EASy-Producer PLP project."); 
        }
    }
    
    protected static boolean isPLP(SelectedPLP selected) {
        return (null != selected && selected.getPLP() != null);
    }
    
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        SelectedPLP selected = getPLPInfo();
        if (isPLP(selected)) {
            execute(event, selected.getProject(), (ProductLineProject) selected.getPLP());
        } else {
            showNoPLPWarning(selected, () -> HandlerUtil.getActiveShell(event));
        }
        return null;
    }
    
    @Override
    public boolean isEnabled() {
        return isPLP(getPLPInfo()) && isAbstractHandlerEnabled();
    }
    
    /**
     * Returns whether the parent {@link AbstractHandler} would be enabled.
     * 
     * @return {@code true} for enabled, {@code false} else
     */
    protected boolean isAbstractHandlerEnabled() {
        return super.isEnabled();
    }

    /**
     * Executes the command on the selected {@code project}.
     * 
     * @param event the causing event
     * @param project the selected project
     * @param plp the selected product line project
     * @throws ExecutionException if the execution fails for some reason
     */
    protected abstract void execute(ExecutionEvent event, IProject project, ProductLineProject plp) 
        throws ExecutionException;

}
