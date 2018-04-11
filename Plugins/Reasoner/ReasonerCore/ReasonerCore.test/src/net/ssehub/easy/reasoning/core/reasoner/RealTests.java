package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

/**
 * Configures the real tests for SSE reasoner.
 * 
 * @author Eichelberger
 */
public class RealTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected RealTests(ITestDescriptor descriptor) {
        super(descriptor, "real");
    }
    
    /**
     * Real defaults test.
     */
    @Test
    public void realDefaultsTest() {
        reasoningTest("RealDefaultsTest.ivml", 0);
    } 
    
    /**
     * Real assign test.
     */
    @Test
    public void realAssignTest() {
        reasoningTest("RealAssignTest.ivml", 0);
    } 
    
    /**
     * Real in compound defaults test.
     */
    @Test
    public void realInCompoundDefaultsTest() {
        reasoningTest("RealInCompoundDefaultsTest.ivml", 0);
    } 
    
    /**
     * Real in compound assign test.
     */
    @Test
    public void realInCompoundAssignTest() {
        reasoningTest("RealInCompoundAssignTest.ivml", 0);
    } 

    /**
     * Real in collection defaults test.
     */
    @Test
    public void realInCollectionDefaultsTest() {
        reasoningTest("RealInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * Real in collection assign test.
     */
    @Test
    public void realInCollectionAssignTest() {
        reasoningTest("RealInCollectionAssignTest.ivml", 2);
    } 

    /**
     * Real reference assign test.
     */
    @Test
    public void realReferenceAssignTest() {
        reasoningTest("RealRefAssignTest.ivml", 0);
    } 

    /**
     * Real annotation test.
     */
    @Test
    public void realAnnotationTest() {
        reasoningTest("RealAnnotationTest.ivml", 10);
    } 

    /**
     * Combined reference-typedef on Real.
     */
    @Test
    public void referenceDerivedRealTest() {
        reasoningTest("ReferenceDerivedRealTest.ivml", 4);
    }    
    
}
