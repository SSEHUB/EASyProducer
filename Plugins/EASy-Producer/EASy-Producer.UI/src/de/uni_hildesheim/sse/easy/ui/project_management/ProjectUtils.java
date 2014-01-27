package de.uni_hildesheim.sse.easy.ui.project_management;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.XtextProjectHelper;

import de.uni_hildesheim.sse.easy_producer.EASyUtils;
import de.uni_hildesheim.sse.easy_producer.PLPWorkspaceListener;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EASyNature;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.NatureUtils;

/**
 * Utilities on Eclipse project level interferring with UI.
 * 
 * @author Holger Eichelberger
 */
public class ProjectUtils {
    
    /**
     * Toggles the EASy nature of <code>project</code>.
     * 
     * @param project the project to toggle the EASy nature for
     * @throws IOException in case of initialization problems
     * @throws InvalidProjectnameException if a projectname is not valid
     */
    public static final void toggleNature(IProject project) throws IOException, InvalidProjectnameException {
        try {
            boolean hasNature = NatureUtils.hasNature(project, EASyNature.NATURE_ID);
            if (!hasNature) {
                IOException exc = null;
                PLPWorkspaceListener.disableFor(project);
                // add natures
                if (!NatureUtils.hasNature(project, XtextProjectHelper.NATURE_ID)) {
                    NatureUtils.addNature(project, XtextProjectHelper.NATURE_ID, null);
                }
                NatureUtils.addNature(project, EASyNature.NATURE_ID, null);
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
            } else {
                String projectID = ResourcesMgmt.INSTANCE.getIDfromResource(project);
                ProductLineProject deletedPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(projectID);
                if (null != deletedPLP) {
                    deletedPLP.close();
                }
                NatureUtils.removeNature(project, EASyNature.NATURE_ID, null);
                project.refreshLocal(IProject.DEPTH_INFINITE, null);
            }
        } catch (CoreException e) {
            throw new IOException(e.getMessage());
        }
    }
    
    /**
     * Loads and initializes the project.
     * @param project the project to be loaded
     * @throws IOException in case of loading/initialization problems
     * @throws InvalidProjectnameException 
     */
    private static void loadAndInitialize(IProject project) throws IOException, InvalidProjectnameException {
        try {
            // try to load project completely
            EASyUtils.loadProject(project);
        } catch (PersistenceException e) {
            // project exists, easy information missing
            // easy path could also be determined via UI but I don't like UI
            EASyUtils.determineConfigurationPath(project);
            try {
                ProjectCreator creator = new ProjectCreator(project.getName(), true);
                ProductLineProject plp = creator.newPLP();
                EASyUtils.initialize(project, plp);
                plp.save();
                // after additional models have been added, update VarModel etc.
                creator.update();
            } catch (ProjectAlreadyExistsException ae) {
                // shall not occur due to lazy creation
                throw new IOException(ae.getMessage());
            } 
        }
    }
}
