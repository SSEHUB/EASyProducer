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

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
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
        // Check validity of original before testing
        ProjectTestUtilities.validateProject(original);
        
        ProjectCopyVisitor copyier = new ProjectCopyVisitor(original, FilterType.ALL);
        original.accept(copyier);
        Project copy = copyier.getCopiedProject();
        
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
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copy.getElement(0);
        assertCopiedElement(decl, copieddecl, copy);
        Assert.assertSame("Copied declaration does not have the same type", basisType, copieddecl.getType());
        Assert.assertEquals("Copied type has not the same default value.", decl.getDefaultValue(),
            copieddecl.getDefaultValue());
        Assert.assertEquals("Copied type has not the same attribute count", decl.getAttributesCount(),
            copieddecl.getAttributesCount());
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
        Project original = new Project("testSimpleDeclarationCopy");
        IDatatype basisType = RealType.TYPE;
        DecisionVariableDeclaration decl = new DecisionVariableDeclaration("decl", basisType, original);
        decl.setValue("5.0");
        original.add(decl);
        
        Project copy = copyProject(original);
        DecisionVariableDeclaration copieddecl = (DecisionVariableDeclaration) copy.getElement(0);
        assertCopiedElement(decl, copieddecl, copy);
        Assert.assertSame("Copied declaration does not have the same type", basisType, copieddecl.getType());
        Assert.assertEquals("Copied type has not the same default value.", decl.getDefaultValue(),
            copieddecl.getDefaultValue());
        Assert.assertEquals("Copied type has not the same attribute count", decl.getAttributesCount(),
            copieddecl.getAttributesCount());
    }

}
