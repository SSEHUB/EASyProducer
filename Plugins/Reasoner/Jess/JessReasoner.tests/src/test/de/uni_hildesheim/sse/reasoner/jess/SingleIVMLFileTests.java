package test.de.uni_hildesheim.sse.reasoner.jess;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.dslCore.StandaloneInitializer;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IvmlException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.reasoner.jess.JessR;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Some test cases to cover basic reasonings.
 * @author tebbje
 */
public class SingleIVMLFileTests {
    
    /**
     *  Before statements to get more usability for proper test cases. 
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        ModelUtility.setResourceInitializer(new StandaloneInitializer());
    }

    /**
     * Load an IVML File to the test projekt.
     * @param path of the ivml file we want to use to
     * @return the projekt with the configuration
     * @throws IOException if an error occurred due reading the ivml file
     */
    private Project loadProject(String path) throws IOException {
        File file = new File(System.getProperty("user.dir") + path);
        try {
            VarModel.INSTANCE.locations().addLocation(file, ProgressObserver.NO_OBSERVER);
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            System.out.println(e.getMessage());
        }
        // Parse IVML File
        TranslationResult<Project> result = ModelUtility.INSTANCE.parse(file);
        Assert.assertEquals(1, result.getResultCount());

        // Load project
        Project p = result.getResult(0);
        return p;
    }

    /**
     * Test rudimentary basis of datatype in a configuration.
     * @throws ValueDoesNotMatchTypeException Should not occur,
     * otherwise there exist an error inside the whole reasoner or model
     * @throws ConfigurationException there is a failure in the configuration
     * @throws IvmlException IvmlException occurred
     * @throws IOException IOException occurred
     */
    @Test
    public void testBasisDatatypeIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testBasisDatatype.ivml";
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);
        configureValue(p, config, 0, "a");
        configureValue(p, config, 1, "1");
        configureValue(p, config, 2, "10.1");
        configureValue(p, config, 3, "true");

        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY of testBasisDatatypeIsValid " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }

    /**
     * Except a false result of given values that not match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testBasisDatatypeIsInvalid() 
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testBasisDatatype.ivml";
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);
        configureValue(p, config, 0, "a");
        configureValue(p, config, 1, "1");
        configureValue(p, config, 2, "1.1");
        configureValue(p, config, 3, "true");
                
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertTrue(result.hasConflict());
    }

    /**
     * Except a true result of given values that not match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testComplexDatatypeIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testComplexBasisDatatype.ivml";
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);
        configureValue(p, config, 0, "2");
        configureValue(p, config, 1, "5");
        configureValue(p, config, 2, "9.0");
        configureValue(p, config, 3, "11.5");
        configureValue(p, config, 4, "22.0");
        configureValue(p, config, 5, "2.0");
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }
    
    /**
     * Except a false result for given (more complex) values that not match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testComplexDatatypeIsInvalid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testComplexBasisDatatype.ivml";
        // Load Project
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);
        configureValue(p, config, 0, "2");
        configureValue(p, config, 1, "5");
        configureValue(p, config, 2, "9.0");
        configureValue(p, config, 3, "10.5");
        configureValue(p, config, 4, "26.0");
        configureValue(p, config, 5, "2.0");

        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertTrue(result.hasConflict());
    }
    
    /**
     * Except a true result for given compound that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testConstrainedCompoundIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testConstrainedCompound.ivml";
        // Load Project
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);      
        configureValue(p, config, 1, "intA", "10", "realB", "5.0");
        configureValue(p, config, 2, "intA", "5", "realB", "10.0");
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }
    
    /**
     * Except an invalid result for given compound that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testConstrainedCompoundIsInValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testConstrainedCompound.ivml";
        // Load Project
        Project p = loadProject(path);
        
        // Create Configuration
        Configuration config = new Configuration(p);      
        configureValue(p, config, 1, "intA", "10", "realB", "10.0");
        configureValue(p, config, 2, "intA", "10", "realB", "10.0");
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertTrue(result.hasConflict());
    } 
    
    /**
     * Except a true result for given compound that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testDatatypeSequenceIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testDatatypeSequence.ivml";
        // Load Project
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);      
        configureValue(p, config, 1, "intA", "1", "realA", "2.2", "stringA", "c");
        
        //TODO sequence length test
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }
    
    /**
     * Except an invalid result for given compound that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testDatatypeSequenceIsInValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testDatatypeSequence.ivml";
        // Load Project
        Project p = loadProject(path);
        
        // Create Configuration
        Configuration config = new Configuration(p);      
        configureValue(p, config, 1, "intA", "2", "realA", "3.3", "stringA", "d");
        
        //TODO sequence length test
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.isConsistent(p, null, ProgressObserver.NO_OBSERVER);
        boolean isConsistent = !result.hasConflict();
        System.out.println("CONSISTENCY " + isConsistent);
        
        // Test correct results
        Assert.assertFalse(isConsistent);
    } 
    
    /**
     * Except a true result for given compound that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testEnumIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        String path = File.separator + "testdata" + File.separator + "testEnum.ivml";
        // Load Project
        Project p = loadProject(path);

        // Create Configuration
        Configuration config = new Configuration(p);      
        
        //TODO enum invalid
        
        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }
    
    /**
     * Except an valid result for given sequence that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testGeneralIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testGeneral.ivml";
        Project p = loadProject(path);
        
        // Create Configuration
        Configuration config = new Configuration(p);      

        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }    
    
    /**
     * Except an valid result for given sequence that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testInfrastructureIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testInfrastructure.ivml";
        Project p = loadProject(path);
        System.out.println("internal number:" + p.getInternalConstraintCount());
        // Create Configuration
        Configuration config = new Configuration(p);      

        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }    
    
    /**
     * Except an valid result for given sequence that match the configuration.
     * @throws ValueDoesNotMatchTypeException if a value does not match the datatype?
     * @throws ConfigurationException if there is any error with the configuration
     * @throws IvmlException if there is an error with the ivml
     * @throws IOException if there is an IO error
     */
    @Test
    public void testInfraIsValid()
        throws ValueDoesNotMatchTypeException, ConfigurationException, IvmlException, IOException {
        
        // Load Project
        String path = File.separator + "testdata" + File.separator + "testInfra.ivml";
        Project p = loadProject(path);
        
        // Create Configuration
        Configuration config = new Configuration(p);      

        // Start reasoning
        JessR reasoner = new JessR();
        ReasoningResult result = reasoner.check(p, config, null, ProgressObserver.NO_OBSERVER);
        System.out.println("CONSISTENCY " + !result.hasConflict());

        // Test correct results
        Assert.assertFalse(result.hasConflict());
    }    
    
    /**
     * Adding values quickly to the test project.
     * @param project project object
     * @param config config object
     * @param index index of the value we want to add
     * @param value value parameters for the element at index
     * @throws ConfigurationException if anything went wrong with the configuration
     * @throws ValueDoesNotMatchTypeException 
     */
    private void configureValue(Project project, Configuration config, int index, String... value) 
        throws ConfigurationException, ValueDoesNotMatchTypeException {
        DecisionVariableDeclaration decl = (DecisionVariableDeclaration) project.getElement(index);
        Value val = ValueFactory.createValue(decl.getType(), (Object[]) value);
        config.getDecision(decl).setValue(val, null);
    }

}
