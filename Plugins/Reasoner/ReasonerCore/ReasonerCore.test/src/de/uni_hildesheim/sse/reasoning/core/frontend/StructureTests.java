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
package de.uni_hildesheim.sse.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

/**
 * Test of reasoner capabilities related to the structure of variability models.
 * @author El-Sharkawy
 *
 */
public abstract class StructureTests extends AbstractReasonerFrontendTest {
    
    /**
     * Performs a test directly located in the structure test directory [convenience].
     * 
     * @param subFolder The subfolder inside structure, which contain all related projects of the same test.
     * @param projectName the name of the file directly located in the test directory
     * @param isValid whether the model shall be valid (or not) to pass
     * 
     * @throws IOException in case of problems reading a model
     */
    private void performStructureCheck(String subFolder, String projectName, boolean isValid) throws IOException {
        performCheck("structure/" + subFolder, projectName, isValid);
    }
    
    /**
     * Tests whether the reasoner can handle 2 projects with cycling imports and variable declarations or whether
     * it stucks inside an endless loop.
     * <pre><code>
     * project ImportCycleTest_CyclingDeclarations_A {
     *
     *   version v0;
     *   import ImportCycleTest_CyclingDeclarations_B;
     *   Integer varA = varB + 1;
     * }
     * 
     * project ImportCycleTest_CyclingDeclarations_B {
     *
     *   version v0;
     *   import ImportCycleTest_CyclingDeclarations_A;
     *   Integer varB = 1;
     *   Integer varC = varA + 1;
     * }
     * </code></pre>
     * <b>Timeout:</b> It's a very simple test case, but reasoner may run into an endless loop.
     * For this reason, I specified a short timeout. Timeout may be shorter.
     * @throws IOException in case of problems reading a mode
     */
//    @Test(timeout = 1000)
    @Test()
    public void testCyclingDeclarations() throws IOException {
        performStructureCheck("CycleTest_CyclingDeclarations", "ImportCycleTest_CyclingDeclarations_A", true);
    }

}
