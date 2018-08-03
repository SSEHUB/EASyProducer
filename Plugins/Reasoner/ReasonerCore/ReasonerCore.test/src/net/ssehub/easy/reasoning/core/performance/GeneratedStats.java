package net.ssehub.easy.reasoning.core.performance;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class GeneratedStats extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected GeneratedStats(ITestDescriptor descriptor) {
        super(descriptor, "ssePerformance");
    }
    
    /**
     * Tests Boolean 1 to 3 ratio.
     */
    @Test    
    public void gr11() {
        reasoningTest("gr1_1_v100_c300_b_l2_0.ivml", 150);
        reasoningTest("gr1_1_v100_c300_b_l2_0.ivml", 150);
        reasoningTest("gr1_1_v300_c900_b_l2_0.ivml", 438);
        reasoningTest("gr1_1_v500_c1500_b_l2_0.ivml", 726);
        reasoningTest("gr1_1_v1000_c3000_b_l2_0.ivml", 1518);
        reasoningTest("gr1_1_v1500_c4500_b_l2_0.ivml", 2236);
    } 
    
    /**
     * Tests Boolean 1 to 1 ratio.
     */
    @Test    
    public void gr12() {
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", 46);
        reasoningTest("gr1_2_v100_c100_b_l2_0.ivml", 46);
        reasoningTest("gr1_2_v300_c300_b_l2_0.ivml", 124);
        reasoningTest("gr1_2_v500_c500_b_l2_0.ivml", 266);
        reasoningTest("gr1_2_v1000_c1000_b_l2_0.ivml", 504);
        reasoningTest("gr1_2_v1500_c1500_b_l2_0.ivml", 739);
    }   

}
