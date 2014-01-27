package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class DroolsProjectImportTest extends AbstractTest {
    
    private static final String DIRPATH = "projectImports" + File.separator;
    
    @Test
    public void testBasicProjectImport() throws IOException {
        projectCount = 2;
        assertConsistency(DIRPATH + "BasicProjectImport.ivml", true);
        projectCount = 0;
    }
    
    //@Test
    public void testProjectImportTest() throws IOException {
        projectCount = 1;
        assertConsistency(DIRPATH + "ProjectImportTest.ivml", false);
        projectCount = 0;
    }
    
    @Test
    public void testProjectImportsWithCompoundsTest() throws IOException {
        projectCount = 1;
        assertConsistency(DIRPATH + "ProjectImportsWithCompounds.ivml", false);
        projectCount = 0;
    }
    

}
