package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
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

}
