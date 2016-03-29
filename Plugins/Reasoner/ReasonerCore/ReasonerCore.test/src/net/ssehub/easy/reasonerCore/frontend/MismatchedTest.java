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
package net.ssehub.easy.reasonerCore.frontend;

import java.io.IOException;

import org.junit.Test;

/**
 * Test of reasoner capabilities related to the structure of variability models.
 * @author El-Sharkawy
 *
 */
public abstract class MismatchedTest extends AbstractReasonerFrontendTest {
    
    /**
     * Performs a test directly located in the structure test directory [convenience].
     * 
     * @param projectName the name of the file directly located in the test directory
     * @param isValid whether the model shall be valid (or not) to pass
     * 
     * @throws IOException in case of problems reading a model
     */
    private void performStructureCheck(String projectName, boolean isValid) throws IOException {
        performCheck("mismatchExample/", projectName, isValid);
    }
    
    /**
     * Reduced QM model with failing typeCheck of FE.
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMismatchTestFail() throws IOException {
        performStructureCheck("MismatchTest", false);
    }
    

}
