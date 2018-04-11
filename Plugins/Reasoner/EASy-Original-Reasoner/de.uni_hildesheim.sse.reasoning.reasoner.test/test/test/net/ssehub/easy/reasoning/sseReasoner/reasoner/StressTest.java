package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import org.junit.Ignore;
import org.junit.Test;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Stresstests.
 * 
 * @author krafczyk
 */
public class StressTest extends net.ssehub.easy.reasoning.core.reasoner.StressTest {

    /**
     * Creates a specific test instance.
     */
    public StressTest() {
        super(TestDescriptor.INSTANCE);
    }

    @Override
    @Test
    @Ignore
    public void testConstraintEvaluation() {
        super.testConstraintEvaluation(); // TODO change still not implemented
    }

    @Override
    @Test
    @Ignore
    public void testConstraintDefaults() {
        super.testConstraintDefaults(); // TODO change still not implemented
    }
    
}
