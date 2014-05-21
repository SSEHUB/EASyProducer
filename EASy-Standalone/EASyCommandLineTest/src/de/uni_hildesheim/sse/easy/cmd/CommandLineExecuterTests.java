package de.uni_hildesheim.sse.easy.cmd;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests the CommandLineExecuter class.
 * The test methods are structured as follows:
 * <ul>
 *     <li><tt>testInstantiateElevator<tt> - Tests the <tt>instantiate</tt> method with source and target project,
 *     using the elevator example.
 *         <ul>
 *             <li><tt>A</tt> - Tests the method with only two folders as parameters.</li>
 *             <li><tt>B</tt> - Tests the method with two folders, and IVML file, and a VIL file as parameters.</li>
 *             <li><tt>C</tt> - Tests the method with two folders, a ivml name, ivml version, vil name,
 *             and vil version as parameters</li>
 *         </ul>
 *     </li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class CommandLineExecuterTests {
    
    private static final String MAIN_CLASS = "de.uni_hildesheim.sse.easy.cmd.CommandLineExecuter";
    private static final String DEFAULT_JDK_LOCATION = "C:\\Program Files (x86)\\Java\\jdk1.7.0_45";

    /**
     * Checks whether the java.home variable is set to a JDK location.
     * If it is not set, the {@link #DEFAULT_JDK_LOCATION} will be set.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        String javaLocation = System.getProperty("java.home");
        String os = System.getProperty("os.name").toLowerCase();
        if (javaLocation.contains("jre") && os.indexOf("win") >=0 ) {
            System.setProperty("java.home", DEFAULT_JDK_LOCATION);            
        }
    }
    
    
    /**
     * Tests the <tt>instantiate</tt> method with two EASy projects (the elevator example).
     * These projects are already configured by Eclipse and contain all necessary information.
     * @throws IOException If an I/O error occurs while passing the command to the shell/command line.
     */
    @Test
    public void testInstantiateElevatorA1() throws IOException {
        // Projects used for instantiation
        File src = new File(AllTests.ELEVATOR_DIR, "PL_SimElevator");
        File trg = new File(AllTests.ELEVATOR_DIR, "New_Product");
        
        // Test that the original is NOT compilable
        compile(src, false);
        
        ProcessExecuter executer = new ProcessExecuter(MAIN_CLASS + " instantiate " + src.getCanonicalPath()
            + " " + trg.getCanonicalPath(), false);
        
        String errMsg = executer.execute();
        if (null != errMsg) {
            Assert.fail(errMsg);
        }
        
        compile(trg, true);
    }
    
    /**
     * Tests the <tt>instantiate</tt> method with one EASy project (the elevator example).
     * The first folder is an valid eASy project, which contains a variability model
     * and all files needed for instantiation.
     * @throws IOException If an I/O error occurs while passing the command to the shell/command line.
     */
    @Test
    public void testInstantiateElevatorA2() throws IOException {
        // Projects used for instantiation
        File src = new File(AllTests.ELEVATOR_DIR, "PL_SimElevator_frozen");
        File trg = new File(AllTests.ELEVATOR_DIR, "New_Product3");
        
        // Test that the original is NOT compilable
        compile(src, false);
        
        ProcessExecuter executer = new ProcessExecuter(MAIN_CLASS + " instantiate " + src.getCanonicalPath()
            + " " + trg.getCanonicalPath(), false);
        
        String errMsg = executer.execute();
        if (null != errMsg) {
            Assert.fail(errMsg);
        }
        
        compile(trg, true);
    }
    
    /**
     * Tests the <tt>instantiate</tt> method with two folders (the elevator example).
     * The first folder is an valid eASy project, which contains a variability model
     * and all files needed for instantiation.
     * The second folder does not exist and should be created during the instantiation process.
     * The configuration and build script will be loaded from outside of the projects/folders as additional parameters.
     * @throws IOException If an I/O error occurs while passing the command to the shell/command line.
     */
    @Test
    public void testInstantiateElevatorB() throws IOException {
        // Projects used for instantiation
        File src = new File(AllTests.ELEVATOR_DIR, "PL_SimElevator2");
        File trg = new File(AllTests.ELEVATOR_DIR, "New_Product2");
        File trgConfigs = new File(trg, "EASy");
        File ivmlFile = new File(trgConfigs, "New_Product2.ivml");
        File vilFile = new File(trgConfigs, "New_Product.vil");
        
        // Test that the original is NOT compilable
        compile(src, false);
        Assert.assertFalse("Folder " + trg.getCanonicalPath() + " should NOT exists, but it does.", trg.exists());
        
        ProcessExecuter executer = new ProcessExecuter(MAIN_CLASS + " instantiate " + src.getCanonicalPath()
            + " " + trg.getCanonicalPath() + " " + ivmlFile.getCanonicalPath()
            + " " + vilFile.getCanonicalPath(), false);
        
        String errMsg = executer.execute();
        if (null != errMsg) {
            Assert.fail(errMsg);
        }
        
        Assert.assertTrue("Folder " + trg.getCanonicalPath() + " should exists, but it does NOT.", trg.exists());
        compile(trg, true);
    }
    
    /**
     * Tests the <tt>instantiate</tt> method with two folders (the elevator example).
     * The first folder is an valid eASy project, which contains a variability model
     * and all files needed for instantiation.
     * The second folder does not exist and should be created during the instantiation process.
     * The configuration and build script will be loaded from outside of the projects/folders as additional parameters.
     * @throws IOException If an I/O error occurs while passing the command to the shell/command line.
     */
    @Test
    public void testInstantiateElevatorC() throws IOException {
        // Projects used for instantiation
        File src = new File(AllTests.ELEVATOR_DIR, "PL_SimElevator2");
        File trg = new File(AllTests.ELEVATOR_DIR, "New_Product4");
        
        // Test that the original is NOT compilable
        compile(src, false);
        Assert.assertFalse("Folder " + trg.getCanonicalPath() + " should NOT exists, but it does.", trg.exists());
        
        ProcessExecuter executer = new ProcessExecuter(MAIN_CLASS + " instantiate " + src.getCanonicalPath()
            + " " + trg.getCanonicalPath() + " " + "New_Product2 0 New_Product 0", false);
        
        String errMsg = executer.execute();
        if (null != errMsg) {
            Assert.fail(errMsg);
        }
        
        Assert.assertTrue("Folder " + trg.getCanonicalPath() + " should exists, but it does NOT.", trg.exists());
        compile(trg, true);
    }

    /**
     * Enumerate Java files in <code>location</code> and store results in <code>files</code>.
     * 
     * @param location the location to enumerate
     * @param files the resulting java files (modified as a side effect)
     */
    private void enumerateJavaFiles(File location, List<File> files) {
        if (location.isDirectory()) {
            File[] dir = location.listFiles();
            if (null != dir) {
                for (File f : dir) {
                    enumerateJavaFiles(f, files);
                }
            }
        } else {
            if (location.getName().endsWith(".java")) {
                files.add(location);
            }
        }
    }
    
    /**
     * Runs the java compiler and checks whether the given folder is compilable.
     * @param folder A java project folder containing a <tt>src</tt> and a <tt>bin</tt> folder.
     * @param compilable Specification, whether the project should be compilable (<tt>true</tt>) or not(<tt>false</tt>).
     */
    private void compile(File folder, boolean compilable) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, Charset.forName("ISO-8859-1"));
        List<File> files = new ArrayList<File>();
        enumerateJavaFiles(new File(folder, "src"), files);
        List<String> options = new ArrayList<String>();
        options.add("-d");
        File binFolder = new File(folder, "bin");
        if (!binFolder.exists()) {
            binFolder.mkdir();
        }
        options.add(new File(folder, "bin").getAbsolutePath());
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
        StringWriter writer = new StringWriter();
        boolean success = compiler.getTask(writer, fileManager, null, options, null, compilationUnits).call();
        try {
            fileManager.close(); 
        } catch (IOException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        if (compilable) {
            Assert.assertTrue("compile problems: " + writer.toString(), success);
        } else {
            Assert.assertFalse("Files should not be compileable, but they are.", success);
        }
    }
}
