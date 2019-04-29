package test.net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Incremental reasoning tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class FailedDecisionsTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected FailedDecisionsTests(ITestDescriptor descriptor) {
        super(descriptor, "failedDecisions");
    }
    
    /**
     * Tests default assignments ignore.
     */
    @Test
    public void basicConstraintTest() {
        reasoningTest("basicConstraintTest.ivml", 1);
    }
    
    /**
     * Tests validation constraint filter.
     */
    @Test
    public void basicAssignmentTest() {
        reasoningTest("basicAssignmentTest.ivml", 2);
    }
    
    /**
     * Tests partial freeze.
     */
    @Test
    public void basicCompoundConstraintTest() {
        reasoningTest("basicCompoundConstraintTest.ivml", 1);
    }
    
}
