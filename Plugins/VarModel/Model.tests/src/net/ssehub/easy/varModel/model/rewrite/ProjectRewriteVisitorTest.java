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
package net.ssehub.easy.varModel.model.rewrite;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IvmlKeyWords;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.rewrite.modifier.DeclarationNameFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.FrozenCompoundConstraintsOmitter;
import net.ssehub.easy.varModel.model.rewrite.modifier.FrozenConstraintVarFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.FrozenConstraintsFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.FrozenTypeDefResolver;
import net.ssehub.easy.varModel.model.rewrite.modifier.IProjectModifier;
import net.ssehub.easy.varModel.model.rewrite.modifier.ImportRegExNameFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.ModelElementFilter;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.IVMLWriter;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the {@link ProjectRewriteVisitor} and especially whether the specified elements
 * can be filtered without removing the other elements.
 * @author El-Sharkawy
 *
 */
public class ProjectRewriteVisitorTest {
    
    private static final ConstantValue ZERO;
    private static final ConstantValue THOUSAND;
    
    static {
        ConstantValue zero = null;
        try {
            zero = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not initialize \"Zero\" as a " + ConstantValue.class.getSimpleName());
        }
        ZERO = zero;

        ConstantValue thousand = null;
        try {
            thousand = new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 1000));
        } catch (ValueDoesNotMatchTypeException e) {
            Assert.fail("Could not initialize \"Thousand\" as a " + ConstantValue.class.getSimpleName());
        }
        
        THOUSAND = thousand;
    }
    
    /**
     * Tests whether filtering of declarations based on their names work.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testFilterDeclarationBasedOnNames() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with two declaration and two assignments
        Project p = new Project("testProjectDeclarationFilter");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declarationA", IntegerType.TYPE, p);
        p.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declarationB", IntegerType.TYPE, p);
        p.add(declB);
        // Create 2 assignments
        Constraint assignmentA = new Constraint(p);
        OCLFeatureCall cstA = new OCLFeatureCall(new Variable(declA), OclKeyWords.ASSIGNMENT,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 42)));
        assignmentA.setConsSyntax(cstA);
        p.add(assignmentA);
        Constraint assignmentB = new Constraint(p);
        OCLFeatureCall cstB = new OCLFeatureCall(new Variable(declB), OclKeyWords.ASSIGNMENT,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 21)));
        assignmentB.setConsSyntax(cstB);
        p.add(assignmentB);
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        
        // Create copy while omitting the comment
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.NO_IMPORTS);
        copynator.addModelCopyModifier(new DeclarationNameFilter(new String[] {declA.getName()}));
        p.accept(copynator);
        
        // Filtered project should contain the declaration, but not the comment
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, declA, true, 2);
        assertProjectContainment(p, declB, false, 2);
        assertProjectContainment(p, assignmentA, true, 2);
        assertProjectContainment(p, assignmentB, false, 2);
    }
    
    /**
     * Tests whether filtering of comments works.
     */
    @Test
    public void testOmmitComments() {
        // Create original project with one declaration and one comment
        Project p = new Project("testProjectComment");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("aDeclaration", IntegerType.TYPE, p);
        p.add(decl);
        Comment cmt = new Comment("    //A comment\n", p);
        p.add(cmt);
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        
        // Create copy while omitting the comment
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.NO_IMPORTS);
        copynator.addModelCopyModifier(new ModelElementFilter(Comment.class));
        p.accept(copynator);
        
        // Filtered project should contain the declaration, but not the comment
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, cmt, false, 1);
        assertProjectContainment(p, decl, true, 1);
    }
    
    /**
     * Tests whether container values of references will be filtered correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testFilterReferneceValueFromContainer() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with two declaration and a set of pointers
        Project p = new Project("testProjectRefValues");
        IDatatype basisType = IntegerType.TYPE;
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declarationA", basisType, p);
        p.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declarationB", basisType, p);
        p.add(declB);
        Reference refType = new Reference("refType", basisType, p);
        Sequence seqType = new Sequence("seqType", refType, p);
        DecisionVariableDeclaration seqDecl = new DecisionVariableDeclaration("sequence", seqType, p);
        p.add(seqDecl);
        // Create ContainerValue pointing to both declarations
        Value refValueA = ValueFactory.createValue(refType, declA);
        Value refValueB = ValueFactory.createValue(refType, declB);
        Value containerValue = ValueFactory.createValue(seqType, new Object[] {refValueA, refValueB});
        Constraint assignment = new Constraint(p);
        OCLFeatureCall cst = new OCLFeatureCall(new Variable(seqDecl), OclKeyWords.ASSIGNMENT,
            new ConstantValue(containerValue));
        assignment.setConsSyntax(cst);
        p.add(assignment);
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        
        // Create copy while omitting the comment
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.NO_IMPORTS);
        copynator.addModelCopyModifier(new DeclarationNameFilter(new String[] {declA.getName(), seqDecl.getName()}));
        p.accept(copynator);
        
        // Filtered project should contain the declaration, but not the comment
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, declA, true, 3);
        assertProjectContainment(p, seqDecl, true, 3);
        assertProjectContainment(p, declB, false, 3);
        Constraint copiedAssignment = (Constraint) p.getElement(2);
        OCLFeatureCall copiedCall = (OCLFeatureCall) copiedAssignment.getConsSyntax();
        ConstantValue copiedValueCST = (ConstantValue) copiedCall.getParameter(0);
        ContainerValue copiedValue = (ContainerValue) copiedValueCST.getConstantValue();
        Assert.assertEquals("Error: Copied value has not the expected number of elements. ", 1,
            copiedValue.getElementSize());
        Assert.assertEquals(refValueA, copiedValue.getElement(0));
    }
    
    /**
     * Tests whether filtering of constraints which contain only frozen variables work.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testOmmitFrozenConstraint() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with two declarations, 2 constraints, and freeze one of these variables
        Project p = new Project("testProjectFrozenConstraint");
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
        Configuration config = new Configuration(p);
        
        // Create copy while omitting "frozen" constraints
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.NO_IMPORTS);
        FrozenConstraintsFilter ommiter = new FrozenConstraintsFilter(config);
        copynator.addModelCopyModifier(ommiter);
        p.accept(copynator);
        
        // Copied project should contain the first constraint (constraintA)
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, constraintA, false, 4);
        assertProjectContainment(p, constraintB, true, 4);
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
        
        // Create copy to allow comparisons between unfiltered and filtered project.
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.ALL);
        p.accept(copynator);
        Project copy = copynator.getCopiedProject();
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(copy, FilterType.ALL);
        copy.accept(rewriter);
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
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree)} is broken.
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
        Project p = new Project("mainTestProjectPerserveImports");
        p.addImport(pImport1);
        Constraint constraint = new Constraint(p);
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(decl), OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 42)));
        constraint.setConsSyntax(comparison);
        p.add(constraint);
        ProjectTestUtilities.validateProject(p);
        
        // Create copy to allow comparisons between unfiltered and filtered project.
        ProjectCopyVisitor copynator = new ProjectCopyVisitor(p, FilterType.ALL);
        p.accept(copynator);
        Project copy = copynator.getCopiedProject();
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(copy, FilterType.ALL);
        copy.accept(rewriter);
        // Test main Project and its import
        assertProjectImport(p, copy);
    }
    
    /**
     * Tests whether elements declared inside a removed import are also resolved correctly outside of the import.
     * @throws ModelManagementException Must not occur,
     * otherwise is the {@link ProjectImport#setResolved(Project)} broken.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * {@link Constraint#setConsSyntax(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree)} is broken.
     */
    @Test
    public void testRemoveLinksToElementsOfRemovedImports() throws ValueDoesNotMatchTypeException, CSTSemanticException,
        ModelManagementException {
        
        // Create first imported project with a declaration
        Project importedProject = new Project("importedProject");
        ProjectImport pImport1 = new ProjectImport(importedProject.getName());
        pImport1.setResolved(importedProject);
        DecisionVariableDeclaration declImported = new DecisionVariableDeclaration("declImported", IntegerType.TYPE,
            importedProject);
        importedProject.add(declImported);
        
        // Create main project with the import, a declaration and two constraints (one using to imported element)
        Project p = new Project("mainTestProjectResolveImports");
        p.addImport(pImport1);
        DecisionVariableDeclaration declTop = new DecisionVariableDeclaration("declTop", IntegerType.TYPE, p);
        p.add(declTop);
        
        // Constraint using the imported declaration (should be removed together with import)
        Constraint constraintToBeRemoved = new Constraint(p);
        Variable varTop = new Variable(declTop);
        Variable varImported = new Variable(declImported);
        OCLFeatureCall comparison1 = new OCLFeatureCall(varTop, OclKeyWords.GREATER, varImported);
        constraintToBeRemoved.setConsSyntax(comparison1);
        p.add(constraintToBeRemoved);
        
        // Constraint using only declaration of top project (should not be removed)
        Constraint constraintToBeKept = new Constraint(p);
        OCLFeatureCall comparison2 = new OCLFeatureCall(varTop, OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(declTop.getType(), 42)));
        constraintToBeKept.setConsSyntax(comparison2);
        p.add(constraintToBeKept);
        
        // Cycling import: Elements of the main project must not be removed
        ProjectImport cyclingImport = new ProjectImport(p.getName());
        cyclingImport.setResolved(p);
        importedProject.addImport(cyclingImport);
        
        // Original project should be valid before using it for testing
        ProjectTestUtilities.validateProject(p);
        
        // Create copy
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addImportModifier(new ImportRegExNameFilter("^Not a valid name to filter all Imports$", true));
        p.accept(rewriter);
        ProjectTestUtilities.validateProject(p);
        
        // Test main Project and its import
        Assert.assertEquals("Error: Copied project must not contain any imports.", 0, p.getImportsCount());
        assertProjectContainment(p, declTop, true, 2);
        assertProjectContainment(p, constraintToBeKept, true, 2);
        assertProjectContainment(p, constraintToBeRemoved, false, 2);
    }
    
    /**
     * Tests whether constraints of {@link DerivedDatatype}s are removed if all instances are frozen.
     *  @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     */
    @Test
    public void testResolveFrozenTypeDefs() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with a typedef and a frozen declaration.
        Project p = new Project("testProjectTypeDefs");
        // Create first typeDef with declaration and freeze it
        DerivedDatatype dType1 = new DerivedDatatype("posInteger1", IntegerType.TYPE, p);
        Variable constraintVar1 = new Variable(dType1.getTypeDeclaration());
        OCLFeatureCall comparison1 = new OCLFeatureCall(constraintVar1, OclKeyWords.GREATER, ZERO);
        Constraint dTypeConstraint1 = new Constraint(dType1);
        dTypeConstraint1.setConsSyntax(comparison1);
        dType1.setConstraints(new Constraint[] {dTypeConstraint1});
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("declA", dType1, p);
        decl1.setValue("42");
        p.add(dType1);
        p.add(decl1);
        // Create second typeDef with declaration and do not freeze it
        DerivedDatatype dType2 = new DerivedDatatype("posInteger2", IntegerType.TYPE, p);
        Variable constraintVar2 = new Variable(dType2.getTypeDeclaration());
        OCLFeatureCall comparison2 = new OCLFeatureCall(constraintVar2, OclKeyWords.GREATER, ZERO);
        Constraint dTypeConstraint2 = new Constraint(dType2);
        dTypeConstraint2.setConsSyntax(comparison2);
        dType2.setConstraints(new Constraint[] {dTypeConstraint2});
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("declB", dType2, p);
        decl2.setValue("21");
        p.add(dType2);
        p.add(decl2);
        // Freeze first declaration (frezeblock should be last element)
        p.add(new FreezeBlock(new IFreezable[] {decl1}, null, null, p));
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        // Create copy
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.ALL);
        copynator.addModelCopyModifier(new FrozenTypeDefResolver(config));
        p.accept(copynator);
        ProjectTestUtilities.validateProject(p);
        
        DerivedDatatype copiedType1 = (DerivedDatatype) p.getElement(0);
        DerivedDatatype copiedType2 = (DerivedDatatype) p.getElement(2);
        Assert.assertEquals("Error: Frozen \"posInteger1\" not resolved.", 0, copiedType1.getConstraintCount());
        Assert.assertEquals("Error: Unfrozen \"posInteger2\" resolved, but should not.", 1,
            copiedType2.getConstraintCount());
    }
    
    /**
     * Tests whether constraints of {@link DerivedDatatype}s are removed if all instances are frozen.
     * Considers Typedefs using other Typedefs.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     */
    @Test
    public void testResolveFrozenTypeDefs2() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with a typedef and a frozen declaration.
        Project p = new Project("testResolveFrozenTypeDefs2");
        // Create first typeDef with declaration and freeze it
        DerivedDatatype dType1 = new DerivedDatatype("posInteger1", IntegerType.TYPE, p);
        Variable constraintVar1 = new Variable(dType1.getTypeDeclaration());
        OCLFeatureCall comparison1 = new OCLFeatureCall(constraintVar1, OclKeyWords.GREATER, ZERO);
        Constraint dTypeConstraint1 = new Constraint(dType1);
        dTypeConstraint1.setConsSyntax(comparison1);
        dType1.setConstraints(new Constraint[] {dTypeConstraint1});
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("declA", dType1, p);
        decl1.setValue("42");
        p.add(dType1);
        p.add(decl1);
        // Create second typeDef with declaration and do not freeze it
        DerivedDatatype dType2 = new DerivedDatatype("posInteger2", dType1, p);
        Variable constraintVar2 = new Variable(dType2.getTypeDeclaration());
        OCLFeatureCall comparison2 = new OCLFeatureCall(constraintVar2, OclKeyWords.LESS, THOUSAND);
        Constraint dTypeConstraint2 = new Constraint(dType2);
        dTypeConstraint2.setConsSyntax(comparison2);
        dType2.setConstraints(new Constraint[] {dTypeConstraint2});
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("declB", dType2, p);
        decl2.setValue("21");
        p.add(dType2);
        p.add(decl2);
        // Freeze first declaration (frezeblock should be last element)
        p.add(new FreezeBlock(new IFreezable[] {decl1}, null, null, p));
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        // Create copy
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.ALL);
        copynator.addModelCopyModifier(new FrozenTypeDefResolver(config));
        p.accept(copynator);
        ProjectTestUtilities.validateProject(p);
        
        DerivedDatatype copiedType1 = (DerivedDatatype) p.getElement(0);
        DerivedDatatype copiedType2 = (DerivedDatatype) p.getElement(2);
        Assert.assertEquals("Error: Unfrozen \"posInteger1\" resolved, but should not.", 1,
            copiedType1.getConstraintCount());
        Assert.assertEquals("Error: Unfrozen \"posInteger2\" resolved, but should not.", 1,
            copiedType2.getConstraintCount());
    }
    
    /**
     * Tests whether compounds with frozen constraints are reduced correctly (constraints containing only frozen
     * elements shall be removed from compound).
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     */
    @Test
    public void testFilterCompoundConstraints() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with 3 compounds and a further variable.
        Project p = new Project("testFilterCompoundConstraints");
        DecisionVariableDeclaration unnestedDecl = new DecisionVariableDeclaration("unnested", IntegerType.TYPE, p);
        p.add(unnestedDecl);
        // First compound with frozen constraint
        Compound cType1 = new Compound("CP1", p);
        DecisionVariableDeclaration nestedDeclA 
            = new DecisionVariableDeclaration("nestedA", IntegerType.TYPE, cType1);
        nestedDeclA.setValue(2);
        cType1.add(nestedDeclA);
        DecisionVariableDeclaration nestedDeclB
            = new DecisionVariableDeclaration("nestedB", IntegerType.TYPE, cType1);
        nestedDeclB.setValue(3);
        cType1.add(nestedDeclB);
        Constraint constraint1 = new Constraint(cType1);
        OCLFeatureCall comparinson1 = new OCLFeatureCall(new Variable(nestedDeclA), OclKeyWords.LESS,
            new Variable(nestedDeclB));
        constraint1.setConsSyntax(comparinson1);
        cType1.addConstraint(constraint1);
        p.add(cType1);
        // Second compound, refinement of CP1 does contain only a (frozen declaration)
        Compound cType2 = new Compound("CP2", p, cType1);
        DecisionVariableDeclaration nestedDeclC
            = new DecisionVariableDeclaration("nestedC", IntegerType.TYPE, cType2);
        nestedDeclC.setValue(5);
        cType2.add(nestedDeclC);
        p.add(cType2);
        // Third compound, refinement of CP2, contains unfrozen constraint
        Compound cType3 = new Compound("CP3", p, cType2);
        Constraint constraint2 = new Constraint(cType3);
        OCLFeatureCall comparinson2 = new OCLFeatureCall(new Variable(nestedDeclC), OclKeyWords.LESS,
            new Variable(unnestedDecl));
        constraint2.setConsSyntax(comparinson2);
        cType3.addConstraint(constraint2);
        p.add(cType3);
        // Create three instances
        DecisionVariableDeclaration cmp1 = new DecisionVariableDeclaration("cmp1", cType1, p);
        DecisionVariableDeclaration cmp2 = new DecisionVariableDeclaration("cmp2", cType2, p);
        DecisionVariableDeclaration cmp3 = new DecisionVariableDeclaration("cmp3", cType3, p);
        p.add(cmp1);
        p.add(cmp2);
        p.add(cmp3);
        // Freeze compounds
        p.add(new FreezeBlock(new IFreezable[] {cmp1, cmp2, cmp3}, null, null, p));
        
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new FrozenCompoundConstraintsOmitter(config));
        p.accept(rewriter);
        
        //ProjectTestUtilities.validateProject(copy, true);
        ContainableModelElement[] copiedElements = getCopiedElements(p, cType1, cType2, cType3);
        Compound copiedCP1 = (Compound) copiedElements[0];
        Compound copiedCP2 = (Compound) copiedElements[1];
        Compound copiedCP3 = (Compound) copiedElements[2];
        Assert.assertEquals("Error: Constraints of frozen compound \"" + copiedCP1.getName() + "\" not removed.", 0,
            copiedCP1.getConstraintsCount());
        Assert.assertEquals("Error: Constraints added to compound \"" + copiedCP2.getName() + "\".", 0,
            copiedCP2.getConstraintsCount());
        Assert.assertEquals("Error: Constraints of unfrozen compound \"" + copiedCP3.getName() + "\" removed.", 1,
            copiedCP3.getConstraintsCount());
    }
    
    /**
     * Searches for the copied elements inside the given projects and returns them in the same order as the passed
     * originals.
     * @param project The project for which the copied elements shall be returned.
     * @param originals The originals for which the copied elements shall be returned.
     * @return The elements of the given project with the same name as the specified orignals, in the same order.
     */
    private ContainableModelElement[] getCopiedElements(Project project, ContainableModelElement... originals) {
        ContainableModelElement[] copiedElements = new ContainableModelElement[originals.length];
        for (int i = 0; i < project.getElementCount(); i++) {
            ContainableModelElement copiedElement = project.getElement(i);
            boolean found = false;
            for (int j = 0; j < originals.length && !found; j++) {
                if (originals[j].getName().equals(copiedElement.getName())) {
                    copiedElements[j] = copiedElement;
                    found = true;
                }
            }
        }
        
        return copiedElements;
    }
    
    /**
     * Tests whether filtering of frozen constraint variables works.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     */
    @Test
    public void testOmmitFrozenConstraintVariables() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        // Create original project with one declaration and one comment
        Project p = new Project("testProjectConstraintVar");
        DecisionVariableDeclaration intDecl = new DecisionVariableDeclaration("intA", IntegerType.TYPE, p);
        p.add(intDecl);
        DecisionVariableDeclaration constVar = new DecisionVariableDeclaration("constVar", ConstraintType.TYPE, p);
        p.add(constVar);
        Variable constraintVar = new Variable(intDecl);
        OCLFeatureCall comparison = new OCLFeatureCall(constraintVar, OclKeyWords.GREATER, ZERO);
        constVar.setValue(comparison);
        DecisionVariableDeclaration constVar2 = new DecisionVariableDeclaration("constVar2", ConstraintType.TYPE, p);
        p.add(constVar2);
        OCLFeatureCall comparison2 = new OCLFeatureCall(constraintVar, OclKeyWords.GREATER, ZERO);
        constVar2.setValue(comparison2);
        // Freeze all, but one constraint
        p.add(new FreezeBlock(new IFreezable[] {intDecl, constVar}, null, null, p));
        // Project should be valid
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        // Create copy while omitting the comment
        ProjectRewriteVisitor copynator = new ProjectRewriteVisitor(p, FilterType.NO_IMPORTS);
        copynator.addModelCopyModifier(new FrozenConstraintVarFilter(config));
        p.accept(copynator);
        
        // Copied project should contain the declaration, freezeblock, and unfrozen constraint
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, intDecl, true, 3);
        assertProjectContainment(p, constVar2, true, 3);
        assertProjectContainment(p, constVar, false, 3);
    }
    
    /**
     * Tests that the but condition of a FreezeBlock is created correctly after filtering declarations.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     */
    @Test
    public void testRewritingOfFreezeBlockSelector() throws ValueDoesNotMatchTypeException {
        // Create original project with two declaration, an annotation and a FreezeBlock
        Project p = new Project("testProjectFreezeBlockSelector");
        OrderedEnum btType = new OrderedEnum("BindingTime", p);
        btType.add(new EnumLiteral("Compiletime", 1, btType));
        btType.add(new EnumLiteral("runtime", 2, btType));
        p.add(btType);
        Attribute attr = new Attribute("bindingTime", btType, p, p);
        p.attribute(attr);
        p.add(attr);
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declarationA", IntegerType.TYPE, p);
        declA.setValue(42);
        p.add(declA);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declarationB", IntegerType.TYPE, p);
        p.add(declB);
        declB.setValue(21);
        // Freeze one declaration
        DecisionVariableDeclaration itr = new DecisionVariableDeclaration("itr", AnyType.TYPE, null);
        AttributeVariable itrVar = new AttributeVariable(new Variable(itr), attr);
        ConstantValue btValue =  new ConstantValue(ValueFactory.createValue(btType, btType.getLiteral(1)));
        ConstraintSyntaxTree selectorCST = new OCLFeatureCall(itrVar, OclKeyWords.GREATER_EQUALS, btValue);
        FreezeBlock block = new FreezeBlock(new IFreezable[] {declA, declB}, itr , selectorCST, p);
        p.add(block);
        
        // Project should be valid
        ProjectTestUtilities.validateProject(p);

        // Filter one declaration
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new DeclarationNameFilter(new String[] {declA.getName()}));
        p.accept(rewriter);
        
        ProjectTestUtilities.validateProject(p);
        assertProjectContainment(p, declA, true, 4);
        assertProjectContainment(p, declB, false, 4);
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        p.getElement(3).accept(iWriter);
        try {
            iWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String freezeAsString = sWriter.toString();
        Assert.assertTrue("Annotation access in freeze block selector not handled correctly.",
            freezeAsString.contains(itr.getName() + IvmlKeyWords.ATTRIBUTE_ACCESS + attr.getName()));
        Assert.assertFalse("Invalid qualified name introduced to annotation access in freeze block selector.",
            freezeAsString.contains(p.getName() + IvmlKeyWords.NAMESPACE_SEPARATOR + itr.getName()));
    }
    
    /**
     * Tests whether a Constraint variable used inside a compound will be removed correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     */
    @Test
    public void testConstraintVarInCompound() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project p = new Project("testContainerConstraintInCompound");
        // First compound with frozen constraint
        Set intSetType = new Set("intSet", IntegerType.TYPE, p);
        Compound cType1 = new Compound("CP1", p);
        DecisionVariableDeclaration nestedDeclSet 
            = new DecisionVariableDeclaration("nestedSet", intSetType, cType1);
        nestedDeclSet.setValue(2);
        cType1.add(nestedDeclSet);
        DecisionVariableDeclaration constrDecl 
            = new DecisionVariableDeclaration("setCheck", ConstraintType.TYPE, cType1);
        OCLFeatureCall sizeCheck = new OCLFeatureCall(new Variable(nestedDeclSet), OclKeyWords.SIZE);
        sizeCheck = new OCLFeatureCall(sizeCheck, OclKeyWords.GREATER,
            new ConstantValue(ValueFactory.createValue(IntegerType.TYPE, 0)));
        constrDecl.setValue(sizeCheck);
        cType1.add(constrDecl);
        p.add(cType1);
        DecisionVariableDeclaration cmpDecl 
            = new DecisionVariableDeclaration("cmp", cType1, p);
        p.add(cmpDecl);
        p.add(new FreezeBlock(new IFreezable[] {cmpDecl}, null, null, p));
        
        // Check whether project was built up correctly
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        // Filter the constraint
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new FrozenConstraintVarFilter(config));
        p.accept(rewriter);
        ProjectTestUtilities.validateProject(p);
        
        ContainableModelElement[] copiedElements = getCopiedElements(p, cType1);
        Compound copiedCP1 = (Compound) copiedElements[0];
        Assert.assertEquals("Error: Constraint variable of frozen compound \"" + copiedCP1.getName()
            + "\" not removed.", 1, copiedCP1.getDeclarationCount());
    }
    
    /**
     * Tests whether an iteration variable of a container operation is translated correctly (no qualified names should
     * be introduced).
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * @throws IOException Must not occur, otherwise {@link IVMLWriter#flush()} is not working.
     */
    @Test
    public void testIterationVariables() throws ValueDoesNotMatchTypeException, CSTSemanticException, IOException {
        Project p = new Project("testIterationVariables");
        Set intSetType = new Set("intSet", IntegerType.TYPE, p);
        DecisionVariableDeclaration setDecl = new DecisionVariableDeclaration("setVar", intSetType, p);
        setDecl.setValue(1, 2, 3);
        p.add(setDecl);
        Constraint constraint = new Constraint(p);
        DecisionVariableDeclaration iVarDecl = new DecisionVariableDeclaration("i", IntegerType.TYPE, p);
        Variable iVar = new Variable(iVarDecl);
        Variable setVar = new Variable(setDecl);
        OCLFeatureCall greater = new OCLFeatureCall(iVar, OclKeyWords.GREATER, ZERO);
        ContainerOperationCall forAllInSet = new ContainerOperationCall(setVar, OclKeyWords.FOR_ALL, greater, iVarDecl);
        constraint.setConsSyntax(forAllInSet);
        p.add(constraint);
        DecisionVariableDeclaration constVarDecl = new DecisionVariableDeclaration("constraintVar", ConstraintType.TYPE,
            p);
        p.add(constVarDecl);
        constVarDecl.setValue(forAllInSet);
        Comment comment = new Comment("    // Some text to be filtered\n", p);
        p.add(comment);
        
        // Check whether project was built up correctly
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        // Filter nothing (test whether iterator variable is copied correctly)
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new FrozenConstraintsFilter(config));
        rewriter.addModelCopyModifier(new FrozenConstraintVarFilter(config));
        rewriter.addModelCopyModifier(new ModelElementFilter(Comment.class));
        p.accept(rewriter);
        
        ProjectTestUtilities.validateProject(p);
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        p.accept(iWriter);
        iWriter.flush();
        Assert.assertFalse(sWriter.toString().contains(IvmlKeyWords.NAMESPACE_SEPARATOR));
    }
    
    /**
     * Simple test whether Operation definitions are kept correctly or whether name space spearators are introduced.
     * The later one occurs if the constraint is not resolved correctly.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * @throws IOException Must not occur, otherwise {@link IVMLWriter#flush()} is not working.
     */
    @Test
    public void testReusedOperationsInConstraintVar() throws ValueDoesNotMatchTypeException, CSTSemanticException,
        IOException {
        
        Project p = new Project("testReusedOperationsInConstraintVar");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("varA", IntegerType.TYPE, p);
        declA.setValue(10);
        p.add(declA);
        DecisionVariableDeclaration constDecl = new DecisionVariableDeclaration("constVar", ConstraintType.TYPE, p);
        p.add(constDecl);
        // A user defined operation, re-using the constraint variable
        OperationDefinition customOp = new OperationDefinition(p);
        DecisionVariableDeclaration paramDecl = new DecisionVariableDeclaration("dv", IntegerType.TYPE, customOp);
        OCLFeatureCall funcCst = new OCLFeatureCall(new Variable(paramDecl), OclKeyWords.LESS, THOUSAND);
        funcCst.inferDatatype();
        CustomOperation functionDef = new CustomOperation(BooleanType.TYPE, "operationCheck", p.getType(), funcCst,
            new DecisionVariableDeclaration[] {paramDecl});
        customOp.setOperation(functionDef);
        p.add(customOp);
        // Second operation, re-using the first one
        OperationDefinition customOp2 = new OperationDefinition(p);
        DecisionVariableDeclaration paramDecl2 = new DecisionVariableDeclaration("dv", IntegerType.TYPE, customOp2);
        OCLFeatureCall compare = new OCLFeatureCall(new Variable(paramDecl2), OclKeyWords.GREATER, ZERO);
        OCLFeatureCall callOp1 = new OCLFeatureCall(new Variable(paramDecl2), customOp.getName(), p);
        OCLFeatureCall funcCst2 = new OCLFeatureCall(compare, OclKeyWords.AND, callOp1);
        CustomOperation functionDef2 = new CustomOperation(BooleanType.TYPE, "operationCheck2", p.getType(), funcCst2,
            new DecisionVariableDeclaration[] {paramDecl2});
        funcCst2.inferDatatype();
        customOp2.setOperation(functionDef2);
        p.add(customOp2);
        
        // Default value for constraint var + freeze
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(declA), customOp.getName(), p);
        comparison.inferDatatype();
        constDecl.setValue(comparison);
        p.add(new FreezeBlock(new IFreezable[] {declA, constDecl}, null, null, p));
        
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new FrozenConstraintVarFilter(config));
        p.accept(rewriter);
        ProjectTestUtilities.validateProject(p);
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        p.accept(iWriter);
        iWriter.flush();
        Assert.assertFalse(sWriter.toString().contains(IvmlKeyWords.NAMESPACE_SEPARATOR));
    }
    
    /**
     * Tests whether a more complex operation is resolved correctly.
     * The operation takes a typedef of a set of a compound as input.
     * More precisely the following project will be tested:
     * <pre><code>
     * project testOperationsOfTypeDefIsResolvedCorrectly {
     *
     *   compound Dimension {
     *     Integer width;
     *     Integer height;
     *     Constraint hCheck = height > 0;
     *   }
     *
     *   typedef Dimensions setOf(Dimension);
     *   Dimensions dimensions = {{width = 1, height = 2}};
     *   freeze {
     *     dimensions;
     *   }
     *   def Boolean func(Dimensions dims) = size(dims->collect(d|d.width > 0)) > 0;
     * }
     * </code></pre>
     * There should no name space saparaters be introduced.
     * @throws ValueDoesNotMatchTypeException Must not occur, otherwise the {@link ValueFactory} or
     * {@link net.ssehub.easy.varModel.model.AbstractVariable#setValue(String)} are broken.
     * @throws CSTSemanticException Must not occur, otherwise
     * @throws IOException Must not occur, otherwise {@link IVMLWriter#flush()} is not working.
     */
    @Test
    public void testOperationsOfTypeDefIsResolvedCorrectly() throws ValueDoesNotMatchTypeException,
        CSTSemanticException, IOException {
        
        Project p = new Project("testOperationsOfTypeDefIsResolvedCorrectly");
        // Compound as basis type
        Compound cType = new Compound("Dimension", p);
        DecisionVariableDeclaration widthDecl = new DecisionVariableDeclaration("width", IntegerType.TYPE, cType);
        DecisionVariableDeclaration heightDecl = new DecisionVariableDeclaration("height", IntegerType.TYPE, cType);
        DecisionVariableDeclaration hCheckDecl = new DecisionVariableDeclaration("hCheck", ConstraintType.TYPE, cType);
        cType.add(widthDecl);
        cType.add(heightDecl);
        cType.add(hCheckDecl);
        OCLFeatureCall hComparison = new OCLFeatureCall(new Variable(heightDecl), OclKeyWords.GREATER, ZERO);
        hCheckDecl.setValue(hComparison);
        p.add(cType);
        // Set of Compound as typedef
        DerivedDatatype dType = new DerivedDatatype("Dimensions", new Set("", cType, p), p);
        p.add(dType);
        // One variable with one value
        DecisionVariableDeclaration dimsDecl = new DecisionVariableDeclaration("dimensions", dType, p);
        Object cmpValue = new Object[] {"width", 1, "height", 2};
        dimsDecl.setValue(cmpValue);
        p.add(dimsDecl);
        // Default value for constraint dimensions + freeze
        p.add(new FreezeBlock(new IFreezable[] {dimsDecl}, null, null, p));
        // Custom Operation (at last position, makes test easier)
        OperationDefinition customOp = new OperationDefinition(p);
        DecisionVariableDeclaration paramDecl = new DecisionVariableDeclaration("dims", dType, customOp);
        DecisionVariableDeclaration itrDecl = new DecisionVariableDeclaration("d", cType, p);
        CompoundAccess access = new CompoundAccess(new Variable(itrDecl), widthDecl.getName());
        OCLFeatureCall comparison = new OCLFeatureCall(access, OclKeyWords.GREATER, ZERO);
        ContainerOperationCall containerCall = new ContainerOperationCall(new Variable(paramDecl), OclKeyWords.COLLECT,
                comparison, itrDecl);
        OCLFeatureCall sizeCall = new OCLFeatureCall(containerCall, OclKeyWords.SIZE, p);
        OCLFeatureCall sizeComparison = new OCLFeatureCall(sizeCall, OclKeyWords.GREATER, ZERO);
        sizeComparison.inferDatatype();
        CustomOperation functionDef = new CustomOperation(BooleanType.TYPE, "func", p.getType(), sizeComparison,
                new DecisionVariableDeclaration[] {paramDecl});
        customOp.setOperation(functionDef);
        p.add(customOp);
        
        ProjectTestUtilities.validateProject(p);
        Configuration config = new Configuration(p);
        StringWriter sWriter = new StringWriter();
        IVMLWriter iWriter = new IVMLWriter(sWriter);
        p.accept(iWriter);
        iWriter.flush();
        String projectAsStringExpected = sWriter.toString().replace("\r", "");
        String[] lines = projectAsStringExpected.split("\n");
        String expected = lines[lines.length - 2];
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p, FilterType.ALL);
        rewriter.addModelCopyModifier(new FrozenCompoundConstraintsOmitter(config));
        p.accept(rewriter);
        ProjectTestUtilities.validateProject(p);
        p.accept(iWriter);
        iWriter.flush();
        String projectAsStringActual = sWriter.toString().replace("\r", "");
        lines = projectAsStringActual.split("\n");
        String actual = lines[lines.length - 2];
        
        Assert.assertFalse(projectAsStringExpected.contains(IvmlKeyWords.NAMESPACE_SEPARATOR));
        Assert.assertEquals(expected, actual);
        Assert.assertFalse(projectAsStringActual.contains(IvmlKeyWords.NAMESPACE_SEPARATOR));
    }
    
    /**
     * Tests one example of a {@link IProjectModifier}, here it tests whether a freeze block may be created in a
     * specific project containing elements with a specified rule.
     * @throws ModelManagementException If {@link ProjectImport#setResolved(Project)} does not work
     */
    @Test
    public void testProjectModifierByAddingFreezeblock() throws ModelManagementException {
        Project p1 = new Project("orgProject");
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("valid_name1", StringType.TYPE, p1);
        p1.add(decl1);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("valid_name2", StringType.TYPE, p1);
        p1.add(decl2);
        DecisionVariableDeclaration decl3 = new DecisionVariableDeclaration("other_name", StringType.TYPE, p1);
        p1.add(decl3);
        
        Project p2 = new Project("orgProjectCfg");
        ProjectImport pImport = new ProjectImport(p1.getName());
        pImport.setResolved(p1);
        p2.addImport(pImport);
        Assert.assertEquals(0, p2.getElementCount());
        
        ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(p2, FilterType.ALL);
        IProjectModifier modifier = new IProjectModifier() {
            
            @Override
            public void modifyProject(Project project, RewriteContext context) {
                if (project.getName().endsWith("Cfg")) {
                    String ns = project.getName().substring(0, project.getName().length() - 3);
                    DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, null);
                    List<AbstractVariable> foundDecls = finder.getVariableDeclarations(VisibilityType.ALL);
                    List<IFreezable> toFreeze = new ArrayList<IFreezable>();
                    for (int i = 0, end = foundDecls.size(); i < end; i++) {
                        AbstractVariable decl = foundDecls.get(i);
                        if (decl.getNameSpace().equals(ns) && decl.getName().startsWith("valid_name")
                            && decl instanceof IFreezable) {
                            
                            toFreeze.add((IFreezable) decl);
                        }
                    }
                    IFreezable[] freezes = toFreeze.toArray(new IFreezable[0]);
                    FreezeBlock block = new FreezeBlock(freezes, null, null, project);
                    project.add(block);
                }
            }
        };
        
        rewriter.addProjectModifier(modifier);
        p2.accept(rewriter);
        ProjectTestUtilities.validateProject(p1);
        ProjectTestUtilities.validateProject(p2);
        Assert.assertEquals(3, p1.getElementCount());
        
        // Test whether the black has been created correctly, dirty: ordering of elements could change
        FreezeBlock createdBlock = (FreezeBlock) p2.getElement(0);
        Assert.assertNotNull(createdBlock);
        Assert.assertEquals(2, createdBlock.getFreezableCount());
        Assert.assertSame(decl1, createdBlock.getFreezable(0));
        Assert.assertSame(decl2, createdBlock.getFreezable(1));
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
     * @param shallbeContained {@code true} the specified element must still exist inside the copied project,
     *     {@code false} the copied project must <b>not</b> contain the specified element.
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
