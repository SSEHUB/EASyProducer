/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.reasoning.capabilities;

import org.junit.BeforeClass;

import de.uni_hildesheim.sse.reasoning.reasoner.Utils;

/**
 * Configures the {@link de.uni_hildesheim.sse.reasoning.core.frontend.CollectionOperationsTests}
 * for the SSE-Reasoner.
 * @author El-Sharkawy
 */
public class CollectionOperationsTests extends de.uni_hildesheim.sse.reasoning.core.frontend.CollectionOperationsTests {

    /**
     * Initializes the tests (for single execution outside the suite).
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        Utils.init();
    }
}
