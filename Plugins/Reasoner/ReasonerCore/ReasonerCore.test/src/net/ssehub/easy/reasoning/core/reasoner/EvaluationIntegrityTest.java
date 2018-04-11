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
package net.ssehub.easy.reasoning.core.reasoner;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests for {@link Resolver}.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public class EvaluationIntegrityTest extends AbstractTest {
    
    // Test: testResolveOfIntegers()
    private Project projectP0;
    private Project projectP1;
    private Project projectP2;    
    
    private DecisionVariableDeclaration declA;
    private DecisionVariableDeclaration declB;
    private DecisionVariableDeclaration declC;
    private DecisionVariableDeclaration declD;

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected EvaluationIntegrityTest(ITestDescriptor descriptor) {
        super(descriptor, null);
    }
    
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
        createProjectP0();
        createProjectP1();    
        createProjectP2();        
        
        Configuration config = new Configuration(projectP2, false);
        ReasonerConfiguration rConfig = new ReasonerConfiguration();
     
        IReasoner reasoner = createReasoner();
        reasoner.propagate(projectP2, config, rConfig, ProgressObserver.NO_OBSERVER);
        
        assertVariable(config, declA, 2, AssignmentState.DERIVED);
        assertVariable(config, declB, 2, AssignmentState.DERIVED);
        assertVariable(config, declC, 3, AssignmentState.DERIVED);
        assertVariable(config, declD, 5, AssignmentState.DERIVED);
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
     * Creates imported project P0.
     * <pre><code>
     * project ProjectP0 {
     *
     *    Integer intA;
     *    Integer intB;
     *    intA = 1;
     *    intB = intA;
     *}
     *</code></pre>
     */
    private void createProjectP0() {
        projectP0 = new Project("ProjectP0");
        declA = createVar("intA", projectP0);
        declB = createVar("intB", projectP0);
        Constraint constraintA = new Constraint(projectP0);
        Constraint constraintB = new Constraint(projectP0);
        try {
            constraintA.setConsSyntax(createAssignment(declA, createConstValue(declA, 1)));
            projectP0.add(constraintA);
            constraintB.setConsSyntax(createAssignment(declB, new Variable(declA)));
            projectP0.add(constraintB);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectP0);
    }
    
    /**
     * Creates imported project P1.
     * <pre><code>
     * project ProjectP1 {
     *    import ProjectP0;
     *
     *    intA = 2;
     *}
     *</code></pre>
     */
    private void createProjectP1() {
        projectP1 = new Project("ProjectP1");
        ProjectImport importP0 = new ProjectImport(projectP0.getName(), null);
        projectP1.addImport(importP0);       
        try {
            importP0.setResolved(projectP0);            
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        
        Constraint constraint = new Constraint(projectP1);
        try {
            constraint.setConsSyntax(createAssignment(declA, createConstValue(declA, 2)));
            projectP1.add(constraint);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectP1);
    }  
    
    /**
     * Creates top imported project.
     * <pre><code>
     * project ProjectP2 {
     *
     *    import ProjectP1;
     *    
     *    Integer intC;
     *    intC = 1;
     *    intC == 1 implies intA == 3;;
     *}
     *</code></pre>
     */
    private void createProjectP2() {
        projectP2 = new Project("ProjectP2");
        ProjectImport importP1 = new ProjectImport(projectP1.getName(), null);
        projectP2.addImport(importP1);       
        try {
            importP1.setResolved(projectP1);            
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        }
        
        declC = createVar("intC", projectP2);
        Constraint constraintC = new Constraint(projectP2);
        try {
            constraintC.setConsSyntax(createAssignment(declC, createConstValue(declC, 3)));
            projectP2.add(constraintC);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        declD = createVar("intD", projectP2);
        Constraint constraintD = new Constraint(projectP2);
        OCLFeatureCall plus = new OCLFeatureCall(new Variable(declC), OclKeyWords.PLUS, new Variable(declA));
        try {
            constraintD.setConsSyntax(createAssignment(declD, plus));
            projectP2.add(constraintD);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        Constraint constraintImplies = new Constraint(projectP2);
        OCLFeatureCall left = new OCLFeatureCall(new Variable(declC), OclKeyWords.EQUALS, createConstValue(declC, 1));
        OCLFeatureCall right 
            = new OCLFeatureCall(new Variable(declA), OclKeyWords.EQUALS, createConstValue(declA, 3));        
        OCLFeatureCall implies = new OCLFeatureCall(left, OclKeyWords.IMPLIES, right);
        try {
            constraintImplies.setConsSyntax(implies); 
            projectP2.add(constraintImplies);
        } catch (CSTSemanticException e) {
            Assert.fail(e.getMessage());
        }
        
        ProjectTestUtilities.validateProject(projectP2);
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

}
