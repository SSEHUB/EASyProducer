/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.varModel.copy;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.copy.FrozenConstraintsOmitter;
import de.uni_hildesheim.sse.model.varModel.copy.ModelElementOmitter;
import de.uni_hildesheim.sse.model.varModel.copy.ProjectCopyVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IntegerType;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.persistency.StringProvider;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the {@link ProjectCopyVisitor} and especially whether the specified elements can be filtered without removing
 * the other elements.
 * @author El-Sharkawy
 *
 */
public class ProjectCopyVisitorTest {
    
    /**
     * Tests whether filtering of comments works.
     */
    @Test
    public void testOmmitComments() {
        // Create original project with one declaration and one comment
        Project p = new Project("testProject");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("aDeclaration", IntegerType.TYPE, p);
        p.add(decl);
        Comment cmt = new Comment("    //A comment\n", p);
        p.add(cmt);
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        
        // Create copy while omitting the comment
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.NO_IMPORTS);
        copynator.addModelCopyModifier(new ModelElementOmitter(Comment.class));
        p.accept(copynator);
        Project copy = copynator.getCopyiedProject();
        
        // Copied project should contain the declaration, but not the comment
        ProjectTestUtilities.validateProject(copy);
        assertProjectContainment(copy, cmt, false, 1);
        assertProjectContainment(copy, decl, true, 1);
    }
    
    /**
     * Tests whether filtering of constraints which contain only frozen variables work.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link de.uni_hildesheim.sse.model.varModel.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testOmmitFrozenConstraint() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with two declarations, 2 constraints, and freeze one of these variables
        Project p = new Project("testProject");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("varA", IntegerType.TYPE, p);
        declA.setValue(10);
        p.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("varB", IntegerType.TYPE, p);
        declB.setValue(10);
        p.add(declB);
        Constraint constraintA = new Constraint(p);
        OCLFeatureCall comparisonA = new OCLFeatureCall(new Variable(declA), OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 5)));
        constraintA.setConsSyntax(comparisonA);
        p.add(constraintA);
        Constraint constraintB = new Constraint(p);
        OCLFeatureCall comparisonB = new OCLFeatureCall(new Variable(declB), OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 5)));
        constraintB.setConsSyntax(comparisonB);
        p.add(constraintB);
        p.add(new FreezeBlock(new IFreezable[] {declA}, null, null, p));
        // Project should be valid        
        ProjectTestUtilities.validateProject(p);
        
        // Create copy while omitting "frozen" constraints
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.NO_IMPORTS);
        FrozenElementsFinder finder = new FrozenElementsFinder(p, FilterType.ALL);
        FrozenConstraintsOmitter ommiter = new FrozenConstraintsOmitter(finder.getFrozenElements());
        copynator.addModelCopyModifier(ommiter);
        p.accept(copynator);
        Project copy = copynator.getCopyiedProject();
        
        // Copied project should contain the first constraint (constraintA)
        ProjectTestUtilities.validateProject(copy);
        assertProjectContainment(copy, constraintA, false, 4);
        assertProjectContainment(copy, constraintB, true, 4);
    }
    
    /**
     * Tests whether imports will be copied correctly.
     * @throws ModelManagementException Must not occur,
     * otherwise is the {@link ProjectImport#setResolved(Project)} broken.
     */
    @Test
    public void testPreserveImports() throws ModelManagementException {
        // Create inner imported Project
        Project importedProject2 = new Project("importedProject2");
        ProjectImport pImport2 = new ProjectImport(importedProject2.getName());
        pImport2.setResolved(importedProject2);
        // Create first imported project
        Project importedProject1 = new Project("importedProject1");
        ProjectImport pImport1 = new ProjectImport(importedProject1.getName());
        importedProject1.addImport(pImport2);
        pImport1.setResolved(importedProject1);
        // Create main project with the import
        Project p = new Project("mainTestProject");
        p.addImport(pImport1);
        ProjectTestUtilities.validateProject(p);
        
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.ALL);
        p.accept(copynator);
        Project copy = copynator.getCopyiedProject();
        // Test main Project and its import
        Project importedCopy = assertProjectImport(p, copy);
        // Test first import
        assertProjectImport(importedProject1, importedCopy);
    }
    /**
     * Tests whether imports will be copied correctly.
     * @throws ModelManagementException Must not occur,
     * otherwise is the {@link ProjectImport#setResolved(Project)} broken.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link de.uni_hildesheim.sse.model.varModel.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testPreserveImportsWithContent() throws ValueDoesNotMatchTypeException, CSTSemanticException,
        ModelManagementException {
        
        // Create first imported project
        Project importedProject = new Project("importedProject");
        ProjectImport pImport1 = new ProjectImport(importedProject.getName());
        pImport1.setResolved(importedProject);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("intA", IntegerType.TYPE, importedProject);
        importedProject.add(decl);
        // Create main project with the import
        Project p = new Project("mainTestProject");
        p.addImport(pImport1);
        Constraint constraint = new Constraint(p);
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(decl), OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 42)));
        constraint.setConsSyntax(comparison);
        p.add(constraint);
        ProjectTestUtilities.validateProject(p);
        
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.ALL);
        p.accept(copynator);
        Project copy = copynator.getCopyiedProject();
        ProjectTestUtilities.validateProject(copy);
        // Test main Project and its import
        Project importedCopy = assertProjectImport(p, copy);
        assertProjectContainment(copy, constraint, true, 1);
        assertProjectContainment(importedCopy, decl, true, 1);
    }

    /**
     * Helpermethod: Tests whether the copied project contains the same imports than the original.
     * @param originalProject The original project for comparison
     * @param copy The copied project for testing
     * @return The first import (must exist).
     */
    private Project assertProjectImport(Project originalProject, Project copy) {
        Assert.assertEquals(originalProject.getName(), copy.getName());
        ProjectTestUtilities.validateProject(copy);
        Assert.assertEquals("Error: Copyied project does not contain the expected numbers of project imports.",
             originalProject.getImportsCount(), copy.getImportsCount());
        ProjectImport copiedImport = copy.getImport(0);
        Assert.assertNotNull("Error: Copyied project does not contain the original import.", copiedImport);
        Project importedCopy = copiedImport.getResolved();
        Assert.assertNotNull("Error: Copyied project does not contain the original import.", importedCopy);
        
        return importedCopy;
    }
    
    /**
     * Helpermethod: Tests whether the copied projects contain the expected elements.
     * @param testProject The copied and modified project.
     * @param element An element which shall (not) be contained.
     * @param shallbeContained <tt>true</tt> the specified element must still exist inside the copied project,
     *     <tt>false</tt> the copied project must <b>not</b> contain the specified element.
     * @param nElementsExpected The number of expected {@link ContainableModelElement}s, which shall still be part of
     *     the test {@link Project}. 
     */
    private void assertProjectContainment(Project testProject, ContainableModelElement element,
        boolean shallbeContained, int nElementsExpected) {
        
        boolean elementFound = false;
        int nElementsFound = testProject.getElementCount();

        Assert.assertEquals("Error: Copied project does not contain the expected number of items.", nElementsExpected,
            nElementsFound);
        
        /*
         * Test whether the element is part of the project.
         * equals/toString cannot be used.
         * StringProvider creates a sufficient String, which could be unambiguously parsed by Xtext.
         */
        String elementAsString = StringProvider.toIvmlString(element);
        for (int i = 0; i < nElementsFound && !elementFound; i++) {
            String currentElementAsString = StringProvider.toIvmlString(testProject.getElement(i));
            elementFound = elementAsString.equals(currentElementAsString);
        }
        
        String errMsgName = (element instanceof Constraint) ? elementAsString.trim() : element.getName();
        if (shallbeContained) {
            Assert.assertTrue("Expected element \"" + errMsgName + "\" not found.", elementFound);
        } else {
            Assert.assertFalse("Forbidden element \"" + errMsgName + "\" found.", elementFound);            
        }
    }

}
