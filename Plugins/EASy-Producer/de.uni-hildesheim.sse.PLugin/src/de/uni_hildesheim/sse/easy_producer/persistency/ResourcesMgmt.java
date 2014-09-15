package de.uni_hildesheim.sse.easy_producer.persistency;

import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.IResourceMgmt;
import de.uni_hildesheim.sse.easy_producer.PLPWorkspaceListener;
import de.uni_hildesheim.sse.easy_producer.ProjectConstants;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EASyNature;

/**
 * Resources abstraction layer.
 * @author El-Sharkawy
 *
 */
public class ResourcesMgmt implements IResourceMgmt {
    
    public static final ResourcesMgmt INSTANCE = new ResourcesMgmt();
    
    private boolean enableBackgroundTasks = true;
    
    /**
     * Hides the default constructor for this singleton class.
     */
    private ResourcesMgmt() {}
    
    /**
    /**
     * Returns the singleton-instance of this class.
     * 
     * @return ResourcesMgmt.INSTANCE The Singleton of the class ResourcesMgmt.
     
    public static ResourcesMgmt getInstance() {
        return INSTANCE;
    }
    **/
     
     
    @Override
    public String getMainSourceFolder() {
        return ProjectConstants.FOLDER_SOURCE;
    }

    @Override
    public String getResourcesFolder() {
        return ProjectConstants.FOLDER_RES;
    }
    
    @Override
    public String getConfigFolder() {
        return ProjectConstants.EASY_FILES;
    }
    
    /**
     * Enables or disables background tasks. This may be helpful in non-full EASy environments, such as the 
     * QualiMaster configuration application. May require shutting down {@link PLPWorkspaceListener}.
     * 
     * @param enable <code>true</code> enables the background tasks, <code>false</code> else
     */
    public void enableBackgroundTasks(boolean enable) {
        this.enableBackgroundTasks = enable;
    }
    
    /**
     * Checks for a given name, whether a PLP with said name is located in the current workspace.
     * 
     * @param name the name of the project to check
     * @return true if the project is a plp and located in the workspace
     */
    public boolean isPLPInWorkspace(String name) {
        boolean available = false;
        
        try {
            IProject project = getProject(name);
            if (null != project) {
                available = project.isOpen() && project.hasNature(EASyNature.NATURE_ID);
            }
        } catch (CoreException e) {
            // Should not occur
        }
        return available;
    }

    /**
     * Returns a representation of the selected project.
     * @param projectname The name of the IProject which shall be retrieved.
     * @return A representation of the selected project
     */
    @Override
    public IProject getProject(String projectname) {
        return getWorkspace().getRoot().getProject(projectname);
    }
    
    /**
     * Returns a representation of the current used workspace.
     * 
     * @return A representation of the current used workspace or <tt>null</tt> if no workspace was loaded
     * (this may happen if the responsible Eclipse plug-in was not loaded and started, e.g. when EASy runs as
     * a command line tool).
     */
    @Override
    public IWorkspace getWorkspace() {
        IWorkspace ws = null;
        try {
            ws = ResourcesPlugin.getWorkspace();
        } catch (IllegalStateException exc) {
            // Not needed
        }
        return ws;
    }
    
    /**
     * Returns the workspace as a {@link File} object.
     * @return The location of the workspace inside the file system or <tt>null</tt> if the workspace was not loaded.
     * @see #getWorkspace()
     */
    public File getWorspaceFolder() {
        File wsFolder = null;
        IWorkspace ws = getWorkspace();
        if (null != ws) {
            wsFolder = ws.getRoot().getLocation().toFile();
        }
        
        return wsFolder;
    }
    
    /**
     * Returns all existing projects inside the current workspace.
     * 
     * @return All projects inside the workspace.
     */
    public IProject[] getAllProjects() {
        return getWorkspace().getRoot().getProjects();
    }
    
    /**
     * gets all PLugin projects from the workspace and adds it to an arraylist.
     * 
     * @return an arraylist filled with PLugin projects
     */
    private ArrayList<IProject> getAllPLProjects() {
        ArrayList<IProject> projects = new ArrayList<IProject>();
        for (IProject project : getAllProjects()) {
            try {
                if (project.isOpen() && project.hasNature(EASyNature.NATURE_ID)) {
                    projects.add(project);
                }
            } catch (CoreException e) {
                // Should not occur
                e.printStackTrace();
            }
        }

        return projects;
    }

    /**
     * Iterates through all EASy projects of the workspace, gets the config path and the uuid from all projects and
     * adds them to the {@link SPLsManager}. Considers {@link #enableBackgroundTasks}.
     */
    public void findPLProjects() {
        ArrayList<IProject> plProjects = getAllPLProjects();

        if (enableBackgroundTasks && plProjects.size() > 0) {
            SPLsManager splsMngr = SPLsManager.INSTANCE;
            for (IProject plProject : plProjects) {
                File projectPath = plProject.getLocation().toFile();
                EASyPersistencer persitency = new EASyPersistencer(projectPath);
                String projectID = persitency.getProjectID();
                PLPInfo plp = (PLPInfo) splsMngr.getPLP(projectID);
                // Test whether the plp is already stored inside the SPLsManager
                if (null == plp || plp.isPreliminary()) {
                    /*
                     * PLP is not stored in SPLsManager: 1. read config file 2. store plp on SPLsManager
                     */
                    try {
                        plp = persitency.load();
                    } catch (PersistenceException pExc) {
                        // TODO SE: handle this exception (invalid configuration
                        // file) correctly
                        pExc.printStackTrace();
                    }
                }
            }
        }
    }
    
    /**
     * Refreshes the files and folders in the package explorer view for the given project.
     * @param projectname The name of the project to be refreshed.
     */
    public void refreshProject(String projectname) {
        if (null != getWorkspace() && !getWorkspace().isTreeLocked()) {
            try {
                IProject project = getProject(projectname);
//                project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
                project.refreshLocal(IResource.DEPTH_INFINITE, null);
            } catch (CoreException e) {
                // Should not occur
                e.printStackTrace();
            }
        }
    }
    
    /**
     * Retrieves the absolute path of an <tt>IProject</tt> inside the file system.
     * @param projectname The name of the project, which location shall be determined.
     * @return The location inside the file system or <tt>workspace/projectname</tt> if the specified <tt>IProject</tt>
     * does not exist.
     */
    public File getProjectLocation(String projectname) {
        File projectLocation = null;
        if (null != getProject(projectname).getLocation()) {
            projectLocation = getProject(projectname).getLocation().toFile();
        } else {
            File workspace = ResourcesPlugin.getWorkspace().getRoot().getLocation().toFile();
            projectLocation = new File(workspace, projectname);
        }
        
        return projectLocation;
    }
    
    /**
     * Returns the local file Seperator. <br />
     * This method should be used instead of "\".
     * 
     * @return Returns a valid file seperator.
     */
    public char getSeperator() {
        return '/';
    }
    
    /**
     * Returns the ID of the project holding the resource.
     * 
     * @param theResource Resource of a project from which the ID should be determined.
     * @return ID of the related project or <b>null</b> if it cannot be determined.
     */
    public String getIDfromResource(IResource theResource) {
        String theID = null;
        QualifiedName qname = new QualifiedName(ProjectConstants.UUID_PROPERTY_QNAME, "projectid");

        try {
            if (theResource.getPersistentProperty(qname) == null) {
                EASyPersistencer persistencer = new EASyPersistencer(theResource.getProject().getLocation().toFile());
                theID = persistencer.getProjectID();
                if (null != theID) {
                    theResource.setPersistentProperty(qname, theID.toString());
                }
            } else {
                theID = theResource.getPersistentProperty(qname);
            }
        } catch (CoreException e) {
            EASyPersistencer persistencer = new EASyPersistencer(theResource.getProject().getLocation().toFile());
            theID = persistencer.getProjectID();
        }
        return theID;
    }
}
