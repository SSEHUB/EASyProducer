package net.ssehub.easy.reasonerCore.frontend;

import java.io.IOException;

import org.junit.Test;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Old tests - please review, revise, refactor or skip.
 * 
 * @author Phani
 */
public abstract class OldTests extends AbstractReasonerFrontendTest {

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
        configureValue(p, config, 0, "1");
        configureValue(p, config, 1, "2.0");
        configureValue(p, config, 2, "true");
        configureValue(p, config, 3, "A string");

        performCheck(p, config, true);
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
        configureValue(p, config, 0, "1");
        configureValue(p, config, 1, "2.0");
        configureValue(p, config, 2, "false");
        configureValue(p, config, 3, "A string");

        performCheck(p, config, false);
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

        // Position of needed variables in ivml file
        int posA1 = 2;
        int posA2 = posA1 + 1;
        int posB1 = posA2 + 1;
        int posB2 = posB1 + 1;

        Configuration config = new Configuration(p);
        configureValue(p, config, posA1, "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringA1");
        configureValue(p, config, posA2, "intA", "2", "realA", "2.0", "boolA", "false", "stringA", "aStringA2");
        configureValue(p, config, posB1, "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringB1");
        configureValue(p, config, posB2, "intA", "2", "realA", "2.8", "boolA", "false", "stringA", "aStringB2");

        performCheck(p, config, true);
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
        configureValue(p, config, 2, "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringA1");
        configureValue(p, config, 3, "intA", "2", "realA", "2.0", "boolA", "true", "stringA", "aStringA2");
        configureValue(p, config, 4, "intA", "1", "realA", "1.0", "boolA", "true", "stringA", "aStringB1");
        configureValue(p, config, 5, "intA", "2", "realA", "2.0", "boolA", "true", "stringA", "aStringB2");

        performCheck(p, config, false);
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

        performCheck(p, config, true);
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

        performCheck(p, config, true);
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

        performCheck(p, config, true);
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

        performCheck(p, config, true);
    }

}
