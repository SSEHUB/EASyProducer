package de.uni_hildesheim.sse.easy.instantiator.copy.core;

import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.osgi.service.component.ComponentContext;

/**
 * General interface for all copy mechanisms.
 *
 * @author El-Sharkawy
 * 
 */
public abstract class AbstractCopyMechanism implements ICopyMechanism {

    private IResourceMgmt resMgmt;

    /**
     * Setter for an resources abstraction layer.
     * 
     * @param resMgmt
     *            The resources abstraction layer, which should be set.
     */
    protected final void setResourceMgmt(IResourceMgmt resMgmt) {
        this.resMgmt = resMgmt;
    }
    
    /**
     * Getter for the resources abstraction layer.
     * @return Returns the current resources abstraction layer.
     */
    protected final IResourceMgmt getResourceManager() {
        return resMgmt;
    }
    
    /**
     * Private method to activate plugin.
     * @param context Context.
     */
    protected void activate(ComponentContext context) {
        // this is not the official way of using DS but the official way is instable
        CopyMechansimRegistry.INSTANCE.register(this);
    }

    /**
     * Private method to to de-activate plugin.
     * @param context Context.
     */
    protected void deactivate(ComponentContext context) {
        // Not needed (yet)
    }

    /**
     * Copy method for copying the resources of a predecessor project to a successor project before instantiating the
     * assets.
     * 
     * @param sourceProjectName
     *            - Project which folders shall be copied
     * @param targetProjectName
     *            - Project to where the data shall be copied to
     */
    public abstract void copy(String sourceProjectName, String targetProjectName);

    @Override
    public final void refreshProject(String projectname) {
        resMgmt.refreshProject(projectname);
    }

    /**
     * Checks for a given name, whether a PLP with said name is located in the current workspace.
     * 
     * @param name
     *            the name of the project to check
     * @return true if the project is a plp and located in the workspace
     */
    public final boolean isPLPInWorkspace(String name) {
        return resMgmt.isPLPInWorkspace(name);
    }

    /**
     * Copies all Folders other than the java source files from a given eclipse Project to another. This method is also
     * used to copy projects which do not have javaproject-nature.
     * 
     * @param sourceProject copysource
     * @param targetProject copytarget
     * @param ignoredFolders additional ignored folders(used for javaprojects)
     * @param appendNS <tt>true</tt> if namespace should be appended, otherwise <tt>false</tt>.
     */
    protected static void genericCopy(IProject sourceProject, IProject targetProject, Set<String> ignoredFolders,
        boolean appendNS) {
        
        try {
            IResource[] members = sourceProject.members();
            for (IResource member : members) {
                // only visible, non derived folders
                if (member.getType() == IResource.FOLDER  && !ignoredFolders.contains(member.getName())
                    && !member.isHidden() && !member.isDerived()) {
                    
                    System.out.println("DEBUG: COPYUTIL FOLDERNAME TO BE COPIED: " + member.getName());

                    IFolder resFolder = (IFolder) member;
                    IFolder resTarget = targetProject.getFolder(resFolder.getName());
                    if (!resTarget.exists()) {
                        resTarget.create(false, true, null);
                    }
                    String namespace = "";
                    if (appendNS) {
                        namespace = sourceProject.getName();
                    }
                    handleResources(resFolder, resTarget, namespace);
                }
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the copy process of a generic folder and its content.
     * 
     * @param resFolder
     *            the folder at the source project
     * @param resTarget
     *            the copy destination
     * @param namespace
     *            the name of the source projects
     * @throws CoreException
     *             may be thrown for various reasons due to the copy mechanism
     */
    protected static void handleResources(IFolder resFolder, IFolder resTarget, String namespace) throws CoreException {
        // handle the resources folder
        IFolder dest = resTarget.getFolder(namespace);
        if (!dest.exists()) {
            dest.create(false, true, null);
        }
        for (IResource member : resFolder.members()) {
            IResource existingRes = null;
            if (member instanceof IFile) {
                existingRes = dest.getFile(member.getName());
            } else if (member instanceof IFolder) {
                existingRes = dest.getFolder(member.getName());
            }
            if (existingRes != null && existingRes.exists()) {
                // required as REPLACE seems not to work properly
                existingRes.delete(true, null);
            }
            member.copy(existingRes.getFullPath(), IResource.REPLACE | IResource.FORCE, null);
        }
    }
}
