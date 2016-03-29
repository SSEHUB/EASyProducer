package de.uni_hildesheim.sse.reasoning.drools2.performance;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.test.AbstractTest;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.reasoning.drools2.DroolsEngine;
import de.uni_hildesheim.sse.reasoning.drools2.DroolsReasonerDescriptor;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.reasoning.core.model.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class Group12 extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(Group12.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "testPerformance");
    
    /**
     * Initializes this Test class.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
        try {
            VarModel.INSTANCE.locations().addLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not add location of test files.");
        }
    }
    
    /**
     * Frees the memory after testing.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        try {
            VarModel.INSTANCE.locations().removeLocation(FOLDER, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("Could not remove location of test files.");
        }
    }
    
    /**
     * Method for determining folder with IVML files.
     * @param property property
     * @return folder location
     */
    private static File determineTestDataFolder(String property) {
        File testdataFolder = determineTestDataDir(property);
        String externalLocation = System.getProperty(property);
        
        // If no property was defined, use ReasonerCore.test/testdata directory
        if (null == externalLocation) {
            // Work around over the path avoids a NullPointer exception
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
            
        return testdataFolder;    
    }
    
    /**
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected Project loadProject(String path) {
        Project project = null;
        try {
            File projectFile = new File(FOLDER, path);
            URI uri = URI.createFileURI(projectFile.getAbsolutePath());
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            StringBuffer errorMsg = new StringBuffer();
            for (int i = 0; i < result.getMessageCount(); i++) {
                Message msg = result.getMessage(i);
                if (!msg.ignore()) {
                    errorMsg.append(msg.getDescription());
                    errorMsg.append("\n");
                }
            }
            if (errorMsg.length() == 0) {
                project = result.getResult(0);
            } else {
                Assert.fail(errorMsg.toString());
            }
            Assert.assertNotNull("Error: The loaded project " + path + " is NULL (should not happen)", project);
            VarModel.INSTANCE.updateModel(project, projectFile.toURI());
        } catch (IOException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        
        return project;
    }
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param ivmlFile IVML file to translate and reason on.
     * @param operation {@link ReasoningOperation} to be performed.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public void reasoningTest(String ivmlFile, ReasoningOperation operation, int expectedFailedConstraints) {
        // Get project
        Project project = loadProject(ivmlFile);
        Configuration config = new Configuration(project);
        ReasonerModel model = new ReasonerModel(config, null);
        
        // Perform reasoning
        DroolsEngine engine = new DroolsEngine(model, operation, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        if (result.getMessageCount() > 0 && result.getMessage(0).getStatus() == Status.ERROR) {            
            net.ssehub.easy.reasoning.core.reasoner.Message cause = result.getMessage(0);
            failedConstraints = Math.max(cause.getConflicts().size(), result.getMessageCount());
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
        
//        Integer i = 0;
//        Integer count = model.getNormalConstraintCount();
//        Set<ReasonerVariable> usedVariables =
//                model.getVariablesUsedInConstraints();
//        for (ReasonerVariable reasonerVariable : usedVariables) {
//            i++;
//            LOGGER.debug(reasonerVariable.getName().toString() 
//                    + " : "
//                    + " rmodel: "
//                    + reasonerVariable.getReasoningState().toString() + " "
//                    + reasonerVariable.getValue()
//                    + " varmodel: "
//                    + reasonerVariable.getDecisionVariable().getState().toString() + " "
//                    + reasonerVariable.getDecisionVariable().getValue());
//        }
    }
    
    /**
     * Tests starter.
     */
    @Test    
    public void gr12v100c100bl20() {
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", ReasoningOperation.VALIDATION, 38);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v100c100bl21() {
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", ReasoningOperation.VALIDATION, 38);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v300c300bl2() {
        reasoningTest("gr1_2_v300_c300_b_l2_0.ivml", ReasoningOperation.VALIDATION, 100);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v500c500bl2() {
        reasoningTest("gr1_2_v500_c500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 236);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v1000c1000bl2() {
        reasoningTest("gr1_2_v1000_c1000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 431);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v1500c1500bl2() {
        reasoningTest("gr1_2_v1500_c1500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 652);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v2000c2000bl2() {
        reasoningTest("gr1_2_v2000_c2000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 872);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v2500c2500bl2() {
        reasoningTest("gr1_2_v2500_c2500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 1049);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v3000c3000bl2() {
        reasoningTest("gr1_2_v3000_c3000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 1278);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v3500c3500bl2() {
        reasoningTest("gr1_2_v3500_c3500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 1467);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v4000c4000bl2() {
        reasoningTest("gr1_2_v4000_c4000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 1636);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v4500c4500bl2() {
        reasoningTest("gr1_2_v4500_c4500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 1909);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v5000c5000bl2() {
        reasoningTest("gr1_2_v5000_c5000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v5500c5500bl2() {
        reasoningTest("gr1_2_v5500_c5500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2288);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v6000c6000bl2() {
        reasoningTest("gr1_2_v6000_c6000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2517);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v6500c6500bl2() {
        reasoningTest("gr1_2_v6500_c6500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2700);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v7000c7000bl2() {
        reasoningTest("gr1_2_v7000_c7000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v7500c7500bl2() {
        reasoningTest("gr1_2_v7500_c7500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v8000c8000bl2() {
        reasoningTest("gr1_2_v8000_c8000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v8500c8500bl2() {
        reasoningTest("gr1_2_v8500_c8500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v9000c9000bl2() {
        reasoningTest("gr1_2_v9000_c9000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v9500c9500bl2() {
        reasoningTest("gr1_2_v9500_c9500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v10000c10000bl2() {
        reasoningTest("gr1_2_v10000_c10000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v10500c10500bl2() {
        reasoningTest("gr1_2_v10500_c10500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v11000c11000bl2() {
        reasoningTest("gr1_2_v11000_c11000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v11500c11500bl2() {
        reasoningTest("gr1_2_v11500_c11500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v12000c12000bl2() {
        reasoningTest("gr1_2_v12000_c12000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v12500c12500bl2() {
        reasoningTest("gr1_2_v12500_c12500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v13000c13000bl2() {
        reasoningTest("gr1_2_v13000_c13000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v13500c13500bl2() {
        reasoningTest("gr1_2_v12000_c12000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v14000c14000bl2() {
        reasoningTest("gr1_2_v14000_c14000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v15000c15000bl2() {
        reasoningTest("gr1_2_v15000_c15000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v15500c15500bl2() {
        reasoningTest("gr1_2_v15500_c15500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v16000c16000bl2() {
        reasoningTest("gr1_2_v16000_c16000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v16500c16500bl2() {
        reasoningTest("gr1_2_v16500_c16500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v17000c17000bl2() {
        reasoningTest("gr1_2_v17000_c17000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v17500c17500bl2() {
        reasoningTest("gr1_2_v17500_c17500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v18000c18000bl2() {
        reasoningTest("gr1_2_v18000_c18000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v18500c18500bl2() {
        reasoningTest("gr1_2_v18500_c18500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v19000c19000bl2() {
        reasoningTest("gr1_2_v19000_c19000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v19500c19500bl2() {
        reasoningTest("gr1_2_v19500_c19500_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
    
    /**
     * Tests gr1_2.
     */
    @Test    
    public void gr12v20000c20000bl2() {
        reasoningTest("gr1_2_v20000_c20000_b_l2_0.ivml", ReasoningOperation.VALIDATION, 2085);
    }
   
}
