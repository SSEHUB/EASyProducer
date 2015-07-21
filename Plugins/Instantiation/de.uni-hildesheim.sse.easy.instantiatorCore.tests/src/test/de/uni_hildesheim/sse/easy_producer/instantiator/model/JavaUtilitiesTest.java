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
package test.de.uni_hildesheim.sse.easy_producer.instantiator.model;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.JavaUtilities;

/**
 * Tests the {@link JavaUtilities} class.
 * 
 * @author Holger Eichelberger
 * @author Sascha El-Sharkawy
 */
public class JavaUtilitiesTest {

    /**
     * Tests the JDK path variable.
     */
    @Test
    public void testJdkPath() {
        String jdkPath = JavaUtilities.JDK_PATH;
        if (null != jdkPath) { // unlikely, but just in case that we run this in Eclipse just in a JRE
            File bin = new File(jdkPath);
            Assert.assertTrue("JDK path does not exist", bin.exists());
            bin = new File(bin, "bin");
            Assert.assertTrue("bin dir in JDK path does not exist", bin.exists());
            boolean javacFound = false;
            boolean javaFound = false;
            File[] binFiles = bin.listFiles();
            Assert.assertNotNull("bin files must not be null", binFiles);
            for (File f : binFiles) {
                String name = f.getName();
                int pos = name.indexOf('.');
                if (pos > 0) { // Unix?
                    name = name.substring(0, pos);
                }
                javaFound |= "java".equals(name);
                javacFound |= "javac".equals(name);
                // Do not test javaw as it is not part of the openJDK on Ubuntu (and maybe other systems)
            }
            Assert.assertTrue("java not found in JDK path/bin", javaFound);
            Assert.assertTrue("javac not found in JDK path/bin", javacFound);
        } else {
            Assert.fail("JavaUtilities is not able to detect the JDK PATH.");
        }
    }

}
