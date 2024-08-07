/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package standalone;

import java.io.IOException;

import org.junit.Test;

import org.junit.Assert;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;

/**
 * Contains all jUnit tests.
 * 
 * @author Holger Eichelberger
 */
public class StandaloneTests {

    /**
     * Tests the standalone version.
     * 
     * @throws ModelManagementException shall not occur, test failure
     * @throws IOException shall not occur, test failure
     */
    @Test
    public void testStandalone() throws ModelManagementException, IOException {
        String[] args = new String[1];
        args[0] = System.getProperty("EASyCommandlineTests.models", null);
        try {
            standalone.Test.main(args);
        } catch (TestFailedException e) {
            Assert.fail(e.getMessage());
        }
    }
    
}
