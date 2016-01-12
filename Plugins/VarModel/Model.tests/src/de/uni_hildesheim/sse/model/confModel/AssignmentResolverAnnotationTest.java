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
package de.uni_hildesheim.sse.model.confModel;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment.Assignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

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
     * Tests whether the annotations of an {@link IDecisionVariable} has the expected values.
     * @param expectedValue The expected value of the given annotation.
     * @param variable A variable for which its first annotation shall be tested.
     */
    private void assertAnnotationValue(Value expectedValue, IDecisionVariable variable) {
        Assert.assertNotNull("Error: Passed variable was null.", variable);

        // Annotation for the given variable
        Assert.assertEquals(1, variable.getAttributesCount());
        IDecisionVariable annotationVariable = variable.getAttribute(0);
        Assert.assertNotNull("Error: Variable \"" + variable.getDeclaration().getName() + "\" has no annotation." ,
            annotationVariable);
        Assert.assertNotNull("Error: Variable \"" + variable.getDeclaration().getName() + "\" has no annotation value."
            , annotationVariable.getValue());
        Assert.assertEquals("Error: Variable \"" + variable.getDeclaration().getName()
            + "\" has wrong annotation value.", expectedValue, annotationVariable.getValue());
    }
}
