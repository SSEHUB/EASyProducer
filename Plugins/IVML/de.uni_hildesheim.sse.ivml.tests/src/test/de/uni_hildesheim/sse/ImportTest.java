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
package test.de.uni_hildesheim.sse;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Testing the correct resolution of project imports inside IVML files, in particular cyclic imports.
 * 
 * @author El-Sharkawy
 */
public class ImportTest extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "imports");
    
    private static final File LOCATION_IMPORTS_WITH_2_PROJECTS = new File(DIR, "CycleTest_2Projects"); 
    private static final File LOCATION_CYCLING_DECLARATIONS = new File(DIR, "CycleTest_CyclingDeclarations"); 
    
    /**
     * Starts up the test overriding the parent method.
     */
    @BeforeClass
    public static void startUp() {
        // "override" parent startUp
        resourceInitialization();
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
        } catch (ModelManagementException mme) {
            mme.printStackTrace();
            Assert.fail("IVML parser could not be registered: " + mme.getMessage());
        }
    }

    /**
     * Tears down the test overriding the parent method.
     */
    @AfterClass
    public static void shutDown() {
        // "override" parent shutDown
    }
    
    /**
     * Removes all locations after each test to ensure that only relevant locations are loaded.
     */
    @After
    public void tearDown() {
        try {
            VarModel.INSTANCE.locations().removeLocation(LOCATION_IMPORTS_WITH_2_PROJECTS, OBSERVER);
        } catch (ModelManagementException e) {
            // Do not abort, print warning if any problems occur
            e.printStackTrace();
        }
        try {
            VarModel.INSTANCE.locations().removeLocation(LOCATION_CYCLING_DECLARATIONS, OBSERVER);
        } catch (ModelManagementException e) {
            // Do not abort, print warning if any problems occur
            e.printStackTrace();
        }
    }
    
    /**
     * Tests whether 2 projects can be loaded, which are importing each other.
     * The following 2 projects are loaded:
     * <pre><code>
     * project ImportCycleTest_2Projects_A {
     *
     *   version v0;
     *   import ImportCycleTest_2Projects_B;
     * }
     * 
     * project ImportCycleTest_2Projects_B {
     *
     *   version v0;
     *   import ImportCycleTest_2Projects_A;
     * }
     * </code></pre>
     */
    @Test
    public void testCycleImportsWith2Projects() {
        addLocation(LOCATION_IMPORTS_WITH_2_PROJECTS);
        
        // Test: Try to load model
        loadAndCheckProject("ImportCycleTest_2Projects_A");
    }
    
    /**
     * Tests whether 2 projects with cycling declarations can be loaded.
     * The following 2 projects are loaded:
     * <pre><code>
     * project ImportCycleTest_CyclingDeclarations_A {
     *
     *   version v0;
     *   import ImportCycleTest_CyclingDeclarations_B;
     *   Integer varA = varB + 1;
     * }
     * 
     * project ImportCycleTest_CyclingDeclarations_B {
     *
     *   version v0;
     *   import ImportCycleTest_CyclingDeclarations_A;
     *   Integer varB = 1;
     *   Integer varC = varA + 1;
     * }
     * </code></pre>
     */
    @Test
    public void testCyclingDeclarations() {
        addLocation(LOCATION_CYCLING_DECLARATIONS);
        
        // Test: Try to load model
        Project project = loadAndCheckProject("ImportCycleTest_CyclingDeclarations_A");
        
        // Test whether all declarations could be resolved correctly
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, null);
//        List<AbstractVariable> delcarations = 
        finder.getVariableDeclarations(VisibilityType.ALL);
        // TODO
    }

    /**
     * Loads the specified IVML {@link Project} and verifies whether the imports are resolved correctly.
     * Note that the locations must be registered before loading the project.
     * Works only if exactly one project with the specified name exists at the registered locations.
     * @param projectName The name of the project to load.
     * @return The loaded project, will not be <tt>null</tt>.
     * @see #addLocation(File)
     */
    private Project loadAndCheckProject(String projectName) {
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels().getModelInfo(projectName);
        Assert.assertNotNull(infos);
        Assert.assertEquals("Error: Only one project should be found, but there were " + infos.size(), 1, infos.size());
        ModelInfo<Project> info = infos.get(0);
        Project project = null;
        try {
            project = VarModel.INSTANCE.load(info);
        } catch (ModelManagementException e) {
            e.printStackTrace();
            Assert.fail("Error: model info of \"" + info.getName() + "\"could not be loaded.\nReason: "
                + e.getMessage());
        }
        
        // Test: Test correct project structure, i.e. loaded cycle imports
        Assert.assertNotNull(project);
        assertImported(project);
        return project;
    }

    /**
     * Adds a file location (folder), to the {@link VarModel} which shall be used to load models for the current test.
     * Test will be aborted if location could not be added.
     * @param location A folder which shall be used for loading models for the current test
     * (will also use sub folders).
     */
    private void addLocation(File location) {
        Assert.assertTrue("Error: The given location does not exist: \"" + location.getAbsolutePath() + "\"",
            location.exists());
        Assert.assertTrue("Error: The given location is not a folder: \"" + location.getAbsolutePath() + "\"",
            location.isDirectory());
        try {
            VarModel.INSTANCE.locations().addLocation(location, OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace();
            Assert.fail("Error: Test location could not be added to VarModel. Failed to add location: \""
                + location.getAbsolutePath() + "\". Message: " + e.getMessage());
        }
    }
    
    /**
     * Recursively asserts the resolved instances of model imports.
     * @param project the project to visit
     */
    private static void assertImported(Project project) {
        Map<ModelInfo<Project>, Project> imported = new HashMap<ModelInfo<Project>, Project>();
        ModelInfo<Project> info = VarModel.INSTANCE.availableModels().getModelInfo(project);
        Assert.assertNotNull(info);
        imported.put(info, project);
        assertImported(project, imported);
    }
    
    /**
     * Recursively asserts the resolved instances of model imports.
     * @param project the project to visit
     * @param imported the already imported (and visited) projects
     */
    private static void assertImported(Project project, Map<ModelInfo<Project>, Project> imported) {
        for (int i = 0; i < project.getImportsCount(); i++) {
            ProjectImport imp = project.getImport(i);
            Project resolved = imp.getResolved();
            Assert.assertNotNull("import '" + imp.getName() + "' in '" + project.getName() + "' is not resolved", 
                resolved);
            ModelInfo<Project> info = VarModel.INSTANCE.availableModels().getModelInfo(resolved);
            Assert.assertNotNull("no model info for '" + imp.getName() + "'", info);
            if (imported.containsKey(info)) {
                Assert.assertTrue("only one instance of '" + imp.getName() + "' shall be used in the model references", 
                    resolved == imported.get(info));
                // already visited, no recursion
            } else {
                imported.put(info, imp.getResolved());
                assertImported(imp.getResolved(), imported);
            }
        }
    }

}
