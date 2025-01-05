package net.ssehub.easy.producer.scenario_tests;

import static net.ssehub.easy.varModel.varModel.testSupport.TextTestUtils.*;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.producer.scenario_tests.mocks.MavenMock;

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
        if (null != base) {
            Assert.assertNotNull(projectName + " execution failed, thus no base file available", base);
    
            /*
            String springConfigName = "Web.config";
            String springConfigInstance = "WMSsolutionProduct/StorageBinSearchService/" + springConfigName;
            assertFileEquality(new File(base, springConfigInstance),
                new File(base, "expected_results/" + springConfigName));
            
            String dbCreationName = "1CreateDatabaseAndTables.sql";
            String dbCreationInstance = "WMSsolutionProduct/Config_Resources/" + dbCreationName;
            assertFileEquality(new File(base, dbCreationInstance),new File(base, "expected_results/" + dbCreationName));
            
            String dbDataName = "2InsertExampleData.sql";
            String dbDataInstance = "WMSsolutionProduct/Config_Resources/" + dbDataName;
            assertFileEquality(new File(base, dbDataInstance), new File(base, "expected_results/" + dbDataName));
            
            String orMapperName = "mapperfragment.xml";
            String orMapperInstance = "WMSsolutionProduct/Config_Resources/" + orMapperName;
            assertFileEquality(new File(base, orMapperInstance), new File(base, "expected_results/" + orMapperName));
            
            FileUtils.deleteQuietly(base);
            */
        }
        debug = false; // remove if working
    }

    /**
     * Tests the very initial QualiMaster test case.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterApril14() throws IOException {
        String[] versions = {"0", "0"};
        File base = executeCase("april14", versions, "QualiMaster/", null, Mode.REASON_INSTANTIATE);
        if (null != base) {
            assertFileEqualityRec(new File(base, "expected"), base);
        }
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, without rt-VIL). Seems to fail on Jenkins.
     * This is a slightly modified version to ensure creation of artifacts in repeatable sequence.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterFeb17() throws IOException {
        testQualiMasterFeb17Impl(Mode.REASON_INSTANTIATE);
    }
    
    /**
     * Tests the QualiMaster model / derivation (February 2017, experimentally modified, without rt-VIL). Seems to 
     * fail on Jenkins. This is a modified version for evaluating VIL/VTL.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterSep17() throws IOException {
        testQualiMasterSep17Impl(Mode.REASON_INSTANTIATE);
    }
    
    /**
     * Tests the oktoflow model / instantiation (updated recent model).
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testOktoflowExperiment() throws IOException {
        final String folder = "experiment";
        File f = new File(getTestFolder(), "IIP-Ecosphere/" + folder);
        if (f.exists()) {
            // ensure passthrough states
            boolean origMvnPassThrough = MavenMock.setPassThrough(false);
            
            // tests
            executeIipCase(folder, "ApiPlatformConfiguration", "generateApi", "tests/api", "tests/common");
            executeIipCase(folder, "PlatformConfiguration", "generateApps", "tests/simpleMesh3", "tests/common");
            executeIipCase(folder, "SerializerConfig1", "main", "tests/single", "tests/common");
            executeIipCase(folder, "SerializerConfig1Old", "generateApps", "tests/single", "tests/common");
            executeIipCase(folder, "KodexMesh", "generateApps", "tests/single", "tests/common");
            executeIipCase(folder, "Modbus", "generateApps", "tests/modbus");
            
            // reset passthrough
            MavenMock.setPassThrough(origMvnPassThrough);
        }
    }
    
    @Override
    protected TracerFactory getTracerFactory() {
        //CodeWriter.setDebugFilter(f -> f.getName().endsWith(".py"));
        return super.getTracerFactory();
        //return net.ssehub.easy.instantiation.core.model.tracing.ConsoleTracerFactory.INSTANCE;
    }
    
}
