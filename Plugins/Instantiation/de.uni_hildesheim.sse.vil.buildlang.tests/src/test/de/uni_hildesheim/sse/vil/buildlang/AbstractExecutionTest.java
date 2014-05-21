package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.varModel.testSupport.DefaultConfiguration;

/**
 * Implements the functionality of an abstract execution test (basis for reuse).
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractExecutionTest extends AbstractTest {

    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "execution");
    }

    /**
     * Returns the actual artifacts folder.
     * 
     * @return the artifacts folder
     */
    protected File getArtifactsFolder() {
        return new File(getTestDataDir(), "artifacts");
    }
    
    /**
     * Creates a file object relative to {@link #DIR} (not a file).
     * 
     * @param name
     *            the name of the file (excluding ".trc")
     * @return the file
     */
    private File createTraceFile(String name) {
        return new File(getTestFolder(), name + ".trc");
    }
    
    /**
     * Shortcut function to {@link #assertEqual(EqualitySetup, int...)}.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files fails
     */
    protected void assertEqual(String name, int... expectedExceptions) throws IOException {
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name));
        assertEqual(setup, expectedExceptions);
    }
    
    /**
     * Creates a default parameter map.
     * 
     * @param source the source project (use empty if <b>null</b>)
     * @param target the target project (use empty if <b>null</b>)
     * @param config the configuration (use empty if <b>null</b>)
     * @return the parameter map
     */
    private static Map<String, Object> createParameterMap(Project source, Project target, Configuration config) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (null == source) {
            source = new Project(); // just dummy
        }
        if (null == target) {
            target = new Project(); // just dummy
        }
        if (null == config) {
            de.uni_hildesheim.sse.model.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
            Assert.assertNotNull("creating default IVML configuration failed", cfg);
            config = new Configuration(cfg);
        }
        param.put(Executor.PARAM_SOURCE, source);
        param.put(Executor.PARAM_TARGET, target);
        param.put(Executor.PARAM_CONFIG, config);
        return param;
    }

    /**
     * Shortcut function to {@link #assertEqual(EqualitySetup, int...)}.
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files fails
     */
    protected void assertEqualDefaultParam(String name, int... expectedExceptions) throws IOException {
        Map<String, Object> param = createParameterMap(null, null, null);
        EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
        assertEqual(setup, expectedExceptions);
    }

    /**
     * Execute the script in <code>name</code> with equally named trace in a self-instantiation
     * project setting (1 project).
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param startRuleName the name of the start rule
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected void assertSelfInstantiate(String name, String startRuleName, int... expectedExceptions) 
        throws IOException {
        assertSelfInstantiate(name, startRuleName, null, expectedExceptions);
    }
    
    /**
     * Interface to check results of self instantiation.
     * 
     * @author Holger Eichelberger
     */
    protected interface SelfInstantiationAsserter {

        /**
         * Asserts validity for files in <code>base</code>.
         * 
         * @param base the base directory
         */
        public void assertIn(File base);
        
    }
    
    /**
     * Execute the script in <code>name</code> with equally named trace in a self-instantiation
     * project setting (1 project).
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param startRuleName the name of the start rule
     * @param expectedExceptions the expected extensions
     * @param asserter optional instance to check the outcome
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected void assertSelfInstantiate(String name, String startRuleName, SelfInstantiationAsserter asserter, 
        int... expectedExceptions) throws IOException {
        // do not operate on the original artifacts
        ArtifactFactory.clear();
        File temp = createTempDir("artifacts");
        FileUtils.copyDirectory(getArtifactsFolder(), temp);
        try {
            TemplateModel.INSTANCE.locations().addLocation(temp, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        try {
            Project project = new Project(temp, ProgressObserver.NO_OBSERVER);
            Map<String, Object> param = createParameterMap(project, project, null);
            EqualitySetup setup = new EqualitySetup(createFile(name), name, null, createTraceFile(name), param);
            setup.setStartElement(startRuleName);
            assertEqual(setup, expectedExceptions);
            if (null != asserter) {
                asserter.assertIn(temp);
            }
            project.release();
            //FileUtils.contentEquals(file1, file2)
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        } finally {
            try {
                TemplateModel.INSTANCE.locations().removeLocation(temp, ProgressObserver.NO_OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail("unexpected exception: " + e.getMessage());
            }
            FileUtils.deleteQuietly(temp);
        }
    }
    
    /**
     * Execute the script in <code>name</code> with equally named trace in a self-instantiation
     * project setting (1 project). By default, the start rule is "main".
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param expectedExceptions the expected extensions
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected void assertSelfInstantiate(String name, int... expectedExceptions) throws IOException {
        assertSelfInstantiate(name, "main", expectedExceptions);
    }

}
