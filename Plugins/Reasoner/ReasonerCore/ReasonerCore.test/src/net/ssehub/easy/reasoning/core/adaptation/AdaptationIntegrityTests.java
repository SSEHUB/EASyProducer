package net.ssehub.easy.reasoning.core.adaptation;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class AdaptationIntegrityTests extends AbstractTest {

    private Configuration config;
    private ReasonerConfiguration rConfig;
    private Project project;
    private DecisionVariableDeclaration declA;
    private DecisionVariableDeclaration declB;
    private DecisionVariableDeclaration declC;
    private DecisionVariableDeclaration myParam;

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected AdaptationIntegrityTests(ITestDescriptor descriptor) {
        super(descriptor, null);
    }

    /**
     * Creates a simple test project and performs reasoning.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException  Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    public void createSimpleProject() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create project and variables
        project = new Project("SimpleTestProject");
        declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(declA);
        declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(declB);
        declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, project);
        declC.setValue(33);
        project.add(declC);
        
        // Create assignment
        Value valA = ValueFactory.createValue(declA.getType(), 31);
        Variable varA = new Variable(declA);
        ConstantValue constValA = new ConstantValue(valA);
        OCLFeatureCall assignmentA = new OCLFeatureCall(varA, OclKeyWords.ASSIGNMENT, constValA);
        Constraint assignmentConstraint = new Constraint(project);
        assignmentConstraint.setConsSyntax(assignmentA);
        project.add(assignmentConstraint);
        
        // Create implies constraint
        Value valB = ValueFactory.createValue(declB.getType(), 37);
        ConstantValue constValB = new ConstantValue(valB);
        Value valC = ValueFactory.createValue(declC.getType(), 40);
        ConstantValue constValC = new ConstantValue(valC);
        OCLFeatureCall equalsA = new OCLFeatureCall(varA, OclKeyWords.EQUALS, constValA);
        OCLFeatureCall equalsB = new OCLFeatureCall(new Variable(declB), OclKeyWords.EQUALS, constValB);
        OCLFeatureCall equalsC = new OCLFeatureCall(new Variable(declC), OclKeyWords.EQUALS, constValC);
        OCLFeatureCall implies = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsB);
        OCLFeatureCall impliesFail = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsC);
        Constraint impliesConstaint = new Constraint(project);
        impliesConstaint.setConsSyntax(implies);
        project.add(impliesConstaint);
        Constraint impliesConstaintFail = new Constraint(project);
        impliesConstaintFail.setConsSyntax(impliesFail);
        project.add(impliesConstaintFail);
        
        // debugging
        System.out.println(StringProvider.toIvmlString(project));
        
        // Create Configuration (will also start AssignmentResolver)
        config = new Configuration(project, true);        
        rConfig = new ReasonerConfiguration();
        IReasoner reasoner = createReasoner();
        reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
    } 
    
    /**
     * Creates a simple test project and performs reasoning.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException  Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    public void createCompoundProject() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create project and variables
        project = new Project("CompoundTestProject");
        Compound param = new Compound("IntParameter", project);
        declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, param);
        param.add(declA);
        declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, param);
        param.add(declB);
        declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, param);
        declC.setValue(33);
        param.add(declC);
        project.add(param);
        
        myParam = new DecisionVariableDeclaration("myParam", param, project);
        project.add(myParam);
        
        // Create assignment
        Value valA = ValueFactory.createValue(declA.getType(), 31);
        Variable varA = new Variable(declA);
        ConstantValue constValA = new ConstantValue(valA);
        OCLFeatureCall assignmentA = new OCLFeatureCall(varA, OclKeyWords.ASSIGNMENT, constValA);
        Constraint assignmentConstraint = new Constraint(param);
        assignmentConstraint.setConsSyntax(assignmentA);
        param.addConstraint(assignmentConstraint);
        
        // Create implies constraint
        Value valB = ValueFactory.createValue(declB.getType(), 37);
        ConstantValue constValB = new ConstantValue(valB);
        Value valC = ValueFactory.createValue(declC.getType(), 40);
        ConstantValue constValC = new ConstantValue(valC);
        OCLFeatureCall equalsA = new OCLFeatureCall(varA, OclKeyWords.EQUALS, constValA);
        OCLFeatureCall equalsB = new OCLFeatureCall(new Variable(declB), OclKeyWords.EQUALS, constValB);
        OCLFeatureCall equalsC = new OCLFeatureCall(new Variable(declC), OclKeyWords.EQUALS, constValC);
        OCLFeatureCall implies = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsB);
        OCLFeatureCall impliesFail = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsC);
        Constraint impliesConstaint = new Constraint(param);
        impliesConstaint.setConsSyntax(implies);
        param.addConstraint(impliesConstaint);
        Constraint impliesConstaintFail = new Constraint(param);
        impliesConstaintFail.setConsSyntax(impliesFail);
        param.addConstraint(impliesConstaintFail);
        
        // debugging
        System.out.println(StringProvider.toIvmlString(project));
        
        // Create Configuration (will also start AssignmentResolver)
        config = new Configuration(project, true);        
        rConfig = new ReasonerConfiguration();
        IReasoner reasoner = createReasoner();
        reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
    }  
    
    /**
     * Tests the results of initial reasoning.
     */
    @Test
    public void testSimpleResultAfterReasoning() {
        try {
            createSimpleProject();
            IDecisionVariable iVarA = config.getDecision(declA);
            IDecisionVariable iVarB = config.getDecision(declB);
            IDecisionVariable iVarC = config.getDecision(declC);
            
            // Test correct assignments
            Assert.assertNotNull(iVarA);
            Assert.assertEquals(31, iVarA.getValue().getValue());
            assertContained("iVarA", iVarA.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);

            Assert.assertNotNull(iVarB);
            Assert.assertEquals(37, iVarB.getValue().getValue());
            assertContained("iVarB", iVarB.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);
            
            Assert.assertNotNull(iVarC);
            Assert.assertEquals(33, iVarC.getValue().getValue());
            Assert.assertSame("iVarC", AssignmentState.DEFAULT, iVarC.getState());

        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests the results of reasoning after changing value for adaptation.
     */
//    @Ignore
    @Test
    public void testSimpleResultAfterReasoningForAdaptation() {
        try {
            createSimpleProject();
            
            Value newValA = ValueFactory.createValue(declA.getType(), 101);
            Value newValC = ValueFactory.createValue(declC.getType(), 33);
            try {
                config.getDecision(declA).setValue(newValA, AssignmentState.USER_ASSIGNED);
                config.getDecision(declC).setValue(newValC, AssignmentState.USER_ASSIGNED);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            IReasoner reasoner = createReasoner();
            reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
            
            IDecisionVariable iVarA = config.getDecision(declA);
            IDecisionVariable iVarB = config.getDecision(declB);
            IDecisionVariable iVarC = config.getDecision(declC);
            
            // Test correct assignments
            Assert.assertNotNull(iVarA);
            Assert.assertEquals(101, iVarA.getValue().getValue());
            Assert.assertSame("iVarA", AssignmentState.USER_ASSIGNED, iVarA.getState());
            
            Assert.assertNotNull(iVarB);
            Assert.assertEquals(37, iVarB.getValue().getValue());
            assertContained("iVarB", iVarB.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);
            
            Assert.assertNotNull(iVarC);
            Assert.assertEquals(33, iVarC.getValue().getValue());
            Assert.assertSame("iVarC", AssignmentState.USER_ASSIGNED, iVarC.getState());
            
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests the results of initial reasoning.
     */
    @Test
    public void testCompoundResultAfterReasoning() {
        try {
            createCompoundProject();
            
            IDecisionVariable iMyParam = config.getDecision(myParam);
            IDecisionVariable iVarA = iMyParam.getNestedElement(0);
            IDecisionVariable iVarB = iMyParam.getNestedElement(1);
            IDecisionVariable iVarC = iMyParam.getNestedElement(2);
            
            // Test correct assignments
            Assert.assertNotNull(iMyParam);
            Assert.assertSame("iMyParam", AssignmentState.ASSIGNED, iMyParam.getState());
            
            Assert.assertNotNull(iVarA);
            Assert.assertEquals(31, iVarA.getValue().getValue());
            Assert.assertSame("iVarA", AssignmentState.DERIVED, iVarA.getState());
            
            Assert.assertNotNull(iVarB);
            Assert.assertEquals(37, iVarB.getValue().getValue());
            Assert.assertSame("iVarB", AssignmentState.DERIVED, iVarB.getState());
            
            Assert.assertNotNull(iVarC);
            Assert.assertEquals(33, iVarC.getValue().getValue());
            Assert.assertSame("iVarC", AssignmentState.DEFAULT, iVarC.getState());
            
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests the results of initial reasoning.
     */
    @Test
    public void testCompoundResultAfterReasoningForAdaptation() {
        try {
            createCompoundProject();
            Value newValA = ValueFactory.createValue(declA.getType(), 101);
            Value newValC = ValueFactory.createValue(declC.getType(), 33);
            try {
                config.getDecision(myParam).getNestedElement(0).setValue(newValA, AssignmentState.USER_ASSIGNED);
                config.getDecision(myParam).getNestedElement(2).setValue(newValC, AssignmentState.USER_ASSIGNED);
            } catch (ConfigurationException e) {
                e.printStackTrace();
            }
            IReasoner reasoner = createReasoner();
            reasoner.propagate(project, config, rConfig, ProgressObserver.NO_OBSERVER);
            
            IDecisionVariable iMyParam = config.getDecision(myParam);
            IDecisionVariable iVarA = iMyParam.getNestedElement(0);
            IDecisionVariable iVarB = iMyParam.getNestedElement(1);
            IDecisionVariable iVarC = iMyParam.getNestedElement(2);
            
            // Test correct assignments
            Assert.assertNotNull(iMyParam);
            Assert.assertSame("iMyParam", AssignmentState.ASSIGNED, iMyParam.getState());
            
            Assert.assertNotNull(iVarA);
            Assert.assertEquals(101, iVarA.getValue().getValue());
            Assert.assertSame("iVarA", AssignmentState.USER_ASSIGNED, iVarA.getState());
            
            Assert.assertNotNull(iVarB);
            Assert.assertEquals(37, iVarB.getValue().getValue());
            Assert.assertSame("iVarB", AssignmentState.DERIVED, iVarB.getState());
            
            Assert.assertNotNull(iVarC);
            Assert.assertEquals(33, iVarC.getValue().getValue());
            Assert.assertSame("iVarC", AssignmentState.USER_ASSIGNED, iVarC.getState());
            
        } catch (ValueDoesNotMatchTypeException e) {
            e.printStackTrace();
        } catch (CSTSemanticException e) {
            e.printStackTrace();
        }
    }
    
}
