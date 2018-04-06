package test.de.uni_hildesheim.sse;

import java.io.CharArrayWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import de.uni_hildesheim.sse.translation.ErrorCodes;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.confModel.ConfigurationSaver;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.ModelQuery;
import net.ssehub.easy.varModel.model.ModelQueryException;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.persistency.IVMLWriter;

/**
 * A test class for blackbox testing parser and type resolution of additional
 * files.
 * 
 * @author Holger Eichelberger
 */
public class AdditionalTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(getTestDataDir(), "additional");

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Tests the EasY file contributed by Sascha.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSascha() throws IOException {
        assertEqual(createFile("sascha"), "PL_1", "0");
    }

    /**
     * Tests the duplicates sets test contributed by Sascha.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testSets() throws IOException {
        assertEqual(createFile("sets"), "PL_Sets", "0", ValueDoesNotMatchTypeException.NOT_ALLOWED_VALUE_STRUCTURE);
    }
    
    /**
     * Tests the Attributes test contributed by Phani.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testPhaniAttributes() throws IOException {
        assertEqual(createFile("phaniAttributes"), "PhaniAttributes", "0");
    }

    /**
     * Tests the combination of compound access and attribute contributed by Phani.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testPhaniCompoundAttributes() throws IOException {
        assertEqual(createFile("phaniCompoundAttribute"), "PhaniCompoundAttribute", "0");
    }

    /**
     * Tests the variable names problem contributed by Phani.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testPhaniVarNames() throws IOException {
        assertEqual(createFile("phaniVarNames"), "PhaniVarNames", "0");
    }
    
    /**
     * Tests the short names bug contributed by Sascha.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testShortNames() throws IOException {
        assertEqual(createFile("shortNames"), "shortNames", "0");
    }

    /**
     * Tests the short names bug contributed by Roman / QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testConstraintDispatchCall() throws IOException {
        assertEqual(createFile("constraintDispatchCall"), "constraintDispatchCall", "0");
    }

    /**
     * Tests the short names bug contributed by Roman / QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testBooleanAlgebraOp() throws IOException {
        assertEqual(createFile("BooleanAlgebraOpTest"), null, null);
    }   

    /**
     * Tests warnings (experimental).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWarning() throws IOException {
        assertEqual(createFile("warning"), null, null);
    }   

    /**
     * Tests warnings (experimental, failing due to illegal positions).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWarning1() throws IOException {
        assertEqual(createFile("warning1"), null, null, ErrorCodes.WARNING_USAGE);
    }   

    /**
     * Tests warnings (experimental, failing due to illegal positions).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWarning2() throws IOException {
        assertEqual(createFile("warning2"), null, null, ErrorCodes.WARNING_USAGE);
    }   
    
    /**
     * Tests warnings (experimental, failing due to illegal positions).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testWarning3() throws IOException {
        assertEqual(createFile("warning3"), null, null, ErrorCodes.WARNING_USAGE);
    }
    
    /**
     * Tests a compound annotation on a variable (contributed by Sascha El-Sharkawy, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundAnnotation() throws IOException {
        List<Project> projects = assertEqual(createFile("compoundAnnotation"), null, null);
        if (1 == projects.size()) { // there shall be only one
            Configuration cfg = new Configuration(projects.get(0));
            Assert.assertTrue(cfg.getDecisionCount() > 0);
        } else {
            Assert.fail("more/less projects than expected: " + projects.size());
        }
    }  

    /**
     * Tests a compound annotation on a project (contributed by Sascha El-Sharkawy, QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCompoundAnnotation2() throws IOException {
        List<Project> projects = assertEqual(createFile("compoundAnnotation2"), null, null);
        if (1 == projects.size()) { // there shall be only one
            Configuration cfg = new Configuration(projects.get(0));
            Assert.assertTrue(cfg.getDecisionCount() > 0);
        } else {
            Assert.fail("more/less projects than expected: " + projects.size());
        }
    }  

    /**
     * Tests composite collection operations (contributed by QM).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testCollection1() throws IOException {
        assertEqual(createFile("collection1"), null, null);
    }

    /**
     * Tests specific refined types in collections (contributed by QM).
     * 
     * @throws IOException should not occur
     * @throws ModelQueryException should not occur
     */
    @Test
    public void specificTypeTest() throws IOException, ModelQueryException {
        List<Project> loaded = assertEqual(createFile("specificTypeTest"), null, null);
        Assert.assertTrue(1 == loaded.size());
        Project prj = loaded.get(0);
        AbstractVariable var = ModelQuery.findVariable(prj, "cmps", null);
        Assert.assertNotNull(var);
        Configuration cfg = new Configuration(prj);
        IDecisionVariable decVar = cfg.getDecision(var);

        Assert.assertNotNull(decVar);
        IDatatype typeCP = ModelQuery.findType(prj, "CP", null);
        Assert.assertNotNull(typeCP);
        IDatatype typeCP2 = ModelQuery.findType(prj, "CP2", null);
        Assert.assertNotNull(typeCP2);

        IDecisionVariable nested0 = decVar.getNestedElement(0);
        Assert.assertNotNull(nested0);
        Assert.assertEquals(nested0.getDeclaration().getType(), typeCP);
        Assert.assertEquals(nested0.getValue().getType(), typeCP);
        IDecisionVariable nested1 = decVar.getNestedElement(1);
        Assert.assertNotNull(nested1);
        Assert.assertEquals(nested1.getDeclaration().getType(), typeCP2); // TODO typeCP2
        Assert.assertEquals(nested1.getValue().getType(), typeCP2);
    }
 
    /**
     * Tests a refby type problem (contributed by QM, S. El-Sharkawy).
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testRefby() throws IOException {
        assertEqual(createFile("refby"), null, null);
    }
    
    /**
     * A configuration saver for testing.
     * 
     * @author Holger Eichelberger
     */
    private static class MyConfigurationSaver extends ConfigurationSaver {

        /**
         * Default constructor for this class. This Constructor will save only user input.
         * @param cfg The configuration which should be saved.
         * @param ownProject return an own project (<code>true</code>) or add the 
         *   configuration to {@link Configuration#getProject()} (<code>false</code>)
         * @throws ConfigurationException in case of any configuration errors
         */
        MyConfigurationSaver(Configuration cfg, boolean ownProject) throws ConfigurationException {
            super(cfg, ownProject, true);
        }
        
    }

    /**
     * Tests a refby-to-container writing problem (contributed by QM). As the problem occurs
     * while writing the configuration back, this test creates configurations of the read projects
     * and compares their IVML syntax.
     * 
     * @throws IOException should not occur
     * @throws ConfigurationException shall not occur
     */
    @Test
    public void testRefby2() throws IOException, ConfigurationException {
        List<Project> prjs = assertEqual(createFile("refby2"), null, null);
        for (int p = 0; p < prjs.size(); p++) {
            Project pr = prjs.get(p);
            if (pr.getName().equals("refby2")) {
                Configuration cfg = new Configuration(prjs.get(p));
                MyConfigurationSaver s = new MyConfigurationSaver(cfg, true);
                Project savedProject = s.getSavedConfiguration();
                
                String fileAsString = file2String(createFile("refby2_conf"));
                Assert.assertTrue(null != fileAsString);
    
                // read model into String
                java.io.CharArrayWriter writer = new CharArrayWriter();
                IVMLWriter visitor = IVMLWriter.getInstance(writer);
                savedProject.accept(visitor);
                IVMLWriter.releaseInstance(visitor);
    
                String errorMsg = checkEqualsAndPrepareMessage(fileAsString, writer);
                if (null != errorMsg) {
                    // Only traditional comparison if file does not contain replacement comments
                    if (!fileAsString.contains("//*")) {
                        Assert.assertEquals(fileAsString.trim(), writer.toString().trim());
                    }
                    // Fallback
                    Assert.fail(errorMsg);
                }
            }
        }
    }

    /**
     * Tests constraint values as Booleans.
     * 
     * @throws IOException should not occur
     * @throws ModelQueryException if a variable cannot be found
     */
    @Test
    public void testConstraintValue() throws IOException, ModelQueryException {
        List<Project> projects = assertEqual(createFile("constraintValue"), null, null);
        Assert.assertNotNull(projects);
        Assert.assertEquals(1, projects.size());
        Project prj = projects.get(0);
        AbstractVariable var = ModelQuery.findVariable(prj, "alg", null);
        Configuration cfg = new Configuration(projects.get(0));
        IDecisionVariable decVar = cfg.getDecision(var);
        Assert.assertNotNull(decVar);
        IDecisionVariable scalable = decVar.getNestedElement("scalable");
        Assert.assertTrue(scalable.getValue() instanceof BooleanValue);
    }

}