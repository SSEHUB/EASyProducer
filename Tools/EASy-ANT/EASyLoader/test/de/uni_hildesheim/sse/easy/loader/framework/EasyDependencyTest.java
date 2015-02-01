package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.easy.loader.Loader;

/**
 * Testclass for EasyDependancy.
 * @author pastuschek
 *
 */
public class EasyDependencyTest {

    private static String producerName = "de.uni_hildesheim.sse.EASy-Producer";
    
    /**
     * Tests the version matching.
     */
    @Test 
    public void versionMatching() {
        
        Version small;
        Version big;
        
        try {
            small = new Version("1.6.8");
            big = new Version("1.9.2");
            if (small.compareTo(big) != -1) {
                Assert.fail();
            }
            if (big.compareTo(small) != 1) {
                Assert.fail();
            }
            if (big.compareTo(big) != 0) {
                Assert.fail();
            }
        } catch (BundleException e) {
            Assert.fail();
        }
    
    }
    
    /**
     * Tests the version-range check.
     */
    @Test
    public void versionRange() {
        
        Version min;
        Version max;
        Version within;
        Version lower;
        Version higher;
        Version withinLow;
        Version withinHigh;
        
        try {
            
            min = new Version("1.6.1");
            max = new Version("2.5.3");
            within = new Version("1.9.2");
            withinLow = new Version("1.6.1");
            withinHigh = new Version("2.5.3");
            lower = new Version("0.4.2");
            higher = new Version("2.5.4");
            
            if (!within.isInRange(min, max)) {
                Assert.fail();
            }
            
            if (lower.isInRange(min, max)) {
                Assert.fail();
            }
            
            if (higher.isInRange(min, max)) {
                Assert.fail();
            }
            
            if (!withinHigh.isInRange(min, max)) {
                Assert.fail();
            }
            
            if (!withinLow.isInRange(min, max)) {
                Assert.fail();
            }
            
        } catch (BundleException e) {
            Assert.fail();
        }
        
    }
    
    /**
     * Tests the dependancy as a whole.
     */
    @Test
    public void testDependancy() {
        
        //List<BundleInfo> roots = BundleRegistry.getInstance().getRootBundles();
        
        Loader testLoader = new Loader(new File("."));
        testLoader.bootstrap(null);
        
        EasyDependency versionSpec = new EasyDependency();
        EasyDependency versionSpec2 = new EasyDependency();
        EasyDependency versionSpec3 = new EasyDependency();
        
        try {
            versionSpec.setBundleVersionMin(new Version("0.6.0"));
            versionSpec2.setBundleVersionMin(new Version("0.0.1"));
            versionSpec2.setBundleVersionMax(new Version("0.4.3"));
            versionSpec3.setBundleVersionMax(new Version("0.6.5"));
        } catch (BundleException e) {
            Assert.fail();
        }
        
        BundleInfo test = BundleRegistry.getInstance().get(producerName, versionSpec);
        BundleInfo test2 = BundleRegistry.getInstance().get(producerName, versionSpec2);
        BundleInfo test3 = BundleRegistry.getInstance().get(producerName, versionSpec3);
        
        if (test == null || test2 == null) {
            Assert.fail();
        }
        
        try {
            if (test.getVersion().compareTo(new Version("0.7.1")) != 0) {
                Assert.fail(); 
            }
            if (test.getVersion().compareTo(new Version("0.7.2")) != -1) {
                Assert.fail(); 
            }
            if (test.getVersion().compareTo(new Version("0.7.0")) != 1) {
                Assert.fail(); 
            }
            if (test2.getVersion().compareTo(new Version("0.0.1")) != 0) {
                Assert.fail();
            }
            if (test2.getVersion().compareTo(new Version("0.0.2")) != -1) {
                Assert.fail(); 
            }
            if (test2.getVersion().compareTo(new Version("0.0.0.1")) != 1) {
                Assert.fail(); 
            }
            if (test3.getVersion().compareTo(new Version("0.6.5")) == 1) {
                Assert.fail();
            }
            System.out.println(test3.getVersion());
        } catch (BundleException e) {
            Assert.fail();
        }
        
        
    }
    
    
}
