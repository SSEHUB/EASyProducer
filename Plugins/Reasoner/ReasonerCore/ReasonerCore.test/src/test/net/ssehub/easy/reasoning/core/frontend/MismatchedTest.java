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
package test.net.ssehub.easy.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Test of reasoner capabilities related to the structure of variability models.
 * 
 * @author El-Sharkawy
 */
public class MismatchedTest extends AbstractTest {
    
    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected MismatchedTest(ITestDescriptor descriptor) {
        super(descriptor, "mismatchExample");
    }
    
    /**
     * Reduced QM model with failing typeCheck of FE.
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testMismatchTestFail() throws IOException {
        resultHandler(0, 0, loadCompleteProject("MismatchTest")); // changed over time
    }

}
