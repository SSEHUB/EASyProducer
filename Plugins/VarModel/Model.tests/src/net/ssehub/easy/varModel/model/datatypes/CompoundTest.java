/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Testfile for the visitor in the compound class.
 * @author lueder
 * @author Sascha El-Sharkawy
 *
 */
public class CompoundTest {

    private Compound cp1;
    private String testName;
    private Project project;
    
    /**
     * setUp method to create the test compound cp1.
     */
    @Before
    public void setUp() {
        project = new Project("project");
        testName = "cp1";
        cp1 = new Compound(testName, project);        
    }
    
    /**
     * Test whether the empty compound is correct initialized.
     */
    @Test
    public void testEmptyCompound() {
                
        Assert.assertEquals(testName, cp1.getName());        
        Assert.assertEquals(0, cp1.getElementCount());
    }
    
    /**
     * Test to fill an empty Compound with a String.
     */
    @Test
    public void testToFillCompound() {
        
        // add a String to the Compound
        String elem1Name = "String1";
        DecisionVariableDeclaration elem1 = new DecisionVariableDeclaration(elem1Name, StringType.TYPE, cp1);
        
        cp1.add(elem1);
        
        Assert.assertEquals(elem1, cp1.getElement(0));
        Assert.assertEquals(cp1, elem1.getParent());
        Assert.assertEquals(false, elem1.isTopLevel());
        
        //try to add the same object a second time
        boolean added = cp1.add(elem1);
        Assert.assertFalse(added);
        
        int n = cp1.getElementCount();
        Assert.assertEquals(1, n);
        
        DecisionVariableDeclaration elem2 = cp1.getElement(0);
        Assert.assertEquals(elem1, elem2);
    }
    
    /**
     * Test to check the refines object of the compound class.
     */
    @Test
    public void testRefines() {
        Compound cp2 = new Compound("cp2", null, cp1);
        
        //The refines object of cp1 should be null
        Compound cpRefines = cp1.getRefines();
        Assert.assertNull(cpRefines);
        
        //The refines object of cp2 should be cp1
        cpRefines = cp2.getRefines();
        Assert.assertEquals(cp1, cpRefines);
        
        // Test correct behavior of assigning refined variables.
        Assert.assertTrue(cp1.isAssignableFrom(cp2));
        Assert.assertFalse(cp2.isAssignableFrom(cp1));
    }
    
    /**
     * Test to check the implementation of the assignableFrom-method.
     */
    @Test
    public void testDifferentCompoundsAreNotAassignable() {
        
        //Test whether a compound is assignableFrom a compound
        Compound cp2 = new Compound("cp2", null);
        boolean assign = cp1.isAssignableFrom(cp2);
        Assert.assertFalse(assign);
        
        //Test whether a compound is assignableFrom a container
        Container con = new Set("container", StringType.TYPE, null);
        assign = cp1.isAssignableFrom(con);
        Assert.assertFalse(assign);
        
    }
    
    /**
     * Tests that {@link Compound#TYPE} is <b>not</b> assignable from enumerations.
     * This bug occurred while introducing {@link net.ssehub.easy.varModel.model.values.NullValue}s,
     * which are a kind of {@link net.ssehub.easy.varModel.model.datatypes.AnyType}.
     */
    @Test
    public void testCompoundAndEnumAreNotAssignable() {
        Enum enumType = new Enum("EnumType", null, "A", "B");
        boolean assignable = Compound.TYPE.isAssignableFrom(enumType);
        Assert.assertFalse("Error: Enumerations are asignable to Compounds.", assignable);
    }
    
    /**
     * Tests that a simple compound (no refinement or nested assign blocks) cannot contain the same slot name
     * multiple times.
     */
    @Test
    public void testSlotNamesUniqueInSimpleCompound() {
        Compound simpleCP = new Compound("simpleCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, simpleCP);
        // Different datatypes to avoid that isSame returns true
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, simpleCP);
        
        // Add two declarations with the same name -> Should fail
        Assert.assertTrue("Could not add the first declaration", simpleCP.add(decl1));
        Assert.assertFalse("Could add the same slot name a second time", simpleCP.add(decl2));
    }
    
    /**
     * Tests that a refined compound cannot contain the same slot name multiple times.
     */
    @Test
    public void testSlotNamesUniqueInRefinedCompound() {
        Compound baseCP = new Compound("baseCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, baseCP);
        Assert.assertTrue("Could not add the first declaration", baseCP.add(decl1));
        Compound refinedCP = new Compound("refinedCP", project, baseCP);
        
        // Add second declaration with the same name -> Should fail
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, baseCP);
        boolean added = refinedCP.add(decl2);
        if (!Compound.ENABLE_SHADOWING_REFINEMENT) {
            Assert.assertFalse("Could add the same slot name a second time", added);
        } else {
            // cannot check type compliance of slots here, done in the parser
            Assert.assertTrue("Shall be able to add the same slot name a second time", added);
        }
    }
    
    /**
     * Tests that a multiple refined compound cannot contain the same slot name multiple times.
     */
    @Test
    public void testSlotNamesUniqueInMultipleRefinedCompound() {
        Compound baseCP = new Compound("baseCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, baseCP);
        Assert.assertTrue("Could not add the first declaration", baseCP.add(decl1));
        Compound refinedCP = new Compound("refinedCP", project, baseCP);
        Compound refinedCP2 = new Compound("refinedCP2", project, refinedCP);
        
        // Add second declaration with the same name -> Should fail
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, baseCP);

        boolean added = refinedCP2.add(decl2);
        if (!Compound.ENABLE_SHADOWING_REFINEMENT) {
            Assert.assertFalse("Could add the same slot name a second time", added);
        } else {
            // cannot check type compliance of slots here, done in the parser
            Assert.assertTrue("Shall be able to add the same slot name a second time", added);
        }
    }
    
    /**
     * Tests that a compound slot is unique also considering assignment blocks.
     * Adds the first declaration to the assignment block <b>before</b> adding the assignment block to the compound.
     */
    @Test
    public void testSlotNamesUniqueInAssignmentWithinCompoundFirstToAssignment() {
        Compound simpleCP = new Compound("simpleCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, simpleCP);
        // Different datatypes to avoid that isSame returns true
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, simpleCP);
        AttributeAssignment assignBlock = new AttributeAssignment(simpleCP);
        Assert.assertTrue("Could not add the first declaration", assignBlock.add(decl1));
        simpleCP.add(assignBlock);
        
        // Add second declaration with the same name -> Should fail
        Assert.assertFalse("Could add the same slot name a second time", simpleCP.add(decl2));
    }
    
    /**
     * Tests that a compound slot is unique also considering assignment blocks.
     * Adds the first declaration to the assignment block <b>after</b> adding the assignment block to the compound.
     */
    @Test
    public void testSlotNamesUniqueInAssignmentWithinCompoundSecondToAssignment() {
        Compound simpleCP = new Compound("simpleCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, simpleCP);
        // Different datatypes to avoid that isSame returns true
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, simpleCP);
        AttributeAssignment assignBlock = new AttributeAssignment(simpleCP);
        simpleCP.add(assignBlock);
        Assert.assertTrue("Could not add the first declaration", assignBlock.add(decl1));
        
        // Add second declaration with the same name -> Should fail
        Assert.assertFalse("Could add the same slot name a second time", simpleCP.add(decl2));
    }
    
    /**
     * Tests that a compound slot is unique also considering assignment blocks.
     * Adds the second declaration to the assignment block.
     */
    @Test
    public void testSlotNamesUniqueInAssignmentWithinCompoundTestOnAssignBlock() {
        Compound simpleCP = new Compound("simpleCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, simpleCP);
        // Different datatypes to avoid that isSame returns true
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, simpleCP);
        AttributeAssignment assignBlock = new AttributeAssignment(simpleCP);
        simpleCP.add(assignBlock);
        Assert.assertTrue("Could not add the first declaration", simpleCP.add(decl1));
        
        // Add second declaration with the same name -> Should fail
        Assert.assertFalse("Could add the same slot name a second time", assignBlock.add(decl2));
    }

    /**
     * Tests that a compound slot is unique also considering assignment blocks.
     * Tests this with a refined compound
     */
    @Test
    public void testSlotNamesUniqueInAssignmentOnRefinedCompound() {
        Compound baseCP = new Compound("baseCP", project);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("slot", StringType.TYPE, baseCP);
        Assert.assertTrue("Could not add the first declaration", baseCP.add(decl1));
        
        Compound refinedCP = new Compound("refinedCP", project, baseCP);
        AttributeAssignment assignBlock = new AttributeAssignment(refinedCP);
        refinedCP.add(assignBlock);
        // Different datatypes to avoid that isSame returns true
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("slot", RealType.TYPE, baseCP);
        
        // Add second declaration with the same name -> Should fail
        Assert.assertFalse("Could add the same slot name a second time", assignBlock.add(decl2));
    }
}
