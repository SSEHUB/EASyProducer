package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
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
     * Tests simple eval (priority).
     */
    @Test
    public void simpleEval() {
        reasoningTest("SimpleEval.ivml", 0);
    }
    
    /**
     * Tests nested eval.
     */
    @Ignore
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
