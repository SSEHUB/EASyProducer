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
import net.ssehub.easy.reasoning.core.model.ReasonerModel;
import net.ssehub.easy.reasoning.core.model.ReasoningOperation;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.drools2.DroolsEngine;
import net.ssehub.easy.reasoning.drools2.DroolsReasonerDescriptor;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class Group22 extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(Group22.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
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
    public void gr22v100c100birl30() {
        reasoningTest("gr2_2_v100_c100_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 45);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v100c100birl31() {
        reasoningTest("gr2_2_v100_c100_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 45);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v300c300birl3() {
        reasoningTest("gr2_2_v300_c300_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 120);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v500c500birl3() {
        reasoningTest("gr2_2_v500_c500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 216);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v1000c1000birl3() {
        reasoningTest("gr2_2_v1000_c1000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 434);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v1500c1500birl3() {
        reasoningTest("gr2_2_v1500_c1500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 624);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v2000c2000birl3() {
        reasoningTest("gr2_2_v2000_c2000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 873);
    }  
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v2500c2500birl3() {
        reasoningTest("gr2_2_v2500_c2500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1080);
    } 
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v3000c3000birl3() {
        reasoningTest("gr2_2_v3000_c3000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1287);
    }  
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v3500c3500birl3() {
        reasoningTest("gr2_2_v3500_c3500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1484);
    }  
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v4000c4000birl3() {
        reasoningTest("gr2_2_v4000_c4000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1703);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v4500c4500birl3() {
        reasoningTest("gr2_2_v4500_c4500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 1948);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v5000c5000birl3() {
        reasoningTest("gr2_2_v5000_c5000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2120);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v5500c5500birl3() {
        reasoningTest("gr2_2_v5500_c5500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2374);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v6000c6000birl3() {
        reasoningTest("gr2_2_v6000_c6000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v6500c6500birl3() {
        reasoningTest("gr2_2_v6500_c6500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v7000c7000birl3() {
        reasoningTest("gr2_2_v7000_c7000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v7500c7500birl3() {
        reasoningTest("gr2_2_v7500_c7500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v8000c8000birl3() {
        reasoningTest("gr2_2_v8000_c8000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 3363);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v8500c8500birl3() {
        reasoningTest("gr2_2_v8500_c8500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 3638);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v9000c9000birl3() {
        reasoningTest("gr2_2_v9000_c9000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 3801);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v9500c9500birl3() {
        reasoningTest("gr2_2_v9500_c9500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 4011);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v10000c10000birl3() {
        reasoningTest("gr2_2_v10000_c10000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 4272);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v10500c10500birl3() {
        reasoningTest("gr2_2_v10500_c10500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 4606);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v11000c11000birl3() {
        reasoningTest("gr2_2_v11000_c11000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 4735);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v11500c11500birl3() {
        reasoningTest("gr2_2_v11500_c11500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 4917);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v12000c12000birl3() {
        reasoningTest("gr2_2_v12000_c12000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v12500c12500birl3() {
        reasoningTest("gr2_2_v12500_c12500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v13000c13000birl3() {
        reasoningTest("gr2_2_v13000_c13000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v13500c13500birl3() {
        reasoningTest("gr2_2_v13500_c13500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v14000c14000birl3() {
        reasoningTest("gr2_2_v14000_c14000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v14500c14500birl3() {
        reasoningTest("gr2_2_v14500_c14500_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
    
    /**
     * Tests gr2_2.
     */
    @Test    
    public void gr22v15000c15000birl3() {
        reasoningTest("gr2_2_v15000_c15000_bir_l3_0.ivml", ReasoningOperation.VALIDATION, 2373);
    }
   
}
