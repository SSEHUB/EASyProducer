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
package de.uni_hildesheim.sse.vil.rt.tests;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import test.de.uni_hildesheim.sse.vil.buildlang.AbstractBasicTest;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;
import de.uni_hildesheim.sse.dslCore.translation.ErrorCodes;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
import de.uni_hildesheim.sse.vil.rt.RtErrorCodes;
import net.ssehub.easy.basics.messages.AbstractException;

/**
 * Basic syntactic language tests.
 * 
 * @author Holger Eichelberger
 */
public class BasicRtTests extends AbstractBasicTest<Script> { // unclear why AbstractRtTest does not work here

    private static BasicRtTests tests;
    
    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new BasicRtTests();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        tests.cleanTemp();
        tests = null;
    }
    
    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new RtVilTestConfigurer();
    }
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "basic-rt");
    }

    /**
     * Tests the empty rt-VIL script example from the specification.
     * Currently comments within a script are not stored in the model!
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testEmpty() throws IOException {
        assertEqual("empty"); // TODO add events
    }
    
    /**
     * Tests a simple tactic.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTactic1() throws IOException {
        assertEqual("tactic1");
    }

    /**
     * Tests a typed rule.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTypedRule() throws IOException {
        assertEqual("typedRule");
    }

    /**
     * Tests a failing tactic due to same signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTacticFail1() throws IOException {
        assertEqual("tacticFail1");
    }
    
    /**
     * Tests a tactic with a typed rule.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testTacticFail2() throws IOException {
        assertEqual("tacticFail2", ErrorCodes.REDEFINITION);
    }

    /**
     * Tests a strategy with sub strategies and tactics.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategy1() throws IOException {
        assertEqual("strategy1");
    }

    /**
     * Tests a failing strategy due to same signatures.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail1() throws IOException {
        assertEqual("strategyFail1", ErrorCodes.REDEFINITION);
    }

    /**
     * Tests a failing strategy due to a missing referenced sub-tactic.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail2() throws IOException {
        assertEqual("strategyFail2", VilException.ID_CANNOT_RESOLVE);
    }

    /**
     * Tests a failing strategy due to a missing referenced sub-strategy.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail3() throws IOException {
        assertEqual("strategyFail3", VilException.ID_CANNOT_RESOLVE);
    }

    /**
     * Tests a failing strategy due to a non-acyclic breakdown tree.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail4() throws IOException {
        assertEqual("strategyFail4", RtErrorCodes.CYCLIC_BREAKDOWN);
    }

    /**
     * Tests a failing strategy due to a mixing strategies and tactic in breakdown.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail5() throws IOException {
        assertEqual("strategyFail5", VilException.ID_CANNOT_RESOLVE);
    }

    /**
     * Tests a failing strategy due to mismatching tuple fields.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail6() throws IOException {
        assertEqual("strategyFail6", AbstractException.ID_SEMANTIC);
    }

    /**
     * Tests a failing strategy due to unknown tuple fields in the weighting expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail7() throws IOException {
        assertEqual("strategyFail7", ErrorCodes.UNKNOWN_ELEMENT);
    }

    /**
     * Tests a failing strategy due to an illegal typed timeout expression.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testStrategyFail8() throws IOException {
        assertEqual("strategyFail8", AbstractException.ID_SEMANTIC);
    }
    
    /**
     * Tests the import of a rt-VIL script.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport1() throws IOException {
        assertEqual("import1");
    }

    /**
     * Tests the import of a VIL script.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testImport2() throws IOException {
        assertEqual("import2");
    }
    
    /**
     * Tests correct syntax of the fail statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail1() throws IOException {
        assertEqual("fail1");
    }

    /**
     * Tests erroneous syntax of the fail statement.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testFail2() throws IOException {
        assertEqual("fail2", ErrorCodes.TYPE_CONSISTENCY);
    }

}
