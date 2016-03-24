package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import de.uni_hildesheim.sse.easy_producer.core.AllTests;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.Persistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.PersistentProject2PLPConverter;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Super class for tests, which should test the {@link PLPInfo} class.
 * @author El-Sharkawy
 *
 */
class AbstractPLPInfoTest implements IVilExecutionListener {
    
    protected static final Set<PLPInfo> LOADED_INFOS = new HashSet<PLPInfo>();
    
    /**
     * Registers VIL and VTL expression parser. This should normally be done via the Descriptive Services (DS),
     * but it seems that it is not the case when the tests are executed via ANT.
     * <b>Must be called from setUpBeforeClass in sub classes...</b>
     */
    static void setUpBeforeClass() {
        de.uni_hildesheim.sse.VilExpressionParser.register();
        de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser.register();
        
        // Initialize temp directory if this test case was executed outside of the test suite.
        AllTests.setUpBeforeClass();
    }
    
    /**
     * Helping method for loading projects from the testdata folder.
     * @param projectFolder The toplevel folder of a saved {@link PLPInfo} which should be used for testing.
     * @return A {@link PLPInfo} which was loaded from the given location.
     * @throws PersistenceException Must not occur, otherwise the config files inside the toplevel location are corrupt.
     */
    protected static PLPInfo loadPLPInfo(File projectFolder) throws PersistenceException {
        // Create Persistencer for loading a PLP
        PathEnvironment projectsWorkspace = new PathEnvironment(projectFolder.getParentFile());
        File easyConfigFile = PersistenceUtils.getLocationFile(projectFolder, PathKind.IVML);
        IPersistencer persistencer = new Persistencer(projectsWorkspace, projectFolder,
            easyConfigFile.getAbsolutePath(), ProgressObserver.NO_OBSERVER);
        Assert.assertNotNull("Error: Persistencer could not be created.", persistencer);
        
        // Load PLP
        PersistentProject project  = persistencer.load();
        Assert.assertNotNull("Error: Information could not be loaded.", project);
        Assert.assertNotNull("Error: IVML could not be loaded.", project.getProject());
        Assert.assertNotNull("Error: VIL could not be loaded.", project.getMainBuildScript());
        
        PLPInfo plp = new PLPInfoLoader(project);
        Assert.assertNotNull("Error: PLP could not be created.", plp);
        Assert.assertNotNull("Error: IVML could not be loaded.", plp.getProject());
        Assert.assertNotNull("Error: VIL could not be loaded.", plp.getBuildScript());
        
        LOADED_INFOS.add(plp);

        PersistentProject2PLPConverter converter = new PersistentProject2PLPConverter(persistencer, project);
        converter.persistentProject2PLP();
        
        return plp;
    }

    /**
     * Counts how many frozen variables are contained inside the given {@link PLPInfo}.
     * @param plp The {@link PLPInfo} of which the {@link de.uni_hildesheim.sse.model.confModel.Configuration}
     * should be inspected.
     * @return The number of stored frozen variables inside the configuration (must be greater or equal to 0).
     */
    static int countFrozenVariables(PLPInfo plp) {
        int nFrozenVars = 0;
        for (IDecisionVariable var : plp.getConfiguration()) {
            if (var.getState() == AssignmentState.FROZEN) {
                nFrozenVars++;
            }
        }
        
        return nFrozenVars;
    }
    
    /**
     * Assert the output for a certain file.
     * @param producedFile the file produced during the tests
     * @param expectedFile the expected file (specified before the tests)
     * @throws IOException If the produced file was not saved or the expected file was not found for comparison
     */
    static void assertFileEquality(File producedFile, File expectedFile) throws IOException {
        Assert.assertTrue(producedFile + " does not exist (produced)", producedFile.exists());
        String produced = FileUtils.readFileToString(producedFile);
        produced = normalizeText(produced);
        Assert.assertTrue(expectedFile + " does not exist (expected)", expectedFile.exists());
        String expected = FileUtils.readFileToString(expectedFile);
        expected = normalizeText(expected);
        Assert.assertEquals("expected file " + expectedFile + " is not the same as produced file " + producedFile, 
            produced, expected);
    }
    
    /**
     * Normalize the given <code>text</code> for comparison.
     * 
     * @param text the text to be normalized
     * @return the normalized text, i.e., without line ends, without spaces at beginning
     *    and end and with reduced whitespaces (multiples to one)
     */
    private static final String normalizeText(String text) {
        text = text.replaceAll("(\\r|\\n)", "");
        text = text.trim();
        StringBuffer tmp = new StringBuffer(text);
        int i = 0;
        while (i + 1 < tmp.length()) {
            if (' ' == tmp.charAt(i) && ' ' == tmp.charAt(i + 1)) {
                tmp.deleteCharAt(i);
            } else {
                i++;
            }
        }
        return tmp.toString();
    }
    
    /**
     * Runs the java compiler and checks whether the given folder is compilable.
     * @param folder A java project folder containing a <tt>src</tt> and a <tt>bin</tt> folder.
     * @param compilable Specification, whether the project should be compilable (<tt>true</tt>) or not(<tt>false</tt>).
     */
    void compile(File folder, boolean compilable) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null,
            Charset.forName("ISO-8859-1"));
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
     * Prints some debug information of the loaded {@link PLPInfo} out to the console.
     * @param plp A {@link PLPInfo} which is currently used during a test case.
     */
    protected static void printPLP(PLPInfo plp) {
        System.out.println("PLP: " + plp.getProjectName());
        System.out.println(" - Predecessors: " + plp.getMemberController().getPredecessorsCount());
        System.out.println(" - Successors: " + plp.getMemberController().getSuccessorsCount());
    }

    @Override
    public void vilExecutionAborted(PLPInfo plp, VilException exc) {
        Assert.fail(exc.getMessage());
    }

    @Override
    public void vilExecutionFinished(PLPInfo plp) {
        // Not needed
    }
}
