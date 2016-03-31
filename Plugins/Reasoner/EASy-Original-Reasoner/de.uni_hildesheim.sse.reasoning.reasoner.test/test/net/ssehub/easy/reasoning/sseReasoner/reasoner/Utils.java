package net.ssehub.easy.reasoning.sseReasoner.reasoner;

import net.ssehub.easy.reasoning.core.frontend.AbstractReasonerFrontendTest;
import net.ssehub.easy.reasoning.core.frontend.TestConfiguration;
import net.ssehub.easy.reasoning.sseReasoner.ReasonerInitializer;

/**
 * Test utilities.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

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
            "net.ssehub.easy.reasoning.sseReasoner.tests", 
            null, 
            true, // CHECK
            false), // CONSISTENT
            ReasonerInitializer.INSTANCE);
    }

}
