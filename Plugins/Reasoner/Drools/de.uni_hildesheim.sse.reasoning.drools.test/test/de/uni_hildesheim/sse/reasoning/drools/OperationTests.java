
package de.uni_hildesheim.sse.reasoning.drools;

import org.junit.BeforeClass;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Holger Eichelberger
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
