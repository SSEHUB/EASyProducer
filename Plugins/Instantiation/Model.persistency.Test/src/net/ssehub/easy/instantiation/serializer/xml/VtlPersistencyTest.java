package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.serializer.xml.XmlIo;

/**
 * A simple model write+read test.
 * 
 * @author Aike Sass
 */
public class VtlPersistencyTest extends AbstractTest {

    /**
     * The file to be read/written during the test.
     */
    private static final File TEST_FOLDER = new File(TEMPDATA, "VtlPersistencyTest");
    public static final File FILE = new File(TEST_FOLDER, "testVTL.xml");
    private final String[] vtlFilter = {"vtl" };
    private final Collection<File> vtlFiles = FileUtils.listFiles(MODELDATA, vtlFilter, true);
    
    @Before
    public void setUp() {
        TEST_FOLDER.mkdir();
    }
    
    /**
     * Delete XML file.
     */
    @After
    public void tearDown() {
        try {
            FileUtils.deleteDirectory(TEST_FOLDER);
        } catch (IOException e) {
            Assert.fail("Could not cleanup temp data directory: " + TEST_FOLDER.getAbsolutePath());
        }
    }
    
    /**
     * Executes the test.
     */
    @Test
    public void testReadWrite() {
        for (File file : vtlFiles) {
            ModelInfo<Template> model = TemplateModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                TemplateModel.INSTANCE.load(model);
                Template template = model.getResolved();
                List<IModel> modelList = new ArrayList<IModel>();
                modelList.add(template);
                // Write the file
                XmlIo.write(modelList, FILE, false);
                // Load the file
                List<IModel> loadedModelList = XmlIo.read(FILE, false);
                Template template1 = (Template) loadedModelList.get(0);
                // Check equality
                String templateAsString = toVtlString(template);
                String template1AsString = toVtlString(template1);
                Assert.assertEquals(templateAsString, template1AsString);
            } catch (ModelManagementException e) {
                Assert.fail(e.getMessage());
            } catch (FileNotFoundException e) {
                Assert.fail(e.getMessage());
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            } catch (VilException e) {
                Assert.fail(e.getMessage());
            }
        }
    }

}
