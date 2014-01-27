package de.uni_hildesheim.sse.varModel.values;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;


/**
 * TestCase for the CompoundValue.
 * @author beck
 *
 */
public class CompoundValueTest {
    
    private Project project;
    private CompoundValue value;
    private Compound comp2;
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
        
        comp2 = new Compound("comp2", project);
        comp2.add(elem1);
        comp2.add(elem2);
        comp2.add(elem3);
        comp2.add(elem4);
        value2 = (CompoundValue) ValueFactory.createValue(comp2, "String", "ABC", 
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
}