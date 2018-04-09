package test.net.ssehub.easy.reasoning.sseReasoner.adaptation;


import java.io.File;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.StandaloneInitializer;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.sseReasoner.Engine;
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class AdaptationScenarioTests extends test.net.ssehub.easy.reasoning.sseReasoner.AbstractTest {
    
    private static final File FOLDER = new File(TESTDATA, "adaptationScenarios");
    
    private Project project;
    private Configuration config;
    private ReasonerConfiguration rConfig;   

    
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
     * Helper method to prepare configuration from a project.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     */
    private void prepareConfiguration(String path) {
        project = loadProject(FOLDER, path);
        config = new Configuration(project, true);        
        rConfig = new ReasonerConfiguration();
    }
    
    /**
     * Helper method to run reasoning.
     */
    private void runReasoning() {
        Engine engine = new Engine(project, config, rConfig, ProgressObserver.NO_OBSERVER);
        engine.reason();  
    }

    /**
     * Asserts that a given variable has the expected value (and state).
     * @param variable The variable to test (maybe a nested variable, but not <tt>null</tt>).
     * @param expectedValue The expected value of the variable (must not be <tt>null</tt>).
     * @param expectedState Should be one of {@link AssignmentState#ASSIGNED} (if it was initialized by the
     *     configuration, {@link AssignmentState#USER_ASSIGNED} if it was manually overwritten by the user
     *     (inside the test case), or {@link AssignmentState#DERIVED} if the reasoner should overwrite a value during
     *     reasoning
     * @param explanation A error message if the Junit test case breaks
     */
    private void assertVariable(IDecisionVariable variable, Object expectedValue, IAssignmentState expectedState,
            String explanation) {
        
        Assert.assertNotNull("Tested variable was NULL, but was not expected to be.", variable);
        String name = variable.getDeclaration().getName();
        if (expectedValue != null) {
            Assert.assertNotNull(name + " " + explanation + " has NULL value, but was not expected.",
                    variable.getValue());        
            Assert.assertEquals(name + " " + explanation, expectedValue, variable.getValue().getValue());            
        } else {
            Assert.assertEquals(name + " " + explanation, expectedValue, variable.getValue()); 
        }
        Assert.assertSame(name + " " + explanation, expectedState, variable.getState());
    }
        
    /**
     * Initial AssignmentResolver. 1st Reasoning. Simple variable value modification by user. 2nd Reasoning.
     * After variable modification it should not be changed by the reasoner.
     * Uses VariableAccessor.
     */
    @Test
    public void simpleVariableTest() {        
        prepareConfiguration("simpleVariable.ivml");
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("a")) {
                assertVariable(variable, 1, AssignmentState.ASSIGNED, "a after 1 reasoning");
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable, 10, AssignmentState.USER_ASSIGNED, "a after new value");
            }
            if (variable.getDeclaration().getName().equals("b")) {
                assertVariable(variable, null, AssignmentState.UNDEFINED, "b after 1 reasoning");                
            }
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("a")) {
                assertVariable(variable, 10, AssignmentState.USER_ASSIGNED, "a after 2 reasoning");                
            }
            if (variable.getDeclaration().getName().equals("b")) {
                assertVariable(variable, 20, AssignmentState.DERIVED, "b after 2 reasoning");
            }
        }
        
    }
    
    /**
     * Initial AssignmentResolver. 1st Reasoning. Compound variables value modification by user. 2nd Reasoning.
     * After variable modification it should not be changed by the reasoner.
     * Uses VariableAccessor (assigns value to cmp as Variable). - FAILS!
     */
    @Test
    public void compoundVariableTest() {        
        prepareConfiguration("compoundVariable.ivml");
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 1, AssignmentState.ASSIGNED, "cmp.a after 1 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED, "cmp.b after 1 reasoning");
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                        "cmp.a after new value");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED, "cmp.b after new value");
            }

        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                        "cmp.a after 2 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.DERIVED, "cmp.b after 2 reasoning");
            }
        }
        
    }
    
    /**
     * Initial AssignmentResolver. 1st Reasoning. Compound variables value modification by user. 2nd Reasoning.
     * After variable modification it should not be changed by the reasoner.
     * Uses CompoundSlotAccessor.
     */
    @Test
    public void compoundConstraintsTest() {        
        prepareConfiguration("compoundConstraints.ivml");
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 1, AssignmentState.DERIVED, "cmp.a after 1 reasoning");
                assertVariable(variable.getNestedElement(1), null, AssignmentState.UNDEFINED, 
                        "cmp.b after 1 reasoning");
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED, 
                        "cmp.a after new value");
                assertVariable(variable.getNestedElement(1), null, AssignmentState.UNDEFINED, 
                        "cmp.b after new value");
            }
            
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED, 
                        "cmp.a after 2 reasoning");
                assertVariable(variable.getNestedElement(1), 20, AssignmentState.DERIVED, 
                        "cmp.b after 2 reasoning");
            }
        }
        
    }
    
    /**
     * Initial AssignmentResolver. 1st Reasoning. Compound variables value modification by user. 2nd Reasoning.
     * After variable modification it should not be changed by the reasoner.
     * Uses VariableAccessor.
     */
    @Test
    public void collectionOfSimpleVariablesTest() {        
        prepareConfiguration("collectionOfSimpleVariables.ivml");
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 1, AssignmentState.ASSIGNED,
                    "seqA[0] after 1 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED,
                     "seqA[1] after 1 reasoning");
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                    "after user defined value for seqA[0]");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED,
                    "after user defined value for seqA[0]");
            }            
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                        "seqA[0] after 2 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.DERIVED,
                         "seqA[1] after 2 reasoning");             
            }
        }        
    }

    
    /**
     * Initial AssignmentResolver. 1st Reasoning. Compound variables value modification by user. 2nd Reasoning.
     * After variable modification it should not be changed by the reasoner.
     * Uses VariableAccessor.
     */
    @Test
    public void collectionOfIntegersTest() {        
        prepareConfiguration("collectionOfIntegers.ivml");
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 1, AssignmentState.ASSIGNED,
                        "seqA[0] after 1 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED,
                         "seqA[1] after 1 reasoning");   
                Assert.assertEquals("seqA[0] after 1 reasoning", 1, variable.getNestedElement(0).getValue().getValue());
                Assert.assertSame("seqA[0] after 1 reasoning", AssignmentState.ASSIGNED, variable.getState());       
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                        "seqA[0] after new value");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.ASSIGNED,
                         "seqA[1] after new value");
            }
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 10, AssignmentState.USER_ASSIGNED,
                        "seqA[0] after 2 reasoning");
                assertVariable(variable.getNestedElement(1), 2, AssignmentState.DERIVED,
                         "seqA[1] after 2 reasoning"); 
            }
        }
    }

    /**
     * Performs a simple test in runtime reasoning mode.
     * 
     * @throws ModelQueryException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void runtimeReasoningTest() throws ModelQueryException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        prepareConfiguration("runtimeReasoning.ivml");
        runReasoning();
        
        rConfig.setRuntimeMode(true);
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_SYSOUT);
        Reasoner reasoner = new Reasoner();
        IReasonerInstance inst = reasoner.createInstance(project, config, rConfig);
        ReasoningResult rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertFalse(rResult.hasConflict());
        
        AbstractVariable bDecl = ModelQuery.findVariable(project, "b", null);
        IDecisionVariable bVar = config.getDecision(bDecl);
        bVar.setValue(ValueFactory.createValue(IntegerType.TYPE, 11), AssignmentState.ASSIGNED);
        rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertFalse(rResult.hasConflict());

        
        bVar.setValue(ValueFactory.createValue(IntegerType.TYPE, 4), AssignmentState.ASSIGNED);
        rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(rResult.hasConflict());
    }

    /**
     * Performs a simple test in runtime reasoning mode.
     * 
     * @throws ModelQueryException shall not occur
     * @throws ValueDoesNotMatchTypeException shall not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void runtimeReasoningConstraintSetTest() throws ModelQueryException, ValueDoesNotMatchTypeException, 
        ConfigurationException {
        prepareConfiguration("runtimeReasoningConstraintSet.ivml");
        runReasoning();
        
        rConfig.setRuntimeMode(true);
        rConfig.setAdditionalInformationLogger(ReasonerConfiguration.ADDITIONAL_INFO_LOG_SYSOUT);
        Reasoner reasoner = new Reasoner();
        IReasonerInstance inst = reasoner.createInstance(project, config, rConfig);
        ReasoningResult rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertFalse(rResult.hasConflict());
        
        AbstractVariable bDecl = ModelQuery.findVariable(project, "b", null);
        IDecisionVariable bVar = config.getDecision(bDecl);
        bVar.setValue(ValueFactory.createValue(IntegerType.TYPE, 11), AssignmentState.ASSIGNED);
        rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertFalse(rResult.hasConflict());

        bVar.setValue(ValueFactory.createValue(IntegerType.TYPE, 4), AssignmentState.ASSIGNED);
        rResult = inst.propagate(ProgressObserver.NO_OBSERVER);
        Assert.assertTrue(rResult.hasConflict());
    }

}
