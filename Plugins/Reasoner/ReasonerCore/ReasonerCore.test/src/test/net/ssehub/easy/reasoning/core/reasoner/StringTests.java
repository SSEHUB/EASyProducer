package test.net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

/**
 * Configures the String tests for SSE reasoner.
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
