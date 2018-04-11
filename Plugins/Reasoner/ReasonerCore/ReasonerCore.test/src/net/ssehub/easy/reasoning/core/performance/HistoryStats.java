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
public class HistoryStats extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected HistoryStats(ITestDescriptor descriptor) {
        super(descriptor, "historyPerformance");
    }
    
    /**
     * Tests history models.
     */
    @Test    
    public void historyStatsTest() {
        reasoningTest("d2d_v10_c1_bir_l1_0.ivml", 0);    
//        reasoningTest("d2d_v10_c1_bir_l1_0.ivml", 0);    
//        reasoningTest("d2d_v100_c10_bir_l1_0.ivml", 6);    
//        reasoningTest("d2d_v1000_c100_bir_l1_0.ivml", 42);
//        reasoningTest("d2d_v10_c1_bir_l3_0.ivml", 0);    
//        reasoningTest("d2d_v100_c10_bir_l3_0.ivml", 6);    
//        reasoningTest("d2d_v1000_c100_bir_l3_0.ivml", 42);
    } 
   
}
