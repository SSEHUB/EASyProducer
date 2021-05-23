package main;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.standalone.cmd.InstantiationCommands;
import net.ssehub.easy.standalone.cmd.LowlevelCommands;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Class for presenting and testing the EASy command line functionalities. System return values: {@link #SYSTEM_OK} if
 * the execution is ok, {@link #SYSTEM_IO_EXC} if an I/O problem occurred, {@link #SYSTEM_MODELMGT_EXC} if a model
 * management problem occurred, {@link #SYSTEM_PERSISTENCE_EXC} if a high-level EASy problem (persistence layer) 
 * occurred, {@link #SYSTEM_VIL_EXC} if a VIL execution problem occurred.
 * 
 * @author El-Sharkawy
 */
public final class EASyExec {
    public static final int SYSTEM_OK = 0;
    public static final int SYSTEM_IO_EXC = 1;
    public static final int SYSTEM_MODELMGT_EXC = 2;
    public static final int SYSTEM_PERSISTENCE_EXC = 3;
    public static final int SYSTEM_VIL_EXC = 4;

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
            System.exit(SYSTEM_IO_EXC);
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
        System.exit(SYSTEM_OK);
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
            System.exit(SYSTEM_MODELMGT_EXC);
        } catch (VilException e) {
            LOGGER.exception(e);
            System.exit(SYSTEM_VIL_EXC);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
            System.exit(SYSTEM_PERSISTENCE_EXC);
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
        } catch (VilException e) {
            LOGGER.exception(e);
            System.exit(SYSTEM_VIL_EXC);
        } catch (PersistenceException e) {
            LOGGER.exception(e);
            System.exit(SYSTEM_PERSISTENCE_EXC);
        } catch (IOException e) {
            LOGGER.exception(e);
            System.exit(SYSTEM_IO_EXC);
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
            System.out.println("Number of variables: " + config.getDecisionCount());
            Iterator<IDecisionVariable> itr = config.iterator();
            while (itr.hasNext()) {
                IDecisionVariable var = itr.next();
                System.out.println(var.getDeclaration().getName() + " = " + var.getValue());
            }
        }
    }

}
