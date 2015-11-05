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

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests for {@link AssignmentResolver}.
 * @author El-Sharkawy
 *
 */
public class AssignmentResolverTest {
    
    // Test: testResolveOfIntegers()
    private Project projectA;
    private Project projectB;
    private Project projectC;
    private Project projectD;
    private Project projectE;
    
    private DecisionVariableDeclaration declA;
    private DecisionVariableDeclaration declB;
    private DecisionVariableDeclaration declC;
    private DecisionVariableDeclaration declD;

    // Test: testResolveOfCompounds()
    private Project cmpProject;
    private DecisionVariableDeclaration cmp1;
    private DecisionVariableDeclaration cmp2;
    private DecisionVariableDeclaration cmp3;
    
    /**
     * Tests whether integer variables are resolved correctly.
     * This tests includes:
     * <ul>
     * <li>Imports</li>
     * <li>Assignments</li>
     * <li>Defaults</li>
     * <li>Re-Assignments</li>
     * </ul>
     */
    @Test
    public void testResolveOfIntegers() {
        createProjectA();
        createProjectB();    
        createProjectC();
        // d uses values of a, c and re-assignes b
        createProjectD();
        // re-assigns a
        createProjectE();
        
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(projectE, true);
        assertVariable(config, declA, 13, AssignmentState.ASSIGNED);
        assertVariable(config, declB, 3, AssignmentState.ASSIGNED);
        assertVariable(config, declC, 2, AssignmentState.DEFAULT);
        assertVariable(config, declD, 7, AssignmentState.DEFAULT);
    }
    
    /**
     * Tests whether assignments were correctly applied.
     * @param config The configuration containing resolved variables.
     * @param decl The declaration to test.
     * @param expectedValue The expected resolved value
     * @param expectedState The expected resolved assignment state
     */
    private void assertVariable(Configuration config, DecisionVariableDeclaration decl, Object expectedValue,
        IAssignmentState expectedState) {
        
        IDecisionVariable variable = config.getDecision(decl);
        Assert.assertNotNull(variable);
        Assert.assertNotNull(variable.getValue());
        Assert.assertEquals(expectedValue, variable.getValue().getValue());
        Assert.assertEquals(expectedState, variable.getState());
    }

    /**
     * Creates imported project.
     * <pre><code>
     * project ProjectA {
     *
     *    Integer intA = 5;
     *}
     *</code></pre>
     */
    private void createProjectA() {
        projectA = new Project("ProjectA");
        declA = createVar("intA", projectA);
        try {
            declA.setValue(createConstValue(declA, 5));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectA);
    }
    
    /**
     * Creates imported project.
     * <pre><code>
     * project ProjectB {
     *
     *    Integer intB;
     *    intB = 11;
     *}
     *</code></pre>
     */
    private void createProjectB() {
        projectB = new Project("ProjectB");
        declB = createVar("intB", projectB);
        Constraint constraint = new Constraint(projectB);
        try {
            constraint.setConsSyntax(createAssignment(declB, createConstValue(declB, 11)));
            projectB.add(constraint);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectB);
    }
    
    /**
     * Creates imported project.
     * <pre><code>
     * project ProjectC {
     *
     *    Integer intC = 2;
     *}
     *</code></pre>
     */
    private void createProjectC() {
        projectC = new Project("ProjectC");
        declC = createVar("intC", projectC);
        try {
            declC.setValue(createConstValue(declC, 2));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectC);
    }
    
    /**
     * Creates top imported project.
     * <pre><code>
     * project ProjectD {
     *
     *    import ProjectA;
     *    import ProjectB;
     *    import ProjectC;
     *    
     *    Integer intD = intA + intC;
     *    intB = 3;
     *}
     *</code></pre>
     */
    private void createProjectD() {
        projectD = new Project("ProjectD");
        ProjectImport importA = new ProjectImport(projectA.getName(), null);
        projectD.addImport(importA);
        ProjectImport importB = new ProjectImport(projectB.getName(), null);
        projectD.addImport(importB);
        ProjectImport importC = new ProjectImport(projectC.getName(), null);
        projectD.addImport(importC);
        try {
            importA.setResolved(projectA);
            importB.setResolved(projectB);
            importC.setResolved(projectC);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        
        declD = createVar("intD", projectD);
        // intD = intA + intC
        OCLFeatureCall plus = new OCLFeatureCall(new Variable(declA), OclKeyWords.PLUS, new Variable(declC));
        try {
            declD.setValue(plus);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        // intB = 3;
        Constraint constraint = new Constraint(projectD);
        try {
            constraint.setConsSyntax(createAssignment(declB, createConstValue(declB, 3)));
            projectD.add(constraint);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectD);
    }
    
    /**
     * Creates main project.
     * <pre><code>
     * project ProjectE {
     *
     *    import ProjectD;
     *    
     *    intA = 13;
     *}
     *</code></pre>
     */
    private void createProjectE() {
        projectE = new Project("ProjectE");
        ProjectImport importD = new ProjectImport(projectD.getName(), null);
        try {
            importD.setResolved(projectD);
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        projectE.addImport(importD);
        
        // intA = 12
        Constraint constraint = new Constraint(projectE);
        OCLFeatureCall assignment = new OCLFeatureCall(new Variable(declA), OclKeyWords.ASSIGNMENT,
            createConstValue(declA, 13));
        try {
            constraint.setConsSyntax(assignment);
            projectE.add(constraint);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectE);
    }

    /**
     * Creates a new integer {@link DecisionVariableDeclaration} in the given {@link Project}.
     * @param varName The name of the {@link DecisionVariableDeclaration}.
     * @param project The project where to add the {@link DecisionVariableDeclaration}.
     * @return The created {@link DecisionVariableDeclaration}.
     */
    private DecisionVariableDeclaration createVar(String varName, Project project) {
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration(varName, IntegerType.TYPE, project);
        project.add(decl);
        return decl;
    }

    /**
     * Creates a {@link ConstantValue} for a given {@link DecisionVariableDeclaration}.
     * @param decl The {@link DecisionVariableDeclaration} for which the {@link ConstantValue} shall be created.
     * @param value The value to create.
     * @return The created {@link ConstraintSyntaxTree}.
     */
    private ConstraintSyntaxTree createConstValue(DecisionVariableDeclaration decl, Object... value) {
        ConstantValue constValue = null;
        try {
            constValue = new ConstantValue(ValueFactory.createValue(decl.getType(), value));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        }
        
        return constValue;
    }
    
    /**
     * Creates an assignment {@link ConstraintSyntaxTree}.
     * @param decl The {@link DecisionVariableDeclaration} for which an assignment shall be created for.
     * @param value The value of the assignment constraint.
     * @return The created assignment {@link ConstraintSyntaxTree}.
     */
    private ConstraintSyntaxTree createAssignment(DecisionVariableDeclaration decl, ConstraintSyntaxTree value) {
        return new OCLFeatureCall(new Variable(decl), OclKeyWords.ASSIGNMENT, value);
    }
    
    /**
     * Tests whether compound variables are resolved correctly.
     * This tests includes:
     * <ul>
     * <li>Defaults of slots</li>
     * <li>Assignment of compounds/slots</li>
     * <li>Re-Defaults of slots</li>
     * <li>Re-Assignments compounds</li>
     * </ul>
     */
    @Test
    public void testResolveOfCompounds() {
        createCompoundProject();
        
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(cmpProject, true);
        assertCompoundValue(config, cmp1, new Object[] {5, 7, 2, 3});
        assertCompoundValue(config, cmp2, new Object[] {11, 13, 17, 19});
        assertCompoundValue(config, cmp3, new Object[] {31, 7, 23, 29});
    }
    
    /**
     * Tests the correct assignments of a compound.
     * @param config The configuration to test.
     * @param decl One of {@link #cmp1}, {@link #cmp2}, {@link #cmp3}
     * @param expectedValues The expected values for the given declaration. As follows:
     * <code>slot1.a, slot1.b, slot2.a, slot2.b</code>
     */
    private void assertCompoundValue(Configuration config, DecisionVariableDeclaration decl, Object[] expectedValues) {
        CompoundValue value = (CompoundValue) config.getDecision(decl).getValue();
        CompoundValue slot1Value = (CompoundValue) value.getNestedValue("slot1");
        CompoundValue slot2Value = (CompoundValue) value.getNestedValue("slot2");
        Assert.assertNotNull("Slot1 must not be null, but it is.", slot1Value);
        Assert.assertNotNull("Slot2 must not be null, but it is.", slot2Value);
        
        Value slot1aValue = slot1Value.getNestedValue("a");
        Value slot1bValue = slot1Value.getNestedValue("b");
        Value slot2aValue = slot2Value.getNestedValue("a");
        Value slot2bValue = slot2Value.getNestedValue("b");
        
        Assert.assertEquals(expectedValues[0], slot1aValue.getValue());
        Assert.assertEquals(expectedValues[1], slot1bValue.getValue());
        Assert.assertEquals(expectedValues[2], slot2aValue.getValue());
        Assert.assertEquals(expectedValues[3], slot2bValue.getValue());
    }

    /**
     * Creates the project for {@link #testResolveOfCompounds()}. Will create:
     * <pre><code>
     * project cmpProject {
     *
     *    compound CP1 {
     *        Integer a = 2;
     *        Integer b = 3;
     *    }
     *
     *    compound CP2 {
     *        CP1 slot1 = {a = 5, b = 7};
     *        CP1 slot2;
     *    }
     *
     *    CP2 cmp1;
     *    CP2 cmp2 = {slot1 = {a = 11, b = 13}, slot2 = {a = 17, b = 19}};
     *    CP2 cmp3 = {slot2 = {a = 23, b = 29}};
     *    cmp3.slot1.a = 31;
     *}
     *</code></pre>
     */
    private void createCompoundProject() {
        cmpProject = new Project("cmpProject");
        Compound cpType1 = new Compound("CP1", cmpProject);
        DecisionVariableDeclaration a = new DecisionVariableDeclaration("a", IntegerType.TYPE, cpType1);
        DecisionVariableDeclaration b = new DecisionVariableDeclaration("b", IntegerType.TYPE, cpType1);
        try {
            a.setValue(createConstValue(a, 2));
            b.setValue(createConstValue(b, 3));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        cpType1.add(a);
        cpType1.add(b);
        cmpProject.add(cpType1);
        
        Compound cpType2 = new Compound("CP2", cmpProject);
        DecisionVariableDeclaration slot1 = new DecisionVariableDeclaration("slot1", cpType1, cpType2);
        DecisionVariableDeclaration slot2 = new DecisionVariableDeclaration("slot2", cpType1, cpType2);
        try {
            slot1.setValue(createConstValue(slot1, new Object[]{"a", 5, "b", 7}));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        cpType2.add(slot1);
        cpType2.add(slot2);
        cmpProject.add(cpType2);
        
        cmp1 = new DecisionVariableDeclaration("cmp1", cpType2, cmpProject);
        cmp2 = new DecisionVariableDeclaration("cmp2", cpType2, cmpProject);
        try {
            cmp2.setValue(new Object[] {"slot1", new Object[] {"a", 11, "b", 13},
                "slot2", new Object[] {"a", 17, "b", 19}});
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        }
        cmp3 = new DecisionVariableDeclaration("cmp3", cpType2, cmpProject);
        try {
            cmp3.setValue(new Object[] {"slot2", new Object[] {"a", 23, "b", 29}});
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        }
        cmpProject.add(cmp1);
        cmpProject.add(cmp2);
        cmpProject.add(cmp3);
        
        try {
            Constraint constraint = new Constraint(cmpProject);
            CompoundAccess slot1Access = new CompoundAccess(new Variable(cmp3), "slot1");
            CompoundAccess slot1aAccess = new CompoundAccess(slot1Access, "a");
            ConstantValue constValue = new ConstantValue(ValueFactory.createValue(a.getType(), 31));
            OCLFeatureCall assignment = new OCLFeatureCall(slot1aAccess, OclKeyWords.ASSIGNMENT, constValue);
            constraint.setConsSyntax(assignment);
            cmpProject.add(constraint);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(cmpProject);
    }
    /**
     * Tests whether dependent constraints will be resolved (in a loop).
     * <pre><code>
     * project loopingTest {
     *
     *    Integer intA;
     *    Integer intB;
     *    intA = intB;
     *    intB = 5;
     *}
     * </code></pre>
     */
    @Test
    public void testDependentConstraintResolving() {
        Project project = new Project("loopingTest");
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(decl1);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(decl2);
        try {
            OCLFeatureCall assignment1 = new OCLFeatureCall(new Variable(decl1), OclKeyWords.ASSIGNMENT,
                new Variable(decl2));
            Constraint constraint1 = new Constraint(project);
            constraint1.setConsSyntax(assignment1);
            project.add(constraint1);
            
            OCLFeatureCall assignment2 = new OCLFeatureCall(new Variable(decl2), OclKeyWords.ASSIGNMENT,
                new ConstantValue(ValueFactory.createValue(decl2.getType(), 5)));
            Constraint constraint2 = new Constraint(project);
            constraint2.setConsSyntax(assignment2);
            project.add(constraint2);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        }
        ProjectTestUtilities.validateProject(project);
        
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        IDecisionVariable var1 = config.getDecision(decl1);
        IDecisionVariable var2 = config.getDecision(decl2);
        Assert.assertNotNull(var1.getValue());
        Assert.assertEquals(5, var1.getValue().getValue());
        Assert.assertNotNull(var2.getValue());
        Assert.assertEquals(5, var2.getValue().getValue());
        
    }
    
    /**
     * Tests whether dependent default values will be resolved (in a loop).
     * <pre><code>
     * project loopingDefaultTest {
     *
     *    Integer intA = 1 + intB;
     *    Integer intB = 2;
     *}
     * </code></pre>
     */
    @Test
    public void testDependentDefaultValueResolving() {
        Project project = new Project("loopingDefaultTest");
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(decl1);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(decl2);
        try {
            ConstantValue value1 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "1"));            
            OCLFeatureCall defaultValue1 = new OCLFeatureCall(value1, OclKeyWords.PLUS,
                new Variable(decl2));
            decl1.setValue(defaultValue1);
            
            ConstantValue value2 = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, "2"));
            decl2.setValue(value2);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail(e.getMessage());
        }
        ProjectTestUtilities.validateProject(project, true);
        
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        IDecisionVariable var1 = config.getDecision(decl1);
        IDecisionVariable var2 = config.getDecision(decl2);
        Assert.assertNotNull(var1.getValue());
        Assert.assertEquals(3, var1.getValue().getValue());
        Assert.assertNotNull(var2.getValue());
        Assert.assertEquals(2, var2.getValue().getValue());
        
    }
    
    /**
     * Tests whether implies constraints will be handled correctly by the {@link AssignmentResolver}.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException  Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    @Test
    public void testImplies() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create project and variables
        Project project = new Project("assignmentTestProject");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, project);
        project.add(declB);
        DecisionVariableDeclaration declC = new DecisionVariableDeclaration("intC", IntegerType.TYPE, project);
        declC.setValue(33);
        project.add(declC);
        
        // Create assignment
        Value valA = ValueFactory.createValue(declA.getType(), 31);
        Variable varA = new Variable(declA);
        ConstantValue constValA = new ConstantValue(valA);
        OCLFeatureCall assignmentA = new OCLFeatureCall(varA, OclKeyWords.ASSIGNMENT, constValA);
        Constraint assignmentConstraint = new Constraint(project);
        assignmentConstraint.setConsSyntax(assignmentA);
        project.add(assignmentConstraint);       
   
        
        // Create implies constraint
        Value valB = ValueFactory.createValue(declB.getType(), 37);
        ConstantValue constValB = new ConstantValue(valB);
        Value valC = ValueFactory.createValue(declC.getType(), 40);
        ConstantValue constValC = new ConstantValue(valC);
        OCLFeatureCall equalsA = new OCLFeatureCall(varA, OclKeyWords.EQUALS, constValA);
        OCLFeatureCall equalsB = new OCLFeatureCall(new Variable(declB), OclKeyWords.EQUALS, constValB);
        OCLFeatureCall equalsC = new OCLFeatureCall(new Variable(declC), OclKeyWords.EQUALS, constValC);
        OCLFeatureCall implies = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsB);
        OCLFeatureCall impliesFail = new OCLFeatureCall(equalsA, OclKeyWords.IMPLIES, equalsC);
        Constraint impliesConstaint = new Constraint(project);
        impliesConstaint.setConsSyntax(implies);
        project.add(impliesConstaint);
        Constraint impliesConstaintFail = new Constraint(project);
        impliesConstaintFail.setConsSyntax(impliesFail);
        project.add(impliesConstaintFail);
        
        
        // Create Configuration (will also start AssignmentResolver)
        // Configuration must be started with AssignmentResolver, since Reasoner is not available in this project.
        Configuration config = new Configuration(project, true);
        IDecisionVariable iVarA = config.getDecision(declA);
        IDecisionVariable iVarB = config.getDecision(declB);
        IDecisionVariable iVarC = config.getDecision(declC);
        
        // Test correct assignments
        Assert.assertNotNull(iVarA);
        Assert.assertEquals(31, iVarA.getValue().getValue());
        Assert.assertSame(AssignmentState.ASSIGNED, iVarA.getState());

        Assert.assertNotNull(iVarB);
        Assert.assertEquals(37, iVarB.getValue().getValue());
        Assert.assertSame(AssignmentState.ASSIGNED, iVarB.getState());
        
        Assert.assertNotNull(iVarC);
        Assert.assertEquals(33, iVarC.getValue().getValue());
        Assert.assertSame(AssignmentState.DEFAULT, iVarC.getState());
    }
}
