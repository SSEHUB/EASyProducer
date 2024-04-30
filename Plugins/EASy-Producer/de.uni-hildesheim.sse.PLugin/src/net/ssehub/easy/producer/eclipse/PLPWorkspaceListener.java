package net.ssehub.easy.producer.eclipse;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.persistency.ResourcesMgmt;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.EASyNature;

/**
 * ChangeListener for the workspace, informs the SPLsManger,
 * if ProductLineProjects were added or remove to the workspace.
 * @author El-Sharkawy
 *
 */
public class PLPWorkspaceListener implements IResourceChangeListener {
    
    private static final Set<IProject> DISABLED = new HashSet<IProject>();
    private static final EASyLogger LOGGER
        = EASyLoggerFactory.INSTANCE.getLogger(PLPWorkspaceListener.class, Activator.PLUGIN_ID);
    private static PLPWorkspaceListener instance;
    
    /**
     * Sole constructor for this class.
     */
    private PLPWorkspaceListener() {
    }
    
    /**
     * Registers the default instance. Shall be called from an activator.
     */
    public static void register() {
        if (null == instance) {
            instance = new PLPWorkspaceListener();
            // Which event types should be observed
            int eventMask = IResourceChangeEvent.POST_CHANGE
                | IResourceChangeEvent.PRE_CLOSE
                | IResourceChangeEvent.PRE_DELETE;
            
            ResourcesPlugin.getWorkspace().addResourceChangeListener(instance, eventMask);
        }
    }

    /**
     * Unregisters the default instance.
     */
    public static void unregister() {
        if (null != instance) {
            ResourcesPlugin.getWorkspace().removeResourceChangeListener(instance);
            instance = null;
        }
    }

    /**
     * Disables the automatic background mechanisms for the given <code>project</code>. This provides a kind of
     * safe region.
     * 
     * @param project the project to disable the background mechanisms
     */
    public static void disableFor(IProject project) {
        DISABLED.add(project);
    }

    /**
     * Reenables the automatic background mechanisms for the given <code>project</code>. This provides a kind of
     * safe region.
     * 
     * @param project the project to reenable the background mechanisms
     */
    public static void reenableFor(IProject project) {
        DISABLED.remove(project);
    }
    
    @Override
    public void resourceChanged(IResourceChangeEvent event) {
        /* 
         * Determine whether an EASy project was opened/imported or closed/deleted
         * and adds/removes the embedded plp of the added/removed EASy project.
         */
        int eventType = event.getType();
        if (IResourceChangeEvent.PRE_CLOSE == eventType || IResourceChangeEvent.PRE_DELETE == eventType) {
            handleRemovedResource(event);            
        } else if (IResourceChangeEvent.POST_CHANGE == eventType) {
            handleOpenedResource(event);            
        }
    }

    /**
     * This method checks whether the  closed/deleted resource was an EASy project.
     * If the  closed/deleted resource was an EASy project, the included plp will be added to the {@link SPLsManager}.
     * @param preChangeEvent A <code>IResourceChangeEvent.PRE_CLOSE</code> or 
     *   <code>IResourceChangeEvent.PRE_DELETE</code> event triggered by the workspace.
     */
    private void handleRemovedResource(IResourceChangeEvent preChangeEvent) {
        IResource deletedResource = preChangeEvent.getResource();
        if (IResource.PROJECT == deletedResource.getType()) {
            IProject project = (IProject) deletedResource;
            if (!DISABLED.contains(project)) {
                try {
                    if (project.isOpen() && project.hasNature(EASyNature.NATURE_ID)) {
                        removeProject(project);                    
                    }
                } catch (CoreException e) {
                    // Not needed -> used warn instead of exception
                    LOGGER.warn(e.getMessage());
                }
            }
        }
    }

    /**
     * Removes a plp from a closed or deleted EASy project from the {@link SPLsManager}.
     * @param deletedProject The deleted or removed EASy project.
     */
    private void removeProject(IProject deletedProject) {
        String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(deletedProject);
        ProductLineProject deletedPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(projectID);
        if (null != deletedPLP) {
            deletedPLP.close();
        }
    }
    
    /**
     * This method checks whether the opened/imported resource was an EASy project.
     * If the opened/imported resource was an EASy project, the included plp will be added to the {@link SPLsManager}.
     * @param postChangeEvent A <code>IResourceChangeEvent.POST_CHANGE</code> event triggered by the workspace.
     */
    private void handleOpenedResource(IResourceChangeEvent postChangeEvent) {
        IResourceDelta openedDelta = postChangeEvent.getDelta();
        if (null != openedDelta) {
            IResourceDelta[] children = openedDelta.getAffectedChildren();
            for (int i = 0; i < children.length; i++) {
                if (IResource.PROJECT == children[i].getResource().getType()) {
                    IProject project = (IProject) children[i].getResource();
                    if (!DISABLED.contains(project)) {
                        try {
                            if (project.exists() && project.isOpen() && project.hasNature(EASyNature.NATURE_ID)) {
                                addProject(project);
                            }
                        } catch (CoreException e) {
                            // Should not be possible to reach this point.
                            LOGGER.exception(e);
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Adds the plp of a newly opened or imported EASY project to the SPLsManager.
     * @param project The (EASy) IProject which contains the PLP and was opened/imported within the current action.
     */
    public static void addProject(IProject project) {
        try {
            EASyUtils.loadProject(project);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
        }
    }
    
}
