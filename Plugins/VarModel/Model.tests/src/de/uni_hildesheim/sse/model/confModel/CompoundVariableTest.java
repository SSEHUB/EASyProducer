package de.uni_hildesheim.sse.model.confModel;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Test class for {@link CompoundVariable}s.
 * @author El-Sharkawy
 *
 */
public class CompoundVariableTest {
    
    private static final String CMP2_NAME = "cmp2";
    private static final String CMP3_NAME = "cmp3";
    
    private Project project;
    private Configuration configuration;
    private DecisionVariableDeclaration cmp;
    private Compound cmpType1;
    private Compound cmpType2;
    private Compound cmpType3;
    private DecisionVariableDeclaration cmp1;
    
    /**
     * SetUp method: creates an empty project together with a configuration.
     */
    @Before
    public void setUp() {
        project = new Project("configurationTestProject");
        
        // Elements for simple compound tests
        Compound cmpType = new Compound("CP", project);
        project.add(cmpType);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, cmpType);
        cmpType.add(intA);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, cmpType);
        cmpType.add(intB);
        cmp = new DecisionVariableDeclaration("cmp", cmpType, project);
        project.add(cmp);
        
        // Elements needed for nested comound tests       
        // Top layer compound
        cmpType1 = new Compound("CP1", project);
        DecisionVariableDeclaration a1 = new DecisionVariableDeclaration("a1", IntegerType.TYPE, cmpType1);
        DecisionVariableDeclaration a2 = new DecisionVariableDeclaration("a2", IntegerType.TYPE, cmpType1);
        cmpType1.add(a1);
        cmpType1.add(a2);
        
        // Nested compound
        cmpType2 = new Compound("CP2", project);
        DecisionVariableDeclaration b = new DecisionVariableDeclaration("b", IntegerType.TYPE, cmpType2); 
        cmpType2.add(b);
        
        // Nested compound inside the nested compound
        cmpType3 = new Compound("CP3", project);
        DecisionVariableDeclaration c1 = new DecisionVariableDeclaration("c1", IntegerType.TYPE, cmpType2); 
        DecisionVariableDeclaration c2 = new DecisionVariableDeclaration("c2", IntegerType.TYPE, cmpType2);
        cmpType3.add(c1);
        cmpType3.add(c2);
        
        // Instantiate Compounds
        DecisionVariableDeclaration cmp3 = new DecisionVariableDeclaration(CMP3_NAME, cmpType3, cmpType2);
        cmpType2.add(cmp3);
        DecisionVariableDeclaration cmp2 = new DecisionVariableDeclaration(CMP2_NAME, cmpType2, cmpType1);
        cmpType1.add(cmp2);
        cmp1 = new DecisionVariableDeclaration("cmp1", cmpType1, project);
        project.add(cmp1);
        
        // Create configuration
        configuration = new Configuration(project);        
    }

    /**
     * Tests the setValue method of a {@link CompoundVariable}.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     * @throws ConfigurationException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     */
    @Test
    public void testSetValue() throws ValueDoesNotMatchTypeException, ConfigurationException {
        CompoundVariable cmpVar = (CompoundVariable) configuration.getDecision(cmp);
        Assert.assertFalse(cmpVar.getValue().isConfigured());
        
        // Set first integer
        Value val = ValueFactory.createValue(IntegerType.TYPE, "1");
        cmpVar.getNestedElement(0).setValue(val, AssignmentState.ASSIGNED);
        Assert.assertFalse(cmpVar.getValue().isConfigured());

        // Set second integer
        val = ValueFactory.createValue(IntegerType.TYPE, "2");
        cmpVar.getNestedElement(1).setValue(val, AssignmentState.ASSIGNED);
        Assert.assertTrue(cmpVar.getValue().isConfigured());
    }
    
    /**
     * Tests nested compounds and value assignment to the nested compounds including correct behavior of the
     * {@link IAssignmentState}'s.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     * @throws ConfigurationException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     */
    @Test
    public void testNestedCompounds() throws ValueDoesNotMatchTypeException, ConfigurationException {        
        // Test precondition
        IDecisionVariable cmp1Variable = configuration.getDecision(cmp1);
        IDecisionVariable cmp2Variable = cmp1Variable.getNestedElement(2);
        IDecisionVariable cmp3Variable = cmp2Variable.getNestedElement(1);
        Assert.assertEquals(CMP2_NAME, cmp2Variable.getDeclaration().getName());
        Assert.assertEquals(CMP3_NAME, cmp3Variable.getDeclaration().getName());
        Assert.assertNotNull(cmp1Variable.getValue());
        Assert.assertNotNull(cmp2Variable.getValue());
        Assert.assertNotNull(cmp3Variable.getValue());
        Assert.assertFalse(cmp1Variable.getValue().isConfigured());
        
        // Set value of nested nested compound
        Value cmp3Value = ValueFactory.createValue(cmpType3, new Object[] {"c1", "1"});
        cmp3Variable.setValue(cmp3Value, AssignmentState.ASSIGNED);
        
        // Test correct behavior (c1 has a value and cmp1, cmp2, and cmp3 are undefined)
        Assert.assertNotNull(cmp1Variable.getValue());
        Assert.assertNotNull(cmp2Variable.getValue());
        Assert.assertNotNull(cmp3Variable.getValue());
        Assert.assertEquals(AssignmentState.UNDEFINED, cmp1Variable.getState());
        Assert.assertEquals(AssignmentState.UNDEFINED, cmp2Variable.getState());
        Assert.assertEquals(AssignmentState.UNDEFINED, cmp3Variable.getState());
        
        // Set value of top-layer and nested nested compound
        cmp3Value = ValueFactory.createValue(cmpType3, new Object[] {"c2", "1"});
        cmp3Variable.setValue(cmp3Value, AssignmentState.ASSIGNED);
        Value cmp1Value = ValueFactory.createValue(cmpType1, new Object[] {"a1", "1", "a2", "1"});
        cmp1Variable.setValue(cmp1Value, AssignmentState.ASSIGNED);
        
        // Test correct behavior
        Assert.assertNotNull(cmp1Variable.getValue());
        Assert.assertNotNull(cmp2Variable.getValue());
        Assert.assertNotNull(cmp3Variable.getValue());
        Assert.assertEquals(AssignmentState.UNDEFINED, cmp1Variable.getState());
        Assert.assertEquals(AssignmentState.UNDEFINED, cmp2Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp3Variable.getState());
        Assert.assertFalse(cmp1Variable.getValue().isConfigured());
        
        // Set the last open value.
        Value cmp2Value = ValueFactory.createValue(cmpType2, new Object[] {"b", "1"});
        cmp2Variable.setValue(cmp2Value, AssignmentState.ASSIGNED);
        
        // Test correct behavior (cmp1 should be fully configured)
        Assert.assertNotNull(cmp1Variable.getValue());
        Assert.assertNotNull(cmp2Variable.getValue());
        Assert.assertNotNull(cmp3Variable.getValue());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp1Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp2Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp3Variable.getState());
        Assert.assertTrue(cmp1Variable.getValue().isConfigured());
    }

}
