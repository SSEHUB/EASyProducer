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
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.management.VarModel;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractTest;
import test.de.uni_hildesheim.sse.vil.buildlang.BuildLangTestConfigurer;
import test.de.uni_hildesheim.sse.vil.buildlang.ITestConfigurer;

/**
 * Abstract functionality for scenario tests.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractScenarioTest extends AbstractTest<Script> {

    protected static boolean debug = false;

    /**
     * Defines the default model paths (IVML, VIL, VTL).
     */
    protected static final String[] DEFAULT_MODEL_PATHS = {"EASy", "EASy", "EASy"};

    /**
     * Defines the current model paths.
     */
    protected static String[] modelPaths = DEFAULT_MODEL_PATHS;

    /**
     * Initializes the reasoner.
     */
    static void initializeReasoner() {
        Reasoner reasoner = new Reasoner();
        ReasonerFrontend.getInstance().getRegistry().register(reasoner);
        ReasonerFrontend.getInstance().setReasonerHint(reasoner.getDescriptor());
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
     * Executes a "real-world" case.
     * 
     * @param projectName the name of the project
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param makeExecutable those files (in relative paths) within the temporary copy of the project to be 
     *   made executable
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @return the base directory of the instantiated project
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String projectName, String[] versions, String caseFolder, 
        String sourceProjectName, String... makeExecutable) throws IOException {
        String[] names = new String[1];
        names[0] = projectName;
        return executeCase(names, versions, caseFolder, sourceProjectName, makeExecutable);
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
    
    /**
     * Executes a "real-world" case.
     * 
     * @param names the name of the project, if only one entry the project folder / model name, else project folder 
     * name, (optional) IVML/VIL model name, (optional) VIL model name
     * @param versions the version of the models, index 0 IVML, index 1 VIL build file (may be <b>null</b>)
     * @param caseFolder an optional set of intermediary folders where the actual case study (innermost folder 
     *   corresponds to name) is located in
     * @param makeExecutable those files (in relative paths) within the temporary copy of the project to be 
     *   made executable
     * @param sourceProjectName the optional name of the source project (null if same as <code>projectName</code>)
     * @return the base directory of the instantiated project
     * @throws IOException in case of I/O problems
     */
    protected File executeCase(String[] names, String[] versions, String caseFolder, 
        String sourceProjectName, String... makeExecutable) throws IOException {
        ProgressObserver observer = ProgressObserver.NO_OBSERVER;
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
        makeExecutable(temp, makeExecutable);
        File ivmlFolder = getIvmlFolderIn(temp);
        File vilFolder = getVilFolderIn(temp);
        File vtlFolder = getVtlFolderIn(temp);
        activateBuildProperties(vilFolder);
        try {
            VarModel.INSTANCE.locations().addLocation(ivmlFolder, observer);
            // those loaders shall already be registered through subclassing AbstractTest
            BuildModel.INSTANCE.locations().addLocation(vilFolder, observer);
            TemplateModel.INSTANCE.locations().addLocation(vtlFolder, observer);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception (VIL/VTL): " + e.getMessage());
        }
        net.ssehub.easy.varModel.model.Project iModel = obtainIvmlModel(iModelName, project(versions, 0), ivmlFolder);
        Configuration config = new Configuration(new net.ssehub.easy.varModel.confModel.Configuration(iModel));
        File sourceFile = temp.getAbsoluteFile();
        Project source = createProjectInstance(sourceFile);
        File targetFile = sourceFile;
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
        try {
            VarModel.INSTANCE.locations().removeLocation(ivmlFolder, observer);
            BuildModel.INSTANCE.locations().removeLocation(vilFolder, observer);
            TemplateModel.INSTANCE.locations().removeLocation(vtlFolder, observer);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        return targetFile;
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
     * Make the given files (relative to <code>base</code>) executable.
     * 
     * @param base the base directory
     * @param makeExecutable a set of relative files (may be <b>null</b>)
     */
    private static void makeExecutable(File base, String[] makeExecutable) {
        if (null != makeExecutable) {
            for (String fName : makeExecutable) {
                File file = new File(base, fName);
                if (file.exists()) {
                    file.setExecutable(true); // don't care for owner as this is intended to run on a temporary copy
                }
            }
        }
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
