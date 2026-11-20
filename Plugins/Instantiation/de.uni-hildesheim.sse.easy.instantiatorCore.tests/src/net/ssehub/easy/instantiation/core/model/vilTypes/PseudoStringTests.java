/*
 * Copyright 2009-2026 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests {@link PseudoString}.
 * 
 * @author Holger Eichelberger
 */
public class PseudoStringTests {
    
    /**
     * Tests {@link PseudoString#relativizeFolder(String, String)}.
     */
    @Test
    public void testRelativizeFolder() {
        assertFolderEquals("../../../resources/software", 
            PseudoString.relativizeFolder(path("/a/b/target/gen/py"), path("/a/b/resources/software")));
        assertFolderEquals(".", 
            PseudoString.relativizeFolder("/a/b/", "/a/b/"));
        assertFolderEquals("./c/d", 
            PseudoString.relativizeFolder("/a/b/", "/a/b/c/d"));
    }
    
    /**
     * Constructs an operating system specific path.
     * 
     * @param path the path, given in Windows or Linux form
     * @return the operating-system specific path, for Windows we may assume an arbitrary drive letter
     */
    public static String path(String path) {
        String result = path;
        if (File.separatorChar == '\\') { // assume Windows
            result = path.replace('/', File.separatorChar);
            if (result.startsWith(File.separator)) {
                result = "W:" + result; // pretend there is a drive
            }
        } else {
            result = path.replace('\\', File.separatorChar);
            if (result.matches("^\\w:.*")) {
                result = result.substring(2);
            }
        }
        return result;
    }

    /**
     * Asserts two folders after normalizing their syntax.
     * 
     * @param expected the expected folder
     * @param actual the actual folder
     */
    public static void assertFolderEquals(String expected, String actual) {
        Assert.assertEquals(normalizeFolder(expected), normalizeFolder(actual));
    }
    
    /**
     * Normalizes the folder syntax to "Linux".
     * 
     * @param folder the folder
     * @return the normalized folder
     */
    public static String normalizeFolder(String folder) {
        return folder.replace('\\', '/');
    }

    @Test
    public void testisURI() {
        Assert.assertFalse(PseudoString.isURI(null));
        Assert.assertTrue(PseudoString.isURI("")); // can be empty
        Assert.assertTrue(PseudoString.isURI("https://example.com"));
        Assert.assertTrue(PseudoString.isURI("https://example.com/path"));
    }

    @Test
    public void testisURL() {
        Assert.assertFalse(PseudoString.isURL(null));
        Assert.assertFalse(PseudoString.isURL(""));
        Assert.assertFalse(PseudoString.isURL("a"));
        Assert.assertTrue(PseudoString.isURL("https://example.com"));
        Assert.assertTrue(PseudoString.isURL("https://example.com/path"));
    }
    
    @Test
    public void testIsAbsolute() {
        Assert.assertFalse(PseudoString.isAbsolute(null));
        Assert.assertFalse(PseudoString.isAbsolute("./file"));
    }

    @Test
    public void testIsBlank() {
        Assert.assertFalse(PseudoString.isBlank(null));
        Assert.assertFalse(PseudoString.isBlank("a"));
        Assert.assertTrue(PseudoString.isBlank(""));
        Assert.assertTrue(PseudoString.isBlank("   "));
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(PseudoString.isEmpty(null));
        Assert.assertFalse(PseudoString.isEmpty("a"));
        Assert.assertTrue(PseudoString.isEmpty(""));
        Assert.assertFalse(PseudoString.isEmpty("   "));
    }

}
