package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the integer tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class IntegerTests extends test.net.ssehub.easy.reasoning.core.reasoner.IntegerTests {

    /**
     * Creates a specific test instance.
     */
    public IntegerTests() {
        super(TestDescriptor.INSTANCE);
    }

}
