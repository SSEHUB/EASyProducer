package de.uni_hildesheim.sse.reasoning.performance;

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
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.reasoner.Engine;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class GeneratedStats extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(GeneratedStats.class, "SSE Reasoner");
    
    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "ssePerformance");
    
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
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public void reasoningTest(String ivmlFile, int expectedFailedConstraints) {
        Project project = loadProject(ivmlFile);
        resultHandler(expectedFailedConstraints, project);
    }   
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public void reasoningTest(String p0, String p1, int expectedFailedConstraints) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        resultHandler(expectedFailedConstraints, projectP1);
    } 

    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param projectP1 Project to reason on.
     */
    private void resultHandler(int expectedFailedConstraints, Project projectP1) {
        Configuration config = new Configuration(projectP1, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();        
        // Perform reasoning
        Engine engine = new Engine(projectP1, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;

        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size();
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);

    } 
    
    /**
     * Tests Boolean 1 to 3 ration.
     */
    @Ignore
    @Test    
    public void gr11() {
        reasoningTest("gr1_1_v100_c300_b_l2_0.ivml", 150);
        reasoningTest("gr1_1_v100_c300_b_l2_0.ivml", 150);
        reasoningTest("gr1_1_v300_c900_b_l2_0.ivml", 438);
        reasoningTest("gr1_1_v500_c1500_b_l2_0.ivml", 726);
        reasoningTest("gr1_1_v1000_c3000_b_l2_0.ivml", 1518);
        reasoningTest("gr1_1_v1500_c4500_b_l2_0.ivml", 2236);
    } 
    
    /**
     * Tests Boolean 1 to 1 ration.
     */
    @Ignore
    @Test    
    public void gr12() {
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", 46);
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", 46);
        reasoningTest("gr1_2_v300_c300_b_l2_0.ivml", 124);
        reasoningTest("gr1_2_v500_c500_b_l2_0.ivml", 266);
        reasoningTest("gr1_2_v1000_c1000_b_l2_0.ivml", 504);
        reasoningTest("gr1_2_v1500_c1500_b_l2_0.ivml", 739);
    }   

}
