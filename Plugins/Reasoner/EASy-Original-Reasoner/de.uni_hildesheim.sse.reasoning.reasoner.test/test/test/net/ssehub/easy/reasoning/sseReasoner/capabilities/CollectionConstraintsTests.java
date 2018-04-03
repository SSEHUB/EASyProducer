package test.net.ssehub.easy.reasoning.sseReasoner.capabilities;


import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class CollectionConstraintsTests extends test.net.ssehub.easy.reasoning.sseReasoner.AbstractTest {
    
    private static final File FOLDER = new File(TESTDATA, "collectionConstraints");
    
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
     * Tests constraints in set.
     */
    @Test
    public void constraintSetDefaultTest() {
        reasoningTest("constraintSetDefault.ivml", 1);
    }

    /**
     * Tests constraints in set of set.
     */
    @Test
    public void constraintSetSetDefaultTest() {
        reasoningTest("constraintSetSetDefault.ivml", 1);
    }

    /**
     * Tests containers with derived types on compounds and constraints.
     */
    @Test
    public void constraintSetDerivedCompoundTest() {
        reasoningTest("constraintSetDerivedCompound.ivml", 2);
    }

    /**
     * Tests containers of containers with derived types on compounds and constraints.
     */
    @Test
    public void constraintSetSetDerivedCompoundTest() {
        reasoningTest("constraintSetSetDerivedCompound.ivml", 2);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetAssignedTest() {
        reasoningTest("constraintSetAssigned.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetDefaultInCompoundTest() {
        reasoningTest("constraintSetDefaultInCompound.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInCompoundDefaultTest() {
        reasoningTest("constraintSetInCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInCompoundAssignedTest() {
        reasoningTest("constraintSetInCompoundAssigned.ivml", 1);
    }
  
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInNestedCompoundDefaultTest() {
        reasoningTest("constraintSetInNestedCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void qmTest() {
        reasoningTest("QM.ivml", 1);
    }

    /**
     * Tests constraints in set.
     */
    @Test
    public void setDerivedSetTest() {
        reasoningTest("setDerivedSet.ivml", 3);
    }

}
