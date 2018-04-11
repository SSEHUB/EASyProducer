package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Test;

/**
 * Configures the compound tests for SSE reasoner.
 * 
 * @author Eichelberger
 */
public class CompoundTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected CompoundTests(ITestDescriptor descriptor) {
        super(descriptor, "compounds");
    }
    
    /**
     * Compound reference assign test for a basic type.
     */
    @Test
    public void compoundReferenceAssignTest1() {
        reasoningTest("CompoundRefAssignTest1.ivml", 2);
    } 

    /**
     * Compound reference assign test for a compound type.
     */
    @Test
    public void compoundReferenceAssignTest2() {
        reasoningTest("CompoundRefAssignTest2.ivml", 2);
    } 

    /**
     * Compound reference assign test for a compound type.
     */
    @Test
    public void compoundReferenceAssignTest3() {
        reasoningTest("CompoundRefAssignTest3.ivml", 2);
    } 

    /**
     * Compound constraint test for a compound type/instances.
     */
    @Test
    public void compoundConstraintTest() {
        reasoningTest("CompoundConstraintTest.ivml", 2);
    } 

    /**
     * Compound constraint test for nested compound type/instances.
     */
    @Test
    public void compoundCompoundTest1() {
        reasoningTest("CompoundCompoundTest1.ivml", 2);
    } 

    /**
     * Compound constraint test for nested recursive compound type/instances.
     */
    @Test
    public void compoundCompoundTest2() {
        reasoningTest("CompoundCompoundTest2.ivml", 2);
    } 

    /**
     * Compound constraint test for nested containers.
     */
    @Test
    public void compoundContainerTest1() {
        reasoningTest("CompoundContainerTest1.ivml", 2);
    } 

    /**
     * Compound constraint test for recursive nested containers.
     */
    @Test
    public void compoundContainerTest2() {
        reasoningTest("CompoundContainerTest2.ivml", 3);
    } 

    /**
     * Compound annotation test.
     */
    @Test
    public void compoundAnnotationTest() {
        reasoningTest("CompoundAnnotationTest.ivml", 10);
    } 

    /**
     * Derived compound annotation test.
     */
    @Test
    public void derivedCompoundAnnotationTest() {
        reasoningTest("DerivedCompoundAnnotationTest.ivml", 10);
    } 

    /**
     * Referenced compound annotation test.
     */
    @Test
    public void referenceCompoundAnnotationTest() {
        reasoningTest("ReferenceCompoundAnnotationTest.ivml", 10);
    }
    
    /**
     * Tests referenced-derived compounds (testing chains of types).
     */
    @Test
    public void referenceDerivedCompoundTest() {
        reasoningTest("ReferenceDerivedCompoundTest.ivml", 5);
    }

}
