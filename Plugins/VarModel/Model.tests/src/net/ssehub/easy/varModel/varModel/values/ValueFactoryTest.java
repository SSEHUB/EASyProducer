package net.ssehub.easy.varModel.varModel.values;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

/**
 * test cases to check the ValueFactory.
 * @author lueder
 *
 */
public class ValueFactoryTest {

    private Project project;
    
    /**
     * Creates a project, which is needed as toplevel element.
     */
    @Before
    public void setUp() {
        project = new Project("project");        
    }
    
    
    /**
     * tests the BasisDataTypes.
     * @throws ValueDoesNotMatchTypeException .
     */
    @Test
    public void basisDatatypeTest() throws ValueDoesNotMatchTypeException {
        
        //StringValue
        DecisionVariableDeclaration string = new DecisionVariableDeclaration("string", StringType.TYPE, project);
        StringValue strV = (StringValue) ValueFactory.createValue(string.getType(), "Hallo");
        Assert.assertTrue(strV.isConfigured());
        
        //IntValue
        DecisionVariableDeclaration integer = new DecisionVariableDeclaration("integer", IntegerType.TYPE, project);
        int intValue = 5;
        IntValue intV = (IntValue) ValueFactory.createValue(integer.getType(), intValue);
        Assert.assertTrue(intV.isConfigured());
        Assert.assertEquals(intValue, (int) intV.getValue());               
        
        //BoolVBalue
        DecisionVariableDeclaration booleanD = new DecisionVariableDeclaration("bool", BooleanType.TYPE, project);
        BooleanValue boolV = (BooleanValue) ValueFactory.createValue(booleanD.getType(), "true");
        Assert.assertTrue(boolV.isConfigured());
        
        //RealValue
        DecisionVariableDeclaration real = new DecisionVariableDeclaration("real", RealType.TYPE, project);
        RealValue realV = (RealValue) ValueFactory.createValue(real.getType(), "5.5");
        Assert.assertTrue(realV.isConfigured());        
        
        //RealValue initialized with a double instead of a string
        DecisionVariableDeclaration realOfDouble = new DecisionVariableDeclaration("real", RealType.TYPE, project);
        Double value = 5.5;
        RealValue realOfDoubleV = (RealValue) ValueFactory.createValue(realOfDouble.getType(), value);
        Assert.assertTrue(realOfDoubleV.isConfigured());
        Assert.assertEquals(value, realOfDoubleV.getValue());
                
    }
    
    /**
     * tests the CustomDataTypes.
     * @throws ValueDoesNotMatchTypeException .
     */
    @Test
    public void customDataTypes() throws ValueDoesNotMatchTypeException {
        
        //EnumValue
        Enum en = new Enum("enum", project, "Lit1", "Lit2");
        EnumValue enV = (EnumValue) ValueFactory.createValue(en, "Lit1", "a", "Lit2", "b");
        Assert.assertTrue(enV.isConfigured());
        
    }
}
