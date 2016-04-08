package net.ssehub.easy.reasoning.drools2.performance;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.test.AbstractTest;
import net.ssehub.easy.dslCore.translation.Message;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.drools2.DroolsEngine;
import net.ssehub.easy.reasoning.drools2.DroolsReasonerDescriptor;
import net.ssehub.easy.reasoning.drools2.model.ReasonerModel;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class Group21 extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(Group21.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
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
    public void gr21v100c300birl30() {
        reasoningTest("gr2_1_v100_c300_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 138);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v100c300birl31() {
        reasoningTest("gr2_1_v100_c300_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 138);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v300c900birl3() {
        reasoningTest("gr2_1_v300_c900_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 411);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v500c1500birl3() {
        reasoningTest("gr2_1_v500_c1500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 657);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v1000c3000birl3() {
        reasoningTest("gr2_1_v1000_c3000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1223);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v1500c4500birl3() {
        reasoningTest("gr2_1_v1500_c4500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1954);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v2000c6000birl3() {
        reasoningTest("gr2_1_v2000_c6000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2518);
    }
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v2500c7500birl3() {
        reasoningTest("gr2_1_v2500_c7500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v3000c9000birl3() {
        reasoningTest("gr2_1_v3000_c9000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v3500c10500birl3() {
        reasoningTest("gr2_1_v3500_c10500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v4000c12000birl3() {
        reasoningTest("gr2_1_v4000_c12000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v4500c13500birl3() {
        reasoningTest("gr2_1_v4500_c13500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
    
    /**
     * Tests gr2_1.
     */
    @Test    
    public void gr21v5000c15000birl3() {
        reasoningTest("gr2_1_v5000_c15000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 872);
    } 
   
}
