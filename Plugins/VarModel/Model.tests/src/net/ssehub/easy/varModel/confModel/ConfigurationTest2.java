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


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.filter.ReferenceValuesFinder;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Additional tests for the {@link Configuration}.
 * Contrary to {@link ConfigurationTest}, this class tests advanced features while creating the {@link Configuration}.
 * In particular this class tests correct behavior of:
 * <ul>
 * <li>{@link ProjectInterface}s</li>
 * <li>Compound refinements</li>
 * <li>{@link Reference}s</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class ConfigurationTest2 {
    
    // General settings
    
    // Interfaced Project
    private static final String PRIVATE_VAR_NAME = "internalVariable";
    private static final String PUBLIC_VAR_NAME = "exportedVariable";
    private static final String INTERFACE_NAME = "defaultInterface";
    
    // Compound Project
    private static final String BASIC_COMPOUND_NAME = "BasicCompound";
    private static final String REFINED_COMPOUND_1_NAME = "RefinedCompound1";
    private static final String REFINED_COMPOUND_2_NAME = "RefinedCompound2";
    private static final String SLOT_1_NAME = "firstSlot";
    private static final String SLOT_2_NAME = "secondSlot";
    private static final String SLOT_3_NAME = "thirdSlot";
    private static final String COMPOUND_INSTANCE_NAME_1 = "cmp1";
    private static final String COMPOUND_INSTANCE_NAME_2 = "cmp2";
    private static final String COMPOUND_INSTANCE_NAME_3 = "cmp3";
    
    // Basic Project
    private static final String BASIC_VARIABLE_NAME = "intVar";
    private static final String REFERENCED_VARIABLE_NAME = "refVar";
    
    // Interfaced Project
    private Project interfacedProject;
    private DecisionVariableDeclaration privateVar;
    private DecisionVariableDeclaration publicVar;
    
    // Compound Project
    private Project cmpProject;
    private DecisionVariableDeclaration cmp1Decl;
    private DecisionVariableDeclaration cmp2Decl;
    private DecisionVariableDeclaration cmp3Decl;
    
    // Basic Project
    private Project basicProject;
    private DecisionVariableDeclaration basicDecl;
    private DecisionVariableDeclaration refDecl;
    
    /**
     * Creates content of {@link #interfacedProject}.
     * Part of the {@link #setUp()} method.
     */
    private void createInterfacedProject() {
        interfacedProject = new Project("Interfaced_Project");
        
        // Variable hidden by the interface
        privateVar = new DecisionVariableDeclaration(PRIVATE_VAR_NAME, IntegerType.TYPE, interfacedProject);
        interfacedProject.add(privateVar);
        
        // Variable exported by the interface
        publicVar = new DecisionVariableDeclaration(PUBLIC_VAR_NAME, IntegerType.TYPE, interfacedProject);
        interfacedProject.add(publicVar);
        
        // Interface
        ProjectInterface pInterface = new ProjectInterface(INTERFACE_NAME,
            new DecisionVariableDeclaration[] {publicVar}, interfacedProject);
        interfacedProject.add(pInterface);
        
        ProjectTestUtilities.validateProject(interfacedProject);
    }
    
    /**
     * Creates content of {@link #cmpProject}.
     * Part of the {@link #setUp()} method.
     */
    private void createCompoundProject() {
        cmpProject = new Project("Compounds");
        
        // Basic Compound
        Compound basicCompound = new Compound(BASIC_COMPOUND_NAME, cmpProject);
        DecisionVariableDeclaration slot1Decl = new DecisionVariableDeclaration(SLOT_1_NAME, IntegerType.TYPE,
            basicCompound);
        basicCompound.add(slot1Decl);
        cmpProject.add(basicCompound);
        
        // RefinedCompound1 refines BasicCompound
        Compound refinedCompound1 = createRefinedCompound(REFINED_COMPOUND_1_NAME, SLOT_2_NAME, basicCompound);
        
        // RefinedCompound2 refines RefinedCompound1
        Compound refinedCompound2 = createRefinedCompound(REFINED_COMPOUND_2_NAME, SLOT_3_NAME, refinedCompound1);
        
        //Create instances for the three compounds
        cmp1Decl = new DecisionVariableDeclaration(COMPOUND_INSTANCE_NAME_1, basicCompound, cmpProject);
        cmpProject.add(cmp1Decl);
        cmp2Decl = new DecisionVariableDeclaration(COMPOUND_INSTANCE_NAME_2, refinedCompound1, cmpProject);
        cmpProject.add(cmp2Decl);
        cmp3Decl = new DecisionVariableDeclaration(COMPOUND_INSTANCE_NAME_3, refinedCompound2, cmpProject);
        cmpProject.add(cmp3Decl);
        
        ProjectTestUtilities.validateProject(cmpProject);
    }

    /**
     * Helper method for creating refined compounds inside {@link #cmpProject}.
     * This will create a compound with one new nested variable.
     * Part of the {@link #createCompoundProject()}.
     * @param cmpName The name of the refined compound
     * @param slotName The name of the nested Variable
     * @param basicCompound The basic {@link Compound} which shall be used for refinement.
     * @return the newly created {@link Compound}.
     */
    private Compound createRefinedCompound(String cmpName, String slotName, Compound basicCompound) {
        Compound refinedCompound = new Compound(cmpName, cmpProject, basicCompound);
        DecisionVariableDeclaration slotDecl = new DecisionVariableDeclaration(slotName, IntegerType.TYPE,
            refinedCompound);
        refinedCompound.add(slotDecl);
        cmpProject.add(refinedCompound);
        
        Assert.assertNotNull("Error: Newly created compound is NULL.", refinedCompound);
        return refinedCompound;
    }
    
    /**
     * Creates content of {@link #basicProject}.
     * This project can import the other projects (if necessary, this must be done inside the test method).
     * Part of the {@link #setUp()} method.
     */
    private void createBasicProject() {
        basicProject = new Project("Basic_Project");
        
        // Create Integer variable
        basicDecl = new DecisionVariableDeclaration(BASIC_VARIABLE_NAME, IntegerType.TYPE, basicProject);
        basicProject.add(basicDecl);
        
        // Reference
        Reference refType = new Reference("RefType", IntegerType.TYPE, basicProject);
        refDecl = new DecisionVariableDeclaration(REFERENCED_VARIABLE_NAME, refType, basicProject);
        basicProject.add(refDecl);
        
        ProjectTestUtilities.validateProject(basicProject);
    }
    
    /**
     * Prepares the projects, which are used for testing.
     */
    @Before
    public void setUp() {
        createInterfacedProject();
        createCompoundProject();
        createBasicProject();
    }
    
    
    /**
     * Helpermethod for the test methods.
     * Checks whether a specified declaration has a variable inside the configuration.
     * @param config The {@link Configuration} to check.
     * @param declarations {@link DecisionVariableDeclaration}s which should be included in the configuration,
     *     further variables may also be included in the {@link Configuration}.
     * @param areVisible Specification whether the given array of Declarations should be visible to the user.
     * <tt>true</tt> if the user should the the variables, <tt>false</tt> otherwise.
     */
    private void variablesAreInConfig(Configuration config, DecisionVariableDeclaration[] declarations,
        boolean areVisible) {
        
        for (int i = 0; i < declarations.length; i++) {
            DecisionVariableDeclaration decl = declarations[i];
            IDecisionVariable var = config.getDecision(decl);
            Assert.assertNotNull("Error: " + decl.getName()
                + " should be part of the configuration, but is not the case.", var);
            Assert.assertEquals(areVisible, var.isVisible());
        }
    }
    
    /**
     * Helpermethod for the test methods.
     * Checks whether a specified declaration has <b>not </b> a variable inside the configuration.
     * @param config The {@link Configuration} to check.
     * @param declarations {@link DecisionVariableDeclaration}s which should <b>not </b> be included in the
     *     configuration.
     */
    private void variablesNotInConfig(Configuration config, DecisionVariableDeclaration[] declarations) {
        for (int i = 0; i < declarations.length; i++) {
            DecisionVariableDeclaration decl = declarations[i];
            IDecisionVariable var = config.getDecision(decl);
            Assert.assertNull("Error: " + decl.getName()
                + " should NOT be part of the configuration, but it is.", var);
        }
    }
    
    /**
     * Adds a {@link ProjectImport} to the {@link #basicProject}.
     * @param importedProject one of {@link #cmpProject} or {@link #interfacedProject}.
     */
    private void addImport(Project importedProject) {
        String interfaceName = importedProject == interfacedProject ? INTERFACE_NAME : null;
        ProjectImport pImport = new ProjectImport(importedProject.getName(), interfaceName);
        try {
            pImport.setResolved(importedProject);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        basicProject.addImport(pImport);
    }
    
    /**
     * Tests whether all variables are part in a {@link Configuration}, but only variables exported by a
     * {@link ProjectInterface} should be visible to the user.
     */
    @Test
    public void testExportedVariables() {
        // Create Project and configuration for testing: basicProject should only import InterfacedProject
        addImport(interfacedProject);
        ProjectTestUtilities.validateProject(basicProject);
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        // Test correct behavior of imported project
        DecisionVariableDeclaration[] visibleVariables = {publicVar, basicDecl, refDecl};
        DecisionVariableDeclaration[] hiddenVariables = {privateVar};
        DecisionVariableDeclaration[] excludedVariables = {cmp1Decl, cmp2Decl, cmp3Decl};
        variablesAreInConfig(config, visibleVariables, true);
        variablesAreInConfig(config, hiddenVariables, false);
        variablesNotInConfig(config, excludedVariables);
    }
    
    /**
     * Checks the correct instantiation of {@link Compound} variables inside the {@link Configuration}.
     * @param config The {@link Configuration} to check.
     * @param cmpDecl The {@link DecisionVariableDeclaration} of a {@link Compound} to check.
     * @param slots The expected nested variables of the compound. This must include <b>all</b> expected variables.
     */
    private void checkCompound(Configuration config, DecisionVariableDeclaration cmpDecl, String[] slots) {
        IDecisionVariable cmpVar = config.getDecision(cmpDecl);
        Assert.assertNotNull(cmpVar);
        int nSlots = cmpVar.getNestedElementsCount();
        Assert.assertEquals(slots.length, nSlots);
        for (int i = 0; i < nSlots; i++) {
            IDecisionVariable slotVar = cmpVar.getNestedElement(i);
            boolean found = false;
            for (int j = 0; j < slots.length && !found; j++) {
                if (slots[j].equals(slotVar.getDeclaration().getName())) {
                    found = true;
                }
            }
            Assert.assertTrue("Error: Not expected slot variable is part of the configuration: "
                + slotVar.getDeclaration().getName(), found);
        }
    }
    
    /**
     * Test the correct behavior of refined compounds.
     */
    @Test
    public void testCompoundProjects() {
        // Create Project and configuration for testing: basicProject should only import CompoundProject
        addImport(cmpProject);
        ProjectTestUtilities.validateProject(basicProject);
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        // Test correct behavior of imported project
        DecisionVariableDeclaration[] visibleVariables = {basicDecl, refDecl, cmp1Decl, cmp2Decl, cmp3Decl};
        DecisionVariableDeclaration[] excludedVariables = {publicVar, privateVar};
        variablesAreInConfig(config, visibleVariables, true);
        variablesNotInConfig(config, excludedVariables);
        checkCompound(config, cmp1Decl, new String[] {SLOT_1_NAME});
        checkCompound(config, cmp2Decl, new String[] {SLOT_1_NAME, SLOT_2_NAME});
        checkCompound(config, cmp3Decl, new String[] {SLOT_1_NAME, SLOT_2_NAME, SLOT_3_NAME});
    }
    
    /**
     * Helpermethod for checking possible values of a {@link Reference}.
     * @param config The configuration to check.
     * @param expectedValues All expected values for {@link #refDecl}.
     */
    private void checkPossibleValuesForReference(Configuration config, String[] expectedValues) {
        Project project = config.getProject();
        Reference refType = (Reference) refDecl.getType();
        List<AbstractVariable> possibleDeclarations = ReferenceValuesFinder.findPossibleValues(project, refType);
        
        //Check whether the correct amount of possible values was found
        Assert.assertSame(expectedValues.length, possibleDeclarations.size());     
        for (int i = 0; i < expectedValues.length; i++) {
            boolean found = false;
            for (int j = 0; j < possibleDeclarations.size() && !found; j++) {
                if (possibleDeclarations.get(j).getName().equals(expectedValues[i])) {
                    found = true;
                }
            }
            
            Assert.assertTrue("Error: Expected reference value was not found in the configuration: "
                + expectedValues[i], found);
        }
    }
    
    /**
     * Test correct value suggestions for given {@link Reference} variable (part 1 of 4).
     * This method tests a project without any imports.
     */
    @Test
    public void testSimpleReference() {
        // Create configuration of basicProject for testing
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        //Test correct project structure
        DecisionVariableDeclaration[] visibleVariables = {basicDecl, refDecl};
        DecisionVariableDeclaration[] excludedVariables = {publicVar, privateVar, cmp1Decl, cmp2Decl, cmp3Decl};
        variablesAreInConfig(config, visibleVariables, true);
        variablesNotInConfig(config, excludedVariables);
        
        // Test correct value suggestions for reference variable
        checkPossibleValuesForReference(config, new String[] {BASIC_VARIABLE_NAME});
        
    }
    
    /**
     * Test correct value suggestions for given {@link Reference} variable (part 2 of 4).
     * This method tests a projects with an imported interface.
     */
    @Test
    public void testImportedReference() {
        // Create Project and configuration for testing: basicProject should only import InterfacedProject
        addImport(interfacedProject);
        ProjectTestUtilities.validateProject(basicProject);
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        //Test correct project structure
        DecisionVariableDeclaration[] visibleVariables = {publicVar, basicDecl, refDecl};
        DecisionVariableDeclaration[] hiddenVariables = {privateVar};
        DecisionVariableDeclaration[] excludedVariables = {cmp1Decl, cmp2Decl, cmp3Decl};
        variablesAreInConfig(config, visibleVariables, true);
        variablesAreInConfig(config, hiddenVariables, false);
        variablesNotInConfig(config, excludedVariables);
        
        // Test correct value suggestions for reference variable
        checkPossibleValuesForReference(config, new String[] {BASIC_VARIABLE_NAME, PUBLIC_VAR_NAME});
    }
    
    /**
     * Test correct value suggestions for given {@link Reference} variable (part 3 of 4).
     * This method tests a projects with slots of a compound.
     */
    @Test
    public void testCompoundedReference() {
        // Create Project and configuration for testing: basicProject should only import CompoundProject
        addImport(cmpProject);
        ProjectTestUtilities.validateProject(basicProject);
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        //Test correct project structure
        DecisionVariableDeclaration[] visibleVariables = {basicDecl, refDecl, cmp1Decl, cmp2Decl, cmp3Decl};
        DecisionVariableDeclaration[] excludedVariables = {privateVar, publicVar};
        variablesAreInConfig(config, visibleVariables, true);
        variablesNotInConfig(config, excludedVariables);
        
        /* 
         * Test correct value suggestions for reference variable: Slots of a compound are currently not supported by
         * IVML, thus, the user should not be able to configure this.
         */
        checkPossibleValuesForReference(config, new String[] {BASIC_VARIABLE_NAME});
    }
    
    /**
     * Test correct value suggestions for given {@link Reference} variable (part 4 of 4).
     * This method tests a projects with slots of a compound and interfaces.
     */
    @Test
    public void testCompoundedAndInterfacedReference() {
        // Create Project and configuration for testing: basicProject should only import CompoundProject
        addImport(cmpProject);
        addImport(interfacedProject);
        ProjectTestUtilities.validateProject(basicProject);
        Configuration config = new Configuration(basicProject);
        Assert.assertNotNull(config);
        
        //Test correct project structure
        DecisionVariableDeclaration[] visibleVariables = {basicDecl, refDecl, cmp1Decl, cmp2Decl, cmp3Decl, publicVar};
        DecisionVariableDeclaration[] hiddenVariables = {privateVar};
        variablesAreInConfig(config, visibleVariables, true);
        variablesAreInConfig(config, hiddenVariables, false);
        
        /* 
         * Test correct value suggestions for reference variable: Slots of a compound are currently not supported by
         * IVML, thus, the user should not be able to configure this.
         */
        checkPossibleValuesForReference(config, new String[] {BASIC_VARIABLE_NAME, PUBLIC_VAR_NAME});
    }
}
