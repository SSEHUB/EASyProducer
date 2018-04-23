package net.ssehub.easy.reasoning.core.capabilities;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.varModel.model.Project;

/**
 * Collection constraints tests.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class ConstraintVariableTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected ConstraintVariableTests(ITestDescriptor descriptor) {
        super(descriptor, "constraintVariables");
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsInCompoundWithDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithDefaultValue.ivml", 2);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsInCompoundWithNoDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithNoDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsInCompoundWithEmptyDefaultValue() {
        reasoningTest("setOfConstraintsInCompoundWithEmptyDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsWithDefaultValue() {
        reasoningTest("setOfConstraintsWithDefaultValue.ivml", 2);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsWithNoDefaultValue() {
        reasoningTest("setOfConstraintsWithNoDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void setOfConstraintsWithEmptyDefaultValue() {
        reasoningTest("setOfConstraintsWithEmptyDefaultValue.ivml", 2);
    }
    
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintDefaultTest() {
        reasoningTest("constraintDefault.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintAssignedTest() {
        reasoningTest("constraintAssigned.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintInCompoundDefaultTest() {
        reasoningTest("constraintInCompoundDefault.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintsInCompoundWithNoDefaultValue() {
        reasoningTest("constraintsInCompoundWithNoDefaultValue.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void constraintInCompoundAssignedTest() {
        reasoningTest("constraintInCompoundAssigned.ivml", 1);
    }
    
    /**
     * Tests false constraint.
     */
    @Test
    public void falseTest() {
        reasoningTest("falseTest.ivml", 1);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanAssignedFalse() {
        reasoningTest("booleanAssignedFalse.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanDefaultFalse() {
        reasoningTest("booleanDefaultFalse.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanAssignedFalseInCompound() {
        reasoningTest("booleanAssignedFalseInCompound.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void booleanDefaultFalseInCompound() {
        reasoningTest("booleanDefaultFalseInCompound.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanInCompoundWithDefaultValue() {
        reasoningTest("setOfBooleanInCompoundWithDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanInCompoundWithNoDefaultValue() {
        reasoningTest("setOfBooleanInCompoundWithNoDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanWithDefaultValue() {
        reasoningTest("setOfBooleanWithDefaultValue.ivml", 0);
    }
    
    /**
     * Tests boolean variable with value false.
     */
    @Test
    public void setOfBooleanWithNoDefaultValue() {
        reasoningTest("setOfBooleanWithNoDefaultValue.ivml", 0);
    }
    
    /**
     * Tests constraint variable order influence (QM project case).
     */
    @Test
    public void compoundConstraintVarOrder() {
        reasoningTest("QM_constraintOrder.ivml", 0);
    }
    
    /**
     * Tests derived constraint variables.
     */
    @Test
    public void constraintsDerivedTest() {
        reasoningTest("constraintsDerived.ivml", 4);
    }

    /**
     * Tests changing constraint variables.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void changingConstraintsTest() throws IOException {
        // basis shall be failing with four tests
       // reasoningTest("changingConstraints/changingConstraintsBase.ivml", 4);
        // importing model changes constraints, shall not fail then 
        Project prj = loadCompleteProject("changingConstraints", "changingConstraints");
        resultHandler(0, 0, prj);
    }

}
