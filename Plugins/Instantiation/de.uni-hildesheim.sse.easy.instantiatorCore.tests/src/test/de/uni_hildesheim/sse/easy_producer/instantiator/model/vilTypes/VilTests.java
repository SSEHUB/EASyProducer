package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The test suite for VilTypes.
 * 
 * @author Holger Eichelberger
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({TypeRegistryTest.class, TypeDescriptorTest.class, 
    ArtifactFactoryTest.class, ConfigurationTests.class })
public class VilTests {

}
