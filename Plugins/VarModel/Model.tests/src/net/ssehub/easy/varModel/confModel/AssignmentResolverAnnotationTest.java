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
package net.ssehub.easy.varModel.confModel;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests for {@link AssignmentResolver}, whether it resolves {@link AttributeAssignment}s correctly.
 * @author El-Sharkawy
 *
 */
public class AssignmentResolverAnnotationTest {
    
    
    /**
     * Tests the correct assignment of annotations.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    @Test
    public void testAssignProjectAnnotation() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Creates a project with an annotation of the complete project
        Project project = new Project("testAssignProjectAnnotation");
        // Annotation for project
        Enum btType = new Enum("Bindingtime", project, "compile_time", "run_time");
        project.add(btType);
        Attribute btDecl = new Attribute("bindingtime", btType, project, project);
        Value compileValue = ValueFactory.createValue(btType, btType.getLiteral(0));
        ConstantValue constValCompiletime = new ConstantValue(compileValue);
        btDecl.setValue(constValCompiletime);
        project.add(btDecl);
        project.attribute(btDecl);
        // Two declarations, one nested, one not
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("intA", IntegerType.TYPE, project);
        project.add(declA);
        // Overwrite default annotation of second declaration
        AttributeAssignment assignBlock = new AttributeAssignment(project);
        Value runValue = ValueFactory.createValue(btType, btType.getLiteral(1));
        ConstantValue constValRuntime = new ConstantValue(runValue);
        Assignment assign = new Assignment(btDecl.getName(), OclKeyWords.ASSIGNMENT, constValRuntime);
        assignBlock.add(assign);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("intB", IntegerType.TYPE, assignBlock);
        assignBlock.add(declB);
        project.add(assignBlock);
        
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project, true);
        
        // Test correct behavior:
        // intA.bindingtime = compile_time
        // intB.bindingtime = run_time
        assertAnnotationValue(compileValue, config.getDecision(declA));
        assertAnnotationValue(runValue, config.getDecision(declB));
    }
    
    /**
     * Tests whether assignment blocks nested in compounds will be resolved correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    @Test
    public void testAssignmentBlockInCompounds() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project project = new Project("testAssignmentBlockInCompounds");
        // Annotation for project
        Enum btType = new Enum("Bindingtime", project, "compile_time", "run_time");
        project.add(btType);
        Attribute btDecl = new Attribute("bindingtime", btType, project, project);
        Value compileValue = ValueFactory.createValue(btType, btType.getLiteral(0));
        ConstantValue constValCompiletime = new ConstantValue(compileValue);
        btDecl.setValue(constValCompiletime);
        project.attribute(btDecl);
        project.add(btDecl);
        Compound cType = new Compound("Dimension", project);
        DecisionVariableDeclaration widthDecl = new DecisionVariableDeclaration("width", IntegerType.TYPE, cType);
        cType.add(widthDecl);
        // Overwrite default annotation of second declaration
        AttributeAssignment assignBlock = new AttributeAssignment(cType);
        Value runValue = ValueFactory.createValue(btType, btType.getLiteral(1));
        ConstantValue constValRuntime = new ConstantValue(runValue);
        Assignment assign = new Assignment(btDecl.getName(), OclKeyWords.ASSIGNMENT, constValRuntime);
        assignBlock.add(assign);
        DecisionVariableDeclaration heightDecl = new DecisionVariableDeclaration("height", IntegerType.TYPE,
            assignBlock);
        assignBlock.add(heightDecl);
        cType.add(assignBlock);
        project.add(cType);
        DecisionVariableDeclaration dimDecl = new DecisionVariableDeclaration("dimension", cType, project);
        project.add(dimDecl);
        
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project, true);
        
        // Test correct behavior:
        // dimension = compile_time
        // dimension.width = compile_time
        // dimension.height = run_time
        IDecisionVariable dimVar = config.getDecision(dimDecl);
        IDecisionVariable widthVar = null;
        IDecisionVariable heightVar = null;
        for (int i = 0; i < dimVar.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = dimVar.getNestedElement(i);
            if (widthDecl == nestedVar.getDeclaration()) {
                widthVar = nestedVar;
            } else if (heightDecl == nestedVar.getDeclaration()) {
                heightVar = nestedVar;
            }
        }
        assertAnnotationValue(compileValue, dimVar);
        assertAnnotationValue(compileValue, widthVar);
        assertAnnotationValue(runValue, heightVar);
    }
    
    /**
     * Tests whether assignment blocks and assignment statements are considered correctly.
     * A (re-)assigned value should overwrite the value from the assignment block.
     * @throws ValueDoesNotMatchTypeException Must not occur otherwise there is a failure inside the
     * {@link ValueFactory}.
     * @throws CSTSemanticException Must not occur otherwise there is a failure inside the constraint syntax trees.
     */
    @Test
    public void testAssignmentBlockAndAssignmentStatements() throws ValueDoesNotMatchTypeException,
        CSTSemanticException {
        
        Project project = new Project("testAssignmentBlockAndAssignmentStatements");
        // Annotation for project
        Enum btType = new Enum("Bindingtime", project, "compile_time", "run_time");
        project.add(btType);
        Attribute btDecl = new Attribute("bindingtime", btType, project, project);
        Value compileValue = ValueFactory.createValue(btType, btType.getLiteral(0));
        ConstantValue constValCompiletime = new ConstantValue(compileValue);
        btDecl.setValue(constValCompiletime);
        project.attribute(btDecl);
        project.add(btDecl);
        Compound cType = new Compound("Dimension", project);
        DecisionVariableDeclaration widthDecl = new DecisionVariableDeclaration("width", IntegerType.TYPE, cType);
        cType.add(widthDecl);
        // Overwrite default annotation of second declaration
        AttributeAssignment assignBlock = new AttributeAssignment(cType);
        Value runValue = ValueFactory.createValue(btType, btType.getLiteral(1));
        ConstantValue constValRuntime = new ConstantValue(runValue);
        Assignment assign = new Assignment(btDecl.getName(), OclKeyWords.ASSIGNMENT, constValRuntime);
        assignBlock.add(assign);
        DecisionVariableDeclaration heightDecl = new DecisionVariableDeclaration("height", IntegerType.TYPE,
                assignBlock);
        assignBlock.add(heightDecl);
        cType.add(assignBlock);
        project.add(cType);
        DecisionVariableDeclaration dimDecl1 = new DecisionVariableDeclaration("dimension1", cType, project);
        project.add(dimDecl1);
        DecisionVariableDeclaration dimDecl2 = new DecisionVariableDeclaration("dimension2", cType, project);
        project.add(dimDecl2);
        // Re assign value for second instance
        Constraint reassignment = new Constraint(project);
        AttributeVariable annotationVar = new AttributeVariable(new CompoundAccess(new Variable(dimDecl2),
            heightDecl.getName()), btDecl);
        OCLFeatureCall call = new OCLFeatureCall(annotationVar, OclKeyWords.ASSIGNMENT, constValCompiletime);
        reassignment.setConsSyntax(call);
        project.add(reassignment);
        
        ProjectTestUtilities.validateProject(project);
        Configuration config = new Configuration(project, true);
        
        // Test correct behavior:
        // dimension1 = compile_time
        // dimension1.width = compile_time
        // dimension1.height = run_time
        // dimension2 = compile_time
        // dimension2.width = compile_time
        // --> dimension2.height = compile_time <--
        IDecisionVariable dimVar1 = config.getDecision(dimDecl1);
        IDecisionVariable[] slots = getSlotsOfDimensionVariable(dimVar1, widthDecl, heightDecl);
        IDecisionVariable widthVar = slots[0];
        IDecisionVariable heightVar = slots[1];
        assertAnnotationValue(compileValue, dimVar1);
        assertAnnotationValue(compileValue, widthVar);
        assertAnnotationValue(runValue, heightVar);
        
        IDecisionVariable dimVar2 = config.getDecision(dimDecl2);
        slots = getSlotsOfDimensionVariable(dimVar2, widthDecl, heightDecl);
        widthVar = slots[0];
        heightVar = slots[1];
        assertAnnotationValue(compileValue, dimVar2);
        assertAnnotationValue(compileValue, widthVar);
        assertAnnotationValue(compileValue, heightVar);
    }

    /**
     * Extracts the slot {@link IDecisionVariable}s for the {@link IDecisionVariable} instance of the dimension
     * compound used in the examples here. Will retrieve the correct slots independent of the implementation
     * of compounds.
     * @param dimVar1 A compound instance for which the slots shall be retrieved.
     * @param delcarations The declarations of directed nested slots, must not be <b>null</b>.
     * @return The {@link IDecisionVariable} instances of the slots, in the same order as passed to this method.
     */
    private IDecisionVariable[] getSlotsOfDimensionVariable(IDecisionVariable dimVar1, 
        AbstractVariable... delcarations) {
        
        IDecisionVariable[] slotVars = new IDecisionVariable[delcarations.length];
        for (int i = 0; i < dimVar1.getNestedElementsCount(); i++) {
            IDecisionVariable nestedVar = dimVar1.getNestedElement(i);
            boolean found = false;
            for (int j = 0; j < slotVars.length && !found; j++) {
                if (delcarations[j] == nestedVar.getDeclaration()) {
                    slotVars[j] = nestedVar;
                    found = true;
                }
            }
        }
        
        return slotVars;
    }

    /**
     * Tests whether the annotations of an {@link IDecisionVariable} has the expected values.
     * @param expectedValue The expected value of the given annotation.
     * @param variable A variable for which its first annotation shall be tested.
     */
    private void assertAnnotationValue(Value expectedValue, IDecisionVariable variable) {
        Assert.assertNotNull("Error: Passed variable was null.", variable);

        // Annotation for the given variable
        Assert.assertEquals(1, variable.getAttributesCount());
        IDecisionVariable annotationVariable = variable.getAttribute(0);
        Assert.assertNotNull("Error: Variable \"" + variable.getQualifiedName() + "\" has no annotation." ,
            annotationVariable);
        Assert.assertNotNull("Error: Variable \"" + variable.getQualifiedName() + "\" has no annotation value."
            , annotationVariable.getValue());
        Assert.assertEquals("Error: Variable \"" + variable.getQualifiedName()
            + "\" has wrong annotation value.", expectedValue, annotationVariable.getValue());
    }
}
