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
package net.ssehub.easy.varModel.cstEvaluation;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the correct evaluation of {@link OclKeyWords#APPLY}.
 * @author El-Sharkawy
 *
 */
public class ApplyTests {
    
    /**
     * Tests whether the {@link EvaluationVisitor} can handle {@link OclKeyWords#APPLY} constraints, creating
     * a new set.
     */
    @Ignore
    @Test
    public void testApplySetCreation() {
        Project project = createTestProject("testApplySetCreation");
        
        // Create apply constraint
        ContainerOperationCall applyCst = createApplyConstraint(project);
        
        // Run evaluation visitor
        Configuration config = new Configuration(project, true);
        EvaluationVisitor evalVisitor = new EvaluationVisitor(config, null, false, null);
        applyCst.accept(evalVisitor);
        
        /* Test:
         * Evaluation visitor should not detect an error
         * Evaluation visitor should return a value for the apply constraint (a setOf(String) with two values)
         */
        Assert.assertFalse("EvaluationVisitor detected that the constraint was violated, but should not.",
            evalVisitor.constraintFailed());
//        Assert.assertTrue("EvaluationVisitor did not marked the constraint as fullfilled, but it should be the case.",
//            evalVisitor.constraintFulfilled());
        Value returnValue = evalVisitor.getResult();
        Assert.assertNotNull("Expected a setOf(String) to be returned, but <NULL> was returned.", returnValue);
        
        
    }

    /**
     * Creates the apply constraint, which creates a new set based on the second declaration of the project.
     * The constraint will be in form of:<br/>
     * <tt>strSet->apply(refTo(String) itr; setOf(String) innerSetType = {} | innerSetType.add(refBy(itr)))</tt><br/>
     * This constraint my be used for building further constraints or to test it directly with the evaluation visitor.
     * @param project The basis project to use {@link #createTestProject(String)}
     * @return The apply constraint.
     */
    private ContainerOperationCall createApplyConstraint(Project project) {
        AbstractVariable setDecl = (AbstractVariable) project.getElement(1);
        Container outerType = (Container) setDecl.getType();
        // Create 2 declarators
        Reference refType = (Reference) outerType.getContainedType();
        ExplicitTypeVariableDeclaration itrDecl = new ExplicitTypeVariableDeclaration("itr", refType, project);
        Set setType = new Set("innerSetType", refType.getType(), project);
        ExplicitTypeVariableDeclaration returnDecl = new ExplicitTypeVariableDeclaration("returnVar", setType, project);
        try {
            returnDecl.setValue();
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create empty default value for \"" + returnDecl.getName() + "\": " + e.getMessage());
        }
        
        // Create inner expression
        Variable returnVar = new Variable(returnDecl);
        Value refValue = null;
        try {
            refValue = ValueFactory.createValue(itrDecl.getType(), itrDecl);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create reference value for \"" + itrDecl.getName() + "\": " + e.getMessage());
        }
        ConstantValue refCSTValue = new ConstantValue(refValue);
        OCLFeatureCall expression = new OCLFeatureCall(returnVar, OclKeyWords.ADD, refCSTValue);
        
        // Create apply expression
        Variable outerVar = new Variable(setDecl);
        ContainerOperationCall applyCst = new ContainerOperationCall(outerVar, OclKeyWords.APPLY, expression, itrDecl,
            returnDecl);
        try {
            applyCst.inferDatatype();
        } catch (CSTSemanticException e) {
            Assert.fail("Could not infer datatype for apply constraint: " + e.getMessage());
        }
        return applyCst;
    }

    /**
     * Creates a test project, which may be extended further. <br/>
     * The project contains two declarations, in that order:
     * <ol>
     *   <li>sequenceOf(String)</li>
     *   <li>setOf(refTo(String))</li>
     * </ol>
     * @param projectName The name of the project to be created, should be the name of the test method to simplify
     *     error analysis.
     * @return The newly created project containing two declarations
     */
    private Project createTestProject(String projectName) {
        Project project = new Project(projectName);
        
        // Create String "array" with 3 values
        Sequence seqType = new Sequence("seqStringType", StringType.TYPE, project);
        DecisionVariableDeclaration seqDecl = new DecisionVariableDeclaration("strArray", seqType, project);
        try {
            seqDecl.setValue("Hello", " ", "World");
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not assign values to String sequence: " + e.getMessage());
        }
        project.add(seqDecl);
        
        // Create set of references to the array, with only 2 values
        Reference refType = new Reference("refType", StringType.TYPE, project);
        Set setType = new Set("setStringType", refType, project);
        DecisionVariableDeclaration setDecl = new DecisionVariableDeclaration("strSet", setType, project);
        ConstraintSyntaxTree refValue1 = createRefToSequenceCST(seqDecl, 0);
        ConstraintSyntaxTree refValue2 = createRefToSequenceCST(seqDecl, 2);
        try {
            Value setValue = ValueFactory.createValue(setType, new Object[] {refValue1, refValue2});
            setDecl.setValue(setValue);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create value for \"" + setDecl.getName() + "\": " + e.getMessage());
        }  
        project.add(setDecl);
        
        // Validate project before it is used for testing
        ProjectTestUtilities.validateProject(project);
        
        return project;
    }

    /**
     * Creates a reference to an item of the sequence.
     * @param decl A sequence declaration.
     * @param index The 0 based index of the element which shall be referenced.
     * @return A constraint representing the reference.
     */
    private ConstraintSyntaxTree createRefToSequenceCST(DecisionVariableDeclaration decl, int index) {
        ConstraintSyntaxTree refCST = null;
        try {
            ConstantValue constValue = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, index));
            refCST = new OCLFeatureCall(new Variable(decl), OclKeyWords.INDEX_ACCESS, constValue);
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not create index-based reference to values of \"" + decl.getName() + "\" for index \""
                + index + "\": " + e.getMessage());
        }
        return refCST;
    }

}
