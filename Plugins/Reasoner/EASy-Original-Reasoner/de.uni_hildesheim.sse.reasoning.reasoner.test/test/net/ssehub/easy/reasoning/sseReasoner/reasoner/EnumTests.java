package net.ssehub.easy.reasoning.sseReasoner.reasoner;

import net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the enum tests for SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Eichelberger
 */
public class EnumTests extends net.ssehub.easy.reasoning.core.reasoner.EnumTests {

    /**
     * Creates a specific test instance.
     */
    public EnumTests() {
        super(TestDescriptor.INSTANCE);
    }

}
