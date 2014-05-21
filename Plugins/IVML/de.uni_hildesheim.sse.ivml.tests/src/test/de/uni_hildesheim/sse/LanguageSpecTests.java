package test.de.uni_hildesheim.sse;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * A test class for blackbox testing parser and type resolution by examples from 
 * the IMVL language specification.
 * 
 * @author Holger Eichelberger
 */
public class LanguageSpecTests extends AbstractTest {

    /**
     * Represents the directory containing the tests.
     */
    private static final File DIR = new File(TESTDATA_DIR, "languageSpec");

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
     * Tests the <code>ref</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void ref() throws IOException {
        assertEqual(createFile("ref"), "ivmlSpec_ref", "");
    }

    /**
     * Tests the <code>ref2</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void ref2() throws IOException {
        assertEqual(createFile("ref2"), "ivmlSpec_ref2", "");
    }
    
    /**
     * Tests the <code>typeDerivation</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void typeDrivation() throws IOException {
        assertEqual(createFile("typeDerivation"), "ivmlSpec_typeDerivation", "");
    }

    /**
     * Tests the <code>attributes</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void attributes() throws IOException {
        assertEqual(createFile("attributes"), "ivmlSpec_attributes", "");
    }

    /**
     * Tests the <code>compounds</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void compounds() throws IOException {
        assertEqual(createFile("compounds"), "ivmlSpec_compounds", "");
    }

    /**
     * Tests the <code>compoundRefines</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void compoundRefines() throws IOException {
        assertEqual(createFile("compoundRefines"), "ivmlSpec_compoundRefines", "");
    }    

    /**
     * Tests the <code>configurations</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void configurations() throws IOException {
        assertEqual(createFile("configurations"), "ivmlSpec_configurations", "");
    }    

    /**
     * Tests the <code>container</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void container() throws IOException {
        assertEqual(createFile("container"), "ivmlSpec_container", "");
    }
    
    /**
     * Tests the <code>decisionVariable</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void decisionVariable() throws IOException {
        assertEqual(createFile("decisionVariable"), "ivmlSpec_decisionVariable", "");
    }      

    
    /**
     * Tests the <code>enum</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void enums() throws IOException {
        assertEqual(createFile("enum"), "ivmlSpec_enum", "");
    }
    
    /**
     * Tests the <code>freeze</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void freeze() throws IOException {
        assertEqual(createFile("freeze"), "ivmlSpec_freeze", "");
    }
    
    /**
     * Tests the <code>imports</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void imports() throws IOException {
        // null for name to disable test as multiple projects are contained
        assertEqual(createFile("imports"), null, "");
    }         
    
    /**
     * Tests the <code>interfaces</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void interfaces() throws IOException {
        // null for name to disable test as multiple projects are contained
        assertEqual(createFile("interfaces"), null, "");
    }
    
    /**
     * Tests the <code>partialConfiguration</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void partialConfiguration() throws IOException {
        // null for name to disable test as multiple projects are contained
        assertEqual(createFile("partialConfiguration"), null, "");
    }

    /**
     * Tests the <code>partialConfiguration</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void partialEvaluation() throws IOException {
        // null for name to disable test as multiple projects are contained
        assertEqual(createFile("partialEvaluation"), null, "");
    }    

    /**
     * Tests the <code>partialConfiguration2</code> file.
     * 
     * @throws IOException should not occur
     */
    @Test
    public void partialEvaluation2() throws IOException {
        // null for name to disable test as multiple projects are contained
        assertEqual(createFile("partialEvaluation2"), null, "");
    }    

}
