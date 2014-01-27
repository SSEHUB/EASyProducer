package de.uni_hildesheim.sse.easy.ui.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.easy.ui.productline_editor.ProductLineEditorInput;
import de.uni_hildesheim.sse.easy_producer.ProjectConstants;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;

/**
 * EASy contribution for the context menu of eclipse's package explorer.
 * This class is needed to open the product line editor via the context menu.
 *
 */
@SuppressWarnings("rawtypes")
public class EditProductLineAction implements IObjectActionDelegate {

    @SuppressWarnings("unused")
    private Shell shell;
    private IStructuredSelection selection;
    private IProject selectedProject;

    /**
     * Constructor for Action1.
     */
    public EditProductLineAction() {
        super();
    }

    @Override
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        shell = targetPart.getSite().getShell();

    }

    @Override
    public void run(IAction action) {

        // Get the config.xml and open it in the ProductLineEditor
        IFile configfile = selectedProject.getFile(ProjectConstants.EASY_FILES + ResourcesMgmt.INSTANCE.getSeperator()
            + PersistenceConstants.CONFIG_FILE);
        String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(configfile);
        PLPInfo plp = SPLsManager.INSTANCE.getPLP(projectID);
        IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
        IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry()
                .findEditor("de.uni_hildesheim.sse.easy_producer.ProductLineConfigurationEditor.new");
        try {
            page.openEditor(new ProductLineEditorInput((ProductLineProject) plp), desc.getId());
        } catch (PartInitException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        this.selection = (IStructuredSelection) selection;
        this.selectedProject = this.getProject();
    }

    /**
     * Returns adaptable objects for the selected objects of the selection.
     * @param selection Selected resources for which the adapter should be retrieved
     * @param clazz the comparing class
     * @return The selected objects
     * @see #getAdapter(Object, Class)
     */
    @SuppressWarnings("unchecked")
    private static Object[] getSelectedAdaptables(ISelection selection, Class clazz) {
        ArrayList result = null;
        Object[] resultingArray = null;
        if (!selection.isEmpty()) {
            result = new ArrayList();
            Iterator elements = ((IStructuredSelection) selection).iterator();
            while (elements.hasNext()) {
                Object adapter = getAdapter(elements.next(), clazz);
                if (clazz.isInstance(adapter)) {
                    result.add(adapter);
                }
            }
        }
        if (result != null && !result.isEmpty()) {
            resultingArray = result.toArray((Object[]) Array.newInstance(clazz, result.size()));
        } else {
            resultingArray = (Object[]) Array.newInstance(clazz, 0);
        }
        return resultingArray;
    }

    /**
     * Returns an adaptable object or <tt>null</tt> if the Object adaptable is neither an instance of the Class
     * <tt>clazz</tt> nor an instance of IAdaptable.
     * 
     * @param adaptable the object in queston
     * @param clazz the comparing class
     * @return An adaptable object or null if the Object adaptable is neither an instance of the Class c nor an instance
     *         of IAdaptable
     */
    public static Object getAdapter(Object adaptable, Class clazz) {
        Object result = null;
        if (clazz.isInstance(adaptable)) {
            result = adaptable;
        }
        if (null == result && adaptable instanceof IAdaptable) {
            IAdaptable a = (IAdaptable) adaptable;
            Object adapter = a.getAdapter(clazz);
            if (clazz.isInstance(adapter)) {
                result = adapter;
            }
        }
        return result;
    }

    /**
     * Returns the selected Project.
     * @return The selected project
     */
    private IProject getProject() {
        IResource[] rs = (IResource[]) getSelectedAdaptables((IStructuredSelection) selection, IResource.class);
        IProject project = null;
        for (int i = 0; i < rs.length; i++) {
            IResource r = rs[i];
            if (r.getType() == IResource.PROJECT) {
                project = (IProject) r;
                break;
            }
        }
        return project;
    }

}
