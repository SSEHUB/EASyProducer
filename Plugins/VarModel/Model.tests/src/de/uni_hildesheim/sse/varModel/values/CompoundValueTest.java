package de.uni_hildesheim.sse.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.validation.IvmlValidationVisitor;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;


/**
 * TestCase for the CompoundValue.
 * @author beck
 * @author El-Sharkawy
 *
 */
public class CompoundValueTest {
    
    private Project project;
    private CompoundValue value;
    private CompoundValue value2;
    /**
     * Creates a project, which is needed as toplevel element.
     * @throws ValueDoesNotMatchTypeException 
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        project = new Project("project");        
        Compound comp1 = new Compound("comp1", project);
        DecisionVariableDeclaration elem1 = new DecisionVariableDeclaration("String", StringType.TYPE, comp1);
        DecisionVariableDeclaration elem2 = new DecisionVariableDeclaration("Int", IntegerType.TYPE, comp1);
        DecisionVariableDeclaration elem3 = new DecisionVariableDeclaration("Real", RealType.TYPE, comp1);
        DecisionVariableDeclaration elem4 = new DecisionVariableDeclaration("Bool", BooleanType.TYPE, comp1);
        comp1.add(elem1);
        comp1.add(elem2);
        comp1.add(elem3);
        comp1.add(elem4);
        value = (CompoundValue) ValueFactory.createValue(comp1, "String", null, 
                "Int", null, "Real", null, "Bool", null);
        
        value2 = (CompoundValue) ValueFactory.createValue(comp1, "String", "ABC", 
                "Int", "5", "Real", "5.5", "Bool", "true");
    }

    /**
     * FullyConfigured-test.
     * @throws ClassCastException .
     * @throws ValueDoesNotMatchTypeException .
     */
    @Test
    public void fullyConf() throws ValueDoesNotMatchTypeException, ClassCastException {
        
        Assert.assertTrue(value2.isFullyConfigured());
        
        //Compound value should not be configured
        Assert.assertFalse(value.isFullyConfigured());
        
        //Compound value should be configured
        value.configureValue("Int", "1");
        value.configureValue("Real", "1.1");
        value.configureValue("String", "Mett");
        value.configureValue("Bool", "true");
        
        Assert.assertTrue(value.isFullyConfigured());
    }
    
    /**
     * Tests whether cloning succeeds.
     */
    @Test
    public void clonetest() {
        //Normal test
        CompoundValue clone = (CompoundValue) value.clone();
        Assert.assertNotSame(clone, value);
        Assert.assertEquals(value.getNestedValue("String"), clone.getNestedValue("String"));
        //TODO: Fails because value = null <-> hashCode()
        Assert.assertEquals(value.getNestedValue("Int"), clone.getNestedValue("Int"));
        Assert.assertEquals(value.getNestedValue("Real"), clone.getNestedValue("Real"));
        Assert.assertEquals(value.getNestedValue("Bool"), clone.getNestedValue("Bool"));
        
        //Exc. Test
        
    }
    
    /**
     * SetValue test.
     */
    @Test
    public void setValue() {
        //setValue with value2
        Assert.assertFalse(value.isFullyConfigured());
        try {
            value.setValue(value2);
            Assert.assertTrue(value.isFullyConfigured());
        } catch (ValueDoesNotMatchTypeException e1) {
            // should not occur
            Assert.fail();
        }
        
        //value = null
        try {
            value.setValue(null);
            Assert.assertNull(value.getNestedValue("String"));
            Assert.assertNull(value.getNestedValue("Real"));
            Assert.assertNull(value.getNestedValue("Int"));
            Assert.assertNull(value.getNestedValue("Bool"));
        } catch (ValueDoesNotMatchTypeException e) {
            // should not occur
            Assert.fail();
        }
        
        //value != null && != CompoundValue -> Exc should occur
        try {
            value.setValue(new DecisionVariableDeclaration("name", StringType.TYPE, project));
            Assert.fail();
        } catch (ValueDoesNotMatchTypeException e) {
            // Should occur because it is not implementet yet
            Assert.assertEquals(e.getMessage(), "value '<not implemented>' does not match type 'comp1'");
        }
    }
    
    /**
     * Tests the correct creation of values for refined (inherited) compounds.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     *     {@link ValueFactory}.
     */
    @Test
    public void setRefinedValue() throws ValueDoesNotMatchTypeException {
        String slot1Name = "slot1";
        String slot2Name = "slot2";
        Integer value4Slot1 = 1;
        Integer value4Slot2 = 2;
        // Create Project for testing
        Project project = new Project("A_Project");
        Compound basisType = new Compound("basisType", project);
        DecisionVariableDeclaration slot1 = new DecisionVariableDeclaration(slot1Name, IntegerType.TYPE, basisType);
        basisType.add(slot1);
        project.add(basisType);
        Compound refinedType = new Compound("refinedType", project, basisType);
        DecisionVariableDeclaration slot2 = new DecisionVariableDeclaration(slot2Name, IntegerType.TYPE, refinedType);
        refinedType.add(slot2);
        project.add(refinedType);
        IvmlValidationVisitor visitor = new IvmlValidationVisitor();
        Assert.assertTrue("Error: Created project has errors.", visitor.getErrorCount() == 0);
        
        // Create a value for the refined compound (both slots must be supported)
        Object[] oValue = {slot1Name, value4Slot1, slot2Name, value4Slot2};
        CompoundValue value = (CompoundValue) ValueFactory.createValue(refinedType, oValue);
        
        // Test correct creation of value for refined compound
        Assert.assertNotNull(value);
        Value slot1Value = value.getNestedValue(slot1Name);
        Value slot2Value = value.getNestedValue(slot2Name);
        Assert.assertNotNull("Error: 1st slot is missing.", slot1Value);
        Assert.assertNotNull("Error: 2nd slot is missing.", slot2Value);
        Assert.assertEquals("Error: 1st slot value is wrong.", value4Slot1, slot1Value.getValue());
        Assert.assertEquals("Error: 2nd slot value is wrong.", value4Slot2, slot2Value.getValue());
    }
    
    /**
     * Tests whether copyValuesFrom of values for refined (inherited) compounds works.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     *     {@link ValueFactory}.
     */
    @Test
    public void setRefinedValueCopy() throws ValueDoesNotMatchTypeException {
        String slot1Name = "slot1";
        String slot2Name = "slot2";
        Integer value4Slot1 = 1;
        Integer value4Slot2 = 2;
        // Create Project for testing
        Project project = new Project("A_Project");
        Compound basisType = new Compound("basisType", project);
        DecisionVariableDeclaration slot1 = new DecisionVariableDeclaration(slot1Name, IntegerType.TYPE, basisType);
        basisType.add(slot1);
        project.add(basisType);
        Compound refinedType = new Compound("refinedType", project, basisType);
        DecisionVariableDeclaration slot2 = new DecisionVariableDeclaration(slot2Name, IntegerType.TYPE, refinedType);
        refinedType.add(slot2);
        project.add(refinedType);
        IvmlValidationVisitor visitor = new IvmlValidationVisitor();
        Assert.assertTrue("Error: Created project has errors.", visitor.getErrorCount() == 0);
        
        // Create a value for the refined compound (both slots should be empty)
        Object[] oValue = {slot1Name, null, slot2Name, null};
        CompoundValue value = (CompoundValue) ValueFactory.createValue(refinedType, oValue);
        
        // Test correct creation of empty value for refined compound
        Assert.assertNotNull(value);
        Value slot1Value = value.getNestedValue(slot1Name);
        Value slot2Value = value.getNestedValue(slot2Name);
        Assert.assertNull("Error: 1st slot is configured, but must not.", slot1Value);
        Assert.assertNull("Error: 2nd slot is configured, but must not.", slot2Value);
        
        // Create second value and copy values from new value to old value
        Object[] oValue2 = {slot1Name, value4Slot1, slot2Name, value4Slot2};
        CompoundValue value2 = (CompoundValue) ValueFactory.createValue(refinedType, oValue2);
        slot1Value = value.getNestedValue(slot1Name);
        slot2Value = value.getNestedValue(slot2Name);
        Assert.assertNull("Error: 1st slot is configured, but must not.", slot1Value);
        Assert.assertNull("Error: 2nd slot is configured, but must not.", slot2Value);
        Value slot1Value2 = value2.getNestedValue(slot1Name);
        Value slot2Value2 = value2.getNestedValue(slot2Name);
        Assert.assertNotNull("Error: 1st slot is not configured.", slot1Value2);
        Assert.assertNotNull("Error: 2nd slot is not configured.", slot2Value2);
        // Copy values
        value.copyValuesFrom(value2);
        slot1Value = value.getNestedValue(slot1Name);
        slot2Value = value.getNestedValue(slot2Name);
        
        // Test: both values should have the same value
        Assert.assertNotNull("Error: 1st slot is not configured.", slot1Value);
        Assert.assertNotNull("Error: 2nd slot is not configured.", slot2Value);
        Assert.assertNotNull("Error: 1st slot is not configured.", slot1Value2);
        Assert.assertNotNull("Error: 2nd slot is not configured.", slot2Value2);      
        Assert.assertEquals("Error: 1st slot value is wrong.", slot1Value, slot1Value2);
        Assert.assertEquals("Error: 1st slot value is wrong.", slot2Value, slot2Value2);
        Assert.assertNotSame(value, value2);
    }
}