package net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Attribute tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class AttributeTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected AttributeTests(ITestDescriptor descriptor) {
        super(descriptor, "attributes");
    }
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void defaultAssign() {
        reasoningTest("DefaultAssign.ivml", 0);
    }
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void blockAssign() {
        reasoningTest("BlockAssign.ivml", 0);
    }
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void individualAssign() {
        reasoningTest("IndividualAssign.ivml", 0);
    }

    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void blockAssignNested() {
        reasoningTest("BlockAssignNested.ivml", 0);
    }
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void blockAssignNestedNested() {
        reasoningTest("BlockAssignNestedNested.ivml", 0);
    }
    
    /**
     * Assign attribute with a default value to the project test. Test includes a 
     * constraint in the attribute assignment.
     */
    @Test    
    public void blockAssignNestedConstraint() {
        reasoningTest("BlockAssignNestedConstraint.ivml", 0);
    }

    /**
     * Assign attribute with cross-references and self within a compound. Test includes a 
     * constraint in the attribute assignment.
     */
    @Test    
    public void compoundIndividualAssign() {
        reasoningTest("CompoundIndividualAssign.ivml", 0);
    }

    /**
     * Assign attribute with a default value to the project test. Test includes a 
     * failing constraint in the attribute assignment.
     */
    @Test    
    public void blockAssignNestedConstraintFail() {
        reasoningTest("BlockAssignNestedConstraintFail.ivml", 1);
    }
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void individualAssignNested() {
        reasoningTest("IndividualAssignNested.ivml", 0);
    } 
    
    /**
     * Assign attribute with a default value to the project test.
     */
    @Test    
    public void nestedAssignBlockTree() {
        reasoningTest("NestedAssignBlockTree.ivml", 1); // just the triple nested shall be a reassignment
    }    

    /**
     * Constraint annotations.
     */
    @Test    
    public void constraintAnnotationTest() {
        reasoningTest("ConstraintAnnotationTest.ivml", 1); // pathological case
    }    

}
