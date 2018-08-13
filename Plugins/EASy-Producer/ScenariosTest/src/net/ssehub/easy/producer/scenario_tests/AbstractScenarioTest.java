package net.ssehub.easy.producer.scenario_tests;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.ITracer;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.Project;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;
import net.ssehub.easy.instantiation.java.Registration;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.AbstractTestDescriptor;
import net.ssehub.easy.reasoning.core.reasoner.GeneralMeasures;
import net.ssehub.easy.reasoning.core.reasoner.IMeasurementKey;
import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.sseReasoner.Measures;
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.varModel.testSupport.MeasurementCollector;
import net.ssehub.easy.varModel.varModel.testSupport.TSVMeasurementCollector;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;
import test.net.ssehub.easy.reasoning.sseReasoner.TestDescriptor;

/**
 * Abstract functionality for scenario tests.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractScenarioTest extends AbstractTest<Script> {

    protected static boolean debug = false;
    // enable/switch of instantiation by default, helpful for reasoning performance experiments
    protected static boolean instantiate = Boolean.valueOf(System.getProperty("easy.scenario.instantiate", "true"));

    /**
     * Test execution modes.
     * 
     * @author Holger Eichelberger
     */
    protected enum Mode {
        
        LOAD(false, false, true),
        REASON(true, false, true),
        REASON_NO_MEASURE(true, false, false),
        INSTANTIATE(false, true, true),
        REASON_INSTANTIATE(true, true, true);
        
        private boolean doReason;
        private boolean doInstantiate;
        private boolean doMeasure;
        
        /**
         * Creates a mode.
         * 
         * @param doReason do reasoning
         * @param doInstantiate do instantiation
         * @param doMeasure do measure
         */
        private Mode(boolean doReason, boolean doInstantiate, boolean doMeasure) {
            this.doReason = doReason;
            this.doInstantiate = doInstantiate;
            this.doMeasure = doMeasure;
        }
        
        /**
         * Returns whether reasoning shall be done.
         * 
         * @return <code>true</code> for reasoning, <code>false</code> else
         */
        protected boolean doReason() {
            return doReason;
        }
        
        /**
         * Returns whether instantiation shall be done.
         * 
         * @return <code>true</code> for instantiation, <code>false</code> else
         */
        protected boolean doInstantiate() {
            return doInstantiate;
        }

        /**
         * Returns whether measurements shall be done and collected.
         * 
         * @return <code>true</code> for measurements, <code>false</code> else
         */
        protected boolean doMeasure() {
            return doMeasure;
        }

    }
    
    /**
     * Defines the default model paths (IVML, VIL, VTL).
     */
    protected static final String[] DEFAULT_MODEL_PATHS = {"EASy", "EASy", "EASy"};

    /**
     * Defines the current model paths.
     */
    protected static String[] modelPaths = DEFAULT_MODEL_PATHS;
    
    protected static final IMeasurementKey[] MEASUREMENTS = AbstractTestDescriptor.concat(
        Measures.values(), GeneralMeasures.values()); 

    /**
     * Initializes the reasoner.
     */
    static void initializeReasoner() {
        Reasoner reasoner = new Reasoner();
        ReasonerFrontend.getInstance().getRegistry().register(reasoner);
        ReasonerFrontend.getInstance().setReasonerHint(reasoner.getDescriptor());
        // common measurements
        AbstractTestDescriptor.registerMeasurementMappings();
        // SSE reasoner measurements
        TestDescriptor.registerMeasurementMappings();
        // see also MEASUREMENTS!
    }
    
    /**
     * Returns a reasoner instance.
     * 
     * @return the instance
     */
    protected IReasoner createReasoner() {
        return new Reasoner();
    }
    
    @Override
    protected void furtherInitialization() {
        initializeReasoner();
        Registration.register();
        net.ssehub.easy.instantiation.ant.Registration.register();
        net.ssehub.easy.instantiation.aspectj.Registration.register();
        //de.uni_hildesheim.sse.easy.maven.Registration.register();
        PersistenceUtils.loadDefaultModels(ProgressObserver.NO_OBSERVER);
    }
    
    @Override
    protected ITestConfigurer<Script> createTestConfigurer() {
        return new BuildLangTestConfigurer("easy_producer.scenarios.testdata.home");
    }

    /**
     * Configures the execution of VIL for <code>projectName</code>.
     * 
     * @param projectName the project name
     * @param args the arguments (may be modified as a side effect
     */
    protected void configureExecution(String projectName, Map<String, Object> args) {
    }
    
    /**
     * Projects the specified version from <code>versions</code>.
     * 
     * @param versions the versions (may be <b>null</b>)
     * @param index the index within version (ignored if <code>versions</code> is <b>null</b>)
     * @return the version or <b>null</b>
     */
    private static String project(String[] versions, int index) {
        return null == versions ? null : versions[index];
    }
    
    // checkstyle: stop parameter number check

    /**
     * Executes a "real-world" case.
     * 
     * @param projectName the name of the project
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @param mode the testing mode
     * @return the base directory of the instantiated project
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String projectName, String[] versions, String caseFolder, 
        String sourceProjectName, Mode mode) throws IOException {
        return executeCase(projectName, versions, caseFolder, sourceProjectName, mode, null);
    }
    
    /**
     * Executes a "real-world" case.
     * 
     * @param projectName the name of the project
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @param mode the testing mode
     * @param modifier test modifier instance (may be <b>null</b>)
     * @return the base directory of the instantiated project
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String projectName, String[] versions, String caseFolder, 
        String sourceProjectName, Mode mode, ITestModifier modifier) throws IOException {
        String[] names = new String[1];
        names[0] = projectName;
        return executeCase(names, versions, caseFolder, sourceProjectName, mode, modifier);
    }

    /**
     * An instance that may modify certain behavior of a real-world test case on-the-fly.
     * 
     * @author Holger Eichelberger
     */
    protected interface ITestModifier {

        /**
         * Called after copying files from a base test template to the actual test folder.
         * 
         * @param target the actual test folder
         */
        public void postCopy(File target);
        
    }

    /**
     * A Test modifier that makes given files executable.
     * 
     * @author Holger Eichelberger
     */
    public static class MakeExecutableTestModifier implements ITestModifier {
        
        private String[] makeExecutable;

        /**
         * Creates a modifier with a set of files to be made executable.
         * 
         * @param makeExecutable those files (in relative paths) within the temporary copy of the project to be 
         *   made executable
         */
        public MakeExecutableTestModifier(String... makeExecutable) {
            this.makeExecutable = makeExecutable;
        }
        
        @Override
        public void postCopy(File target) {
            if (null != makeExecutable) {
                for (String fName : makeExecutable) {
                    File file = new File(target, fName);
                    if (file.exists()) {
                        file.setExecutable(true); // don't care for owner as this is intended to run on a temporary copy
                    }
                }
            }
        }
        
    }

    
    /**
     * Executes a "real-world" case.
     * 
     * @param names the name of the project, if only one entry the project folder / model name, else project folder 
     * name, (optional) IVML/VIL model name, (optional) VIL model name
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @param mode the testing mode
     * @return the base directory of the instantiated project (<b>null</b> for no instantiation, i.e., do not assert)
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String[] names, String[] versions, String caseFolder, String sourceProjectName, 
        Mode mode) throws IOException {
        return executeCase(names, versions, caseFolder, sourceProjectName, mode, null);
    }
    
    /**
     * Executes a "real-world" case.
     * 
     * @param names the name of the project, if only one entry the project folder / model name, else project folder 
     * name, (optional) IVML/VIL model name, (optional) VIL model name
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @param mode the testing mode
     * @param modifier test modifier instance (may be <b>null</b>)
     * @return the base directory of the instantiated project (<b>null</b> for no instantiation, i.e., do not assert)
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String[] names, String[] versions, String caseFolder, 
        String sourceProjectName, Mode mode, ITestModifier modifier) throws IOException {
        ArtifactFactory.clear();
        String projectName = names[0];
        String iModelName = names.length > 1 ? names[1] : projectName;
        String vModelName = names.length > 2 ? names[2] : iModelName;
        File temp = createTempDir(projectName);
        File base = new File(getTestFolder(), caseFolder + projectName);
        FileUtils.copyDirectory(base, temp);
        File sourceProjectFolder = null;
        if (null != sourceProjectName) {
            sourceProjectFolder = createTempDir(sourceProjectName);
            File sBase = new File(getTestFolder(), caseFolder + sourceProjectName);
            FileUtils.copyDirectory(sBase, sourceProjectFolder);
        }
        if (null != modifier) {
            modifier.postCopy(temp);
        }
        File ivmlFolder = getIvmlFolderIn(temp);
        File vilFolder = getVilFolderIn(temp);
        File vtlFolder = getVtlFolderIn(temp);
        activateBuildProperties(vilFolder);
        System.out.println("Registering model location...");
        doLocations(ivmlFolder, vilFolder, vtlFolder, true);
        System.out.println("Loading IVML...");
        net.ssehub.easy.varModel.model.Project iModel = obtainIvmlModel(iModelName, project(versions, 0), ivmlFolder);
        Configuration config = assertConfiguration(iModel, mode);
        File targetFile = null;
        if (instantiate && mode.doInstantiate()) {
            File sourceFile = temp.getAbsoluteFile();
            Project source = createProjectInstance(sourceFile);
            targetFile = sourceFile;
            Project target = source; // adjust base below if changed
            if (null != sourceProjectFolder) {
                source = createProjectInstance(sourceProjectFolder.getAbsoluteFile());
            }
            Map<String, Object> param = new HashMap<String, Object>();
            Project[] tmp = new Project[1]; // the EASy way to call it
            tmp[0] = source;
            param.put(Executor.PARAM_SOURCE, tmp);
            param.put(Executor.PARAM_TARGET, target);
            param.put(Executor.PARAM_CONFIG, config);
            configureExecution(projectName, param);
            System.out.println("Executing VIL...");
            TracerFactory current = TracerFactory.getInstance();
            TracerFactory tFactory = getTracerFactory();
            TracerFactory.setDefaultInstance(tFactory);
            Script script = obtainVilModel(vModelName, project(versions, 1), vilFolder);
            Executor executor = new Executor(script, param);
            executor.addBase(targetFile);
            try {
                executor.execute();
            } catch (VilException e) {
                System.out.println(tFactory);
                e.printStackTrace(System.out);
                Assert.fail("VIL execution issue " + e);
            }
            println(tFactory, debug);
            TracerFactory.setDefaultInstance(current);
        }
        doLocations(ivmlFolder, vilFolder, vtlFolder, false);
        return targetFile;
    }
    
    /**
     * Operate on the locations.
     * 
     * @param ivmlFolder the IVML folder
     * @param vilFolder the VIL folder
     * @param vtlFolder the VTL folder
     * @param add <code>true</code> for adding as locations, <code>false</code> for removing
     */
    private void doLocations(File ivmlFolder, File vilFolder, File vtlFolder, boolean add) {
        try {
            // those loaders shall already be registered through subclassing AbstractTest
            if (add) {
                VarModel.INSTANCE.locations().addLocation(ivmlFolder, ProgressObserver.NO_OBSERVER);
                BuildModel.INSTANCE.locations().addLocation(vilFolder, ProgressObserver.NO_OBSERVER);
                TemplateModel.INSTANCE.locations().addLocation(vtlFolder, ProgressObserver.NO_OBSERVER);
            } else {
                VarModel.INSTANCE.locations().removeLocation(ivmlFolder, ProgressObserver.NO_OBSERVER);
                BuildModel.INSTANCE.locations().removeLocation(vilFolder, ProgressObserver.NO_OBSERVER);
                TemplateModel.INSTANCE.locations().removeLocation(vtlFolder, ProgressObserver.NO_OBSERVER);
            }
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception (VIL/VTL): " + e.getMessage());
        }
    }

    // checkstyle: resume parameter number check

    /**
     * Creates and asserts a VIL configuration and checks the reasoning/propagation result for no conflicts.
     * 
     * @param prj the project to create the configuration for
     * @param mode the testing mode
     * @return the VIL configuration
     */
    protected Configuration assertConfiguration(net.ssehub.easy.varModel.model.Project prj, Mode mode) {
        System.out.println("Creating VIL configuration...");
        Configuration config = new Configuration(new net.ssehub.easy.varModel.confModel.Configuration(prj));
        Assert.assertNotNull("VIL configuration must not be null", config);
        if (mode.doReason()) {
            System.out.println("Performing reasoning/propagation...");
            ReasonerConfiguration rCfg = new ReasonerConfiguration();
            rCfg.setTimeout(5000); // to be on the safe side
            TSVMeasurementCollector.ensureCollector(new File(getTestDataDir(), "temp/" + getMeasurementFileName()));
            String id = mode.doMeasure() ? MeasurementCollector.start(config.getConfiguration(), "SCENARIO") : null;
            ReasoningResult res = ReasonerFrontend.getInstance().propagate(prj, 
                config.getConfiguration(), rCfg, ProgressObserver.NO_OBSERVER);
            if (null != id) {
                MeasurementCollector.endAuto(id);
                net.ssehub.easy.reasoning.core.reasoner.AbstractTest.transferReasoningMeasures(
                    MeasurementCollector.getInstance(), id, getMeasurements(), res);
                MeasurementCollector.end(id);
            }
            res.logInformation(prj, rCfg);
            Assert.assertFalse("Reasoning must not have a conflict", res.hasConflict());
            Assert.assertFalse("Reasoning must not have a timeout", res.hasTimeout());
        }
        return config;
    }
    
    /**
     * Returns the name of the measurement file.
     * 
     * @return the name of the measurement file
     */
    protected abstract String getMeasurementFileName();

    /**
     * Returns the measurements to be collected for the measurement collector.
     * Requires registration of measurement keys!
     * 
     * @return the measurements
     */
    protected IMeasurementKey[] getMeasurements() {
        return MEASUREMENTS;
    }

    /**
     * Conditional println.
     * 
     * @param object the object to be printed
     * @param print to print or not to print
     */
    private static void println(Object object, boolean print) {
        if (print) {
            System.out.println(object);
        }
    }
    
    /**
     * Creates the tracer factory.
     * 
     * @return the tracer factory
     */
    protected TracerFactory getTracerFactory() {
        return new MyTracerFactory();
    }
    
    /**
     * Obtains the specified VIL model.
     * 
     * @param projectName the name of the project
     * @param vilVersion the version of the VIL file
     * @param vilFolder the base folder for VIL files
     * @return the VIL model
     */
    private static Script obtainVilModel(String projectName, String vilVersion, File vilFolder) {
        String versionPostfix = "";
        if (null != vilVersion) {
            versionPostfix = "_" + vilVersion;
        }
        URI scriptURI = new File(vilFolder, projectName + versionPostfix + ".vil").toURI();
        Script script = null;
        try {
            ModelInfo<Script> info = 
                BuildModel.INSTANCE.availableModels().getModelInfo(projectName, vilVersion, scriptURI);
            Assert.assertNotNull("VIL model " + projectName + " " + vilVersion + " cannot be found", info);
            script = BuildModel.INSTANCE.load(info);
        } catch (VersionFormatException e) {
            Assert.fail("version information invalid");
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e);
        }
        Assert.assertNotNull("cannot load VIL build script " + projectName + " (syntax?)", script);
        return script;
    }

    /**
     * Obtains the specified IVML model.
     * 
     * @param projectName the name of the project
     * @param ivmlVersion the version of the IVML file
     * @param ivmlFolder the base folder for IVML files
     * @return the IVML model
     */
    protected static net.ssehub.easy.varModel.model.Project obtainIvmlModel(String projectName, String ivmlVersion,
        File ivmlFolder) {
        String versionSuffix = "";
        if (null != ivmlVersion) {
            versionSuffix = "_" + ivmlVersion;
        }
        URI modelURI = new File(ivmlFolder, projectName + versionSuffix + ".ivml").toURI();
        net.ssehub.easy.varModel.model.Project ivmlModel = null;
        try {
            ModelInfo<net.ssehub.easy.varModel.model.Project> info = 
                VarModel.INSTANCE.availableModels().getModelInfo(projectName, ivmlVersion, modelURI);
            Assert.assertNotNull("IVML model " + projectName + " cannot be found", info);
            ivmlModel = VarModel.INSTANCE.load(info);
        } catch (VersionFormatException e) {
            Assert.fail("version information invalid (IVML)");
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception (IVML): " + e);
        }
        Assert.assertNotNull("cannot load IVML model " + projectName + " (syntax?)", ivmlModel);
        return ivmlModel;
    }

    /**
     * Returns the folder in <code>base</code> containing the IVML files.
     * 
     * @param base the base directory for the project
     * @return the IVML files folder
     */
    protected static File getIvmlFolderIn(File base) {
        return new File(base, modelPaths[0]);
    }

    /**
     * Returns the folder in <code>base</code> containing the VIL files.
     * 
     * @param base the base directory for the project
     * @return the VIL files folder
     */
    protected static File getVilFolderIn(File base) {
        return new File(base, modelPaths[1]);
    }

    /**
     * Returns the folder in <code>base</code> containing the VTL files.
     * 
     * @param base the base directory for the project
     * @return the VTL files folder
     */
    protected static File getVtlFolderIn(File base) {
        return new File(base, modelPaths[2]);
    }

    /**
     * Activates operating system specific build properties if they exist.
     * 
     * @param dir the directory to look into
     */
    private static void activateBuildProperties(File dir) {
        String os = System.getProperty("os.name").toLowerCase();
        String suffix;
        if (os.indexOf("win") >= 0 ) {
            suffix = "win";
        } else {
            suffix = "unix"; // at least unix-based
        }
        File file = new File(dir, "build.properties_" + suffix);
        if (file.exists()) {
            file.renameTo(new File(dir, "build.properties"));
        }
    }

    /**
     * Creates a project instance for <code>folder</code>.
     * 
     * @param folder the folder to create the project on
     * @return the created project instance
     */
    private static Project createProjectInstance(File folder) {
        Project result = null;
        try {
            result = new Project(folder, ProgressObserver.NO_OBSERVER);
        } catch (VilException e) {
            Assert.fail("unexpected exeption: " + e);
        }
        return result;
    }
    
    /**
     * A simple tracer factory for understanding the build process.
     * 
     * @author Holger Eichelberger
     */
    private static class MyTracerFactory extends TracerFactory {
        
        private StringWriter writer = new StringWriter();
        
        @Override
        public String toString() {
            return writer.toString();
        }
        
        @Override
        public ITracer createTemplateLanguageTracerImpl() {
            return net.ssehub.easy.instantiation.core.model.templateModel.NoTracer.INSTANCE;
        }

        @Override
        public net.ssehub.easy.instantiation.core.model.buildlangModel.ITracer createBuildLanguageTracerImpl() {
            return net.ssehub.easy.instantiation.core.model.buildlangModel.NoTracer.INSTANCE;
        }

        @Override
        public IInstantiatorTracer createInstantiatorTracerImpl() {
            return EMPTY_INSTANTIATOR_TRACER;
        }
        
    }

}
