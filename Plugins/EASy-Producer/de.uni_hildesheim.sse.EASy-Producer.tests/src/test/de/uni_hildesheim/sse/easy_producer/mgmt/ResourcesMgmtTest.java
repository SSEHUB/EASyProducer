package test.de.uni_hildesheim.sse.easy_producer.mgmt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import test.AllTests;
import de.uni_hildesheim.sse.easy_producer.persistency.ResourcesMgmt;

/**
 * Tests the ResourcesMgmt and its functions. NOT WORKING RIGHT NOW!
 * 
 * @author Pastuschek
 * 
 */
public class ResourcesMgmtTest {

    private static boolean projectsImported = false;
    
    private static File[] childs;
    private ResourcesMgmt mgmt = ResourcesMgmt.INSTANCE;

    /**
     * Preparation before testing.
     */
    @BeforeClass
    public static void setUpBeforeClass() {

        if (!projectsImported) {
            AllTests.setUpBeforeClass();
            
            if (AllTests.TESTDATA_DIR_COPY.isDirectory()) {
                childs = AllTests.TESTDATA_DIR_COPY.listFiles();
            }
    
            if (null != childs) {
                for (int i = 0; i < childs.length; i++) {
                    copyIntoWorkspace(childs[i]);
    
                }
            } else {
                Assert.fail("Could not load testdata directory.");
            }
            
            projectsImported = true;
        }
    }

    /**
     * Tests the {@link ResourcesMgmt#isPLPInWorkspace(String)} and the {@link ResourcesMgmt#findPLProjects()} methods.
     */
    @Test
    public void testIsPLPInWorkspace() {

        ResourcesMgmt.INSTANCE.findPLProjects();
        System.out.println("MANAGER WORKSPACE: " + mgmt.getWorkspace().getRoot().getLocation());

        IProject[] projects = mgmt.getAllProjects();
        System.out.println("NUMBER OF PROJECTS FOUND: " + projects.length);
        for (int i = 0; i < projects.length; i++) {
            System.out.println(i + ": " + projects[i].getName());
        }

        IProject test = mgmt.getProject("PL_1");

        System.out.println();
        System.out.println("Existing.: " + test.exists());
        System.out.println("Open: " + test.isOpen());

        Assert.assertFalse(mgmt.isPLPInWorkspace("notThere"));
        // Assert.assertTrue(mgmt.isPLPInWorkspace("PL_1"));

    }

    /**
     * Helping method for testing: copies projects into eclipse's workspace.
     * @param file A Folder where the contents should be copied into the workspace.
     */
    private static void copyIntoWorkspace(File file) {

        InputStream in = null;
        OutputStream out = null;
        File[] childs = null;

        IWorkspace workspace = ResourcesPlugin.getWorkspace();
        String relativePath = AllTests.TESTDATA_DIR_COPY.toURI().relativize(file.toURI()).getPath();
        File target = new File(workspace.getRoot().getLocation().toOSString() + File.separator + relativePath);

        if (file.isDirectory()) {

            target.mkdirs();

            childs = file.listFiles();

            for (int i = 0; i < childs.length; i++) {
                copyIntoWorkspace(childs[i]);
            }

        } else {

            try {
                in = new FileInputStream(file.getPath());
                out = new FileOutputStream(target);
                System.out.println("COPY FILE:" + target.getAbsolutePath());
            } catch (FileNotFoundException noFileException) {
                // TODO Auto-generated catch block
                noFileException.printStackTrace();
            }

            try {

                byte[] buf = new byte[1024];
                int len;

                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }

                in.close();
                out.close();

            } catch (IOException ioException) {

                ioException.printStackTrace();

            }

        }

    }

}
