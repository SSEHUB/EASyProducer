package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Defines the boolean tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 * @author Eichelberger
 */
public class BooleanTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected BooleanTests(ITestDescriptor descriptor) {
        super(descriptor, "boolean");
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
     * Car example.
     */
    @Test
    public void carExampleTest() {
        reasoningTest("CarExample.ivml", 1);
    }
    
    /**
     * Boolean defaults test.
     */
    @Test
    public void booleanDefaultsTest() {
        reasoningTest("BooleanDefaultsTest.ivml", 2);
    } 
    
    /**
     * Boolean assign test.
     */
    @Test
    public void booleanAssignTest() {
        reasoningTest("BooleanAssignTest.ivml", 2);
    } 
    
    /**
     * Boolean in compound defaults test.
     */
    @Test
    public void booleanInCompoundDefaultsTest() {
        reasoningTest("BooleanInCompoundDefaultsTest.ivml", 2);
    } 
    
    /**
     * Boolean in compound assign test.
     */
    @Test
    public void booleanInCompoundAssignTest() {
        reasoningTest("BooleanInCompoundAssignTest.ivml", 2);
    } 
    
    /**
     * Boolean implies test.
     */
    @Test
    public void booleanImpliesTest() {
        reasoningTest("BooleanImpliesTest.ivml", 1);
    } 
    
    /**
     * Boolean in compound implies test.
     */
    @Test
    public void booleanInCompoundImpliesTest() {
        reasoningTest("BooleanInCompoundImpliesTest.ivml", 1);
    }

    /**
     * Boolean in collection defaults test.
     */
    @Test
    public void booleanInCollectionDefaultsTest() {
        reasoningTest("BooleanInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * Boolean in collection assign test.
     */
    @Test
    public void booleanInCollectionAssignTest() {
        reasoningTest("BooleanInCollectionAssignTest.ivml", 2);
    } 

    /**
     * Boolean reference assign test.
     */
    @Test
    public void booleanReferenceAssignTest() {
        reasoningTest("BooleanRefAssignTest.ivml", 2);
    } 

    /**
     * Boolean annotation test.
     */
    @Test
    public void booleanAnnotationTest() {
        reasoningTest("BooleanAnnotationTest.ivml", 9);
    } 
    
}
