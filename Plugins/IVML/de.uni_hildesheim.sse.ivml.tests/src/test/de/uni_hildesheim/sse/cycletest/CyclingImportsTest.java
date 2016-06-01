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
package test.de.uni_hildesheim.sse.cycletest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.filter.FilterType;
import test.de.uni_hildesheim.sse.AbstractTest;

/**
 * Tests that in a complex cycling project structure (based on QM, May 2016), not different {@link Project}s
 * are created for the same import.
 * @author El-Sharkawy
 */
public class CyclingImportsTest extends AbstractTest {
    
    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "scenarios/qm_may16");

    /**
     * Creates a model file object for {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    
    /**
     * Test that even in cycling imports for all project imports only one {@link Project}
     * instance is created.
     *  @throws IOException Problems finding or reading the model file
     */
    @Test
    public void testSingleProjectInstances() throws IOException {
        List<Project> projects = assertEqual(createFile("QM"), "QM", "0", null);
        Assert.assertEquals(1, projects.size());
        
        Project mainProject = projects.get(0);
        UsedProjectFinder finder = new UsedProjectFinder(mainProject, FilterType.ALL);
        mainProject.accept(finder);
        
        Collection<Project> usedProjects = finder.getUsedProjects();
        assertProjects(usedProjects);
    }
    
    /**
     * Checks that for each project (unique by name) only one {@link Project} instance was created.
     * @param usedProjects The result of the visitation, all found project instances.
     */
    private void assertProjects(Collection<Project> usedProjects) {
        Map<String, List<Project>> projectMap = new HashMap<String, List<Project>>();
        for (Project project : usedProjects) {
            List<Project> projects = projectMap.get(project.getName());
            if (null == projects) {
                projects = new ArrayList<Project>();
                projectMap.put(project.getName(), projects);
            }
            projects.add(project);
        }
        
        for (Map.Entry<String, List<Project>> entry : projectMap.entrySet()) {
            int nProjects = entry.getValue().size();
            if (nProjects > 1) {
                Assert.fail("Project \"" + entry.getKey() + "\" has " + nProjects
                    + " different Project instances.");
            }
        }
    }
}
