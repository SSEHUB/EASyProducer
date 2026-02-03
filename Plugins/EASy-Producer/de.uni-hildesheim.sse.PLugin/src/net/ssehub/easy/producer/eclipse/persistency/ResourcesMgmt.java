package net.ssehub.easy.producer.eclipse.persistency;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.eclipse.Activator;
import net.ssehub.easy.producer.eclipse.EASyUtils;
import net.ssehub.easy.producer.eclipse.PLPWorkspaceListener;
import net.ssehub.easy.producer.eclipse.ProjectConstants;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.observer.EclipseProgressObserver;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.EASyNature;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.NatureUtils;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.IEASyProjectConfigurator;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.InvalidProjectnameException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectAlreadyExistsException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectCreator;

/**
 * Resources abstraction layer.
 * @author El-Sharkawy
 *
 */
public class ResourcesMgmt {
    
    public static final ResourcesMgmt INSTANCE = new ResourcesMgmt();
    
    private boolean enableBackgroundTasks = true;
    
    /**
     * Hides the default constructor for this singleton class.
     */
    private ResourcesMgmt() {}
    
    /**
     * Enables or disables background tasks. This may be helpful in non-full EASy environments, such as the 
     * QualiMaster configuration application. May require shutting down
     * {@link net.ssehub.easy.producer.eclipse.PLPWorkspaceListener}.
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
    public IProject getProject(String projectname) {
        return getWorkspace().getRoot().getProject(projectname);
    }
    
    /**
     * Returns a representation of the current used workspace.
     * 
     * @return A representation of the current used workspace or <code>null</code> if no workspace was loaded
     * (this may happen if the responsible Eclipse plug-in was not loaded and started, e.g. when EASy runs as
     * a command line tool).
     */
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
     * @return The location of the workspace inside the file system or <code>null</code> if the workspace 
     *     was not loaded.
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
     * 
     * @param obs progress monitor
     */
    public void findPLProjects(EclipseProgressObserver obs) {
        ArrayList<IProject> plProjects = getAllPLProjects();

        if (enableBackgroundTasks && plProjects.size() > 0) {
            SPLsManager splsMngr = SPLsManager.INSTANCE;
            for (IProject plProject : plProjects) {
                File projectPath = plProject.getLocation().toFile();
                EASyPersistencer persistency = new EASyPersistencer(projectPath, obs, plProject);
                String projectID = persistency.getProjectID();
                PLPInfo plp = (PLPInfo) splsMngr.getPLP(projectID);
                // Test whether the plp is already stored inside the SPLsManager
                if (null == plp || plp.isPreliminary()) {
                    /*
                     * PLP is not stored in SPLsManager: 1. read config file 2. store plp on SPLsManager
                     */
                    try {
                        plp = persistency.load();
                    } catch (PersistenceException pExc) {
                        EASyLoggerFactory.INSTANCE.getLogger(getClass(), projectID).info(
                            "Cannot load PLP. Ignoring. Reason: " + pExc.getMessage());
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
     * Retrieves the absolute path of an <code>IProject</code> inside the file system.
     * @param projectname The name of the project, which location shall be determined.
     * @return The location inside the file system or <code>workspace/projectname</code> if the specified 
     * <code>IProject</code> does not exist.
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
     * @param project the project to operate on, may be <b>null</b>
     * @return ID of the related project or <b>null</b> if it cannot be determined.
     */
    public String getIDfromResource(IResource theResource, IProject project) {
        String theID = null;
        QualifiedName qname = new QualifiedName(ProjectConstants.UUID_PROPERTY_QNAME, "projectid");
        try {
            if (theResource.getPersistentProperty(qname) == null) {
                EASyPersistencer persistencer = new EASyPersistencer(
                    theResource.getProject().getLocation().toFile(), null, project);
                theID = persistencer.getProjectID();
                if (null != theID) {
                    theResource.setPersistentProperty(qname, theID.toString());
                }
            } else {
                theID = theResource.getPersistentProperty(qname);
            }
        } catch (CoreException e) {
        }
        if (null == theID) {
            EASyPersistencer persistencer = new EASyPersistencer(
                theResource.getProject().getLocation().toFile(), null, project);
            theID = persistencer.getProjectID();
        }
        return theID;
    }
    
    /**
     * Adds the EASy-Nature to an Eclipse {@link IProject}, the project does not have this nature.
     * Will also add all another relevant information needed to work with EASy if not existent, these are:
     * <ul>
     *   <li>The Xtext nature to open use its editors for IVML, VIL, VTL, ...</li>
     *   <li>EASy Folder with default configuration files:
     *   <ul>
     *     <li>Main IVML file</li>
     *     <li>Main VIL file</li>
     *     <li>.EASyConfig</li>
     *   </ul></li>
     * </ul>
     * @param project A project from the workspace.
     * @param natures Must be the Xtext and the EASy nature (unfortunately, they are provided by UI packages).
     * @throws CoreException If project does not exist or is not open
     * @throws InvalidProjectnameException If the project which should be created has a non-valid name.
     * @throws IOException In case of loading/initialization problems
     */
    public void addEASyNatures(IProject project, String... natures) throws CoreException, InvalidProjectnameException,
        IOException {
        
        IOException exc = null;
        PLPWorkspaceListener.disableFor(project);
        // Add natures
        if (null != natures) {
            for (int i = 0; i < natures.length; i++) {
                if (!NatureUtils.hasNature(project, natures[i])) {
                    NatureUtils.addNature(project, natures[i], null);
                }
                NatureUtils.ensureBuilder(project, EASyNature.BUILDER_ID, EASyNature.XTEXT_BUILDER_ID, null);
            }
        }
        try {
            loadAndInitialize(project);
        } catch (IOException e) {
            exc = e;
        }
        PLPWorkspaceListener.reenableFor(project);
        project.refreshLocal(IProject.DEPTH_INFINITE, null);
        if (null == exc) {
            PLPWorkspaceListener.addProject(project);
        } else {
            throw exc;
        }
    }
    
    /**
     * Loads and initializes the project.
     * @param project the project to be loaded
     * @throws IOException in case of loading/initialization problems
     * @throws InvalidProjectnameException  If the project which should be created has a non-valid name.
     */
    private void loadAndInitialize(IProject project) throws IOException, InvalidProjectnameException {
        try {
            // try to load project completely
            EASyUtils.loadProject(project);
        } catch (PersistenceException e) {
            // project exists, easy information missing
            // easy path could also be determined via UI but I don't like UI - Niko will take care of that
            EASyUtils.determineConfigurationPaths(project);
            try {
                ProjectCreator creator = new ProjectCreator(project.getName(), true);
                /*
                 * IEASyProjectConfigurator = null -> Keep project configured as it is
                 * (Xtext and EASy Nature are already added in step before).
                 */
                ProductLineProject plp = creator.newPLP((IEASyProjectConfigurator) null);
                EASyUtils.initialize(project, plp);
                plp.save();
                // after additional models have been added, update VarModel etc.
                PersistencerFactory.getPersistencer(plp.getProjectLocation(), null, project).update();
            } catch (ProjectAlreadyExistsException ae) {
                // shall not occur due to lazy creation
                throw new IOException(ae.getMessage());
            } catch (PersistenceException exc) {
                // Part of the update function, should not be critical
                EASyLoggerFactory.INSTANCE.getLogger(ResourcesMgmt.class, Activator.PLUGIN_ID).exception(exc);
            } 
        }
    }
}
