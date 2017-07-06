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
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils;

/**
 * Experiment tests that currently can only be executed locally.
 * 
 * @author Holger Eichelberger
 */
public class LocalExperimentsTests extends ExperimentsTests {

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        ExperimentsTests.startUp();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        ExperimentsTests.shutDown();
    }

    /**
     * Test modified QM XML templates (modified to run without variability model).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testXml() throws IOException {
        File tmp = executeCase("xmlExperiments", null, "", null);
        File expected = new File(tmp, "GenTopoHardwareCorrelationFinancialPom.xml");
        TextTestUtils.assertFileEquality(new File(tmp, "hwAlg.xml"), expected);
        TextTestUtils.assertFileEquality(new File(tmp, "hwAlg1.xml"), expected);
        TextTestUtils.assertFileEquality(new File(tmp, "hwAlg2.xml"), expected);
        TextTestUtils.assertFileEquality(new File(tmp, "hwAlg3.xml"), expected);
        
        expected = new File(tmp, "ModelGenPom.xml");
        TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom.xml"), expected);
        //
        //
        TextTestUtils.assertFileEquality(new File(tmp, "modelGenPom3.xml"), expected);
    }

}
