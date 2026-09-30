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
        assertFolderEquals("..\\..\\..\\resources\\software", 
            PseudoString.relativizeFolder("W:\\a\\b\\target\\gen\\py", "W:\\a\\b\\resources\\software"));
        assertFolderEquals(".", 
            PseudoString.relativizeFolder("W:\\a\\b\\", "W:\\a\\b\\"));
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

}
