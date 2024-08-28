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

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.basics.progress.ProgressObserver.ITask;
import net.ssehub.easy.dslCore.validation.ValidationUtils;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleDescriptor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.Entity;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.datatypes.Model;
import net.ssehub.easy.producer.core.persistence.datatypes.ModelType;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.persistence.internal.DataStorage;
import net.ssehub.easy.producer.core.persistence.internal.StorageType;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

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
        this.observer = null == observer ? ProgressObserver.NO_OBSERVER : observer;
    }

    /**
     * Loads the default models if existent.
     */
    private void loadDefaultModels() {
        PersistenceUtils.loadDefaultModels(Persistencer.class.getClassLoader(), observer, null);
    }

    @Override
    public PersistentProject load() throws PersistenceException {
        ValidationUtils.enable(false); // prevent interferences with editor validation
        loadDefaultModels();
        Configuration config = PersistenceUtils.getConfiguration(projectFolder);
        /* 
         * Load non ivml data.
         * This data also contains the information which ivml model should be read
         * in case of multiple projects are present.
         */
        PersistentProject project = new PersistentProject(projectFolder);
        ITask task = observer.registerTask("Loading project " + projectFolder.getName());
        observer.notifyStart(task, 4);
        storage.loadModels(project);
        observer.notifyProgress(task, 1);
        //Register the folder of ivml files to the model for dynamic ivml file loading.
        try {
            PersistenceUtils.processLocation(config, true, false, observer);
        } catch (ModelManagementException e) {
            // Should not happen, but it is also not necessarily to throw this exception.
            throw new PersistenceException(e);
        }
        observer.notifyProgress(task, 2);
        // link predecessors as dependent locations for this project
        Model pred = project.getModel(ModelType.PREDECESSORS);
        if (null != pred) {
            for (int e = 0; e < pred.getEntityCount(); e++) {
                String location = pred.getEntity(e).getAttributeValue(PRESUCCESSOR_LOCATION);
                if (null != location) {
                    File fLoc = new File(projectFolder.getParent(), location).getAbsoluteFile();
                    PersistenceUtils.setDependentLocations(projectFolder.getAbsoluteFile(), fLoc, config);
                }
            }
        }
        //Load the main project file for this PersistentProject
        Model rootModel = project.getModel(ModelType.ROOT);
        Entity projectInformation = rootModel.getEntity(0);
        String projectName = projectInformation.getAttributeValue(PTN_PROJECTNAME);
        project.setName(projectName);
        String projectVersion = projectInformation.getAttributeValue(PLP_VERSION);
        if (!Boolean.valueOf(projectInformation.getAttributeValue(PTN_SKIP, "false"))) {
            LOGGER.debug("Loading IVML for \"" + projectName + "\" in " + projectVersion + ".");
            ModelLoader<Project> projectLoader = new ModelLoader<Project>(project, config);
            projectLoader.loadModel(projectName, projectVersion, PathKind.IVML);
            observer.notifyProgress(task, 3);
            LOGGER.debug("Loading VIL/VTL for \"" + projectName + "\" in " + projectVersion + ".");
            ModelLoader<Script> scriptLoader = new ModelLoader<Script>(project, config);
            scriptLoader.loadModel(projectName, projectVersion, PathKind.VIL);
            LOGGER.debug("Loaded Project \"" + projectName + "\" in " + projectVersion + ".");
        }
        observer.notifyProgress(task, 4);
        project.setID(projectInformation.getAttributeValue(PTN_UUID));
        observer.notifyEnd(task);
        ValidationUtils.enable(true);
        return project;
    }
    
    /**
     * Loads a {@link PLPInfo} from a storage (file system).
     * @return The {@link PLPInfo} which should be loaded.
     * @throws PersistenceException In case of an incorrect data format of the configuration file,
     * this exception will be thrown.
     */
    public PLPInfo loadPLP() throws PersistenceException {
        PersistentProject pProject = load();
        PersistentProject2PLPConverter converter = new PersistentProject2PLPConverter(this, pProject);
        return converter.persistentProject2PLP();
    }

    
    @SuppressWarnings("deprecation")
    @Override
    public IProjectCreationResult createProject(String projectName, File parentFolder, String projectID, boolean lazy)
        throws PersistenceException {
        
        ProjectCreationResult result = null;
        File projectFolder = new File(parentFolder, projectName);
        Configuration config = PersistenceUtils.getConfiguration(projectFolder);
        File configFolder = config.getPathFile(PathKind.IVML, 0);
        File scriptFolder = config.getPathFile(PathKind.VIL, 0);
        boolean projectOk;
        if (lazy) {
            // this part is for ScaleLog... it might make sense to check for the files in the EASy folder...
            projectOk = true;
            if (!configFolder.exists()) {
                projectOk = configFolder.mkdirs();
                if (!configFolder.equals(scriptFolder)) {
                    projectOk = scriptFolder.mkdirs();
                }
                File vtlFolder = config.getPathFile(PathKind.VTL, 0);
                if (!scriptFolder.equals(vtlFolder)) {
                    projectOk = vtlFolder.mkdirs();
                }
            }
        } else {
            projectOk = configFolder.mkdirs();
            if (!configFolder.equals(scriptFolder)) {
                projectOk = scriptFolder.mkdirs();
            } 
        }
        if (projectOk) {
            loadDefaultModels();
            // Add location of newly created project to VarModel
            try {
                PersistenceUtils.processLocation(config, true, false, observer);
            } catch (ModelManagementException e) {
                // Should not happen, but it is also not necessarily to throw this exception.
                LOGGER.exception(e);
            }            
            
            // VarModel Information 
            Project varModel = new Project(projectName);
            varModel.setVersion(PersistenceUtils.defaultVersion());
            
            // Build Script
            VariableDeclaration[] declarations = Script.createDefaultParameter();
            Script mainBuildScript = new Script(projectName, declarations);
            mainBuildScript.setVersion(PersistenceUtils.defaultVersion());
            Rule main = new Rule("main", false, declarations, new RuleDescriptor(), mainBuildScript);
            mainBuildScript.addRule(main);
            
            PersistentProject pProject = new PersistentProject(varModel, projectFolder, configFolder);
            pProject.setScript(new ScriptContainer(mainBuildScript, null, config, true));
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
        
        // Old way to save EASy, would be nice to remove the whole PersitentProject stuff
        save(project);
        
        // Write debug information
        writeDebugData(plp);
    }

    /**
     * Writes debug data to file system, if and only if {@link PLPInfo#getSaveDebugInformation()} was set
     * to <code>true</code>. Part of the {@link #save(PLPInfo)} method. 
     * @param plp the information, which should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    private void writeDebugData(PLPInfo plp) throws PersistenceException {
        if (plp.getSaveDebugInformation()) {
            Configuration config = PersistenceUtils.getConfiguration(plp.getProjectLocation());
            // as before, just use the first location, the others only for resolution
            String projectPath = config.getPathFile(PathKind.IVML, 0).getAbsolutePath();

            // Save debug information from configuration
            // Save Configuration in same folder as the project
            try {
                /*
                 * debug == true -> onlyUserInput == false
                 */
                Project debugedConfig = plp.getConfiguration().toProject(true, false);
                PersistenceUtils.writeIVMLProject(debugedConfig, projectPath, true);
            } catch (ConfigurationException e) {
                LOGGER.exception(e);
            }
            
        }
    }
    
    /**
     * Saves given EASy to storage.
     * 
     * @param project the information, which should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    private void save(PersistentProject project) throws PersistenceException {
        Configuration config = PersistenceUtils.getConfiguration(project.getLocation());
        // as before, just use the first location, the others only for resolution
        String projectPath = config.getPathFile(PathKind.IVML, 0).getAbsolutePath();
        String scriptPath = config.getPathFile(PathKind.VIL, 0).getAbsolutePath();
        
        // Write the ivml data
        ProjectContainer ivmlProject = project.getProject();
        if (ivmlProject.isSaveable()) {
            PersistenceUtils.writeIVMLProject(ivmlProject.getModel(), projectPath);
        }
        
        // Write the VIL data
        ScriptContainer buildScript = project.getMainBuildScript();
        if (buildScript.isSaveable()) {
            PersistenceUtils.writeVILScript(buildScript.getModel(), scriptPath);
            buildScript.setEdited(false);
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
        File configFolder = PersistenceUtils.getLocationFile(projectFolder, PathKind.IVML);
        // TODO SE: check is overriding the attribute storage really intended here???
        storage = new DataStorage(StorageType.XML, configFolder.getAbsolutePath(), pathEnv);
        return storage.getProjectID();
    }

    @Override
    public void update() throws PersistenceException {
        try {
            Configuration config = PersistenceUtils.getConfiguration(projectFolder);
            // use absolute locations?
            PersistenceUtils.updateLocations(config, PathKind.IVML, VarModel.INSTANCE.locations(), observer);
            PersistenceUtils.updateLocations(config, PathKind.VIL, BuildModel.INSTANCE.locations(), observer);
            PersistenceUtils.updateLocations(config, PathKind.VTL, TemplateModel.INSTANCE.locations(), observer);
        } catch (ModelManagementException e) {
            throw new PersistenceException(e.getMessage());
        }
    }

    @Override
    public PathEnvironment getPathEnvironment() {
        return storage.getPathEnvironment();
    }

}
