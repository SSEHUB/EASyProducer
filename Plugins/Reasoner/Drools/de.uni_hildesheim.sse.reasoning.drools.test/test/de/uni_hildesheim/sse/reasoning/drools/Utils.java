package de.uni_hildesheim.sse.reasoning.drools;

import net.ssehub.easy.reasonerCore.frontend.AbstractReasonerFrontendTest;
import net.ssehub.easy.reasonerCore.frontend.TestConfiguration;

/**
 * Test utilities.
 * 
 * @author Holger Eichelberger
 */
class Utils {

    /**
     * Prevents creation from outside.
     */
    private Utils() {
    }
    
    /**
     * Initializes the tests (reusable method).
     */
    public static final void init() {
        AbstractReasonerFrontendTest.setupTests(new TestConfiguration(
            "de.uni_hildesheim.sse.reasoning.drools.test", 
            null, 
            true, // CHECK
            false), // CONSISTENT
            DroolsReasonerInitializer.INSTANCE);
    }

}
