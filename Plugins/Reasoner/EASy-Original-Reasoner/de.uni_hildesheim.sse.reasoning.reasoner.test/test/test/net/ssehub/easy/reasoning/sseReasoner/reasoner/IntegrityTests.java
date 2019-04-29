package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Configures the integrity tests for the SSE reasoner. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class IntegrityTests extends test.net.ssehub.easy.reasoning.core.reasoner.IntegrityTests {
    
    /**
     * Creates a specific test instance.
     */
    public IntegrityTests() {
        super(TestDescriptor.INSTANCE);
    }
    
}
