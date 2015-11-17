
package de.uni_hildesheim.sse.reasoning.capabilities;

import org.junit.BeforeClass;

import de.uni_hildesheim.sse.reasoning.reasoner.Utils;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class OperationTests extends de.uni_hildesheim.sse.reasoning.core.frontend.OperationTests {

    /**
     * Initializes the tests (for single execution outside the suite).
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        Utils.init();
    }

}
