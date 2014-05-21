package de.uni_hildesheim.sse.reasoning.drools;

import java.io.File;
import java.io.IOException;
import org.junit.Test;

public class DroolsTestConf extends AbstractTest {
    

    private static final String DIRPATH = "confidential" + File.separator;
    @Test
    public void testModel() throws IOException {
        projectCount = 2;
        assertConsistency(DIRPATH + "TestModel.ivml", false);
        projectCount = 0;
    }
}
