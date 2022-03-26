package test.net.ssehub.easy.reasoning.core.reasoner;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Configures the compound tests for reasoners.
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
    public void compoundReferenceAssignTest2Fail() {
        reasoningTest("CompoundRefAssignTest2.ivml", 2); // re-assign
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
     * Compound constraint test for recursive nested containers.
     * 
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void compoundContainerTest3() throws ModelQueryException {
        Configuration cfg = reasoningTest("CompoundContainerTest3.ivml", 0);
        IDecisionVariable rec = cfg.getDecision("rec", false);
        Assert.assertNotNull(rec);
        IDecisionVariable fields = rec.getNestedElement("fields");
        Assert.assertNotNull(fields);
        Assert.assertEquals(2, fields.getNestedElementsCount());
        assertField(fields.getNestedElement(0), "field1", "", 1);
        assertField(fields.getNestedElement(1), "field2", "desc", 2);
    } 

    /**
     * Asserts slots of a "Field".
     * 
     * @param field the field (variable)
     * @param name the expected name
     * @param description the expected description
     * @param cacheTime the expected caching time
     */
    private static void assertField(IDecisionVariable field, String name, String description, int cacheTime) {
        Assert.assertNotNull(field);
        IDecisionVariable nameSlot = field.getNestedElement("name");
        Assert.assertNotNull(nameSlot);
        Value v = nameSlot.getValue();
        Assert.assertNotNull(v);
        Object value = v.getValue();
        Assert.assertNotNull(value);
        Assert.assertEquals(name, value);

        IDecisionVariable descSlot = field.getNestedElement("description");
        Assert.assertNotNull(descSlot);
        v = descSlot.getValue();
        Assert.assertNotNull(v);
        value = v.getValue();
        Assert.assertNotNull(value);
        Assert.assertEquals(description, value);

        IDecisionVariable cacheTimeSlot = field.getNestedElement("cacheTime");
        Assert.assertNotNull(cacheTimeSlot);
        v = cacheTimeSlot.getValue();
        Assert.assertNotNull(v);
        value = v.getValue();
        Assert.assertNotNull(value);
        Assert.assertEquals(cacheTime, value);
    }

    /**
     * Compound annotation test.
     */
    @Test
    public void compoundAnnotationTest() {
        reasoningTest("CompoundAnnotationTest.ivml", 9);
    } 

    /**
     * Derived compound annotation test.
     */
    @Test
    public void derivedCompoundAnnotationTest() {
        reasoningTest("DerivedCompoundAnnotationTest.ivml", 9);
    } 

    /**
     * Referenced compound annotation test.
     */
    @Test
    public void referenceCompoundAnnotationTest() {
        reasoningTest("ReferenceCompoundAnnotationTest.ivml", 9);
    }
    
    /**
     * Tests referenced-derived compounds (testing chains of types).
     */
    @Test
    public void referenceDerivedCompoundTest() {
        reasoningTest("ReferenceDerivedCompoundTest.ivml", 5);
    }

    /**
     * Tests changing constraint variables.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void changingValuesTest() throws IOException {
        // basis shall be failing with four tests
        reasoningTest("changingValues/changingValuesBase.ivml", 3);
        // importing model changes constraints, shall not fail then 
        Project prj = loadCompleteProject("changingValues", "changingValues");
        resultHandler(0, 0, prj);
    }

    /**
     * Additional compound annotation test on combining nested compounds with an assignment block (QM).
     */
    @Test
    public void compoundAnnotationTest2() {
        reasoningTest("CompoundAnnotationTest2.ivml", 0);
    } 

    /**
     * Tests a slot reassignment.
     * 
     * @throws IOException shall not occur
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void slotReassignmentTest() throws IOException, ModelQueryException {
        Project prj = loadCompleteProject("slotReassignment", "Cfg");
        Configuration cfg = resultHandler(0, 0, prj);
 
        IDecisionVariable compoundVar = cfg.getDecision("c", false);
        Assert.assertNotNull(compoundVar);
        IDecisionVariable paramsVar = compoundVar.getNestedElement("params");
        Assert.assertNotNull(paramsVar);
        Value val = paramsVar.getValue();
        Assert.assertTrue(val instanceof ContainerValue);
        ContainerValue cVal = (ContainerValue) val;
        Assert.assertTrue(cVal.getElementSize() > 0);
    }

    /**
     * Tests shadowing a slot while keeping its constraints.
     */
    @Test
    public void compoundShadowingTest() {
        reasoningTest("CompoundShadowTest.ivml", 2);
    } 

    /**
     * Closure test [contributed by Ke Liu].
     * 
     * @throws ModelQueryException in case that a model query fails
     */
    @Test
    public void closureTest() throws ModelQueryException {
        Configuration cfg = reasoningTest("PL_Test_Closure.ivml", 0);
        IDecisionVariable closure = cfg.getDecision("is_closure", false);
        Assert.assertTrue(closure.getValue() instanceof ContainerValue);
        ContainerValue closureValue = (ContainerValue) closure.getValue();
        Assert.assertEquals(3, closureValue.getElementSize());
        IDecisionVariable isAc = cfg.getDecision("is_Ac", false);
        Assert.assertEquals(BooleanValue.FALSE, isAc.getValue());
    }     

    /**
     * Closure test [contributed by Ke Liu].
     * 
     * @throws ModelQueryException in case that a model query fails
     */
    @Test
    public void closureTest2() throws ModelQueryException {
        Configuration cfg = reasoningTest("PL_Test_Closure2.ivml", 0);
        IDecisionVariable closure = cfg.getDecision("is_closure", false);
        Assert.assertTrue(closure.getValue() instanceof ContainerValue);
        ContainerValue closureValue = (ContainerValue) closure.getValue();
        Assert.assertEquals(5, closureValue.getElementSize());
        IDecisionVariable isAc = cfg.getDecision("is_Ac", false);
        Assert.assertEquals(BooleanValue.FALSE, isAc.getValue());
    }     

    /**
     * Staged compound initialization test with isDefined [contributed by IIP-Ecosphere].
     */
    @Test
    public void compoundInit1Test() {
        reasoningTest("CompoundInit1.ivml", 0);
    } 

    /**
     * Staged compound initialization test missing the variable initialization with !isDefined 
     * [contributed by IIP-Ecosphere].
     */
    @Test
    public void compoundInit2Test() {
        reasoningTest("CompoundInit2.ivml", 0);
    } 

    /**
     * Assignment-based compound initialization with isDefined [contributed by IIP-Ecosphere].
     */
    @Test
    public void compoundInit3Test() {
        reasoningTest("CompoundInit3.ivml", 0);
    } 

    /**
     * Assignment-based compound initialization with isDefined [contributed by IIP-Ecosphere].
     * 
     * @throws ModelQueryException shall not occur
     */
    @Test
    public void compoundInit4Test() throws ModelQueryException {
        Configuration cfg = reasoningTest("CompoundInit4.ivml", 0);
        IDecisionVariable var = cfg.getDecision("mgr", false);
        Assert.assertNotNull(var);
        Assert.assertNotNull(var.getValue());
        Assert.assertEquals("DockerContainerMgr", var.getValue().getType().getName());
    } 

}
