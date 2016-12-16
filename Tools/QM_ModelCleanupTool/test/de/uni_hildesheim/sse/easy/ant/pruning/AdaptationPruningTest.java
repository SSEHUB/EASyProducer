package de.uni_hildesheim.sse.easy.ant.pruning;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

public class AdaptationPruningTest {
    
    // Input for testing
    private final static File DESTINATION_FOLDER = new File("model/prunedDestination");
    private final static File ORIGINAL_FOLDER = new File("model/origin");
    private final static String MAIN_PROJECT = "QM";
    
    @Test
    public void testPruning() {
        if (DESTINATION_FOLDER.exists()) {
            try {
                FileUtils.deleteDirectory(DESTINATION_FOLDER);
            } catch (IOException e) {
                Assert.fail(e.getMessage());
            }
        }
        
        DESTINATION_FOLDER.mkdirs();
        AdaptationPruning antTask = new AdaptationPruning(ORIGINAL_FOLDER.getAbsolutePath(),
            DESTINATION_FOLDER.getAbsolutePath(), MAIN_PROJECT);
        antTask.execute();
    }

}
