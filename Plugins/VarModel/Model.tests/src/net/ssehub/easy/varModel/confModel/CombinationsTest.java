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
package net.ssehub.easy.varModel.confModel;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests special combinations of variables. Thus, these tests are not related to exact one data type.
 * @author El-Sharkawy
 *
 */
public class CombinationsTest {

    /**
     * Constructor of this class will create a fresh instance before each test execution. 
     */
    private Project project = new Project("testProject");
    
    /**
     * Tests whether elements of a setOf(Compound) inside a setOf(Compound) are configurable.
     * Bug reported on 29.07.2015.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise {@link ValueFactory} does not work
     * @throws CSTSemanticException Must not occur, otherwise assignment constraints are broken.
     */
    @Test
    public void testNestedCompoundSets() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create nested Compound
        Compound nestedCmpType = new Compound("NestedCP", project);
        project.add(nestedCmpType);
        DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration("nestedInt", IntegerType.TYPE,
            nestedCmpType);
        nestedCmpType.add(nestedDecl);
        
        // Create toplevel compound
        Compound cmpType = new Compound("TopCP", project);
        project.add(cmpType);
        Set nestedSetType = new Set("nestedCompoundsType", nestedCmpType, cmpType);
        DecisionVariableDeclaration nestedCPs = new DecisionVariableDeclaration("nestedCompounds", nestedSetType,
            cmpType);
        cmpType.add(nestedCPs);
        
        // Create top level set
        Set topSetType = new Set("compoundsType", cmpType, project);
        DecisionVariableDeclaration topCPs = new DecisionVariableDeclaration("topCompounds", topSetType, project);
        project.add(topCPs);
        
        // Create an assignment
        Constraint assingnmentConstraint = new Constraint(project);
        Value nestedCmpValue = ValueFactory.createValue(nestedCmpType, new Object[] {"nestedInt", "1"});
        Value nestedSetValue = ValueFactory.createValue(nestedSetType, nestedCmpValue);
        Value cmpValue = ValueFactory.createValue(cmpType, new Object[] {"nestedCompounds", nestedSetValue});
        Value topSetValue = ValueFactory.createValue(topSetType, cmpValue);
        ConstantValue constValue = new ConstantValue(topSetValue);
        OCLFeatureCall assignment = new OCLFeatureCall(new Variable(topCPs), OclKeyWords.ASSIGNMENT, constValue);
        assingnmentConstraint.setConsSyntax(assignment);
        project.add(assingnmentConstraint);
        
        // Create configuration out of valid project
        ProjectTestUtilities.validateProject(project);
     // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        
        // Pre condition: Set is configured and has exact one value
        IDecisionVariable topVar = config.getDecision(topCPs);
        ContainerValue topValue = (ContainerValue) topVar.getValue();
        Assert.assertEquals("Error: top level set should have exactly one value", 1, topValue.getElementSize());
        
        // Test whether an IDecisionVariable was created for: nestedInt
        IDecisionVariable topCmpVar = getNestedElement(topVar);
        IDecisionVariable nestedSetVar = getNestedElement(topCmpVar);
        IDecisionVariable nestedCmpVar = getNestedElement(nestedSetVar);
        IDecisionVariable mostNestedVar = getNestedElement(nestedCmpVar);
        Assert.assertTrue(mostNestedVar.getValue().isConfigured());
    }
    
    /**
     * Tests whether a configured nest element will change the value of the containing compound.
     * @throws ValueDoesNotMatchTypeException 
     * @throws ConfigurationException 
     */
    @Test
    public void testCorrectValueOfCompoundContainingSets() throws ConfigurationException,
        ValueDoesNotMatchTypeException {
        
        Compound cType = new Compound("CP", project);
        Set setType = new Set("setOfInts", IntegerType.TYPE, cType);
        DecisionVariableDeclaration intsDecl = new DecisionVariableDeclaration("ints", setType, cType);
        cType.add(intsDecl);
        project.add(cType);
        DecisionVariableDeclaration cmpDecl = new DecisionVariableDeclaration("cmp", cType, project);
        project.add(cmpDecl);
        
        ProjectTestUtilities.validateProject(project, true);
        Configuration config = new Configuration(project);
        IDecisionVariable cmpVar = config.getDecision(cmpDecl);
        
        // Test pre condition: Value for the set should be null/empty
        ContainerValue nestedValue = (ContainerValue) ((CompoundValue) cmpVar.getValue())
            .getNestedValue(intsDecl.getName());
        Assert.assertNull(nestedValue);
        
        // configure the value for the set (extend it and configure nested element)
        ContainerVariable setVar = (ContainerVariable) cmpVar.getNestedElement(0);
        setVar.addNestedElement();
        IDecisionVariable firstSetElement = setVar.getNestedElement(0);
        firstSetElement.setValue(ValueFactory.createValue(IntegerType.TYPE, "42"), AssignmentState.ASSIGNED);
        
        // Test post condition: compoudn value should return a value for the nested element of the set
        nestedValue = (ContainerValue) ((CompoundValue) cmpVar.getValue()).getNestedValue(intsDecl.getName());
        Assert.assertNotNull(nestedValue);
        Assert.assertEquals(42, nestedValue.getElement(0).getValue());
    }
    
    /**
     * Extracts the first nested {@link IDecisionVariable} of the given {@link IDecisionVariable} and tests,
     * that the extracted variable exists.
     * @param var An {@link IDecisionVariable} which should hold a nested {@link IDecisionVariable}.
     * @return The nested {@link IDecisionVariable} or an error will be thrown.
     */
    private static IDecisionVariable getNestedElement(IDecisionVariable var) {
        Assert.assertTrue("Error: There was no nested element created for \"" + var.getDeclaration().getName() + "\"",
            var.getNestedElementsCount() > 0);
        IDecisionVariable nestedVar = var.getNestedElement(0);
        Assert.assertNotNull("Error: First nested element of \"" + var.getDeclaration().getName() + "\" is null.",
            nestedVar);
        return nestedVar;
    }
}
