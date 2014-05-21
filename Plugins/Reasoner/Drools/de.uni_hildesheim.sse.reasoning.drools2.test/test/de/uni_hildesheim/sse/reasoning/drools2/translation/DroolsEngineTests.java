
package de.uni_hildesheim.sse.reasoning.drools2.translation;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
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
import de.uni_hildesheim.sse.reasoning.core.model.ReasonerModel;
import de.uni_hildesheim.sse.reasoning.core.model.ReasoningOperation;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.drools2.DroolsEngine;
import de.uni_hildesheim.sse.reasoning.drools2.DroolsReasonerDescriptor;
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
            de.uni_hildesheim.sse.reasoning.core.reasoner.Message cause = result.getMessage(0);
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
     * Tests large scale model on linux example. Create boolean variables in RModel.
     * Boolean var - 62482
     */ 
    @Ignore
    @Test
    public void largeIVMLforLinuxVarCreateTest() {
        reasoningTest("IVML_boolean_var0", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests large scale model on linux example.
     * Boolean var - 62482
     * Constraints - 273799
     * Level 1
     */ 
    @Ignore
    @Test
    public void largeIVMLforLinux1Test() {
        reasoningTest("IVML_boolean_lev1.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests large scale model on linux example.
     * Boolean var - 62482
     * Constraints - 273799
     * Level 2
     */ 
    @Ignore
    @Test
    public void largeIVMLforLinux2Test() {
        reasoningTest("IVML_boolean_lev2.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests large scale model on linux example.
     * Boolean var - 62482
     * Constraints - 273799
     * Level 3
     */    
    @Ignore 
    @Test
    public void largeIVMLforLinux3Test() {
        reasoningTest("IVML_boolean_lev3.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests rb model.
     * Boolean var - 2000
     * Boolean Constraints - 10000
     * Integer var - 2000
     * Real var - 2000
     * Arithmetical constraints - 20000
     * Level 1
     * -Xms128m -Xmx512m -XX:MaxPermSize=128m -Xss2m
     * Time: 1051,647s = 17,52745
     */
    @Ignore
    @Test
    public void rbIVML1Test() {
        reasoningTest("IVML_rb_lev1.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests rb model.
     * Boolean var - 2000
     * Boolean Constraints - 10000
     * Integer var - 2000
     * Real var - 2000
     * Arithmetical constraints - 20000
     * Level 2
     * -Xmx1024M -XX:MaxPermSize=256M -Xss512K
     * Time 1071,126s = 17,8521m
     */
    @Ignore
    @Test
    public void rbIVML2Test() {
        reasoningTest("IVML_rb_lev2.ivml", ReasoningOperation.VALIDATION, 14160);
    }
    
    /**
     * Tests rb model.
     * Boolean var - 2000
     * Boolean Constraints - 10000
     * Integer var - 2000
     * Real var - 2000
     * Arithmetical constraints - 20000
     * Level 3
     * -Xmx1024M -XX:MaxPermSize=256M -Xss512K
     * OutOfMemoryError: Java heap space
     */
    @Ignore
    @Test
    public void rbIVML3Test() {
        reasoningTest("IVML_rb_lev3.ivml", ReasoningOperation.VALIDATION, 0);
    }
    
    /**
     * Tests scl model.
     * Boolean var - 500
     * Boolean Constraints - 500
     * Level 2
     * Eclipse default
     * Time: 8,722
     * -Xms128m -Xmx512m -XX:MaxPermSize=128m -Xss2m
     * Time: 8,425
     */
    @Ignore
    @Test
    public void sclIVML2Test() {
        reasoningTest("IVML_scl_lev2.ivml", ReasoningOperation.VALIDATION, 214);
    }
    
    /**
     * Tests comparison model.
     * Boolean var - 1000
     * Boolean Constraints - 100
     * Level 2
     * Eclipse default
     * Time: 4,182
     * -Xms128m -Xmx512m -XX:MaxPermSize=128m -Xss2m
     * Time: 3,869
     */
    @Ignore
    @Test
    public void compIVML2Test() {
        reasoningTest("IVML_comparison_lev2.ivml", ReasoningOperation.VALIDATION, 40);
    }

    /**
     * Tests comparison model.
     * Boolean var - 334
     * Boolean Constraints - 34
     * Arithmetical var - 666
     * Arithmetical Constraints - 66
     * Level 2
     * Eclipse default
     * Time: 4,230
     * -Xms128m -Xmx512m -XX:MaxPermSize=128m -Xss2m
     * Time: 4,136 Prev.ver.: 7,330
     */
    @Ignore
    @Test
    public void compMixIVML2Test() {
        reasoningTest("IVML_comparisonMix_lev2.ivml", ReasoningOperation.VALIDATION, 54);
    }
}
