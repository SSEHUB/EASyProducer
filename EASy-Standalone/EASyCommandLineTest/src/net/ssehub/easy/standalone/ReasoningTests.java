package net.ssehub.easy.standalone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ReasoningTests {
    
    private static final String MAIN_CLASS = "net.ssehub.easy.standalone.cmd.CommandLineExecuter";
    
    @BeforeClass
    public static void setUpBeforeClass() {
        AllTests.setUpBeforeClass();
    }
    
    /**
     * Target where the result of the reasoning will be written to, located inside of the project.
     * The result will be:
     * <ul>
     * <li><tt>true</tt>: The Reasoner detected conflicts.</li>
     * <li><tt>false</tt>: The Reasoner detected <b>no</b> conflicts.</li>
     * </ul>
     */
    private static final String RESULT_FILE = ".result";
    
    private static boolean hasConflict(File resultFile) {
        boolean result = false;
        Assert.assertTrue("Error: Result file was not created!", resultFile.exists());
       
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(resultFile));
            String line = br.readLine();
            
            if ("true".equals(line)) {
                result = true;
            } else if ("false".equals(line)) {
                result = false;
            } else {
                Assert.fail("Error: Unspecified output has been written.");
            }
        } catch (FileNotFoundException e) {
            //should not occur as it was tested before
            Assert.fail("Error: Result file was not created!");
        } catch (IOException e) {
            Assert.fail("Failure: Cannnot read created file. Please check test environment.");
        }
        finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    Assert.fail("Failure: Cannnot close result file. Please check test environment.");
                }
            }
        }
        
        return result;
    }
    
    /**
     * Performs the reasoning. And tests whether the reasoning process was executed correctly.
     * @param projectFolder File object pointing to a test project folder (inside of {@link AllTests#TESTDATA_DIR}.
     * @param ivmlName The name of the variability model inside of the project folder, which should be used for
     *     reasoning. Maybe <tt>null</tt>, in this case also the version is ignored and the project must be a complete
     *     EASy/Eclipse project.
     * @param ivmlVersion the version of the ivml project, which shall be used for reasoning.
     */
    private static void performReasoning(File projectFolder, String ivmlName, String ivmlVersion) {
        ProcessExecuter executor = null;
        try {
            if (null != ivmlName) {
            executor = new ProcessExecuter(MAIN_CLASS + " checkValidity "
                + projectFolder.getCanonicalPath() + " " + ivmlName + " " + ivmlVersion, false);
            } else {
                executor = new ProcessExecuter(MAIN_CLASS + " checkValidity " + projectFolder.getCanonicalPath(),
                    false);
            }
            executor.waitFor();
        } catch (IOException e) {
            Assert.fail("Error in creating the process: " + e.getMessage());
        } catch (InterruptedException e) {
            Assert.fail("Error process was interrupted: " + e.getMessage());
        }
        if (null != executor) {
            try {
                String errMsg = executor.execute();
                if (null != errMsg) {
                    System.err.println(errMsg);
                    Assert.fail(errMsg);
                }
            } catch (IOException e) {
                Assert.fail("Error while executing the process: " + e.getMessage());
            }
        }
    }
    
    /**
     * Performs the reasoning <b>and</b> checks whether the reasoning produces the correct outcome.
     * 
     * @param projectFolder File object pointing to a test project folder (inside of {@link AllTests#TESTDATA_DIR}.
     * @param ivmlName The name of the variability model inside of the project folder, which should be used for
     *     reasoning. Maybe <tt>null</tt>, in this case also the version is ignored and the project must be a complete
     *     EASy/Eclipse project.
     * @param ivmlVersion the version of the ivml project, which shall be used for reasoning.
     * @param expectedResult <tt>true</tt> if a conflict should be detected by the reasoner, <tt>false</tt> otherwise.
     */
    private static void checkValidity(File projectFolder, String ivmlName, String ivmlVersion, boolean expectedResult) {
        performReasoning(projectFolder, ivmlName, ivmlVersion);
        File resultFile = new File(projectFolder, RESULT_FILE);
        boolean hasConflict = hasConflict(resultFile);
        
        Assert.assertEquals("Error in Reasoning: The reasoner created the wrong result", expectedResult, hasConflict);
    }

    /**
     * Checks the validity of a configuration. Basically, this test aims at validating whether the
     * reasoner classes are properly loaded for the command line interface.
     * 
     * @throws IOException If an I/O error occurs while passing the command to the shell/command line.
     */
    @Test
    public void testSimpleReasoning() {
        String projectName = "PL_SimElevator_frozen";
        File projectFolder = new File(AllTests.ELEVATOR_DIR, projectName);
        checkValidity(projectFolder, projectName, "0", false);
    }
    
    /**
     * Tests whether a variability model with only boolean variables and <tt>XOR</tt> constraints could be used for
     * reasoning. Reasoner should detect a conflict. <br />
     * Failure detected on 21.02.2014 by Roman Sizonenko.
     */
    @Ignore
    @Test
    public void testXORReasoningFails() {
        String projectName = "XORReasoningFailes_TestProject";
        File projectFolder = new File(AllTests.REASONINGS_DIR, projectName);
        checkValidity(projectFolder, projectName, "0", true);
    }
    
    /**
     * Tests whether a variability model with only boolean variables and <tt>XOR</tt> constraints could be used for
     * reasoning. Reasoner should <b>not</b> detect a conflict. <br />
     * Failure detected on 21.02.2014 by Roman Sizonenko.
     */
    @Ignore
    @Test
    public void testXORReasoningOK() {
        String projectName = "XORReasoningCorrect_TestProject";
        File projectFolder = new File(AllTests.REASONINGS_DIR, projectName);
        checkValidity(projectFolder, projectName, "0", false);
    }
    
    /**
     * Tests whether a variability model with only real variables and <tt>+</tt> constraints could be used for
     * reasoning. Reasoner should detect a conflict. <br />
     */
    @Test
    public void testADDReasoningFails() {
        String projectName = "ADDReasoningFails_TestProject";
        File projectFolder = new File(AllTests.REASONINGS_DIR, projectName);
        checkValidity(projectFolder, projectName, "0", true);
    }
    
    /**
     * Tests whether an EASy project can be used for reasoning with only one parameter, the project folder.
     * In this test, the reasoner should <b>not</b> detect any errors.
     */
    @Test
    public void testSimpleProjectReasoningValid() {
        String projectName = "SimpleReasoningTest_Valid";
        File projectFolder = new File(AllTests.REASONINGS_DIR, projectName);
        checkValidity(projectFolder, null, null, true);
    }
    
    /**
     * Tests whether an EASy project can be used for reasoning with only one parameter, the project folder.
     * In this test, the reasoner should detect one error.
     */
    @Test
    public void testSimpleProjectReasoningFails() {
        String projectName = "SimpleReasoningTest_Fails";
        File projectFolder = new File(AllTests.REASONINGS_DIR, projectName);
        checkValidity(projectFolder, null, null, true);
    }
}
