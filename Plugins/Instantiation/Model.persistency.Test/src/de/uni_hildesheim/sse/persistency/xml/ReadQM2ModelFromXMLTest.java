package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.util.Collection;
import java.util.List;

import loader.IVMLModelLoader;
import loader.VILModelLoader;
import loader.VTLModelLoader;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Test case for loading the QM2 model from a xml file.
 * 
 * @author Sass
 * 
 */
public class ReadQM2ModelFromXMLTest extends AbstractUtil {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ReadQM2ModelFromXMLTest.class, 
            "Model.persistency.Test");

    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    private final File file = new File("qm2.xml");
    private final String[] vtlFilter = {"vtl" };
    private final String[] vilFilter = {"vil" };
    private final String[] ivmlFilter = {"ivml" };
    private final Collection<File> vtlFiles = FileUtils.listFiles(getTestDataDir(), vtlFilter, true);
    private final Collection<File> vilFiles = FileUtils.listFiles(getTestDataDir(), vilFilter, true);
    private final Collection<File> ivmlFiles = FileUtils.listFiles(getTestDataDir(), ivmlFilter, true);

    // TODO: tptp performance messen und in excel schreiben
    // AbstractInstantiateLocal
    /**
     * Test if the QM2 model can be loaded.
     */
    @Test
    public void testReadQM2() {
        long before = System.nanoTime();
        try {
            BuiltIn.initialize();
            VarModel.INSTANCE.loaders().registerLoader(new IVMLModelLoader(), OBSERVER);
            VarModel.INSTANCE.locations().addLocation(file, OBSERVER);
            for (File file : ivmlFiles) {
                String pattern = "(_\\d)*.ivml";
                String fileName = file.getName().replaceAll(pattern, "");
                List<ModelInfo<Project>> list = VarModel.INSTANCE.availableModels().getModelInfo(fileName);
                Assert.assertEquals(true, list != null);
                ModelInfo<Project> model = list.get(0);
                try {
                    VarModel.INSTANCE.load(model);
                } catch (ModelManagementException e) {
                    logger.exception(e);
                }
            }
            BuildModel.INSTANCE.loaders().registerLoader(new VILModelLoader(), OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(file, OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(new VTLModelLoader(), OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(file, OBSERVER);
        } catch (ModelManagementException e1) {
            logger.exception(e1);
        }
        for (File file : vilFiles) {
            String pattern = "(_\\d)*.vil";
            String fileName = file.getName().replaceAll(pattern, "");
            List<ModelInfo<Script>> list = BuildModel.INSTANCE.availableModels().getModelInfo(fileName);
            Assert.assertEquals(true, list != null);
            ModelInfo<Script> model = list.get(0);
            try {
                BuildModel.INSTANCE.load(model);
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
//            sysoutScript(model);
        }
        for (File file : vtlFiles) {
            String fileName = file.getName().replace(".vtl", "");
            List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
            if (list == null) {
                System.out.println(fileName);
            }
            Assert.assertEquals(true, list != null);
            ModelInfo<Template> model = list.get(0);
            try {
                TemplateModel.INSTANCE.load(model);
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        // execute
        try {
            ProjectDescriptor source = new ProjectDescriptor("qm2.xml", "QM");
            ProjectDescriptor target = new ProjectDescriptor(source, file);
            Executor executor = new Executor(source.getMainVilScript()).addSource(source).addTarget(target)
                    .addConfiguration(ProjectDescriptor.getConfiguration("QM"));
            executor.execute();
        } catch (ModelManagementException e) {
            logger.exception(e);
            e.printStackTrace();
        } catch (VilLanguageException e) {
            logger.exception(e);
            e.printStackTrace();
        }
        long after = System.nanoTime();
        long runningTimeMs = (after - before) / 1000000;
        System.out.println("Duration: " + runningTimeMs);
    }

}
