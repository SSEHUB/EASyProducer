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

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy.ant.modelcopy.ModelCopy;

/**
 * Tests the {@link ModelCopy} class.
 * @author El-Sharkawy
 *
 */
public class ModelCopyTest {

    @Test
    public void test() throws IOException {
        // Input for testing
        File destFolder = new File("model/copy");
        File orgFolder = new File("model/origin");
        String mainProject = "QM";

        // Test precondition: Dest folder does not exist, org folder does exist 
        if (destFolder.exists()) {
            FileUtils.deleteDirectory(destFolder);
        }
        Assert.assertFalse("Destination folder \"" + destFolder.getAbsolutePath()
            + "\"exists and could not be deleted.", destFolder.exists());
        Assert.assertTrue("Original folder \"" + orgFolder.getAbsolutePath() + "\"does not exist.", orgFolder.exists());
             
        ModelCopy copy = new ModelCopy(orgFolder.getAbsolutePath(), destFolder.getAbsolutePath(), mainProject);
        copy.execute();
        
        // Testing one sample:
        String sampleFile = "pipelines/PipelinesCfg.ivml";
        File copiedFile = new File(destFolder, sampleFile);
        File orgFile = new File(orgFolder, sampleFile);
        Assert.assertTrue("Original file \"" + orgFile.getAbsolutePath() + "\" was deleted.", orgFile.exists());
        Assert.assertTrue("File \"" + copiedFile.getAbsolutePath() + "\" was not created.", copiedFile.exists());
        String orgContents = FileUtils.readFileToString(orgFile).replace("\r", "").trim();
        String copiedContents = FileUtils.readFileToString(copiedFile).replace("\r", "").trim();
        Assert.assertNotEquals("Configuration file was not filtered", orgContents, copiedContents);
    }

}
