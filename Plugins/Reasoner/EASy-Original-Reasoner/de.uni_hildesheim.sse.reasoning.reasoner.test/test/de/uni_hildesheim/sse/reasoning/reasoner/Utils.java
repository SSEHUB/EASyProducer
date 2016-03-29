package de.uni_hildesheim.sse.reasoning.reasoner;

import net.ssehub.easy.reasonerCore.frontend.AbstractReasonerFrontendTest;
import net.ssehub.easy.reasonerCore.frontend.TestConfiguration;

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
            "de.uni_hildesheim.sse.reasoning.reasoner.test", 
            null, 
            true, // CHECK
            false), // CONSISTENT
            ReasonerInitializer.INSTANCE);
    }

}
