package net.ssehub.easy.standalone.cmd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy.loader.ListLoader;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.persistence.PersistenceException;

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
    
    static {
        OPTIONS.add(OPT_RESULTFILE);
    }
    
    /**
     * Main method for testing.
     * @param args Specification which method shall be executed. Also possibility to pass arguments to the selected
     *     method.
     */
    public static void main(String[] args) {
        int result = CmdConstants.SYSTEM_OK;
        try {
            ListLoader loader = new ListLoader();
            //loader.setVerbose(true);
            loader.startup();

            if (null != args && args.length > 1) {
                Map<String, String> options = new HashMap<String, String>();
                args = pruneArguments(args, options);
                if ("instantiateSelf".equals(args[0])) {
                    result = instantiateSelf(args, options);
                } else if ("instantiate".equals(args[0])) {
                    result = instantiate(args, options);
                } else if ("checkValidity".equals(args[0])) {
                    result = checkValidity(args, options);
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
     * Handles the validity check calls.
     * 
     * @param args The arguments for the validity check.
     * @param options additional command line options extracted from {@code args}
     * @return command line result value
     */
    private static int checkValidity(String[] args, Map<String, String> options) {
        int cmdResult = CmdConstants.SYSTEM_OK;
        Boolean result = null;
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
                out.println(result);
                out.flush();
                out.close();
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
