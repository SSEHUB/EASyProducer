package net.ssehub.easy.varModel.varModel.management;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionedModelInfos;
import net.ssehub.easy.varModel.model.Project;

/**
 * Tests {@link VersionedModelInfos}. We assume that {@link ModelInfo} is 
 * tested sucessfully.
 * 
 * @author Holger Eichelberger
 */
public class VersionedProjectInfosTest {

    /**
     * Tests the non-static functions in {@link VersionedModelInfos} with or
     * without given version.
     */
    @Test
    public void testNonStatic() {
        Version v1 = new Version(1);
        Version v2 = new Version(2);
        testNonStatic(null, v1);
        testNonStatic(v1, v2);
        testNonStatic(v1, null);
        testNonStatic(null, null);
    }

    /**
     * Tests the functions in {@link VersionedModelInfos} for a given matching
     * and an unmatching version.
     * 
     * @param version the matching version (positive test, may be <b>null</b>)
     * @param unmatchingVersion the unmatching version (negative test, may be <b>null</b>)
     */
    private void testNonStatic(Version version, Version unmatchingVersion) {
        // create object under test and check attributes
        VersionedModelInfos<Project> vInfo = new VersionedModelInfos<Project>(version);
        Assert.assertTrue(Version.equals(version, vInfo.getVersion()));
        // create test data
        @SuppressWarnings("unchecked")
        ModelInfo<Project>[] data = new ModelInfo[10];
        URI[] uris = new URI[10];
        File dir = new File(".");
        for (int i = 0; i < data.length; i++) {
            File tmpFile = new File(dir, String.valueOf(i)); // does not matter whether this exists
            uris[i] = tmpFile.toURI();
            data[i] = new ModelInfo<Project>("pName", version, null, uris[i], null);
        }
        // test add
        try {
            for (int i = 0; i < data.length; i++) {
                vInfo.add(data[i]);
                Assert.assertTrue(data[i] == vInfo.get(i));
            }
        } catch (IllegalArgumentException e) {
            Assert.assertTrue(false);
        }
        Assert.assertEquals(data.length, vInfo.size());
        for (int i = 0; i < data.length; i++) {
            List<ModelInfo<Project>> list = vInfo.getByEqualUri(uris[i]);
            Assert.assertNotNull(list);
            Assert.assertEquals(1, list.size());
            Assert.assertTrue(data[i] == list.get(0));
        }
        // test invalid add (name mismatch)
        int size = vInfo.size();
        try {
            vInfo.add(new ModelInfo<Project>("dontCare", version, null, null, null));
            Assert.assertTrue(false);
        } catch (IllegalArgumentException e) {
            // this is fine
            Assert.assertEquals(size, vInfo.size()); // no change
        }
        // test removal by object
        Assert.assertTrue(vInfo.remove(data[5]));
        data[5] = null;
        assertEquals(data, vInfo);
        // test removal by index
        Assert.assertTrue(data[4] == vInfo.remove(4));
        data[4] = null;
        assertEquals(data, vInfo);
        // test toList with internally created list
        List<ModelInfo<Project>> list = vInfo.toList(null);
        Assert.assertNotNull(list);
        assertEquals(data, list);
        // test toList with existing list
        list.clear();
        vInfo.toList(list);
        Assert.assertNotNull(list);
        assertEquals(data, list);
        // test clear
        vInfo.clear();
        Assert.assertEquals(0, vInfo.size());
        // test invalid add (version)
        if (!Version.equals(version, unmatchingVersion)) {
            try {
                vInfo.add(new ModelInfo<Project>("dontCare", unmatchingVersion, null, null, null));
                Assert.assertTrue(false);
            } catch (IllegalArgumentException e) {
                // this is fine!
                Assert.assertEquals(0, vInfo.size()); // no change
            }
        }
    }
    
    /**
     * Tests the static functions in {@link VersionedModelInfos}.
     */
    @Test
    public void testStatic() {
        // create test data
        Version[] versions = {null, new Version(1), new Version(2)};
        @SuppressWarnings("unchecked")
        VersionedModelInfos<Project>[] infos = new VersionedModelInfos[versions.length];
        for (int i = 0; i < infos.length; i++) {
            infos[i] = new VersionedModelInfos<Project>(versions[i]);
        }
        
        // test find with null list
        List<VersionedModelInfos<Project>> list = null; 
        assertFind(versions, infos, list);
        
        // test find with empty list
        list = new ArrayList<VersionedModelInfos<Project>>();
        assertFind(versions, infos, list);

        // test find with test data
        for (int i = 0; i < infos.length; i++) {
            list.add(infos[i]);
        }
        assertFind(versions, infos, list);
    }
    
    /**
     * Asserts that the elements contained in <code>list</code> are found and negative
     * find results lead to <b>null</b>.
     * 
     * @param versions the versions to search for
     * @param infos the information objects associated to <code>versions</code>
     * @param list the list to search in (may be <b>null</b> or empty)
     */
    private void assertFind(Version[] versions, VersionedModelInfos<Project>[] infos, 
        List<VersionedModelInfos<Project>> list) {
        Assert.assertTrue(nullify(infos[0], list) == VersionedModelInfos.find(list, versions[0]));
        Assert.assertTrue(nullify(infos[1], list) == VersionedModelInfos.find(list, versions[1]));
        Assert.assertTrue(nullify(infos[2], list) == VersionedModelInfos.find(list, versions[2]));
        
        Assert.assertTrue(nullify(infos[2], list) == VersionedModelInfos.find(list, new Version(2)));
        
        Assert.assertTrue(null == VersionedModelInfos.find(list, new Version(3)));
    }
    
    /**
     * Returns <code>null</code> if <code>list</code> is <b>null</b> or empty.
     * 
     * @param info the information object to be nullified
     * @param list the list causing the nullification
     * @return <code>null</code> if <code>list</code> is <b>null</b> or empty
     */
    private VersionedModelInfos<Project> nullify(VersionedModelInfos<Project> info, 
        List<VersionedModelInfos<Project>> list) {
        return (null == list || 0 == list.size()) ? null : info; 
    }
    
    /**
     * Asserts that the elements in <code>data</code> are also stored in <code>vInfo</code>.
     *
     * @param data the test data (may contain <b>null</b> if already deleted)
     * @param vInfo the object under test
     */
    private void assertEquals(ModelInfo<Project>[] data, VersionedModelInfos<Project> vInfo) {
        int v = 0;
        for (int i = 0; i < data.length; i++) {
            if (null != data[i]) {
                Assert.assertTrue(vInfo.get(v) == data[i]);
                v++;
            }
        }
        Assert.assertEquals(v, vInfo.size());
    }

    /**
     * Asserts that the elements in <code>data</code> are also stored in <code>list</code>.
     *
     * @param data the test data (may contain <b>null</b> if already deleted)
     * @param list a list of project information objects
     */
    private void assertEquals(ModelInfo<Project>[] data, List<ModelInfo<Project>> list) {
        int v = 0;
        for (int i = 0; i < data.length; i++) {
            if (null != data[i]) {
                Assert.assertTrue(list.get(v) == data[i]);
                v++;
            }
        }
        Assert.assertEquals(v, list.size());
    }
    
    /**
     * Tests {@link VersionedModelInfos#getByClosestUri(java.net.URI)}.
     */
    @Test
    public void testGetClosestUri() {
        testGetClosestUri(null);
        testGetClosestUri(new Version(1));
    }

    /* Test schema:
    .
    |- inRoot.ivml (closest shall be inRoot.ivml)
    |- level
       |- inLevel.ivml (closest shall be inLevel.ivml)
       |- sublevel
          |- inSubLevel.ivml (closest shall be inSubLevel.ivml) 
       |- sublevel1
          |* inSubLevel1.ivml (closest shall be inLevel.ivml)
    |- level2
       |- inLevel2.ivml (closest shall be inLevel2.ivml)
    |- level3
       |- sublevel3
         |- subsublevel3
           |- inSubSubLevel3.ivml (closest shall be inSubSubLevel3.ivml)
         |- subsublevel4
           |* inSubSubLevel4.ivml (closest shall be inRoot.ivml)
    |- level4
      |* inLevel4.ivml (closest shall be inRoot.ivml)
    */
    
    /**
     * Tests the functionality of {@link VersionedModelInfos#getByClosestUri(java.net.URI)}
     * for a given <code>version</code>.<br/>
     * 
     * @param version the version to test with (may be <b>null</b>)
     */
    private void testGetClosestUri(Version version) {
        // we assume that add is tested sucessfully
        final String projectName = "myProject";
        File dirRoot = new File(".");

        // backed by project information objects
        File dirLevel = new File(dirRoot, "level");
        File dirLevel2 = new File(dirRoot, "level2");
        File dirLevel3 = new File(dirRoot, "level3");
        File dirSubLevel = new File(dirLevel, "sublevel");
        File dirSubLevel3 = new File(dirLevel3, "sublevel3");
        File dirSubSubLevel3 = new File(dirSubLevel3, "subsublevel3");

        // search locations, other project name or version assumed
        File dirSubLevel1 = new File(dirLevel, "sublevel1");
        File inSubLevel1 = new File(dirSubLevel1, "inSubLevel1.ivml");
        File dirSubSubLevel4 = new File(dirSubLevel3, "subsublevel4");
        File inSubSubLevel4 = new File(dirSubSubLevel4, "inSubSubLevel4.ivml");
        File dirLevel4 = new File(dirRoot, "level4");
        File inLevel4 = new File(dirLevel4, "inLevel4.ivml");

        final int inRoot = 0;
        final int inLevel = 1;
        final int inSubLevel = 2;
        final int inLevel2 = 3;
        final int inSubSubLevel3 = 4;
        final int max = inSubSubLevel3;
        
        @SuppressWarnings("unchecked")
        ModelInfo<Project>[] projectInfo = new ModelInfo[max + 1];
        projectInfo[inRoot] 
            = new ModelInfo<Project>(projectName, version, null, new File(dirRoot, "inRoot.ivml").toURI(), null);
        projectInfo[inLevel] 
            = new ModelInfo<Project>(projectName, version, null, new File(dirLevel, "inLevel.ivml").toURI(), null);
        projectInfo[inSubLevel] 
            = new ModelInfo<Project>(projectName, version, null, new File(dirSubLevel, "inSubLevel.ivml").toURI(), 
                null);
        projectInfo[inLevel2] 
            = new ModelInfo<Project>(projectName, version, null, new File(dirLevel2, "inLevel2.ivml").toURI(), null);
        projectInfo[inSubSubLevel3] = new ModelInfo<Project>(
            projectName, version, null, new File(dirSubSubLevel3, "inSubSubLevel3.ivml").toURI(), null);
        
        VersionedModelInfos<Project> vInfo = new VersionedModelInfos<Project>(version);
        try {
            for (int p = 0; p < projectInfo.length; p++) {
                vInfo.add(projectInfo[p]);
            }
        } catch (IllegalArgumentException e) {
            // shall not happen
            Assert.assertTrue(false);
        }

        // assert match in same directory
        for (int p = 0; p < projectInfo.length; p++) {
            assertClosestUri(projectInfo, vInfo, replaceLocationByDummy(projectInfo[p]), p);
        }
        // assert schema above
        assertClosestUri(projectInfo, vInfo, inSubLevel1.toURI(), inLevel);
        assertClosestUri(projectInfo, vInfo, inSubSubLevel4.toURI(), inRoot);
        assertClosestUri(projectInfo, vInfo, inLevel4.toURI(), inRoot);
    }

    /**
     * Return the location of <code>info</code> with replaced dummy file name.
     * 
     * @param info the information object to be taken as source
     * @return the replaced URI
     */
    private URI replaceLocationByDummy(ModelInfo<Project> info) {
        URI uri = info.getLocation();
        String text = uri.toString();
        int pos = text.lastIndexOf('/');
        if (pos > 0) {
            try {
                uri = new URI(text.substring(0, pos + 1) + "dummy.ivml").normalize();
            } catch (URISyntaxException e) {
                Assert.assertTrue(false); // shall not happen
            }
        }
        return uri;
    }
    
    /**
     * Asserts the closest project version information using 
     * {@link VersionedModelInfos#getByClosestUri(java.net.URI)} to <code>expected</code>.
     * 
     * @param info the information objects created for testing
     * @param vInfo the subject under test
     * @param searchFor the URI to start searching at
     * @param expected the index into <code>info</code> denoting the expected
     *   project information object
     */
    private void assertClosestUri(ModelInfo<Project>[] info, VersionedModelInfos<Project> vInfo, 
        URI searchFor, int expected) {
        if (null == searchFor) {
            expected = 0; // adjust expected to specified default
        }
        ModelInfo<Project> closest = vInfo.getByClosestUri(searchFor, null);
        // we can use here reference equality by construction
        Assert.assertTrue(info[expected] == closest);
    }
    
}
