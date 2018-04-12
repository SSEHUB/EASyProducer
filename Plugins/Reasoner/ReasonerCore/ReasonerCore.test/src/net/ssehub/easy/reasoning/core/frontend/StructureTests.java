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
package net.ssehub.easy.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;
import net.ssehub.easy.varModel.model.Project;

/**
 * Test of reasoner capabilities related to the structure of variability models.
 * @author El-Sharkawy
 *
 */
public class StructureTests extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected StructureTests(ITestDescriptor descriptor) {
        super(descriptor, null);
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
    @Test(timeout = 4000)
    public void testCyclingDeclarations() throws IOException {
        Project prj = loadCompleteProject("structure/CycleTest_CyclingDeclarations", 
            "ImportCycleTest_CyclingDeclarations_A");
        resultHandler(0, 0, prj);
    }
    
    /**
     * Tests whether the reasoner can handle a project importing a cycle structure with variable declarations or whether
     * it stucks inside an endless loop.
     * <b>Timeout:</b> It's a very simple test case, but reasoner may run into an endless loop.
     * For this reason, I specified a short timeout. Timeout may be shorter.
     * @throws IOException in case of problems reading a mode
     */
    @Test(timeout = 4000)
    public void testNestedCycle() throws IOException {
        Project prj = loadCompleteProject("structure/CycleTest_NestedCycle", "NestedCycleTest_MainProject");
        resultHandler(0, 0, prj);
    }

}
