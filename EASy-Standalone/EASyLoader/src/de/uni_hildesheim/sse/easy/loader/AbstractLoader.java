package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import de.uni_hildesheim.sse.easy.loader.framework.BundleInfo;
import de.uni_hildesheim.sse.easy.loader.framework.BundleRegistry;
import de.uni_hildesheim.sse.easy.loader.framework.Log;
import de.uni_hildesheim.sse.easy.loader.framework.NegatingFilter;
import de.uni_hildesheim.sse.easy.loader.framework.Options;
import de.uni_hildesheim.sse.easy.loader.framework.SimpleManifestNameFilter;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Provides common functionality for an EASy loader.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractLoader {

    protected static final String TAG_EASY = "EASy-Producer";
    protected static final String EASY_EXCLUSION_PATTERN = ".*\\.uni[-_]hildesheim\\.sse.*";
    protected static final String EASY_INCLUSION_PATTERN = ".*\\.uni[-_]hildesheim\\.sse([^u][^i])*";
    
    private File base;

    /**
     * Creates a new abstract loader.
     * 
     * @param base the base folder where the plugins are located in
     */
    protected AbstractLoader(File base) {
        this.base = base;
    }
    
    /**
     * Initializes the {@link BundleRegistry}.
     */
    protected static void initializeRegistry() {
        BundleRegistry.getInstance().setEmitIgoredWarnings(false);
        // core emulated by the loader, required classes are loaded as libraries rather than bundles
        BundleRegistry.addGlobalIgnore("org.eclipse.osgi");
        BundleRegistry.addGlobalIgnore("org.eclipse.equinox.ds");
        BundleRegistry.addGlobalIgnore("org.eclipse.equinox.launcher");
        BundleRegistry.addGlobalIgnore("org.eclipse.osgi.services");
        BundleRegistry.addGlobalIgnore("org.eclipse.equinox.common");
        BundleRegistry.addGlobalIgnore("org.eclipse.equinox.preferences");
        BundleRegistry.addGlobalIgnore("org.eclipse.equinox.registry");
        // not needed for running the languages
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.mwe2.launch");
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.mwe2.lib");
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.mwe.core");
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.mwe.utils");
        BundleRegistry.addGlobalIgnore("org.eclipse.xtext.generator");
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.codegen");
        BundleRegistry.addGlobalIgnore("org.eclipse.emf.codegen.ecore");
    }

    /**
     * Bootstraps EASy using the default bootstrap method.
     */
    protected void bootstrap() {
        simpleBootstrap();
    }
    
    /**
     * Does bootstrapping having bundles in local folders.
     */
    protected void simpleBootstrap() {
        Utils.loadBundles(Utils.findJars(new File(base, "plugins")), null, TAG_EASY);
        Utils.loadBundles(Utils.findJars(new File(base, "plugins/eclipse")), null, null);
    }
    
    /**
     * Generic bootstrapping from eclipse.
     */
    protected void genericBootstrap() {
        // consider unpacked
        File eclipsePlugins = new File("W:\\eclipse37\\easy\\Eclipse\\plugins");
        List<File> recentEclipseBundles = Utils.findRecentBundles(eclipsePlugins);
        Utils.loadBundles(recentEclipseBundles, 
            new NegatingFilter(new SimpleManifestNameFilter(EASY_EXCLUSION_PATTERN)), null);
        BundleRegistry.setInstance(new BundleRegistry(BundleRegistry.getInstance()));
        Utils.loadBundles(recentEclipseBundles, new SimpleManifestNameFilter(EASY_INCLUSION_PATTERN), null);
    }

    /**
     * Recursively prints the dependencies of <code>info</code>.
     * 
     * @param info the object to print the dependencies for
     * @param indent the current indentation
     */
    protected void printDependencies(BundleInfo info, String indent) {
        System.out.println(indent + info);
        for (int r = 0; r < info.getRequiredBundlesCount(); r++) {
            printDependencies(info.getRequiredBundle(r), indent + "  ");
        }
    }

    /**
     * Returns possible UI bundles.
     * 
     * @return the possible ui bundles (may be empty)
     */
    protected static List<BundleInfo> getUiBundles() {
        List<BundleInfo> ui = new ArrayList<BundleInfo>();
        for (BundleInfo info : BundleRegistry.getInstance().getAllBundles()) {
            String name = info.getName().toLowerCase();
            if (name.endsWith(".ui") || name.contains(".ui.")) {
                ui.add(info);
            }
        }
        return ui;
    }

    /**
     * Collect the bootstrap data.
     * 
     * @param info the bundle information object to consider
     * @param urls the jar files to load (modified as a side effect)
     * @param instantiate the bundles to instantiate, either via activator or DS (modified as a side effect)
     * @param done the already considered bundles (modified as a side effect)
     * @param tag an optional bundle tag for filtering relevant bundles (may be <b>null</b>)
     */
    protected void collectBootstrapData(BundleInfo info, List<URL> urls, List<BundleInfo> instantiate, 
        Set<BundleInfo> done, Object tag) {
        if (!done.contains(info)) {
            for (int r = 0; r < info.getRequiredBundlesCount(); r++) {
                collectBootstrapData(info.getRequiredBundle(r), urls, instantiate, done, tag);
            }
            if (!done.contains(info)) {
                done.add(info);
                collectBootstrapData(info, urls, instantiate, tag);
            }
        }
    }

    /**
     * Collect the bootstrap data for <code>info</code>. This method is called by 
     * {@link #collectBootstrapData(BundleInfo, List, List, Set, Object)}.
     * 
     * @param info the bundle information object to consider
     * @param urls the jar files to load (modified as a side effect)
     * @param instantiate the bundles to instantiate, either via activator or DS (modified as a side effect)
     * @param tag an optional bundle tag for filtering relevant bundles (may be <b>null</b>)
     */
    private void collectBootstrapData(BundleInfo info, List<URL> urls, List<BundleInfo> instantiate, Object tag) {
        File resolved = info.getResolvedJar();
        if (null != resolved) {
            try {
                if (alreadyKnownToClassLoader(info)) {
                    info.setClassloader(getClass().getClassLoader());
                } else {
                    URL url = resolved.toURI().toURL();
                    urls.add(url);
                    notifyMapping(url, info);
                    handleBundleClasspath(info, urls);
                    if (considerForBootstrap(info, tag)) {
                        instantiate.add(info);
                    }
                }
            } catch (MalformedURLException e) {
                Log.error("cannot determine URL: " + e.getMessage());
            }
        }
    }
    
    /**
     * Is called by {@link #collectBootstrapData(BundleInfo, List, List, Object)} to notify about
     * mapping a URL to the given bundle <code>info</code>.
     * 
     * @param url the URL of the bundle JAR
     * @param info the related bundle information object
     */
    protected void notifyMapping(URL url, BundleInfo info) {
    }
    
    /**
     * Returns whether the given bundle is already known to the class loader. This
     * method relies on {@link BundleInfo#getSampleClass()}.
     * 
     * @param info the info to be tested
     * @return <code>true</code> if the bundle is already known, <code>false</code> else
     */
    private static boolean alreadyKnownToClassLoader(BundleInfo info) {
        return alreadyKnownToClassLoader(info.getSampleClass());
    }

    /**
     * Returns whether the given (sample) class is already known to the class loader. 
     * 
     * @param sampleClass the sample class to be tested
     * @return <code>true</code> if the bundle is already known, <code>false</code> else
     */
    private static boolean alreadyKnownToClassLoader(String sampleClass) {
        boolean result = false;
        if (Options.considerLoadedClasses()) {
            if (null != sampleClass) {
                try {
                    Class.forName(sampleClass);
                    result = true;
                } catch (ClassNotFoundException e) {
                    // ignore
                }
            }
        }
        return result;
    }

    /**
     * Returns whether the given (JAR) file is already known to the class loader. 
     * 
     * @param file the JAR file to be tested
     * @return <code>true</code> if the bundle is already known, <code>false</code> else
     */
    private static boolean alreadyKnownToClassLoader(File file) {
        boolean result = false;
        if (Options.considerLoadedClasses()) {
            JarFile libJar = null;
            try {
                libJar = new JarFile(file);
                String sampleClass = BundleInfo.getSampleClass(libJar);
                libJar.close();
                result = alreadyKnownToClassLoader(sampleClass);
            } catch (IOException e) {
                Utils.closeQuietly(libJar);
            }
        }
        return result;
    }

    /**
     * Handles the classpath of the given bundle.
     * 
     * @param info the bundle information object
     * @param urls the URLs (to be modified as a side effect)
     * @throws MalformedURLException in case that the URL cannot be created
     */
    private void handleBundleClasspath(BundleInfo info, List<URL> urls) throws MalformedURLException {
        if (info.getClasspathEntryCount() > 0) {
            JarFile jarFile = null;
            try {
                jarFile = new JarFile(info.getResolvedJar());
                for (int c = 0; c < info.getClasspathEntryCount(); c++) {
                    String cp = info.getClasspathEntry(c);
                    JarEntry entry = jarFile.getJarEntry(cp);
                    if (null != entry && entry.getName().endsWith(".jar")) {
                        String libName = entry.getName();
                        File file = Utils.createTempFile(libName);
                        file.deleteOnExit();
                        Utils.jarEntryToFile(jarFile, entry, file);
                        if (!alreadyKnownToClassLoader(file)) {
                            urls.add(file.toURI().toURL());
                        }
                    } else {
                        Log.warn("cannot expand jar entry " + cp + " for class loading: ");
                    }
                }
                jarFile.close();
            } catch (IOException e) {
                Utils.closeQuietly(jarFile);
                Log.warn("cannot expand jar file for class loading: ", e);
            }
        }
        /*
        URL resolvedUrl = info.getResolvedJar().toURI().toURL(); 
        for (int c = 0; c < info.getClasspathEntryCount(); c++) {
            urls.add(new URL(JarClassLoader.JAR_PROTOCOL_NAME, "", resolvedUrl + "!/" + info.getClasspathEntry(c)));
        }*/
    }
    
    /**
     * Returns whether the given bundle shall be considered for the bootstrap process.
     * 
     * @param info the bundle information object
     * @param tag the optional tag (may be <b>null</b>)
     * @return <code>true</code> if <code>info</code> shall be considered, <code>false</code> else
     */
    private static boolean considerForBootstrap(BundleInfo info, Object tag) {
        boolean result = false;
        if (null != info.getActivatorClassName() || info.getDsClassesCount() > 0) {
            if (null == tag || tag.equals(info.getTag())) {
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Returns whether the name of a certain JAR entry is irrelevant for a standalone execution.
     * 
     * @param name the name
     * @return <code>true</code> if the name (and potential overlapping names) is irrelevant, 
     *     <code>false</code> if relevant
     */
    protected boolean irrelevantInJar(String name) {
        boolean irrelevant = name.startsWith("META-INF") || name.startsWith("OSGI-INF");
        irrelevant |= name.startsWith("about_file") || name.startsWith("about.");
        irrelevant |= name.startsWith(".api_description");
        irrelevant |= name.equals("plugin.properties") || name.equals(".options"); // eclipse
        irrelevant |= name.equals("javadoc.zip") || name.equals("src.zip"); // external interfaces
        irrelevant |= name.endsWith(".html") || name.endsWith(".png"); 
        irrelevant |= name.endsWith("plugin.xml"); 
        irrelevant |= name.endsWith("package-info.class"); 
        return irrelevant;
    }
    
    /**
     * Returns the base folder.
     * 
     * @return the base folder
     */
    protected File getBase() {
        return base;
    }

}
