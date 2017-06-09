package net.ssehub.easy.producer.scenario_tests;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Contains those tests not running on Jenkins (whyever). It's fine if there are no tests
 * in this class :)
 * 
 * @author Holger Eichelberger
 */
public class LocalRealTests extends RealTests {
        
    /**
     * Tests the initial INDENICA WMS build (contributed by Christian).
     * 
     * @throws IOException should not occur 
     */
    @Ignore
    @Test
    public void testIndenicaPlWmsPlatform() throws IOException {
        // I've moved it here for initial testing. If it works also under Linux, move it back to RealTests
        
        debug = true; // remove if working
        
        String projectName = "PL_WMS_Platform";
        File base = executeIndenicaCase(projectName, "0", "0");
        Assert.assertNotNull(projectName + " execution failed, thus no base file available", base);

        debug = false; // remove if working

        /*
        String springConfigName = "Web.config";
        String springConfigInstance = "WMSsolutionProduct/StorageBinSearchService/" + springConfigName;
        assertFileEquality(new File(base, springConfigInstance),
            new File(base, "expected_results/" + springConfigName));
        
        String dbCreationName = "1CreateDatabaseAndTables.sql";
        String dbCreationInstance = "WMSsolutionProduct/Config_Resources/" + dbCreationName;
        assertFileEquality(new File(base, dbCreationInstance), new File(base, "expected_results/" + dbCreationName));
        
        String dbDataName = "2InsertExampleData.sql";
        String dbDataInstance = "WMSsolutionProduct/Config_Resources/" + dbDataName;
        assertFileEquality(new File(base, dbDataInstance), new File(base, "expected_results/" + dbDataName));
        
        String orMapperName = "mapperfragment.xml";
        String orMapperInstance = "WMSsolutionProduct/Config_Resources/" + orMapperName;
        assertFileEquality(new File(base, orMapperInstance), new File(base, "expected_results/" + orMapperName));
        
        FileUtils.deleteQuietly(base);
        */
    }

    /**
     * Tests the very initial QualiMaster test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterApril14() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("april14", versions, "QualiMaster/", null);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

    /**
     * Tests the QualiMaster model / derivation (February 2017, without rt-VIL). Seems to fail on Jenkins.
     * This is a slightly modified version to ensure creation of artifacts in repeatable sequence.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterFeb17() throws IOException {
        String[] versions = {"0", "0"};
        String[] names = {"feb17", "QM"};
        File base = executeCase(names, versions, "QualiMaster/", null);
        assertFileEqualityRec(new File(base, "expected"), base);
    }

}
