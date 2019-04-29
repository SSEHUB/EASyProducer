package test.net.ssehub.easy.reasoning.sseReasoner.capabilities;

import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Attribute tests. Inheritance is used here to be able
 * to override and disable some tests, e.g., during development.
 * 
 * @author Sizonenko
 * @author El-Sharkawy
 */
public class AttributeTests extends test.net.ssehub.easy.reasoning.core.capabilities.AttributeTests {

    /**
     * Creates a specific test instance.
     */
    public AttributeTests() {
        super(TestDescriptor.INSTANCE);
    }

}
