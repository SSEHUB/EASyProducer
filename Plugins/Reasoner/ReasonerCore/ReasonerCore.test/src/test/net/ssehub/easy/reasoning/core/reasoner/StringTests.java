package test.net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelQueryException;

/**
 * Configures the String tests.
 * 
 * @author Eichelberger
 */
public class StringTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected StringTests(ITestDescriptor descriptor) {
        super(descriptor, "string");
    }
    
    /**
     * String defaults test.
     */
    @Test
    public void stringDefaultsTest() {
        reasoningTest("StringDefaultsTest.ivml", 0);
    } 
    
    /**
     * String assign test.
     */
    @Test
    public void stringAssignTest() {
        reasoningTest("StringAssignTest.ivml", 0);
    } 
    
    /**
     * String in compound defaults test.
     */
    @Test
    public void stringInCompoundDefaultsTest() {
        reasoningTest("StringInCompoundDefaultsTest.ivml", 0);
    } 
    
    /**
     * String in compound assign test.
     */
    @Test
    public void stringInCompoundAssignTest() {
        reasoningTest("StringInCompoundAssignTest.ivml", 0);
    } 

    /**
     * String in collection defaults test.
     */
    @Test
    public void stringInCollectionDefaultsTest() {
        reasoningTest("StringInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * String in collection assign test.
     */
    @Test
    public void stringInCollectionAssignTest() {
        reasoningTest("StringInCollectionAssignTest.ivml", 2);
    } 

    /**
     * Empty default string assignment test.
     */
    @Test
    public void emptyStringTest() throws ModelQueryException {
        Configuration cfg = reasoningTest("EmptyString.ivml", 0);
        IDecisionVariable var = cfg.getDecision("val", false);
        Assert.assertNotNull(var);
        Assert.assertNotNull(var.getValue());
        Assert.assertEquals("", var.getValue().getValue());
        
        var = cfg.getDecision("c", false);
        Assert.assertNotNull(var);
        IDecisionVariable n = var.getNestedElement("val");
        Assert.assertNotNull(n);
        Assert.assertNotNull(n.getValue());
        Assert.assertEquals("", n.getValue().getValue());
        
        n = var.getNestedElement("inner");
        Assert.assertNotNull(n);
        IDecisionVariable n1 = var.getNestedElement("val");
        Assert.assertNotNull(n1);
        Assert.assertNotNull(n1.getValue());
        Assert.assertEquals("", n1.getValue().getValue());
    } 
    
    /**
     * String reference assign test.
     */
    @Test
    public void stringReferenceAssignTest() {
        reasoningTest("StringRefAssignTest.ivml", 2);
    } 

    /**
     * String annotation test.
     */
    @Test
    public void stringAnnotationTest() {
        reasoningTest("StringAnnotationTest.ivml", 9);
    } 
    
    /**
     * Combined reference-typedef on String.
     */
    @Test
    public void referenceDerivedStringTest() {
        reasoningTest("ReferenceDerivedStringTest.ivml", 4);
    }

}
