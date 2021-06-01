package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.varModel.model.Project;

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
        reasoningTest("RealRefAssignTestFail.ivml", 2); // re-assinment
    } 
    
    /**
     * Tests whether overridden default values for constraint variables are evaluated correctly.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testConstraintDefaults() throws IOException {
        Project p = loadCompleteProject("realRefAssign", "RealRefAssignTest");
        resultHandler(0, 0, p);
    }

    /**
     * Real annotation test.
     */
    @Test
    public void realAnnotationTest() {
        reasoningTest("RealAnnotationTest.ivml", 9);
    } 

    /**
     * Combined reference-typedef on Real.
     */
    @Test
    public void referenceDerivedRealTest() {
        reasoningTest("ReferenceDerivedRealTest.ivml", 4);
    }    
    
}
