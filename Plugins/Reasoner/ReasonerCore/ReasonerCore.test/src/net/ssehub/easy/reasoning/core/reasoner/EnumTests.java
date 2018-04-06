package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Configures the enum tests for SSE reasoner.
 * 
 * @author Eichelberger
 */
public class EnumTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected EnumTests(ITestDescriptor descriptor) {
        super(descriptor, "enums");
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
     * Enum defaults test.
     */
    @Test
    public void enumDefaultsTest() {
        reasoningTest("EnumDefaultsTest.ivml", 0);
    } 
    
    /**
     * Enum assign test.
     */
    @Test
    public void enumAssignTest() {
        reasoningTest("EnumAssignTest.ivml", 0);
    } 
    
    /**
     * Enum in compound defaults test.
     */
    @Test
    public void enumInCompoundDefaultsTest() {
        reasoningTest("EnumInCompoundDefaultsTest.ivml", 0);
    } 
    
    /**
     * Enum in compound assign test.
     */
    @Test
    public void enumInCompoundAssignTest() {
        reasoningTest("EnumInCompoundAssignTest.ivml", 0);
    } 

    
    
    /**
     * OrderedEnum defaults test.
     */
    @Test
    public void orderedEnumDefaultsTest() {
        reasoningTest("OrderedEnumDefaultsTest.ivml", 0);
    } 
    
    /**
     * OrderedEnum assign test.
     */
    @Test
    public void orderedEnumAssignTest() {
        reasoningTest("OrderedEnumAssignTest.ivml", 0);
    } 
    
    /**
     * OrderedEnum in compound defaults test.
     */
    @Test
    public void orderedEnumInCompoundDefaultsTest() {
        reasoningTest("OrderedEnumInCompoundDefaultsTest.ivml", 0);
    } 
    
    /**
     * OrderedEnum in compound assign test.
     */
    @Test
    public void orderedEnumInCompoundAssignTest() {
        reasoningTest("OrderedEnumInCompoundAssignTest.ivml", 0);
    } 

    /**
     * Enum in collection defaults test.
     */
    @Test
    public void enumInCollectionDefaultsTest() {
        reasoningTest("EnumInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * Enum in collection assign test.
     */
    @Test
    public void enumInCollectionAssignTest() {
        reasoningTest("EnumInCollectionAssignTest.ivml", 2);
    } 

    /**
     * Ordered enum in collection defaults test.
     */
    @Test
    public void orderedEnumInCollectionDefaultsTest() {
        reasoningTest("OrderedEnumInCollectionDefaultsTest.ivml", 2);
    } 
    
    /**
     * Ordered enum in collection assign test.
     */
    @Test
    public void orderedEnumInCollectionAssignTest() {
        reasoningTest("OrderedEnumInCollectionAssignTest.ivml", 2);
    } 

    /**
     * Enum reference assign test.
     */
    @Test
    public void enumReferenceAssignTest() {
        reasoningTest("EnumRefAssignTest.ivml", 2);
    } 

    /**
     * Ordered enum reference assign test.
     */
    @Test
    public void orderedEnumReferenceAssignTest() {
        reasoningTest("OrderedEnumRefAssignTest.ivml", 2);
    } 

    /**
     * Enum annotation test.
     */
    @Test
    public void enumAnnotationTest() {
        reasoningTest("EnumAnnotationTest.ivml", 10);
    } 

    /**
     * Ordered enum annotation test.
     */
    @Test
    public void orderdEnumAnnotationTest() {
        reasoningTest("OrderedEnumAnnotationTest.ivml", 10);
    } 

    /**
     * Combination of references and typedefs on enums.
     */
    @Test
    public void referenceDerivedEnumTest() {
        reasoningTest("ReferenceDerivedEnumTest.ivml", 3);
    } 

}
