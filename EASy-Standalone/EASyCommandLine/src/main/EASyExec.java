package main;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import de.uni_hildesheim.sse.easy.cmd.InstantiationCommands;
import de.uni_hildesheim.sse.easy.cmd.LowlevelCommands;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Class for presenting and testing the EASy command line functionalities.
 * @author El-Sharkawy
 *
 */
public final class EASyExec {
    private static final String WS_PATH = "C:/Elscha/Eclipse/runtime-EclipseApplication2";
    private static final File WS_FILE = new File(WS_PATH);
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(EASyExec.class, "EASyCommandLine");
   
    /**
     * Main method for testing.
     * @param args Will be ignored.
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
            }
        } else {
            runDemo();
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
            default:
                LOGGER.warn("Unspecified combination of arguments passed. # Arguments = " + args.length);
                break;
            }
        } catch (VilLanguageException e) {
            LOGGER.exception(e);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
        } catch (IOException e) {
            LOGGER.exception(e);
        }
    }

    /**
     * Example how to load an EASy project.
     */
    private static void runDemo() {
        LOGGER.info("Running static example");
        LowlevelCommands.loadWorkspace(WS_FILE);
        
        PLPInfo plp = LowlevelCommands.getProject("New_Product");
        
        
        // Output the configuration of the project
        if (null != plp) {
            Configuration config = plp.getConfiguration();
            System.out.println("Anzahl Variablen: " + config.getDecisionCount());
            Iterator<IDecisionVariable> itr = config.iterator();
            while (itr.hasNext()) {
                IDecisionVariable var = itr.next();
                System.out.println(var.getDeclaration().getName() + " = " + var.getValue());
            }
        }
    }

}
