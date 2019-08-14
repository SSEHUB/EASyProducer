package test.net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

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
     * Changes an annotation value before freezing. Respective slot shall not be frozen.
     * 
     * @throws ModelQueryException shall not occur
     */
    @Test    
    public void compoundAnnotationChange() throws ModelQueryException {
        Configuration cfg = reasoningTest("CompoundAnnotationChange.ivml", 0);
        
        AbstractVariable c = ModelQuery.findVariable(cfg.getProject(), "c", null);
        IDecisionVariable cVar = cfg.getDecision(c);
        Assert.assertEquals(AssignmentState.FROZEN, cVar.getNestedElement("description").getState());
        Assert.assertEquals(AssignmentState.DEFAULT, cVar.getNestedElement("name").getState());
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
        // initial: just the triple nested shall be a reassignment
        // recognize potential multiple assignments and ignore them
        reasoningTest("NestedAssignBlockTree.ivml", 0); 
    }    

    /**
     * Assign attribute in nested manner across compounds.
     */
    @Test    
    public void nestedAssignBlock2() {
        reasoningTest("NestedAssignBlock2.ivml", 0); 
    }    

    /**
     * Constraint annotations.
     */
    @Test    
    public void constraintAnnotationTest() {
        reasoningTest("ConstraintAnnotationTest.ivml", 9);
    }    

}
