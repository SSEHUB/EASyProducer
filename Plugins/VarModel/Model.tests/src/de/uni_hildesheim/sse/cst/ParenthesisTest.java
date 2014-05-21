package de.uni_hildesheim.sse.cst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;

/**
 * Tests correct behavior of the {@link Parenthesis} class.
 * @author El-Sharkawy
 *
 */
public class ParenthesisTest {
    private Project project;
    private Variable realA;
    private Variable realB;
    private Variable realC;
    
    /**
     * Creates a project with the variables for testing.
     */
    @Before
    public void setUp() {
        //Create VarModel
        project = new Project("project");
        DecisionVariableDeclaration realADecl = new DecisionVariableDeclaration("realA", RealType.TYPE, project);
        DecisionVariableDeclaration realBDecl = new DecisionVariableDeclaration("realB", RealType.TYPE, project);
        DecisionVariableDeclaration realCDecl = new DecisionVariableDeclaration("realC", RealType.TYPE, project);
        project.add(realADecl);
        project.add(realBDecl);
        project.add(realCDecl);
        
        //Create constraint variables for building constraints in test methods
        realA = new Variable(realADecl);
        realB = new Variable(realBDecl);
        realC = new Variable(realCDecl);
    }
    
    /**
     * Tests the inferDatatype method of {@link Parenthesis}.
     * Builds a constraint <code>(realA + realB) &lt realC</code>
     * @throws CSTSemanticException Must not occur, otherwise there is an error inside the <code>cst</code> package
     */
    @Test
    public void testInferDatatype() throws CSTSemanticException {
        // Test: (realA + realB) < realC
        
        //Create (realA + realB)
        OCLFeatureCall nestedCall = new OCLFeatureCall(realA, OclKeyWords.PLUS, realB);
        Assert.assertEquals(RealType.TYPE, nestedCall.inferDatatype());
        Parenthesis parenthesis = new Parenthesis(nestedCall);
        Assert.assertEquals(nestedCall.inferDatatype(), parenthesis.inferDatatype());
        
        //Create (realA + realB) < realC
        OCLFeatureCall completeCall = new OCLFeatureCall(parenthesis, OclKeyWords.LESS, realC);
        Assert.assertEquals(BooleanType.TYPE, completeCall.inferDatatype());
    }

}
