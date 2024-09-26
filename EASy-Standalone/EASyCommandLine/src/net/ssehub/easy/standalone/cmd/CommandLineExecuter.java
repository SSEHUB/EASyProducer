package net.ssehub.easy.standalone.cmd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy.loader.ManifestLoader;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.LoggingLevel;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.EASyPersistencer;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.reasoning.core.reasoner.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;

/**
 * Class for executing EASy commands via the command line. Potential 
 * system return values: {@link CmdConstants}. The result file (by default {@code .result}) can be defined via the 
 * command line option {@code --resultFile=<i>fileOrFolder</i>} (no spaces around "=").
 * 
 * @author El-Sharkawy
 */
public class CommandLineExecuter {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(CommandLineExecuter.class,
        Utils.BUNDLE_ID);
    private static final List<String> OPTIONS = new ArrayList<String>();
    private static final String OPT_RESULTFILE = "--resultFile"; 
    private static final boolean DEBUG = "DEBUG".equals(System.getProperty("de.uni_hildesheim.sse.easy.logging.level"));
    
    static {
        OPTIONS.add(OPT_RESULTFILE);
    }

    /**
     * Prints the command line help.
     */
    private static void printHelp() {
        System.out.println("Help (more infos in readme and programmers guide):");
        System.out.println(" - instantiate (source -> target):");
        System.out.println("   instantiate <src_folder> <trg_folder>");
        System.out.println("   instantiate <src_folder> <trg_folder> <absolute path to ivml_file>");
        System.out.println("     <absolute path to vil_file>");
        System.out.println("   instantiate <src_folder> <trg_folder> <ivml name> <ivml version>");
        System.out.println("     <vil name> <vil version>");
        System.out.println(" - self-instantiation (folder -> folder):");
        System.out.println("   instantiateSelf <project_folder>");
        System.out.println("   instantiateSelf <project_folder> <absolute path to ivml_file>");
        System.out.println("   instantiateSelf <project_folder> <absolute path to ivml_file>");
        System.out.println("     <absolute path to vil_file>");
        System.out.println(" - checking validity / reasoning:");
        System.out.println("   checkValidity <project_folder>");
        System.out.println("   checkValidity <project_folder> <absolute path to ivml_file>");
        System.out.println("   checkValidity <project_folder> <ivml project name> <ivml project version>");
        System.out.println(" - PLP operations:");
        System.out.println("   createPLP <project_folder> (flavour)*");
        System.out.println("   showFlavours");
        System.out.println("   setPredecessors <project_folder> <project_folder>*");
        System.out.println("   pullConfig <project_folder>");
    }
    
    /**
     * Main method for testing.
     * @param args Specification which method shall be executed. Also possibility to pass arguments to the selected
     *     method.
     */
    public static void main(String[] args) {
        System.out.println("EASy-Producer CLI");
        if (args.length == 0) {
            printHelp();
        }
        int result = CmdConstants.SYSTEM_OK;
        try {
            ManifestLoader loader = new ManifestLoader(DEBUG);
            loader.startup();
            if (DEBUG) {
                EASyLoggerFactory.INSTANCE.setLoggingLevel(LoggingLevel.DEBUG);
                TracerFactory.setDefaultInstance(ConsoleTracerFactory.INSTANCE);
            }
            if (null != args && args.length > 1) {
                Map<String, String> options = new HashMap<String, String>();
                args = pruneArguments(args, options);
                switch(args[0]) {
                case "instantiateSelf":
                    result = instantiateSelf(args, options);
                    break;
                case "instantiate":
                    result = instantiate(args, options);
                    break;
                case "checkValidity":
                    result = checkValidity(args, options);
                    break;
                case "setPredecessors":
                    result = setPredecessors(args, options, true);
                    break;
                case "pullConfig":
                    result = pullConfig(args, options, true);
                    break;
                case "createPLP":
                    result = createPLP(args, options, true);
                    break;
                default:
                    break;
                }
            } else if (null != args && args.length == 1) {
                switch(args[0]) {
                case "showFlavours":
                    System.out.println("Available flavours:");
                    ProjectCreationFlavour.forEach(
                        f -> System.out.println(" - " + f.getName() + ": " + f.getDescription()));
                    break;
                default:
                    break;
                }
            }
            loader.shutdown();
        } catch (IOException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_IO_EXC;
        }
        System.exit(result);
    }

    /**
     * Handles the instantiateSelf method calls.
     * @param args The arguments for the instantiateSelf method calls.
     * @param options additional command line options extracted from {@code args}
     * @return command line result value
     */
    private static int instantiateSelf(String[] args, Map<String, String> options) {
        int result = CmdConstants.SYSTEM_OK;
        try {
            File project = new File(args[1]);
            switch (args.length) {
            case 2:
                InstantiationCommands.instantiateSelf(project);
                break;
            case 3:
                File ivmlFile1 = new File(args[2]);
                InstantiationCommands.instantiateSelf(project, ivmlFile1);
                break;
            case 4:
                File ivmlFile2 = new File(args[2]);
                File vilFile = new File(args[3]);
                InstantiationCommands.instantiateSelf(project, ivmlFile2, vilFile);
                break;
            default:
                LOGGER.warn("Unspecified combination of arguments passed. # Arguments = " + args.length);
                break;
            }
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_MODELMGT_EXC;
        } catch (VilException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_VIL_EXC;
        } catch (PersistenceException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_PERSISTENCE_EXC;
        }  catch (IndexOutOfBoundsException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_INDEX_EXC;
        }
        return result;
    }
    
    /**
     * Handles the instantiate method calls.
     * @param args The arguments for the instantiate method calls.
     * @param options additional command line options extracted from {@code args}
     * @return command line result value
     */
    private static int instantiate(String[] args, Map<String, String> options) {
        int result = CmdConstants.SYSTEM_OK;
        try {
            File projectSRC = new File(args[1]);
            File projectTRG = new File(args[2]);
            switch (args.length) {
            case 3:
                InstantiationCommands.instantiate(projectSRC, projectTRG);
                break;
            case 5:
                File ivmlFile = new File(args[3]);
                File vilFile = new File(args[4]);
                InstantiationCommands.instantiate(projectSRC, projectTRG, ivmlFile, vilFile);
                break;
            case 7:
                ModelLoadDefinition ivmlDef = new ModelLoadDefinition(args[3], args[4]);
                ModelLoadDefinition vilDef = new ModelLoadDefinition(args[5], args[6]);
                InstantiationCommands.instantiate(projectSRC, projectTRG, ivmlDef, vilDef);
                break;
            default:
                LOGGER.warn("Unspecified combination of arguments passed. # Arguments = " + args.length);
                break;
            }
        } catch (VilException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_VIL_EXC;
        } catch (PersistenceException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_PERSISTENCE_EXC;
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_MODELMGT_EXC;
        } catch (SecurityException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_SECURITY_EXC;
        } catch (IOException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_IO_EXC;
        } catch (NullPointerException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_NPE_EXC;
        } catch (VersionFormatException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_VERSION_EXC;
        }  catch (IndexOutOfBoundsException e) {
            LOGGER.exception(e);
            result = CmdConstants.SYSTEM_INDEX_EXC;
        }
        return result;
    }
    
    /**
     * Checks an argument for a known option.
     * 
     * @param arg the argument to check
     * @param options the optional option result (to be modified as a side effect)
     * @return {@code true} if {@code arg} is an option and has been stored in {@code options} if not <b>null</b>, 
     *     {@code false} else (usual command line argument)
     */
    private static boolean checkForOption(String arg, Map<String, String> options) {
        String optName = null;
        String optValue = null;
        for (int o = 0; null == optName && o < OPTIONS.size(); o++) {
            String argName = OPTIONS.get(o);
            if (arg.equals(argName)) {
                optName = argName;
            } else if (arg.startsWith(argName + "=")) {
                if (arg.length() > argName.length() + 1) {
                    optName = argName;
                    optValue = arg.substring(argName.length() + 1);
                }
            }
            if (null != options && null != optName) {
                options.put(optName, optValue);
            }
        }
        return null != optName;
    }

    /**
     * Prunes the argument list for known options.
     * 
     * @param args the arguments to check
     * @param options the optional option result (to be modified as a side effect)
     * @return the pruned arguments
     */
    private static String[] pruneArguments(String[] args, Map<String, String> options) {
        List<String> tmpArgs = new ArrayList<String>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (!checkForOption(arg, options)) {
                tmpArgs.add(arg);
            }
        }
        args = new String[tmpArgs.size()];
        return tmpArgs.toArray(args);
    }

    /**
     * Pulls the configuration.
     * 
     * @param args The arguments for the validity check.
     * @param options additional command line options extracted from {@code args}
     * @param add add or remove the specified predecessors
     * @return command line result value
     */
    private static int pullConfig(String[] args, Map<String, String> options, boolean add) {
        int cmdResult = CmdConstants.SYSTEM_OK;
        File project = new File(args[1]);
        try {
            LowlevelCommands.loadProject(project);
            String projectName = ProjectNameMapper.getInstance().getName(project);
            PLPInfo plp = LowlevelCommands.getProject(projectName);
            plp.pullConfigFromPredecessors();
        } catch (PersistenceException e) {
            LOGGER.error("Predecessors command execution failed: " + e.getMessage());
            cmdResult = CmdConstants.SYSTEM_PERSISTENCE_EXC;
        }
        return cmdResult;
    }

    /**
     * Creates a PLP.
     * 
     * @param args The arguments for the validity check.
     * @param options additional command line options extracted from {@code args}
     * @param add add or remove the specified predecessors
     * @return command line result value
     */
    private static int createPLP(String[] args, Map<String, String> options, boolean add) {
        int cmdResult = CmdConstants.SYSTEM_OK;
        File project = new File(args[1]);
        try {
            if (project.exists()) {
                if (project.listFiles() != null) {
                    LOGGER.error("Project folder may exist but must be empty.");
                    cmdResult = CmdConstants.SYSTEM_IO_EXC;
                }
            } else {
                project.mkdirs();
            }
            List<ProjectCreationFlavour> flavours = ProjectCreationFlavour.getFlavours(
                Arrays.copyOfRange(args, 1, args.length));
            EASyPersistencer persistencer = new EASyPersistencer(project);
            ProjectCreationFlavour.forEach(flavours, f -> f.configure(persistencer));
            IProjectCreationResult result = persistencer.createProject(project.getName(), 
                project.getParentFile(), null, true);
            persistencer.populateEasyProject(result);
            ProjectCreationFlavour.forEach(flavours, f -> f.apply(project));
        } catch (PersistenceException e) {
            LOGGER.error("Creating PLP failed: " + e.getMessage());
            cmdResult = CmdConstants.SYSTEM_PERSISTENCE_EXC;
        }
        return cmdResult;
    }

    /**
     * Modifies the predecessors.
     * 
     * @param args The arguments for the validity check.
     * @param options additional command line options extracted from {@code args}
     * @param add add or remove the specified predecessors
     * @return command line result value
     */
    private static int setPredecessors(String[] args, Map<String, String> options, boolean add) {
        int cmdResult = CmdConstants.SYSTEM_OK;
        if (args.length < 2) {
            LOGGER.error("Predecessors command requires at least two arguments.");
            cmdResult = CmdConstants.SYSTEM_INDEX_EXC;
        } else {
            try {
                File project = new File(args[1]);
                LowlevelCommands.loadProject(project);
                String projectName = ProjectNameMapper.getInstance().getName(project);
                PLPInfo plp = LowlevelCommands.getProject(projectName);
                List<PLPInfo> preds = new ArrayList<>();
                boolean ok = true;
                // load preds, otherwise PLPInfo will not add them
                for (int p = 2; ok && p < args.length; p++) {
                    File pred = new File(args[p]);
                    if (pred.exists()) {
                        LowlevelCommands.loadProject(pred);
                        String predName = ProjectNameMapper.getInstance().getName(pred);
                        PLPInfo plpInfo = LowlevelCommands.getProject(predName);
                        SPLsManager.INSTANCE.addPLP(plpInfo);
                        preds.add(plpInfo);
                    } else {
                        LOGGER.error("Specified project " + args[p] + " is not a valid predecessor of " 
                            + projectName + ". Canceling operation.");
                        ok = false;
                    }
                }

                // search for PLPs and add them
                List<String> input = plp.getMemberController().getPossiblePredecessors();
                ArrayList<String> newPredecessors = new ArrayList<>();
                for (int p = 0; ok && p < preds.size(); p++) {
                    PLPInfo pred = preds.get(p);
                    if (null == input || input.contains(pred.getProjectID())) {
                        newPredecessors.add(pred.getProjectID());
                    } else {
                        LOGGER.error("Specified project " + pred.getProjectName() + " is not a valid predecessor of " 
                            + projectName + ". Canceling operation.");
                        ok = false;
                    }
                }
                if (ok) {
                    boolean changed = plp.setPredecessors(newPredecessors);
                    if (changed) {
                        plp.save();
                    }
                    System.out.println("Setting predecessors " + newPredecessors + " on " + projectName 
                        + " (changed: " + changed + ")");
                } else {
                    cmdResult = CmdConstants.SYSTEM_NO_PREDECESSOR;
                }
            } catch (PersistenceException e) {
                LOGGER.error("Predecessors command execution failed: " + e.getMessage());
                cmdResult = CmdConstants.SYSTEM_PERSISTENCE_EXC;
            }
        }
        return cmdResult;
    }

    /**
     * Handles the validity check calls.
     * 
     * @param args The arguments for the validity check.
     * @param options additional command line options extracted from {@code args}
     * @return command line result value
     */
    private static int checkValidity(String[] args, Map<String, String> options) {
        int cmdResult = CmdConstants.SYSTEM_OK;
        ReasoningResult result = null;
        try {
            File project = new File(args[1]);
            switch (args.length) {
            case 2:
                result = ReasoningCommands.checkValidity(project);
                break;
            case 3:
                File ivmlFile = new File(args[2]);
                result = ReasoningCommands.checkValidity(project, ivmlFile);
                break;
            case 4:
                ModelLoadDefinition ivmlDef = new ModelLoadDefinition(args[2], args[3]);
                result = ReasoningCommands.checkValidity(project, ivmlDef);
                break;
            default:
                LOGGER.warn("Unspecified combination of arguments passed. # Arguments = " + args.length);
                break;
            }
            if (null != result) {
                File file;
                String path = options.get(OPT_RESULTFILE);
                if (null == path) {
                    file = new File(project, ".result");
                } else {
                    file = new File(path);
                    if (file.isDirectory()) {
                        file = new File(file, ".result");
                    }
                }
                PrintStream out = new PrintStream(new FileOutputStream(file));
                out.println(result.hasConflict());
                out.flush();
                out.close();
                
                String optionalNot = result.hasConflict() ? "not " : "";
                System.out.println("Reasoning result: The model is " + optionalNot + "valid");
                for (int m = 0; m < result.getMessageCount(); m++) {
                    Message msg = result.getMessage(m);
                    out.println(msg.getDescription());
                    out.println(" " + msg.getConflictComments());
                    out.println(" " + msg.getConflictSuggestions());
                }
                if (result.hasConflict()) {
                    cmdResult = CmdConstants.SYSTEM_REASONER_CONFLICT;
                }
            } else {
                cmdResult = CmdConstants.SYSTEM_NO_REASONER;
            }
        } catch (VersionFormatException e) {
            LOGGER.exception(e);
            cmdResult = CmdConstants.SYSTEM_VERSION_EXC;
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
            cmdResult = CmdConstants.SYSTEM_MODELMGT_EXC;
        } catch (IOException e) {
            LOGGER.exception(e);
            cmdResult = CmdConstants.SYSTEM_IO_EXC;
        } catch (PersistenceException e) {
            LOGGER.exception(e);
            cmdResult = CmdConstants.SYSTEM_PERSISTENCE_EXC;
        } catch (IndexOutOfBoundsException e) {
            LOGGER.exception(e);
            cmdResult = CmdConstants.SYSTEM_INDEX_EXC;
        }
        return cmdResult;
    }
    
}
