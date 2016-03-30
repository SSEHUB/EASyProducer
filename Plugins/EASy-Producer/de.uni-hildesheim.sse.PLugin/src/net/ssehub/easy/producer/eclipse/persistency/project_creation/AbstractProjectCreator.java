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
package net.ssehub.easy.producer.eclipse.persistency.project_creation;

import java.util.UUID;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.QualifiedName;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.eclipse.Activator;
import net.ssehub.easy.producer.eclipse.ProjectConstants;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.persistency.EASyPersistencer;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.EclipsePersistencer;
import net.ssehub.easy.producer.eclipse.persistency.eclipse.IEclipseProjectCreationResult;

/**
 * Super class for creating new EASy projects.
 * @author El-Sharkawy
 *
 */
abstract class AbstractProjectCreator {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(AbstractProjectCreator.class,
        Activator.PLUGIN_ID);
    
    private ProductLineProject newPLP;
    private String projectName;
    private EclipsePersistencer persistencer;
    private IProject project;
    private boolean lazy;
    /**
    
     * Configurators to configure the project during creation.
     * Maybe <tt>null</tt>.
     */
    private IEASyProjectConfigurator[] configurators;

    /**
     * Sole constructor for creating new EASy projects.
     * @param projectName The name of the new project (should already be checked, whether the name is valid).
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before
     * @param configurators Optional list of configurators to configure the newly created project, maybe <tt>null</tt>.
     *     The configurators whill be applied in the ordering of the array.
     */
    protected AbstractProjectCreator(String projectName, boolean lazy, IEASyProjectConfigurator... configurators) {
        this.projectName = projectName;
        this.lazy = lazy;
        this.configurators = configurators;
        persistencer = new EclipsePersistencer(projectName, null);
        project = null;
    }
    
    /**
     * Returns the newly created {@link ProductLineProject}.
     * @return The newly created {@link ProductLineProject} or <tt>null</tt> if this method was called before the
     *     creation was finished. 
     */
    protected final ProductLineProject getCreatedProject() {
        return newPLP;
    }
    
    /**
     * Returns whether the project should be created lazy.
     * @return <code>true</code> if only required parts should be created,
     *     else assume that project does not exist before
     */
    protected final boolean isLazyCreation() {
        return lazy;
    }
    
    /**
     * Creates the (empty) {@link ProductLineProject}, which may needs further configuration.
     * This is the first step while creating a derived or not derived project.
     * This project will also be configured with the given {@link IEASyProjectConfigurator}s.
     */
    protected final void createProject() {
        createNewEASyProject();
        if (!lazy) {
            configureProject();
        }
    }
    
    /**
     * Configures the newly created project.
     * For instance, this may include to change the project to a Java project.
     * Part of the {@link #createProject()} method.
     */
    private void configureProject() {
        NullProgressMonitor monitor = new NullProgressMonitor();
        
        monitor.beginTask("Create Java Project", 10);

        // Create the project (SE: unsure whether this is needed)
        try {
            if (!project.exists()) {
                IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
                desc.setLocationURI(null);
                project.create(desc, monitor);
                monitor = null;
            }
            if (!project.isOpen()) {
                project.open(monitor);
                monitor = null;
            }
        } catch (CoreException e) {
            LOGGER.exception(e);
        } finally {
            if (monitor != null) {
                monitor.done();
            }
        }
        
        // Configure project to java Project
        if (null != configurators) {
            for (IEASyProjectConfigurator configurator : configurators) {
                configureProject(project, configurator);
            }
        }
    }

    /**
     * Configures the newly created Eclipse project.
     * @param createdProject The newly created EASy (Eclipse) project.
     * @param configurator The configurator to use for configuring the project.
     */
    protected abstract void configureProject(IProject createdProject, IEASyProjectConfigurator configurator);
    
    /**
     * Create the project related information, i.e., the PLP instance, possibly including the containing project.
     * This project needs further configuration.
     * Part of the {@link #createProject()} method.
     */
    private void createNewEASyProject() {
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
                Script mainBuildScript = new Script(projectName, Script.createDefaultParameter());
                Version version = result.getVarModel().getVersion();
                if (null != version) {
                    mainBuildScript.setVersion(version);
                }
                
                Configuration location = PersistenceUtils.getConfiguration(result.getProjectFolder());
                ProjectContainer varModel = new ProjectContainer(result.getVarModel(), location);
                ScriptContainer instantiationModel = new ScriptContainer(mainBuildScript, location);
                instantiationModel.setEdited(true);
                
                newPLP = new ProductLineProject(projectID, projectName, varModel, result.getProjectFolder(),
                    instantiationModel);
            }
        }
    }
    
    /**
     * Sets persistence properties for the newly created project and refreshes the workspace/models.
     */
    protected final void setPersistenceProperties() {
        QualifiedName qname = new QualifiedName(ProjectConstants.UUID_PROPERTY_QNAME, "projectid");
        try {
            project.setPersistentProperty(qname, newPLP.getProjectID());
            EASyPersistencer.refreshModels(newPLP);
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Creates the new {@link ProductLineProject} with the specified parameters.
     * @return The newly created {@link ProductLineProject}.
     */
    abstract ProductLineProject createEASyProject();

}
