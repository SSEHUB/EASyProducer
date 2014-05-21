package de.uni_hildesheim.sse.reasoning.drools2;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Test cases with coded reasoning scenarios.
 * @author El-Sharkawy
 *
 */
public class ReasoningScenarioTests {

    private Project project;
    private Configuration config;
    
    /**
     * Creates a project for reasoning.
     * The project will be:
     * <pre>
     * project reasoningTest {
     *
     *    Integer intA;
     *    Integer intB;
     *    intA = 2;
     *    intA == 2 implies intB == 3;
     * }
     * </pre>
     * @throws ValueDoesNotMatchTypeException Must not happen otherwise there is an error inside the
     * {@link Configuration}.
     * @throws CSTSemanticException Must not happen otherwise there is an error inside the
     * {@link de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree}s
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        project = new Project("reasoningTest");
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(intA);
        project.add(intB);
        
        // Create Assignment: intA = 2
        Variable var = new Variable(intA);
        Value value = ValueFactory.createValue(IntegerType.TYPE, 2);
        ConstantValue constValue = new ConstantValue(value);
        OCLFeatureCall call = new OCLFeatureCall(var, OclKeyWords.ASSIGNMENT, constValue);
        Constraint assignment = new Constraint(project);
        assignment.setConsSyntax(call);
        project.add(assignment);
        
        // Create Constraint: intA == 2 implies intB == 3
        Variable varA = new Variable(intA);
        Variable varB = new Variable(intB);
        Value valA = ValueFactory.createValue(IntegerType.TYPE, 2);
        Value valB = ValueFactory.createValue(IntegerType.TYPE, 3);
        ConstantValue constA = new ConstantValue(valA);
        ConstantValue constB = new ConstantValue(valB);
        OCLFeatureCall lhs = new OCLFeatureCall(varA, OclKeyWords.EQUALS, constA);
        OCLFeatureCall rhs = new OCLFeatureCall(varB, OclKeyWords.EQUALS, constB);
        OCLFeatureCall complete = new OCLFeatureCall(lhs, OclKeyWords.IMPLIES, rhs);
        Constraint constraint = new Constraint(project);
        constraint.setConsSyntax(complete);
        project.add(constraint);
        
        ProjectTestUtilities.validateProject(project);
        config = new Configuration(project);
        int nOfAssignedVariables = 0;
        for (IDecisionVariable decVar : config) {
            if (decVar.hasValue() && AssignmentState.ASSIGNED == decVar.getState()) {
                nOfAssignedVariables++;
            }
        }
        Assert.assertEquals("Error: More or less variables are configured than expected.", 1, nOfAssignedVariables);
    }
    
    /**
     * Tests whether variables will not be removed after running the reasoner several times.
     * <ol>
     * <li>Runs the propagation task</li>
     * <li>Runs validation/check task</li>
     * <li>Checks that after the second reasong the same amount of variables have a value after the first reasonign</li>
     * </ol>
     */
    @Test
    public void testPropagateAndReasonAgain() {
        // 1. Propagate Values
        DroolsReasoner reasoner = new DroolsReasoner();
        reasoner.propagate(project, config, null, ProgressObserver.NO_OBSERVER);
        int nOfAssignedVariables = 0;
        for (IDecisionVariable decVar : config) {
            if (decVar.hasValue()) {
                nOfAssignedVariables++;
            }
        }
        Assert.assertEquals("Error: More or less variables are configured than expected.", 2, nOfAssignedVariables);
        
        // 2. validate (again)
        reasoner = new DroolsReasoner();
        reasoner.check(project, config, null, ProgressObserver.NO_OBSERVER);
        nOfAssignedVariables = 0;
        for (IDecisionVariable decVar : config) {
            if (decVar.hasValue()) {
                nOfAssignedVariables++;
            }
        }
        Assert.assertEquals("Error: More or less variables are configured than expected.", 2, nOfAssignedVariables);
    }
}
