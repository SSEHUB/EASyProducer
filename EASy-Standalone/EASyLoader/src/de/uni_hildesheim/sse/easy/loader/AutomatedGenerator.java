package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy.loader.framework.BundleInfo;
import de.uni_hildesheim.sse.easy.loader.framework.BundleRegistry;
import de.uni_hildesheim.sse.easy.loader.framework.EasyDependency;

/**
 * Start the automated generation of the generator class.
 * @author pastuschek
 *
 */
public class AutomatedGenerator {
    
    private static final File FEATURE_PATH = determineDir("easy.features.dir", "../Features");
    
    /**
     * Determines folders, which should be used during testing.
     * @param property A system property to specify the directory from outside.
     * @param defaultFolder A folder relative to this project. Will only be used if no property was used.
     * @return A folder which can be used for testing.
     */
    private static File determineDir(String property, String defaultFolder) {
        File result;
        String externalLocation = System.getProperty(property);
        if (null == externalLocation) {
            result = new File(defaultFolder);
        } else {
            result = new File(externalLocation);
        }
        return result;
    }
    
    /**
     * Main method is used to conveniently start the automated generation.
     * @param args arguments
     */
    public static void main(String[] args) {
        
        List<File> baseFeat = new ArrayList<File>();
        List<File> addFeat = new ArrayList<File>();
        System.out.println(FEATURE_PATH.getAbsolutePath());
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.easy_producer.core.no_eclipse_feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.ivml.core_feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.vil.core_feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.reasoning.drools2_feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.apache.commons.io.feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.easy.instantiator.java.feature"));
        baseFeat.add(new File(
                FEATURE_PATH, "de.uni_hildesheim.sse.easy_producer.instantiation.velocity_feature"));
        addFeat.add(new File(FEATURE_PATH.getAbsolutePath()));

        Generator.autoGenerate(baseFeat, addFeat, true);
        System.out.println("**** Done ****");
        
    }

}
