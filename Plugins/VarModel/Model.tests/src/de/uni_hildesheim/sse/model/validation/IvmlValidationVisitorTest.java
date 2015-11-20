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
package de.uni_hildesheim.sse.model.validation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IvmlKeyWords;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

/**
 * Tests the {@link IvmlValidationVisitor}.
 * @author El-Sharkawy
 *
 */
public class IvmlValidationVisitorTest {

    private Project project;
    
    /**
     * Creates an empty project for testing.
     */
    @Before
    public void setUp() {
        project = new Project("testProject");
    }
    
    /**
     * Tests whether for a variable with a {@link de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype},
     * the {@link de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype} is also available inside
     * the {@link Project}.
     */
    @Test
    public void testPresenceOfDatatypes() {
        // Create Declaration with custom datatype, but do NOT add the custom datatype
        Enum enumType = new Enum("MyEnum", project, "A", "B");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", enumType, project);
        project.add(decl);
        
        // Test whether the IvmlValidationVisitor is able to detect the missing declaration
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        
        // Test postcondition: Visitor should detect the missing datatype
        Assert.assertTrue(validator.getErrorCount() > 0);
        ValidationMessage errMsg = validator.getMessage(0);
        Assert.assertEquals(ValidationMessage.MISSING_CUSTOM_DATATYPE, errMsg.getCode());
    }
    
    /**
     * Test whether the {@link IvmlValidationVisitor} does not detect to many identifier errors.
     */
    @Test
    public void testIdentifierCheckValid() {
        Project validIdentifierProject = new Project("validIdentifier");
        /* 
         * Some "problematic" examples. May be extended ;-)
         * Avoid to use the same implementation as already used inside the visitor.
         */
        createDeclaration(validIdentifierProject, OclKeyWords.AT);
        createDeclaration(validIdentifierProject, OclKeyWords.APPLY);
        createDeclaration(validIdentifierProject, OclKeyWords.COUNT);
        
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        validIdentifierProject.accept(validator);
        Assert.assertEquals("Visitor detected errors, but should not.", 0, validator.getErrorCount());
    }
    
    /**
     * Test whether the {@link IvmlValidationVisitor} does detect identifier erros.
     */
    @Test
    public void testIdentifierCheckFails() {
        Project invalidIdentifierProject = new Project("invalidIdentifier");
        /* 
         * Some "problematic" examples. May be extended ;-)
         * Avoid to use the same implementation as already used inside the visitor.
         */
        int problemsAdded = 0;
        createDeclaration(invalidIdentifierProject, OclKeyWords.AND);
        problemsAdded++;
        createDeclaration(invalidIdentifierProject, IvmlKeyWords.ABSTRACT);
        problemsAdded++;
        createDeclaration(invalidIdentifierProject, OclKeyWords.EQUALS);
        problemsAdded++;
        createDeclaration(invalidIdentifierProject, "[");
        problemsAdded++;
        createDeclaration(invalidIdentifierProject, "42");
        problemsAdded++;
        createDeclaration(invalidIdentifierProject, "42_and_a_name");
        problemsAdded++;
        
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        invalidIdentifierProject.accept(validator);
        Assert.assertEquals("Visitor detected not all identifier problems", problemsAdded, validator.getErrorCount());
    }

    /**
     * Helper method to simplify the creation of {@link DecisionVariableDeclaration}s.
     * @param project The project where to add the declaration.
     * @param name The name of the declaration.
     */
    private void createDeclaration(Project project, String name) {
        // Data type is not important -> There I choose one basic type
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration(name, IntegerType.TYPE, project);
        project.add(decl);
    }
}
