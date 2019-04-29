package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the real tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class RealTests extends test.net.ssehub.easy.reasoning.core.reasoner.RealTests {

    /**
     * Creates a specific test instance.
     */
    public RealTests() {
        super(TestDescriptor.INSTANCE);
    }

}
