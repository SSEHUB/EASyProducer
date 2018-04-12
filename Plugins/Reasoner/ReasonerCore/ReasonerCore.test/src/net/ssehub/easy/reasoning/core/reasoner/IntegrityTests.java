package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class IntegrityTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected IntegrityTests(ITestDescriptor descriptor) {
        super(descriptor, null); // no test path, in memory tests only
    }

    /**
     * Tests whether implies constraints will be handled correctly by the
     * {@link net.ssehub.easy.varModel.confModel.AssignmentResolver}.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException  Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    @Test
    public void testImplies() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create project and variables
        Project project = new Project("assignmentTestProject");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(declB);
        DecisionVariableDeclaration declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, project);
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
        
        // Create Configuration (will also start AssignmentResolver)
        Configuration config = new Configuration(project, true);
        IDecisionVariable iVarA = config.getDecision(declA);
        IDecisionVariable iVarB = config.getDecision(declB);
        IDecisionVariable iVarC = config.getDecision(declC);

        // Test correct assignments
        Assert.assertNotNull(iVarA);
        Assert.assertEquals(31, iVarA.getValue().getValue());
        assertContained(iVarA.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);

        Assert.assertNotNull(iVarB);
        Assert.assertEquals(37, iVarB.getValue().getValue());
        assertContained(iVarB.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);
        
        Assert.assertNotNull(iVarC);
        Assert.assertEquals(33, iVarC.getValue().getValue());
        Assert.assertSame(AssignmentState.DEFAULT, iVarC.getState());
    }    
    
}
