/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.easy.ui.project_management;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.XtextProjectHelper;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.EASyUtils;
import de.uni_hildesheim.sse.easy_producer.PLPWorkspaceListener;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.PersistencerFactory;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EASyNature;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.NatureUtils;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.IEASyProjectConfigurator;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.InvalidProjectnameException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectAlreadyExistsException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Utilities on Eclipse project level interferring with UI.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class ProjectUtils {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ProjectUtils.class,
        Activator.PLUGIN_ID);
    
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
                addEASyNature(project);
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
     * Adds the EASy-Nature to an Eclipse {@link IProject}, the project does not have this nature.
     * Will also add all aother relevant information needed to work with EASy if not existent, these are:
     * <ul>
     *   <li>The Xtext nature to open use its editors for IVML, VIL, VTL, ...</li>
     *   <li>EASy Folder with defult configuration files:</li>
     *   <ul>
     *     <li>Main IVML file</li>
     *     <li>Main VIL file</li>
     *     <li>.EASyConfig</li>
     *   </ul>
     * </ul>
     * @param project A project from the workspace.
     * @throws CoreException If project does not exist or is not open
     * @throws InvalidProjectnameException If the project which should be created has a non-valid name.
     * @throws IOException In case of loading/initialization problems
     */
    private static void addEASyNature(IProject project) throws CoreException, InvalidProjectnameException, IOException {
        IOException exc = null;
        PLPWorkspaceListener.disableFor(project);
        // Add Xtext nature
        if (!NatureUtils.hasNature(project, XtextProjectHelper.NATURE_ID)) {
            NatureUtils.addNature(project, XtextProjectHelper.NATURE_ID, null);
        }
        // Add EASy-Nature
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
    }
    
    /**
     * Loads and initializes the project.
     * @param project the project to be loaded
     * @throws IOException in case of loading/initialization problems
     * @throws InvalidProjectnameException  If the project which should be created has a non-valid name.
     */
    private static void loadAndInitialize(IProject project) throws IOException, InvalidProjectnameException {
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
                PersistencerFactory.getPersistencer(plp.getProjectLocation()).update();
            } catch (ProjectAlreadyExistsException ae) {
                // shall not occur due to lazy creation
                throw new IOException(ae.getMessage());
            } catch (PersistenceException exc) {
                // Part of the update function, should not be critical
                LOGGER.exception(exc);
            } 
        }
    }
}
