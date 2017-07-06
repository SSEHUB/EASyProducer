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
package net.ssehub.easy.producer.scenario_tests;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.instantiation.maven.Registration;

/**
 * Runs experiment tests from scenarios.
 * 
 * @author Holger Eichelberger
 */
public class ExperimentsTests extends AbstractScenarioTest {

    private static ExperimentsTests tests;
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "experiments");
    }
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new ExperimentsTests();
        tests.cleanTemp();
        Registration.register();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (!debug && null != tests) {
//TODOtests.cleanTemp();
            tests = null;
        }
    }

    /**
     * Prevent no runnable methods.
     */
    @Test
    public void dummy() {
    }

}
