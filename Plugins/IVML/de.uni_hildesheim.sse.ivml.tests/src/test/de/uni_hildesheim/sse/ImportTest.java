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
        File location = new File(DIR, "CycleTest_2Projects");
        try {
            VarModel.INSTANCE.locations().addLocation(location, OBSERVER);
        } catch (ModelManagementException e) {
            e.printStackTrace();
            Assert.fail("Error: Test location could not be added to VarModel. " + e.getMessage());
        }
        
        // Test pre-condition: Check that exactly one location is known
        // works only as individual test, not in combination with other tests and already known locations
        /**
        ModelLocations<Project> knownLocations = VarModel.INSTANCE.locations();
        int nKnownLocations = knownLocations.getLocationCount();
        Assert.assertEquals("Error: Only one location should registered, but " + nKnownLocations + " are registered",
            1, nKnownLocations);
        Assert.assertEquals(LOCATION_IMPORTS_WITH_2_PROJECTS.getAbsolutePath(),
            knownLocations.getLocation(0).getLocation().getAbsolutePath());      
        **/
        
        // Test: Try to load model
        List<ModelInfo<Project>> infos = VarModel.INSTANCE.availableModels()
            .getModelInfo("ImportCycleTest_2Projects_A");
        Assert.assertNotNull(infos);
        Assert.assertEquals("Error: Only one project should be found, but there were " + infos.size(), 1, infos.size());
        Project project = null;
        try {
            project = VarModel.INSTANCE.load(infos.get(0));
        } catch (ModelManagementException e) {
            e.printStackTrace();
            Assert.fail("Error: Model-Info could not be loaded. " + e.getMessage());
        }
        Assert.assertNotNull(project);
        assertImported(project);
        
        
        
        // Test: Test correct project structure, i.e. loaded cycle imports
        // TODO
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
