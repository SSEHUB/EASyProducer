package test.net.ssehub.easy.reasoning.core.frontend;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import test.net.ssehub.easy.reasoning.core.reasoner.AbstractTest;
import test.net.ssehub.easy.reasoning.core.reasoner.ITestDescriptor;

/**
 * Old tests - please review, revise, refactor or skip.
 * 
 * @author Phani
 */
public abstract class OldTests extends AbstractTest {

    /**
     * Creating a test instance.
     * 
     * @param descriptor the test descriptor
     */
    protected OldTests(ITestDescriptor descriptor) {
        super(descriptor, ".");
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBasisDatatypeIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException,
                    IvmlException, IOException {

        Project p = loadProject("testBasisDatatype.ivml");
        Configuration config = new Configuration(p);
        configureValue(config, "intA", "1");
        configureValue(config, "realA", "2.0");
        configureValue(config, "boolA", "true");
        configureValue(config, "stringA", "A string");

        assertPropagation(0, 0, config);
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testBasisDatatypeIsInvalid() throws ValueDoesNotMatchTypeException, ConfigurationException,
                    IvmlException, IOException {

        Project p = loadProject("testBasisDatatype.ivml");
        Configuration config = new Configuration(p);
        configureValue(config, "intA", "1");
        configureValue(config, "realA", "2.0");
        configureValue(config, "boolA", "false");
        configureValue(config, "stringA", "A string");

        assertPropagation(1, 0, config); // count may be wrong
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testComplexDatatypeIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException,
                    IvmlException, IOException {

        Project p = loadProject("testComplexDatatype.ivml");

        Configuration config = new Configuration(p);
        configureValue(config, "a1", "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringA1");
        configureValue(config, "a2", "intA", "2", "realA", "2.0", "boolA", "false", "stringA", "aStringA2");
        configureValue(config, "b1", "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringB1");
        configureValue(config, "b2", "intA", "2", "realA", "2.8", "boolA", "false", "stringA", "aStringB2");

        assertPropagation(0, 0, config);
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testComplexDatatypeIsInvalid() throws ValueDoesNotMatchTypeException, ConfigurationException,
                    IvmlException, IOException {

        Project p = loadProject("testComplexDatatype.ivml");
        Configuration config = new Configuration(p);
        configureValue(config, "a1", "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringA1");
        configureValue(config, "a2", "intA", "2", "realA", "2.0", "boolA", "true", "stringA", "aStringA2");
        configureValue(config, "b1", "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringB1");
        configureValue(config, "b2", "intA", "2", "realA", "2.0", "boolA", "true", "stringA", "aStringB2");

        assertPropagation(1, 0, config); // count may be wrong
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testEnumIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException,
                    IOException {

        Project p = loadProject("testEnum.ivml");
        Configuration config = new Configuration(p);

        assertPropagation(0, 0, config);
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testGeneralIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException,
                    IOException {

        Project p = loadProject("testGeneral.ivml");
        Configuration config = new Configuration(p);

        assertPropagation(0, 0, config);
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testInfrastructureIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException,
                    IvmlException, IOException {

        Project p = loadProject("testInfrastructure.ivml");
        Configuration config = new Configuration(p);

        assertPropagation(0, 0, config);
    }

    /**
     * Unknown.
     * 
     * @throws ValueDoesNotMatchTypeException in case that a value cannot be applied
     * @throws ConfigurationException in case that a configuration cannot be changed
     * @throws IvmlException in case of type problems in the model
     * @throws IOException in case of problems reading a model
     */
    @Test
    public void testInfraIsValid() throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException,
                    IOException {

        Project p = loadProject("testInfra.ivml");
        Configuration config = new Configuration(p);

        assertPropagation(0, 0, config);
    }

}
