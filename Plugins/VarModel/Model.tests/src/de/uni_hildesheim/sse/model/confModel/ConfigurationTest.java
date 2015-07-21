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
package de.uni_hildesheim.sse.model.confModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.filter.ConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FreezeBlockFinder;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * This class tests the correct behavior of the configuration.
 * @author El-Sharkawy
 *
 */
public class ConfigurationTest {
    
    private Project project;
    private Configuration configuration;
    
    /**
     * SetUp method: creates an empty project together with a configuration.
     * @throws URISyntaxException Must not occur
     */
    @Before
    public void setUp() throws URISyntaxException {
        project = new Project("configurationTestProject");
        // This call overwrites old instances of projects with same name and version number
        URI fictiveLocation = new URI("path/" + project.getName());
        VarModel.INSTANCE.updateModel(project, fictiveLocation);
        configuration = new Configuration(project);        
    }

    /**
     * This method tests whether the constructor works fine.
     * It mainly tests the correct instantiation of decision variables.
     */
    @Test
    public void testInstantiation() {
        //Test empty configuration, should be empty even after refreshing it
        Assert.assertEquals(0, configuration.getDecisionCount());
        configuration.refresh();
        Assert.assertEquals(0, configuration.getDecisionCount());
        
        //Create one declaration, refresh configuration, and test element count
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        Assert.assertEquals(1, configuration.getDecisionCount());
        
        //Test whether variable do not have any values.
        IDecisionVariable variable = configuration.getDecision(intA);
        Assert.assertNotNull(variable);
        Assert.assertNull(variable.getValue());
    }
    
    /**
     * Tests the correct instantiation of decisions having a default value.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is an error in the configuration
     */
    @Test
    public void testDefaultValueAssignment() throws ValueDoesNotMatchTypeException {
        //Create project & configuration
        String valueForIntA = "5";
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        intA.setValue(valueForIntA);
        project.add(intA);
        configuration.refresh();
        
        //Test behavior of configuration
        IDecisionVariable variable = configuration.getDecision(intA);
        Assert.assertNotNull(variable);
        Assert.assertNotNull(variable.getValue());
        Assert.assertEquals(ValueFactory.createValue(intA.getType(), valueForIntA), variable.getValue());
    }
    
    /**
     * Tests the correct instantiation of decisions having a default value.
     * This test case test the behavior of compound assignments
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is an error in the configuration
     */
    @Test
    public void testDefaultValueAssignmentCompound() throws ValueDoesNotMatchTypeException {
        //Create project & configuration
        String valueForIntA = "5";
        Compound cmp = new Compound("CMP", project);
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, cmp);
        intA.setValue(valueForIntA);
        cmp.add(intA);
        project.add(cmp);
        DecisionVariableDeclaration cmpInstance = new DecisionVariableDeclaration("cp", cmp, project);
        project.add(cmpInstance);
        
        configuration.refresh();
        
        //Test behavior of configuration
        IDecisionVariable variable = configuration.getDecision(cmpInstance);
        Assert.assertNotNull(variable);
        Assert.assertNotNull(variable.getValue());
        Assert.assertNotNull(variable.getValue().isConfigured());
    }
    
    /**
     * Tests whether the configuration will be stored into a new project will be created.
     * This method does not tests the whole saving process,
     * instead the correct behavior depending to the given parameter is tested.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise a failure inside the {@link ValueFactory} exists
     * @throws ConfigurationException Must not occur otherwise a failure inside the
     * {@link IDecisionVariable#setValue(Value, IAssignmentState)} exists
     * @see #testToNewProject()
     */
    @Test
    public void testToOwnProject() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Create Project/Configuration with one (configured) variable.
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        IDecisionVariable varIntA = configuration.getDecision(intA);
        Value intAValue = ValueFactory.createValue(intA.getType(), "5");
        varIntA.setValue(intAValue, AssignmentState.ASSIGNED);
        
        // Save precondition
        int elementsInProject = project.getElementCount();
        
        // Save into same project
        Project confInSameProject = configuration.toProject(false);
        
        // Test post condition for saving into same project
        Assert.assertSame(project, confInSameProject);
        Assert.assertEquals(elementsInProject + 1, project.getElementCount());
    }
    
    /**
     * Tests whether the configuration will be stored into the related project.
     * This method does not tests the whole saving process,
     * instead the correct behavior depending to the given parameter is tested.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise a failure inside the {@link ValueFactory} exists
     * @throws ConfigurationException Must not occur otherwise a failure inside the
     * {@link IDecisionVariable#setValue(Value, IAssignmentState)} exists
     * @see #testToOwnProject()
     */
    @Test
    public void testToNewProject() throws ValueDoesNotMatchTypeException, ConfigurationException {
        // Create Project/Configuration with one (configured) variable.
        DecisionVariableDeclaration intA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(intA);
        configuration.refresh();
        IDecisionVariable varIntA = configuration.getDecision(intA);
        Value intAValue = ValueFactory.createValue(intA.getType(), "5");
        varIntA.setValue(intAValue, AssignmentState.ASSIGNED);
        
        // Save precondition
        int elementsInProject = project.getElementCount();
        
        // Save into different project
        Project confInNewProject = configuration.toProject(true);
        
        // Test post condition for saving into different project
        Assert.assertNotSame(project, confInNewProject);
        Assert.assertEquals(elementsInProject, project.getElementCount());
        Assert.assertEquals(elementsInProject, confInNewProject.getElementCount());
    }
    
    /**
     * Helping method for assigning values to a variable.
     * @param decl The Declaration inside the {@link #project}.
     * @param state The desired {@link IAssignmentState} state for the {@link IDecisionVariable}
     *     inside the {@link #configuration}.
     * @param value The value for the {@link IDecisionVariable}.
     */
    private void assignValue(AbstractVariable decl, IAssignmentState state, Object... value) {
        IDecisionVariable variable = configuration.getDecision(decl);
        try {
            Value variablesValue = ValueFactory.createValue(decl.getType(), value);
            variable.setValue(variablesValue, state);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Error in creating a value for a variable: " + e.getMessage());
        } catch (ConfigurationException e) {
            Assert.fail("Error in assigning a value to a variable: " + e.getMessage());
        }
    }
    
    /**
     * Checks whether a given declaration is in a given project.
     * @param declarations A List of declarations, retrieved by a
     * {@link de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder}.
     * @param decl The desired variable Declaration, which should (not) be included in the given list.
     * @param shouldBeFound <tt>true</tt> if the given declaration should be found in the given project,
     *     <tt>false</tt> otherwise.
     */
    private void checkDeclarationIsInList(List<AbstractVariable> declarations, AbstractVariable decl,
        boolean shouldBeFound) {
        
        boolean found = false;
        for (int i = 0; i < declarations.size(); i++) {
            AbstractVariable declarationOfList = declarations.get(i);
            if (declarationOfList.getName().equals(decl.getName())) {
                found = declarationOfList.getType() == decl.getType();
                break;
            }
        }
        
        if (shouldBeFound) {
            Assert.assertTrue("Declaration " + decl + " should be included in project, but is not.", found);
        } else {
            Assert.assertFalse("Declaration " + decl + " must not be included in project, but was found.", found);
        }
    }
    
    /**
     * Tests whether only user contents will be saved inside the configuration (derived values will be ignored).
     * @throws ConfigurationException 
     */
    @Test
    public void testSaveUserContentOnly() throws ConfigurationException {
        // Create project with configured variables in different states.
        DecisionVariableDeclaration intAssigned
            = new DecisionVariableDeclaration("intAssigned", IntegerType.TYPE, project);
        project.add(intAssigned);
        DecisionVariableDeclaration intDerived
            = new DecisionVariableDeclaration("intDerived", IntegerType.TYPE, project);
        project.add(intDerived);
        DecisionVariableDeclaration intFrozen
            = new DecisionVariableDeclaration("intFrozen", IntegerType.TYPE, project);
        project.add(intFrozen);
        configuration.refresh();
        // I like prime numbers ;-)
        assignValue(intAssigned, AssignmentState.ASSIGNED, "2");
        assignValue(intDerived, AssignmentState.DERIVED, "3");
        assignValue(intFrozen, AssignmentState.FROZEN, "5");
        
        // Save configuration into new project (easier for testing)
        Project confInNewProject = configuration.toProject(true);
        
        // Test post condition for saving into different project       
        Assert.assertEquals(3, confInNewProject.getElementCount());
        
        // Find all assigned variables of saved configuration
        ConstraintFinder cFinder = new ConstraintFinder(confInNewProject, false);
        List<Constraint> constraints = cFinder.getConstraints();
        List<AbstractVariable> declarations = new ArrayList<AbstractVariable>();
        for (int i = 0; i < constraints.size(); i++) {
            OCLFeatureCall call = (OCLFeatureCall) constraints.get(i).getConsSyntax();
            Variable var = (Variable) call.getOperand();
            declarations.add(var.getVariable());
        }
        checkDeclarationIsInList(declarations, intAssigned, true);
        checkDeclarationIsInList(declarations, intFrozen, true);
        checkDeclarationIsInList(declarations, intDerived, false);
        
        // Check frozen variables.
        FreezeBlockFinder fFinder = new FreezeBlockFinder(confInNewProject, FilterType.NO_IMPORTS);
        List<FreezeBlock> freezeBlocks = fFinder.getFreezeBlocks();
        Assert.assertEquals(1, freezeBlocks.size());
        FreezeBlock freezeBlock = freezeBlocks.get(0);
        Assert.assertEquals(1, freezeBlock.getFreezableCount());
        IFreezable frozenVar = freezeBlock.getFreezable(0);
        Assert.assertEquals(intFrozen.getName(), frozenVar.getName());
    }
     
    /**
     * Tests whether attributes are handled correctly inside the configuration.
     */
    @Test
    public void testAttributeHandling() {
        // Create project with attribute on project and on one variable
        Enum enum1 = new Enum("Enum1", project, "A", "B");
        project.add(enum1);
        Enum enum2 = new Enum("Enum2", project, "C", "D");
        project.add(enum2);
        Attribute projectAttr = new Attribute("projectAttribute", enum1, project, project);
        project.add(projectAttr);
        project.attribute(projectAttr);
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(decl1);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(decl2);
        Attribute vartAttr = new Attribute("variableAttribute", enum2, project, decl2);
        project.add(vartAttr);
        decl2.attribute(vartAttr);
        ProjectTestUtilities.validateProject(project);
        
        // Create config
        configuration.refresh();
        
        // Test correct number of Attributes in configuration.
        // var1/decl1 should have one attribute (project attribute)
        IDecisionVariable var1 = configuration.getDecision(decl1);
        Assert.assertEquals(1, var1.getAttributesCount());
        // var2/decl2 should have two attributes (project attribute and variable attribute)
        IDecisionVariable var2 = configuration.getDecision(decl2);
        Assert.assertEquals(2, var2.getAttributesCount());
    }
    
    /**
     * Tests whether a {@link ProjectInterface} is correctly considered by the {@link Configuration}.
     * @throws ModelManagementException Must not occur, otherwise {@link ProjectImport#setResolved(Project)}
     *     is broken.
     */
    @Test
    public void testProjectInterface() throws ModelManagementException {
        // Create Imported Project
        DecisionVariableDeclaration publicDecl
            = new DecisionVariableDeclaration("publicVar", IntegerType.TYPE, project);
        DecisionVariableDeclaration internalDecl
            = new DecisionVariableDeclaration("internalVar", IntegerType.TYPE, project);
        project.add(publicDecl);
        project.add(internalDecl);
        
        // Create Interface
        String interfaceName = "intf";
        ProjectInterface pInterface = new ProjectInterface(interfaceName,
            new DecisionVariableDeclaration[] {publicDecl}, project);
        project.add(pInterface);
        
        // Create Importing Project
        Project importingProject = new Project("importingProject");
        ProjectImport pImport = new ProjectImport(project.getName(), interfaceName);
        importingProject.addImport(pImport);
        
        // Test Correct Project Setting
        ProjectTestUtilities.validateProject(project);
        pImport.setResolved(project);
        Assert.assertNotNull(pImport.getResolved());
        ProjectTestUtilities.validateProject(importingProject);
        
        // Create Configuration for Importing Project
        Configuration config2 = new Configuration(importingProject);
        IDecisionVariable publicVar = config2.getDecision(publicDecl);
        IDecisionVariable internalVar = config2.getDecision(internalDecl);
        
        // Test correct behavior of importing project
        Assert.assertNotNull(publicDecl.getName() + " could not be found in " + importingProject.getName(), publicVar);
        Assert.assertNotNull(internalDecl.getName() + " could not be found in " + importingProject.getName(),
            internalVar);
        Assert.assertTrue(publicDecl.getName() + " should be exported, but is not.", publicVar.isVisible());
        Assert.assertFalse(internalDecl.getName() + " should NOT be exported, but IS.", internalVar.isVisible());
    }

}
