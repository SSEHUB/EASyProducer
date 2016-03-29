package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

import de.uni_hildesheim.sse.translation.ErrorCodes;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

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
    private static final File DIR = new File(TESTDATA_DIR, "additional");

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

}