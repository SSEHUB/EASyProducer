package test.net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

/**
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 * @author Eichelberger
 */
public class EvalTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected EvalTests(ITestDescriptor descriptor) {
        super(descriptor, "evals");
    }
    
    /**
     * Tests simple eval (priority).
     */
    @Test
    public void simpleEval() {
        reasoningTest("SimpleEval.ivml", 0);
    }
    
    /**
     * Tests nested eval.
     */
    @Test
    public void nestedEval() {
        reasoningTest("NestedEval.ivml", 1);
    }
    
    /**
     * Tests compound eval (priority).
     */
    @Test
    public void compoundEval() {
        reasoningTest("CompoundEval.ivml", 0);
    }

}
