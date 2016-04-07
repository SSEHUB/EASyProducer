/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.confModel;

import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * Testcases for {@link SetVariable}s.
 * @author lueder
 *
 */
public class SetVariableTest {

    private Project project;
    private Configuration configuration;
    private DecisionVariableDeclaration set;
    private Compound innerCompound;
    private DecisionVariableDeclaration setOfCompound;
    
    
    /**
     * SetUp method: creates an empty project together with a configuration.
     */
    @Before
    public void setUp() {
        project = new Project("configurationTestProject");
        Set setType = new Set("SET", IntegerType.TYPE, project);
        set = new DecisionVariableDeclaration("set", setType, project);
        project.add(set);
        innerCompound = new Compound("CMP", project);
        project.add(innerCompound);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, innerCompound);
        DecisionVariableDeclaration intB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, innerCompound);
        innerCompound.add(intA);
        innerCompound.add(intB);
        Set setOfCompoundType = new Set("SetOfCompound", innerCompound, project);
        setOfCompound = new DecisionVariableDeclaration("setOfCompound", setOfCompoundType, project);
        project.add(setOfCompound);
        IvmlValidationVisitor validationer = new IvmlValidationVisitor();
        project.accept(validationer);
        Assert.assertEquals(0, validationer.getErrorCount());
        
        configuration = new Configuration(project);  
    }
    
    /**
     * Helping method for testing the ouput of saving a value assignment.
     * This method gets the output of the <tt>Configuration.toProject(true)</tt> method and extracts
     * the searched value assignment for further testing.
     * @param savedConfig The result of <tt>Configuration.toProject(true)</tt>
     * @param elementNo The position of the declaration to which the searched assignment belongs,
     * starting at 0.
     * @return The value assignment, without surrounding whitespaces and ;
     */
    static String getValue(StringBuffer savedConfig, int elementNo) {
        int lineBreak = savedConfig.indexOf("\n");
        // Search the line containing the value assignment
        for (int i = 0; i < 2 + elementNo; i++) {
            lineBreak = savedConfig.indexOf("\n", lineBreak + 1);
        }
        String savedValueAssignment = savedConfig.substring(lineBreak + 1, savedConfig.lastIndexOf(";"));
        savedValueAssignment = savedValueAssignment.trim();
        
        return savedValueAssignment;
    }
    
    /**
     * Saves the configuration in a StringBuffer using the <tt>Configuration.toProject(true)</tt> method.
     * @param config the configuration which should be saved.
     * @return The saved configuration.
     */
    static StringBuffer configToStringBuffer(Configuration config) {
        StringBuffer result = null;
        try {
            Project confProject = config.toProject(true);
            StringWriter sWriter = new StringWriter();
            IVMLWriter writer = new IVMLWriter(sWriter);
            confProject.accept(writer);
            result =  sWriter.getBuffer();
        } catch (ConfigurationException e) {
            Assert.fail(e.getLocalizedMessage());
        }
        
        // Cannot be null.
        return result;
    }
    
    /**
     * Tests the setValue method of a {@link SetVariable}.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} is broken.
     * @throws ConfigurationException Must not occur, otherwise {@link SetVariable#setValue(Value, IAssignmentState)}
     * is broken.
     */
    @Test
    public void testSimpleAssignment() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Retrieve setVariable
        SetVariable setVar = retrieveSetVariable(set);
        
        // Assign Values
        IDatatype setType = setVar.getDeclaration().getType();
        Value setValue = ValueFactory.createValue(setType, "1", "2", "3");
        setVar.setValue(setValue, AssignmentState.ASSIGNED);
        
        // Test correct behavior
        Assert.assertEquals(3, setVar.getNestedElementsCount());
    }

    /**
     * Supporting method for tests to retrieve a variable related to the
     * specified {@link DecisionVariableDeclaration}.
     * @param decl The {@link DecisionVariableDeclaration} for the searched {@link SetVariable}.
     * @return The variable inside the configuration for the specified {@link DecisionVariableDeclaration}.
     */
    private SetVariable retrieveSetVariable(DecisionVariableDeclaration decl) {
        SetVariable setVar = (SetVariable) configuration.getDecision(decl);
        Assert.assertNotNull(setVar);
        Assert.assertEquals(0, setVar.getNestedElementsCount());
        return setVar;
    }
    
    /**
     * Supporting method for tests to create a nested variable inside the variable of
     * the specified {@link DecisionVariableDeclaration}.
     * @param setVar The {@link SetVariable} where a nested element should be created in.
     * @return The newly created nested variable.
     */
    private IDecisionVariable createNestedElement(SetVariable setVar) {
        int countNestedElements = setVar.getNestedElementsCount();
        
        // Extend variable (insert new nested element).
        setVar.addNestedElement();
        
        // Test whether nested element was created correctly
        Assert.assertEquals(countNestedElements + 1, setVar.getNestedElementsCount());
        IDecisionVariable nestedElement = setVar.getNestedElement(countNestedElements);
        Assert.assertNotNull(nestedElement);
        Assert.assertNotNull(nestedElement.getValue());
        Assert.assertFalse(nestedElement.getValue().isConfigured());
        
        //Return newly created variable
        return nestedElement;
    }
    
    /**
     * Tests the stepwise creation of nested Values of a set.
     * This is needed for the stepwise configuration inside the GUI.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} is broken.
     * @throws ConfigurationException Must not occur, otherwise {@link SetVariable#setValue(Value, IAssignmentState)}
     * is broken.
     */
    @Test
    public void testStepwiseExtentionOfSet() throws ValueDoesNotMatchTypeException, ConfigurationException {
        String testValue = "1";
        
        // Retrieve setVariable
        SetVariable setVar = retrieveSetVariable(set);
        Container setType = (Container) setVar.getDeclaration().getType();
        IDatatype setOfType = setType.getContainedType();
        
        // Extend variable (insert new nested element) and configure nested element
        IDecisionVariable nestedElement = createNestedElement(setVar);
        Value tmpNestedValue = ValueFactory.createValue(setOfType, testValue);
        nestedElement.setValue(tmpNestedValue, AssignmentState.ASSIGNED);
        
        // Test correct behavior of configuring the nested element.
        Assert.assertEquals(testValue, nestedElement.getValue().getValue().toString());
        ContainerValue completeValue = (ContainerValue) setVar.getValue();
        Value nestedValue = completeValue.getElement(0);
        Assert.assertNotNull(nestedValue);
        Assert.assertNotNull(nestedValue.getValue());
        Assert.assertEquals(testValue, nestedValue.getValue().toString());
        
        // Test whether the variable would be saved correctly
        Project confProject = configuration.toProject(true);
        StringWriter sWriter = new StringWriter();
        IVMLWriter writer = new IVMLWriter(sWriter);
        confProject.accept(writer);
        StringBuffer output = sWriter.getBuffer();
        String savedValueAssignment = getValue(output, 0);
        String expected = set.getName() + " " + IvmlKeyWords.ASSIGNMENT + " "
            + StringProvider.toIvmlString(completeValue);
        Assert.assertEquals(expected, savedValueAssignment);
    }
    
    /**
     * Test the correct behavior of extending and configuring a setOfCompound.
     * this test also checks the correct behavior of configuring 2 nested elements.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} is broken.
     * @throws ConfigurationException Must not occur, otherwise {@link SetVariable#setValue(Value, IAssignmentState)}
     * is broken.
     */
    @Test
    public void testSetOfCompound() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Values for nested compounds
        String[] values0 = {"1", "2"};
        String[] values1 = {"-1", "-2"};
        
        // retrieve Variable and extend it (correct behavior is tested in supporting methods).
        SetVariable setVar = retrieveSetVariable(setOfCompound);
        IDecisionVariable nestedElement0 = createNestedElement(setVar);
        Container setType = (Container) setVar.getDeclaration().getType();
        IDatatype setOfType = setType.getContainedType();
        
        // configure nested compound
        Value tmpNestedValue0 = ValueFactory.createValue(setOfType, "intA", values0[0], "intB", values0[1]);
        nestedElement0.setValue(tmpNestedValue0, AssignmentState.ASSIGNED);
        
        // Test correct value assignment of nested compound at pos 0.
        CompoundValue cmpValue0 = (CompoundValue) nestedElement0.getValue();
        Value cmpValue0IntA = cmpValue0.getNestedValue("intA"); 
        Value cmpValue0IntB = cmpValue0.getNestedValue("intB");
        Assert.assertEquals(values0[0], cmpValue0IntA.getValue().toString());
        Assert.assertEquals(values0[1], cmpValue0IntB.getValue().toString());
        
        //Create a second compound and configure a value
        IDecisionVariable nestedElement1 = createNestedElement(setVar);
        Value tmpNestedValue1 = ValueFactory.createValue(setOfType, "intA", values1[0], "intB", values1[1]);
        nestedElement1.setValue(tmpNestedValue1, AssignmentState.ASSIGNED);
        
        // Test correct value assignment (compound{0} must not be changed, compound{1} must be configured).
        // compound{0}
        cmpValue0 = (CompoundValue) nestedElement0.getValue();
        cmpValue0IntA = cmpValue0.getNestedValue("intA"); 
        cmpValue0IntB = cmpValue0.getNestedValue("intB");
        Assert.assertEquals(values0[0], cmpValue0IntA.getValue().toString());
        Assert.assertEquals(values0[1], cmpValue0IntB.getValue().toString());
        // compound{1}
        CompoundValue cmpValue1 = (CompoundValue) nestedElement1.getValue();
        Value cmpValue1IntA = cmpValue1.getNestedValue("intA"); 
        Value cmpValue1IntB = cmpValue1.getNestedValue("intB");
        Assert.assertEquals(values1[0], cmpValue1IntA.getValue().toString());
        Assert.assertEquals(values1[1], cmpValue1IntB.getValue().toString());
    }
    
    /**
     * Tests the correct behavior of freezing a set of compounds.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} is broken.
     * @throws ConfigurationException Must not occur, otherwise {@link SetVariable#setValue(Value, IAssignmentState)}
     * is broken.
     */
    @Test
    public void testFreeze() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Values for nested compound
        String[] values = {"1", "2"};
        
        // retrieve Variable and extend it (correct behavior is tested in supporting methods).
        SetVariable setVar = retrieveSetVariable(setOfCompound);
        IDecisionVariable nestedElement = createNestedElement(setVar);
        Container setType = (Container) setVar.getDeclaration().getType();
        IDatatype setOfType = setType.getContainedType();
        
        // configure nested compound
        Value tmpNestedValue = ValueFactory.createValue(setOfType, "intA", values[0], "intB", values[1]);
        nestedElement.setValue(tmpNestedValue, AssignmentState.ASSIGNED);
        Assert.assertEquals(1, setVar.getNestedElementsCount());
        Assert.assertEquals(AssignmentState.ASSIGNED, setVar.getState());
        
        //Freeze set variable
        setVar.freeze(AllFreezeSelector.INSTANCE);
        
        //Test correct behavior of set variable (same amount of nested elements, frozen state)
        Assert.assertEquals(1, setVar.getNestedElementsCount());
        Assert.assertEquals(AssignmentState.FROZEN, setVar.getState());
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        configuration.toProject(false).accept(iWriter);
        System.out.println(sWriter.toString());
    }
}
