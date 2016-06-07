package net.ssehub.easy.reasoning.sseReasoner.capabilities;


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
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ConstraintVariableTests extends net.ssehub.easy.reasoning.sseReasoner.AbstractTest {
    
    private static final File FOLDER = new File(TESTDATA, "constraintVariables");
    
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
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsInCompoundWithDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsInCompoundWithNoDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithNoDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsInCompoundWithEmptyDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithEmptyDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsWithDefaultValue() {
        reasoningTest("setOfConstraintsWithDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsWithNoDefaultValue() {
        reasoningTest("setOfConstraintsWithNoDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void setOfConstraintsWithEmptyDefaultValue() {
        reasoningTest("setOfConstraintsWithEmptyDefaultValue.ivml", 1);
    }
    
    
    /**
     * Tests false constraint.
     */
//    @Ignore
    @Test
    public void constraintDefaultTest() {
        reasoningTest("constraintDefault.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void constraintAssignedTest() {
        reasoningTest("constraintAssigned.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintInCompoundDefaultTest() {
        reasoningTest("constraintInCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void constraintsInCompoundWithNoDefaultValue() {
        reasoningTest("constraintsInCompoundWithNoDefaultValue.ivml", 1);
    }
    
    
    /**
     * Tests false constraint. TODO implement assigned ConstraintVariableEvaluation
     */
    @Ignore
    @Test
    public void constraintInCompoundAssignedTest() {
        reasoningTest("constraintInCompoundAssigned.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
//    @Ignore
    @Test
    public void falseTest() {
        reasoningTest("falseTest.ivml", 1);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanAssignedFalse() {
        reasoningTest("booleanAssignedFalse.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanDefaultFalse() {
        reasoningTest("booleanDefaultFalse.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanAssignedFalseInCompound() {
        reasoningTest("booleanAssignedFalseInCompound.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanDefaultFalseInCompound() {
        reasoningTest("booleanDefaultFalseInCompound.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanInCompoundWithDefaultValue() {
        reasoningTest("setOfBooleanInCompoundWithDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanInCompoundWithNoDefaultValue() {
        reasoningTest("setOfBooleanInCompoundWithNoDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanWithDefaultValue() {
        reasoningTest("setOfBooleanWithDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanWithNoDefaultValue() {
        reasoningTest("setOfBooleanWithNoDefaultValue.ivml", 0);
    }
    
    /**
     * Tests constraint variable order influence (QM project case).
     */
    @Test
    public void compoundConstraintVarOrder() {
        reasoningTest("QM_constraintOrder.ivml", 0);
    }

}
