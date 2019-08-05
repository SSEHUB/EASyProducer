package net.ssehub.easy.instantiation.core.model.vilTypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for VilTypes.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TypeRegistryTest.class, TypeDescriptorTest.class, 
    ArtifactFactoryTest.class, ConfigurationTests.class, SerializationTest.class })
public class VilTests {

}
