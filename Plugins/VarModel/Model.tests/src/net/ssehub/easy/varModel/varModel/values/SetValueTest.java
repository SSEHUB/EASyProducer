package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * Test cases for a value of a set.
 * @author lueder
 * @author El-Sharkawy
 *
 */
public class SetValueTest {

    private Project pro;
    private Set set;
//    private DecisionVariableDeclaration int1;
//    private DecisionVariableDeclaration int2;
    
    /**
     * setUp for all tests.
     */
    @Before
    public void setUp() {
        pro = new Project("MyPro");
        set = new Set("MySet", IntegerType.TYPE, pro);
    }

    /**
     * Creates a set value and adds and edits sub values.
     * Also tests handling of duplicates.
     * @throws ValueDoesNotMatchTypeException 
     */
    @Test
    public void testBasicOperations() throws ValueDoesNotMatchTypeException {
        // Create empty set value
        ContainerValue setValue = (ContainerValue) ValueFactory.createValue(set, (Object[]) null);
        Assert.assertNotNull(setValue);
        Assert.assertEquals(0, setValue.getElementSize());
        Assert.assertTrue(setValue.isConfigured());
        
        // Add 2 elements
        ContainerValue nestedValues = (ContainerValue) ValueFactory.createValue(set, new Object[] {"1", "2"});
        setValue.setValue(nestedValues);
        Assert.assertNotNull(setValue);
        Assert.assertEquals(2, setValue.getElementSize());
        Assert.assertTrue(setValue.isConfigured());
        
        // Add 2 more elements including one duplicate
        nestedValues = (ContainerValue) ValueFactory.createValue(set, new Object[] {"2", "3"});
        try {
            setValue.setValue(nestedValues);
            Assert.fail("Same value was assigned twice to a set.");
        } catch (ValueDoesNotMatchTypeException e) {
            //This exception should occur
            Assert.assertEquals(ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE, e.getCode());
            nestedValues = (ContainerValue) ValueFactory.createValue(set, new Object[] {"3"});
            setValue.setValue(nestedValues);
            // No exception should occur here.
        }
        Assert.assertNotNull(setValue);
        Assert.assertEquals(3, setValue.getElementSize());
        Assert.assertTrue(setValue.isConfigured());
    }

    /**
     * Tests whether a {@link ContainerValue} can be created with passing an existing value to the constructor.
     * @throws ValueDoesNotMatchTypeException Must not occur.
     */
    @Test
    public void testValueCreationWithExistingValue() throws ValueDoesNotMatchTypeException {
        //Create an constant value
        IntValue intv = (IntValue) ValueFactory.createValue(IntegerType.TYPE, "4");
//        ConstantValue val = new ConstantValue(intv);
        
        //Create a container
        ContainerValue con = (ContainerValue) ValueFactory.createValue(set, intv);
        Assert.assertEquals(1, con.getElementSize());
    }
    
    /**
     * Tests the first ValueDoesNotMatchTypeException of the constructor.
     */
    @Test
    public void failCst() {
        ConstantValue val = null;
        StringValue strv = null;
        
        //Creating a string value
        try {
            strv = (StringValue) ValueFactory.createValue(StringType.TYPE, "fail");
            val = new ConstantValue(strv);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(); //Should not occur
        }
        
        //Create a ContainerValue of an integer set, filled with a string -> exc should occur
        try {
            ValueFactory.createValue(set, val);
            Assert.fail(); //Should not occur
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.assertTrue(true);
        }
    }
    
    /**
     * Test valid constructor call.
     * @throws ValueDoesNotMatchTypeException 
     */
    @Test
    public void initialValue() throws ValueDoesNotMatchTypeException {
        //Create a value
        IntValue intv = (IntValue) ValueFactory.createValue(IntegerType.TYPE, "5");
        
        //Create a container
        ContainerValue con = (ContainerValue) ValueFactory.createValue(set, intv);
        Assert.assertTrue(con.isFullyConfigured());
    }
    
    /**
     * Tests whether duplicates can be passed to the constructor of a set value.
     */
    @Test
    public void testDupplicatedValuesInConstructor() {
        try {
            ValueFactory.createValue(set, new Object[] {"1", "1"});
            Assert.fail("SetValue has value duplicates, but this is not allowed.");
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.assertEquals(ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE, e.getCode());
        }
    }
    
    /**
     * Tests the second ValueDoesNotMatchTypeException of the constructor.
     */
    @Test
    public void failValue() {
        
        StringValue strv = null;
        
        //Creating a string value
        try {
            strv = (StringValue) ValueFactory.createValue(StringType.TYPE, "fail");
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(); //Should not occur
        }
        
        //Create a ContainerValue of an integer set, filled with a string -> exc should occur
        try {
            ValueFactory.createValue(set, strv);
            Assert.fail(); //Should not occur
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.assertTrue(true);
        }
    }
}
