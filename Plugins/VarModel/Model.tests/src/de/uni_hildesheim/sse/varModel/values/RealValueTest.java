package de.uni_hildesheim.sse.varModel.values;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.RealType;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * test case to check the realValue-class.
 * 
 * @author beck
 *
 */
public class RealValueTest {

    private Project project;
    private DecisionVariableDeclaration realDec;
    private Double value;
    private RealValue realV;
    
    /**
     * setUp for all testCases.
     * @throws ValueDoesNotMatchTypeException should not occur
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        project = new Project("Projekt");
        realDec = new DecisionVariableDeclaration("real", RealType.TYPE, project);
        value = 5.5;
        realV = (RealValue) ValueFactory.createValue(realDec.getType(), value);
    }

    /**
     * Test case to clone a realValue.
     * @throws ValueDoesNotMatchTypeException should not occur
     */
    @Test
    public void cloneReal() throws ValueDoesNotMatchTypeException {
        Double newValue = 1.8;
        realV.setValue(newValue);
        Assert.assertEquals(newValue, realV.getValue());
        
        RealValue clonedValue = (RealValue) realV.clone();
        Assert.assertEquals(realV.getValue(), clonedValue.getValue());
        Assert.assertNotSame(realV, clonedValue);
    }
    
    /**
     * Try to use the setMethod with a wrong object or null.
     */
    @Test
    public void useWrongValue() {
        String stringV = "Must Fail";        
        try {
            realV.setValue(stringV);
            fail();
        } catch (ValueDoesNotMatchTypeException e) {
            //should occur. Used string in the setValue method.
        }
        
       //set realV to null
        try {
            realV.setValue(null);
        } catch (ValueDoesNotMatchTypeException e) {
            fail();
            //should not occur
        }
        
        Assert.assertEquals(null, realV.getValue());
    }

}
