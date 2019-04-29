package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the compound tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class CompoundTests extends test.net.ssehub.easy.reasoning.core.reasoner.CompoundTests {

    /**
     * Creates a specific test instance.
     */
    public CompoundTests() {
        super(TestDescriptor.INSTANCE);
    }

}
