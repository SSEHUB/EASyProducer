package de.uni_hildesheim.sse.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.StringType;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * test case for the StringValue class.
 * @author beck
 *
 */
public class StringValueTest {


    private Project project;
    private DecisionVariableDeclaration strDec;
    private String str;
    private StringValue strV;
    
    /**
     * setUp for all tests.
     * @throws ValueDoesNotMatchTypeException should not occur
     */
    @Before
    public void setUp() throws ValueDoesNotMatchTypeException {
        project = new Project("Projekt");
        str = "String";
        strDec = new DecisionVariableDeclaration("String", StringType.TYPE, project);
        strV = (StringValue) ValueFactory.createValue(strDec.getType(), str);
    }
    
    /**
     * test to clone a stringValue.
     * @throws ValueDoesNotMatchTypeException should not occur
     */
    @Test
    public void cloneString() throws ValueDoesNotMatchTypeException {
        str = "Ersetzt";
        strV.setValue(str);
        Assert.assertEquals(str, strV.getValue());
        StringValue cloneStr = (StringValue) strV.clone();
        Assert.assertEquals(cloneStr.getValue(), strV.getValue());
        Assert.assertNotSame(cloneStr, strV);
    }

}
