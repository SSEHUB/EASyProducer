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
package de.uni_hildesheim.sse.vil.rt.tests;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractExecutionTest;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.reasoning.core.frontend.ReasonerFrontend;
import de.uni_hildesheim.sse.reasoning.reasoner.Reasoner;

/**
 * An abstract basic rt-VIL test.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractRtTest extends AbstractExecutionTest<Script> {

    private static boolean reasonerRegistered = false;
    
    /**
     * Registers the reasoner but only once per VM test execution.
     */
    protected static void registerReasoner() {
        if (!reasonerRegistered) {
            ReasonerFrontend.getInstance().getRegistry().register(new Reasoner());
            reasonerRegistered = true;
        }
    }
    
    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new RtVilTestConfigurer();
    }

}
