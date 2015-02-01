package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import de.uni_hildesheim.sse.easy.loader.framework.BundleInfo;
import de.uni_hildesheim.sse.easy.loader.framework.BundleRegistry;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Provides a bundle analysis on top of the EASy loader.
 * 
 * @author Holger Eichelberger
 */
public class Analyzer extends AbstractLoader {

    /**
     * Creates a new analyzer with default base ".".
     */
    public Analyzer() {
        this(new File("."));
    }
    
    /**
     * Creates a new analyzer.
     * 
     * @param base the base folder where the plugins are located in
     */
    public Analyzer(File base) {
        super(base);
    }
    
    /**
     * Starts the analyzer.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Analyzer analyzer = new Analyzer();
        analyzer.analyze();
    }
    
    static {
        initializeRegistry();
    }

    /**
     * Performs a default analysis of the bundles such as cyclic dependencies, overlapping files,
     * missing bundles.
     */
    public void analyze() {
        bootstrap(null, null, null);
        List<BundleInfo> allBundles = BundleRegistry.getInstance().getAllBundles();
        if (allBundles.isEmpty()) {
            System.out.println("No Bundles loaded. Cannot continue.");
        } else {
            final String indent = "  ";
            final String cannotContinue = "Cannot continue.";

            System.out.println("All dependencies:");
            List<BundleInfo> roots = BundleRegistry.getInstance().getRootBundles();
            for (BundleInfo info : roots) {
                printDependencies(info, "");
            }
            
            List<BundleInfo> uiBundles = getUiBundles();
            if (!uiBundles.isEmpty()) {
                System.out.println("\nWARNING: possible UI plugins detected");
                print(uiBundles, indent);
            }

            boolean fail = printBundles(BundleRegistry.getInstance().getUnresolvedBundles(), 
                indent, "\nunresolved bundles", "Missing bundles." + cannotContinue, false);

            List<String> paths = Utils.analyzeForCyclicDependencies(allBundles);
            if (!paths.isEmpty()) {
                System.out.println("\ncyclic dependencies:");
                print(paths, indent);
                fail = true;
            }
            
            fail |= printBundles(roots, indent, "\nroot bundles:", "No root bundles. " + cannotContinue, true);
            if (!fail) {
                printDuplicateFiles(allBundles);
            }
        }
    }
    
    /**
     * Prints duplicate files in JARs.
     * 
     * @param infos the bundle information objects to be analyzed
     * @return <code>true</code> if duplicates were found, <code>false</code> else
     */
    protected boolean printDuplicateFiles(List<BundleInfo> infos) {
        Map<String, BundleInfo> names = new HashMap<String, BundleInfo>();
        boolean found = false;
        for (BundleInfo info : infos) {
            File file = info.getResolvedJar();
            if (null != file) {
                found = analyzeJarForDuplicates(info, names);
            }
        }
        return found;
    }
    
    /**
     * Analyzes the resolved Jar of <code>info</code> for duplicate files.
     * 
     * @param info the bundle information object (must have a resolved jar)
     * @param names already known name-bundle mappings (modified as a side effect)
     * @return <code>true</code> if duplicates were found, <code>false</code> else
     */
    private boolean analyzeJarForDuplicates(BundleInfo info, Map<String, BundleInfo> names) {
        boolean found = false;
        JarFile jar = null;
        try {
            jar = new JarFile(info.getResolvedJar());
            Enumeration<JarEntry> e = jar.entries();
            while (e.hasMoreElements()) {
                JarEntry entry = e.nextElement();
                if (!entry.isDirectory()) {
                    String name = entry.getName();
                    if (!irrelevantInJar(name)) {
                        BundleInfo known = names.get(name);
                        if (null != known) {
                            found = true;
                            System.out.println("duplicate entry: " + name + " in " + known.getName() 
                                + " and " + info.getName());
                        } else {
                            names.put(name, info);
                        }
                    }
                }
            }
            jar.close();
        } catch (IOException e) {
            Utils.closeQuietly(jar);
        }
        return found;
    }

    /**
     * Analyzes bundles and prints them in case of failure (i.e., <code>infos</code> is not empty).
     * 
     * @param infos the information objects to be analyzed
     * @param indent indentation of the data
     * @param headline headline to be printed
     * @param stopMessage the message to be printed in case that a failure is detected
     * @param negate negate the failure test, i.e., test for empty <code>infos</code>
     * @return <code>true</code> in case of failure, <code>false</code> else
     */
    private boolean printBundles(List<BundleInfo> infos, String indent, String headline, String stopMessage, 
        boolean negate) {
        boolean fail = !infos.isEmpty();
        if (negate) {
            fail = !fail;
        }
        if (fail) {
            System.out.println(headline);
            print(infos, indent);
            if (null != stopMessage) {
                System.out.println(stopMessage);
            }
        }
        return fail;
    }
    
    /**
     * Prints a list of data with indent.
     * 
     * @param data the data to be printed
     * @param indent the indentation
     */
    private void print(List<?> data, String indent) {
        for (Object d : data) {
            System.out.println(indent + d);
        }
    }

}
