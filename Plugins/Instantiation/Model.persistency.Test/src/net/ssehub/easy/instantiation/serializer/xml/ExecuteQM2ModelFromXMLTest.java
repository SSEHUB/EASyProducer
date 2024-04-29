package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.BuiltIn;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.impl.ReasonerRegistry;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasoning.sseReasoner.Reasoner;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * Test case for executing the QM2 model from a XML file.
 * 
 * @author Sass
 * 
 */
public class ExecuteQM2ModelFromXMLTest extends AbstractUtil {

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    
    private static final File TMP_DIR = new File(TEMPDATA, "gen");

    private static final File VIL = new File(XMLDATA, "qm2.xml");
    
//    private static final File IVML = new File(XMLDATA, "qm2ivml.xml");
    
    /**
     * Load properties and register types.
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        if (!Environment.runsInEclipse()) {
            loadProperties();
            Registration.register();
            BuiltIn.initialize();
            net.ssehub.easy.instantiation.maven.Registration.register();
            
            // Ensure correct reasoner is used
            while (ReasonerRegistry.getInstance().getReasonerCount() > 0) {
                // Unregister all reasoners
                ReasonerRegistry.getInstance().unregister(ReasonerRegistry.getInstance().getReasoner(0));
            }
            // register desired reasoner: SSE-Reasoner
            ReasonerRegistry.getInstance().register(new Reasoner());
        }
        // Remove all possible locations
        int locationCount = VarModel.INSTANCE.locations().getLocationCount();
        for (int i = 0; i < locationCount; i++) {
            try {
                File varModelLocation = VarModel.INSTANCE.locations().getLocation(i).getLocation();
                File buildModelLocation = BuildModel.INSTANCE.locations().getLocation(i).getLocation();
                File tempModelLocation = TemplateModel.INSTANCE.locations().getLocation(i).getLocation();
                VarModel.INSTANCE.locations().removeLocation(varModelLocation, OBSERVER);
                BuildModel.INSTANCE.locations().removeLocation(buildModelLocation, OBSERVER);
                TemplateModel.INSTANCE.locations().removeLocation(tempModelLocation, OBSERVER);
            } catch (ModelManagementException e) {
                Assert.fail(e.getMessage());
            }
        }
        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
    }
    
    /**
     * Clean up after test.
     */
    @AfterClass
    public static void tearDownAfterClass() {
        FileUtils.deleteQuietly(TMP_DIR);
        // TODO: WHY ARE THERE 2 LOADERS AFTER THE TEST ON JENKINS?
//        Assert.assertEquals(1, VarModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(1, BuildModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(1, TemplateModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(1, VarModel.INSTANCE.locations().getLocationCount());
//        Assert.assertEquals(1, BuildModel.INSTANCE.locations().getLocationCount());
//        Assert.assertEquals(1, TemplateModel.INSTANCE.locations().getLocationCount());
        // Remove locations
//        try {
//            VarModel.INSTANCE.locations().removeLocation(VIL, OBSERVER);
//            VarModel.INSTANCE.locations().removeLocation(IVML, OBSERVER);
//            BuildModel.INSTANCE.locations().removeLocation(VIL, OBSERVER);
//            TemplateModel.INSTANCE.locations().removeLocation(VIL, OBSERVER);
//        } catch (ModelManagementException e) {
//            Assert.fail(e.getMessage());
//        }
        // Unregister Loader
//        VarModel.INSTANCE.loaders().unregisterLoader(IVMLModelLoader.INSTANCE, OBSERVER);
//        BuildModel.INSTANCE.loaders().unregisterLoader(VILModelLoader.INSTANCE, OBSERVER);
//        TemplateModel.INSTANCE.loaders().unregisterLoader(VTLModelLoader.INSTANCE, OBSERVER);
        // Check if all loaders and locations were removed
//        Assert.assertEquals(0, VarModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(0, BuildModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(0, TemplateModel.INSTANCE.loaders().getLoaderCount());
//        Assert.assertEquals(0, VarModel.INSTANCE.locations().getLocationCount());
//        Assert.assertEquals(0, BuildModel.INSTANCE.locations().getLocationCount());
//        Assert.assertEquals(0, TemplateModel.INSTANCE.locations().getLocationCount());
    }
    
    /**
     * Test if the QM2 model can be loaded.
     * 
     * @throws ModelManagementException 
     */
    @Ignore("SE: Currently, the maven execution crashes")
    @Test
    public void testExecuteVil() throws ModelManagementException {
        Assert.assertTrue("File does not exist: " + VIL.getAbsolutePath(), VIL.exists());
        ModelDeserializer.deserializeModel(VIL);
        // execute
        try {
            ProjectDescriptor source = new ProjectDescriptor("qm2.xml", "QM");
            ProjectDescriptor target = new ProjectDescriptor(source, TMP_DIR);
            TracerFactory.setDefaultInstance(ConsoleTracerFactory.INSTANCE);
            Executor executor = new Executor(source.getMainVilScript()).addSource(target).addTarget(target)
                    .addConfiguration(ProjectDescriptor.getConfiguration("QM"));
            executor.execute();
        } catch (ModelManagementException e) {
            Assert.fail(e.getMessage());
        } catch (VilException e) {
            Assert.fail(e.getMessage());
        }
        checkEquality();
    }

    /**
     * Check the equality of the generated files with the original files.
     */
    private void checkEquality() {
        // Exclude jar and class files
        IOFileFilter jarFileFilter = FileFilterUtils.notFileFilter(FileFilterUtils.suffixFileFilter(".jar"));
        IOFileFilter classFileFilter = FileFilterUtils.notFileFilter(FileFilterUtils.suffixFileFilter(".class"));
        IOFileFilter targetFolderFilter = FileFilterUtils.notFileFilter(FileFilterUtils.nameFileFilter("target"));
        IOFileFilter fileFilter = FileFilterUtils.and(jarFileFilter, classFileFilter, targetFolderFilter);
        Collection<File> allfiles = FileUtils.listFiles(TEMPDATA, fileFilter, 
                fileFilter);
        // Check if the right amount of files were generated
        File ifGen = new File(MODELDATA, "if-gen");
        File pipelines = new File(MODELDATA, "pipelines");
        Collection<File> ifGenFiles = FileUtils.listFiles(ifGen, fileFilter, fileFilter);
        Collection<File> pipelineFiles = FileUtils.listFiles(pipelines, fileFilter, fileFilter);
        Collection<File> allOriginalFiles = ifGenFiles;
        allOriginalFiles.addAll(pipelineFiles);
        if (allOriginalFiles.size() != allfiles.size()) {
            for (File file : allOriginalFiles) {
                String newPath = file.getPath();
                newPath = newPath.replaceAll("QM2.devel", "tmp/gen");
                File tmp = new File(newPath);
                if (!allfiles.contains(tmp)) {
                    Assert.fail("Not generated: " + tmp);
                }
            }
        }
        // Compare generated files with original files from the testdata folder
        String gen = "";
        String origin = "";
        for (File file : allfiles) {
            try {
                String generatedFile = readFile(file.toString());
                String path = file.toString().replaceAll("tmp/gen", "QM2.devel");
                String originalFile = readFile(path);
                Assert.assertEquals("Comparison failure in \""+ path + "\" (original) and \""+ file.getAbsolutePath()
                    +"\" (generated)", originalFile, generatedFile);
//                if (!generatedFile.equals(originalFile)) {
//                    Assert.fail("Not equals: " + file);
//                    gen += generatedFile + "\n";
//                    origin += originalFile + "\n";
//                }
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
        Assert.assertEquals(origin, gen);
    }
    
    /**
     * Test for reasoning.
     */
    @Test
    public void testExecuteIVML() {
        Assert.assertTrue("File does not exist: " + VIL.getAbsolutePath(), VIL.exists());
        // if Model does not work due to changes, copy testdata/tmp/qm2.* to testdata/serializedModel.
        // the serializedModel is intentionaly not taken over automatically. it is written during the prequisite tests
        ModelDeserializer.deserializeModel(VIL);
        ReasonerConfiguration configuration = new ReasonerConfiguration();
        configuration.enableCustomMessages();
        Project project = VarModel.INSTANCE.availableModels().getModelInfo("QM").get(0).getResolved();
        Configuration cfg = new Configuration(project);
        
        ReasonerFrontend rFrontend = ReasonerFrontend.getInstance();
        ReasonerDescriptor desc = rFrontend.setPreferredReasoner();
        System.out.println("Using reasoner: " + desc.getName());
        /*ReasoningResult result = */
        ReasonerFrontend.getInstance().check(cfg, configuration, ProgressObserver.NO_OBSERVER);
        //Assert.assertEquals("Reasoning encountered problems", 0, result.getMessageCount()); //unclear
    }
    
}
