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
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.serializer.xml.XmlIo;

/**
 * A simple model write+read test.
 * 
 * @author Aike Sass
 */
public class VilPersistencyTest extends AbstractTest {

    /**
     * The file to be read/written during the test.
     */
    private static final File TEST_FOLDER = new File(TEMPDATA, "VilPersistencyTest");
    
    public static final File FILE = new File(TEST_FOLDER, "testVIL.xml");
    
    private final String[] vilFilter = {"vil" };
    
    private Collection<File> vilFiles = null;
    
    
    @Before
    public void setUp() {
        vilFiles = FileUtils.listFiles(MODELDATA, vilFilter, true);
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
        for (File file : vilFiles) {
            ModelInfo<Script> model = BuildModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                BuildModel.INSTANCE.load(model);
                Script script = model.getResolved();
                List<IModel> modelList = new ArrayList<IModel>();
                modelList.add(script);
                // Write file
                XmlIo.write(modelList, FILE, false);
                // Read file
                List<IModel> loadedModelList = XmlIo.read(FILE, false);
                Assert.assertEquals(true, loadedModelList.size() > 0);
                Script script1 = (Script) loadedModelList.get(0);
                // Check equality
                String scriptAsString = toVilString(script);
                String script1AsString = toVilString(script1);
                Assert.assertEquals(scriptAsString, script1AsString);
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
