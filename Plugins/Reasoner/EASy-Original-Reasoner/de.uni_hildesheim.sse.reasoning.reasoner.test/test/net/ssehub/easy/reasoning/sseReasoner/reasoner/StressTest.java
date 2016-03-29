package net.ssehub.easy.reasoning.sseReasoner.reasoner;

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
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.sseReasoner.Engine;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Stresstests.
 * 
 * @author krafczyk
 */
public class StressTest extends AbstractTest<Project> {
    
    private static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    private static final File FOLDER = new File(TESTDATA, "stresstest");
    
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
        if (!testdataFolder.exists()) {
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore");
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
            System.out.println(testdataFolder);
        }            
        return testdataFolder;    
    }
    
    /**
     * Helper method for load an IVML file.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected static Project loadProject(String path) {
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
     * Runs the reasoner for the specified project.
     * @param projectP1 Project to reason on.
     * @return number of failed constraints.
     */
    private int runReasoner(Project projectP1) {
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
        
        return failedConstraints;
    }
    
    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param projectP1 Project to reason on.
     */
    private void resultHandler(int expectedFailedConstraints, Project projectP1) {
        int failedConstraints = runReasoner(projectP1);
        Assert.assertEquals("Failed constraints: ", expectedFailedConstraints, failedConstraints);
    }   
    
    
    /**
     * Tests whether boolean deafult values are handled correctly.
     */
    @Test
    @Ignore
    public void testBooleanDefault() {
        // Test whether default values for booleans are not treated as project constraints
        reasoningTest("BooleanDefault.1.ivml", 0);
        // Test whether default values for booleans are applied to them
        reasoningTest("BooleanDefault.2.ivml", 1);
    }
    
    /**
     * Tests whether boolean implies values are handled correctly.
     */
    @Test
    @Ignore
    public void testBooleanImplies() {
        reasoningTest("BooleanImplies.ivml", 1);
    }
    
    /**
     * Tests whether constraint variables are evaluated correctly.
     */
    @Test
    @Ignore
    public void testConstraintEvaluation() {
        reasoningTest("ConstraintEval.ivml", 1);
    }
    
    /**
     * Tests whether overridden default values for constraint variables are evaluated correctly.
     */
    @Test
    @Ignore
    public void testConstraintDefaults() {
        reasoningTest("ConstraintDefault.1.ivml", 0);
        reasoningTest("ConstraintDefault.2.ivml", 1);
    }
    
    /**
     * Tests whether automatic assignment of undefined variables in constraints
     * via == does not result in failing constraints.
     */
    @Test
    @Ignore
    public void testUndefinedVariables() {
        reasoningTest("UndefinedVariables.ivml", 0);
    }
    
    /**
     * Tests whether typedefs work correctly with compounds.
     */
    @Test
    @Ignore
    public void testCompoundTypedef() {
        // Tests whether simple typedefs ("aliases") work
//        reasoningTest("CompoundTypedef.1.ivml", 0);
        // Tests whether typedefs with "with" work
        reasoningTest("CompoundTypedef.2.ivml", 1);
    }
    
    /**
     * Tests whether typedefs work correctly with sequences and sets.
     */
    @Test
    public void testSetAndSequenceTypedef() {
        // Tests whether simple typedefs ("aliases") work with sets and sequences
        reasoningTest("SetAndSequenceTypedef.ivml", 2);
        // Tests whether typedefs of typedefs and "with" works for sequences
        reasoningTest("SequenceTypedefWith.ivml", 1);
    }
    
    /**
     * Tests whether constraints in refined compounds produce the right number of error messages.
     */
    @Test
    public void testCompoundRefineConstraints() {
        reasoningTest("CompoundRefineConstraints.ivml", 1);
    }
    
    /**
     * Tests whether typedef constraints are correctly evaluated in sequences / sets.
     */
    @Test
    @Ignore
    public void testTypedefConstraintsInSequences() {
        reasoningTest("TypedefConstraintSequence.ivml", 1);
    }
    
    /**
     * Tests whether out-of-bounds accesses to sequences are handled correctly.
     */
    @Test
    public void testOutOfBoundsIndex() {
        runReasoner(loadProject("OutOfBoundsIndex.ivml"));
    }
    
    /**
     * Tests whether size() works for null sets and sequences.
     */
    @Test
    public void testNullSize() {
        runReasoner(loadProject("NullSize.ivml"));
    }
    
    /**
     * Tests whether == in implies LHS is treated correctly.
     */
    @Test
    public void testPropagationSyntax() {
        reasoningTest("PropagationSyntax1.ivml", 0);
    }
    
    /**
     * Tests whether undefined values in if are handled correctly.
     */
    @Test
    public void testIfWithUndefinedValues() {
        reasoningTest("UndefinedIf.ivml", 0);
    }
    
    /**
     * Tests whether constraints with undefined variables are ignored.
     */
    @Test
    public void testUndefinedVariableConstraints() {
        reasoningTest("UndefinedVariableConstraints.ivml", 0);
    }
    
    /**
     * Tests whether constants passed to custom operations don't cause exceptions.
     */
    @Test
    public void testConstantInCustomOperation() {
        reasoningTest("ConstantInCustomOperation.ivml", 0);
    }

}
