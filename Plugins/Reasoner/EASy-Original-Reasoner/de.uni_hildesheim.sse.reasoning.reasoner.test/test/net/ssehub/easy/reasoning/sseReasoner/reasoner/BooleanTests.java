package net.ssehub.easy.reasoning.sseReasoner.reasoner;

import net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the boolean tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 * @author Eichelberger
 */
public class BooleanTests extends net.ssehub.easy.reasoning.core.reasoner.BooleanTests {

    /**
     * Creates a specific test instance.
     */
    public BooleanTests() {
        super(TestDescriptor.INSTANCE);
    }

}
