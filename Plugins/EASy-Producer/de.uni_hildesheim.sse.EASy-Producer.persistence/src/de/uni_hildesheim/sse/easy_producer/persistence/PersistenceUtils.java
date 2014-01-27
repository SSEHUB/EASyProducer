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

package de.uni_hildesheim.sse.easy_producer.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangWriter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.DataStorage;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.StorageType;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.IVMLWriter;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagement;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Static utility functions related to the persistence layer.
 * @author El-Sharkawy
 *
 */
public class PersistenceUtils {

    public static final String TOP_LEVEL_CONFIG_NAME = ".EASyProducer";
    
    /**
     * Notification by the instantiator controller:
     * No multiple instantiated files message.
     */
    public static final String INSTANTIATOR_CONTROLLER_MULTIPLE = "No file will be instantiated by multiple engines";
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(PersistenceUtils.class
        , Activator.PLUGIN_ID);
    
    /**
     * Adds the given location to {@link VarModel}, {@link BuildModel}, and {@link TemplateModel}.
     * @param configFolder The IVML location which shall be added.
     * @param scriptFolder The VIL/VTL location which shall be added.
     * @param observer observer a progress observer, may be {@link ProgressObserver#NO_OBSERVER}
     * @throws ModelManagementException - in case that the available information may become
     *     inconsistent due to the new location (if more than one exception is created, the last one will be returned)
     */
    public static final void addLocation(File configFolder, File scriptFolder, ProgressObserver observer)
        throws ModelManagementException {
        ModelManagementException returnExc = null;
        try {
            VarModel.INSTANCE.locations().addLocation(configFolder, observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        try {
            BuildModel.INSTANCE.locations().addLocation(scriptFolder, observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        try {
            TemplateModel.INSTANCE.locations().addLocation(scriptFolder, observer);
        } catch (ModelManagementException exc) {
            returnExc = exc;
        }
        
        if (null != returnExc) {
            throw returnExc;
        }
    }
    
    /**
     * Returns the configuration location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a string, may be a path
     */
    public static final String getConfigLocation(File projectFolder) {
        String result = PersistenceConstants.EASY_FILES_DEFAULT; // wrong dependency direction        
        File topConfigFile = new File(projectFolder, TOP_LEVEL_CONFIG_NAME);
        if (topConfigFile.exists()) {
            LineNumberReader lnr = null;
            try {
                lnr = new LineNumberReader(new FileReader(topConfigFile));
                String line = lnr.readLine();
                if (null != line) {
                    result = line;
                }
                lnr.close();
            } catch (IOException e) {
                if (null != lnr) {
                    try {
                        lnr.close();
                    } catch (IOException e1) {
                    }
                }
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * Returns the script location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a string, may be a path
     */
    public static final String getScriptLocation(File projectFolder) {
        String result = PersistenceConstants.EASY_FILES_DEFAULT; // wrong dependency direction        
        File topConfigFile = new File(projectFolder, TOP_LEVEL_CONFIG_NAME);
        if (topConfigFile.exists()) {
            LineNumberReader lnr = null;
            try {
                lnr = new LineNumberReader(new FileReader(topConfigFile));
                String line = lnr.readLine();
                if (null != line) {
                    result = lnr.readLine();
                }
                lnr.close();
            } catch (IOException e) {
                if (null != lnr) {
                    try {
                        lnr.close();
                    } catch (IOException e1) {
                    }
                }
                e.printStackTrace();
            }
        }
        return result;
    }
    
    /**
     * Returns the configuration location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a subpath of <code>projectFolder</code>
     */
    public static final File getConfigLocationFile(File projectFolder) {
        return new File(projectFolder, getConfigLocation(projectFolder));
    }

    /**
     * Returns the script location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a subpath of <code>projectFolder</code>
     */
    public static final File getScriptLocationFile(File projectFolder) {
        return new File(projectFolder, getScriptLocation(projectFolder));
    }
    
    /**
     * Returns the absolute path of the configuration location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a absolute path of <code>projectFolder</code>
     */
    public static final String getConfigLocationAbsolutePath(File projectFolder) {
        return getConfigLocationFile(projectFolder).getAbsolutePath();
    }
    
    /**
     * Returns the absolute path of the script location within the given 
     * <code>projectFolder</code>.
     * 
     * @param projectFolder the folder of the EASy project
     * @return the configuration location as a absolute path of <code>projectFolder</code>
     */
    public static final String getScriptLocationAbsolutePath(File projectFolder) {
        return getScriptLocationFile(projectFolder).getAbsolutePath();
    }
    
    /**
     * Persists the location of the configuration folder.
     * 
     * @param projectFolder the folder of the EASy project
     * @param location the location to be persisted
     * @throws IOException any I/O exception during persisting the location
     */
    public static final void storeConfigLocation(File projectFolder, String location) throws IOException {
        File topConfigFile = new File(projectFolder, TOP_LEVEL_CONFIG_NAME);
        PrintWriter pw = new PrintWriter(new FileWriter(topConfigFile));
        pw.println(location);
        pw.close();
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
     * This method locates the project file for the ivml/vil model for a specific EASy project
     * within the given storage path.
     * 
     * @param projectName The qualified name of the model project which should be read/saved
     * @param projectVersion The version of the model project which should be read/saved, can be <code>null</code>.
     * @param storagePath The location (top level folder) of the configuration files
     * @param extension The file extension (<tt>".ivml"</tt> for IVML files, or <tt>".vil"</tt>)
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
     * {@link de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject} to the file system.
     * @param project The IVML {@link Project} which should be saved.
     * @param storagePath The folder, where the file should be saved.
     * @throws PersistenceException If the file cannot be written to the file system.
     */
    public static void writeIVMLProject(Project project, String storagePath) throws PersistenceException {       
        File file = new File(PersistenceUtils.ivmlFileLocation(project, storagePath));
        
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
     * {@link de.uni_hildesheim.sse.easy_producer.persistence.datatypes.PersistentProject} to the file system.
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
        } catch (VilLanguageException e) {
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
     *     or {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template}
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
}
