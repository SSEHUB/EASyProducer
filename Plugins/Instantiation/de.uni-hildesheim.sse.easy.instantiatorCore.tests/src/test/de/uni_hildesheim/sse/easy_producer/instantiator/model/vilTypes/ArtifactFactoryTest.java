package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.File;

import junit.framework.Assert;

import org.junit.Test;

import test.de.uni_hildesheim.sse.easy_producer.instantiator.model.AbstractTest;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactFactory;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FolderArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IFileSystemArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.VtlFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml.XmlFileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Tests the artifact factory.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactFactoryTest extends AbstractTest {
    
    private static final File TESTDATA_DIR = determineTestDataDir();

    /**
     * Tests the creation of a file system artifact according to basic and file system artifact methods.
     * 
     * @param cls the expected artifact class
     * @param real the real object to create the artifact from
     * @throws ArtifactException in case that something goes wrong
     */
    private static final void testFileSystemArtifact(Class<? extends IArtifact> cls, File real) 
        throws ArtifactException {
        IArtifact artifact = ArtifactFactory.createArtifact(real);
        Assert.assertNotNull("artifact not created" + artifact);
        // not == due to overriden artifacts
        Assert.assertTrue("artifact class not as expected (" + cls.getName() + " <-> " 
            + artifact.getClass().getName() + ")", cls.isAssignableFrom(artifact.getClass()));
        IFileSystemArtifact fsArtifact = ArtifactFactory.createFileSystemArtifact(real);
        Assert.assertNotNull("artifact not created" + fsArtifact);
        // not == due to overriden artifacts
        Assert.assertTrue("artifact class not as expected (" + cls.getName() + " <-> " 
            + artifact.getClass().getName() + ")", cls.isAssignableFrom(fsArtifact.getClass())); 
    }

    /**
     * Tests the creation of default built-in artifacts.
     */
    @Test
    public void testDefaultArtifactCreation() {
        try {
            testFileSystemArtifact(FolderArtifact.class, TESTDATA_DIR);
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception : " + e.getMessage());
        }
        try {
            testFileSystemArtifact(FileArtifact.class, new File(TESTDATA_DIR, "TextFile.txt"));
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception : " + e.getMessage());
        }
        try {
            testFileSystemArtifact(XmlFileArtifact.class, new File(TESTDATA_DIR, "XmlFile.xml"));
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception : " + e.getMessage());
        }
        try {
            ArtifactFactory.createArtifact(new Object());
            Assert.fail("most generic object cannot be handled");
        } catch (ArtifactException e) {
            Assert.assertEquals("no creator / input file does not exist (wrong id)", e.getId(), 
                ArtifactException.ID_NO_ARTIFACT_CREATOR);
        }
        try {
            ArtifactFactory.createArtifact(null);
            Assert.fail("null cannot be handled");
        } catch (ArtifactException e) {
            Assert.assertEquals("null not allowed (wrong id)", e.getId(), 
                ArtifactException.ID_IS_NULL);
        }
    }

    /**
     * Tests type-constrained artifact creation.
     */
    @Test
    public void testConstrainedArtifactCreation() {
        // overriding file artifact may interfere with this test
        try {
            VtlFileArtifact artifact = ArtifactFactory.createArtifact(VtlFileArtifact.class, 
                new File("test.vtl"), null);
            Assert.assertNotNull("specific VTL artifact not created ", artifact);
        } catch (ArtifactException e) {
            Assert.fail("unexpected exception: " + e.getMessage());
        }
    }

    // TODO configuration test
    
}
