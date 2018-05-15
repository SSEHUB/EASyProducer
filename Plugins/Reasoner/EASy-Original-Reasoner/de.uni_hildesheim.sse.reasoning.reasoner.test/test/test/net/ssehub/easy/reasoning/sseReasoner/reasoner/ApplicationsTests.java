package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the application tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class ApplicationsTests extends net.ssehub.easy.reasoning.core.reasoner.ApplicationsTests {

    /**
     * Creates a specific test instance.
     */
    public ApplicationsTests() {
        super(TestDescriptor.INSTANCE);
    }

}
