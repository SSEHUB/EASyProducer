package net.ssehub.easy.reasoning.core.adaptation;

import org.eclipse.xtext.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.frontend.IReasonerInstance;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
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
public class AdaptationScenarioTests extends AbstractTest {
    
    private Project project;
    private Configuration config;
    private ReasonerConfiguration rConfig;   

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected AdaptationScenarioTests(ITestDescriptor descriptor) {
        super(descriptor, "adaptationScenarios");
    }
    
    /**
     * Helper method to prepare configuration from a project.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     */
    private void prepareConfiguration(String path) {
        project = loadProject(path);
        config = new Configuration(project, true);        
        rConfig = new ReasonerConfiguration();
    }

    /**
     * Helper method to run reasoning.
     * 
     * @return the reasoning result
     */
    private ReasoningResult runReasoning() {
        IReasoner reasoner = createReasoner();
        return reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
    }

    /**
     * Asserts that a given variable has the expected value (and state).
     * @param variable The variable to test (maybe a nested variable, but not <tt>null</tt>).
     * @param expectedValue The expected value of the variable (must not be <tt>null</tt>).
     * @param explanation A error message if the Junit test case breaks
     * @param expectedStates Should be one of {@link AssignmentState#ASSIGNED} (if it was initialized by the
     *     configuration, {@link AssignmentState#USER_ASSIGNED} if it was manually overwritten by the user
     *     (inside the test case), or {@link AssignmentState#DERIVED} if the reasoner should overwrite a value during
     *     reasoning
     */
    private void assertVariable(IDecisionVariable variable, Object expectedValue, String explanation, 
         IAssignmentState... expectedStates) {
        
        Assert.assertNotNull("Tested variable was NULL, but was not expected to be.", variable);
        String name = variable.getDeclaration().getName();
        if (expectedValue != null) {
            Assert.assertNotNull(name + " " + explanation + " has NULL value, but was not expected.",
                    variable.getValue());        
            Assert.assertEquals(name + " " + explanation, expectedValue, variable.getValue().getValue());            
        } else {
            Assert.assertEquals(name + " " + explanation, expectedValue, variable.getValue()); 
        }
        Assert.assertTrue(name + " " + explanation, Arrays.contains(expectedStates, variable.getState()));
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
                assertVariable(variable, 1, "a after 1 reasoning", AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable, 10, "a after new value", AssignmentState.USER_ASSIGNED);
            }
            if (variable.getDeclaration().getName().equals("b")) {
                assertVariable(variable, null, "b after 1 reasoning", AssignmentState.UNDEFINED);
            }
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("a")) {
                assertVariable(variable, 10, "a after 2 reasoning", AssignmentState.USER_ASSIGNED);
            }
            if (variable.getDeclaration().getName().equals("b")) {
                assertVariable(variable, 20, "b after 2 reasoning", AssignmentState.DERIVED);
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
                assertVariable(variable.getNestedElement(0), 1, "cmp.a after 1 reasoning", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                assertVariable(variable.getNestedElement(1), 2, "cmp.b after 1 reasoning", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, "cmp.a after new value", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "cmp.b after new value", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
            }

        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 10, "cmp.a after 2 reasoning", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "cmp.b after 2 reasoning", AssignmentState.DERIVED);
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
                assertVariable(variable.getNestedElement(0), 1, "cmp.a after 1 reasoning", AssignmentState.DERIVED);
                assertVariable(variable.getNestedElement(1), null, "cmp.b after 1 reasoning", 
                     AssignmentState.UNDEFINED);
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, "cmp.a after new value", 
                        AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), null, "cmp.b after new value", 
                        AssignmentState.UNDEFINED);
            }
            
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("cmp")) {
                assertVariable(variable.getNestedElement(0), 10, "cmp.a after 2 reasoning", 
                         AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 20, "cmp.b after 2 reasoning", 
                         AssignmentState.DERIVED);
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
                assertVariable(variable.getNestedElement(0), 1, "seqA[0] after 1 reasoning", 
                     AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                assertVariable(variable.getNestedElement(1), 2, "seqA[1] after 1 reasoning", 
                     AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, "after user defined value for seqA[0]", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "after user defined value for seqA[0]", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
            }            
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 10, "seqA[0] after 2 reasoning", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "seqA[1] after 2 reasoning", 
                    AssignmentState.DERIVED);             
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
                assertVariable(variable.getNestedElement(0), 1, "seqA[0] after 1 reasoning", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                assertVariable(variable.getNestedElement(1), 2, "seqA[1] after 1 reasoning", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);   
                Assert.assertEquals("seqA[0] after 1 reasoning", 1, variable.getNestedElement(0).getValue().getValue());
                assertContained("seqA[0] after 1 reasoning", variable.getState(), 
                     AssignmentState.ASSIGNED, AssignmentState.DERIVED);
                try {
                    Value newValA = ValueFactory.createValue(IntegerType.TYPE, 10);
                    variable.getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                } catch (ValueDoesNotMatchTypeException e) {                    
                    e.printStackTrace();
                } catch (ConfigurationException e) {
                    e.printStackTrace();
                }
                assertVariable(variable.getNestedElement(0), 10, "seqA[0] after new value", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "seqA[1] after new value", 
                    AssignmentState.ASSIGNED, AssignmentState.DERIVED);
            }
        }
        runReasoning();
        for (IDecisionVariable variable : config) {
            if (variable.getDeclaration().getName().equals("seqA")) {
                assertVariable(variable.getNestedElement(0), 10, "seqA[0] after 2 reasoning", 
                    AssignmentState.USER_ASSIGNED);
                assertVariable(variable.getNestedElement(1), 2, "seqA[1] after 2 reasoning", 
                    AssignmentState.DERIVED); 
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
        IReasoner reasoner = createReasoner();
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
        IReasoner reasoner = createReasoner();
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
