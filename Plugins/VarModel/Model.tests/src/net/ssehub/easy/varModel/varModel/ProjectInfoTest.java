package net.ssehub.easy.varModel.varModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionFormatException;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * Test cases for the projectinfo class.
 * @author lueder
 *
 */
public class ProjectInfoTest {

    private Version version;
    private ModelInfo<?> pi;
    private URI location;
    
    /**
     * Sets up the project before the test runs.
     * @throws VersionFormatException 
     * @throws URISyntaxException 
     */
    @Before
    public void setUp() throws VersionFormatException, URISyntaxException {
        version = new Version("1");
        location = new URI("http://asd.de");
    }

    /**
     * Creating a project info.
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Test
    public void creatingProjectInfo() {
        IModelLoader loader = null;
        pi = new ModelInfo("Info", version, loader, location, null);
        Assert.assertEquals("Info", pi.getName());
        Assert.assertEquals(version, pi.getVersion());
        Assert.assertEquals(loader, pi.getLoader());
        Assert.assertEquals(location, pi.getLocation());
        
        Assert.assertEquals("'Info'1" , pi.nameVersionToString());
        
        List<ProjectImport> imp = new ArrayList<ProjectImport>();
        imp.add(new ProjectImport("myProject", null));
        pi = new ModelInfo("Info", null, loader, location, imp);
        Assert.assertTrue(null == pi.getVersion());
        Assert.assertEquals(1, pi.getImportsCount());
        Assert.assertEquals(imp.get(0), pi.getImport(0));
    }

}
