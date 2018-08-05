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
package net.ssehub.easy.producer.scenario_tests;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * A Scenario ramp-up test including a QualiMaster model.
 * 
 * @author Holger Eichelberger
 */
public class ScenarioRampUpTest extends RampUpTest {

    /**
     * Performs the ram-up test.
     * 
     * @throws ConfigurationException if setting an expression as default value fails
     * @throws ValueDoesNotMatchTypeException if a value does not match a type
     * @throws CSTSemanticException if a constraint is erroneously composed
     * @throws IOException if loading a model fails
     */
    @Test
    public void rampUpTest() throws ConfigurationException, ValueDoesNotMatchTypeException, 
        CSTSemanticException, IOException {
        super.rampUpTest();
        RealTests t = new RealTests();
        t.testQualiMasterFeb17Impl(Mode.REASON_NO_MEASURE);
    }

}
