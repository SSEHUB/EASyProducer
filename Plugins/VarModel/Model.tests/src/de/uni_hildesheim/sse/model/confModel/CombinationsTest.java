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
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

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
        ProjectTestUtilities.validateProject(project, true);
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
