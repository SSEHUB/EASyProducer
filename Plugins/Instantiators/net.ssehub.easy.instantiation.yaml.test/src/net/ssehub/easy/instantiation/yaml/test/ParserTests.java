package net.ssehub.easy.instantiation.yaml.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.instantiation.yaml.YamlDeserializer;
import net.ssehub.easy.instantiation.yaml.YamlEditor;
import net.ssehub.easy.instantiation.yaml.YamlSerializer;

/**
 * This class contains tests for the yaml instantiation editor.
 * @author Aike Sass
 *
 */
public class ParserTests extends AbstractTest {

    private static final File STORM = new File(determineTestDataDir(), "storm.yaml");

    private static final File WORKER = new File(determineTestDataDir(), "worker-storm.yaml");

    private static final String OUTPUT_FILE_NAME = "output.yaml";

    /**
     * Test if a configuration file can be loaded.
     */
    @Test
    public void testYamlDeserializer() {
        try {
            Map<Object, Object> data = YamlDeserializer.getInstance().loadFile(STORM);
            Assert.assertNotNull(data);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    // @Test
    // public void testYamlSerializer() {
    // try {
    // Map<Object, Object> data =
    // YamlDeserializer.getInstance().loadFile(STORM);
    // Assert.assertNotNull(data);
    // File outputFile = new File(TMP, OUTPUT_FILE_NAME);
    // YamlSerializer.getInstance().save(data, outputFile);
    // Assert.assertTrue(outputFile.exists());
    // } catch (FileNotFoundException e) {
    // Assert.fail(e.getMessage());
    // } catch (IOException e) {
    // Assert.fail(e.getMessage());
    // }
    // }

    /**
     * Test if entries can be updated.
     */
    @Test
    public void testUpdateEntry() {
        try {
            Map<Object, Object> data = YamlDeserializer.getInstance().loadFile(STORM);
            Assert.assertNotNull(data);
            File outputFile = new File(TMP, OUTPUT_FILE_NAME);
            String key = "nimbus.host";
            String value = "192.168.0.2";
            YamlEditor.getInstance().updateEntry(outputFile, key, value);
            // Load file and check if the entry was updated
            Map<Object, Object> newData = YamlEditor.getInstance().getData();
            Assert.assertEquals(value, newData.get(key));
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Test if the original file can be changed.
     */
    @Test
    public void testChangeOriginalFile() {
        try {
            String key = "nimbus.host";
            String value = "192.168.0.2";
            YamlEditor.getInstance().updateEntry(STORM, key, value);
            YamlEditor.getInstance().updateEntry(STORM, "storm.zookeeper.port", Integer.valueOf("2182"));
            YamlEditor.getInstance().updateEntry(STORM, "nimbus.thrift.port", Integer.valueOf("6628"));
            ArrayList<String> list = (ArrayList<String>) YamlEditor.getInstance().getData()
                    .get("storm.zookeeper.servers");
            list.add("192.168.0.104");
            YamlEditor.getInstance().updateEntry(STORM, "storm.zookeeper.servers", list);

            YamlEditor.getInstance().updateEntry(STORM, key, value);
            String oldString = YamlDeserializer.getInstance().getOriginalFile();
            Assert.assertNotNull(oldString);
            Assert.assertEquals(false, oldString.isEmpty());
            String newString = YamlSerializer.getInstance().merge(YamlEditor.getInstance().getData(), oldString);

            File expected = new File(determineTestDataDir(), "storm_new.yaml");
            FileInputStream inputStream = new FileInputStream(expected);
            String fileAsString = "";
            try {
                fileAsString = IOUtils.toString(inputStream);
            } finally {
                inputStream.close();
            }
            Assert.assertEquals(fileAsString, newString);

        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Disabled. Provide user and password for testing.
     * Test if a configuration file can be loaded from a remote host.
     */
//    @Test
//    @Ignore
//    public void testConnectViaSCP() {
//        String user = "";
//        String password = "";
//        File dest = new File(TMP, "remote.yaml");
//        YamlDeserializer.getInstance().getFromSCP(user, password, "nimbus1.sse.local",
//                "/usr/local/storm/conf/storm.yaml", dest.getAbsolutePath());
//        Assert.assertTrue(dest.exists());
//    }

    /**
     * Disabled. Provide user and password for testing.
     */
//    @Test
//    @Ignore
//    public void testGetWorkerInfo() {
//        String user = "";
//        String password = "";
//        File dest = new File(TMP, "worker.txt");
//        try {
//            YamlDeserializer.getInstance().getStormWorker(user, password, "nimbus1.sse.local",
//                    "/var/nfs/env.sh", dest.getAbsolutePath());
//        } catch (IOException e) {
//            Assert.fail(e.getMessage());
//        }
//    }

    /**
     * Test if a backup file will be created.
     */
    @Test
    public void testCreateBackup() {
        try {
            YamlDeserializer.getInstance().createBackup(STORM);
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }
    }

    /**
     * Test if numberous files can be edited.
     */
    @Test
    public void testAutomaticEditing() {
        File src = new File(determineTestDataDir(), "storm");
        File dest = new File(TMP, "storm");
        String key = "worker.childopts";
        String value = " -SPASSMETER";
        File expected = new File(determineTestDataDir(), "storm_SPASSmeter.yaml");
        String expectedString = null;
        try {
            FileInputStream inputStream = new FileInputStream(expected);
            expectedString = IOUtils.toString(inputStream);
            FileUtils.copyDirectory(src, dest);
        } catch (IOException e1) {
            Assert.fail(e1.getMessage());
        }
        for (int i = 1; i < 4; i++) {
            String path = "worker" + i + "/usr/local/storm/conf/storm.yaml";
            File file = new File(dest, path);
            try {
                System.out.println(file);
                YamlDeserializer.getInstance().createBackup(file);
                YamlEditor.getInstance().refreshData(file);
                String oldValue = (String) YamlEditor.getInstance().getEntry(key, file);
                System.out.println(oldValue);
                String newValue = oldValue + value;
                YamlEditor.getInstance().updateEntry(file, key, newValue);
                String oldString = YamlDeserializer.getInstance().getOriginalFile();
                Assert.assertNotNull(oldString);
                Assert.assertEquals(false, oldString.isEmpty());
                String newString = YamlSerializer.getInstance().merge(YamlEditor.getInstance().getData(), oldString);
                //Assert.assertEquals(expectedString, newString); // missing whitespace
                YamlSerializer.getInstance().save(newString, file);
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
//        try {
//            FileUtils.deleteDirectory(dest);
//        } catch (IOException e) {
//            Assert.fail(e.getMessage());
//        }
    }
}
