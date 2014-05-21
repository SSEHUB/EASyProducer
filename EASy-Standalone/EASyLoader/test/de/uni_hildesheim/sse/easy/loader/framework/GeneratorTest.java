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

    /**
     * Tests the Generation via Features.
     */
    @Test
    public void testGenerator() {
        
        List<Feature> features = new ArrayList<Feature>();
        Feature feat1 = new Feature(new File("//sse.local/Daten/Studenten/Homes/pastuschek/Desktop/feature.xml"));
        Feature feat2 = new Feature(new File("//sse.local/Daten/Studenten/Homes/pastuschek/Desktop/feature2.xml"));
        
        features.add(feat1);
        features.add(feat2);
        
        List<BundleInfo> bundles = Generator.generate(features, true);
        
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

    }
    
}
