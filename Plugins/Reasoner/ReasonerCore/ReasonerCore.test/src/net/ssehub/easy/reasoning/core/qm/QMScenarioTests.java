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
package net.ssehub.easy.reasoning.core.qm;

import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Configures the operation tests for SSE reasoner.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class QMScenarioTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected QMScenarioTests(ITestDescriptor descriptor) {
        super(descriptor, "qmTemplates");
    }
    
    /**
     * Tests QM Hardware collections.
     */
    @Test    
    public void qmHardwareTest() {
        reasoningTest("QMHardwareTest.ivml", 1);
    }
    
    /**
     * Tests collections.
     */
    @Test    
    public void nestedHardwareTest() {
        reasoningTest("nestedHardwareTest.ivml", 1);
    } 
    
    /**
     * Tests QM Family Algorithms fields test.
     */
    @Test    
    public void qmFamilyAlgorithmsFieldsTest() {
        reasoningTest("QMFamilyAlgorithmsFieldsTest.ivml", 1); // fail as stated in model
    } 

}
