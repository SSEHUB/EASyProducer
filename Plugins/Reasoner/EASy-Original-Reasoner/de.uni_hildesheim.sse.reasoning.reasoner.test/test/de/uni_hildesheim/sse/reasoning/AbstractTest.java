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
package de.uni_hildesheim.sse.reasoning;

import java.io.File;
import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.junit.Assert;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.reasoning.reasoner.Engine;
import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * General abstract test class for reasoning tests.
 * @author Sizonenko
 * @author El-Sharkawy
 *
 */
public abstract class AbstractTest extends de.uni_hildesheim.sse.dslCore.test.AbstractTest<Project> {
    
    public static final File TESTDATA = determineTestDataFolder("reasonerCore.testdata.home");
    
    /**
     * Method for handling reasoning result.
     * @param expectedFailedConstraints Number of constraints that are expected to fa
     * @param projectP1 Project to reason on.
     */
    protected static final void resultHandler(int expectedFailedConstraints, Project projectP1) {
        Configuration config = new Configuration(projectP1, false);        
        ReasonerConfiguration rConfig = new ReasonerConfiguration();

        // Perform reasoning
        Engine engine = new Engine(projectP1, config, rConfig, ProgressObserver.NO_OBSERVER);
        ReasoningResult result = engine.reason();
        
        // Test whether reasoning detected correct result  
        int failedConstraints = 0;
        StringBuffer errMsg = new StringBuffer();
        for (int i = 0; i < result.getMessageCount(); i++) {
            if (result.getMessage(i).getStatus() == Status.ERROR) {
                failedConstraints = failedConstraints + result.getMessage(i).getConflicts().size();
                errMsg.append("\n");
                errMsg.append(result.getMessage(i).getDescription());
            }
        }
        Assert.assertEquals("Failed constraints: " + failedConstraints + " of " + expectedFailedConstraints
            + errMsg.toString(), expectedFailedConstraints, failedConstraints);
    }
    
    /**
     * Helper method for load an IVML file.
     * @param testFolder The (sub-) folder where to load the specified IVML test files.
     * @param path The name of the ivml file to load (including the file extension) inside of the
     *     <tt>reasonerModel</tt> folder.
     * @return The loaded {@link Project} representing the read IVML file.
     */
    protected final Project loadProject(File testFolder, String path) {
        Project project = null;
        try {
            File projectFile = new File(testFolder, path);
            URI uri = URI.createFileURI(projectFile.getAbsolutePath());
            TranslationResult<Project> result = ModelUtility.INSTANCE.parse(uri);
            StringBuffer errorMsg = new StringBuffer();
            for (int i = 0; i < result.getMessageCount(); i++) {
                Message msg = result.getMessage(i);
                if (!msg.ignore()) {
                    errorMsg.append(msg.getDescription());
                    errorMsg.append("\n");
                }
            }
            if (errorMsg.length() == 0) {
                project = result.getResult(0);
            } else {
                Assert.fail(errorMsg.toString());
            }
            Assert.assertNotNull("Error: The loaded project " + path + " is NULL (should not happen)", project);
            VarModel.INSTANCE.updateModel(project, projectFile.toURI());
        } catch (IOException exc) {
            Assert.fail(exc.getLocalizedMessage());
        }
        
        return project;
    }

    /**
     * Method for determining folder with IVML files.
     * @param property property
     * @return folder location
     */
    public static File determineTestDataFolder(String property) {
        File testdataFolder = determineTestDataDir(property);
        String externalLocation = System.getProperty(property);
        
        // If no property was defined, use ReasonerCore.test/testdata directory
        if (null == externalLocation) {
            // Work around over the path avoids a NullPointer exception
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
        if (!testdataFolder.exists()) {
            String path = testdataFolder.getAbsolutePath();
            testdataFolder = new File(path);
            testdataFolder = testdataFolder.getParentFile().getParentFile().getParentFile();
            testdataFolder = new File(testdataFolder, "ReasonerCore");
            testdataFolder = new File(testdataFolder, "ReasonerCore.test");
            testdataFolder = new File(testdataFolder, "testdata");
        }
        return testdataFolder;    
    }
}
