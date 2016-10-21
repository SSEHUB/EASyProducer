/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.adaptiveVarModel.confModel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests for the {@link AdaptiveConfiguration}.
 * @author El-Sharkawy
 */
public class AdaptiveConfigurationTests {
    private Project testProject;
    private AdaptiveConfiguration config;
    
    // Simple values
    private DecisionVariableDeclaration intDecl;
    private DecisionVariableDeclaration strDecl;
    private DecisionVariableDeclaration cmpNotNested;

    /**
     * Creates the test project and the associated configuration, which are used for testing.
     * @param projectName The name of the test case (used for assert messages)
     */
    private void createTestProject(String projectName) {
        testProject = new Project(projectName);
        
        // Simple values
        intDecl = new DecisionVariableDeclaration("intVar", IntegerType.TYPE, testProject);
        setValue(intDecl, "42");
        testProject.add(intDecl);
        strDecl = new DecisionVariableDeclaration("strVar", StringType.TYPE, testProject);
        setValue(strDecl, "Hello World");
        testProject.add(strDecl);
        
        // Not nested compound
        Compound cType1 = new Compound("CP1", testProject);
        DecisionVariableDeclaration slotADecl = new DecisionVariableDeclaration("slotA", IntegerType.TYPE, cType1);
        setValue(slotADecl, "2");
        DecisionVariableDeclaration slotBDecl = new DecisionVariableDeclaration("slotB", IntegerType.TYPE, cType1);
        setValue(slotBDecl, "3");
        cType1.add(slotADecl);
        cType1.add(slotBDecl);
        testProject.add(cType1);
        cmpNotNested = new DecisionVariableDeclaration("cmp1", cType1, testProject);
        testProject.add(cmpNotNested);
        
        // Validate project before testing
        ProjectTestUtilities.validateProject(testProject, true);
        
        // Create configuration
        config = new AdaptiveConfiguration(testProject);
    }

    /**
     * Sets a default value during the {@link #createTestProject(String)} method.
     * @param decl The declaration for which the value should be set.
     * @param value The value to set (must be of the same type)
     */
    private void setValue(DecisionVariableDeclaration decl, String value) {
        try {
            decl.setValue(value);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not set value \"" + value + "\" for \"" + decl.getName() + "\": " + e.getMessage());
        }
    }
    
    /**
     * Tests whether basic, non nested variables can be handled by the {@link AdaptiveConfiguration}.
     */
    @Test
    public void testConfigurationOfSimpleToplevelVariables() {
        createTestProject("testConfigurationOfSimpleToplevelVariables");
        
        // Test precondition, variables should have their default values from the createTestProject-Method
        IDecisionVariable intVar = config.getDecision(intDecl);
        IDecisionVariable strVar = config.getDecision(strDecl);
        assertValue(intVar, 42);
        assertValue(strVar, "Hello World");
        
        // Add temporary values (must not affect the values of the variables)
        config.addValue(intDecl.getQualifiedName(), 2);
        config.addValue(intDecl.getQualifiedName(), 3);
        config.addValue(strDecl.getQualifiedName(), "Hello Universe");
        config.addValue(intDecl.getQualifiedName(), 5);
        assertValue(intVar, 42);
        assertValue(strVar, "Hello World");
        
        // Take over values, values must change to last specified value
        config.takeOverValues();
        assertValue(intVar, 5);
        assertValue(strVar, "Hello Universe");
    }
    
    /**
     * Tests whether single slots of a compound can be handled by the {@link AdaptiveConfiguration}.
     */
    @Test
    public void testConfigureSlotOfCompound() {
        createTestProject("testConfigureSlotOfCompound");
        // Test precondition, variables should have their default values from the createTestProject-Method
        IDecisionVariable cmpVar = config.getDecision(cmpNotNested);
        assertValueStringBased(cmpVar, "{slotB=3 : Integer, slotA=2 : Integer}");
        
        // Add temporary values (must not affect the values of the variables)
        config.addValue(cmpVar.getNestedElement("slotA").getQualifiedName(), 7);
        config.addValue(cmpVar.getNestedElement("slotA").getQualifiedName(), 11);
        assertValueStringBased(cmpVar, "{slotB=3 : Integer, slotA=2 : Integer}");
        
        // Take over values, values must change to last specified value, slotB must not change
        config.takeOverValues();
        assertValueStringBased(cmpVar, "{slotB=3 : Integer, slotA=11 : Integer}");
    }

    /**
     * Checks whether the specified variable has the expected value.
     * @param var The variable to test.
     * @param expectedValue The expected value ({@link Value#getValue()}).
     */
    private void assertValue(IDecisionVariable var, Object expectedValue) {
        Assert.assertEquals("Variable \"" + var.getDeclaration().getName() + "\" in test + \"" + testProject.getName()
            + "\" has not the expected value: ", expectedValue, var.getValue().getValue());
    }
    
    /**
     * Alternative method to simplify checking of compound values in one step. However, this method is safe to use
     * as the String representation of a value may change during refactorings.
     * @param var The variable to test.
     * @param expectedValue The expected value ({@link Value#toString()}).
     * @see #assertValue(IDecisionVariable, Object)
     */
    private void assertValueStringBased(IDecisionVariable var, String expectedValue) {
        Assert.assertEquals("Variable \"" + var.getDeclaration().getName() + "\" in test + \"" + testProject.getName()
            + "\" has not the expected value: ", expectedValue, var.getValue().toString());
    }

}
