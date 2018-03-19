package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
     * Initializes this Test class.
     */
    @Before
    public void setUpBeforeClass() {
        startup();
    }
    
    /**
     * Frees the memory after testing.
     */
    @After
    public void tearDownAfterClass() {
        shutdown();
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

}
