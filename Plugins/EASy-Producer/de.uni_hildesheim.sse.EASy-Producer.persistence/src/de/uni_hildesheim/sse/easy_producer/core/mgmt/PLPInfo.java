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

package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.CopyModel;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.EASyConfigFileImporter;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.Persistencer;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ProjectContainer;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.SemanticErrorDescription;
import de.uni_hildesheim.sse.easy_producer.instantiator.TranformatorNotificationDelegate;
import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorProject;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IProjectDescriptor;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.frontend.IReasonerListener;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasoningProcess;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;
import de.uni_hildesheim.sse.utils.modelManagement.ModelImport;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.Version;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

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
    private CopyModel copyModel;
    private InstantiatorController instantiatorController;
    private List<IProductLineProjectListener> plpListeners;
    private ReasonerConfiguration reasonerConfig;
    
    /**
     * Specification whether further debug information should be saved.
     * <ul>
     * <li><tt>true</tt>: Debug information will be saved.</li>
     * <li><tt>false</tt>: Debug information will <b>not</b> be saved (default value).</li>
     * </ul>
     */
    private boolean saveDebugInformation;
    
    
    /**
     * Creates an information instance.
     * This constructor is used during {@link PersistenceUtils#loadRootPLPInfo(
     * de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment, String, File)}.
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
     * de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment, String, File)}.
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
    }
    
    
    /**
     * Specification whether further debug information should be saved.
     * @return
     * <ul>
     * <li><tt>true</tt>: Debug information will be saved.</li>
     * <li><tt>false</tt>: Debug information will <b>not</b> be saved (default value).</li>
     * </ul>
     */
    public boolean getSaveDebugInformation() {
        return saveDebugInformation;
    }
    
    /**
     * Specification whether further debug information should be saved.
     * @param saveDebugInformation
     * <ul>
     * <li><tt>true</tt>: Debug information will be saved.</li>
     * <li><tt>false</tt>: Debug information will <b>not</b> be saved.</li>
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
    public de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration getPathConfiguration() {
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
        instantiatorController = new InstantiatorController();
        copyModel = new CopyModel();
        reasonerConfig = new ReasonerConfiguration();
    }
    
    /**
     * Resets the {@link InstantiatorController} of the {@link PLPInfo}.
     * @param transformatorController The new {@link InstantiatorController} which should replace the old one.
     */
    public void setTransformatorController(InstantiatorController transformatorController) {
        this.instantiatorController = transformatorController;
    }

    @Override
    public InstantiatorController getInstantiatorController() {
        return instantiatorController;
    }
    
    /**
     * Returns the member controller.
     * @return the memberController
     */
    public MemberController getMemberController() {
        return memberController;
    }

    @Override
    public CopyModel getCopyModel() {
        return copyModel;
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
     * Instantiates the whole project.
     * @param instantiationMonitor A monitor notifying the user about the instantiation progress.
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    public void instantiate(TranformatorNotificationDelegate instantiationMonitor) throws VilLanguageException {
        // Each instantiator will now produce its own messages and send it to the console
        Transformator transformator = new Transformator(getProjectID(), instantiationMonitor, SPLsManager.INSTANCE,
            getCopyModel().getCopyMechanism());
       
        // >> VIL addition
        if (!transformator.execute()) {
            // currently: give old transformators a chance - if nothing happens, try VIL
            // VIL output is handled via the TracerFactory configured in UI.Startup
            if (null != getBuildScript()) { // just to be sure for now
                try {
                    createExecutor().execute(); // TODO replace observer
                } catch (VilLanguageException vilExc) {
                    throw vilExc;
                } finally {
                    refresh();
                }
            }
        }
        // << VIL addition
    }
    
    /**
     * Creates a VIL executor for the contained PLP.
     * 
     * @return the created executor
     */
    private Executor createExecutor() {
        // old styles... without having explicit predecessors in VIL projects
        
        /*Executor executor = new Executor(getBuildScript())
            .addTarget(getProjectLocation())
            .addConfiguration(getConfiguration());
        List<File> predecessors = getPredecessorLocations(true);
        if (null == predecessors || predecessors.isEmpty()) {
            // no predecessors - assume self-instantiation
            executor.addSource(getProjectLocation());
        } else {
            executor.addSources(predecessors);
        }
        VilArgumentProvider.provideArguments(this, executor);
        return executor;*/
        ProjectDescriptor me = new ProjectDescriptor(this);
        Executor executor = new Executor(getBuildScript())
            .addTarget(me)
            .addConfiguration(getConfiguration());
        int predCount = getMemberController().getPredecessorsCount();
        if (0 == predCount) {
            // no predecessors - assume self-instantiation
            executor.addSource(me);
        } else {
            IProjectDescriptor[] pred = new IProjectDescriptor[predCount + 1];
            int i = 0;
            pred[i++] = me;
            for (PLPInfo p : getMemberController().getPredecessors()) {
                pred[i++] = new ProjectDescriptor(p);
            }
            executor.addSources(pred);
        }
        VilArgumentProvider.provideArguments(this, executor);
        return executor;
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
        
        /*
         * To avoid potential project reloads during the unload process,
         * first remove location for loading models and than unload the project
         */
        try {
            VarModel.INSTANCE.locations().removeLocation(getConfigLocation(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            BuildModel.INSTANCE.locations().removeLocation(getScriptLocation(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            TemplateModel.INSTANCE.locations().removeLocation(getTemplateLocation(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            VarModel.INSTANCE.unload(getProject(), ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
        try {
            BuildModel.INSTANCE.unload(getBuildScript(), ProgressObserver.NO_OBSERVER);
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
     *     Can be <tt>null</tt>, if no action shall be executed after the reasoning is finished.
     */
    public void reason(ReasoningOperation desiredOperation, IReasonerListener listener) {
        createReasoningProcess(desiredOperation, listener).run();
    }
    
    /**
     * Creates a reasoning process.
     * @param desiredOperation  Specifies which reasoning operation should be performed.
     * @param listener listener A listener which will be called after the reasoning has been finished.
     *     Can be <tt>null</tt>, if no action shall be executed after the reasoning is finished.
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
     * @return <tt>true</tt> if loaded models are used and can be saved, <tt>false</tt> if at least one dummy was used,
     * which should not be saved.
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
     * 
     * @throws VarModelConflictException
     */
    public void pullConfigFromPredecessors() {
        EASyConfigFileImporter importer = new EASyConfigFileImporter(this);
        // These list temporarily save the instantiators from all predecessors
        List<FileInstantiator> compareTransformators = new ArrayList<FileInstantiator>();
        
        MemberIterator predecessors = getMemberController().predecessors();
        while (predecessors.hasNext()) {
            PLPInfo predecessorPLP = predecessors.next();
            
            // Copy Instantiator settings
            compareTransformators.addAll(predecessorPLP.getInstantiatorController().getTransformators());
            
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
