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

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        ISelectionService selectionService = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        ISelection selection = selectionService.getSelection();
        if (selection instanceof IStructuredSelection) {    
            Object firstElement = ((IStructuredSelection) selection).getFirstElement();   
            if (firstElement instanceof IAdaptable) {
                IProject selectedProject = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
                IFile configfile = EASyUtils.findEasyConfig(selectedProject);
                String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(configfile, null);
                PLPInfo plp = SPLsManager.INSTANCE.getPLP(projectID);
                if (null != plp) {
                    execute(event, selectedProject, (ProductLineProject) plp);
                } else {
                    Shell shell = HandlerUtil.getActiveShell(event);
                    MessageDialog.openWarning(shell, "No PLP project", 
                        "Cannot perform operation as project is no EASy-Producer PLP project."); 
                }
            }
        }
        return null;
    }

    /**
     * Executes the command on the selected {@link project}.
     * 
     * @param event the causing event
     * @param project the selected project
     * @param plp the selected product line project
     * @throws ExecutionException if the execution fails for some reason
     */
    protected abstract void execute(ExecutionEvent event, IProject project, ProductLineProject plp) 
        throws ExecutionException;

}
