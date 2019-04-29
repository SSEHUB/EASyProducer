package test.net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Incremental reasoning tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class RuntimeReasoningTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected RuntimeReasoningTests(ITestDescriptor descriptor) {
        super(descriptor, "incrementalReasoningConstraints");
    }

    @Override
    protected void configureReasoner(ReasonerConfiguration rConfig) {
        rConfig.setRuntimeMode(true);
    }
    
    /**
     * Tests default assignments ignore.
     */
    @Test
    public void ignoreDefaultAssignmentsTest() {
        reasoningTest("IgnoreDefaultAssignments.ivml", 0);
    }
    
    /**
     * Tests validation constraint filter.
     */
    @Test
    public void validationConstraintFilterTest() {
        reasoningTest("ValidationConstraintFilter.ivml", 0);
    }
    
    /**
     * Tests partial freeze.
     */
    @Test
    public void partialFreezeTest() {
        reasoningTest("PartialFreeze.ivml", 0);
    }
    
}
