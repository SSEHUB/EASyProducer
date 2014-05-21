package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ScriptContainer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.VilArgumentProvider;
import de.uni_hildesheim.sse.easy_producer.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.modelManagement.ProjectContainer;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Static commands for instantiating projects via the command line or by a build tool. Files/Folders 
 * to be passed in through this interface shall be absolute!<br/>
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
     * Instatiates the given project.
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    public static void instantiateSelf(File project) throws PersistenceException, VilLanguageException {
        instantiateSelf(project, (Map<String, Object>) null);
    }
    
    /**
     * Instatiates the given project.
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    public static void instantiateSelf(File project, Map<String, Object> arguments) 
        throws PersistenceException, VilLanguageException {
        // This is the usual way:
        VilArgumentProvider provider = createArgumentProvider(arguments);
        LowlevelCommands.loadProject(project);
        String projectName = project.getName();
        PLPInfo plp = LowlevelCommands.getProject(projectName);
        if (null != plp) {
            plp.instantiate(null);
        } else {
            throw new PersistenceException("Project \"" + projectName + "\" could not be loaded.");
        }
        VilArgumentProvider.remove(provider); // works with null as argument
    }

    /**
     * Instatiates the given project.
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile) throws ModelManagementException,
        VilLanguageException, PersistenceException {
        instantiateSelf(project, ivmlFile, (Map<String, Object>) null);
    }
    
    /**
     * Instatiates the given project.
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, Map<String, Object> arguments) 
        throws ModelManagementException, VilLanguageException, PersistenceException {
        
        // This is an unusual way (a hack):  
        // Determine default build script location
        String projectName = project.getName();
        File configFolder = PersistenceUtils.getLocationFile(project, PathKind.IVML);
        String path = PersistenceUtils.vilFileLocation(projectName, "0", configFolder.getAbsolutePath());
        File buildScriptFile = new File(path);
        
        instantiateSelf(project, ivmlFile, buildScriptFile, arguments);
    }

    /**
     * Instatiates the given project. <br />
     * It's <b>not</b> necessary that the project has a valid EASy structure. This method is a convenience wrapper for 
     * {@link #instantiateSelf(File, File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param project The toplevel absolute folder of the project
     * @param ivmlFile A frozen configuration, which should be used for instantiation.
     * @param buildScriptFile The main build script (starting point) which should be used for instantiation.
     * 
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, File buildScriptFile)
        throws ModelManagementException, VilLanguageException, PersistenceException {
        instantiateSelf(project, ivmlFile, buildScriptFile, null);
    }
    
    /**
     * Instatiates the given project. <br />
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     */
    public static void instantiateSelf(File project, File ivmlFile, File buildScriptFile, Map<String, Object> arguments)
        throws ModelManagementException, VilLanguageException, PersistenceException {
        
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
            String projectName = project.getName();
            ProjectContainer pCont = new ProjectContainer(ivmlProject, ivmlFile.getParentFile());
            ScriptContainer sCont = new ScriptContainer(buildScript, buildScriptFile.getParentFile());
            PLPInfo plp = new ProductLineProject(UUID.randomUUID().toString(), projectName, pCont, project, sCont);
            plp.instantiate(null);
            VilArgumentProvider.remove(provider); // ok if provider is null
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
     * Instantiates the project <tt>projectTarget</tt>, while using source files (and IVML/VIL information) provided
     * by <tt>projectSource</tt>.
     * The following conditions must be hold:
     * <ol>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><tt>projectTarget</tt> must contain a contain a frozen configuration.</li>
     * <li><tt>projectTarget</tt> must contain VIL script.</li>
     * <li><tt>projectSource</tt> must contain a infrastructure, which cen be instantiated, e.g. annotated source files.
     *     </li>
     * </ol>
     * If <tt>projectTarget</tt> does not exist, this method will create the folder. In this case, 2.) and 3.) must be
     * included in <tt>projectSource</tt>.
     * This method is a convenience wrapper for {@link #instantiate(File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param projectSource The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     serves as a basis for instantiation.
     * @param projectTarget The toplevel absolute folder of an EASy project (must have a valid EASy structure), which 
     *     should be instantiated.
     * 
     * @throws PersistenceException Will be thrown if one of the projects could not be loaded,
     *     e.g. if the project has no valid EASy structure.
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget) throws PersistenceException,
        VilLanguageException, IOException {
        instantiate(projectSource, projectTarget, null);
    }
    
    /**
     * Instantiates the project <tt>projectTarget</tt>, while using source files (and IVML/VIL information) provided
     * by <tt>projectSource</tt>.
     * The following conditions must be hold:
     * <ol>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><tt>projectTarget</tt> must contain a contain a frozen configuration.</li>
     * <li><tt>projectTarget</tt> must contain VIL script.</li>
     * <li><tt>projectSource</tt> must contain a infrastructure, which cen be instantiated, e.g. annotated source files.
     *     </li>
     * </ol>
     * If <tt>projectTarget</tt> does not exist, this method will create the folder. In this case, 2.) and 3.) must be
     * included in <tt>projectSource</tt>.
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, Map<String, Object> arguments) 
        throws PersistenceException, VilLanguageException, IOException {
        
        if (projectSource.exists() && projectTarget.exists()) {
            // This is the usual way:
            instantiateEASyProjects(projectSource, projectTarget, arguments);
        } else if (!projectTarget.exists()) {
            VilArgumentProvider provider = createArgumentProvider(arguments);
            
            // Unusual way: use IVML/VIL files form source and create new empty project for instantiation
            // 1. Creates the targetFolder (and copies EASy files to target).
            createTargetFolder(projectSource, projectTarget);
            
            // 2. Load Predecessor
            LowlevelCommands.loadProject(projectSource);
            String projectName =  projectSource.getName();
            PLPInfo plpPre = LowlevelCommands.getProject(projectName);
            
            // 3. Extract variability information
            Project ivmlProject = plpPre.getProject();
            Configuration configTarget = PersistenceUtils.getConfiguration(projectTarget);
            String projectFolderPath = configTarget.getPath(PathKind.IVML);
            File projectFolder = new File(projectFolderPath);
            Script buildScript = plpPre.getBuildScript();
            String scriptFolderPath = configTarget.getPath(PathKind.VIL);
            File scriptFolder = new File(scriptFolderPath);
            
            // 4. Create successor with extracted information.
            String projectNameTrg = projectTarget.getName();
            ProjectContainer pCont = new ProjectContainer(ivmlProject, projectFolder);
            ScriptContainer sCont = new ScriptContainer(buildScript, scriptFolder);
            PLPInfo plpSuc = new ProductLineProject(UUID.randomUUID().toString(), projectNameTrg, pCont,
                projectTarget, sCont);
            plpSuc.getMemberController().addPredecessor(plpPre);
            plpSuc.instantiate(null);
            
            VilArgumentProvider.remove(provider); // works with null as argument
        }
    }

    /**
     * Instantiates the project <tt>projectTarget</tt>, while using source files (and IVML/VIL information) provided
     * by <tt>projectSource</tt>.
     * The following conditions must be hold:
     * <ul>
     * <li>Both projects must exist and have a valid EASy project structure with the usual configuration files, IDs,
     *     and folders.</li>
     * <li><tt>projectTarget</tt> must contain a contain a frozen configuration.</li>
     * <li><tt>projectTarget</tt> must contain VIL script.</li>
     * <li><tt>projectSource</tt> must contain a infrastructure, which cen be instantiated, e.g. annotated source files.
     *     </li>
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
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    private static void instantiateEASyProjects(File projectSource, File projectTarget, Map<String, Object> arguments) 
        throws PersistenceException, VilLanguageException {
            
        VilArgumentProvider provider = createArgumentProvider(arguments);
        
        // This is the usual way:
        LowlevelCommands.loadProject(projectSource);
        LowlevelCommands.loadProject(projectTarget);
        String projectName =  projectTarget.getName();
        PLPInfo plp = LowlevelCommands.getProject(projectName);
        
        if (null != plp) {
            plp.instantiate(null);
        } else {
            throw new PersistenceException("Project \"" + projectName + "\" could not be loaded.");
        }
        
        VilArgumentProvider.remove(provider); // works with null as argument
    }
    
    /**
     * Uses <tt>projectSource</tt> to instantiate <tt>projectTarget</tt>.
     * The folder <tt>projectTarget</tt> will be created, if it does not exist. This method is a convenience wrapper 
     * for {@link #instantiate(File, File, File, File, Map)} with <b>null</b> as arguments.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlFile The model definition including its frozen configuration, which should be used for instantiation.
     *     (Must be inside either of <tt>projectSource</tt> or <tt>projectTarget</tt>).
     * @param scriptFile The main build script (starting point) which should be used for instantiation.
     *     (Must be inside either of <tt>projectSource</tt> or <tt>projectTarget</tt>).
     * 
     * @throws SecurityException If <tt>projectTarget</tt> does not exist, a security manager exists,
     *     and its <code>{@link java.lang.SecurityManager#checkWrite(java.lang.String)}</code>
     *     method does not permit <tt>projectTarget</tt> directory to be created
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, File ivmlFile, File scriptFile) 
        throws ModelManagementException, SecurityException, PersistenceException, VilLanguageException, IOException {
        instantiate(projectSource, projectTarget, ivmlFile, scriptFile, null);
    }
    
    /**
     * Uses <tt>projectSource</tt> to instantiate <tt>projectTarget</tt>.
     * The folder <tt>projectTarget</tt> will be created, if it does not exist.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files 
     *     to instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlFile The model definition including its frozen configuration, which should be used for instantiation.
     *     (Must be inside either of <tt>projectSource</tt> or <tt>projectTarget</tt>).
     * @param scriptFile The main build script (starting point) which should be used for instantiation.
     *     (Must be inside either of <tt>projectSource</tt> or <tt>projectTarget</tt>).
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws SecurityException If <tt>projectTarget</tt> does not exist, a security manager exists,
     *     and its <code>{@link java.lang.SecurityManager#checkWrite(java.lang.String)}</code>
     *     method does not permit <tt>projectTarget</tt> directory to be created
     * @throws ModelManagementException In case that the available information
     *   may become inconsistent due to this update
     * @throws VilLanguageException In case that artifact operations or script execution fails
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     */
    public static void instantiate(File projectSource, File projectTarget, File ivmlFile, File scriptFile, 
        Map<String, Object> arguments) throws ModelManagementException, SecurityException, PersistenceException, 
        VilLanguageException, IOException {
        
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
     * @param ivmlProject A loaded configuration, which should be used for instantiation (Must not be <tt>null</tt>).
     * @param buildScript A loaded build script, which should be used for instantiation (Must not be <tt>null</tt>).
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    private static void createPLPsAndInstantiate(File projectSource, File projectTarget, Project ivmlProject,
        Script buildScript, Map<String, Object> arguments) throws VilLanguageException {
        
        VilArgumentProvider provider = createArgumentProvider(arguments);
        
        // Create Predecessor
        String projectNameSrc = projectSource.getName();
        PLPInfo plpPre = new ProductLineProject(projectNameSrc, projectSource);
        
        // Create Successor
        Configuration config = PersistenceUtils.getConfiguration(projectTarget);
        File projectFolder = new File(config.getPath(PathKind.IVML));
        File scriptFolder = new File(config.getPath(PathKind.VIL));
        
        String projectNameTrg = projectTarget.getName();
        ProjectContainer pCont = new ProjectContainer(ivmlProject, projectFolder);
        ScriptContainer sCont = new ScriptContainer(buildScript, scriptFolder);
        PLPInfo plpSuc = new ProductLineProject(UUID.randomUUID().toString(), projectNameTrg, pCont,
            projectTarget, sCont);
        plpSuc.getMemberController().addPredecessor(plpPre);
        plpSuc.instantiate(null);
        
        VilArgumentProvider.remove(provider); // works with null as argument
    }

    /**
     * Uses <tt>projectSource</tt> to instantiate <tt>projectTarget</tt>.
     * The folder <tt>projectTarget</tt> will be created, if it does not exist. This method is a convenience wrapper 
     * for {@link #instantiate(File, File, ModelLoadDefinition, ModelLoadDefinition, Map)} with <b>null</b> 
     * as arguments.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlDefinition A (model name, version) pair for specifying which {@link Project} should be used for
     *     instantantion.
     *     The {@link Project} must be located inside of <tt>projectTarget</tt> or <tt>projectSource</tt>.
     *     This method first
     *     tries to load the {@link Project} from the <tt>projectTarget</tt> before it tries to load the {@link Project}
     *     from the <tt>projectSource</tt>.
     * @param vilDefinition A (model name, version) pair for specifying which {@link Script} should be used for
     *     instantantion.
     *     The {@link Script} must be located inside of <tt>projectTarget</tt> or <tt>projectSource</tt>.
     *     This method first
     *     tries to load the {@link Script} from the <tt>projectTarget</tt> before it tries to load the {@link Script}
     *     from the <tt>projectSource</tt>.
     * 
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     * @throws ModelManagementException In case that the available information
     *     may become inconsistent due to this update
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    public static void instantiate(File projectSource, File projectTarget, ModelLoadDefinition ivmlDefinition,
        ModelLoadDefinition vilDefinition) throws PersistenceException, IOException, ModelManagementException, 
        VilLanguageException {
        instantiate(projectSource, projectTarget, ivmlDefinition, vilDefinition, null);
    }
    
    /**
     * Uses <tt>projectSource</tt> to instantiate <tt>projectTarget</tt>.
     * The folder <tt>projectTarget</tt> will be created, if it does not exist.
     * 
     * @param projectSource An absolute folder/project, which contains the product line infrastructure, i.e. files to 
     *     instantiate.
     * @param projectTarget An absolute folder/project where the files should be instantiated in. The folder will be 
     *     created if it does not exist.
     * @param ivmlDefinition A (model name, version) pair for specifying which {@link Project} should be used for
     *     instantantion.
     *     The {@link Project} must be located inside of <tt>projectTarget</tt> or <tt>projectSource</tt>.
     *     This method first
     *     tries to load the {@link Project} from the <tt>projectTarget</tt> before it tries to load the {@link Project}
     *     from the <tt>projectSource</tt>.
     * @param vilDefinition A (model name, version) pair for specifying which {@link Script} should be used for
     *     instantantion.
     *     The {@link Script} must be located inside of <tt>projectTarget</tt> or <tt>projectSource</tt>.
     *     This method first
     *     tries to load the {@link Script} from the <tt>projectTarget</tt> before it tries to load the {@link Script}
     *     from the <tt>projectSource</tt>.
     * @param arguments a name-element mapping specifying the top-level parameter of a VIL instantiation (may 
     *   be <b>null</b>)
     * 
     * @throws PersistenceException Will be thrown if at least one of the IVML or VIL files could not be loaded.
     * @throws IOException If source or destination is invalid, or if an IO error occurs during copying
     * @throws ModelManagementException In case that the available information
     *     may become inconsistent due to this update
     * @throws VilLanguageException In case that artifact operations or script execution fails
     */
    public static void instantiate(File projectSource, File projectTarget, ModelLoadDefinition ivmlDefinition,
        ModelLoadDefinition vilDefinition, Map<String, Object> arguments) 
        throws PersistenceException, IOException, ModelManagementException, VilLanguageException {
        
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
     * Checks whether <tt>maybeChild</tt> is nested inside of <tt>possibleParent</tt>.
     * 
     * @param possibleParent A folder which may contain <tt>maybeChild</tt>.
     * @param maybeChild A file or folder which should be located inside of <tt>possibleParent</tt>.
     * @return <tt>true</tt> if <tt>maybeChild</tt> is nested inside of <tt>possibleParent</tt>,
     *     <tt>false</tt> otherwise.
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
     * Creates <tt>projectTarget</tt> if it does not exist. Copies also all configuration files, i.e. the EASy folder
     * from <tt>projectSource</tt> to <tt>projectTarget</tt>.
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
