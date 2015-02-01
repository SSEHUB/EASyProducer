package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.uni_hildesheim.sse.easy.loader.Generator;

/**
 * A simple testcase for the generation functionality.
 * @author pastuschek
 *
 */
public class GeneratorTest {
    
    private static final File FEATURE_PATH = determineDir("easy.features.dir", "../Features");
//    private static final File FEATURE_PATH = determineDir("easy.features.dir", "C:/Repos/Features");
    
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
     * Tests the Generation via Features.
     */
    /*@Test
    public void testGenerator() {
        
        List<Feature> features = new ArrayList<Feature>();
        Feature feat1 = new Feature(new File("//sse.local/Daten/Studenten/Homes/pastuschek/Desktop/feature.xml"));
        Feature feat2 = new Feature(new File("//sse.local/Daten/Studenten/Homes/pastuschek/Desktop/feature2.xml"));
        
        features.add(feat1);
        features.add(feat2);
        
        List<BundleInfo> bundles = Generator.generate(features, null, true);
        
        System.out.println("");
        System.out.println("### Bundles Found: ###");
        List<BundleInfo> testKram = BundleRegistry.getInstance().getAllBundles();
        for (int i = 0; i < testKram.size(); i++) {
            System.out.println(testKram.get(i).getName() + " " + testKram.get(i).getVersion());
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("### Following Plugins were chosen: ###");
        
        for (int i = 0; i < bundles.size(); i++) {     
            if (bundles.get(i) != null) {
                System.out.println("plugin: " + bundles.get(i).getName() + " " + bundles.get(i).getVersion());
            }      
        }        

    }*/
    
    /**
     * The actual major testcase.
     */
    @Test
    public void testGenAutomatic() {
        
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
        addFeat.add(new File("C:/Users/pastuschek/workspace/Features"));
//        addFeat.add(new File("C:/Repos/Features"));
        //addFeat.add(new File("C:/Users/Patu/Desktop/Gen/Features"));

        Generator.autoGenerate(baseFeat, addFeat, true, 
                "C:/Users/pastuschek/Desktop/EASyPlugins/EASyPlugins", 
                //"C:/Users/pastuschek/Desktop/TestEclipseLinux/TestEclipseLinux/plugins",
                "C:/Users/pastuschek/Desktop/EclipsePatrik/EclipseCompile_SSE200/plugins",
                "C:/Users/pastuschek/workspace/EASyLoader/newGenerator", 
                ".", 
                "C:/Users/pastuschek/workspace/EASyLoader/bin",
                "C:/Users/pastuschek/workspace/EASyLoader/libs");
//        Generator.autoGenerate(baseFeat, addFeat, true, "C:/Users/El-Sharkawy/Eclipse/EASyPlugins",
//            "C:/Elscha/Eclipse/Eclipse SSE/plugins", "C:/Elscha/Eclipse/workspaceSSE/EASyLoader/newGenerator",
//            "C:/Elscha/Eclipse/workspaceSSE/EASyLoader", "C:/Elscha/Eclipse/workspaceSSE/EASyLoader/bin");
        
        System.out.println(null == BundleRegistry.getInstance().get("org.eclipse.osgi.services", new EasyDependency()));
    
    }
    
}
