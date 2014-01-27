package de.uni_hildesheim.sse.easy.loader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;

import de.uni_hildesheim.sse.easy.loader.framework.BundleException;
import de.uni_hildesheim.sse.easy.loader.framework.BundleInfo;
import de.uni_hildesheim.sse.easy.loader.framework.BundleRegistry;
import de.uni_hildesheim.sse.easy.loader.framework.FakeBundle;
import de.uni_hildesheim.sse.easy.loader.framework.FakeBundleContext;
import de.uni_hildesheim.sse.easy.loader.framework.FakeComponentContext;
import de.uni_hildesheim.sse.easy.loader.framework.Log;
import de.uni_hildesheim.sse.easy.loader.framework.Options;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * Provides generator factilities for static loading.
 * 
 * @author Holger Eichelberger
 */
public class Generator extends AbstractLoader {
    
    private static final Class<?>[] RUNTIME_CLASSES;
    private List<BundleInfo> data;
    private List<URL> urls;
    private Map<URL, BundleInfo> urlBundleMapping = new HashMap<URL, BundleInfo>();

    static {
        Options.setConsiderLoadedClasses(false);
        initializeRegistry();
        List<Class<?>> rtCls = new ArrayList<Class<?>>();
        addRuntimeClass(ListLoader.class, rtCls);
        addRuntimeClass(Log.class, rtCls);
        addRuntimeClass(Utils.class, rtCls);
        addRuntimeClass(BundleException.class, rtCls);
        addRuntimeClass(FakeBundle.class, rtCls);
        addRuntimeClass(FakeBundleContext.class, rtCls);
        addRuntimeClass(FakeComponentContext.class, rtCls);
        Class<?>[] tmp = new Class<?>[rtCls.size()];
        rtCls.toArray(tmp);
        RUNTIME_CLASSES = tmp;
    }
    
    /**
     * Creates the generator instance.
     * 
     * @param base the base folder
     */
    protected Generator(File base) {
        super(base);
        bootstrap();
        List<BundleInfo> roots = BundleRegistry.getInstance().getRootBundles();

        urls = new ArrayList<URL>();
        data = new ArrayList<BundleInfo>();
        Set<BundleInfo> done = new HashSet<BundleInfo>();
        Utils.sortByContainment(roots);
        for (BundleInfo info : roots) {
            collectBootstrapData(info, urls, data, done, TAG_EASY);                    
        }
        File libsDir = new File(base, "libs");
        File[] libs = libsDir.listFiles();
        if (null != libs) {
            for (File lib : libs) {
                try {
                    urls.add(lib.toURI().toURL());
                } catch (MalformedURLException e) {
                    Log.warn("malformed URL", e);
                }
            }
        }
    }

    /**
     * Adds a runtime class for being packed with the generated jars.
     * 
     * @param cls the class to be packed (including nested classes)
     * @param rtClasses the classes to be loaded (modified as a side effect)
     */
    private static void addRuntimeClass(Class<?> cls, List<Class<?>> rtClasses) {
        rtClasses.add(cls);
        Class<?>[] inner = cls.getDeclaredClasses();
        if (null != inner) {
            for (Class<?> innerCls : inner) {
                rtClasses.add(innerCls);
            }
        }
    }
    
    /**
     * Executes the generator.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        File base = new File(".");
        Generator generator = new Generator(new File("."));
        generator.generateJarFiles(new File(base, "dist"), true);
        generator.generateJarFiles(new File(base, "dist-unbundled"), false);
    }
    
    /**
     * Helper class for carrying unbundling information. To be used incrementally on each classpath URL.
     *  
     * @author Holger Eichelberger
     */
    private class UnbundleInfo {
        
        private File target;
        private String name;
        private boolean eclipsePart;
        private BundleInfo bundle;
        
        /**
         * Create an instance for bundling (not unbundling).
         */
        UnbundleInfo() {
        }
        
        /**
         * Crates an instance for unbundling to <code>target</code>.
         * 
         * @param target the target folder
         */
        UnbundleInfo(File target) {
            this.target = target;
        }
        
        /**
         * Sets the target name just as given.
         * 
         * @param name the target name
         */
        void setName(String name) {
            this.name = name;
        }
        
        /**
         * Sets the target name from the name of the <code>url</code>.
         * 
         * @param url the url to take the name from
         */
        void setName(URL url) {
            String tmp = url.toString();
            int pos = tmp.lastIndexOf('/');
            if (pos > 0) {
                name = tmp.substring(pos + 1);
            } else {
                name = "tmp.tmp";
            }
        }
        
        /**
         * Returns the target name.
         * 
         * @return the name
         */
        String getName() {
            return name;
        }
        
        /**
         * Defines the bundle information.
         * 
         * @param bundle the bundle information
         */
        void setBundleInfo(BundleInfo bundle) {
            this.bundle = bundle;
        }
        
        /**
         * Indicates that the denoted element belongs to eclipse (not to easy).
         * 
         * @param eclipsePart whether it belongs to eclipse
         */
        void setEclipsePart(boolean eclipsePart) {
            this.eclipsePart = eclipsePart;
        }
        
        /**
         * The target as file including location (based on the folder given during initialization).
         * 
         * @return the targer
         */
        File getTarget() {
            return new File(target, name);
        }
        
        /**
         * Returns whether the denoted element is a bundle.
         * 
         * @return <code>true</code> if it is a bundle, <code>false</code> else
         */
        boolean isBundle() {
            return null != bundle;
        }
        
        /**
         * Returns whether the denoted element is an eclipse part.
         * 
         * @return <code>true</code> if it is an eclipse part, <code>false</code> else
         */
        boolean isEclipsePart() {
            return eclipsePart;
        }
        
        /**
         * Returns whether this info is enabled (unbundling) or disabled (bundling).
         * 
         * @return <code>true</code> for unbundling, <code>false</code> for bundling
         */
        boolean enabled() {
            return null != target;
        }
        
    }
    
    /**
     * Generates the JAR files for static loading.
     * 
     * @param targetDir the target dire where to put the final jar files to
     * @param bundle whether libraries shall be bundled or not
     */
    protected void generateJarFiles(File targetDir, boolean bundle) {
        UnbundleInfo unbundle = bundle ? new UnbundleInfo() : new UnbundleInfo(targetDir);
        targetDir.mkdirs();
        Log.info("generating Jar files into " + targetDir.getPath());
        File easyJarFile = new File(targetDir, "easy-headless.jar");
        File eclipseJarFile = new File(targetDir, "eclipse-part.jar");
        Set<String> done = new HashSet<String>();
        JarOutputStream easyJar = null;
        JarOutputStream eclipseJar = null;
        try {
            easyJar = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(easyJarFile)));
            if (unbundle.enabled()) {
                eclipseJar = null;
            } else {
                eclipseJar = new JarOutputStream(new BufferedOutputStream(new FileOutputStream(eclipseJarFile)));
            }
            Set<String> classpathEntries = new HashSet<String>();
            for (URL url : urls) {
                String path = url.getPath();
                BundleInfo info = urlBundleMapping.get(url);
                classpathEntries.clear();
                unbundle.setBundleInfo(info);
                if (null != info) {
                    for (int c = 0; c < info.getClasspathEntryCount(); c++) {
                        String cpe = info.getClasspathEntry(c);
                        classpathEntries.add(cpe);
                        // specific rule for drools2!
                        if (cpe.startsWith("lib/slf4j") && !done.contains("libs/slf4j-simple-1.6.4.jar")) {
                            File file = new File("libs/slf4j-simple-1.6.4.jar");
                            unbundle.setName(file.getName());
                            unbundle.setBundleInfo(null); // this is not a bundle
                            InputStream is = new FileInputStream(file);
                            handleJar(is, easyJar, done, new HashSet<String>(), unbundle);
                            is.close();
                        }
                    }
                }
                InputStream is = url.openStream();
                unbundle.setEclipsePart(path.contains("/eclipse/") || path.contains("/libs/"));
                unbundle.setName(url);
                Log.info(" - processing " + path);
                if (unbundle.isEclipsePart()) {
                    handleJar(is, eclipseJar, done, classpathEntries, unbundle);
                } else {
                    handleJar(is, easyJar, done, classpathEntries, unbundle);
                }
                is.close();
            }
            Utils.closeQuietly(eclipseJar);
            Log.info("adding startup spec to " + easyJarFile);
            produceStartupList(easyJar);
            Log.info("adding loader classes to " + easyJarFile);
            addRuntimeLoaderClasses(easyJar);
            easyJar.close();
        } catch (IOException e) {
            Log.warn("I/O problem while generating Jars", e);
            Utils.closeQuietly(easyJar);
            Utils.closeQuietly(eclipseJar);
        }
    }
    
    /**
     * Copies the entries of an entire JAR in <code>is</code> to the target JAR in <code>os</code> without
     * duplicating entries. Considers {@link #irrelevantInJar(String)} in order to filter out irrelevant
     * entries.
     * 
     * @param is the input JAR as stream
     * @param os the output JAR as stream
     * @param done already processed entries to avoid duplicates
     * @param exclude JAR entries not to be added (in addition to {@link #irrelevantInJar(String)})
     * @param unbundle information about unbunding the current stream <code>is</code>
     * @throws IOException in case that reading from or writing to a JAR stream fails
     */
    private void handleJar(InputStream is, JarOutputStream os, Set<String> done, Set<String> exclude, 
        UnbundleInfo unbundle) throws IOException {
        boolean copy;
        boolean include = false;
        if (unbundle.enabled()) {
            copy = unbundle.isEclipsePart() || !unbundle.isBundle(); // remainder shall be from EASy
            if ("aspectjrt.jar".equals(unbundle.getName())) {
                include = true; // special case for aspect library
            }
        } else {
            copy = false;
        }
        if (include) {
            JarEntry osEntry = new JarEntry(unbundle.getName());
            os.putNextEntry(osEntry);
            Utils.copy(is, os);
            os.closeEntry();
        } else if (copy) {
            FileOutputStream fos = new FileOutputStream(unbundle.getTarget());
            Utils.copy(is, fos);
            fos.close();
        } else {
            JarEntry isEntry = null;
            JarInputStream jis = new JarInputStream(is);
            do {
                isEntry = jis.getNextJarEntry();
                if (null != isEntry) {
                    String name = isEntry.getName();
                    String key = name.toLowerCase();
                    if (!done.contains(key) && !irrelevantInJar(name) && !exclude.contains(name)) {
                        done.add(key);
                        JarEntry osEntry = new JarEntry(name);
                        os.putNextEntry(osEntry);
                        Utils.copy(jis, os);
                        os.closeEntry();
                    }
                }
            } while (null != isEntry);
        }
    }
    
    /**
     * Produces the JAR entry containing the EASy startup list to be read and interpreted at loading time.
     * 
     * @param os the output stream
     * @throws IOException in case of problems writing to <code>os</code>
     */
    private void produceStartupList(JarOutputStream os) throws IOException {
        JarEntry listEntry = new JarEntry(ListLoader.EASY_STARTUP_FILE_NAME);
        os.putNextEntry(listEntry);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(os));
        for (BundleInfo info : data) {
            if (null != info.getActivatorClassName()) {
                out.print(ListLoader.InitType.ACTIVATOR.name());
                out.print(":");
                out.println(info.getActivatorClassName());
            }
            // DS-methods are optional
            for (int c = 0; c < info.getDsClassesCount(); c++) {
                out.print(ListLoader.InitType.DS.name());
                out.print(":");
                out.println(info.getDsClass(c));
            }
        }
        out.flush();
        os.closeEntry();
    }
    
    /**
     * Adds the classes needed for runtime loading to <code>os</code>.
     * 
     * @param os the JAR output stream
     * @throws IOException in case that reading the class file or writing to <code>os</code> fails
     */
    private void addRuntimeLoaderClasses(JarOutputStream os) throws IOException {
        for (Class<?> rtClass : RUNTIME_CLASSES) {
            String name = rtClass.getName().replace('.', '/') + Utils.CLASS_SUFFIX;
            File file = new File(getBase(), "bin/" + name);
            if (file.exists()) {
                FileInputStream is = null;
                try {
                    JarEntry entry = new JarEntry(name);
                    os.putNextEntry(entry);
                    is = new FileInputStream(file);
                    Utils.copy(is, os);
                    os.closeEntry();
                    Utils.closeQuietly(is);
                } catch (IOException e) {
                    Utils.closeQuietly(is);
                    throw e;
                }
            } else {
                Log.warn("Class file " + name + "does not exist. Generation incomplete.");
            }
        }
    }

    @Override
    protected void notifyMapping(URL url, BundleInfo info) {
        urlBundleMapping.put(url, info);
    }

    @Override
    protected boolean irrelevantInJar(String name) {
        boolean result;
        if (name.startsWith("META-INF") && !name.equals("META-INF/MANIFEST.MF")) {
            result = false;
        } else {
            result = super.irrelevantInJar(name);
        }
        return result;
    }

}
