package test.de.uni_hildesheim.sse.scenarios;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import de.uni_hildesheim.sse.easy.java.Registration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.TracerFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Project;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.modelManagement.VersionFormatException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import test.de.uni_hildesheim.sse.vil.buildlang.AbstractTest;

/**
 * Abstract functionality for scenario tests.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractScenarioTest extends AbstractTest {

    protected static boolean debug = true;

    /**
     * Defines the default model paths (IVML, VIL, VTL).
     */
    protected static final String[] DEFAULT_MODEL_PATHS = {"EASy", "EASy", "EASy"};

    /**
     * Defines the current model paths.
     */
    protected static String[] modelPaths = DEFAULT_MODEL_PATHS;

    @Override
    protected void furtherInitialization() {
        Registration.register();
    }

    @Override
    protected String getSystemPropertyName() {
        return "easy_producer.scenarios.testdata.home";
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
        ProgressObserver observer = ProgressObserver.NO_OBSERVER;
        ArtifactFactory.clear();
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
            VarModel.INSTANCE.loaders().registerLoader(de.uni_hildesheim.sse.ModelUtility.INSTANCE, observer);
            VarModel.INSTANCE.locations().addLocation(ivmlFolder, observer);
            // those loaders shall already be registered through subclassing AbstractTest
            BuildModel.INSTANCE.locations().addLocation(vilFolder, observer);
            TemplateModel.INSTANCE.locations().addLocation(vtlFolder, observer);
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
        de.uni_hildesheim.sse.model.varModel.Project ivmlModel = obtainIvmlModel(projectName, versions[0], ivmlFolder);
        Configuration config = new Configuration(new de.uni_hildesheim.sse.model.confModel.Configuration(ivmlModel));
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
        MyTracerFactory tFactory = new MyTracerFactory();
        TracerFactory.setInstance(tFactory);
        Script script = obtainVilModel(projectName, versions[1], vilFolder);
        Executor executor = new Executor(script, param);
        executor.addBase(targetFile);
        try {
            executor.execute();
        } catch (VilLanguageException e) {
            System.out.println(tFactory);
            e.printStackTrace(System.out);
            Assert.fail("VIL execution issue " + e);
        }
        if (debug) {
            System.out.println(tFactory);
        }
        TracerFactory.setInstance(current);
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
     * Obtains the specified VIL model.
     * 
     * @param projectName the name of the project
     * @param vilVersion the version of the VIL file
     * @param vilFolder the base folder for VIL files
     * @return the VIL model
     */
    private static Script obtainVilModel(String projectName, String vilVersion, File vilFolder) {
        URI scriptURI = new File(vilFolder, projectName + "_" + vilVersion + ".vil").toURI();
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
    private static de.uni_hildesheim.sse.model.varModel.Project obtainIvmlModel(String projectName, String ivmlVersion,
        File ivmlFolder) {
        URI modelURI = new File(ivmlFolder, projectName + "_" + ivmlVersion + ".ivml").toURI();
        de.uni_hildesheim.sse.model.varModel.Project ivmlModel = null;
        try {
            ModelInfo<de.uni_hildesheim.sse.model.varModel.Project> info = 
                VarModel.INSTANCE.availableModels().getModelInfo(projectName, ivmlVersion, modelURI);
            Assert.assertNotNull("IVML model " + projectName + " cannot be found", info);
            ivmlModel = VarModel.INSTANCE.load(info);
        } catch (VersionFormatException e) {
            Assert.fail("version information invalid");
        } catch (ModelManagementException e) {
            Assert.fail("unexpected exception: " + e);
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
    private static File getIvmlFolderIn(File base) {
        return new File(base, modelPaths[0]);
    }

    /**
     * Returns the folder in <code>base</code> containing the VIL files.
     * 
     * @param base the base directory for the project
     * @return the VIL files folder
     */
    private static File getVilFolderIn(File base) {
        return new File(base, modelPaths[1]);
    }

    /**
     * Returns the folder in <code>base</code> containing the VTL files.
     * 
     * @param base the base directory for the project
     * @return the VTL files folder
     */
    private static File getVtlFolderIn(File base) {
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
        } catch (ArtifactException e) {
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
        protected de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.ITracer 
        createBuildLanguageTracerImpl() {
            return new de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StreamTracer(writer, true);
        }

        @Override
        protected de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.ITracer 
        createTemplateLanguageTracerImpl() {
            return new de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.StreamTracer(writer, true);
        }
        
    }

}
