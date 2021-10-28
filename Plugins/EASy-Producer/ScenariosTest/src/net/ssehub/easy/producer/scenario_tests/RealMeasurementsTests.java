/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.producer.scenario_tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests for experiments only. Can be forced to run in an own JVM.
 */
public class RealMeasurementsTests extends AbstractRealTests {

    private static RealMeasurementsTests tests;

    /**
     * Starts up the test.
     */
    @BeforeClass
    public static void startUp() {
        tests = new RealMeasurementsTests();
        tests.cleanTemp();
    }

    /**
     * Tears down the test.
     */
    @AfterClass
    public static void shutDown() {
        if (!debug && null != tests) {
            tests.cleanTemp();
            tests = null;
        }
    }
    
    @Override
    protected String getMeasurementFileName() {
        return "measurements-scenarioVariants.tsv";
    }
    
    @Override
    protected File getTestFolder() {
        return new File(getTestDataDir(), "real");
    }

    
    /**
     * Modifies a QM test by enabling a specified variant of the pipelines configuration file.
     * 
     * @author Holger Eichelberger
     */
    private static class QMTestModifier implements ITestModifier {

        private int variantNr;
        private File target;
        
        @Override
        public void postCopy(File target) {
            this.target = target;
            copy(new File(target, "variants/PipelinesCfg_" + variantNr + ".ivml"), 
                new File(target, "EASy/pipelines/PipelinesCfg.ivml"));
            copy(new File(target, "variants/InfrastructureCfg_" + variantNr + ".ivml"), 
                new File(target, "EASy/infrastructure/InfrastructureCfg.ivml"));
            copy(new File(target, "variants/AlgorithmsCfg_" + variantNr + ".ivml"), 
                new File(target, "EASy/infrastructure/AlgorithmsCfg.ivml"));
            copy(new File(target, "variants/FamiliesCfg_" + variantNr + ".ivml"), 
                new File(target, "EASy/infrastructure/FamiliesCfg.ivml"));
            copy(new File(target, "variants/DataManagementCfg_" + variantNr + ".ivml"), 
                new File(target, "EASy/infrastructure/DataManagementCfg.ivml"));
            try {
                FileUtils.deleteDirectory(new File(target, "variants"));
            } catch (IOException e) {
                System.out.println("ERROR: Cannot delete variants folder, " + e.getMessage());
            }
        }
        
        /**
         * Copies a file if it exists to a target location. Ignores non existing sources files
         * 
         * @param src the source file
         * @param tgt the target location
         */
        private void copy(File src, File tgt) {
            if (src.exists()) {
                System.out.println("Copying " + src + " to " + tgt);
                try {
                    FileUtils.copyFile(src, tgt);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        
        /**
         * Cleans up if not already done.
         */
        private void cleanUp() {
            if (null != target) {
                FileUtils.deleteQuietly(target);
                target = null;
            }
        }
        
        /**
         * Changes the variant to activate.
         * 
         * @param variantNr the variant nr
         */
        private void setVariantNr(int variantNr) {
            this.variantNr = variantNr;
        }

        @Override
        public String getTempFolderName(String projectName) {
            return String.format("%02d_sv_%s", variantNr, projectName);
        }

        @Override
        public File getVilOutputFolder(File tmp) {
            return null;
        }
        
    }

    /**
     * Tests the QualiMaster model / derivation (February 2017, experimentally modified, without rt-VIL). This is a 
     * series of modified models by leaving out certain pipelines. No VIL instantiations are executed on the 
     * variants, only reasoning.
     * 
     * @throws IOException shall not occur
     */
    @Test
    public void testQualiMasterSep17Variants() throws IOException {
        QMTestModifier modifier = new QMTestModifier();
        
        String[] versions = {"0", "0"};
        String[] names = {"sep17", "QM"};
        enableRealTimeAsserts = true;
        int[] tests = {0, 4, 5, 6, 7, 8, 9, 10, 11, 12}; // more seems to cause problems with file system on windows
        for (int i : tests) {
            System.out.println(">> Start Variant " + i);
            modifier.setVariantNr(i);
            executeCase(names, versions, "QualiMaster/", null, Mode.REASON, modifier);
            modifier.cleanUp();
            System.out.println("<< End Variant " + i);
        }
        enableRealTimeAsserts = false;
    }


}
