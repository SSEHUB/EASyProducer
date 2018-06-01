package net.ssehub.easy.reasoning.core.capabilities;

import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;

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
        reasoningTest("constraintSetDefault.ivml", 1);
    }

    /**
     * Tests constraints in set of set.
     */
    @Test
    public void constraintSetSetDefaultTest() {
        reasoningTest("constraintSetSetDefault.ivml", 1);
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
        reasoningTest("constraintSetDefaultInCompound.ivml", 1);
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
    
    /**
     * String collections test (#72).
     */
    @Test
    public void stringCollection1Test() {
        reasoningTest("StringTest1.ivml", 1);
    }

    /**
     * String collections test (#72).
     */
    @Test
    public void stringCollection2Test() {
        reasoningTest("StringTest2.ivml", 0);
    }

    /**
     * String collections test (#72).
     * 
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void stringCollection3Test() throws ModelQueryException {
        Configuration cfg = reasoningTest("StringTest3.ivml", 0);

        AbstractVariable orgVarsDecl = ModelQuery.findVariable(cfg.getProject(), "orgVars", null);
        Assert.assertNotNull(orgVarsDecl);
        IDecisionVariable orgVars = cfg.getDecision(orgVarsDecl);
        Assert.assertNotNull(orgVars);
        assertContained(orgVars.getState(), AssignmentState.ASSIGNED, AssignmentState.DERIVED);
        Value val = orgVars.getValue();
        Assert.assertTrue(val instanceof ContainerValue);
        ContainerValue cVal = (ContainerValue) val;
        Assert.assertTrue(cVal.getElementSize() > 0);
    }

    /**
     * String collections test (#74).
     * 
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void stringCollection4Test() throws ModelQueryException {
        Configuration cfg = reasoningTest("StringTest4.ivml", 0);

        AbstractVariable orgVarsDecl = ModelQuery.findVariable(cfg.getProject(), "set2", null);
        Assert.assertNotNull(orgVarsDecl);
        IDecisionVariable orgVars = cfg.getDecision(orgVarsDecl);
        Assert.assertNotNull(orgVars);
        assertContained(orgVars.getState(), AssignmentState.DEFAULT);
        Value val = orgVars.getValue();
        Assert.assertTrue(val instanceof ContainerValue);
        ContainerValue cVal = (ContainerValue) val;
        Assert.assertTrue(cVal.getElementSize() > 0);
    }
    
}
