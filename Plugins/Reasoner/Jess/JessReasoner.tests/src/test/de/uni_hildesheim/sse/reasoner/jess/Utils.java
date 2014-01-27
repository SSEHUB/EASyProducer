package test.de.uni_hildesheim.sse.reasoner.jess;

import de.uni_hildesheim.sse.reasoner.jess.JessReasonerInitializer;
import de.uni_hildesheim.sse.reasoning.core.frontend.AbstractReasonerFrontendTest;
import de.uni_hildesheim.sse.reasoning.core.frontend.TestConfiguration;

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
            "JessReasoner.tests", 
            null, 
            true, // CHECK
            false), // CONSISTENT
            JessReasonerInitializer.INSTANCE);
    }

}
