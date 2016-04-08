
package net.ssehub.easy.reasoning.drools2.translation;

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
public class DroolsEngineTests extends AbstractTest<Project> {

    private static final EASyLogger LOGGER =
            EASyLoggerFactory.INSTANCE.getLogger(DroolsEngineTests.class, DroolsReasonerDescriptor.BUNDLE_NAME);
    
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
     * Tests equality and unequality conditions in rules.
     */
    @Test    
    public void equalityTest() {
        reasoningTest("EqualityTest.ivml", ReasoningOperation.VALIDATION, 0);
    }    
    
    /**
     * Tests basic arithmetical operations on Integer and Real numbers.
     */
    @Test    
    public void basicMathOpTest() {
        reasoningTest("BasicMathOpTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests basic comparison operations on Integer and Real numbers.
     */
    @Test    
    public void numberComparisonTest() {
        reasoningTest("NumberComparisonTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests basic comparison operations on Integer and Real numbers.
     */
    @Test    
    public void booleanAlgebraOpTest() {
        reasoningTest("BooleanAlgebraOpTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests advanced arithmetical operations on Integer and Real numbers.
     */
    @Test    
    public void advancedMathOpTest() {
        reasoningTest("AdvancedMathOpTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests string operations.
     */
    @Test    
    public void stringOpTest() {
        reasoningTest("StringOpTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests compound access.
     */
    @Test    
    public void compoundAccessTest() {
        reasoningTest("CompoundAccessTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests compound internal constraints.
     */ 
    @Ignore
    @Test    
    public void compoundInternalConstraintsTest() {
        reasoningTest("CompoundInternalConstraintsTest.ivml", ReasoningOperation.VALIDATION, 4);
    }
    
    /**
     * Tests enum access.
     */ 
    @Test    
    public void enumAccessTest() {
        reasoningTest("EnumAccessTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests value assignment.
     */ 
    @Test    
    public void valueAssignmentTest() {
        reasoningTest("ValueAssignmentTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests implies.
     */
    @Ignore
    @Test    
    public void impliesTest() {
        reasoningTest("ImpliesTest.ivml", ReasoningOperation.VALIDATION, 1);
    }
    
    /**
     * Tests state assignment.
     */ 
    @Test    
    public void stateAssignmentTest() {
        reasoningTest("StateAssignmentTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests internal constraints.
     */ 
    @Ignore
    @Test    
    public void internalConstraintTest() {
        reasoningTest("InternalConstraintTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests setOf.
     */ 
    @Test    
    public void setTest() {
        reasoningTest("SetTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests setOf with compounds validation. CustomConstraintIgnoreTest.ivml
     */
    @Test
    public void setOfCompoundsPropagationTest() {
        reasoningTest("SetOfCompoundsPropagationTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }
    
    /**
     * Tests ignore of operand = {} constraints. ValuePropagationTest.ivml
     */
    @Test
    public void customConstraintIgnoreTest() {
        reasoningTest("CustomConstraintIgnoreTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests simple value propagation.
     */
    @Test
    public void valuePropagationTest() {
        reasoningTest("ValuePropagationTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }
    
    /**
     * Tests compound value propagation.
     */
    @Test
    public void valueInCompoundPropagationTest() {
        reasoningTest("ValueInCompoundPropagationTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }    
    
    /**
     * Tests Indenica YMS.
     */
    @Test
    public void validationOfYMSTest() {
        reasoningTest("ValidationOfYMSTest.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests correct value assignment.
     */
    @Test
    public void variablePropagationTest() {
        reasoningTest("VariablePropagationTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }
    
    /**
     * Tests correct value assignment.
     */
    @Test
    public void kBaseUpdateTest() {
        reasoningTest("KBaseUpdateTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }
    
    /**
     * Tests correct value assignment.
     */
    @Test
    public void kBaseUpdateCompoundsTest() {
        reasoningTest("KBaseUpdateCompoundsTest.ivml", ReasoningOperation.PROPAGATION, 0);
    }
    
    /**
     * Tests correct interface usage.
     */
    @Ignore
    @Test
    public void interfaceUsageTest() {
        reasoningTest("InterfaceUser.ivml", ReasoningOperation.PROPAGATION, 2);
    }    
}
