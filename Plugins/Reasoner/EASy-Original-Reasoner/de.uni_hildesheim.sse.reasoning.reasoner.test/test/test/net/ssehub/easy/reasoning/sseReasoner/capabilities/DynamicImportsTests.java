package test.net.ssehub.easy.reasoning.sseReasoner.capabilities;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Dynamic imports tests tests. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class DynamicImportsTests extends test.net.ssehub.easy.reasoning.core.capabilities.DynamicImportsTests {

    /**
     * Creates a specific test instance.
     */
    public DynamicImportsTests() {
        super(TestDescriptor.INSTANCE);
    }

}
