package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * A simple model write+read test.
 * 
 * @author Aike Sass
 */
public class VtlPersistencyTest extends AbstractTest {

    /**
     * The file to be read/written during the test.
     */
    public static final File FILE = new File("testVTL.xml");
    private final String[] vtlFilter = {"vtl" };
    private final Collection<File> vtlFiles = FileUtils.listFiles(getTestDataDir(), vtlFilter, true);

    /**
     * Executes the test.
     */
    @Test
    public void testReadWrite() {
        // TODO: does not work since some projects can not be resolved
//        for (File file : vtlFiles) {
//            String fileName = file.getName().replace(".vtl", "");
//            List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo(fileName);
//            System.out.println(fileName);
//            ModelInfo<Template> model = list.get(0);
//            try {
//                TemplateModel.INSTANCE.load(model);
//                Template template = model.getResolved();
//                List<IModel> modelList = new ArrayList<IModel>();
//                modelList.add(template);
//                FileOutputStream out = new FileOutputStream(FILE);
//                XmlIo.write(modelList, out);
//                out.close();
//
//                FileInputStream in = new FileInputStream(FILE);
//                List<IModel> loadedModelList = XmlIo.read(in);
//                Template template1 = (Template) loadedModelList.get(0);
//
//                String templateAsString = toVtlString(template);
//                String template1AsString = toVtlString(template1);
//
//                Assert.assertEquals(templateAsString, template1AsString);
//            } catch (ModelManagementException e) {
//                logger.exception(e);
//
//            } catch (FileNotFoundException e) {
//                logger.exception(e);
//            } catch (IOException e) {
//                logger.exception(e);
//            } catch (VilLanguageException e) {
//                logger.exception(e);
//            }
//        }
        List<ModelInfo<Template>> list = TemplateModel.INSTANCE.availableModels().getModelInfo("maxHost");
        ModelInfo<Template> model = list.get(0);
        try {
            TemplateModel.INSTANCE.load(model);
            Template template = model.getResolved();
            List<IModel> modelList = new ArrayList<IModel>();
            modelList.add(template);
            FileOutputStream out = new FileOutputStream(FILE);
            XmlIo.write(modelList, out);
            out.close();

            FileInputStream in = new FileInputStream(FILE);
            List<IModel> loadedModelList = XmlIo.read(in);
            Template template1 = (Template) loadedModelList.get(0);

            String templateAsString = toVtlString(template);
            String template1AsString = toVtlString(template1);

            Assert.assertEquals(templateAsString, template1AsString);
        } catch (ModelManagementException e) {
            logger.exception(e);
        } catch (FileNotFoundException e) {
            logger.exception(e);
        } catch (IOException e) {
            logger.exception(e);
        } catch (VilLanguageException e) {
            logger.exception(e);
        }
    }

}
