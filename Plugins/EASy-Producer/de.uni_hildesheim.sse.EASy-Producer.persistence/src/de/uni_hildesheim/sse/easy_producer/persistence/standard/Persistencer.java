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

package de.uni_hildesheim.sse.easy_producer.persistence.standard;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Rule;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.RuleDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.IProjectCreationResult;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.DataStorage;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.StorageType;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.modelManagement.ProjectContainer;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelContainer.SemanticErrorDescription;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * This class represents an interlayer between persistency-layer and model. It provides functions
 * for loading a model from the storage or saving it to storage. Therefore it performs a conversion
 * between the persistency model and the application model.   
 * 
 * @author El-Sharkawy
 */
public class Persistencer implements IPersistencer, PersistenceConstants {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(Persistencer.class,
        Activator.PLUGIN_ID);
    
    private DataStorage storage;
    private ProgressObserver observer;
    private File projectFolder;

    /**
     * Sole constructor for this class for saving/reading persistence information out of a xml file.
     * @param pathEnv a path environment for making files and paths relative
     * @param projectFolder The location of the product line project.
     * @param storageFile The absolute path of the file, which should be read/be written.
     * for loading (nested) ivml models.
     * @param observer a progress observer, may be {@link ProgressObserver#NO_OBSERVER}
     */
    public Persistencer(PathEnvironment pathEnv, File projectFolder, String storageFile, ProgressObserver observer) {
        this.projectFolder = projectFolder;
        storage = new DataStorage(StorageType.XML, storageFile, pathEnv);
        this.observer = observer;
    }

    @Override
    public PersistentProject load() throws PersistenceException {
        File configFolder = PersistenceUtils.getConfigLocationFile(projectFolder);
        File scriptFolder = PersistenceUtils.getScriptLocationFile(projectFolder);
        String configPath = configFolder.getAbsolutePath();
        String scriptPath = scriptFolder.getAbsolutePath();
        
        /* 
         * Load non ivml data.
         * This data also contains the information which ivml model should be read
         * in case of multiple projects are present.
         */
        PersistentProject project = new PersistentProject(projectFolder);
        storage.loadModels(project);
        
        //Register the folder of ivml files to the model for dynamic ivml file loading.
        try {
            PersistenceUtils.addLocation(configFolder, scriptFolder, observer);
        } catch (ModelManagementException e) {
            // Should not happen, but it is also not necessarily to throw this exception.
            throw new PersistenceException(e);
        }

        //Load the main project file for this PersistentProject
        Model rootModel = project.getModel(ModelType.ROOT);
        Entity projectInformation = rootModel.getEntity(0);
        String projectName = projectInformation.getAttributeValue(PTN_PROJECTNAME);
        project.setName(projectName);
        String projectVersion = projectInformation.getAttributeValue(PLP_VERSION);
        LOGGER.debug("Loaded Project \"" + projectName + "\" in " + projectVersion + ".");
        loadVarModel(configPath, project, projectName, projectVersion);
        loadBuildModel(scriptPath, project, projectName, projectVersion);

        return project;
    }

    /**
     * Loads the IVML variability model during the {@link #load()} method.
     * @param folderPath The config folder where the variability model should be stored in.
     * @param project The result of the {@link #load()} method.
     * @param projectName The name of the EASy project containing the variability project.
     * @param projectVersion The desired version which shall be loaded.
     * @throws PersistenceException Will be thrown if an error occurred during
     *     the {@link VarModel#load(ModelInfo)} operation.
     */
    private void loadVarModel(String folderPath, PersistentProject project, String projectName, String projectVersion)
        throws PersistenceException {
        
        String fileName = PersistenceUtils.ivmlFileLocation(projectName, projectVersion, folderPath);
        File file = new File(fileName);
        Project ivmlProject = null;
        ModelInfo<Project> info = null;
        ProjectContainer varModel = null;
        try {
            info = VarModel.INSTANCE.availableModels().getModelInfo(projectName, projectVersion, file.toURI());
        } catch (VersionFormatException e) {
            throw new PersistenceException(e);
        }
        if (null != info) {
            LOGGER.debug("Info found: " + info.toString());
            try {
                ivmlProject = VarModel.INSTANCE.load(info);
                varModel = new ProjectContainer(ivmlProject, new File(folderPath));
                LOGGER.debug("Info loaded: " + info.toString());
            } catch (ModelManagementException e) {
                if (e.getId() == ModelManagementException.INTERNAL) {
                    throw new PersistenceException(e);
                } else {
                    LOGGER.warn("Info could not be loaded: " + e.getLocalizedMessage());
                    /*
                     * Load an empty project, otherwise no PLP can be created
                     * and thus the user won't be able to edit the project. 
                     */
                    ivmlProject = new Project(projectName);
                    SemanticErrorDescription description = new SemanticErrorDescription(file.getAbsolutePath(),
                        e.getLocalizedMessage());
                    varModel = new ProjectContainer(ivmlProject, description, new File(folderPath));
                }
            }
        } else {
            ivmlProject = new Project(projectName);
            ivmlProject.setVersion(new Version(0));
            VarModel.INSTANCE.updateModel(ivmlProject, file.toURI());
            SemanticErrorDescription description = null;
            if (file.exists()) {
                LOGGER.warn("File could not be parsed");
                description = new SemanticErrorDescription(file.getAbsolutePath(),
                    "File contains syntax errors");
            }
            varModel = new ProjectContainer(ivmlProject, description, new File(folderPath));
        }
        project.setVarModel(varModel);
    }
    
    /**
     * Loads the VIL build script during the {@link #load()} method.
     * @param folderPath The config folder where the build script should be stored in.
     * @param project The result of the {@link #load()} method.
     * @param projectName The name of the EASy project containing the build script.
     * @param projectVersion The desired version which shall be loaded.
     * @throws PersistenceException Will be thrown if an error occurred during
     *     the {@link VarModel#load(ModelInfo)} operation.
     */
    private void loadBuildModel(String folderPath, PersistentProject project, String projectName, String projectVersion)
        throws PersistenceException {
        
        String fileName = PersistenceUtils.vilFileLocation(projectName, projectVersion, folderPath);
        File file = new File(fileName);
        Script buildScript = null;
        ModelInfo<Script> info = null;
        ScriptContainer instantiationModel = null;
        try {
            info = BuildModel.INSTANCE.availableModels().getModelInfo(projectName, projectVersion, file.toURI());
        } catch (VersionFormatException e) {
            throw new PersistenceException(e);
        }
        if (null != info) {
            LOGGER.debug("Found: " + info.toString());
            try {
                buildScript = BuildModel.INSTANCE.load(info);
                instantiationModel = new ScriptContainer(buildScript, new File(folderPath));
                LOGGER.debug("Info loaded: " + info.toString());
            } catch (ModelManagementException e) {
                if (e.getId() == ModelManagementException.INTERNAL) {
                    throw new PersistenceException(e);
                } else {
                    LOGGER.warn("Info could not be loaded: " + e.getLocalizedMessage());
                    /*
                     * Load an empty Script, otherwise no PLP can be created
                     * and thus the user won't be able to edit the project. 
                     */
                    buildScript = new Script(projectName);
                    SemanticErrorDescription description = new SemanticErrorDescription(file.getAbsolutePath(),
                        e.getLocalizedMessage());
                    instantiationModel = new ScriptContainer(buildScript, description, new File(folderPath));
                }
            }
        } else {
            buildScript = new Script(projectName);
            buildScript.setVersion(new Version(0));
            BuildModel.INSTANCE.updateModel(buildScript, file.toURI());
            SemanticErrorDescription description = null;
            if (file.exists()) {
                LOGGER.warn("File could not be parsed");
                description = new SemanticErrorDescription(file.getAbsolutePath(),
                    "File contains syntax errors");
            }
            instantiationModel = new ScriptContainer(buildScript, description, new File(folderPath));
        }
        project.setScript(instantiationModel);
    }
    
    @SuppressWarnings("deprecation")
    @Override
    public IProjectCreationResult createProject(String projectName, File parentFolder, String projectID, boolean lazy)
        throws PersistenceException {
        
        ProjectCreationResult result = null;
        File projectFolder = new File(parentFolder, projectName);
        File configFolder = PersistenceUtils.getConfigLocationFile(projectFolder);
        File scriptFolder = PersistenceUtils.getScriptLocationFile(projectFolder);
        boolean projectOk;
        if (lazy) {
            // this part is for ScaleLog... it might make sense to check for the files in the EASy folder...
            projectOk = true;
            if (!projectFolder.exists()) {
                projectOk = configFolder.mkdirs();
                if (!configFolder.equals(scriptFolder)) {
                    projectOk = scriptFolder.mkdirs();
                }                
            }
        } else {
            projectOk = configFolder.mkdirs();
            if (!configFolder.equals(scriptFolder)) {
                projectOk = scriptFolder.mkdirs();
            } 
        }
        
        if (projectOk) {
            // Add location of newly created project to VarModel
            try {
                PersistenceUtils.addLocation(configFolder, scriptFolder, observer);
            } catch (ModelManagementException e) {
                // Should not happen, but it is also not necessarily to throw this exception.
                LOGGER.exception(e);
            }            
            
            // VarModel Information 
            Project varModel = new Project(projectName);
            varModel.setVersion(PersistenceUtils.defaultVersion());
            
            // Build Script
            VariableDeclaration[] declarations = Script.createDefaultParameter();
            Script mainBuildScript = new Script(projectName, null, declarations, null, null);
            mainBuildScript.setVersion(PersistenceUtils.defaultVersion());
            Rule main = new Rule("main", new RuleDescriptor(declarations), false, mainBuildScript);
            mainBuildScript.addRule(main);
            
            PersistentProject pProject = new PersistentProject(varModel, projectFolder, configFolder);
            pProject.setScript(new ScriptContainer(mainBuildScript, scriptFolder));
            pProject.setID(projectID);
            pProject.setName(projectName);
            save(pProject);
            
            // Register newly created varModel (ivml project).
            String configPath = configFolder.getAbsolutePath();
            String scriptPath = scriptFolder.getAbsolutePath();
            File configFile = new File(PersistenceUtils.ivmlFileLocation(varModel, configPath));
            VarModel.INSTANCE.updateModel(varModel, configFile.toURI());
            File buildFile = new File(PersistenceUtils.vilFileLocation(mainBuildScript, scriptPath));
            BuildModel.INSTANCE.updateModel(mainBuildScript, buildFile.toURI());
            
            result = new ProjectCreationResult(projectFolder, projectID, configFile, varModel, mainBuildScript);
        } else {
            throw new PersistenceException("System cannot create folders for the new project at the specified location:"
                + " " + parentFolder);
        }
        
        return result;
    }

    /**
     * Saves given EASy to storage.
     * 
     * @param plp the information, which should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    @Override
    public void save(PLPInfo plp) throws PersistenceException {
        PLP2ProjectConverter converter = new PLP2ProjectConverter(plp, this);
        PersistentProject project = converter.plp2PersistentProject();
        save(project);
    }
    
    /**
     * Saves given EASy to storage.
     * 
     * @param project the information, which should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    private void save(PersistentProject project) throws PersistenceException {
        String projectPath = PersistenceUtils.getConfigLocationAbsolutePath(project.getLocation());
        String scriptPath = PersistenceUtils.getScriptLocationAbsolutePath(project.getLocation());
        //Write the ivml data
        ProjectContainer ivmlProject = project.getProject();
        if (ivmlProject.isSaveable()) {
            PersistenceUtils.writeIVMLProject(ivmlProject.getModel(), projectPath);
        }
        //Write the VIL data
        ScriptContainer buildScript = project.getMainBuildScript();
        if (buildScript.isSaveable()) {
            PersistenceUtils.writeVILScript(buildScript.getModel(), scriptPath);
        }
        
        //Write the non ivml data
        storage.saveModels(project);  
    }

    /**
     * Returns the ID of a given EASy project.
     * 
     * @return the id or <b>null</b> if the specified project has no configuration file.
     */
    @Override
    public String getProjectID() {
        PathEnvironment pathEnv = storage.getPathEnvironment();
        File configFolder = PersistenceUtils.getConfigLocationFile(projectFolder);
        // TODO SE: check is overriding the attribute storage really intended here???
        storage = new DataStorage(StorageType.XML, configFolder.getAbsolutePath(), pathEnv);
        return storage.getProjectID();
    }

    @Override
    public void update() throws PersistenceException {
        try {
            File configFolder = PersistenceUtils.getConfigLocationFile(projectFolder);
            File scriptFolder = PersistenceUtils.getScriptLocationFile(projectFolder);
            VarModel.INSTANCE.locations().updateLocation(configFolder, observer);
            BuildModel.INSTANCE.locations().updateLocation(scriptFolder, observer);
            TemplateModel.INSTANCE.locations().updateLocation(scriptFolder, observer);
        } catch (ModelManagementException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public PathEnvironment getPathEnvironment() {
        return storage.getPathEnvironment();
    }

}
