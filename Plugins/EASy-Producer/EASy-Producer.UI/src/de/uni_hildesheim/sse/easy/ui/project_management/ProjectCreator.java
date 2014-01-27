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

import java.net.URI;
import java.util.UUID;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.wizards.JavaCapabilityConfigurationPage;

import de.uni_hildesheim.sse.easy_producer.EASyUtils;
import de.uni_hildesheim.sse.easy_producer.ProjectConstants;
import de.uni_hildesheim.sse.easy_producer.contributions.Contributions;
import de.uni_hildesheim.sse.easy_producer.contributions.Contributions.CoreFunction;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.persistency.EASyPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.EclipsePersistencer;
import de.uni_hildesheim.sse.easy_producer.persistency.eclipse.IEclipseProjectCreationResult;
import de.uni_hildesheim.sse.model.validation.IvmlIdentifierCheck;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.modelManagement.ProjectContainer;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Creates a new Project with the given parameters.
 * 
 * @author El-Sharkawy
 * @author Kapeluch
 * @author Nowatzki
 * 
 */
public class ProjectCreator {
    private ProductLineProject newPLP;
    private String projectname;
    private EclipsePersistencer persistencer;
    private IProject project;
    private boolean lazy;

    /**
     * Default constructor for this class.
     * 
     * @param projectname The name of the new project
     * @throws ProjectAlreadyExistsException If the project which should be created already exists.
     * @throws InvalidProjectnameException If the projectname is not valid.
     */
    public ProjectCreator(String projectname) throws ProjectAlreadyExistsException, InvalidProjectnameException {
        this(projectname, false);
    }
    
    /**
     * Use this constructor in case, if you don't want to open a configuration window. This constructor is for automated
     * testing.
     * 
     * @param projectname The name of the new project
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before
     * 
     * @throws ProjectAlreadyExistsException If the project which should be created already exists.
     * @throws InvalidProjectnameException If the project which should be created has a non-valid name.
     */
    public ProjectCreator(String projectname, boolean lazy) 
        throws ProjectAlreadyExistsException, InvalidProjectnameException {
        if (!lazy && (projectExists(projectname))) {
        /* If the project which is intended to be created is already existing,
         * the user gets informed. Thus the project wont be created.
         */ 
            throw new ProjectAlreadyExistsException();    
        }
        if (!IvmlIdentifierCheck.isValidIdentifier(projectname)) {
        /* If the projects name is not valid, the user gets informed. Thus the project
         * wont be created.
         */
            throw new InvalidProjectnameException();
        }
        if (IvmlIdentifierCheck.isValidIdentifier(projectname)) {
            this.projectname = projectname;
            this.lazy = lazy;
            persistencer = new EclipsePersistencer(projectname, null);
            project = null;
        }
    }
    
    /**
     * Creates a new productline member with all necessarily files and folders. The new created project will be a
     * successor of an existing project. This function is only enabled if 
     * {@link de.uni_hildesheim.sse.easy_producer.contributions.Contributions.CoreFunction#DERIVE_NEW_MEMBER}
     * is enabled. This method acts as a frontend for 
     * {@link #deriveNewPLP(String)}.
     * 
     * @see ProjectCreator#newPLP()
     * @param predecessor On predecessor of the new project
     * @return The newly created product line project
     */
    public ProductLineProject deriveNewMember(String predecessor) {
        
        /* New blank ProductLineProject for this method in order 
         * to avoid more than one return-statement.
         */
        ProductLineProject plpDerive = new ProductLineProject(predecessor, null);
        
        if (Contributions.isEnabled(CoreFunction.DERIVE_NEW_MEMBER)) {
            plpDerive = deriveNewPLP(predecessor);
        } else {
            plpDerive = null;
        }
        return plpDerive;
    }
    
    /**
     * Creates a new productline project with all necessarily files and folders. The new created project will be a
     * successor of an existing project.
     * 
     * @see ProjectCreator#newPLP()
     * @param predecessor On predecessor of the new project
     * @return The newly created product line project
     */
    public ProductLineProject deriveNewPLP(String predecessor) {
        createProject(false);
        createJavaProject();
        ProductLineProject parentPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(predecessor);

        // Set Predecessors
        newPLP.getMemberController().addPredecessor(predecessor);
        Project parentProject = parentPLP.getProject();
        
        // Support old EASy project, which do not contain any build scripts
        boolean hasBuildScript = null != parentPLP.getBuildScript();
        EASyUtils.addImport(newPLP, parentProject.getName(), parentProject.getVersion(), hasBuildScript);

        // Save parent plp
        parentPLP.save();

        // Sets persistence properties for the newly created project and refreshes the workspace/models
        setPersistenceProperties();

        // Set Successor
        parentPLP.getMemberController().addSuccessor(newPLP.getProjectID());

        // Configure the newly created PTN
        newPLP.pullConfigFromPredecessors();
        newPLP.save();

        return newPLP;
    }
    
    /**
     * Create the project related information, i.e., the PLP instance, possibly including the containing project.
     * 
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before 
     *   (and possibly handle errors if the project already exists)
     */
    private void createProject(boolean lazy) {
        String projectID = UUID.randomUUID().toString();
        IEclipseProjectCreationResult result = null;
        try {
            result = persistencer.createEASyProject(projectID, lazy);            
        } catch (PersistenceException e) {
            e.printStackTrace();
        } catch (CoreException e) {
            e.printStackTrace();
        }
        
        if (null != result) {
            project = result.getIProject();
            /*
             * persistencer.createEASyProject(projectID, lazy); leads to a refreshed workspace which automatically
             * creates an PLP of the newly created IProject.
             * It is important to avoid the creation of a second PLP for the same IProject.
             */
            if (null != result.getProjectID()) {
                newPLP = (ProductLineProject) SPLsManager.INSTANCE.getPLP(projectID);
            }
            /*
             * If workspace refresh did not lead to the creation of an PLP, create it here.
             * TODO: Unclear whether this is needed.
             */
            if (null == newPLP && null != result.getVarModel()) {
                // at least called when importing / creating a new project
                Script mainBuildScript = new Script(projectname, null, Script.createDefaultParameter(), null, null);
                Version version = result.getVarModel().getVersion();
                if (null != version) {
                    mainBuildScript.setVersion(version);
                }
                
                ProjectContainer varModel = new ProjectContainer(result.getVarModel(), result.getConfigFolder());
                ScriptContainer instantiationModel = new ScriptContainer(mainBuildScript, result.getConfigFolder());
                
                newPLP = new ProductLineProject(projectID,
                    projectname,
                    varModel,
                    result.getProjectFolder(),
                    instantiationModel);
            }
        }
    }
    

    /**
     * Sets persistence properties for the newly created project and refreshes the workspace/models.
     */
    private void setPersistenceProperties() {
        QualifiedName qname = new QualifiedName(ProjectConstants.UUID_PROPERTY_QNAME, "projectid");
        try {
            project.setPersistentProperty(qname, newPLP.getProjectID());
            EASyPersistencer.refreshModels(newPLP);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new product line project with all necessarily files and folders.
     * 
     * @see #deriveNewPLP(String)
     * @return The newly created product line project
     */
    public ProductLineProject newPLP() {
        createProject(lazy);
        if (!lazy) {
            createJavaProject();
        }
        setPersistenceProperties();

        return newPLP;
    }
    
    /**
     * Creates a new java project inside eclipse.
     */
    private void createJavaProject() {       
        try {
            JavaCapabilityConfigurationPage.createProject(project, (URI) null, null);
        } catch (CoreException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        JavaCapabilityConfigurationPage jcpage = new JavaCapabilityConfigurationPage();
        IJavaProject javaProject = JavaCore.create(project);

        jcpage.init(javaProject, null, null, false);
        try {
            jcpage.configureJavaProject(null);
        } catch (CoreException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        // Create default java folders and settings
        try {
            project.getFolder(ProjectConstants.FOLDER_LIBS).create(false, true, null);
            IFolder resFolder = project.getFolder(ProjectConstants.FOLDER_RES);
            resFolder.create(false, true, null);
            IClasspathEntry resEntry = JavaCore.newSourceEntry(resFolder.getFullPath());
            IClasspathEntry[] currentEntries = javaProject.getRawClasspath();
            IClasspathEntry[] newEntries = new IClasspathEntry[currentEntries.length + 1];
            System.arraycopy(currentEntries, 0, newEntries, 0, currentEntries.length);
            newEntries[newEntries.length - 1] = resEntry;
            javaProject.setRawClasspath(newEntries, null);
        } catch (CoreException e) {
            // Every caught exception is painful, but not harmful
            e.printStackTrace();
        }
    }


    /**
     * Tests whether a given projectname already exists inside the workspace.
     * 
     * @param projectname A new projectname to test
     * @return <b>true</b> if the project already exists, otherwise <b>false</b>
     */
    public static boolean projectExists(String projectname) {
        return ResourcesPlugin.getWorkspace().getRoot().getProject(projectname).exists();
    }
    
    /**
     * Updates the models in this project.
     */
    public void update() {
        try {
            persistencer.update();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Getter for the name of the created project.
     * @return project name name of the project
     */
    public String getProjectName() {
        return projectname;
    }
}