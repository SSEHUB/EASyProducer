/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Tests for {@link Resolver}. Inheritance is used here to 
 * be able to override and disable some tests, e.g., during development.
 * 
 * @author El-Sharkawy
 * @author Sizonenko
 */
public class EvaluationIntegrityTest extends net.ssehub.easy.reasoning.core.reasoner.EvaluationIntegrityTest {

    /**
     * Creates a specific test instance.
     */
    public EvaluationIntegrityTest() {
        super(TestDescriptor.INSTANCE);
    }

}
