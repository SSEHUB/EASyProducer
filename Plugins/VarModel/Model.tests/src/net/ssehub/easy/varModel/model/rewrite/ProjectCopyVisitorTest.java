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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.filter.DeclrationInConstraintFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;
import net.ssehub.easy.varModel.persistency.StringProvider;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 * Tests the deep copy functionality of the {@link ProjectCopyVisitor}.
 * @author El-Sharkawy
 */
public class ProjectCopyVisitorTest {
    
    /**
     * Helper method for applying the {@link ProjectCopyVisitor}, will copy the project and apply
     * some general assertions.
     * @param original The project to copy.
     * @return The copied project for further testings.
     */
    private Project copyProject(Project original) {
        return copyProject(original, null);
    }
    
    /**
     * Helper method for applying the {@link ProjectCopyVisitor}, will copy the project and apply
     * some general assertions.
     * @param original The project to copy.
     * @param allProjects Optional an empty set of projects, where all copied projects will be added to.
     *     Maybe <tt>null</tt>.
     * @return The copied project for further testings.
     */
    private Project copyProject(Project original, java.util.Set<Project> allProjects) {
        // Check validity of original before testing
        ProjectTestUtilities.validateProject(original);
        
        ProjectCopyVisitor copyier = new ProjectCopyVisitor(original, FilterType.ALL);
        original.accept(copyier);
        Project copy = copyier.getCopiedProject();
        if (null != allProjects) {
            allProjects.addAll(copyier.getAllCopiedProjects());
        }
        
        // Test correct copy
        java.util.Set<Project> done = new HashSet<Project>();
        assertProject(original, copy, done);
        
        // Check validity of copy
        ProjectTestUtilities.validateProject(copy);
        
        return copy;
    }

    /**
     * Tests the copies projects (and its imports).
     * @param original The original for comparison.
     * @param copy The copied project to test.
     * @param done Already checked copied projects (to avoid cycles).
     */
    private void assertProject(Project original, Project copy, java.util.Set<Project> done) {
        Assert.assertNotNull("Copy is null", copy);

        if (!done.contains(copy)) {
            done.add(copy);
            
            // Test project
            Assert.assertEquals("Copied project does not have the same name", original.getName(), copy.getName());
            Assert.assertNotSame("Projects \"" + original.getName() + "\"are same, i.e., no copy was created",
                original, copy);
            Assert.assertTrue("Copied project has not the same Version",
                Version.equals(original.getVersion(), copy.getVersion()));
            Assert.assertEquals("Copied project does not have the same amount of imports", original.getImportsCount(),
                copy.getImportsCount());
            Assert.assertEquals("Copied project has not the same amount of elements", original.getElementCount(),
                copy.getElementCount());
            
            // Test imports
            Assert.assertEquals("Copy has different amount of imports", original.getImportsCount(),
                copy.getImportsCount());
            for (int i = 0; i < original.getImportsCount(); i++) {
                ProjectImport orgImport = original.getImport(i);
                ProjectImport copyImport = copy.getImport(i);
                Assert.assertNotSame("Original import[" + i + "] was used instead of copy for import of \""
                    + copyImport.getName() + "\"", orgImport, copyImport);
                Assert.assertEquals("Import[" + i + "] name is wrong", orgImport.getName(), copyImport.getName());
                // TODO SE: Version restriction
                Assert.assertEquals("Interface[" + i + "] name is wrong", orgImport.getInterfaceName(),
                    copyImport.getInterfaceName());
                assertProject(orgImport.getResolved(), copyImport.getResolved(), done);
            }
            
            // Test annotations
            assertAnnotateableElement(original, copy, copy);
        }
    }
    
    /**
     * Tests an annotated elements, whether all annotations are copied correctly.
     * @param original The original for comparison
     * @param copy The copy to test
     * @param expectedParent The expected parent of all annotations
     */
    private void assertAnnotateableElement(IAttributableElement original, IAttributableElement copy,
        Project expectedParent) {
        
        Assert.assertEquals("Copied element \"" + copy.getName() + "\" does not have the same amount of annontations",
            original.getAttributesCount(), copy.getAttributesCount());
        
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        for (int i = 0; i < copy.getAttributesCount(); i++) {
            Attribute orgAnnotation = original.getAttribute(i);
            mapping.put(orgAnnotation, expectedParent);
            assertDeclaration(original.getAttribute(i), copy.getAttribute(i), mapping);
        }
    }
    
    /**
     * General comparison between original and copied model element.
     * @param originalElement The original element which should be copied.
     * @param copiedElement The copied element to test.
     * @param expectedParent The new expected parent for the copied element
     */
    private void assertCopiedElement(ContainableModelElement originalElement, ContainableModelElement copiedElement,
        IModelElement expectedParent) {
        
        Assert.assertNotNull("Copied element is null", copiedElement);
        Assert.assertNotNull("Error in test case: No expected parent specified for: " + copiedElement.getName(),
            expectedParent);
        Assert.assertSame("Copied element is not of type \"" + originalElement.getClass()
            + "\".", originalElement.getClass(), copiedElement.getClass());
        Assert.assertEquals("Copied element has not the same name \"" + originalElement.getName()
            + "\".", originalElement.getName(), copiedElement.getName());
        Assert.assertSame("Copied element \"" + copiedElement.getName() + "\" has wrong parent expected "
            + expectedParent.getName() + "["
            + Integer.toHexString(System.identityHashCode(expectedParent)) + "] but was "
            + copiedElement.getParent() + " ["
            + Integer.toHexString(System.identityHashCode(copiedElement.getParent())) + "]", expectedParent,
            copiedElement.getParent());
        Assert.assertNotSame(originalElement.getParent(), copiedElement.getParent());
        Assert.assertSame("Copied element has wrong comment", originalElement.getComment(), copiedElement.getComment());
        /*
         * If both elements are printed out, they should look equal (especially no namespaces should be introduced
         * through copying the elements
         */
        Assert.assertEquals(StringProvider.toIvmlString(originalElement), StringProvider.toIvmlString(originalElement));
    }
    
    /**
     * Tests whether the original and copied enumeration are equal.
     * @param enumType The original enumeration
     * @param copiedEnum The copied enumeration
     * @param copy The new expected parent for the copied element
     */
    private void assertEnumeration(Enum enumType, Enum copiedEnum, Project copy) {
        assertCopiedElement(enumType, copiedEnum, copy);
        
        Assert.assertEquals("Copied enumeration type has different amount of literals.", enumType.getLiteralCount(),
            copiedEnum.getLiteralCount());
        for (int i = 0; i < enumType.getLiteralCount(); i++) {
            Assert.assertEquals("Literal[" + i + "] is of different class", enumType.getLiteral(i).getClass(),
                copiedEnum.getLiteral(i).getClass());
            Assert.assertEquals("Literal[" + i + "] has different name", enumType.getLiteral(i).getName(),
                copiedEnum.getLiteral(i).getName());
            Assert.assertEquals("Literal[" + i + "] has different ordinal value", enumType.getLiteral(i).getOrdinal(),
                copiedEnum.getLiteral(i).getOrdinal());
            Assert.assertEquals("Literal[" + i + "] has different comment", enumType.getLiteral(i).getComment(),
                copiedEnum.getLiteral(i).getComment());
        }
    }
    
    /**
     * Checks that the original and copied declaration are basically equal.
     * @param decl The original declaration
     * @param copieddecl The copied declaration to test
     * @param copyMapping Tuple of (original declaration, copied project parent) to verify parents (recursive
     * function for nested annotations).
     */
    private void assertDeclaration(AbstractVariable decl, AbstractVariable copieddecl,
        Map<AbstractVariable, Project> copyMapping) {
        
        assertCopiedElement(decl, copieddecl, copyMapping.get(decl));
        
        // Data type
        IDatatype basisType = decl.getType();
        if (basisType.isPrimitive()) {
            Assert.assertSame("Copied declaration does not have the same type", basisType, copieddecl.getType());
        }
        
        // Default value
        Assert.assertEquals("Copied type has not the same default value.", decl.getDefaultValue(),
            copieddecl.getDefaultValue());
        
        if (decl instanceof Attribute) {
            Attribute orgAnnoatation = (Attribute) decl;
            Attribute copiedAnnoatation = (Attribute) copieddecl;
            IAttributableElement orgAnnotatedElement = orgAnnoatation.getElement();
            IAttributableElement copiedAnnotatedElement = copiedAnnoatation.getElement();
            Assert.assertEquals(orgAnnotatedElement.getQualifiedName(), copiedAnnotatedElement.getQualifiedName());
            Assert.assertNotSame(orgAnnotatedElement, copiedAnnotatedElement);
        }
        
        // Annotations
        Assert.assertEquals(decl.isAttribute(), copieddecl.isAttribute());
        Assert.assertEquals("Copied declaration has not the same attribute count", decl.getAttributesCount(),
            copieddecl.getAttributesCount());
        for (int i = 0, end = decl.getAttributesCount(); i < end; i++) {
            AbstractVariable orgAnnotation = decl.getAttribute(i);
            if (null == copyMapping.get(orgAnnotation)) {
                copyMapping.put(orgAnnotation, copieddecl.getProject());
            }
            assertDeclaration(decl.getAttribute(i), copieddecl.getAttribute(i), copyMapping);
        }
    }
    
    /**
     * Checks whether a constraint was copied correctly.
     * @param constraint The original constraint for comparison
     * @param copiedConstraint The copied constraint to test
     * @param expectedParent The expected parent of the constraint
     * @param copiedProjects Valid parents for elements of the constraint.
     */
    private void assertConstraint(Constraint constraint, Constraint copiedConstraint, IModelElement expectedParent,
        java.util.Set<Project> copiedProjects) {
        
        assertCopiedElement(constraint, copiedConstraint, expectedParent);
        assertCST(copiedConstraint.getConsSyntax(), copiedProjects);
    }
    
    /**
     * Checks a copied {@link ConstraintSyntaxTree}.
     * @param copiedCST The copied {@link ConstraintSyntaxTree} to test.
     * @param copiedProjects Valid parents for nested declarations, i.e., (copied) Projects
     */
    private void assertCST(ConstraintSyntaxTree copiedCST, java.util.Set<Project> copiedProjects) {
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(copiedCST);
        for (AbstractVariable usedDecl : finder.getDeclarations()) {
            Assert.assertTrue("Used declaration \"" + usedDecl.getName() + "\" of original project.",
                copiedProjects.contains(usedDecl.getTopLevelParent()));
        }
    }
    
    /**
     * Checks a copied {@link DerivedDatatype}.
     * @param dType The original type for comparison
     * @param copiedType The copied type to test
     * @param copy The expected parent of the derived type
     * @param copiedProjects Valid parents for elements of the constraint.
     */
    private void assertDerivedType(DerivedDatatype dType, DerivedDatatype copiedType,
        Project copy, java.util.Set<Project> copiedProjects) {
        
        assertCopiedElement(dType, copiedType, copy);
        Assert.assertEquals("Copied type has different amount of constraints", dType.getConstraintCount(),
            copiedType.getConstraintCount());
        for (int i = 0; i < dType.getConstraintCount(); i++) {
            Constraint orgConstraint = dType.getConstraint(i);
            Constraint copiedConstraint = copiedType.getConstraint(i);
            assertConstraint(orgConstraint, copiedConstraint, copiedType, copiedProjects);
        }
    }
    
    /**
     * Checks a copied {@link Reference}s.
     * @param refType The original type for comparison
     * @param copiedType The copied type to test
     * @param copy The expected parent of the constraint
     */
    private void assertReferenceType(Reference refType, Reference copiedType, Project copy) {
        assertCopiedElement(refType, copiedType, copy);
        Assert.assertEquals(refType.getType().getName(), copiedType.getType().getName());
        Assert.assertSame(refType.getType().getClass(), copiedType.getType().getClass());
    }
    
    /**
     * Checks a copied {@link Compound}.
     * @param cType The original type for comparison
     * @param copiedType The copied type to test
     * @param expectedParent The expected parent of the compound (and parent compound)
     */
    private void assertCompound(Compound cType, Compound copiedType, IModelElement expectedParent) {
        assertCopiedElement(cType, copiedType, expectedParent);

        // recursive call for all parent compounds
        if (null != cType.getRefines()) {
            assertCompound(cType.getRefines(), copiedType.getRefines(), expectedParent);
        }
        
        Assert.assertEquals("Compound differs in respect to isAbstract", cType.isAbstract(), copiedType.isAbstract());
        Assert.assertEquals("Copied compound has different amount of nested elements", cType.getElementCount(),
            copiedType.getElementCount());
        for (int i = 0; i < cType.getElementCount(); i++) {
            assertCopiedElement(cType.getElement(i), copiedType.getElement(i), copiedType);
        }
    }
    
    /**
     * Checks a copied {@link ProjectInterface}.
     * @param pInterface The original interface for comparison
     * @param copiedIface The copied interface to test
     * @param expectedParent The expected parent of the interface and exported elements
     */
    private void assertProjectInterface(ProjectInterface pInterface, ProjectInterface copiedIface,
        Project expectedParent) {
        
        assertCopiedElement(pInterface, copiedIface, expectedParent);
        // Name already tested
        Assert.assertEquals("Copied interface is importing not the correct amount of elements",
            pInterface.getExportsCount(), copiedIface.getExportsCount());
        for (int i = 0; i < pInterface.getExportsCount(); i++) {
            assertCopiedElement(pInterface.getElement(i), copiedIface.getElement(i), expectedParent);
        }
    }
    
    /**
     * Checks a copied {@link OperationDefinition}.
     * @param operation The original operation for comparison
     * @param copiedOp The copied operation to test.
     * @param expectedParent The expected parent of the interface and exported elements
     */
    private void assertUserOperation(OperationDefinition operation, OperationDefinition copiedOp,
        Project expectedParent) {
        
        assertCopiedElement(operation, copiedOp, expectedParent);
        CustomOperation orgOperation = operation.getOperation();
        CustomOperation copiedOperation = copiedOp.getOperation();
        Assert.assertEquals("NULL handling is different.", orgOperation.acceptsNull(), copiedOperation.acceptsNull());
        Assert.assertEquals("Copied operation has different amount of parameters than expected",
            orgOperation.getParameterCount(), copiedOperation.getParameterCount());
        for (int i = 0, end = orgOperation.getParameterCount(); i < end; i++) {
            assertCopiedElement(orgOperation.getParameterDeclaration(i), copiedOperation.getParameterDeclaration(i),
                copiedOp);
        }
        java.util.Set<Project> parents = new HashSet<Project>();
        parents.add(expectedParent);
        assertCST(copiedOperation.getFunction(), parents);
    }
    
    /**
     * Tests a copied {@link FreezeBlock}.
     * @param freeze The original freeze block for comparison
     * @param copiedBlock The copied block to test
     * @param copiedProject The expected parent of the copied block
     * @param allCopiedProjects All valid (copied) parents for the expression of the selector.
     */
    private void assertFreezeBlock(FreezeBlock freeze, FreezeBlock copiedBlock, Project copiedProject,
        java.util.Set<Project> allCopiedProjects) {
        
        Assert.assertEquals("Copied freeze block has different amount of elements", freeze.getFreezableCount(),
            copiedBlock.getFreezableCount());
        for (int i = 0; i < copiedBlock.getFreezableCount(); i++) {
            assertCopiedElement((ContainableModelElement) freeze.getFreezable(i),
                (ContainableModelElement) copiedBlock.getFreezable(i), copiedProject);
        }
        
        DecisionVariableDeclaration orgItr = freeze.getIter();
        if (null != orgItr) {
            
            Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
            mapping.put(orgItr, copiedProject);
            assertDeclaration(orgItr, copiedBlock.getIter(), mapping);
        }
        
        if (null != freeze.getSelector()) {
            assertCST(copiedBlock.getSelector(), allCopiedProjects);
        }
    }
    
    /**
     * Tests whether an empty project may be copied.
     */
    @Test
    public void testCopyEmptyProject() {
        Project original = new Project("testCopyEmptyProject");
        copyProject(original);
    }
    
    /**
     * Tests whether an empty project may be copied.
     */
    @Test
    public void testCopyEmptyProjectWithVersion() {
        Project original = new Project("testCopyEmptyProjectWithVersion");
        original.setVersion(new Version(1, 2, 3, 4, 5));
        copyProject(original);
    }
    
    /**
     * Tests whether comments nested inside the project can be copied.
     */
    @Test
    public void testCopyComment() {
        Project original = new Project("testCopyComment");
        Comment comment = new Comment("// A comment", original);
        original.add(comment);
        
        Project copy = copyProject(original);
        ContainableModelElement copiedComment = copy.getElement(0);
        assertCopiedElement(comment, copiedComment, copy);
    }
    
    /**
     * Tests whether commented elements keep their comments.
     */
    @Test
    public void testCopyCommentOnElement() {
        Project original = new Project("testCopyCommentOnElement");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, original);
        original.add(decl);
        decl.setComment("// A comment");
        
        Project copy = copyProject(original);
        DecisionVariableDeclaration copiedDecl = (DecisionVariableDeclaration) copy.getElement(0);
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        mapping.put(decl, copy);
        assertDeclaration(decl, copiedDecl, mapping);
    }
    
    /**
     * Tests whether (non ordered) enumerations can be copied.
     */
    @Test
    public void testCopyEnum() {
        Project original = new Project("testCopyEnum");
        Enum enumType = new Enum("enumType", original, "LiteralA", "LiteralB", "LiteralC");
        original.add(enumType);
        
        Project copy = copyProject(original);
        Enum copiedEnum = (Enum) copy.getElement(0);
        assertEnumeration(enumType, copiedEnum, copy);
    }
    
    /**
     * Tests whether <b>ordered</b> enumerations can be copied.
     */
    @Test
    public void testCopyOrderedEnum() {
        Project original = new Project("testCopyEnum");
        OrderedEnum enumType = new OrderedEnum("enumType", original);
        enumType.add(new EnumLiteral("LiteralA", 11, enumType));
        enumType.add(new EnumLiteral("LiteralB", 7, enumType));
        enumType.add(new EnumLiteral("LiteralC", 13, enumType));
        original.add(enumType);
        
        Project copy = copyProject(original);
        Enum copiedEnum = (Enum) copy.getElement(0);
        assertEnumeration(enumType, copiedEnum, copy);
    }
    
    /**
     * Copies a constraint, which has no outstanding dependencies.
     * @throws ValueDoesNotMatchTypeException If String values cannot be created.
     * @throws CSTSemanticException If a string constraint cannot be created
     */
    @Test
    public void testSimpleConstraintCopy() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project original = new Project("testSimpleConstraintCopy");
        IDatatype basisType = StringType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        original.add(decl);
        Constraint constraint = new Constraint(original);
        ConstantValue helloWorldVal = new ConstantValue(ValueFactory.createValue(basisType, "Hello World"));
        OCLFeatureCall equality = new OCLFeatureCall(new Variable(decl), OclKeyWords.EQUALS, helloWorldVal);
        constraint.setConsSyntax(equality);
        original.add(constraint);
        
        java.util.Set<Project> copiedProjects = new HashSet<Project>();
        Project copy = copyProject(original, copiedProjects);
        Constraint copiedConstraint = (Constraint) copy.getElement(1);
        assertConstraint(constraint, copiedConstraint, copy, copiedProjects);
    }
    
    /**
     * Copies a constraint, which is depending on elements, defined at a later point.
     * @throws ValueDoesNotMatchTypeException If String values cannot be created.
     * @throws CSTSemanticException If a string constraint cannot be created
     */
    @Test
    public void testDependingConstraintCopy() throws ValueDoesNotMatchTypeException, CSTSemanticException {
        Project original = new Project("testDependingConstraintCopy");
        IDatatype basisType = StringType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        Constraint constraint = new Constraint(original);
        ConstantValue helloWorldVal = new ConstantValue(ValueFactory.createValue(basisType, "Hello World"));
        OCLFeatureCall equality = new OCLFeatureCall(new Variable(decl), OclKeyWords.EQUALS, helloWorldVal);
        constraint.setConsSyntax(equality);
        original.add(constraint);
        original.add(decl);
        
        java.util.Set<Project> copiedProjects = new HashSet<Project>();
        Project copy = copyProject(original, copiedProjects);
        Constraint copiedConstraint = (Constraint) copy.getElement(0);
        assertConstraint(constraint, copiedConstraint, copy, copiedProjects);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No {@link Attribute}s</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testSimpleDeclarationCopy() {
        Project original = new Project("testSimpleDeclarationCopy");
        IDatatype basisType = RealType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        original.add(decl);
        
        Project copy = copyProject(original);
        AbstractVariable copieddecl = (AbstractVariable) copy.getElement(0);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertDeclaration(decl, copieddecl, copyMapping);
    }
    
    /**
     * Tests whether {@link ExplicitTypeVariableDeclaration}s can be copied
     * (usually used inside {@link OperationDefinition}s). Here it is used outside of a operation, this test may fail
     * if future implementation of our variability model becomes more restrictive.
     */
    @Test
    public void testSimpleExplicitDeclarationCopy() {
        Project original = new Project("testSimpleExplicitDeclarationCopy");
        IDatatype basisType = RealType.TYPE;
        ExplicitTypeVariableDeclaration decl = new ExplicitTypeVariableDeclaration("decl", basisType, original);
        original.add(decl);
        
        Project copy = copyProject(original);
        AbstractVariable copieddecl = (AbstractVariable) copy.getElement(0);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertDeclaration(decl, copieddecl, copyMapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No {@link Attribute}s</li>
     *   <li>Depending data type (compound which is defined later)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testDeclarationWithDependingType() {
        Project original = new Project("testDeclarationWithDependingType");
        Compound cType = new Compound("cType", original);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", cType, original);
        original.add(decl);
        original.add(cType);
        
        Project copy = copyProject(original);
        // Attention: Ordering has changed!
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copy.getElement(1);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertDeclaration(decl, copieddecl, copyMapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No {@link Attribute}s</li>
     *   <li>Depending data type (compound which is defined later)</li>
     *   <li>Nested in another compound</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testDeclarationWithDependingTypeNested() {
        Project original = new Project("testDeclarationWithDependingTypeNested");
        Compound dependingType = new Compound("CP1", original);
        Compound parentType = new Compound("CP2", original);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", dependingType, parentType);
        parentType.add(decl);
        original.add(parentType);
        original.add(dependingType);
        
        Project copy = copyProject(original);
        Compound copiedParentCP = (Compound) copy.getElement(0);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertCompound(parentType, copiedParentCP, copy);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No {@link Attribute}s</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>Has a <b>constant</b> default value</li>
     * </ul>
     * @throws ValueDoesNotMatchTypeException Identifies errors in {@link DecisionVariableDeclaration#setValue(String)}
     */
    @Test
    public void testSimpleDeclarationWithDefaultCopy() throws ValueDoesNotMatchTypeException {
        Project original = new Project("testSimpleDeclarationWithDefaultCopy");
        IDatatype basisType = RealType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        decl.setValue("5.0");
        original.add(decl);
        
        Project copy = copyProject(original);
        AbstractVariable copieddecl = (AbstractVariable) copy.getElement(0);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertDeclaration(decl, copieddecl, copyMapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No {@link Attribute}s</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>Has a default value referencing another variable, which is defined at a later point</li>
     * </ul>
     * @throws ValueDoesNotMatchTypeException Identifies errors in {@link DecisionVariableDeclaration
     *     #setValue(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree )}
     * @throws CSTSemanticException Identifies errors in {@link DecisionVariableDeclaration
     *     #setValue(net.ssehub.easy.varModel.cst.ConstraintSyntaxTree )}
     */
    @Test
    public void testSimpleDeclarationWithDependingDefaultCopy() throws ValueDoesNotMatchTypeException,
        CSTSemanticException {
        
        Project original = new Project("testSimpleDeclarationWithDefaultCopy");
        IDatatype basisType = RealType.TYPE;
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declA", basisType, original);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declB", basisType, original);
        declA.setValue(new Variable(declB));
        original.add(declA);
        original.add(declB);
        
        Project copy = copyProject(original);
        AbstractVariable copiedDeclA = (AbstractVariable) copy.getElement(0);
        AbstractVariable copiedDeclB = (AbstractVariable) copy.getElement(1);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(declA, copy);
        copyMapping.put(declB, copy);
        assertDeclaration(declA, copiedDeclA, copyMapping);
        assertDeclaration(declB, copiedDeclB, copyMapping);
        Variable defaultA = (Variable) copiedDeclA.getDefaultValue();
        Assert.assertSame("Default value of first declaration is pointing to wrong instance of second declaration",
            copiedDeclB, defaultA.getVariable());
    }
    
    /**
     * Tests whether Attribute can be copied. This method tests a declaration:
     * <ul>
     *   <li>Annotated to whole project</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testSimpleAnnotationCopy() {
        Project original = new Project("testSimpleAnnotationCopy");
        IDatatype basisType = StringType.TYPE;
        Attribute decl = new Attribute("anno", basisType, original, original);
        original.add(decl);
        original.attribute(decl);
        
        Project copy = copyProject(original);
        AbstractVariable copieddecl = (AbstractVariable) copy.getElement(0);
        Map<AbstractVariable, Project> copyMapping = new HashMap<AbstractVariable, Project>();
        copyMapping.put(decl, copy);
        assertDeclaration(decl, copieddecl, copyMapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>Has an {@link Attribute}</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testDeclarationWithAnnotationCopy() {
        Project original = new Project("testDeclarationWithAnnotationCopy");
        Attribute annotation = new Attribute("anno", StringType.TYPE, original, original);
        original.add(annotation);
        original.attribute(annotation);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, original);
        original.add(decl);
//        decl.attribute(annotation);
        
        Project copiedProject = copyProject(original);
        AbstractVariable copiedAnnotation = (AbstractVariable) copiedProject.getElement(0);
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copiedProject.getElement(1);
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        mapping.put(copiedAnnotation, copiedProject);
        mapping.put(copieddecl, copiedProject);
        assertDeclaration(decl, copieddecl, mapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>Has an {@link Attribute}, which is defined after the declaration</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testDeclarationWithDependingAnnotationCopy() {
        Project original = new Project("testDeclarationWithDependingAnnotationCopy");
        Attribute annotation = new Attribute("anno", StringType.TYPE, original, original);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, original);
        original.add(decl);
        original.add(annotation);
        original.attribute(annotation);
        
        Project copiedProject = copyProject(original);
        AbstractVariable copiedAnnotation = (AbstractVariable) copiedProject.getElement(1);
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copiedProject.getElement(0);
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        mapping.put(copiedAnnotation, copiedProject);
        mapping.put(copieddecl, copiedProject);
        assertDeclaration(decl, copieddecl, mapping);
    }
    
    /**
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>Has an {@link Attribute}, which is defined after the declaration (annotation is only on declaration)</li>
     *   <li>Simple data type (is already known)</li>
     *   <li>No default value</li>
     * </ul>
     */
    @Test
    public void testDeclarationWithDependingAnnotationCopy2() {
        Project original = new Project("testDeclarationWithDependingAnnotationCopy2");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, original);
        Attribute annotation = new Attribute("anno", StringType.TYPE, original, decl);
        original.add(decl);
        original.add(annotation);
        decl.attribute(annotation);
        
        Project copiedProject = copyProject(original);
        AbstractVariable copiedAnnotation = (AbstractVariable) copiedProject.getElement(1);
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copiedProject.getElement(0);
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        mapping.put(copiedAnnotation, copiedProject);
        mapping.put(copieddecl, copiedProject);
        assertDeclaration(decl, copieddecl, mapping);
    }

    /**
     * Tests whether a simple {@link DerivedDatatype} without any dependencies can be copied.
     * @throws CSTSemanticException If <tt>true</tt>  cannot be created as constraint for a boolean type
     */
    @Test
    public void testCopyDerivedType() throws CSTSemanticException {
        Project original = new Project("testCopyDerivedType");
        IDatatype basisType = BooleanType.TYPE;
        DerivedDatatype dType = new DerivedDatatype("posType", basisType, original);
        Constraint constraint = new Constraint(dType);
        OCLFeatureCall equality = new OCLFeatureCall(new Variable(dType.getTypeDeclaration()), OclKeyWords.EQUALS,
                new ConstantValue(BooleanValue.TRUE));
        constraint.setConsSyntax(equality);
        dType.setConstraints(new Constraint[] {constraint});
        original.add(dType);
        
        java.util.Set<Project> copiedProjects = new HashSet<Project>();
        Project copy = copyProject(original, copiedProjects);
        DerivedDatatype copiedType = (DerivedDatatype) copy.getElement(0);
        assertDerivedType(dType, copiedType, copy, copiedProjects);
    }
    
    /**
     * Tests whether a {@link DerivedDatatype}, depending on a declaration can be copied.
     * @throws CSTSemanticException If a boolean equality constraint cannot be created
     */
    @Test
    public void testCopyDerivedTypeDependingOnDeclaration() throws CSTSemanticException {
        Project original = new Project("testCopyDerivedTypeDependingOnDeclaration");
        IDatatype basisType = BooleanType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        DerivedDatatype dType = new DerivedDatatype("bType", basisType, original);
        Constraint constraint = new Constraint(dType);
        OCLFeatureCall equality = new OCLFeatureCall(new Variable(dType.getTypeDeclaration()), OclKeyWords.EQUALS,
            new Variable(decl));
        constraint.setConsSyntax(equality);
        dType.setConstraints(new Constraint[] {constraint});
        original.add(dType);
        original.add(decl);
        
        java.util.Set<Project> copiedProjects = new HashSet<Project>();
        Project copy = copyProject(original, copiedProjects);
        DerivedDatatype copiedType = (DerivedDatatype) copy.getElement(0);
        assertDerivedType(dType, copiedType, copy, copiedProjects);
    }
    
    /**
     * Tests whether a simple {@link DerivedDatatype} without any dependencies can be copied.
     * @throws CSTSemanticException If a greater constraint cannot be created
     * @throws ValueDoesNotMatchTypeException If 0 cannot be created as value
     */
    @Test
    public void testCopyDerivedTypeDependingOnType() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        Project original = new Project("testCopyDerivedTypeDependingOnType");
        IDatatype basisType = IntegerType.TYPE;
        DerivedDatatype dType1 = new DerivedDatatype("posType", basisType, original);
        Constraint constraint = new Constraint(dType1);
        ConstantValue zero = new ConstantValue(ValueFactory.createValue(basisType, 0));
        OCLFeatureCall greater = new OCLFeatureCall(new Variable(dType1.getTypeDeclaration()), OclKeyWords.GREATER,
            zero);
        constraint.setConsSyntax(greater);
        dType1.setConstraints(new Constraint[] {constraint});
        DerivedDatatype dType2 = new DerivedDatatype("alias", dType1, original);
        original.add(dType2);
        original.add(dType1);
        
        java.util.Set<Project> copiedProjects = new HashSet<Project>();
        Project copy = copyProject(original, copiedProjects);
        // Attention: Ordering has changed!
        DerivedDatatype copiedType = (DerivedDatatype) copy.getElement(1);
        assertDerivedType(dType2, copiedType, copy, copiedProjects);
    }
    
    /**
     * Tests whether a simple {@link Reference} without any dependencies can be copied.
     */
    @Test
    public void testCopyReferenceType() {
        Project original = new Project("testCopyReferenceType");
        IDatatype basisType = RealType.TYPE;
        Reference refType = new Reference("refType", basisType, original);
        original.add(refType);
        
        Project copy = copyProject(original);
        Reference copiedType = (Reference) copy.getElement(0);
        assertReferenceType(refType, copiedType, copy);
    }
    
    /**
     * Tests whether a simple {@link Reference} depending on another type can be copied.
     */
    @Test
    public void testCopyReferenceDependingOnType() {
        Project original = new Project("testCopyReferenceDependingOnType");
        Enum eType = new Enum("Color", original, "R", "G", "B");
        Reference refType = new Reference("refType", eType, original);
        original.add(refType);
        original.add(eType);
        
        Project copy = copyProject(original);
        // Attention: Ordering has changed!
        Reference copiedType = (Reference) copy.getElement(1);
        assertReferenceType(refType, copiedType, copy);
    }
    
    /**
     * Tests copying a compound without any dependencies.
     */
    @Test
    public void testCopySimpleCompound() {
        Project original = new Project("testCopySimpleCompound");
        Compound cType = new Compound("cType", original);
        DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType);
        cType.add(nestedDecl);
        original.add(cType);
        
        Project copy = copyProject(original);
        Compound copiedType = (Compound) copy.getElement(0);
        assertCompound(cType, copiedType, copy);
    }
    
    /**
     * Tests copying a compound without any dependencies.
     */
    @Test
    public void testCopyRefinedCompound() {
        Project original = new Project("testCopyRefinedCompound");
        Compound cType1 = new Compound("abstractCompound", original, true, null);
        Compound cType2 = new Compound("cType", original, false, cType1);
        DecisionVariableDeclaration nestedDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType2);
        cType2.add(nestedDecl);
        original.add(cType2);
        original.add(cType1);
        
        Project copy = copyProject(original);
        // Attention: Ordering has changed!
        Compound copiedType = (Compound) copy.getElement(1);
        assertCompound(cType2, copiedType, copy);
    }
    
    /**
     * Tests copying of Sequences, badly tested as they are usually not added to the project.
     */
    @Test
    public void testCopySequence() {
        Project original = new Project("testCopySequence");
        Sequence seqType = new Sequence("seqType", IntegerType.TYPE, original);
        original.add(seqType);
        
        Project copy = copyProject(original);
        Sequence copiedType = (Sequence) copy.getElement(0);
        assertCopiedElement(seqType, copiedType, copy);
    }
    
    /**
     * Tests copying of Sets, badly tested as they are usually not added to the project.
     */
    @Test
    public void testCopySet() {
        Project original = new Project("testCopySet");
        Set setType = new Set("setType", IntegerType.TYPE, original);
        original.add(setType);
        
        Project copy = copyProject(original);
        Set copiedType = (Set) copy.getElement(0);
        assertCopiedElement(setType, copiedType, copy);
    }
    
    /**
     * Tests that {@link ProjectInterface}s can be copied, if all exported elements are already resolved.
     */
    @Test
    public void testSimpleProjectInterfaceCopy() {
        Project original = new Project("testSimpleProjectInterfaceCopy");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declA", StringType.TYPE, original);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declB", RealType.TYPE, original);
        original.add(declA);
        original.add(declB);
        ProjectInterface pInterface = new ProjectInterface("anInterface", new DecisionVariableDeclaration[] {declA},
            original);
        original.add(pInterface);
        
        Project copy = copyProject(original);
        ProjectInterface copiedIface = (ProjectInterface) copy.getElement(2);
        assertProjectInterface(pInterface, copiedIface, copy);
    }
    
    /**
     * Tests that {@link ProjectInterface}s can be copied, if exported elements are <b>not</b>already resolved.
     */
    @Test
    public void testProjectInterfaceDepeningDeclarationsCopy() {
        Project original = new Project("testProjectInterfaceDepeningDeclarationsCopy");
        DecisionVariableDeclaration declA = new DecisionVariableDeclaration("declA", StringType.TYPE, original);
        DecisionVariableDeclaration declB = new DecisionVariableDeclaration("declB", RealType.TYPE, original);
        ProjectInterface pInterface = new ProjectInterface("anInterface", new DecisionVariableDeclaration[] {declA},
                original);
        original.add(pInterface);
        original.add(declA);
        original.add(declB);
        
        Project copy = copyProject(original);
        // Attention: Ordering has changed!
        ProjectInterface copiedIface = (ProjectInterface) copy.getElement(2);
        assertProjectInterface(pInterface, copiedIface, copy);
    }
    
    /**
     * Tests whether a simple {@link OperationDefinition}, without any dependencies, can be copied.
     * Tests also that {@link ExplicitTypeVariableDeclaration}s can be copied (as they may be used inside of
     * {@link OperationDefinition}s but not elsewhere.
     */
    @Test
    public void testSimpleOperationCopy() {
        Project original = new Project("testSimpleOperationCopy");
        OperationDefinition operation = new OperationDefinition(original);
        ExplicitTypeVariableDeclaration parameterDecl = new ExplicitTypeVariableDeclaration("param1", RealType.TYPE,
            operation);
        ConstantValue constTrueFunc = new ConstantValue(BooleanValue.TRUE);
        CustomOperation func = new CustomOperation(BooleanType.TYPE, "returnsTrue", original.getType(), constTrueFunc,
            new DecisionVariableDeclaration[] {parameterDecl});
        operation.setOperation(func);
        original.add(operation);
        
        Project copy = copyProject(original);
        OperationDefinition copiedOp = (OperationDefinition) copy.getElement(0);
        assertUserOperation(operation, copiedOp, copy);
    }
    
    /**
     * Tests whether a {@link OperationDefinition}, with a depending CST could be copied.
     */
    @Test
    public void testOperationDependingCSTCopy() {
        Project original = new Project("testOperationDependingCSTCopy");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, original);
        OperationDefinition operation = new OperationDefinition(original);
        ExplicitTypeVariableDeclaration parameterDecl = new ExplicitTypeVariableDeclaration("param1", RealType.TYPE,
                operation);
        OCLFeatureCall comparison = new OCLFeatureCall(new Variable(parameterDecl), OclKeyWords.GREATER,
            new Variable(decl));
        CustomOperation func = new CustomOperation(BooleanType.TYPE, "returnsTrue", original.getType(), comparison,
                new DecisionVariableDeclaration[] {parameterDecl});
        operation.setOperation(func);
        original.add(operation);
        original.add(decl);
        
        Project copy = copyProject(original);
        OperationDefinition copiedOp = (OperationDefinition) copy.getElement(0);
        assertUserOperation(operation, copiedOp, copy);
    }
    
    /**
     * Tests whether a {@link OperationDefinition} can be copied, which depends on an unresolved type.
     */
    @Test
    public void testOperationDependingCompletely() {
        Project original = new Project("testOperationDependingCompletely");
        DerivedDatatype aliasType = new DerivedDatatype("boolAlias", BooleanType.TYPE, original);
        OperationDefinition operation = new OperationDefinition(original);
        ExplicitTypeVariableDeclaration parameterDecl = new ExplicitTypeVariableDeclaration("param1", aliasType,
            operation);
        ConstantValue constTrueFunc = new ConstantValue(BooleanValue.TRUE);
        CustomOperation func = new CustomOperation(aliasType, "returnsTrue", original.getType(), constTrueFunc,
            new DecisionVariableDeclaration[] {parameterDecl});
        operation.setOperation(func);
        original.add(operation);
        original.add(aliasType);
        
        Project copy = copyProject(original);
        // Attention: Ordering has changed!
        OperationDefinition copiedOp = (OperationDefinition) copy.getElement(1);
        assertUserOperation(operation, copiedOp, copy);
    }
    
    /**
     * Tests that a {@link ProjectImport} to an empty project can be copied.
     * @throws ModelManagementException If {@link ProjectImport#setResolved(Project)} is not working
     */
    @Test
    public void testEmptyProjectImport() throws ModelManagementException {
        Project importedProject = new Project("importedProject_of_testEmptyProjectImport");
        Project mainProject = new Project("mainProject_of_testEmptyProjectImport");
        ProjectImport pImport = new ProjectImport(importedProject.getName());
        pImport.setResolved(importedProject);
        mainProject.addImport(pImport);
        
        copyProject(mainProject);
    }
    
    /**
     * Tests that a {@link ProjectImport} with a non empty project can be copied.
     * The importing project has a declaration with a default value to the imported project.
     * @throws ModelManagementException If {@link ProjectImport#setResolved(Project)} is not working
     * @throws CSTSemanticException If {@link DecisionVariableDeclaration#setValue(ConstraintSyntaxTree)} is not working
     * @throws ValueDoesNotMatchTypeException If {@link DecisionVariableDeclaration#setValue(ConstraintSyntaxTree)}
     *     is not working 
     */
    @Test
    public void testNonEmptyProjectImport() throws ModelManagementException, ValueDoesNotMatchTypeException,
        CSTSemanticException {
        
        Project importedProject = new Project("importedProject_of_testNonEmptyProjectImport");
        DecisionVariableDeclaration decl1 = new DecisionVariableDeclaration("importedDecl", IntegerType.TYPE,
            importedProject);
        importedProject.add(decl1);
        Project mainProject = new Project("mainProject_of_testNonEmptyProjectImport");
        ProjectImport pImport = new ProjectImport(importedProject.getName());
        pImport.setResolved(importedProject);
        mainProject.addImport(pImport);
        DecisionVariableDeclaration decl2 = new DecisionVariableDeclaration("mainDecl", IntegerType.TYPE, mainProject);
        Variable defltValue = new Variable(decl1);
        decl2.setValue(defltValue);
        mainProject.add(decl2);

        Project copiedMain = copyProject(mainProject);
        DecisionVariableDeclaration copiedDecl2 = (DecisionVariableDeclaration) copiedMain.getElement(0);
        Project copiedImported = copiedMain.getImport(0).getResolved();
        DecisionVariableDeclaration copiedDecl1 = (DecisionVariableDeclaration) copiedImported.getElement(0);
        
        // Tuple (original declaration, expected copied parent)
        Map<AbstractVariable, Project> mapping = new HashMap<AbstractVariable, Project>();
        mapping.put(decl1, copiedImported);
        mapping.put(decl2, copiedMain);
        assertDeclaration(decl1, copiedDecl1, mapping);
        assertDeclaration(decl2, copiedDecl2, mapping);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A known declaration</li>
     *   <li>No But expression</li>
     * </ul>
     */
    @Test
    public void testSimpleFreezeBlock() {
        Project orgProject = new Project("testSimpleFreezeBlock");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, orgProject);
        orgProject.add(decl);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {decl}, null, null, orgProject);
        orgProject.add(freeze);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(1);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A depending declaration</li>
     *   <li>No But expression</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockDependningDeclaration() {
        Project orgProject = new Project("testFreezeBlockDependningDeclaration");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, orgProject);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {decl}, null, null, orgProject);
        orgProject.add(freeze);
        orgProject.add(decl);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        // Attention: Ordering has changed
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(1);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A known compound access</li>
     *   <li>No But expression</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockKnownCompoundAccess() {
        Project orgProject = new Project("testFreezeBlockKnownCompoundAccess");
        Compound cType = new Compound("CP", orgProject);
        DecisionVariableDeclaration slotDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType);
        cType.add(slotDecl);
        orgProject.add(cType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", cType, orgProject);
        orgProject.add(decl);
        CompoundAccessStatement cpAccess = new CompoundAccessStatement(decl, slotDecl.getName(), orgProject);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {cpAccess}, null, null, orgProject);
        orgProject.add(freeze);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(2);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A compound access, which is defined at a alter point</li>
     *   <li>No But expression</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockDependingCompoundAccess() {
        Project orgProject = new Project("testFreezeBlockDependingCompoundAccess");
        Compound cType = new Compound("CP", orgProject);
        DecisionVariableDeclaration slotDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType);
        cType.add(slotDecl);
        orgProject.add(cType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", cType, orgProject);
        CompoundAccessStatement cpAccess = new CompoundAccessStatement(decl, slotDecl.getName(), orgProject);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {cpAccess}, null, null, orgProject);
        orgProject.add(freeze);
        orgProject.add(decl);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        // Attention: Ordering has changed
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(2);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A compound access, which <b>type</b> is defined at a alter point</li>
     *   <li>No But expression</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockDependingCompoundAccessType() {
        Project orgProject = new Project("testFreezeBlockDependingCompoundAccessType");
        Compound cType = new Compound("CP", orgProject);
        DecisionVariableDeclaration slotDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType);
        cType.add(slotDecl);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", cType, orgProject);
        orgProject.add(decl);
        CompoundAccessStatement cpAccess = new CompoundAccessStatement(decl, slotDecl.getName(), orgProject);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {cpAccess}, null, null, orgProject);
        orgProject.add(freeze);
        orgProject.add(cType);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        // Attention: Ordering has changed
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(2);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A known declaration</li>
     *   <li>Simple but block (constant expression)</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockKnownDeclarationSimpleBut() {
        Project orgProject = new Project("testFreezeBlockKnownDeclarationSimpleBut");
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", RealType.TYPE, orgProject);
        orgProject.add(decl);
        DecisionVariableDeclaration itrDecl = new DecisionVariableDeclaration("i", BooleanType.TYPE, orgProject);
        ConstantValue trueExpr = new ConstantValue(BooleanValue.TRUE);
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {decl}, itrDecl, trueExpr, orgProject);
        orgProject.add(freeze);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        // Attention: Ordering has changed
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(1);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
    
    /**
     * Tests copying a {@link FreezeBlock}. It tests:
     * <ul>
     *   <li>A known declaration</li>
     *   <li>But expression on annotation</li>
     * </ul>
     */
    @Test
    public void testFreezeBlockKnownDeclarationAnnotationBut() {
        Project orgProject = new Project("testFreezeBlockKnownDeclarationAnnotationBut");
        Attribute annoDecl = new Attribute("anno", BooleanType.TYPE, orgProject, orgProject);
        orgProject.add(annoDecl);
        orgProject.attribute(annoDecl);
        Compound cType = new Compound("CP", orgProject);
        DecisionVariableDeclaration slotDecl = new DecisionVariableDeclaration("slot", StringType.TYPE, cType);
        cType.add(slotDecl);
        orgProject.add(cType);
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", cType, orgProject);
        orgProject.add(decl);
        
        DecisionVariableDeclaration itrDecl = new DecisionVariableDeclaration("i", BooleanType.TYPE, orgProject);
        AttributeVariable annotationAccess = new AttributeVariable(new Variable(itrDecl), annoDecl);
        ConstantValue trueExpr = new ConstantValue(BooleanValue.TRUE);
        OCLFeatureCall equality = new OCLFeatureCall(annotationAccess, OclKeyWords.EQUALS, trueExpr); 
        FreezeBlock freeze = new FreezeBlock(new IFreezable[] {decl}, itrDecl, equality, orgProject);
        orgProject.add(freeze);
        
        java.util.Set<Project> allCopiedProjects = new HashSet<Project>();
        Project copiedProject = copyProject(orgProject, allCopiedProjects);
        FreezeBlock copiedBlock = (FreezeBlock) copiedProject.getElement(3);
        assertFreezeBlock(freeze, copiedBlock, copiedProject, allCopiedProjects);
    }
}
