package net.ssehub.easy.reasoning.core.upgrader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.junit.Assert;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uni_hildesheim.sse.dslCore.test.AbstractTest;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasoning.core.reasoner.FileUpgrader;
import net.ssehub.easy.reasoning.core.reasoner.IUpgrader;
import net.ssehub.easy.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.reasoning.core.reasoner.ZipUpgrader;
import net.ssehub.easy.varModel.model.Project;

/**
 * Specific tests for the upgrade mechanism.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public class UpgraderTests extends AbstractTest<Project> {
    private static final File TESTDATA = determineTestDataDir("reasonerCore.testdata.home");

    private static final boolean LIST_DIRS = false;
    private static File sourceDir;
    private static File targetDir;
    private static final File TEST_ZIP = new File(TESTDATA, "reasoner.zip");
    
    // original -> target file
    private static final Map<String, String> FILE_MAPPING = new HashMap<String, String>();
    // target file -> size
    private static final Map<String, Long> FILE_SIZE = new HashMap<String, Long>();
    
    /**
     * Create test environment.
     */
    @BeforeClass
    public static void startUp() {
        FILE_MAPPING.put("reasoner/lib/artifacts.jar", "artifacts.jar");
        FILE_MAPPING.put("reasoner/lib/content.jar", "content.jar");
        
        try {
            sourceDir = File.createTempFile("reasonerCore", "");
            sourceDir.delete();
            sourceDir.mkdirs();
            unpackZip(TEST_ZIP, sourceDir);
            for (Map.Entry<String, String> fileMapping : FILE_MAPPING.entrySet()) {
                File file = new File(sourceDir, fileMapping.getKey());
                long size = -1;
                if (file.exists()) {
                    size = file.length();
                }
                FILE_SIZE.put(fileMapping.getValue(), size);
            }
            
            targetDir = File.createTempFile("reasonerCore", "");
            targetDir.delete();
            targetDir.mkdirs();
        } catch (IOException e) {
            Assert.fail("I/O: " + e.getMessage());
        }
    }

    /**
     * Unpacks an entire ZIP file.
     * 
     * @param source the file to unpack
     * @param target the target directory
     * @throws IOException in case of any I/O problem
     */
    private static void unpackZip(File source, File target) throws IOException {
        FileInputStream fis = new FileInputStream(source);
        ZipInputStream zis = new ZipInputStream(fis);

        byte[] buffer = new byte[1024];
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            File f = new File(target, entry.getName());
            if (!entry.isDirectory()) {
                f.getParentFile().mkdirs();
                FileOutputStream fos = new FileOutputStream(f);
                int read = 0;
                while ((read = zis.read(buffer)) != -1) {
                    fos.write(buffer, 0, read);
                }
                fos.close();
            } else {
                f.mkdirs();
            }
        }
        zis.close();
    }

    /**
     * Prints the listing of the (contained) files.
     * See {@link #LIST_DIRS}.
     * 
     * @param file the file/directory to list
     */
    private void print(File file) {
        if (LIST_DIRS) {
            printImpl(file);
            System.out.println();
        }
    }
    
    /**
     * Prints the listing of the (contained) files.
     * 
     * @param file the file/directory to list
     */
    private void printImpl(File file) {
        if (file.isDirectory()) {
            System.out.println(file);
            File[] files = file.listFiles();
            if (null != files) { // dir is empty
                for (int f = 0; f < files.length; f++) {
                    printImpl(files[f]);
                }
            }
        } else {
            System.out.println(" " + file);
        }
    }
    
    /**
     * Cleans a file or a directory, i.e. deletes all contents.
     * 
     * @param file the file to be cleaned
     */
    private static void clean(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) { // dir is empty
                for (int f = 0; f < files.length; f++) {
                    clean(files[f]);
                }
            }
        } else {
            file.delete();
        }
    }

    /**
     * Asserts the results of executing an upgrader.
     * 
     * @param result the reasoning result returned by the upgrade operation
     * @param fileMapping the file mapping provided to the upgrader
     */
    public void assertResult(ReasoningResult result, Map<String, String> fileMapping) {
        Assert.assertNotNull(result);
        if (result.getMessageCount() > 0) {
            for (int m = 0; m < result.getMessageCount(); m++) {
                System.out.println(result.getMessage(m).getDescription());
            }
        }
        Assert.assertEquals(0, result.getMessageCount());
        for (String target : fileMapping.values()) {
            File expected = new File(targetDir, target);
            Assert.assertTrue(expected.exists());
            Long size = FILE_SIZE.get(target);
            Assert.assertNotNull(size);
            Assert.assertEquals(size.longValue(), expected.length());
        }
    }
    
    /**
     * Test {@link ZipUpgrader}.
     */
    @Test
    public void testZipUpgrader() {
        try {
            print(targetDir);
            Map<String, String> fileMapping = Collections.unmodifiableMap(FILE_MAPPING);
            String location = IUpgrader.toBundleLocation(targetDir);
            ZipUpgrader upgrader = new ZipUpgrader(TEST_ZIP.toURI(), 
                location, fileMapping, null, ProgressObserver.NO_OBSERVER);
            assertResult(upgrader.upgrade(), fileMapping);
            print(targetDir);
            clean(targetDir);
        } catch (MalformedURLException e) {
            Assert.fail("URL: " + e.getMessage());
        }
    }

    /**
     * Test {@link FileUpgrader}.
     */
    @Test
    public void testFileUpgrader() {
        try {
            print(targetDir);
            Map<String, String> fileMapping = Collections.unmodifiableMap(FILE_MAPPING);
            String location = IUpgrader.toBundleLocation(targetDir);
            FileUpgrader upgrader = new FileUpgrader(sourceDir.toURI(), 
                location, fileMapping, null, ProgressObserver.NO_OBSERVER);
            assertResult(upgrader.upgrade(), fileMapping);
            print(targetDir);
            clean(targetDir);
        } catch (MalformedURLException e) {
            Assert.fail("URL: " + e.getMessage());
        }
    }
    
    /**
     * Cleanup temporary stuff.
     */
    @AfterClass
    public static void afterTests() {
        clean(sourceDir);
        sourceDir.delete();
        clean(targetDir);
        targetDir.delete();
    }

}
