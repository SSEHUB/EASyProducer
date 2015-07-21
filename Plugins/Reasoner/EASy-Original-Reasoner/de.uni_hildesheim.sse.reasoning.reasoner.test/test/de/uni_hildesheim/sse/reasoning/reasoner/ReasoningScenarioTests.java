package de.uni_hildesheim.sse.reasoning.reasoner;


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
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Configures the operation tests for SSE reasoner.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ReasoningScenarioTests extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(ReasoningScenarioTests.class, Descriptor.BUNDLE_NAME);
    
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
     * @param customMsg Enable custom messages.
     */        
    public void reasoningTest(String ivmlFile, int expectedFailedConstraints, boolean customMsg) {
        Project project = loadProject(ivmlFile);
        resultHandler(expectedFailedConstraints, project, customMsg);
    }   
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @param customMsg Enable custom messages.
     */        
    public void reasoningTest(String p0, String p1, int expectedFailedConstraints, boolean customMsg) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        resultHandler(expectedFailedConstraints, projectP1, customMsg);
    }
    
    /**
     * Method to test whether different types of variables and constraints could be translated correctly
     * into rules and reasoned on without any errors. 
     * @param p0 IVML file to translate and reason on.
     * @param p1 IVML file to translate and reason on.
     * @param p2 IVML file to translate and reason on.
     * @param expectedFailedConstraints Number of constraints that are expected to fail.
     * @param customMsg Enable custom messages.
     */        
    public void reasoningTest(String p0, String p1, String p2, int expectedFailedConstraints, boolean customMsg) {
        Project projectP0 = loadProject(p0);
        Project projectP1 = loadProject(p1);
        Project projectP2 = loadProject(p2);
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);
        ProjectImport importP1 = new ProjectImport(projectP1.getName(), null);
        projectP2.addImport(importP1);
        resultHandler(expectedFailedConstraints, projectP2, customMsg);
    }

    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param projectP1 Project to reason on.
     * @param customMsg Enable custom messages.
     */
    private void resultHandler(int expectedFailedConstraints, Project projectP1, boolean customMsg) {
        Configuration config = new Configuration(projectP1, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
        if (customMsg) {
            rConfig.enableCustomMessages();
        }
        // Perform reasoning
        Engine engine = new Engine(projectP1, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
//        if (result.getMessageCount() > 0 && result.getMessage(0).getStatus() == Status.ERROR) {            
//            de.uni_hildesheim.sse.reasoning.core.reasoner.Message cause = result.getMessage(0);            
//            failedConstraints = Math.max(cause.getConflicts().size(), result.getMessageCount());
//        }
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                if (customMsg) {
                    failedConstraints = failedConstraints + result.getMessage(i).getConflictLabels().size();
                } else {
                    failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size(); 
                }
            }
        }
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
//        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, 0);
    }   
    
    /**
     * Basic test.
     */
    @Test    
    public void initialTest() {
        reasoningTest("InitialTest.ivml", 2, false);
    } 
    
    /**
     * Tests collections.
     */
    @Test    
    public void preCollectionTest() {
        reasoningTest("PreCollectionTest.ivml", 1, false);
    }
    
    /**
     * Tests duplicates.
     */
    @Ignore
    @Test    
    public void hasDuplicatesTestTest() {
        reasoningTest("HasDuplicatesTest.ivml", 0, false);
    }
    
    /**
     * Tests collections.
     */
    @Test    
    public void qmHardwareTest() {
        reasoningTest("QMHardwareTest.ivml", 1, false);
    } 
    
    /**
     * Tests collections.
     */
    @Test    
    public void nestedHardwareTest() {
        reasoningTest("nestedHardwareTest.ivml", 1, false);
    } 
    
    /**
     * Tests freeze.
     */
    @Test    
    public void freezeTest() {
        reasoningTest("FreezeTest.ivml", 0, false);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test    
    public void freezeImportTest() {
        reasoningTest("FreezeTest.ivml", "FreezeImportTest.ivml", 1, false);
    } 
    
    /**
     * Tests import freeze.
     */
    @Test 
    @Ignore
    public void nullTest() {
        reasoningTest("NullTest.ivml", 3, false);
    } 
    
    /**
     * Tests null import.
     */
    @Test  
    @Ignore
    public void nullImportTest() {
        reasoningTest("NullTest.ivml", "NullImportTest.ivml", 4, false);
    } 
    
    /**
     * Tests import child (1 failed constraint).
     */
    @Test    
    public void importChildTest() {
        reasoningTest("ImportChild.ivml", 1, false);
    } 
    
    /**
     * Tests import core (variable is reassigned and 0 constraints fail).
     */
    @Test    
    public void importCoreTest() {
        reasoningTest("ImportChild.ivml", "ImportCore.ivml", 0, false);
    } 
    
    /**
     * Tests internal constraints.
     */ 
    @Test
    @Ignore
    public void internalConstraintTest() {
        reasoningTest("InternalConstraintTest.ivml", 1, false);
    }
    
    /**
     * Tests constraint variables. 
     */ 
    @Test    
    public void constraintVariablesTest() {
        reasoningTest("ConstraintVariableTest.ivml", 2, true);
    }
    
    /**
     * Tests failed variables assignments.
     */ 
    @Test    
    public void variableAssignmentFailTest() {
        reasoningTest("VariableAssignmentFailTest.ivml", 1, false);
    }
    
    /**
     * Tests constraint variables.
     */ 
    @Test    
    public void compoundEqualityTest() {
        reasoningTest("CompoundEqualityTest.ivml", 0, false);
    }
    
    /**
     * Tests compound internal constraints.
     */
    @Test    
    public void constrainedCompoundTest() {
        reasoningTest("ConstrainedCompoundTest.ivml", 3, false);
    }
    
    /**
     * Tests compound internal constraints.
     */
    @Test    
    public void attributeTest() {
        reasoningTest("AttributeTest.ivml", 0, false);
    }
    
    /**
     * Tests compound nested constraints.
     */
    @Test    
    @Ignore
    public void refinedCompoundTest() {
        reasoningTest("RefinedCompoundTest.ivml", 0, false);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void traceTest() {
        reasoningTest("TraceTest.ivml", 1, false);
    }
    
    /**
     * Tests trace in failed elements.
     */
    @Test
    public void nestedVariableReplaceTest() {
        reasoningTest("nestedVariableReplaceTest.ivml", 1, false);
    }

    
//    /**
//     * Tests basic arithmetical operations on Integer and Real numbers.
//     */
//    @Test    
//    public void basicMathOpTest() {
//        reasoningTest("BasicMathOpTest.ivml", 0);
//    }
//    
//    /**
//     * Tests basic comparison operations on Integer and Real numbers.
//     */
//    @Test    
//    public void numberComparisonTest() {
//        reasoningTest("NumberComparisonTest.ivml", 0);
//    }
//    
//    /**
//     * Tests basic comparison operations on Integer and Real numbers.
//     */
//    @Test    
//    public void booleanAlgebraOpTest() {
//        reasoningTest("BooleanAlgebraOpTest.ivml", 0);
//    }
//    
//    /**
//     * Tests advanced arithmetical operations on Integer and Real numbers.
//     */
//    @Test    
//    public void advancedMathOpTest() {
//        reasoningTest("AdvancedMathOpTest.ivml", 0);
//    }
//    
//    /**
//     * Tests string operations.
//     */
//    @Test    
//    public void stringOpTest() {
//        reasoningTest("StringOpTest.ivml", 0);
//    }
//    
//    /**
//     * Tests compound access.
//     */
//    @Test    
//    public void compoundAccessTest() {
//        reasoningTest("CompoundAccessTest.ivml", 0);
//    }
//    
//    
//    /**
//     * Tests compound internal constraints.
//     */ 
//    @Ignore
//    @Test    
//    public void compoundInternalConstraintsTest() {
//        reasoningTest("CompoundInternalConstraintsTest.ivml", 4);
//    }
//    
//    /**
//     * Tests enum access.
//     */ 
//    @Test    
//    public void enumAccessTest() {
//        reasoningTest("EnumAccessTest.ivml", 0);
//    }
//    
//    /**
//     * Tests value assignment.
//     */ 
//    @Test    
//    public void valueAssignmentTest() {
//        reasoningTest("ValueAssignmentTest.ivml", 0);
//    }
//    
//    /**
//     * Tests implies.
//     */
//    @Ignore
//    @Test    
//    public void impliesTest() {
//        reasoningTest("ImpliesTest.ivml", 1);
//    }
//    
//    /**
//     * Tests state assignment.
//     */ 
//    @Test    
//    public void stateAssignmentTest() {
//        reasoningTest("StateAssignmentTest.ivml", 0);
//    }
//    
//    
//    /**
//     * Tests setOf.
//     */ 
//    @Test    
//    public void setTest() {
//        reasoningTest("SetTest.ivml", 0);
//    }
//    
//    
//    
//    /**
//     * Tests setOf with compounds validation. CustomConstraintIgnoreTest.ivml
//     */
//    @Test
//    public void setOfCompoundsPropagationTest() {
//        reasoningTest("SetOfCompoundsPropagationTest.ivml", 0);
//    }
//    
//    /**
//     * Tests ignore of operand = {} constraints. ValuePropagationTest.ivml
//     */
//    @Test
//    public void customConstraintIgnoreTest() {
//        reasoningTest("CustomConstraintIgnoreTest.ivml", 0);
//    }
//    
//    /**
//     * Tests simple value propagation.
//     */
//    @Test
//    public void valuePropagationTest() {
//        reasoningTest("ValuePropagationTest.ivml", 0);
//    }
//    
//    /**
//     * Tests compound value propagation.
//     */
//    @Test
//    public void valueInCompoundPropagationTest() {
//        reasoningTest("ValueInCompoundPropagationTest.ivml", 0);
//    }    
//    
//    /**
//     * Tests Indenica YMS.
//     */
//    @Test
//    public void validationOfYMSTest() {
//        reasoningTest("ValidationOfYMSTest.ivml", 0);
//    }
//    
//    /**
//     * Tests correct value assignment.
//     */
//    @Test
//    public void variablePropagationTest() {
//        reasoningTest("VariablePropagationTest.ivml", 0);
//    }
}
