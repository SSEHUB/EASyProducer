package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.persistence.PersistenceException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;

/**
 * Class for executing EASy commands via the command line.
 * @author El-Sharkawy
 *
 */
public class CommandLineExecuter {

    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(CommandLineExecuter.class,
        Utils.BUNDLE_ID);
    
    /**
     * Main method for testing.
     * @param args Specification which method shall be executed. Also possibility to pass arguments to the selected
     *     method.
     */
    public static void main(String[] args) {
        try {
            LowlevelCommands.startEASy();
        } catch (IOException e1) {
            LOGGER.exception(e1);
        }
        
        
        if (null != args && args.length > 1) {
            if ("instantiateSelf".equals(args[0])) {
                instantiateSelf(args);
            } else if ("instantiate".equals(args[0])) {
                instantiate(args);
            } else if ("checkValidity".equals(args[0])) {
                checkValidity(args);
            }
        }
    }

    /**
     * Handles the instantiateSelf method calls.
     * @param args The arguments for the instantiateSelf method calls.
     */
    private static void instantiateSelf(String[] args) {
        File project = new File(args[1]);
        try {
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
        } catch (VilLanguageException e) {
            LOGGER.exception(e);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
        }
    }
    
    /**
     * Handles the instantiate method calls.
     * @param args The arguments for the instantiate method calls.
     */
    private static void instantiate(String[] args) {
        File projectSRC = new File(args[1]);
        File projectTRG = new File(args[2]);
        try {
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
        } catch (VilLanguageException e) {
            LOGGER.exception(e);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        } catch (SecurityException e) {
            LOGGER.exception(e);
        } catch (IOException e) {
            LOGGER.exception(e);
        } catch (NullPointerException e) {
            LOGGER.exception(e);
        } catch (VersionFormatException e) {
            LOGGER.exception(e);
        }
    }
    
    /**
     * Handles the validity check calls.
     * 
     * @param args The arguments for the validity check.
     */
    private static void checkValidity(String[] args) {
        Boolean result = null;
        try {
            File project = new File(args[1]);
            switch (args.length) {
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
                File file = new File(project, ".result");
                PrintStream out = new PrintStream(new FileOutputStream(file));
                out.println(result);
                out.flush();
                out.close();
            }
        } catch (VersionFormatException e) {
            LOGGER.exception(e);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        } catch (IOException e) {
            LOGGER.exception(e);
        } 
    }
    
}
