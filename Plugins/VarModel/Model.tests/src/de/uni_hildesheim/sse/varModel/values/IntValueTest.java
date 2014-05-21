package de.uni_hildesheim.sse.varModel.values;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * test case to check the intValue-class.
 * @author beck
 *
 */
public class IntValueTest {

    private Project project;
    private DecisionVariableDeclaration intDec;
    private int integer;
    private IntValue intV;
    
    /**
     * setUp for all tests.
     * @throws ValueDoesNotMatchTypeException should not occur
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        project = new Project("Projekt");
        intDec = new DecisionVariableDeclaration("integer", IntegerType.TYPE, project);        
        integer = 5;
        intV = (IntValue) ValueFactory.createValue(intDec.getType(), integer);
    }
    
    /**
     * test to clone a intValue.
     */
    @Test
    public void cloneInt() {
        integer = 2;
        intV.setValue(integer);
        Assert.assertEquals(integer, (int) intV.getValue());
        IntValue cloneInt = (IntValue) intV.clone();
        Assert.assertEquals(cloneInt.getValue(), intV.getValue());
        Assert.assertNotSame(cloneInt, intV);
    }
    
    /**
     * Try to use the setMethod with a wrong object or null.
     */
    @Test
    public void useWrongValue() {
        String stringV = "Must Fail";        
        try {
            intV.setValue(stringV);
            fail();
        } catch (ValueDoesNotMatchTypeException e) {
            //should occur. Used string in the setValue method.
        }
        
        //set intV to null
        try {
            intV.setValue(null);
        } catch (ValueDoesNotMatchTypeException e) {
            fail();
            //should not occur
        }
        
        Assert.assertEquals(null, intV.getValue());
        
    }

}
