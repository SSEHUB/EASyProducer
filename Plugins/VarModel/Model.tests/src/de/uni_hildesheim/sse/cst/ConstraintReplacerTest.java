package de.uni_hildesheim.sse.cst;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintReplacer;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Testfile for the ConstraintReplacer.
 * @author beck
 *
 */
public class ConstraintReplacerTest {
    
    private Project project;
    private DecisionVariableDeclaration origin;
    private DecisionVariableDeclaration replacement;
    private Variable originVariable;
    private Variable replacementVariable;
    private Value value;
    private ConstantValue constValue;
    
    /**
     * Creates project, and a origin variable declaration which should be replaced by the replacement.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        //Create Variabel declarations
        project = new Project("Project");
        origin = new DecisionVariableDeclaration("Origin", IntegerType.TYPE, project);
        replacement = new DecisionVariableDeclaration("Replacement", IntegerType.TYPE, project);        
        originVariable = new Variable(origin);
        replacementVariable = new Variable(replacement);       

        //Create nested elements for the constraint
        value = ValueFactory.createValue(IntegerType.TYPE, "5");
        constValue = new ConstantValue(value);
    }

    /**
     * Test whether a simple OCLFeatureCall is copied correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testCopyOfSimpleOCLFeatureCall() throws ValueDoesNotMatchTypeException {       
        
        //Create Constraint
        String operation = IntegerType.GREATER_INTEGER_INTEGER.getName();
        OCLFeatureCall originConstraint = new OCLFeatureCall(originVariable, operation, constValue);
        Assert.assertNotNull(originConstraint);
        
        //Copy constraint and replace origin with replacement
        ConstraintReplacer replacer = new ConstraintReplacer(originConstraint);
        OCLFeatureCall copiedConstraint =
                (OCLFeatureCall) replacer.replaceVariable(originVariable, replacementVariable);
        
        //Test whether originConstraint has not changed
        Assert.assertNotNull(originConstraint);
        Assert.assertEquals(originVariable, originConstraint.getOperand());
        Assert.assertEquals(operation, originConstraint.getOperation());
        Assert.assertEquals(constValue, originConstraint.getParameter(0));
        
        //Test whether copiedConstraint is correct instantiated
        Assert.assertNotNull(copiedConstraint);
        Assert.assertEquals(replacementVariable, copiedConstraint.getOperand());
        Assert.assertEquals(operation, copiedConstraint.getOperation());
        Assert.assertEquals(constValue, copiedConstraint.getParameter(0));
    }
    
    /**
     * Test whether a complex OCLFeatureCall is copied correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise there is an error in the whole model
     */
    @Test
    public void testCopyOfCombinedOCLFeatureCall() throws ValueDoesNotMatchTypeException {
        //Create left constraint
        String operation = IntegerType.GREATER_INTEGER_INTEGER.getName();
        OCLFeatureCall leftConstraint = new OCLFeatureCall(originVariable, operation, constValue);
        Assert.assertNotNull(leftConstraint);

        //Create right constraint
        DecisionVariableDeclaration b = new DecisionVariableDeclaration("b", IntegerType.TYPE, project);
        Variable bVariable = new Variable(b);
        Value valueB = ValueFactory.createValue(IntegerType.TYPE, "7");
        ConstantValue constValueB = new ConstantValue(valueB);             
        String operation2 = IntegerType.EQUALS_INTEGER_INTEGER.getName();
        OCLFeatureCall rightConstraint = new OCLFeatureCall(bVariable, operation2, constValueB);         
        
        //Combine leftConstraint and rightConstraint in a new constraint
        String completeOperation = BooleanType.IMPLIES.getName();
        OCLFeatureCall completeConstraint = new OCLFeatureCall(leftConstraint, completeOperation, rightConstraint);
        
        
        //Copy constraint and replace leftConstraint with replacement
        ConstraintReplacer replacer = new ConstraintReplacer(completeConstraint);
        OCLFeatureCall copiedConstraint = 
                (OCLFeatureCall) replacer.replaceVariable(originVariable, replacementVariable);
        
        
        //Test whether originConstraint has not changed
        Assert.assertNotNull(completeConstraint);
        Assert.assertEquals(leftConstraint, completeConstraint.getOperand());
        Assert.assertEquals(completeOperation, completeConstraint.getOperation());
        Assert.assertEquals(rightConstraint, completeConstraint.getParameter(0));
        
        //Test whether copiedConstraint is correct instantiated
        Assert.assertNotNull(copiedConstraint);
        //Cast is needed, to call getOperand a second time
        OCLFeatureCall leftOperand = (OCLFeatureCall) copiedConstraint.getOperand();
        Assert.assertEquals(replacementVariable, leftOperand.getOperand());
        Assert.assertEquals(completeOperation, copiedConstraint.getOperation());
        
        //Test whether the right part of constraint did not changed
        OCLFeatureCall copiedRightConstraint = (OCLFeatureCall) copiedConstraint.getParameter(0);
        Assert.assertEquals(rightConstraint.getOperand(), copiedRightConstraint.getOperand());
        Assert.assertEquals(rightConstraint.getOperation(), copiedRightConstraint.getOperation());
        Assert.assertEquals(rightConstraint.getParameter(0), copiedRightConstraint.getParameter(0));
    }

}
