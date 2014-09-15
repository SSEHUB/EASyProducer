package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.translation.ErrorCodes;

/**
 * A test class for blackbox testing parser and type resolution of 
 * IVML files contributed from "external" sources. 
 * 
 * @author Holger Eichelberger
 */
public class ExternalTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "external");

    /**
     * Creates a file in {@link #DIR}.
     * 
     * @param name
     *            the name of the file (excluding ".ivml")
     * @return the file
     */
    private static final File createFile(String name) {
        return new File(DIR, name + ".ivml");
    }

    /**
     * Tests the EasY file with 10000 variables.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void test10000() throws IOException {
        assertEqual(createFile("10000Variables"), null, null);
    }

    /**
     * ScaleLog test case leading to stackoverflow.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void scaleLogGoodsIn() throws IOException {
        assertEqual(createFile("GoodsIn_Instances"), null, null);
    }

    /**
     * Topology test case. Use of ref and refBy in compounds and sequences.
     * Simplified version contributed by QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferences() throws IOException {
        assertEqual(createFile("references"), null, null);
    }

    /**
     * Failing Topology test case as variable is not dereferenced (omitting refBy).
     * Simplified version contributed by QualiMaster.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testReferencesFail() throws IOException {
        assertEqual(createFile("referencesFail"), null, null, CSTSemanticException.TYPE_MISMATCH);
    }

    /**
     * Self interface import from wrong model contributed by Sebastian Bender.
     * The base model (v0) defines the interface, the second model (v1) imports 
     * the (same) model by name without version and accidentally the v0 is taken
     * instead of v2. 
     * 
     * @throws IOException should not occur
     */
    @Test
    public void testInterfaceImportFail() throws IOException {
        assertEqual(createFile("InterfaceImportFail_1"), "InterfaceImportFail", "1", ErrorCodes.IMPORT);
    }

}
