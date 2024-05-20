package net.ssehub.easy.standalone.cmd;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.IVilExecutionListener;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Static commands for instantiating projects via the command line or by a build tool. Files/Folders 
 * to be passed in through this interface shall be absolute! This class considers {@link ProjectNameMapper}.<br/>
 * 
 * <b>Before calling any of the methods here, EASy must be loaded via calling {@link LowlevelCommands#startEASy()}.</b>
 * 
 * @author El-Sharkawy
 */
public final class InstantiationCommands {
    
    /**
     * Should prevent instantiation of this utility class.
     */
    private InstantiationCommands() {}
    
    
    /**
     * Listener to collect {@link VilException}s during script execution.
     * @author El-Sharkawy
     *
     */
    private static class InstantiationListener implements IVilExecutionListener {
        private VilException exc = null;

        @Override
        public void vilExecutionAborted(PLPInfo plp, VilException exc) {
            this.exc = exc;
        }

        @Override
        public void vilExecutionFinished(PLPInfo plp, boolean instantiationSuccessfull) {
            // Not needed
        }
        
    }

    /**
     * Instantiates the given project.
     * The project must:
     * <ul>
     * <li>be a valid EASy project with the usual configuration files and folders.</li>
     * <li>contain a frozen configuration</li>
     * <li>contain VIL script which can be applied to itself</li>
     * </ul>
     * 
     * @param project The toplevel absolute folder of the project (must have a valid EASy structure)
     * 
     * @throws PersistenceException Will be thrown if the project could not be loaded, e.g. if the project has no
     *     valid EASy structure.
     * @throws VilException In case that artifact operations or script execution fails
     */
    public static void instantiateSelf(File project) throws PersistenceException, VilException {
        instantiateSelf(project, (Map<String, Object>) null);
    }
    
    /**
     * Instantiates the given project.
     * The project must:
     * <ul>
     * <li>be a valid EASy project with the usual configuration files and folders.</li>
     * <li>contain a frozen configuration</li>
     * <li>contain VIL script which can be applied to itself</li>
     * </ul>
     * 
     * @param project The toplevel absolute folder of the project (must have a valid EASy structure)
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws PersistenceException Will be thrown if the project could not be loaded, e.g. if the project has no
     *     valid EASy structure.
     * @throws VilException In case that artifact operations or script execution fails
     */
    public static void instantiateSelf(File project, Map<String, Object> arguments) 
        throws PersistenceException, VilException {
        // This is the usual way:
        VilArgumentProvider provider = createArgumentProvider(arguments);
        LowlevelCommands.loadProject(project);
        String projectName = ProjectNameMapper.getInstance().getName(project);
        PLPInfo plp = LowlevelCommands.getProject(projectName);
        if (null != plp) {
            InstantiationListener listener = new InstantiationListener();
            plp.addVilExecutionListener(listener);
            plp.instantiate(ProgressObserver.NO_OBSERVER, true);
            if (null != listener.exc) {
                throw listener.exc; 
            }
        } else {
            throw new PersistenceException("Project \"" + projectName + "\" could not be loaded.");
        }
        VilArgumentProvider.remove(provider); // works with null as argument
    }

    /**
     * Instantiates the given project.
     * The project must:
     * <ul>
     * <li>contain VIL script which can be applied to itself, which uses the usual EASy naming convention for
     *     VIL scripts in Version 0.</li>
     * </ul>
     * This method is a convenience wrapper for {@link #instantiateSelf(File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param project The toplevel absolute folder of the project
     * @param ivmlFile A frozen configuration, which should be used for instantiation.
     * 
     * @throws ModelManagementException In case that the available information
     *   may be come inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile) throws ModelManagementException,
        VilException, PersistenceException {
        instantiateSelf(project, ivmlFile, (Map<String, Object>) null);
    }
    
    /**
     * Instantiates the given project.
     * The project must:
     * <ul>
     * <li>contain VIL script which can be applied to itself, which uses the usual EASy naming convention for
     *     VIL scripts in Version 0.</li>
     * </ul>
     * 
     * @param project The toplevel absolute folder of the project
     * @param ivmlFile A frozen configuration, which should be used for instantiation.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws ModelManagementException In case that the available information
     *   may be come inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, Map<String, Object> arguments) 
        throws ModelManagementException, VilException, PersistenceException {
        
        // This is an unusual way (a hack):  
        // Determine default build script location
        String projectName = ProjectNameMapper.getInstance().getName(project);
        File configFolder = PersistenceUtils.getLocationFile(project, PathKind.IVML);
        String path = PersistenceUtils.vilFileLocation(projectName, "0", configFolder.getAbsolutePath());
        File buildScriptFile = new File(path);
        
        instantiateSelf(project, ivmlFile, buildScriptFile, arguments);
    }

    /**
     * Instantiates the given project. <br />
     * It's <b>not</b> necessary that the project has a valid EASy structure. This method is a convenience wrapper for 
     * {@link #instantiateSelf(File, File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param project The toplevel absolute folder of the project
     * @param ivmlFile A frozen configuration, which should be used for instantiation.
     * @param buildScriptFile The main build script (starting point) which should be used for instantiation.
     * 
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, File buildScriptFile)
        throws ModelManagementException, VilException, PersistenceException {
        instantiateSelf(project, ivmlFile, buildScriptFile, null);
    }
    
    /**
     * Instantiates the given project. <br />
     * It's <b>not</b> necessary that the project has a valid EASy structure.
     * 
     * @param project The toplevel absolute folder of the project
     * @param ivmlFile A frozen configuration, which should be used for instantiation.
     * @param buildScriptFile The main build script (starting point) which should be used for instantiation.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     *   
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, File buildScriptFile, Map<String, Object> arguments)
        throws ModelManagementException, VilException, PersistenceException {
        
        // This is an unusual way (a hack):
        // Load ivml file
        Project ivmlProject = PersistenceUtils.loadModel(VarModel.INSTANCE, ivmlFile);      
        // Load build script
        Script buildScript = PersistenceUtils.loadModel(BuildModel.INSTANCE, buildScriptFile);
        // Adds the project folder to all 3 models. In case of an error, only the last exception will be thrown.
        Configuration config = PersistenceUtils.getConfiguration(project);
        PersistenceUtils.addLocation(config, ProgressObserver.NO_OBSERVER);
        
        // Create temporary PLP
        if (null != ivmlProject && null != buildScript) {
            VilArgumentProvider provider = createArgumentProvider(arguments);
            String projectName = ProjectNameMapper.getInstance().getName(project);
            ProjectContainer pCont = new ProjectContainer(ivmlProject, config);
            ScriptContainer sCont = new ScriptContainer(buildScript, config);
            PLPInfo plp = new ProductLineProject(UUID.randomUUID().toString(), projectName, pCont, project, sCont);
            InstantiationListener listener = new InstantiationListener();
            plp.addVilExecutionListener(listener);
            plp.instantiate(ProgressObserver.NO_OBSERVER, true);
            VilArgumentProvider.remove(provider); // ok if provider is null
            if (null != listener.exc) {
                throw listener.exc; 
            }
        } else {
            throw new PersistenceException("The specified IVML/VIL files could not be loaded.");
        }
    }
    
    /**
     * Creates an argument provider and registers it with {@link VilArgumentProvider} if necessary.
     * 
     * @param arguments the arguments to be passed to VIL (may be <b>null</b>)
     * 
     * @return the argument provider if one was created and registered, <b>null</b> else
     */
    private static VilArgumentProvider createArgumentProvider(Map<String, Object> arguments) {
        VilArgumentProvider argProvider = null;
        if (null != arguments) {
            argProvider = new GenericVilArgumentProvider(arguments);
            VilArgumentProvider.add(argProvider);
        }
        return argProvider;
    }

    /**
     * Instantiates the project <code>projectTarget</code>, while using source files (and IVML/VIL information) provided
     * by <code>projectSource</code>.
     * The following conditions must be hold:
     * <ol>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><code>projectTarget</code> must contain a contain a frozen configuration.</li>
     * <li><code>projectTarget</code> must contain VIL script.</li>
     * <li><code>projectSource</code> must contain a infrastructure, which cen be instantiated, e.g. annotated 
     *   source files.</li>
     * </ol>
     * If <code>projectTarget</code> does not exist, this method will create the folder. In this case, 2.) and 3.) 
     *   must be included in <code>projectSource</code>.
     * This method is a convenience wrapper for {@link #instantiate(File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param projectSource The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     serves as a basis for instantiation.
     * @param projectTarget The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     should be instantiated.
     * 
     * @throws PersistenceException Will be thrown if one of the projects could not be loaded,
     *     e.g. if the project has no valid EASy structure.
     * @throws VilException In case that artifact operations or script execution fails
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget) throws PersistenceException,
        VilException, IOException {
        instantiate(projectSource, projectTarget, null);
    }
    
    /**
     * Instantiates the project <code>projectTarget</code>, while using source files (and IVML/VIL information) provided
     * by <code>projectSource</code>.
     * The following conditions must be hold:
     * <ol>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><code>projectTarget</code> must contain a contain a frozen configuration.</li>
     * <li><code>projectTarget</code> must contain VIL script.</li>
     * <li><code>projectSource</code> must contain a infrastructure, which cen be instantiated, e.g. annotated 
     *     source files.</li>
     * </ol>
     * If <code>projectTarget</code> does not exist, this method will create the folder. In this case, 2.) and 3.) 
     * must be included in <code>projectSource</code>.
     * 
     * @param projectSource The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     serves as a basis for instantiation.
     * @param projectTarget The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     should be instantiated.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws PersistenceException Will be thrown if one of the projects could not be loaded,
     *     e.g. if the project has no valid EASy structure.
     * @throws VilException In case that artifact operations or script execution fails
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, Map<String, Object> arguments) 
        throws PersistenceException, VilException, IOException {
        
        if (projectSource.exists() && projectTarget.exists()) {
            // This is the usual way:
            instantiateEASyProjects(projectSource, projectTarget, arguments);
        } else if (!projectTarget.exists()) {
            VilArgumentProvider provider = createArgumentProvider(arguments);
            
            // 1. Load Predecessor
            LowlevelCommands.loadProject(projectSource);
            String projectName =  ProjectNameMapper.getInstance().getName(projectSource);
            PLPInfo plpPre = LowlevelCommands.getProject(projectName);
            
            // 2. Create successor
            Configuration configTarget = PersistenceUtils.getConfiguration(projectTarget);
            File parentFolder = projectTarget.getParentFile();
            String projectNameTrg = ProjectNameMapper.getInstance().getName(projectTarget);
            PathEnvironment pathEnv = new PathEnvironment(parentFolder);
            File easyConfigFile = PersistenceUtils.getLocationFile(projectTarget, PathKind.IVML);
            Persistencer persistencer = new Persistencer(pathEnv, projectTarget, easyConfigFile.getAbsolutePath(),
                ProgressObserver.NO_OBSERVER);
            IProjectCreationResult result = persistencer.createProject(projectNameTrg, parentFolder,
                UUID.randomUUID().toString(), false);
            ScriptContainer sCont = new ScriptContainer(result.getBuildScript(), configTarget);
            ProjectContainer pCont = new ProjectContainer(result.getVarModel(), configTarget);
            PLPInfo plpSuc = new ProductLineProject(result.getProjectID(), projectNameTrg, pCont, projectTarget, sCont);
            plpSuc.getMemberController().addPredecessor(plpPre);
            PersistenceUtils.addImport(plpSuc, plpPre, true);
            plpSuc.pullConfigFromPredecessors();
            PersistenceUtils.refreshModels(plpSuc);
            PersistenceUtils.createInstantiatePredecessorScript(plpSuc, plpPre);
            sCont.setEdited(true);
            plpSuc.save();
            
            // 3. Instantiate
            InstantiationListener listener = new InstantiationListener();
            plpSuc.addVilExecutionListener(listener);
            plpSuc.instantiate(ProgressObserver.NO_OBSERVER, true);
            VilArgumentProvider.remove(provider); // works with null as argument
            if (null != listener.exc) {
                throw listener.exc; 
            }
        }
    }

    /**
     * Instantiates the project <code>projectTarget</code>, while using source files (and IVML/VIL information) provided
     * by <code>projectSource</code>.
     * The following conditions must be hold:
     * <ul>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><code>projectTarget</code> must contain a contain a frozen configuration.</li>
     * <li><code>projectTarget</code> must contain VIL script.</li>
     * <li><code>projectSource</code> must contain a infrastructure, which can be instantiated, e.g. annotated source 
     *     files.</li>
     * </ul>
     * 
     * @param projectSource The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     serves as a basis for instantiation.
     * @param projectTarget The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     should be instantiated.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws PersistenceException Will be thrown if one of the projects could not be loaded,
     *     e.g. if the project has no valid EASy structure.
     * @throws VilException In case that artifact operations or script execution fails
     */
    private static void instantiateEASyProjects(File projectSource, File projectTarget, Map<String, Object> arguments) 
        throws PersistenceException, VilException {
            
        VilArgumentProvider provider = createArgumentProvider(arguments);
        
        // This is the usual way:
        LowlevelCommands.loadProject(projectSource);
        LowlevelCommands.loadProject(projectTarget);
        String projectName =  ProjectNameMapper.getInstance().getName(projectTarget);
        PLPInfo plp = LowlevelCommands.getProject(projectName);
        if (null != plp) {
            InstantiationListener listener = new InstantiationListener();
            plp.addVilExecutionListener(listener);
            plp.instantiate(ProgressObserver.NO_OBSERVER, true);
            if (null != listener.exc) {
                throw listener.exc; 
            }
        } else {
            throw new PersistenceException("Project \"" + projectName + "\" could not be loaded.");
        }
        
        VilArgumentProvider.remove(provider); // works with null as argument
    }
    
    /**
     * Uses <code>projectSource</code> to instantiate <code>projectTarget</code>.
     * The folder <code>projectTarget</code> will be created, if it does not exist. This method is a convenience wrapper
     * for {@link #instantiate(File, File, File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlFile The model definition including its frozen configuration, which should be used for instantiation.
     *     (Must be inside either of <code>projectSource</code> or <code>projectTarget</code>).
     * @param scriptFile The main build script (starting point) which should be used for instantiation.
     *     (Must be inside either of <code>projectSource</code> or <code>projectTarget</code>).
     * 
     * @throws SecurityException If <code>projectTarget</code> does not exist, a security manager exists,
     *     and its <code>{@link java.lang.SecurityManager#checkWrite(java.lang.String)}</code>
     *     method does not permit <code>projectTarget</code> directory to be created
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, File ivmlFile, File scriptFile) 
        throws ModelManagementException, SecurityException, PersistenceException, VilException, IOException {
        instantiate(projectSource, projectTarget, ivmlFile, scriptFile, null);
    }
    
    /**
     * Uses <code>projectSource</code> to instantiate <code>projectTarget</code>.
     * The folder <code>projectTarget</code> will be created, if it does not exist.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files 
     *     to instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlFile The model definition including its frozen configuration, which should be used for instantiation.
     *     (Must be inside either of <code>projectSource</code> or <code>projectTarget</code>).
     * @param scriptFile The main build script (starting point) which should be used for instantiation.
     *     (Must be inside either of <code>projectSource</code> or <code>projectTarget</code>).
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws SecurityException If <code>projectTarget</code> does not exist, a security manager exists,
     *     and its <code>{@link java.lang.SecurityManager#checkWrite(java.lang.String)}</code>
     *     method does not permit <code>projectTarget</code> directory to be created
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, File ivmlFile, File scriptFile, 
        Map<String, Object> arguments) throws ModelManagementException, SecurityException, PersistenceException, 
        VilException, IOException {
        
        // This is an unusual way (a hack):
        //check whether ivmlFile and scriptFile are located in target oder in source
        boolean ivmlReleativeToProjects = checkIsNestedFile(projectSource, ivmlFile)
            || checkIsNestedFile(projectTarget, ivmlFile);
        boolean vilReleativeToProjects = checkIsNestedFile(projectSource, scriptFile)
            || checkIsNestedFile(projectTarget, scriptFile);
        if (!(ivmlReleativeToProjects && vilReleativeToProjects)) {
            throw new PersistenceException("IVML and VIL files must be located either inside the source or the "
                + "target folder.");
        }
        /*
         * Create trg and copy EASy files, if it does not exist. In the next step the files will be loaded,
         * maybe from the newly created location.
         */
        createTargetFolder(projectSource, projectTarget);
        
        // Adds the project folder to all 3 models. In case of an error, only the last exception will be thrown.
        Configuration configSource = PersistenceUtils.getConfiguration(projectSource);
        PersistenceUtils.addLocation(configSource, ProgressObserver.NO_OBSERVER);    
        Configuration configTarget = PersistenceUtils.getConfiguration(projectTarget);
        PersistenceUtils.addLocation(configTarget, ProgressObserver.NO_OBSERVER);

        // Load ivml file
        Project ivmlProject = PersistenceUtils.loadModel(VarModel.INSTANCE, ivmlFile);      
        // Load build script
        Script buildScript = PersistenceUtils.loadModel(BuildModel.INSTANCE, scriptFile);
        
        // Create temporary PLPs
        if (null != ivmlProject && null != buildScript) {
            createPLPsAndInstantiate(projectSource, projectTarget, ivmlProject, buildScript, arguments);
        } else {
            throw new PersistenceException("The specified IVML/VIL files could not be loaded.");
        }
    }

    /**
     * Creates two (temporary) {@link PLPInfo}s, links them (sets prede-/successor), and instantiates the successor.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An existing absolute folder/project where the files should be instantiated in.
     * @param ivmlProject A loaded configuration, which should be used for instantiation (Must not be 
     *   <code>null</code>).
     * @param buildScript A loaded build script, which should be used for instantiation (Must not be <code>null</code>).
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws VilException In case that artifact operations or script execution fails
     */
    private static void createPLPsAndInstantiate(File projectSource, File projectTarget, Project ivmlProject,
        Script buildScript, Map<String, Object> arguments) throws VilException {
        
        VilArgumentProvider provider = createArgumentProvider(arguments);
        
        // Create Predecessor
        String projectNameSrc = ProjectNameMapper.getInstance().getName(projectSource);
        PLPInfo plpPre = new ProductLineProject(projectNameSrc, projectSource);
        
        // Create Successor
        Configuration config = PersistenceUtils.getConfiguration(projectTarget);
        
        String projectNameTrg = ProjectNameMapper.getInstance().getName(projectTarget);
        ProjectContainer pCont = new ProjectContainer(ivmlProject, config);
        ScriptContainer sCont = new ScriptContainer(buildScript, config);
        PLPInfo plpSuc = new ProductLineProject(UUID.randomUUID().toString(), projectNameTrg, pCont,
            projectTarget, sCont);
        plpSuc.getMemberController().addPredecessor(plpPre);
        InstantiationListener listener = new InstantiationListener();
        plpSuc.addVilExecutionListener(listener);
        plpSuc.instantiate(ProgressObserver.NO_OBSERVER, true);
        VilArgumentProvider.remove(provider); // works with null as argument
        if (null != listener.exc) {
            throw listener.exc; 
        }
        
    }

    /**
     * Uses <code>projectSource</code> to instantiate <code>projectTarget</code>.
     * The folder <code>projectTarget</code> will be created, if it does not exist. This method is a convenience wrapper
     * for {@link #instantiate(File, File, ModelLoadDefinition, ModelLoadDefinition, Map)} with <b>null</b> 
     * as arguments.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlDefinition A (model name, version) pair for specifying which {@link Project} should be used for
     *     instantantion.
     *     The {@link Project} must be located inside of <code>projectTarget</code> or <code>projectSource</code>.
     *     This method first
     *     tries to load the {@link Project} from the <code>projectTarget</code> before it tries to load the 
     *     {@link Project} from the <code>projectSource</code>.
     * @param vilDefinition A (model name, version) pair for specifying which {@link Script} should be used for
     *     instantantion.
     *     The {@link Script} must be located inside of <code>projectTarget</code> or <code>projectSource</code>.
     *     This method first tries to load the {@link Script} from the <code>projectTarget</code> before it tries to 
     *     load the {@link Script} from the <code>projectSource</code>.
     * 
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     * @throws ModelManagementException In case that the available information
     *     may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     */
    public static void instantiate(File projectSource, File projectTarget, ModelLoadDefinition ivmlDefinition,
        ModelLoadDefinition vilDefinition) throws PersistenceException, IOException, ModelManagementException, 
        VilException {
        instantiate(projectSource, projectTarget, ivmlDefinition, vilDefinition, null);
    }
    
    /**
     * Uses <code>projectSource</code> to instantiate <code>projectTarget</code>.
     * The folder <code>projectTarget</code> will be created, if it does not exist.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlDefinition A (model name, version) pair for specifying which {@link Project} should be used for
     *     instantantion.
     *     The {@link Project} must be located inside of <code>projectTarget</code> or <code>projectSource</code>.
     *     This method first tries to load the {@link Project} from the <code>projectTarget</code> before it tries to 
     *     load the {@link Project} from the <code>projectSource</code>.
     * @param vilDefinition A (model name, version) pair for specifying which {@link Script} should be used for
     *     instantantion.
     *     The {@link Script} must be located inside of <code>projectTarget</code> or <code>projectSource</code>.
     *     This method first
     *     tries to load the {@link Script} from the <code>projectTarget</code> before it tries to load the 
     *     {@link Script} from the <code>projectSource</code>.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     * @throws ModelManagementException In case that the available information
     *     may become inconsistent due to this update
     * @throws VilException In case that artifact operations or script execution fails
     */
    public static void instantiate(File projectSource, File projectTarget, ModelLoadDefinition ivmlDefinition,
        ModelLoadDefinition vilDefinition, Map<String, Object> arguments) 
        throws PersistenceException, IOException, ModelManagementException, VilException {
        
        /*
         * Create trg and copy EASy files, if it does not exist. In the next step the files will be loaded,
         * maybe from the newly created location.
         */
        createTargetFolder(projectSource, projectTarget);
        
        // Adds the project folder to all 3 models. In case of an error, only the last exception will be thrown.
        Configuration configSource = PersistenceUtils.getConfiguration(projectSource);
        Configuration configTarget = PersistenceUtils.getConfiguration(projectTarget);
        PersistenceUtils.addLocation(configSource, ProgressObserver.NO_OBSERVER);    
        PersistenceUtils.addLocation(configTarget, ProgressObserver.NO_OBSERVER);
        
        Project ivmlProject = Utils.loadPreferredModel(VarModel.INSTANCE, ivmlDefinition, projectTarget, projectSource);
        Script script = Utils.loadPreferredModel(BuildModel.INSTANCE, vilDefinition, projectTarget, projectSource);
        
        // Create temporary PLPs
        if (null != ivmlProject && null != script) {
            createPLPsAndInstantiate(projectSource, projectTarget, ivmlProject, script, arguments);
        } else {
            throw new PersistenceException("The specified IVML/VIL files could not be loaded.");
        }
    }

    /**
     * Checks whether <code>maybeChild</code> is nested inside of <code>possibleParent</code>.
     * 
     * @param possibleParent A folder which may contain <code>maybeChild</code>.
     * @param maybeChild A file or folder which should be located inside of <code>possibleParent</code>.
     * @return <code>true</code> if <code>maybeChild</code> is nested inside of <code>possibleParent</code>,
     *     <code>false</code> otherwise.
     * 
     * @see <a href=
     * "http://stackoverflow.com/questions/4746671/how-to-check-if-a-given-path-is-possible-child-of-another-path">
     * http://stackoverflow.com/questions/4746671/how-to-check-if-a-given-path-is-possible-child-of-another-path</a>
     */
    private static boolean checkIsNestedFile(File possibleParent, File maybeChild) {
        boolean isNested = false;
        
        File parent = null;
        try {
            parent = possibleParent.getCanonicalFile();
        } catch (IOException e1) {
            // Not needed.
        }
        
        String child = null;
        try {
            child = maybeChild.getCanonicalPath();
        } catch (IOException e) {
            // Not needed.
        }
        if (null != parent && null != child) {
            isNested = child.startsWith(parent.getAbsolutePath());
        }
        return isNested;
    }
    
    /**
     * Creates <code>projectTarget</code> if it does not exist. Copies also all configuration files, i.e. the EASy 
     * folder from <code>projectSource</code> to <code>projectTarget</code>.
     * 
     * @param projectSource A EASy project which contains a EASy folder with IVML/VIL files.
     * @param projectTarget The folder which shall be created.
     * 
     * @throws PersistenceException Will be thrown if the folder could not be created.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    private static void createTargetFolder(File projectSource, File projectTarget) throws PersistenceException,
        IOException {
        
        if (!projectTarget.exists()) {
            if (!projectTarget.mkdir()) {
                throw new PersistenceException("Folder " + projectTarget.getAbsolutePath() + " does not exist and "
                    + "could not be created.");
            }
            
            File easySrcFiles = new File(projectSource, PersistenceConstants.EASY_FILES_DEFAULT);
            File easyTrgFiles = new File(projectTarget, PersistenceConstants.EASY_FILES_DEFAULT);
            FileUtils.copyDirectory(easySrcFiles, easyTrgFiles);
        }
    }

//    public static void instantiate(File projectSRC, File projectTRG, File ivmlFile) {
//        // im Folder mittels mainBS instantiiert
//    }
//    
//    public static void instantiate(File projectSRC, File projectTRG, String ivmlName) {
//        instantiate(projectSRC, projectTRG, ivmlName, null);
//    }
//
//    public static void instantiate(File projectSRC, File projectTRG, Version v) {
//        //
//    }
//    
//    public static void instantiate(File projectSRC, File projectTRG, String ivmlName, Version v) {
//        // im Folder mittels mainBS instantiiert
//    }    
}
