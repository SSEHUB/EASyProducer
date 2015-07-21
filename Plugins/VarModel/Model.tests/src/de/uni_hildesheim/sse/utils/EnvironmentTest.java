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
package de.uni_hildesheim.sse.utils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;


/**
 * Tests the {@link Environment} utility functions.
 * @author El-Sharkawy
 *
 */
public class EnvironmentTest {

    /**
     * Tests whether URLs containing a whitespace can be converted correctly.
     * @throws MalformedURLException Must not occur, otherwise this test is broken (wrong call of URL constructor).
     */
    @Test
    public void testToFile() throws MalformedURLException {
        String home = System.getProperty("user.home");
        Assert.assertNotNull("Error: Could not retrieve a folder for testing", home);
        // It is not necessary that tested location really exists.
        File file = new File(home, "resource conaining whitepaces");
        file = new File(file, "subResourceWithoutWhitespaces");

        // Test: Covert to URL and back to File
        URL testURL = new URL("file:///" + file.getAbsolutePath());
        System.out.println(testURL);
        File convertedFile = Environment.toFile(testURL);
        
        // Test postcondition: Both files must point to the same address
        Assert.assertEquals(file, convertedFile); 
    }
}
