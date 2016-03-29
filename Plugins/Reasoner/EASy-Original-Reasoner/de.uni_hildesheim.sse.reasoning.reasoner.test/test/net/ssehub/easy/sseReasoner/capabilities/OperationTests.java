
package net.ssehub.easy.sseReasoner.capabilities;

import org.junit.BeforeClass;

import net.ssehub.easy.sseReasoner.reasoner.Utils;

/**
 * Configures the operation tests for the SSE-Reasoner.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class OperationTests extends net.ssehub.easy.reasonerCore.frontend.OperationTests {

    /**
     * Initializes the tests (for single execution outside the suite).
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        Utils.init();
    }

}
