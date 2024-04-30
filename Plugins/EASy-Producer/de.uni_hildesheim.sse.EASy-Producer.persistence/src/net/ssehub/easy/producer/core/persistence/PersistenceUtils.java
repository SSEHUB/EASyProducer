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

package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.io.FileUtils;
import net.ssehub.easy.basics.io.JarUtils;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelLocations;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.DefaultLib;
import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.IModelAccessor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.AbstractRule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildlangWriter;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ForStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.InstantiateExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Utils;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypes;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.Entity;
import net.ssehub.easy.producer.core.persistence.datatypes.Model;
import net.ssehub.easy.producer.core.persistence.datatypes.ModelType;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.persistence.internal.DataStorage;
import net.ssehub.easy.producer.core.persistence.internal.StorageType;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExpressionVersionRestriction;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * Static utility functions related to the persistence layer.
 * @author El-Sharkawy
 *
 */
public class PersistenceUtils {

    /**
     * Notification by the instantiator controller:
     * No multiple instantiated files message.
     */
    public static final String INSTANTIATOR_CONTROLLER_MULTIPLE = "No file will be instantiated by multiple engines";
    
    private static final String DEBUG_FILES_EXTENSION = "_debug";
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, 
        Activator.PLUGIN_ID);
    
    private static final Map<String, Configuration> CONFIGURATIONS = new HashMap<String, Configuration>();
    
    private static boolean defaultModelsLoaded = false;
    
    /**
     * Returns the (cached) configuration for the given project (in terms of a <code>projectFolder</code>).
     * 
     * @param projectFolder the project folder representing the project
     * @return the configuration of the project
     */
    public static final Configuration getConfiguration(File projectFolder) {
        Configuration result;
        if (null == projectFolder) {
            // pathological case - occurred in some tests
            result = new Configuration(Configuration.DEFAULT);
        } else {
            try {
                projectFolder = projectFolder.getCanonicalFile();
            } catch (IOException e) {
                LOGGER.info("invalid project path - using default configuration: " + projectFolder);
            }
            String key = projectFolder.getPath();
            result = CONFIGURATIONS.get(key);
            if (null == result) {
                result = new Configuration(projectFolder);
                CONFIGURATIONS.put(key, result);
            } else {
                result.checkForModification();
            }
        }
        return result;
    }
    
    /**
     * Closes a project, i.e., removes its configuration from the internal cache.
     * 
     * @param projectFolder the project folder representing the project
     */
    public static final void closeProject(File projectFolder) {
        if (null != projectFolder) {
            try {
                CONFIGURATIONS.remove(projectFolder.getCanonicalFile().getPath());
            } catch (IOException e) {
                LOGGER.info("invalid project path - ignoring close request: " + projectFolder);
            }
        } // pathological case - occurred in some tests    
    }
    
    /**
     * Updates the paths.
     * 
     * @param config the configuration instance to use
     * @param kind the path kind
     * @param locations the target model locations
     * @param observer the progress observer to use
     * @throws ModelManagementException if updating the locations fails
     */
    public static void updateLocations(Configuration config, PathKind kind, ModelLocations<?> locations, 
        ProgressObserver observer) throws ModelManagementException {
        for (int p = 0; p < config.getPathCount(kind); p++) {
            locations.updateLocation(config.getPathFile(kind, p), observer);
        }
    }

    /**
     * Updates the paths.
     * 
     * @param config the configuration instance to use
     * @param kind the path kind
     * @param locations the target model locations
     * @param observer the progress observer to use
     * @throws ModelManagementException if updating the locations fails
     */
    public static void addLocations(Configuration config, PathKind kind, ModelLocations<?> locations, 
        ProgressObserver observer) throws ModelManagementException {
        for (int p = 0; p < config.getPathCount(kind); p++) {
            locations.addLocation(config.getPathFile(kind, p), observer);
        }
    }
        
    /**
     * Adds the given location to {@link VarModel}, {@link BuildModel}, and {@link TemplateModel}.
     * @param config the configuration to use for obtaining the folders
     * @param observer observer a progress observer, may be {@link ProgressObserver#NO_OBSERVER}
     * @throws ModelManagementException - in case that the available information may become
     *     inconsistent due to the new location (if more than one exception is created, the last one will be returned)
     */
    public static final void addLocation(Configuration config, ProgressObserver observer)
        throws ModelManagementException {
        ModelManagementException returnExc = null;
        try {
            addLocations(config, PathKind.IVML, VarModel.INSTANCE.locations(), observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        try {
            addLocations(config, PathKind.VIL, BuildModel.INSTANCE.locations(), observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        try {
            addLocations(config, PathKind.VTL, TemplateModel.INSTANCE.locations(), observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        
        for (IModelAccessor<?> accessor : TopLevelModelAccessor.registered()) {
            PathKind kind = PathKind.valueOf(accessor.getPathKindHint());
            if (null == kind) {
                kind = PathKind.IVML;
            }
            for (int p = 0; p < config.getPathCount(kind); p++) {
                try {
                    accessor.addLocation(config.getPathFile(kind, p).getAbsoluteFile(), observer);
                } catch (ModelManagementException exc) {
                    returnExc = exc;
                }
            }
        }
        
        if (null != returnExc) {
            throw returnExc;
        }
    }
    
    /**
     * Returns the specified location within the given <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @param kind the path kind
     * @return the configuration location as a subpath of <code>projectFolder</code>
     */
    public static final File getLocationFile(File projectFolder, PathKind kind) {
        return getConfiguration(projectFolder).getPathFile(kind, 0);
    }
    
    /**
     * This method locates the configuration file for non ivml information within the given storage path.
     * @param storagePath The storage path, where the configuration file should be placed.
     * @return The absolute path of the configuration file within the give folder path.
     */
    public static final String storageFileLocation(String storagePath) {
        return storagePath + System.getProperty("File.Separator") + PersistenceConstants.CONFIG_FILE;
    }
    
    /**
     * This method locates the project file for the ivml variability model for a specific ivml project
     * within the given storage path.
     * 
     * @param project The ivml project which should be read/saved
     * @param storagePath The location (top level folder) of the configuration files
     * @return The absolute path for the file to be written/read.
     */
    public static final String ivmlFileLocation(Project project, String storagePath) {
        String projectName = project.getQualifiedName();
        String projectVersion = null;
        Version version = project.getVersion();
        if (null != version) {
            projectVersion = version.getVersion();
        }
        
        return ivmlFileLocation(projectName, projectVersion, storagePath);
    }
    
    /**
     * This method locates the project file for the VIL variability model for a specific EASy project
     * within the given storage path.
     * 
     * @param buildScript The VIL build script project which should be read/saved
     * @param storagePath The location (top level folder) of the configuration files
     * @return The absolute path for the file to be written/read.
     */
    public static final String vilFileLocation(Script buildScript, String storagePath) {
        String projectName = buildScript.getName();
        String projectVersion = null;
        Version version = buildScript.getVersion();
        if (null != version) {
            projectVersion = version.getVersion();
        }
        
        return vilFileLocation(projectName, projectVersion, storagePath);
    }
    
    /**
     * This method locates the project file for the ivml variability model for a specific ivml project
     * within the given storage path.
     * 
     * @param projectName The qualified name of the ivml project which should be read/saved
     * @param projectVersion The version of the ivml project which should be read/saved, can be <code>null</code>.
     * @param storagePath The location (top level folder) of the configuration files
     * @return The absolute path for the file to be written/read.
     */
    public static final String ivmlFileLocation(String projectName, String projectVersion, String storagePath) {
        return modelFileLocation(projectName, projectVersion, storagePath, ".ivml");
    }
    
    /**
     * This method locates the project file for the VIL build script model for a specific EASy project
     * within the given storage path.
     * 
     * @param projectName The qualified name of the VIL build script project which should be read/saved
     * @param projectVersion The version of the VIL build script project which should be read/saved,
     *     can be <code>null</code>.
     * @param storagePath The location (top level folder) of the configuration files
     * @return The absolute path for the file to be written/read.
     */
    public static final String vilFileLocation(String projectName, String projectVersion, String storagePath) {
        return modelFileLocation(projectName, projectVersion, storagePath, ".vil");
    }
    
    /**
     * This method locates the file for a IVML/VIL model for a specific EASy project
     * within the given folder.
     * 
     * @param projectName The qualified name of the model which should be read/saved
     * @param projectVersion The version of the model which should be read/saved,
     *     can be <code>null</code>.
     * @param folder The location (top level folder) of the configuration files
     * @param modelType Either {@link PathKind#IVML} or {@link PathKind#VIL}
     * @return The absolute path for the file to be written/read.
     */
    public static final String modelFileLocation(String projectName, String projectVersion, String folder,
        PathKind modelType) {
        
        String result = "";
        switch(modelType) {
        case IVML:
            result = ivmlFileLocation(projectName, projectVersion, folder);
            break;
        case VIL:
            result = vilFileLocation(projectName, projectVersion, folder);
            break;
        case VTL:
            result = new File(folder, projectName + "vtl").getAbsolutePath();
            break;
        default:
            // Not needed
            break;
        }
        
        return result;
    }
    
    /**
     * This method locates the project file for the ivml/vil model for a specific EASy project
     * within the given storage path.
     * 
     * @param projectName The qualified name of the model project which should be read/saved
     * @param projectVersion The version of the model project which should be read/saved, can be <code>null</code>.
     * @param storagePath The location (top level folder) of the configuration files
     * @param extension The file extension (<code>".ivml"</code> for IVML files, or <code>".vil"</code>)
     * @return The absolute path for the file to be written/read.
     */
    public static final String modelFileLocation(String projectName, String projectVersion, String storagePath,
        String extension) {
        
        File file = new File(storagePath);
        StringBuffer fileName = new StringBuffer(projectName.replaceAll("::", "_"));
        if (null != projectVersion) {
            fileName.append("_");      
            fileName.append(projectVersion.replaceAll("\\.", "-"));
        }
        fileName.append(extension);
        file = new File(file, fileName.toString());
        
        String location = file.getAbsolutePath();
        LOGGER.debug("Model file to load: " + location);
        
        return location;
    }
    
    /**
     * Loads a specific model.
     * 
     * @param pathEnv the path environment for making absolute paths relative
     * @param location the location containing the data
     * @param type the type of the model
     * @return the model
     * @throws PersistenceException in case of reading errors
     */
    public static final Model loadModel(PathEnvironment pathEnv, String location, ModelType type) 
        throws PersistenceException {
        DataStorage storage = new DataStorage(StorageType.XML, location, pathEnv);
        Model model = new Model(type);
        storage.loadModels(model);
        return model;
    }
    
    /**
     * Loads the information of the root product line project from the configuration at the given location.
     * 
     * @param pathEnv the environment for making locations absolute and relative
     * @param modelLocation the location to load the information from
     * @param projectLocation an optional location where the related PLP is (in case of temporary loading, this enables
     *    relocation)
     * @return the product line project information
     */
    public static final PLPInfo loadRootPLPInfo(PathEnvironment pathEnv, String modelLocation, File projectLocation) {
        PLPInfo result = null;
        try {
            Model model = loadModel(pathEnv, modelLocation, ModelType.ROOT);
            if (null != model && model.getEntityCount() > 0) {
                Entity entity = model.getEntity(0);
                String uuid = entity.getAttributeValue(PersistenceConstants.PTN_UUID);
                String projectName = entity.getAttributeValue(PersistenceConstants.PTN_PROJECTNAME);
                String version = entity.getAttributeValue(PersistenceConstants.PLP_VERSION);
                if (null == projectLocation) {
                    String tmp = entity.getAttributeFileString(PersistenceConstants.PLP_LOCATION);
                    projectLocation = pathEnv.makeAbsolute(tmp);
                }
                if (projectLocation.isFile()) {
                    result = new PLPInfo(uuid, projectName, version, new File(modelLocation), projectLocation);
                } else {
                    result = new PLPInfo(uuid, projectName, version, projectLocation);
                }
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * Writes the IVML Variability model of the
     * {@link net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject} to the file system.
     * @param project The IVML {@link Project} which should be saved.
     * @param storagePath The folder, where the file should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public static void writeIVMLProject(Project project, String storagePath) throws PersistenceException { 
        writeIVMLProject(project, storagePath, false);
    }
    
    /**
     * Writes the IVML Variability model of the
     * {@link net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject} to the file system.
     * @param project The IVML {@link Project} which should be saved.
     * @param storagePath The folder, where the file should be saved.
     * @param debug If <code>true</code> The String "_debug" will be added to the file's name.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public static void writeIVMLProject(Project project, String storagePath, boolean debug)
        throws PersistenceException {       
        
        File file = new File(PersistenceUtils.ivmlFileLocation(project, storagePath));
        
        if (debug) {
            File folder = file.getParentFile();
            String fileName = file.getName();
            int lastDot = fileName.lastIndexOf('.');
            String preName = fileName.substring(0, lastDot);
            String sufName = fileName.substring(lastDot, fileName.length());
            fileName = preName + DEBUG_FILES_EXTENSION + sufName;
            
            file = new File(folder, fileName);
        }
        
        /*
         * One file can contain multiple projects. In this case, the old projects must not be deleted.
         * The loop below tries to identify all projects of the file and tries to keep them (save them again).
         * the loop also tries to keep the origin ordering of the projects.
         */
        URI location = file.toURI();
        List<ModelInfo<Project>> oldProjects = VarModel.INSTANCE.availableModels().getVisibleModelInfo(location);
        List<Project> allProjects = new ArrayList<Project>();
        boolean projectAdded = false;
        // Add all not changed projects of the origin file to the list of allProjects (keep ordering)
        if (null != oldProjects && !oldProjects.isEmpty()) {
            for (int i = 0; i < oldProjects.size(); i++) {
                ModelInfo<Project> info = oldProjects.get(i);
                if (info.getName().equals(project.getName())
                    && Version.equals(info.getVersion(), project.getVersion())) {
                    
                    allProjects.add(project);
                    projectAdded = true;
                } else if (info.isResolved() && info.getLocation().equals(location)
                    && !info.getName().equals(project.getName())) {
                    
                    allProjects.add(info.getResolved());
                }
            }
        }
        if (!projectAdded) {
            allProjects.add(project);            
        }
        
        //Save project in filesystem
        if (file.exists()) {
            file.delete();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            IVMLWriter writer = new IVMLWriter(fileWriter);
            allProjects.get(0).accept(writer);                
            for (int i = 1; i < allProjects.size(); i++) {
                fileWriter.append(IvmlKeyWords.LINEFEED);
                allProjects.get(i).accept(writer);                
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }
    
    /**
     * Writes the IVML Variability model of the
     * {@link net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject} to the file system.
     * @param buildScript The VIL build script project which should be saved
     * @param storagePath The folder, where the file should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public static void writeVILScript(Script buildScript, String storagePath) throws PersistenceException {       
        //Save project in filesystem
        File file = new File(PersistenceUtils.vilFileLocation(buildScript, storagePath));
        if (file.exists()) {
            file.delete();
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BuildlangWriter writer = new BuildlangWriter(fileWriter);
            buildScript.accept(writer);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            throw new PersistenceException(e);
        } catch (VilException e) {
            throw new PersistenceException(e);
        }
    }
    
    /**
     * Creates a new IVML project.
     * @param projectName Name of the project.
     * @param version Version of the project.
     * @param storagePath The folder, where the file should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public static void createIVMLProject(String projectName, Version version, String storagePath)
        throws PersistenceException {
        
        Project project = new Project(projectName);
        if (null != version) {
            project.setVersion(version);
        }
        
        writeIVMLProject(project, storagePath);
    }
    
    
    /**
     * Creates a new {@link Version}, which should be used for the creation of new
     * EASy config files (variability models, build scripts, and templates).
     * @return A new version instance.
     */
    public static final Version defaultVersion() {
        return new Version(0);
    }
    
    /**
     * Loads an {@link IModel} from a file, i.e. a IVML project, a VIL script, or a VTL template.
     * This also adds the the parent folder of the file to {@link ModelManagement#locations()}.
     * @param modelManagement A {@link ModelManagement}, i.e. {@link VarModel#INSTANCE}, {@link BuildModel#INSTANCE},
     *     or {@link TemplateModel#INSTANCE}. Please be aware of that the correct model is used in respect to the
     *     desired file, which should be loaded by the model.
     * @param modelFile The model file which should be loaded, must be of the type of the used {@link ModelManagement}.
     * @param <M> The type handled by the given {@link ModelManagement}, i.e. {@link Project}, {@link Script},
     *     or {@link net.ssehub.easy.instantiation.core.model.templateModel.Template}
     * @return The loaded (and parsed) model.
     * @throws ModelManagementException In case of any error during loading the file.
     */
    public static<M extends IModel> M loadModel(ModelManagement<M> modelManagement, File modelFile)
        throws ModelManagementException {
        
        modelManagement.locations().updateLocation(modelFile.getParentFile(), ProgressObserver.NO_OBSERVER);
        modelManagement.updateModelInformation(modelFile, ProgressObserver.NO_OBSERVER);
        ModelInfo<M> info = modelManagement.availableModels().getInfo(modelFile.toURI());
        return modelManagement.load(info);
    }
    
    /**
     * (Re-)Loads all variability models of the specified {@link PLPInfo} from the file system.
     * @param plp A {@link PLPInfo} containing saved models which should be (re-) loaded from the file system
     */
    public static void refreshModels(PLPInfo plp) {
        try {
            VarModel.INSTANCE.updateModelInformation(plp.getConfigLocation(), ProgressObserver.NO_OBSERVER);
            BuildModel.INSTANCE.updateModelInformation(plp.getScriptLocation(), ProgressObserver.NO_OBSERVER);
            TemplateModel.INSTANCE.updateModelInformation(plp.getTemplateLocation(), ProgressObserver.NO_OBSERVER);
            if (null != plp.getProject()) {
                VarModel.INSTANCE.resolveImports(plp.getProject(), plp.getConfigLocation().toURI(), null);
            }
            if (null != plp.getBuildScript()) {
                BuildModel.INSTANCE.resolveImports(plp.getBuildScript(), plp.getScriptLocation().toURI(), null);
            }
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        } catch (NullPointerException e) {
            LOGGER.exception(e);
        }
    }
    
    /**
     * Creates a (new) build script inside <code>plp</code>. This build script will only call build script from all
     * predecessor projects and will instantiate their stuff into <code>plp</code>.<br/>
     * In this case, this method tries to add a "instantiate all predecessors" call to the main rule.
     * @param plp The newly created Project where a new main build script shall be created.
     * @param parentPLPs Predecessor projects which shall be instantiated into the newly created project.
     */
    public static void createInstantiatePredecessorScript(PLPInfo plp, PLPInfo... parentPLPs) {
        Script mainScript = plp.getBuildScript();
        AbstractRule mainRule = mainScript.getMainRule(true);
        
        if (null != parentPLPs) {
            for (int j = 0, n = parentPLPs.length; j < n; j++) {
                Script parentScript = parentPLPs[j].getBuildScript();
                Script resolved = null;
                for (int i = 0; i < mainScript.getImportsCount() && resolved == null; i++) {
                    ModelImport<?> scriptImport = mainScript.getImport(i);
                    if (scriptImport.getName().equals(parentScript.getName())) {
                        resolved = (Script) scriptImport.getResolved();
                    }
                }
                if (null == resolved) {
                    addScriptImportToPLP(plp, parentPLPs[j]);
                    BuildModel.INSTANCE.resolveImports(mainScript, null, null);
                    for (int i = 0; i < mainScript.getImportsCount() && resolved == null; i++) {
                        ModelImport<?> scriptImport = mainScript.getImport(i);
                        if (scriptImport.getName().equals(parentScript.getName())) {
                            resolved = (Script) scriptImport.getResolved();
                        }
                    }
                }
                
                if (null != resolved) {
                    
                    // If empty, call "instantiate p : source.predecessors()"
                    if (mainRule.getBodyElementCount() == 0) {
                        try {
                            // Create variable for iteration
                            VariableDeclaration p = new VariableDeclaration("predecessor", IvmlTypes.projectType());
                            
                            // Create: source.predecessors()
                            Expression sourceVar = new VariableExpression(mainRule.getParameter(0));
                            Expression predecessorAccess = new CallExpression(mainRule, "predecessors", sourceVar);
                            // Resolve expression
                            predecessorAccess.inferType();
                            
                            // Create body: instantiate call
                            CallArgument sourceProject = new CallArgument(new VariableExpression(p));
                            CallArgument config = new CallArgument(new VariableExpression(mainRule.getParameter(1)));
                            CallArgument targetProject
                                = new CallArgument(new VariableExpression(mainRule.getParameter(2)));
                            Expression forBody = new InstantiateExpression(p, null, null, sourceProject, config,
                                targetProject);
                            // Resolve expression
                            forBody.inferType();
                            
                            // Create for each loop
                            ExpressionStatement bodyStatement = new ExpressionStatement(forBody);
                            VariableDeclaration[] mapVariables = {p};
                            ForStatement forEachLoop = new ForStatement(mapVariables, predecessorAccess,
                                new IRuleElement[]{bodyStatement}, new TypeDescriptor[] {p.getType()} , true);
                            //ExpressionStatement mapStatement = new ExpressionStatement(map);
                            
                            // Set body of main rule
                            mainRule.setBody(new IRuleElement[] {forEachLoop});
                            // If changes where successful (no exception occurred, notify model that script was edited.
                            plp.buildScriptWasEdited();
                        } catch (VilException e) {
                            LOGGER.warn("Rule could not be modified. Reason: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Adds an import to the {@link net.ssehub.easy.varModel.model.Project} and to the {@link Script} of a given
     * {@link PLPInfo} to the {@link net.ssehub.easy.varModel.model.Project} and {@link Script} of a predecessor
     * project.
     * 
     * @param plp the product line project to add the import to
     * @param predecessor A predecessor project of plp, where the {@link net.ssehub.easy.varModel.model.Project}
     *     <b>and</b> the {@link Script} should be included.
     * @param considerVIL <code>true</code> if the parent project has also a build script which should be considered,
     *     <code>false</code> otherwise
     */
    public static final void addImport(PLPInfo plp, PLPInfo predecessor, boolean considerVIL) {
        String projectName = (null != predecessor.getProject()) ? predecessor.getProject().getName()
            : predecessor.getProjectName();
        boolean hasProjectVersion = null != predecessor.getProject() && null != predecessor.getProject().getVersion();

        // Variability Model
        ProjectImport parentImport = new ProjectImport(projectName, null);
        
        if (hasProjectVersion) {
            Version clonedVersion = null;
            try {
                clonedVersion = new Version(predecessor.getProject().getVersion().getVersion());
            } catch (VersionFormatException e) {
                // Can not happen, since a valid version was used
                LOGGER.exception(e);
            }
            try {
                DecisionVariableDeclaration[] vars = ExpressionVersionRestriction.createRestrictionVars(projectName);
                ConstraintSyntaxTree expr = ExpressionVersionRestriction.createSingleRestriction(vars[1], 
                    IvmlKeyWords.EQUALS, clonedVersion);
                parentImport.setRestrictions(new ExpressionVersionRestriction(expr, vars[0], vars[1]));
            } catch (RestrictionEvaluationException e) {
                LOGGER.exception(e);
            } catch (CSTSemanticException e) {
                LOGGER.exception(e);
            } catch (ValueDoesNotMatchTypeException e) {
                LOGGER.exception(e);
            }
        }
        plp.getProject().addImport(parentImport);
        
        // Build Script
        if (considerVIL) {
            addScriptImportToPLP(plp, predecessor);
        }
    }
    
    /**
     * Adds a new import to the main build script of a {@link PLPInfo}.
     * @param plp The plp where the import shall be added to the main build script.
     * @param predecessor The predecessor project which shall be imported.
     */
    private static void addScriptImportToPLP(PLPInfo plp, PLPInfo predecessor) {
        String scriptName = (null != predecessor.getBuildScript()) ?  predecessor.getBuildScript().getName()
            : predecessor.getProjectName();
        ModelImport<Script> scriptImport = new ModelImport<Script>(scriptName);
        
        boolean hasScriptVersion = null != predecessor.getBuildScript()
            && null != predecessor.getBuildScript().getVersion();
        
        if (hasScriptVersion) {
            Version clonedVersion = null;
            try {
                clonedVersion = new Version(predecessor.getBuildScript().getVersion().getVersion());
            } catch (VersionFormatException e) {
                // Can not happen, since a valid version was used
                LOGGER.exception(e);
            }
            try {
                scriptImport.setRestrictions(Utils.createSingleRestriction(plp.getBuildScript(), 
                    OclKeyWords.EQUALS, clonedVersion));
            } catch (RestrictionEvaluationException e) {
                LOGGER.exception(e);
            } 
        }
        plp.addScriptImport(scriptImport);
    }

    /**
     * Loads the default models if existent using the class loader of this class.
     * 
     * @param observer the progress observer
     */
    public static void loadDefaultModels(ProgressObserver observer) {
        loadDefaultModels(PersistenceUtils.class.getClassLoader(), observer, null);
    }

    /**
     * Loads the default models if existent using the class loader of this class.
     * 
     * @param observer the progress observer
     * @param alternativePaths for loading the models (see {@link Configuration}, may be <b>null</b>)
     */
    public static void loadDefaultModels(ProgressObserver observer, Map<PathKind, File> alternativePaths) {
        loadDefaultModels(PersistenceUtils.class.getClassLoader(), observer, alternativePaths);
    }

    /**
     * Loads the default models if existent.
     * 
     * @param loader the loader to take the resources from
     * @param observer the progress observer
     * @param alternativePaths for loading the models (see {@link Configuration}, may be <b>null</b>)
     */
    public static void loadDefaultModels(ClassLoader loader, ProgressObserver observer, 
        Map<PathKind, File> alternativePaths) {
        if (!defaultModelsLoaded) {
            defaultModelsLoaded = true;
            List<URL> libs = new ArrayList<URL>();
            URL dfltUrl = null;
            try { // constant is bad, currently no better way
                dfltUrl = DefaultLib.findDefaultLibURL(loader, DefaultLib.composePluginPattern(Activator.PLUGIN_ID), 
                    "de.uni_hildesheim.sse.EASy-Producer.persistence");
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).error(
                    "While retrieving fallback libary URL: " + e.getMessage());
            }
                
            DefaultLib.appendQuietly(libs, dfltUrl); // ignores null
            DefaultLib.appendAll(libs);
            int count = 0;
            for (URL url : libs) { // all shall be different from null by construction
                EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).info(
                    "Trying to load default IVML/VIL library from '" + url);
                try {
                    String urlString = url.toString().replace(" ", "%20"); // space problem :(
                    URI uri = new URI(urlString);
                    if (JarUtils.isJarURL(url)) {
                        File file = FileUtils.createTmpDir("easyDefaultLib_" + count);
                        JarUtils.unpackJar(url, file);
                        uri = file.toURI();
                    }
                    Location defltLibLocation = VarModel.INSTANCE.locations().getLocationFor(uri);
                    if (null == defltLibLocation && FileUtils.isFileURI(uri)) {
                        File defltLibFolder = new File(uri);
                        if (defltLibFolder.exists()) {
                            Configuration cfg = getDefaultModelsConfiguration(defltLibFolder, alternativePaths);
                            addLocation(cfg, observer);
                            EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).info(
                                "Loaded default IVML/VIL library from '" + url);
                        }
                    }
                    count++;
                } catch (URISyntaxException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).error(
                        "While loading default library in '" + url + "': " + e.getMessage());
                } catch (ModelManagementException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).error(
                        "While loading default library in '" + url + "': " + e.getMessage());
                } catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).error(
                        "While loading default library in '" + url + "': " + e.getMessage());
                }
            }
        }
    }
    
    /**
     * Creates a configuration for loading default models.
     * 
     * @param folder the folder with the models
     * @param alternativePaths for loading the models (see {@link Configuration}, may be <b>null</b>)
     * @return the configuration
     */
    private static Configuration getDefaultModelsConfiguration(File folder, Map<PathKind, File> alternativePaths) {
        Configuration result = new Configuration(folder);
        if (null != alternativePaths) {
            for (Map.Entry<PathKind, File> entry : alternativePaths.entrySet()) {
                try {
                    result.setPath(entry.getKey(), entry.getValue());
                }  catch (IOException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class, Activator.PLUGIN_ID).error(
                        "While loading default library and using " + entry.getKey() + "= " 
                        + entry.getValue() + ": " + e.getMessage() + " - using default");
                }
            }
        }
        return result;
    }

}