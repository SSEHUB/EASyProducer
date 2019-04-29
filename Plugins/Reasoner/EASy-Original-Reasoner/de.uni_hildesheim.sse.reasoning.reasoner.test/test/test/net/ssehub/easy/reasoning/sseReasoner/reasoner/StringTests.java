package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the string tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class StringTests extends test.net.ssehub.easy.reasoning.core.reasoner.StringTests {

    /**
     * Creates a specific test instance.
     */
    public StringTests() {
        super(TestDescriptor.INSTANCE);
    }

}
