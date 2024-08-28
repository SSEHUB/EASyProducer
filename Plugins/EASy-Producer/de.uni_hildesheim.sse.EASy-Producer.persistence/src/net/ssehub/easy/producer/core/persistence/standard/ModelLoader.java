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
package net.ssehub.easy.producer.core.persistence.standard;

import java.io.File;
import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.varMod.container.ModelContainer;
import net.ssehub.easy.producer.core.varMod.container.ModelContainerFactory;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.core.varMod.container.SemanticErrorDescription;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Part of the {@link Persistencer}, responsible for loading IVML/VIL models.
 * @param <Model> One of {@link Project} or {@link Script}.
 * @author El-Sharkawy
 *
 */
class ModelLoader<Model extends IModel> {
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(ModelLoader.class,
        Activator.PLUGIN_ID);
    
    
    private PersistentProject project;
    private Configuration location;
    
    /**
     * Sole constructor of this class.
     * @param project The {@link PersistentProject} which is currently loaded by the {@link Persistencer}.
     * @param location The {@link Configuration} of the {@link PersistentProject}.
     */
    public ModelLoader(PersistentProject project, Configuration location) {
        this.project = project;
        this.location = location;
    }
    
    /**
     * Loads the {@link Project} or the {@link Script} and adds it to the given {@link PersistentProject}.
     * @param projectName The name of the {@link IModel} to load.
     * @param projectVersion The {@link Version} of the {@link IModel} to load.
     * @param modelType Must match to the given {@link IModel} type:
     * <ul>
     * <li>{@link Project} = {@link PathKind#IVML}</li>
     * <li>{@link Script} = {@link PathKind#VIL}</li>
     * </ul>
     * @throws PersistenceException Will be thrown if an error occurred during
     *     the {@link ModelManagement#load(ModelInfo)} operation.
     */
    @SuppressWarnings("unchecked")
    public void loadModel(String projectName, String projectVersion, PathKind modelType)
        throws PersistenceException {

        switch(modelType) {
        case IVML:
            ProjectContainer projectContainer = (ProjectContainer) loadModel(projectName, projectVersion,
                (ModelManagement<Model>) VarModel.INSTANCE, modelType);
            project.setVarModel(projectContainer);
            break;
        case VIL:
            ScriptContainer scriptContainer = (ScriptContainer) loadModel(projectName, projectVersion,
                (ModelManagement<Model>) BuildModel.INSTANCE, modelType);
            project.setScript(scriptContainer);
            break;
        default:
            // Not needed
            break;
        }
    }
    
    /**
     * Loads the {@link Project} or the {@link Script} and stores it to in a {@link ModelContainer}.
     * @param projectName The name of the {@link IModel} to load.
     * @param projectVersion The {@link Version} of the {@link IModel} to load.
     * @param modelManagement Must match to the given {@link IModel} type:
     * <ul>
     * <li>{@link Project} = {@link VarModel#INSTANCE}</li>
     * <li>{@link Script} = {@link BuildModel#INSTANCE}</li>
     * </ul>
     * @param modelType Must match to the given {@link IModel} type:
     * <ul>
     * <li>{@link Project} = {@link PathKind#IVML}</li>
     * <li>{@link Script} = {@link PathKind#VIL}</li>
     * </ul>
     * @return The loaded {@link ModelContainer}.
     * @throws PersistenceException Will be thrown if an error occurred during
     *     the {@link ModelManagement#load(ModelInfo)} operation.
     */
    private ModelContainer<?> loadModel(String projectName, String projectVersion,
        ModelManagement<Model> modelManagement, PathKind modelType) throws PersistenceException {
        File folder = location.getPathFile(modelType, 0);
        String fileName = PersistenceUtils.modelFileLocation(projectName, projectVersion, folder.getAbsolutePath(),
            modelType);
        File file = new File(fileName);
        Model model = null;
        ModelInfo<Model> info = null;
        ModelContainer<?> modelContainer = null;
        try {
            info = modelManagement.availableModels().getModelInfo(projectName, projectVersion, file.toURI());
            // Eclipse project specifies a version number, but that version number was not found in available models.
            if (null == info) {
                List<ModelInfo<Model>> alternatives
                    = modelManagement.availableModels().getVisibleModelInfo(projectName, file.toURI());
                // Load alternative, if exactly one alternative was found
                if (null != alternatives && 1 == alternatives.size()) {
                    info = alternatives.get(0);
                    // old assumption on version==0, just take it
                    //LOGGER.warn("No " + modelType.name() + "-model found with name =\"" + projectName
                    //    + "\" and version =\"" + projectVersion + "\" at " + file.getAbsolutePath()
                    //    + ", load single available alternative.");
                }
            }
        } catch (VersionFormatException e) {
            throw new PersistenceException(e);
        }
        if (null != info) {
            LOGGER.debug("Found: " + info.toString());
            try {
                model = modelManagement.load(info);
                modelContainer = ModelContainerFactory.createContainer(model, location);
                LOGGER.debug("Model loaded: " + info.toString());
            } catch (ModelManagementException e) {
                if (e.getId() == ModelManagementException.INTERNAL) {
                    throw new PersistenceException(e);
                } else {
                    try { // do a second round for heavily dependent imports
                        model = modelManagement.load(info);
                        modelContainer = ModelContainerFactory.createContainer(model, location);
                        LOGGER.debug("Model loaded: " + info.toString());
                    } catch (ModelManagementException e1) { // if second round fails, standard output
                        LOGGER.warn(info.getName() + " " + Version.toString(info.getVersion()) + " cannot be loaded: " 
                            + e.getLocalizedMessage());
                        /*
                         * Load an empty Script, otherwise no PLP can be created
                         * and thus the user won't be able to edit the project. 
                         */
                        model = createEmptyModel(projectName, projectVersion, modelType);
                        SemanticErrorDescription description = new SemanticErrorDescription(file.getAbsolutePath(),
                            e.getLocalizedMessage());
                        modelContainer = ModelContainerFactory.createContainer(model, description, location);
                    }
                }
            }
        } else {
            model = createEmptyModel(projectName, projectVersion, modelType);
            modelManagement.updateModel(model, file.toURI());
            SemanticErrorDescription description = null;
            if (file.exists()) {
                // this seems to happen if the IVML file is not named properly -> more helpful message possible?
                LOGGER.warn("File cannot be parsed: " + file.getName());
                description = new SemanticErrorDescription(file.getAbsolutePath(),
                    "File contains syntax errors");
            }
            modelContainer = ModelContainerFactory.createContainer(model, description, location);
        }
        return modelContainer;
    }
    
    /**
     * Creates an empty {@link IModel}, if the specified model could not be loaded.
     * This should prevent {@link NullPointerException}s in the rest of the application.
     * @param projectName The name of the {@link IModel} to load.
     * @param projectVersion The {@link Version} of the {@link IModel} to load.
     * @param modelType Must match to the given {@link IModel} type:
     * <ul>
     * <li>{@link Project} = {@link PathKind#IVML}</li>
     * <li>{@link Script} = {@link PathKind#VIL}</li>
     * </ul>
     * @return An empty {@link IModel}, with the given name.
     */
    @SuppressWarnings("unchecked")
    private Model createEmptyModel(String projectName, String projectVersion, PathKind modelType) {
        Model result = null;
        switch(modelType) {
        case IVML:
            result = (Model) new Project(projectName);
            break;
        case VIL:
            result = (Model) new Script(projectName);
            break;
        default:
            // Not needed
            break;
        }
        
        if (null != result && null != projectVersion) {
            try {
                Version version = new Version(projectVersion);
                result.setVersion(version);
            } catch (VersionFormatException e) {
                LOGGER.exception(e);
            }
        }
        
        return result;
    }
}
