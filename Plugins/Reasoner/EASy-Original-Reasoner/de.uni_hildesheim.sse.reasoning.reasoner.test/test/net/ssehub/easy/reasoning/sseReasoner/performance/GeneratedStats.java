package net.ssehub.easy.reasoning.sseReasoner.performance;

import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class GeneratedStats extends net.ssehub.easy.reasoning.sseReasoner.AbstractTest {
    
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
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    private Project loadProject(String path) {
        return loadProject(FOLDER, path);
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
