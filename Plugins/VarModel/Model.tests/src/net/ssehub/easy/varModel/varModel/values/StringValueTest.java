package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

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
