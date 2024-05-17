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
package de.uni_hildesheim.sse.easy.ant.modelcopy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests the {@link ModelCopy} class based on the QualiMaster model.
 * @author El-Sharkawy
 *
 */
public class ModelCopyTest {
    
    // Input for testing
    private final static File DESTINATION_FOLDER = new File("model/copy");
    private final static File ORIGINAL_FOLDER = new File("model/origin");
    private final static File COMPARISON_FOLDER = new File("model/expected");
    private final static String MAIN_PROJECT = "QM";
    
    /**
     * Copies the QualiMaster model and test precondition. The methods tests whether specific files are copied
     * correctly. 
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        // Test precondition: Dest folder does not exist, org folder does exist 
        if (DESTINATION_FOLDER.exists()) {
            try {
                FileUtils.deleteDirectory(DESTINATION_FOLDER);
            } catch (IOException e) {
                Assert.fail("Could not cleanup destination directory \"" + DESTINATION_FOLDER.getAbsolutePath() + "\":"
                    + e.getMessage());
            }
        }
        Assert.assertFalse("Destination folder \"" + DESTINATION_FOLDER.getAbsolutePath()
        + "\"exists and could not be deleted.", DESTINATION_FOLDER.exists());
        Assert.assertTrue("Original folder \"" + ORIGINAL_FOLDER.getAbsolutePath() + "\"does not exist.", ORIGINAL_FOLDER.exists());
        
        ModelCopy copy = new ModelCopy(ORIGINAL_FOLDER.getAbsolutePath(), DESTINATION_FOLDER.getAbsolutePath(), MAIN_PROJECT);
        copy.execute();        
    }

    /**
     * Tests that the PipliesCfg is filtered correctly.
     */
    @Test
    public void testPipelinesCfg() {      
        assertIVMLConfigFile("pipelines/PipelinesCfg.ivml");
    }
    
    /**
     * Tests that BasicCfg is filtered correctly.
     */
    @Test
    public void testBasicCfg() {
        assertIVMLConfigFile("infrastructure/BasicsCfg.ivml");
    }
    
    /**
     * Tests that AlgorithmsCfg is filtered correctly.
     */
    @Test
    public void testAlgorithmsCfg() {
        assertIVMLConfigFile("infrastructure/AlgorithmsCfg.ivml");
    }
    
    /**
     * Tests that DataManagementCfg is filtered correctly.
     */
    @Test
    public void testDataManagementCfg() {
        assertIVMLConfigFile("infrastructure/DataManagementCfg.ivml");
    }
    
    /**
     * Tests that FamiliesCfg is filtered correctly.
     */
    @Test
    public void testFamiliesCfg() {
        assertIVMLConfigFile("infrastructure/FamiliesCfg.ivml");
    }
    
    /**
     * Tests that HardwareCfg is filtered correctly.
     */
    @Test
    public void testHardwareCfg() {
        assertIVMLConfigFile("infrastructure/HardwareCfg.ivml");
    }
    
    /**
     * Tests that InfrastructureCfg is filtered correctly.
     */
    @Ignore("Currently not working")
    @Test
    public void testInfrastructureCfg() {
        assertIVMLConfigFile("infrastructure/InfrastructureCfg.ivml");
    }
    
    /**
     * Tests that ReconfigurableHardwareCfg is filtered correctly.
     */
    @Test
    public void testReconfigurableHardwareCfg() {
        assertIVMLConfigFile("infrastructure/ReconfigurableHardwareCfg.ivml");
    }

    /**
     * Compares a generated IVML file with another IVML file for specifying the desired output.
     * @param sampleFile The relative file name inside the {@link #ORIGINAL_FOLDER}.
     */
    private void assertIVMLConfigFile(String sampleFile) {
        try {
            File copiedFile = new File(DESTINATION_FOLDER, sampleFile);
            File expectedFile = new File(COMPARISON_FOLDER, sampleFile);
            Assert.assertTrue("Expected file \"" + expectedFile.getAbsolutePath() + "\" does not exist.",
                expectedFile.exists());
            Assert.assertTrue("File \"" + copiedFile.getAbsolutePath() + "\" was not created.", copiedFile.exists());
            String expectedContents = FileUtils.readFileToString(expectedFile, Charset.defaultCharset())
                .replace("\r", "").trim();
            String copiedContents = FileUtils.readFileToString(copiedFile, Charset.defaultCharset())
                .replace("\r", "").trim();
            /*System.out.println(">> expected");
            System.out.println(expectedContents);
            System.out.println("<< expected");
            System.out.println(">> copied");
            System.out.println(copiedContents);
            System.out.println("<< copied");*/
            Assert.assertEquals("Configuration file was not filtered correctly.", expectedContents, copiedContents);
        } catch (IOException e) {
            Assert.fail("IVML files could not be read: " + e.getMessage());
        }
    }

}
