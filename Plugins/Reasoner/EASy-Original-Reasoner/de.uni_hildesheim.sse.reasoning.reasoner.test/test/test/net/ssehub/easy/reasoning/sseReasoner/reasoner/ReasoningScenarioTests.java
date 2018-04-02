package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;


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
 * Configures the operation tests for SSE reasoner.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ReasoningScenarioTests extends test.net.ssehub.easy.reasoning.sseReasoner.AbstractTest {
    
    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "operationsTemplates");
    
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
    protected Project loadProject(String path) {
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
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param p2 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     */        
    public void reasoningTest(String p0, String p1, String p2, int expectedFailedConstraints) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        Project projectP2 = loadProject(p2);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        ProjectImport importP1 = new ProjectImport(projectP1.getName(), null);
        projectP2.addImport(importP1);
        resultHandler(expectedFailedConstraints, projectP2);
    }
    
    /**
     * Basic test.
     */
    @Test    
    public void initialTest() {
        reasoningTest("InitialTest.ivml", 2);
    } 
    
    /**
     * Tests collections.
     */
    @Test    
    public void preCollectionTest() {
        reasoningTest("PreCollectionTest.ivml", 1);
    }
    
    /**
     * Tests duplicates.
     */
    @Ignore
    @Test    
    public void hasDuplicatesTestTest() {
        reasoningTest("HasDuplicatesTest.ivml", 0);
    }      
    
    /**
     * Tests freeze.
     */
    @Test    
    public void freezeTest() {
        reasoningTest("FreezeTest.ivml", 0);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test    
    public void freezeImportTest() {
        reasoningTest("FreezeTest.ivml", "FreezeImportTest.ivml", 1);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test 
    @Ignore
    public void nullTest() {
        reasoningTest("NullTest.ivml", 3);
    } 
    
    /**
     * Tests null import.
     */
    @Test  
    @Ignore
    public void nullImportTest() {
        reasoningTest("NullTest.ivml", "NullImportTest.ivml", 4);
    } 
    
    /**
     * Tests import child (1 failed constraint).
     */
    @Test    
    public void importChildTest() {
        reasoningTest("ImportChild.ivml", 1);
    } 
    
    /**
     * Tests import core (variable is reassigned and 0 constraints fail).
     */
    @Test    
    public void importCoreTest() {
        reasoningTest("ImportChild.ivml", "ImportCore.ivml", 0);
    } 
    
    /**
     * Tests internal constraints.
     */ 
    @Test
    @Ignore
    public void internalConstraintTest() {
        reasoningTest("InternalConstraintTest.ivml", 1);
    }
    
    /**
     * Tests constraint variables. 
     */ 
    @Test    
    public void constraintVariablesTest() {
        reasoningTest("ConstraintVariableTest.ivml", 2);
    }
    
    /**
     * Tests failed variables assignments.
     */ 
    @Test    
    public void variableAssignmentFailTest() {
        reasoningTest("VariableAssignmentFailTest.ivml", 1);
    }
    
    /**
     * Tests constraint variables.
     */ 
    @Test    
    public void compoundEqualityTest() {
        reasoningTest("CompoundEqualityTest.ivml", 0);
    }
    
    /**
     * Tests compound internal constraints.
     */
    @Test    
    public void constrainedCompoundTest() {
        reasoningTest("ConstrainedCompoundTest.ivml", 3);
    }
    
    /**
     * Tests annotation assignment.
     */
    @Test    
    public void annotationInitialTest() {
        reasoningTest("AnnotationInitialTest.ivml", 0);
    }
    
    /**
     * Tests annotations in compound.
     */
    @Test    
    public void annotationAssignedToDifferentCompoundSlotsValid() {
        reasoningTest("AnnotationAssignedToDifferentCompoundSlotsValid.ivml", 0);
    }
    
    /**
     * Tests compound nested constraints.
     */
    @Test    
    @Ignore
    public void refinedCompoundTest() {
        reasoningTest("RefinedCompoundTest.ivml", 0);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void traceTest() {
        reasoningTest("TraceTest.ivml", 1);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void nestedVariableReplaceTest() {
        reasoningTest("nestedVariableReplaceTest.ivml", 1);
    }
    
    /**
     * String patern test with internal constraint.
     */
    @Test
    public void internalConstraintStringPaternTest() {
        reasoningTest("internalConstraintStringPaternTest.ivml", 1);
    }
    
    /**
     * Inherited internal constraint test.
     */
    @Test
    public void internalConstraintInheritedTest() {
        reasoningTest("internalConstraintInheritedTest.ivml", 1);
    }
    
    /**
     * Inherited internal constraint in compound test.
     */
    @Test
    public void internalConstraintInheritedInCompoundTest() {
        reasoningTest("internalConstraintInheritedInCompoundTest.ivml", 1);
    }
    
    /**
     * Collection internal constraint test.
     */
    @Test
    public void internalConstraintCollectionTest() {
        reasoningTest("internalConstraintCollectionTest.ivml", 2);
    }
    
    /**
     * Collection internal constraint in compound test.
     */
    @Test
    public void internalConstraintCollectionInCompoundTest() {
        reasoningTest("internalConstraintCollectionInCompoundTest.ivml", 2);
    }
    
    /**
     * String pattern test with internal constraint.
     */
    @Test
    public void refToCompoundInSequenceTest() {
        reasoningTest("RefToCompoundInSequenceTest.ivml", 0);
    }
    
    /**
     * Default constraint reevaluation.
     */
    @Test
    public void defaultConstraintReevaluationTest() {
        reasoningTest("DefaultConstraintReevaluationTest.ivml", 1);
    }
    
    /**
     * isDefined test.
     */
    @Test
    public void isDefinedTest() {
        reasoningTest("IsDefinedTest.ivml", 10);
    }  
    
    /**
     * isDefined Compound test.
     */
    @Test
    public void isDefinedCompoundTest() {
        reasoningTest("IsDefinedCompoundTest.ivml", 1);
    }  
    
    /**
     * Test for collections of compounds equality operation.
     */
    @Test
    public void compoundCollectionEqualityTest() {
        reasoningTest("compoundCollectionEqualityTest.ivml", 1);
    }  
    
    /**
     * Test for collections of refTo(compounds) equality operation.
     */
    @Test
    public void refByCompoundCollectionEqualityTest() {
        reasoningTest("refByCompoundCollectionEqualityTest.ivml", 1);
    }  
    
    /**
     * Test for collections of string equality operation.
     */
    @Test
    public void stringCollectionEqualityTest() {
        reasoningTest("stringCollectionEqualityTest.ivml", 2);
    }
    
    /**
     * Test for incremental reasoning and clering derived values in configuration..
     */
    @Test
    public void clearConfigTest() {
        reasoningTest("ClearConfigBase.ivml", "ClearConfigCore.ivml", 0);
    }   
    

}
