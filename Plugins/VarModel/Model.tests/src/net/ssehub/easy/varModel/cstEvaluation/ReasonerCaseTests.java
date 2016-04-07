package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Test;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Some test cases due to the reasoning experiments by roman.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerCaseTests {

    /**
     * Tests <code>(bool_134 and bool_214) and (not (bool_39 xor bool_227));</code>.
     * 
     * @throws ValueDoesNotMatchTypeException in case that value assignments fail (shall not occur)
     * @throws ConfigurationException in case that initial assignment of values fail (shall not occur)
     * @throws CSTSemanticException in case that the expressions created during this test are not 
     *   valid (shall not occur)
     */
    @Test
    public void testBoolCase() throws ConfigurationException, ValueDoesNotMatchTypeException, CSTSemanticException {
        Project project = new Project("Test");
        DecisionVariableDeclaration bool134 = new DecisionVariableDeclaration("bool_134", BooleanType.TYPE, project);
        project.add(bool134);
        DecisionVariableDeclaration bool214 = new DecisionVariableDeclaration("bool_214", BooleanType.TYPE, project);
        project.add(bool214);
        DecisionVariableDeclaration bool39 = new DecisionVariableDeclaration("bool_39", BooleanType.TYPE, project);
        project.add(bool39);
        DecisionVariableDeclaration bool227 = new DecisionVariableDeclaration("bool_227", BooleanType.TYPE, project);
        project.add(bool227);
        
        ConstraintSyntaxTree left = Utils.createCall(bool134, BooleanType.AND, new Variable(bool214));
        left.inferDatatype();
        left = Utils.wrapInParenthesis(left);

        ConstraintSyntaxTree right = Utils.createCall(bool39, BooleanType.XOR, new Variable(bool227));
        right.inferDatatype();
        right = Utils.wrapInParenthesis(right);
        right = Utils.createCall(right, BooleanType.NOT);
        right.inferDatatype();
        right = Utils.wrapInParenthesis(right);
        ConstraintSyntaxTree cst = Utils.createCall(left, BooleanType.AND, right);
        cst.inferDatatype();
        cst = Utils.wrapInParenthesis(cst);
        
        Configuration config = new Configuration(project);
        config.getDecision(bool134).setValue(ValueFactory.createValue(BooleanType.TYPE, false), 
            AssignmentState.ASSIGNED);
        config.getDecision(bool214).setValue(ValueFactory.createValue(BooleanType.TYPE, false), 
            AssignmentState.ASSIGNED);
        config.getDecision(bool39).setValue(ValueFactory.createValue(BooleanType.TYPE, true), 
            AssignmentState.ASSIGNED);
        config.getDecision(bool227).setValue(ValueFactory.createValue(BooleanType.TYPE, false), 
            AssignmentState.ASSIGNED);

        EvaluationVisitor visitor = new EvaluationVisitor();
        visitor.init(config, AssignmentState.DEFAULT, false, null);
        cst.accept(visitor);
        Utils.assertEquals(false, visitor.getResult());
        visitor.clear();
    }

    // did not go on as the reason for failing was a misuse of "="

}
