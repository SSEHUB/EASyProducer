
package test.de.uni_hildesheim.sse.reasoner.jess;

import org.junit.BeforeClass;

/**
 * Configures the operation tests for Drools.
 * 
 * @author Holger Eichelberger
 */
public class OperationTests extends de.uni_hildesheim.sse.reasoning.core.frontend.OperationTests {

    /**
     * Initializes the tests (for single execution outside the suite).
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("JESS");
        Utils.init();
    }

}
