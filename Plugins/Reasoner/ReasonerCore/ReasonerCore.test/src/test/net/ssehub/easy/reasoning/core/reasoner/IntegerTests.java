package test.net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelQueryException;

/**
 * Configures the integer tests for SSE reasoner.
 * 
 * @author Eichelberger
 */
public class IntegerTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected IntegerTests(ITestDescriptor descriptor) {
        super(descriptor, "integer");
    }
    
    /**
     * Integer defaults test.
     */
    @Test
    public void integerDefaultsTest() {
        reasoningTest("IntegerDefaultsTest.ivml", 0);
    } 
    
    /**
     * Integer assign test.
     */
    @Test
    public void integerAssignTest() {
        reasoningTest("IntegerAssignTest.ivml", 0);
    } 
    
    /**
     * Integer in compound defaults test.
     */
    @Test
    public void integerInCompoundDefaultsTest() {
        reasoningTest("IntegerInCompoundDefaultsTest.ivml", 0);
    } 
    
    /**
     * Integer in compound assign test.
     */
    @Test
    public void integerInCompoundAssignTest() {
        reasoningTest("IntegerInCompoundAssignTest.ivml", 0);
    } 

    /**
     * Integer in collection defaults test.
     */
    @Test
    public void integerInCollectionDefaultsTest() {
        reasoningTest("IntegerInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * Integer in collection assign test.
     */
    @Test
    public void integerInCollectionAssignTest() {
        reasoningTest("IntegerInCollectionAssignTest.ivml", 2);
    }

    /**
     * Integer reference assign test.
     */
    @Test
    public void integerReferenceAssignTest() {
        reasoningTest("IntegerRefAssignTest.ivml", 2);
    }

    /**
     * Integer annotation test.
     */
    @Test
    public void integerAnnotationTest() {
        reasoningTest("IntegerAnnotationTest.ivml", 9);
    }

    /**
     * Combined reference-typedef on Integer.
     */
    @Test
    public void referenceDerivedIntegerTest() {
        reasoningTest("ReferenceDerivedIntegerTest.ivml", 4);
    }

    /**
     * Reassignment failure (#46).
     */
    @Test
    public void variableFailTest() {
        reasoningTest("VariableFailTest.ivml", 1);
    }
    
    /**
     * Product test. [Ke Liu]
     * 
     * @throws ModelQueryException shall not happen
     */
    @Test
    public void productTest() throws ModelQueryException {
        Configuration cfg = reasoningTest("Product.ivml", 0);
        IDecisionVariable var = cfg.getDecision("i_product1", false);
        Assert.assertNotNull(var);
        Assert.assertNotNull(var.getValue());
        Assert.assertEquals(120, var.getValue().getValue());
        
        var = cfg.getDecision("i_product2", false);
        Assert.assertNotNull(var);
        Assert.assertNotNull(var.getValue());
        Assert.assertEquals(5040, var.getValue().getValue());
    }

}
