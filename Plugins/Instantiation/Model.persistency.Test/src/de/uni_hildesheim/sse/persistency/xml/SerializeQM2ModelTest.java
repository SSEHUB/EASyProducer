package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.BuildLangModelUtility;
import de.uni_hildesheim.sse.ModelUtility;
import de.uni_hildesheim.sse.VilExpressionParser;
import de.uni_hildesheim.sse.easy.java.Registration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.BuiltIn;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildlangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionParserRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateLangExecution;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;
import de.uni_hildesheim.sse.vil.templatelang.TemplateLangModelUtility;
import de.uni_hildesheim.sse.vil.templatelang.VtlExpressionParser;

/**
 * Test if the whole QM2 model can be serialized.
 * 
 * @author Sass
 *
 */
public class SerializeQM2ModelTest extends AbstractUtil {
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(SerializeQM2ModelTest.class, 
            "Model.persistency.Test");
    
    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;
    
    private static final File FILE = new File("qm2.xml");
    private final String[] vtlFilter = {"vtl" };
    private final String[] vilFilter = {"vil" };
    private final String[] ivmlFilter = {"ivml" };
    private final Collection<File> vtlFiles = FileUtils.listFiles(getTestDataDir(), vtlFilter, true);
    private final Collection<File> vilFiles = FileUtils.listFiles(getTestDataDir(), vilFilter, true);
    private final Collection<File> ivmlFiles = FileUtils.listFiles(getTestDataDir(), ivmlFilter, true);

    /**
     * Test if the whole QM2 model can be serialized.
     */
    @Test
    public void testWriteQM2() {
        long before = System.nanoTime();
        Registration.register();
        BuiltIn.initialize();
        ExpressionParserRegistry.setExpressionParser(BuildlangExecution.LANGUAGE, new VilExpressionParser());
        ExpressionParserRegistry.setExpressionParser(TemplateLangExecution.LANGUAGE, new VtlExpressionParser());
        try {
            VarModel.INSTANCE.loaders().registerLoader(ModelUtility.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.loaders().registerLoader(BuildLangModelUtility.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(TemplateLangModelUtility.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(getTestDataDir(), OBSERVER);
        } catch (ModelManagementException e) {
            logger.exception(e);
        }
        List<IModel> modelList = new ArrayList<IModel>();
        for (File file : ivmlFiles) {
            String pattern = "(_\\d)*.ivml";
            String fileName = file.getName().replaceAll(pattern, "");
            List<ModelInfo<Project>> list = VarModel.INSTANCE.availableModels().getModelInfo(fileName);
            ModelInfo<Project> model = list.get(0);
            try {
                VarModel.INSTANCE.load(model);
                Project project = model.getResolved();
                modelList.add(project);
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        for (File file : vtlFiles) {
            String fileName = file.getName().replace(".vtl", "");
            List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
            ModelInfo<Template> model = list.get(0);
            try {
                TemplateModel.INSTANCE.load(model);
                Template template = model.getResolved();
                modelList.add(template);
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        for (File file : vilFiles) {
            String pattern = "(_\\d)*.vil";
            String fileName = file.getName().replaceAll(pattern, "");
            List<ModelInfo<Script>> list = BuildModel.INSTANCE.availableModels().getModelInfo(fileName);
            ModelInfo<Script> model = list.get(0);
            try {
                BuildModel.INSTANCE.load(model);
                Script script = model.getResolved();
                modelList.add(script);
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        FileOutputStream out;
        try {
            out = new FileOutputStream(FILE);
            XmlIo.write(modelList, out);
        } catch (FileNotFoundException e) {
            logger.exception(e);
        }
        long after = System.nanoTime();
        long runningTimeMs = (after - before) / 1000000;
        System.out.println("Duration: " + runningTimeMs);
    }
    
    /**
     * Test if the QM2 model can be loaded from a XML file.
     */
    @Test
    public void testReadQM2() {
        FileInputStream in;
        int countFiles = vilFiles.size() + ivmlFiles.size() + vtlFiles.size();
        try {
            in = new FileInputStream(FILE);
            List<IModel> list = XmlIo.read(in);
            Assert.assertEquals(countFiles, list.size());
        } catch (FileNotFoundException e) {
            logger.exception(e);
        }
    }
}
