package net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class CollectionConstraintsTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected CollectionConstraintsTests(ITestDescriptor descriptor) {
        super(descriptor, "collectionConstraints");
    }

    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetDefaultTest() {
        reasoningTest("constraintSetDefault.ivml", 2);
    }

    /**
     * Tests constraints in set of set.
     */
    @Test
    public void constraintSetSetDefaultTest() {
        reasoningTest("constraintSetSetDefault.ivml", 2);
    }

    /**
     * Tests containers with derived types on compounds and constraints.
     */
    @Test
    public void constraintSetDerivedCompoundTest() {
        reasoningTest("constraintSetDerivedCompound.ivml", 2);
    }

    /**
     * Tests containers of containers with derived types on compounds and constraints.
     */
    @Test
    public void constraintSetSetDerivedCompoundTest() {
        reasoningTest("constraintSetSetDerivedCompound.ivml", 2);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetAssignedTest() {
        reasoningTest("constraintSetAssigned.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetDefaultInCompoundTest() {
        reasoningTest("constraintSetDefaultInCompound.ivml", 2);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInCompoundDefaultTest() {
        reasoningTest("constraintSetInCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInCompoundAssignedTest() {
        reasoningTest("constraintSetInCompoundAssigned.ivml", 1);
    }
  
    /**
     * Tests constraints in set.
     */
    @Test
    public void constraintSetInNestedCompoundDefaultTest() {
        reasoningTest("constraintSetInNestedCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests constraints in set.
     */
    @Test
    public void qmTest() {
        reasoningTest("QM.ivml", 1);
    }

    /**
     * Tests constraints in set.
     */
    @Test
    public void setDerivedSetTest() {
        reasoningTest("setDerivedSet.ivml", 3);
    }

    /**
     * Collection annotation test.
     */
    @Test
    public void containerAnnotationTest() {
        reasoningTest("ContainerAnnotationTest.ivml", 10);
    } 

    /**
     * Tests for derived and referenced collections.
     */
    @Test
    public void referenceDerivedCollectionTest() {
        reasoningTest("ReferenceDerivedCollectionTest.ivml", 5);
    }
    
}
