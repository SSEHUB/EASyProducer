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
package net.ssehub.easy.varModel.model.filter;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.filter.ProjectInterfaceFinder;
import net.ssehub.easy.varModel.varModel.testSupport.ProjectTestUtilities;

/**
 *Tests The {@link ProjectInterfaceFinder}.
 * @author Sascha El-Sharkawy
 *
 */
public class ProjectInterfaceTest {
    
    private Project project;
    private ProjectInterface importedInterfaceUsed;
    private ProjectInterface importedInterfaceUnused;
    private ProjectInterface ownInterface1;
    private ProjectInterface ownInterface2;
    
    /**
     * Configures a project with two interfaces which is importing another project also with two interfaces.
     */
    @Before
    public void setUp() {
        // Create imported project
        Project importedProject = new Project("importedProject");
        importedInterfaceUsed = new ProjectInterface("importedInterfaceUsed", null, importedProject);
        importedInterfaceUnused = new ProjectInterface("importedInterfaceUnused", null, importedProject);
        importedProject.add(importedInterfaceUsed);
        importedProject.add(importedInterfaceUnused);
        ProjectTestUtilities.validateProject(importedProject);
        
        // Create importing project
        project = new Project("mainProject");
        ProjectImport pImport = new ProjectImport(importedProject.getName(), importedInterfaceUsed.getName());
        try {
            pImport.setResolved(importedProject);
        } catch (ModelManagementException e) {
            Assert.fail("Creation of project import failed: " + e.getMessage());
            e.printStackTrace();
        }
        project.addImport(pImport);
        ownInterface1 = new ProjectInterface("ownInterface1", null, project);
        ownInterface2 = new ProjectInterface("ownInterface2", null, project);
        project.add(ownInterface1);
        project.add(ownInterface2);
        ProjectTestUtilities.validateProject(project);
    }

    /**
     * Tests to find only interfaces of the main project.
     */
    @Test
    public void testFindOnlyOwnInterfaces() {
        ProjectInterface[] expectedInterfaces = {ownInterface1, ownInterface2};
        
        assertFoundInterfaces(FilterType.NO_IMPORTS, expectedInterfaces, false);
    }
    
    /**
     * Tests to find only interfaces of imported projects.
     */
    @Test
    public void testFindOnlyImportedInterfaces() {
        ProjectInterface[] expectedInterfaces = {importedInterfaceUsed, importedInterfaceUnused};
        
        assertFoundInterfaces(FilterType.ONLY_IMPORTS, expectedInterfaces, false);
    }
    
    /**
     * Tests to find all interfaces.
     */
    @Test
    public void testFindAllInterfaces() {
        ProjectInterface[] expectedInterfaces = {ownInterface1, ownInterface2,
            importedInterfaceUsed, importedInterfaceUnused};
        
        assertFoundInterfaces(FilterType.ALL, expectedInterfaces, false);
    }
    /**
     * Tests to find only interfaces which where used inside project imports.
     */
    @Test
    public void testFindOnlyUsedInterfaces() {
        ProjectInterface[] expectedInterfaces = {importedInterfaceUsed};
        
        assertFoundInterfaces(FilterType.ALL, expectedInterfaces, true);
        assertFoundInterfaces(FilterType.ONLY_IMPORTS, expectedInterfaces, true);
        assertFoundInterfaces(FilterType.NO_IMPORTS, new ProjectInterface[] {}, true);
    }

    /**
     * Helping method for all test methods. Runs the {@link ProjectInterfaceFinder} on {@link #project}
     * and compares the output with the expected output. 
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param expectedInterfaces All expected interfaces which shall be found
     * @param onlyUsedInterfaces Consider only interfaces of imported projects, which are used inside
     *     the project import.
     */
    private void assertFoundInterfaces(FilterType filterType, ProjectInterface[] expectedInterfaces,
        boolean onlyUsedInterfaces) {
        
        // Find Project interfaces
        ProjectInterfaceFinder finder = new ProjectInterfaceFinder(project, filterType, onlyUsedInterfaces);
        List<ProjectInterface> interfaces = finder.getProjectInterfaces();
        
        // Test: Only expected interfaces shall be found
        Assert.assertNotNull(interfaces);
        Assert.assertEquals(expectedInterfaces.length, interfaces.size());
        for (int i = 0; i < expectedInterfaces.length; i++) {
            Assert.assertTrue(interfaces.contains(expectedInterfaces[i]));
        }
    }
}
