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

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.filter.DeclrationInConstraintFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
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
        Assert.assertNotNull("Copy is null", copy);
        Assert.assertEquals("Copied project does not have the same name", original.getName(), copy.getName());
        Assert.assertNotSame("Projects are same, i.e., not copy was created", original, copy);
        Assert.assertTrue("Copied project has not the same Version",
            Version.equals(original.getVersion(), copy.getVersion()));
        Assert.assertEquals("Copied project does not have the same amount of imports", original.getImportsCount(),
            copy.getImportsCount());
        Assert.assertEquals("Copied project has not the same amount of elements", original.getElementCount(),
            copy.getElementCount());
        
        // Check validity of copy
        ProjectTestUtilities.validateProject(copy);
        
        return copy;
    }
    
    /**
     * General comparison between original and copied model element.
     * @param originalElement The original element which should be copied.
     * @param copiedElement The copied element to test.
     * @param copy The new expected parent for the copied element
     */
    private void assertCopiedElement(ContainableModelElement originalElement, ContainableModelElement copiedElement,
        Project copy) {
        
        Assert.assertNotNull("Copied element is null", copiedElement);
        Assert.assertSame("Copied element is not of type \"" + originalElement.getClass()
            + "\".", originalElement.getClass(), copiedElement.getClass());
        Assert.assertEquals("Copied element has not the same name \"" + originalElement.getName()
            + "\".", originalElement.getName(), copiedElement.getName());
        Assert.assertSame("Copied element has wrong parent", copy, copiedElement.getParent());
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
        Assert.assertEquals("Copied type has not the same attribute count", decl.getAttributesCount(),
            copieddecl.getAttributesCount());
        for (int i = 0, end = decl.getAttributesCount(); i < end; i++) {
            assertDeclaration(decl.getAttribute(i), copieddecl.getAttribute(i), copyMapping);
        }
    }
    
    /**
     * Checks whether a constraint was copied correctly.
     * @param constraint The original constraint for comparison
     * @param copiedConstraint The copied constraint to test
     * @param copy The expected parent of the constraint
     * @param copiedProjects Valid parents for elements of the constraint.
     */
    private void assertConstraint(Constraint constraint, Constraint copiedConstraint, Project copy,
        java.util.Set<Project> copiedProjects) {
        
        assertCopiedElement(constraint, copiedConstraint, copy);
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(copiedConstraint.getConsSyntax());
        for (AbstractVariable usedDecl : finder.getDeclarations()) {
            Assert.assertTrue("Used declaration \"" + usedDecl.getName() + "\" of original project.",
                copiedProjects.contains(usedDecl.getParent()));
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
     *   <li>No attributes</li>
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
     * Tests whether declarations can be copied. This method tests a declaration:
     * <ul>
     *   <li>No attributes</li>
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
     *   <li>No attributes</li>
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

}
