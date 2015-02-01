package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;

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
    
}