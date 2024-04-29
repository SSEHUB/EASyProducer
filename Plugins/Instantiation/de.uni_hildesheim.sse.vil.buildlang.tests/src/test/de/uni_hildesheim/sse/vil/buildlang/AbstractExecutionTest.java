package test.de.uni_hildesheim.sse.vil.buildlang;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.SystemUtils;
import org.junit.Assert;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.Project;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.varModel.testSupport.DefaultConfiguration;

/**
 * Implements the functionality of an abstract execution test (basis for reuse).
 * 
 * @param <M> the actual model type
 * @author Holger Eichelberger
 */
public abstract class AbstractExecutionTest <M extends Script> extends AbstractTest<M> {

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
     * Creates a file object relative to {@link #getTestFolder()} (not a file).
     * 
     * @param name
     *            the name of the file (excluding ".trc")
     * @return the file
     */
    protected File createTraceFile(String name) {
        File file = new File(getTestFolder(), name + ".trc");
        if (SystemUtils.IS_OS_MAC) {
            file = insertAndCheckInfix(file, "macos");
        } else if (SystemUtils.IS_OS_UNIX) {
            file = insertAndCheckInfix(file, "unix");
        } else if (SystemUtils.IS_OS_WINDOWS) {
            file = insertAndCheckInfix(file, "win");
        }
        return file;
    }

    /**
     * Inserts an OS infix and before the extension of <code>file</code>
     * and returns the modified file object if it exists.
     * 
     * @param file the file to be taken as template
     * @param infix the infix to be inserted
     * @return <code>file</code> the the composed file name does not exist, the composed file name else
     */
    private File insertAndCheckInfix(File file, String infix) {
        String f = file.toString();
        int pos = f.lastIndexOf('.');
        if (pos > 0) {
            f = f.substring(0, pos + 1) + infix + "." + f.substring(pos + 1);
            File tmp = new File(f);
            if (tmp.exists()) {
                file = tmp;
            }
        }
        return file;
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
        EqualitySetup<M> setup = new EqualitySetup<M>(createFile(name), name, null, createTraceFile(name));
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
    protected static Map<String, Object> createParameterMap(Project source, Project target, Configuration config) {
        Map<String, Object> param = new HashMap<String, Object>();
        if (null == source) {
            source = new Project(); // just dummy
        }
        if (null == target) {
            target = new Project(); // just dummy
        }
        if (null == config) {
            net.ssehub.easy.varModel.confModel.Configuration cfg = DefaultConfiguration.createDefaultConfiguration();
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
        EqualitySetup<M> setup = new EqualitySetup<M>(createFile(name), name, null, createTraceFile(name), param);
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
         * Determines the test directory which should be used for the test.
         * 
         * @param file directory for the test
         * @return File containing the directory
         */
        public File determineTestDirectory(File file);

        /**
         * Asserts validity for files in <code>base</code>.
         * 
         * @param base the base directory
         */
        public void assertIn(File base);
        
        /**
         * Delete between multiple test runs.
         * 
         * @param base the base directory
         */
        public void deleteBetween(File base);
        
    }

    /**
     * Just an empty implementation as adapter.
     * 
     * @author Holger Eichelberger
     */
    public static class SelfInstantiationAsserterAdapter implements SelfInstantiationAsserter {

        @Override
        public void assertIn(File base) {
        }

        @Override
        public void deleteBetween(File base) {
        }

        @Override
        public File determineTestDirectory(File file) {
            return file;
        }
        
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
        assertSelfInstantiate(name, startRuleName, null, asserter, expectedExceptions);
    }
    
    /**
     * Execute the script in <code>name</code> with equally named trace in a self-instantiation
     * project setting (1 project).
     * 
     * @param name the name of the test file (without extension), the name of the project and
     *   the name of the trace file (without extension)
     * @param startRuleName the name of the start rule
     * @param configName the IVML name of the configuration to be used
     * @param expectedExceptions the expected extensions
     * @param asserter optional instance to check the outcome
     * @throws IOException in case that loading files or preparing the test environment fails
     */
    protected void assertSelfInstantiate(String name, String startRuleName, String configName, 
        SelfInstantiationAsserter asserter, int... expectedExceptions) throws IOException {
        // do not operate on the original artifacts
        ArtifactFactory.clear();
        File temp = createTempDir("artifacts");
        FileUtils.copyDirectory(getArtifactsFolder(), temp);
        if (null != asserter) {
            temp = asserter.determineTestDirectory(temp);
        }
        try {
            TemplateModel.INSTANCE.locations().addLocation(temp, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        try {
            Project project = new Project(temp, ProgressObserver.NO_OBSERVER);
            Configuration config = null;
            if (null != configName) {
                List<ModelInfo<net.ssehub.easy.varModel.model.Project>> info = 
                    VarModel.INSTANCE.availableModels().getModelInfo(configName);
                if (info.isEmpty()) {
                    Assert.fail("cannot find IVML model " + configName);
                }
                if (info.size() > 1) {
                    Assert.fail("IVML model ambiguous " + info);
                }
                try {
                    config = new Configuration(new net.ssehub.easy.varModel.confModel.Configuration(
                        VarModel.INSTANCE.load(info.get(0))));
                } catch (ModelManagementException e) {
                    Assert.fail(e.getMessage());
                }
            }
            
            Map<String, Object> param = createParameterMap(project, project, config);
            String pName = name;
            int pos = pName.lastIndexOf("/");
            if (pos > 0) {
                pName = pName.substring(pos + 1);
            }
            EqualitySetup<M> setup = new EqualitySetup<M>(createFile(name), pName, null, createTraceFile(name), param);
            setup.setStartElement(startRuleName);
            assertEqual(setup, createCleaner(asserter, temp), expectedExceptions);
            if (null != asserter) {
                asserter.assertIn(temp);
            }
            project.release();
            //FileUtils.contentEquals(file1, file2)
        } catch (VilException e) {
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
     * Creates a cleaner from an asserter.
     * 
     * @param asserter the asserter (may be <b>null</b>)
     * @param base the base directory
     * @return the cleaner or <b>null</b>
     */
    private static Cleaner createCleaner(final SelfInstantiationAsserter asserter, final File base) {
        Cleaner result = null;
        if (null != asserter) {
            result = new Cleaner() {
                
                @Override
                public void deleteBetween() {
                    asserter.deleteBetween(base);
                }
            };
        }
        return result;
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
