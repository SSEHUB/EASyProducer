/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.model.confModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.cstEvaluation.EvaluationVisitor;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

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
    // Simple Compound
    private Compound cmpType;
    // Multiple nested compounds
    private Compound cmpType1;
    private Compound cmpType2;
    private Compound cmpType3;
    private DecisionVariableDeclaration cmp1;
    private Constraint constraint;
    
    /**
     * SetUp method: creates an empty project together with a configuration.
     */
    @Before
    public void setUp() {
        project = new Project("configurationTestProject");
        
        // Elements for simple compound tests
        cmpType = new Compound("CP", project);
        project.add(cmpType);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, cmpType);
        cmpType.add(intA);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, cmpType);
        cmpType.add(intB);
        cmp = new DecisionVariableDeclaration("cmp", cmpType, project);
        project.add(cmp);
        
        // Elements needed for nested compound tests       
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
        DecisionVariableDeclaration c1 = new DecisionVariableDeclaration("c1", IntegerType.TYPE, cmpType3); 
        DecisionVariableDeclaration c2 = new DecisionVariableDeclaration("c2", IntegerType.TYPE, cmpType3);
        cmpType3.add(c1);
        cmpType3.add(c2);
        
        // Instantiate Compounds
        DecisionVariableDeclaration cmp3 = new DecisionVariableDeclaration(CMP3_NAME, cmpType3, cmpType2);
        cmpType2.add(cmp3);
        DecisionVariableDeclaration cmp2 = new DecisionVariableDeclaration(CMP2_NAME, cmpType2, cmpType1);
        cmpType1.add(cmp2);
        project.add(cmpType1);
        project.add(cmpType2);
        project.add(cmpType3);
        cmp1 = new DecisionVariableDeclaration("cmp1", cmpType1, project);
        project.add(cmp1);
        
        // A constraint for the CP compound
        constraint = new Constraint(project);
        CompoundAccess slotAccess = new CompoundAccess(new Variable(cmp), intA.getName());
        try {
            ConstantValue constVal = new ConstantValue(ValueFactory.createValue(intA.getType(), 2));
            OCLFeatureCall equality = new OCLFeatureCall(slotAccess, OclKeyWords.EQUALS, constVal);
            constraint.setConsSyntax(equality);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        project.add(constraint);
        
        ProjectTestUtilities.validateProject(project, true);
        
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
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp1Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp2Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp3Variable.getState());
        
        // Set value of top-layer and nested nested compound
        cmp3Value = ValueFactory.createValue(cmpType3, new Object[] {"c2", "1"});
        cmp3Variable.setValue(cmp3Value, AssignmentState.ASSIGNED);
        Value cmp1Value = ValueFactory.createValue(cmpType1, new Object[] {"a1", "1", "a2", "1"});
        cmp1Variable.setValue(cmp1Value, AssignmentState.ASSIGNED);
        
        // Test correct behavior
        Assert.assertNotNull(cmp1Variable.getValue());
        Assert.assertNotNull(cmp2Variable.getValue());
        Assert.assertNotNull(cmp3Variable.getValue());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp1Variable.getState());
        Assert.assertEquals(AssignmentState.ASSIGNED, cmp2Variable.getState());
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

    
    /**
     * Tests whether {@link CompoundVariable} can handle {@link NullValue}s.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     * @throws ConfigurationException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     */
    @Test
    public void testNullValues() throws ValueDoesNotMatchTypeException, ConfigurationException {
        CompoundVariable cmpVar = (CompoundVariable) configuration.getDecision(cmp);
        Assert.assertFalse(cmpVar.getValue().isConfigured());
        
        // Set first integer
        cmpVar.setValue(NullValue.INSTANCE, AssignmentState.ASSIGNED);
        EvaluationVisitor evalVisitor = new EvaluationVisitor(configuration, null, false, null);
        
        // Must not throw a (ClassCast-)Exception
        constraint.getConsSyntax().accept(evalVisitor);
        
        // Set nested element
        String nestedName = cmpType.getDeclaration(1).getName();
        IDecisionVariable nestedVar = cmpVar.getNestedVariable(nestedName);
        Value nestedValue = ValueFactory.createValue(nestedVar.getDeclaration().getType(), 1);
        nestedVar.setValue(nestedValue, AssignmentState.ASSIGNED);
        Assert.assertNotSame(NullValue.class, cmpVar.getValue());
        Assert.assertSame(nestedValue, ((CompoundValue) cmpVar.getValue()).getNestedValue(nestedName));
    }
    
    /**
     * Tests whether nested {@link CompoundVariable}a can handle {@link NullValue}s.
     * Bug reported by Holger Eichelberger on 13.07.2015.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     * @throws ConfigurationException Must not occur otherwise there
     * is an error in setting values of nested elements inside a compound
     */
    @Test
    public void testNestedNullValues() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Retrieve Compounds for testing
        CompoundVariable cmpVar = (CompoundVariable) configuration.getDecision(cmp1);
        Assert.assertFalse(cmpVar.getValue().isConfigured());
        CompoundVariable nestedVariable = (CompoundVariable) cmpVar.getNestedVariable(CMP2_NAME);
        Assert.assertNotNull(nestedVariable);

        // Test precondition: nested compound value is not a NullValue
        Assert.assertFalse(nestedVariable.getValue().isConfigured());
        Assert.assertNotNull(nestedVariable.getValue());
        Assert.assertNotEquals(NullValue.INSTANCE, nestedVariable.getValue());
        Assert.assertTrue(nestedVariable.getValue() instanceof CompoundValue);

        // Action: Set nested compound to null
        nestedVariable.setValue(NullValue.INSTANCE, AssignmentState.ASSIGNED);
        // Should not crash
        
        // Test post condition: Nested value should be a NullValue.
        Assert.assertTrue(nestedVariable.getValue().isConfigured());
        Assert.assertNotNull(nestedVariable.getValue());
        Assert.assertEquals(NullValue.INSTANCE, nestedVariable.getValue());
        Assert.assertTrue(nestedVariable.getValue() instanceof NullValue);
    }
}
