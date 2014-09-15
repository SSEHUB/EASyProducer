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
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;

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
}
