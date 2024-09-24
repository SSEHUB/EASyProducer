/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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

package net.ssehub.easy.producer.core.mgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModelListener;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.TopLevelModelAccessor;
import net.ssehub.easy.dslCore.TopLevelModelAccessor.IModelAccessor;
import net.ssehub.easy.instantiation.core.model.IInstantiatorProject;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.internal.Activator;
import net.ssehub.easy.producer.core.persistence.standard.EASyConfigFileImporter;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.core.varMod.container.SemanticErrorDescription;
import net.ssehub.easy.reasoning.core.frontend.IReasonerListener;
import net.ssehub.easy.reasoning.core.frontend.ReasoningProcess;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Carries basic information about a product line project.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class PLPInfo implements IInstantiatorProject, IModelListener<Script> {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(PLPInfo.class, Activator.PLUGIN_ID);
    
    private String uuid;
    private String name;
    private File projectLocation; // file is preliminary, URI are complicated to handle
    
    // Variability information
    
    /**
     * The individual variability model for this project.
     */
    private ProjectContainer varModel;
    
    /**
     * The main build script, specifying how to instantiate the whole project.
     */
    private ScriptContainer mainBuildScript;
    
    // Further information needed for reasoning, instantiation, ...
    private MemberController memberController;
    private List<IProductLineProjectListener> plpListeners;
    private ReasonerConfiguration reasonerConfig;
    
    /**
     * Specification whether further debug information should be saved.
     * <ul>
     * <li><code>true</code>: Debug information will be saved.</li>
     * <li><code>false</code>: Debug information will <b>not</b> be saved (default value).</li>
     * </ul>
     */
    private boolean saveDebugInformation;
    
    private VilExecutionThread vilExecutor;
    
    /**
     * Creates an information instance.
     * This constructor is used during {@link PersistenceUtils#loadRootPLPInfo(
     * net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment, String, File)}.
     * Please note, that no {@link Project} and no {@link Script} will be created/loaded by using this constructor.
     * 
     * @param uuid the unique identifier
     * @param name the name of the project
     * @param version the version of the project
     * @param location the physical location of the PLP (may be <b>null</b>, shall not be <b>null</b> 
     *   in case of archived PLPs such as ones in JAR files)
     */
    public PLPInfo(String uuid, String name, String version, File location) {
        this(uuid, name, version, PersistenceUtils.getLocationFile(location, PathKind.IVML), location);
    }

    
    /**
     * Creates an information instance.
     * This constructor is used during {@link PersistenceUtils#loadRootPLPInfo(
     * net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment, String, File)}.
     * Please note, that no {@link Project} and no {@link Script} will be created/loaded by using this constructor.
     * 
     * @param uuid the unique identifier
     * @param name the name of the project
     * @param version the version of the project
     * @param configLocation the physical location of the configuration file
     * @param projectLocation the physical location of the PLP (may be <b>null</b>, shall not be <b>null</b> 
     *   in case of archived PLPs such as ones in JAR files)
     */
    public PLPInfo(String uuid, String name, String version, File configLocation, File projectLocation) {
        this.uuid = uuid;
        this.name = name;
        this.projectLocation = projectLocation;
        plpListeners = new ArrayList<IProductLineProjectListener>();
        initModels();
        saveDebugInformation = false;
        //SPLsManager.INSTANCE.addPLP(this);
        vilExecutor = new VilExecutionThread(this);
    }
    
    
    /**
     * Specification whether further debug information should be saved.
     * @return
     * <ul>
     * <li><code>true</code>: Debug information will be saved.</li>
     * <li><code>false</code>: Debug information will <b>not</b> be saved (default value).</li>
     * </ul>
     */
    public boolean getSaveDebugInformation() {
        return saveDebugInformation;
    }
    
    /**
     * Specification whether further debug information should be saved.
     * @param saveDebugInformation
     * <ul>
     * <li><code>true</code>: Debug information will be saved.</li>
     * <li><code>false</code>: Debug information will <b>not</b> be saved.</li>
     * </ul>
     */
    public void setSaveDebugInformation(boolean saveDebugInformation) {
        this.saveDebugInformation = saveDebugInformation;
    }
    
    /**
     * Returns the unique identifier.
     * 
     * @return the unique identifier
     */
    public String getProjectID() {
        return uuid;
    }

    /**
     * Returns the project name.
     * 
     * @return the name of the project
     */
    public String getProjectName() {
        return name;
    }

    /**
     * Returns the version of the project.
     * 
     * @return the version (may be <b>null</b>)
     */
    public String getVersion() {
        String version = null;
        if (varModel != null) {
            version = varModel.getVersion().getVersion();
        } 
        return version;
    }
    
    /**
     * Sets a model as the "main" model of the project.
     * @param newMainModel The model that is to be set as the main model.
     */
    public void setMainModel(ModelInfo<Project> newMainModel) {
        varModel.setMainModel(newMainModel);
    }
    
    
    /**
     * Returns the physical location of the project.
     * 
     * @return the physical location (may be <b>null</b>)
     */
    public File getProjectLocation() {
        return projectLocation;
    }

    /**
     * Reloads all models (variability model(s), build script(s), template(s)) and refreshes loaded files and folders.
     */
    public void refresh() {
        //TODO SE: Force refresh.
    }
    
    /**
     * Getter for the reasoner settings.
     * @return The reasoner configuration.
     */
    public ReasonerConfiguration getReasonerConfig() {
        return reasonerConfig;
    }
    
    /**
     * Setter for the reasoner configuration settings.
     * @param reasonerConfig The configuration of the reasoners for this project.
     */
    public void setReasonerConfig(ReasonerConfiguration reasonerConfig) {
        this.reasonerConfig = reasonerConfig;
    }
    
    /**
     * Returns the folder containing the EASy configuration and the variability 
     * models as a subfolder of {@link #getProjectLocation()}.
     * 
     * @return the folder containing the EASy configuration and the variability model
     */
    public File getConfigLocation() {
        return PersistenceUtils.getLocationFile(getProjectLocation(), PathKind.IVML);
    }
    
    /**
     * Returns the (cached) configuration for this project (in terms of a <code>projectFolder</code>).
     * 
     * @return the configuration of the project
     */
    public net.ssehub.easy.producer.core.persistence.Configuration getPathConfiguration() {
        return PersistenceUtils.getConfiguration(getProjectLocation());
    }

    /**
     * Returns the folder containing the VIL scripts 
     * as a subfolder of {@link #getProjectLocation()}.
     * 
     * @return the folder containing the VIL scripts
     */
    public File getScriptLocation() {
        return PersistenceUtils.getLocationFile(getProjectLocation(), PathKind.VIL);
    }
    
    /**
     * Returns the folder containing the VTL templates 
     * as a subfolder of {@link #getProjectLocation()}.
     * 
     * @return the folder containing the VTL templates.
     */
    public File getTemplateLocation() {
        return PersistenceUtils.getLocationFile(getProjectLocation(), PathKind.VTL);
    }
    
    /**
     * This method is for an initial setting of the variability model.
     * This method also sets a project listener for this variability model to the varmodel class for getting informed
     * in case that the project is replaced by a new one.
     * @param project The variability model for this project.
     */
    protected void setProject(ProjectContainer project) {
        this.varModel = project;
    }    

    /**
     * Getter for the ivml project.
     * @return Returns the complete variability model for this project.
     */
    public Project getProject() {
        return varModel.getModel();
    }
    
    /**
     * Returns the configuration for the ivml variability model of this plp.
     * @return the configuration for the ivml project.
     * @see #getProject()
     */
    public Configuration getConfiguration() {
        return varModel.getConfiguration();
    }
    
    /**
     * This method is needed inside the constructors for constructing needed legacy models and model managers, like
     * MemberController, InstantiatorController, ...
     */
    private void initModels() {
        memberController = new MemberController(getProjectID());
        reasonerConfig = new ReasonerConfiguration();
    }
    
    /**
     * Returns the member controller.
     * @return the memberController
     */
    public MemberController getMemberController() {
        return memberController;
    }

    // ScaleLog: preliminary interface
    @Override
    public List<File> getPredecessorLocations(boolean checkExisting) {
        List<File> result = new ArrayList<File>();
        for (PLPInfo info : getMemberController().getPredecessors()) {
            File loc = info.getProjectLocation();
            if (null != loc && (!checkExisting || checkExisting && loc.exists())) {
                result.add(loc);
            }
        }
        return result;
    }

    // ScaleLog: preliminary interface
    @Override
    public List<File> getSuccessorLocations() {
        List<File> result = new ArrayList<File>();
        for (PLPInfo info : getMemberController().getSuccessors()) {
            File loc = info.getProjectLocation();
            if (null != loc) {
                result.add(loc);
            }
        }
        return result;
    }
    
    /**
     * Returns the main build script for building the project (starting point of the instantiation).
     * @return The main build script for building the project (starting point of the instantiation).
     */
    public Script getBuildScript() {
        return null != mainBuildScript ? mainBuildScript.getModel() : null;
    }
    
    /**
     * Returns whether the default main build script exists (also without having loaded it).
     * 
     * @return <code>true</code> if the default main build script exists, <code>false</code> else
     */
    public boolean hasDefaultMainBuildScript() {
        File tmpBuild = new File(PersistenceUtils.vilFileLocation(name, getVersion(),
            getScriptLocation().getAbsolutePath()));
        return tmpBuild.exists();
    }
    
    /**
     * Sets the given projectIDs as predecessor projects of this project.
     * @param predecessorIDs A list of predecessors projects.
     * @return <code>true</code> if at least one ID was removed or added, <code>false</code> otherwise.
     */
    public boolean setPredecessors(List<String> predecessorIDs) {
        boolean changed = false;
        
        // Add all selected Predecessors to this PTN
        if (predecessorIDs != null) {

            // handle removed predecessors
            Iterator<String> iterator = getMemberController().getPredecessorIDs().iterator();
            Set<String> newPredecessorsAsSet = new HashSet<String>(predecessorIDs);
            while (iterator.hasNext()) {
                String oldPredcessorID = iterator.next();
                if (!newPredecessorsAsSet.contains(oldPredcessorID)) {
                    getMemberController().removePredecessor(oldPredcessorID);
                    changed = true;
                }
            }

            // add all new predecessors
            Set<String> currentPredecessors = getMemberController().getPredecessorIDs();
            for (String predecessor : predecessorIDs) {
                if (!currentPredecessors.contains(predecessor)) {
                    getMemberController().addPredecessor(predecessor);
                    changed = true;
                }
            }
        }
        
        if (changed) {
            createMainRule();
        }
        
        return changed;
    }
    
    /**
     * Creates a main rule inside the main build script calling the main scripts of all predecessor projects.
     * If no main script exists, a main script is created.
     */
    protected void createMainRule() {
        if (null == mainBuildScript) {
            Script script = new Script(getProjectName(), Script.createDefaultParameter());
            Version version = null;
            try {
                version = new Version(getVersion());
            } catch (VersionFormatException e) {
                // Not important
                LOGGER.debug(e.getLocalizedMessage());
            }
            if (null != version) {
                script.setVersion(version);
            }
            mainBuildScript = new ScriptContainer(script, PersistenceUtils.getConfiguration(getProjectLocation()));
        }
        
        
        //TODO Add main rule calls of predecessor projects.
        /*
        Rule mainRule = null;
        try {
            mainRule = mainBuildScript.determineStartRule("main");
        } catch (VilLanguageException e) {
            LOGGER.exception(e);
        }
        
        if (null != mainRule) {
            Iterator<String> predecessors = getMemberController().getPredecessorIDs().iterator();
            while (predecessors.hasNext()) {
                ProductLineProject predecessor = SPLsManager.INSTANCE.getPLP(predecessors.next());
                if (null != predecessor && null != predecessor.getBuildScript()) {
                    Rule predecessorMainRule = null;
                    try {
                        predecessorMainRule = predecessor.getBuildScript().determineStartRule("main");
                    } catch (VilLanguageException e) {
                        LOGGER.exception(e);
                    }
                    
                    if (null != predecessorMainRule) {
                        mainRule
                    }
                }
            }
        }
        */
        
        mainBuildScript.registerModelListener(this);
    }
    
    /**
     * Setter for the main build script.
     * @param mainBuildScript A script specifying how to instantiate the whole project.
     */
    protected void setBuildScript(ScriptContainer mainBuildScript) {
        this.mainBuildScript = mainBuildScript;
        this.mainBuildScript.registerModelListener(this);
    }
    
    /**
     * Instantiates the whole project in a separate thread.
     * @deprecated Use {@link #instantiate(ProgressObserver)} instead.
     */
    @Deprecated
    public void instantiate() {
        vilExecutor.startInstantiation(ProgressObserver.NO_OBSERVER, false);
    }
    
    /**
     * Instantiates the whole project in a separate thread (asynchronous behavior).
     * @param observer The observer to inform about the current progress (in case of <code>null</code>
     * {@link ProgressObserver#NO_OBSERVER} will be used).
     * @see #instantiate(ProgressObserver, boolean)
     * @see #abortInstantiation()
     */
    public void instantiate(ProgressObserver observer) {
        vilExecutor.startInstantiation(observer, false);
    }
    
    /**
     * Instantiates the whole project in a separate thread.
     * @param observer The observer to inform about the current progress (in case of <code>null</code>
     * {@link ProgressObserver#NO_OBSERVER} will be used).
     * @param waitFor <code>true</code> This method will wait until the script was processed completely (blocking 
     *   method), <code>false</code> script will be processed in an asynchronous manner (usually used in an GUI 
     *   environment).
     * @see #instantiate(ProgressObserver)
     * @see #abortInstantiation()
     */
    public void instantiate(ProgressObserver observer, boolean waitFor) {
        vilExecutor.startInstantiation(observer, waitFor);
    }
    
    /**
     * Aborts the current execution of the VIL script at the next possible point (that is not any time possible, e.g.,
     * during the execution of third party tools like embedded <code>maven</code> scripts).
     * @see #instantiate(ProgressObserver)
     */
    public void abortInstantiation() {
        vilExecutor.abortInstantiation();
    }
    
    /**
     * Adds a new {@link IVilExecutionListener} to get informed when the instantiation was finished/aborted.
     * @param newListener The listener to be informed about the VIL execution.
     * @see #removeVilExecutionListener(IVilExecutionListener)
     */
    public void addVilExecutionListener(IVilExecutionListener newListener) {
        vilExecutor.addListener(newListener);
    }
    
    /**
     * Removes an {@link IVilExecutionListener}.
     * @param oldListener The old listener, to be removed.
     * @see #addVilExecutionListener(IVilExecutionListener)
     */
    public void removeVilExecutionListener(IVilExecutionListener oldListener) {
        vilExecutor.removeListener(oldListener);
    }
    
    /**
     * Registers a new {@link IProductLineProjectListener} to this project.
     * @param listener The listener which will be informed in case of changes.
     */
    public void register(IProductLineProjectListener listener) {
        plpListeners.add(listener);
    }
    
    /**
     * Unregisters a {@link IProductLineProjectListener} from this project.
     * @param listener the listener which shall be removed.
     */
    public void unregister(IProductLineProjectListener listener) {
        plpListeners.remove(listener);
    }
    
    /**
     * Informs all {@link IProductLineProjectListener}s that the configuration was pulled.
     */
    protected final void configurationPulled() {
        for (int i = 0; i < plpListeners.size(); i++) {
            plpListeners.get(i).configurationPulled();
        }
    }
    
    /**
     * Closes this project, which also removes this project from the {@link SPLsManager} and closes all editors.
     * This method shall be called if the related EASy/IProject will be removed/closed.
     */
    public void close() {
        /*
         * Informs all {@link IProductLineProjectListener}s that the project was closed.
         */
        for (int i = 0; i < plpListeners.size(); i++) {
            plpListeners.get(i).projectClosed();
        }
        
        PersistenceUtils.closeProject(getProjectLocation());
        
        ProgressObserver observer = ProgressObserver.NO_OBSERVER;
        /*
         * To avoid potential project reloads during the unload process,
         * first remove location for loading models and than unload the project
         */
        try {
            VarModel.INSTANCE.locations().removeLocation(getConfigLocation(), observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            BuildModel.INSTANCE.locations().removeLocation(getScriptLocation(), observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            TemplateModel.INSTANCE.locations().removeLocation(getTemplateLocation(), observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        for (IModelAccessor<?> accessor : TopLevelModelAccessor.registered()) {
            PathKind kind = PathKind.valueOf(accessor.getPathKindHint());
            if (null == kind) {
                kind = PathKind.IVML;
            }
            try {
                accessor.removeLocation(PersistenceUtils.getLocationFile(getProjectLocation(), kind), observer);
            } catch (ModelManagementException e) {
                LOGGER.exception(e);
            }            
        }
        try {
            VarModel.INSTANCE.unload(getProject(), observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            BuildModel.INSTANCE.unload(getBuildScript(), observer);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
            
        SPLsManager.INSTANCE.removePLP(getProjectID());
    }

    @Override
    public void notifyReplaced(Script oldModel, Script newModel) {
        for (int i = 0; i < plpListeners.size(); i++) {
            plpListeners.get(i).buildScriptChanged();
        }
    } 

    /**
     * Starts the reasoning.
     * @param desiredOperation  Specifies which reasoning operation should be performed.
     * @param listener listener A listener which will be called after the reasoning has been finished.
     *     Can be <code>null</code>, if no action shall be executed after the reasoning is finished.
     */
    public void reason(ReasoningOperation desiredOperation, IReasonerListener listener) {
        createReasoningProcess(desiredOperation, listener).run();
    }
    
    /**
     * Creates a reasoning process.
     * @param desiredOperation  Specifies which reasoning operation should be performed.
     * @param listener listener A listener which will be called after the reasoning has been finished.
     *     Can be <code>null</code>, if no action shall be executed after the reasoning is finished.
     * @return A {@link ReasoningProcess} which can be used for reasoning (cf. {@link ReasoningProcess#run()}). 
     */
    protected final ReasoningProcess createReasoningProcess(ReasoningOperation desiredOperation,
        IReasonerListener listener) {
        
        ReasoningProcess process = null;
        if (desiredOperation == ReasoningOperation.CONSITENCY_CHECK) {
            process = new ReasoningProcess(getProject(), getReasonerConfig(), listener, ProgressObserver.NO_OBSERVER);
        } else {
            process = new ReasoningProcess(desiredOperation, getConfiguration(), getReasonerConfig(), listener,
                ProgressObserver.NO_OBSERVER);            
        }
        
        return process;
    }
    
    /**
     * Overrides the toString method from super class Object.<br/>
     * This is done for debugging.
     * 
     * @return The name of the current project.
     */
    @Override
    public String toString() {
        boolean varModelLoaded = (null != varModel) && (null != varModel.getModel());
        return varModelLoaded ? varModel.getModel().getQualifiedName() : getProjectName();
    }

    /**
     * Returns a list with all models that are available within this project.
     * @return A list with all models of this project.
     */
    public List<ModelInfo<Project>> listAvailableModels() {
        return varModel.listAvailableModels();
    }

    /**
     * Returns the highest Version that is available for this project.
     * @return The highest version that exists within all models of this project (null if no model exists).
     */
    public Version getHighestVersion() {
        return varModel.getHighestVersion();
    }
    
    /**
     * Checks whether the models and can be saved, or if a dummy was used to avoid {@link NullPointerException}s.
     * @return <code>true</code> if loaded models are used and can be saved, <code>false</code> if at least one dummy 
     * was used, which should not be saved.
     */
    public boolean isSaveable() {
        return varModel.isSaveable();
    }
    
    /**
     * Saves the data of this project persistently to file system.
     * @throws PersistenceException If files cannot be written to the file system.
     */
    public void save() throws PersistenceException {      
        PathEnvironment projectsWorkspace = new PathEnvironment(getProjectLocation().getParentFile());
        File easyConfigFile = PersistenceUtils.getLocationFile(getProjectLocation(), PathKind.IVML);
        IPersistencer persistencer = new Persistencer(projectsWorkspace, getProjectLocation(),
                easyConfigFile.getAbsolutePath(), ProgressObserver.NO_OBSERVER);
        persistencer.save(this);
    }

    /**
     * Returns a list of {@link SemanticErrorDescription} which occurred while parsing the VarModel (IVML files) and
     * the build script (VIL files).
     * @return a list of parsing errors. Should be empty iff no semantic errors exist inside the files.
     */
    public List<SemanticErrorDescription> getParsingExceptions() {
        List<SemanticErrorDescription> exceptions = new ArrayList<SemanticErrorDescription>(2);
        
        if (null != varModel.getDescription()) {
            exceptions.add(varModel.getDescription());
        }
        if (null != mainBuildScript.getDescription()) {
            exceptions.add(mainBuildScript.getDescription());
        }
        
        return exceptions;
    }
    
    /**
     * Checks whether VIL instantiation should be possible. Currently, we check whether there is a start rule (main-rule
     * matching the script parameters) which either has a body or some kind of precondition or some kind of 
     * postcondition.
     * 
     * @return <code>true</code> if instantiation should be possible, <code>false</code> else
     */
    protected final boolean isTransformableVIL() {
        return mainBuildScript.isTransformable();
    }
    
    /**
     * This method copies the variability model, configuration,
     * and build scripts/templates from the predecessors to this project..
     */
    public void pullConfigFromPredecessors() {
        EASyConfigFileImporter importer = new EASyConfigFileImporter(this);
        // These list temporarily save the instantiators from all predecessors
        
        MemberIterator predecessors = getMemberController().predecessors();
        while (predecessors.hasNext()) {
            PLPInfo predecessorPLP = predecessors.next();
            
            //Copy (imported) ivml files
            // Insert a dot to hide imported folders
            importer.copyConfigFiles(predecessorPLP, "." + predecessorPLP.getProjectName());
        }

        
        //Refresh
        PersistenceUtils.refreshModels(this);
        getConfiguration().refresh();
        configurationPulled();
    }
    
    /**
     * Adds a Script Import to the build script. This method should be used instead during this
     * via {@link #getBuildScript()} and {@link Script#addImport(ModelImport)}.
     * This will ensure that the included import will also be saved, when this plp is saved.
     * @param scriptImport A import which shall be added to the main {@link Script} of this project.
     */
    public void addScriptImport(ModelImport<Script> scriptImport) {
        mainBuildScript.getModel().addImport(scriptImport);
        mainBuildScript.setEdited(true);
    }
    
    /**
     * Sets the flag for saving the build script. This should be called whenever the build script was modified via
     * EASy and the changes should be saved when this plp is saved.
     * If this flag was not set, all the (changed) build script will not be saved.
     */
    public void buildScriptWasEdited() {
        mainBuildScript.setEdited(true);
    }
    
    /**
     * Returns the encapsulated {@link ProjectContainer} for the {@link #getProject()}.
     * This method should only be needed by the Persistencers.
     * @return The {@link ProjectContainer} for the variability model.
     */
    public ProjectContainer getProjectContainer() {
        return varModel;
    }
    
    /**
     * Returns the encapsulated {@link ScriptContainer} for the {@link #getBuildScript()}.
     * This method should only be needed by the Persistencers.
     * @return The {@link ScriptContainer} for build script.
     */
    public ScriptContainer getScriptContainer() {
        return mainBuildScript;
    }
    
    /**
     * Returns whether this is a preliminary information object or a specialized.
     * 
     * @return <code>true</code> if it is preliminary, i.e., directly from this class, <code>false</code> if it is 
     * from a subclass
     */
    public boolean isPreliminary() {
        return getClass() == PLPInfo.class;
    }
}
