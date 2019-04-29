package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the interface tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class InterfaceTests extends test.net.ssehub.easy.reasoning.core.reasoner.InterfaceTests {

    /**
     * Creates a specific test instance.
     */
    public InterfaceTests() {
        super(TestDescriptor.INSTANCE);
    }

}
