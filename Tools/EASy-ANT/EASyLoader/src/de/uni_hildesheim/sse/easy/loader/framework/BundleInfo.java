package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


/**
 * Maintains information about an OSGi bundle. In addition, bundle information object support tagging,
 * i.e., additional information such as a loading stage may be attached and retrieved.
 * 
 * @author Holger Eichelberger
 */
public class BundleInfo {

    private static final DocumentBuilderFactory XML_FACTORY = DocumentBuilderFactory.newInstance();
    
    private File resolved;
    private String name;
    private boolean singleton;
    private Version version;
    private String activator;
    private String activationPolicy;
    private String dsSpec;
    private String[] dsClasses;
    private BundleInfo[] requiredBundles;
    @SuppressWarnings("unused")
    private String[] importPackages;
    @SuppressWarnings("unused")
    private String[] exportPackages;
    private Object tag;
    private String sampleClass;
    private ClassLoader loader;
    private boolean doBundleClassPath;
    private String[] classpath;
    private String[] origClasspath;

    /**
     * Creates a bundle information object from a given JAR <code>manifest</code>.
     * Please note that the DS specification must be loaded via {@link #parseDsSpec(InputStream)}.
     * 
     * @param file the JAR file resolving this bundle
     * @param manifest the JAR manifest to analyze
     * @throws BundleException if a non-OSGi manifest shall be analyzed, i.e., information in missing (or if the 
     *     bundle shall be ignored, see {@link BundleException#dueTognored()})
     */
    private BundleInfo(File file, Manifest manifest) throws BundleException {
        resolve(file, manifest);
        BundleRegistry.getInstance().add(this);
    }

    /**
     * Creates an unresolved bundle information object from the given symbolic <code>name</code>.
     * 
     * @param name the name of the bundle
     * @param versionRestriction the version restriction specification
     * @throws BundleException in case that the name is illegal (or if the bundle shall be ignored, 
     *     see {@link BundleException#dueTognored()})
     */
    private BundleInfo(String name, EasyDependency versionRestriction) throws BundleException {
        if (null == name || 0 == name.length()) {
            throw new BundleException("no symbolic name given");
        }
        this.name = name;
        resolved = null;
        BundleRegistry.getInstance().add(this);
        // we omit the version restrictions and assume that proper bundles are given
    }
    
    /**
     * Creates an bundle information instance. Successfully created 
     * instances are automatically registered in the {@link BundleRegistry}.
     * 
     * @param name the name of the bundle
     * @param versionSpec the version or version specification to be fulfilled
     * @return the corresponding bundle information object (or <b>null</b>)
     * @throws BundleException in case that relevant information is missing
     */
    public static BundleInfo createInstance(String name, EasyDependency versionSpec) throws BundleException {
        BundleInfo info = null;
        if (!BundleRegistry.getInstance().ignoreBundle(name)) {
            info = BundleRegistry.getInstance().get(name, versionSpec);
            if (null == info) {
                info = new BundleInfo(name, versionSpec);
            }
        }
        return info;
    }

    /**
     * Creates an bundle information instance from a JAR file. Successfully created 
     * instances are automatically registered in the {@link BundleRegistry}.
     * 
     * @param file the file to be analyzed
     * @return the corresponding bundle information object (or <b>null</b>)
     * @throws BundleException in case that reading the bundle manifest fails
     */
    public static BundleInfo createInstance(File file) throws BundleException {
        BundleInfo info = null;
        JarFile jarFile = null;
        InputStream is = null;
        EasyDependency dependancy = new EasyDependency();
        try {
            jarFile = new JarFile(file);
            Manifest mf = jarFile.getManifest();
            Attributes attributes = getAttributes(mf);
            String name = parseSymbolicName(attributes);
            if (!BundleRegistry.getInstance().ignoreBundle(name)) {
                Version version = parseVersion(attributes);
                dependancy.setBundleVersionMin(version);
                info = BundleRegistry.getInstance().get(name, dependancy);
                if (null == info) {
                    info = new BundleInfo(file, mf);
                } else { // TODO this is very strange <-> factory
                    info = new BundleInfo(file, mf);
                    //info.resolve(file, mf);
                }
                if (null != info.getDsSpec()) {
                    ZipEntry entry = jarFile.getEntry(info.getDsSpec());
                    if (null != entry) {
                        is = jarFile.getInputStream(entry);
                        info.parseDsSpec(is);
                        is.close();
                        is = null;
                    }
                }
                if (null == info.getSampleClass()) {
                    info.setSampleClass(getSampleClass(jarFile));
                }
            }
            jarFile.close();
        } catch (IOException e) {
            Utils.closeQuietly(is);
            Utils.closeQuietly(jarFile);
            throw new BundleException(e.getMessage());
        } catch (BundleException e) {
            Utils.closeQuietly(is);
            Utils.closeQuietly(jarFile);
            throw e;
        }
        return info;
    }
    
    /**
     * Returns the name of a representative class in the given JAR file.
     * 
     * @param jarFile the JAR file
     * @return the name of the representative class (just the first identified one)
     */
    public static String getSampleClass(JarFile jarFile) {
        String result = null;
        if (Options.considerLoadedClasses()) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (null == result && entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                if (name.length() > Utils.CLASS_SUFFIX.length() && name.endsWith(Utils.CLASS_SUFFIX) 
                    && !name.endsWith("package-info.class")) {
                    result = name.substring(0, name.length() - Utils.CLASS_SUFFIX.length()).replace('/', '.');
                }
            }
        }
        return result;
    }
    
    /**
     * Returns the attributes of the manifest to be considered.
     * 
     * @param manifest the manifest to be analyzed
     * @return the attributes to be considered
     */
    static Attributes getAttributes(Manifest manifest) {
        return manifest.getMainAttributes();
    }

    /**
     * Parses the bundle version from the <code>attributes</code>.
     * 
     * @param attributes the attributes to parse from
     * @return the bundle version or <b>null</b> if none is given
     * @throws BundleException in case that the version number cannot be parsed
     */
    static Version parseVersion(Attributes attributes) throws BundleException {
        Version result;
        String tmp = attributes.getValue("Bundle-Version");
        if (null == tmp) {
            result = new Version("0");
        } else {
            result = new Version(tmp);
        }
        return result;
    }

    /**
     * Parses a package list from the given Manifest attributes.
     * 
     * @param attributes the attributes to be considered
     * @param key the attribute key
     * @return the parsed package list, may be <b>null</b>
     */
    private static String[] parsePackageList(Attributes attributes, String key) {
        String[] result = null;
        String tmp = attributes.getValue(key);
        if (null != tmp) {
            result = tmp.split("\\s*,\\s*");
            if (null != result && 0 == result.length) {
                result = null;
            }
        }
        return result;
    }
    
    /**
     * Parses the bundle classpath.
     * @param attributes the attributes to be considered
     * @return the bundle classpath (may be <b>null</b>)
     */
    private static String[] parseClasspath(Attributes attributes) {
        List<String> res = new ArrayList<String>();
        String tmp = attributes.getValue("Bundle-ClassPath");
        if (null != tmp) {
            String[] tmpCp = tmp.split("\\s*,\\s*");
            for (int t = 0; t < tmpCp.length; t++) {
                if (!tmpCp[t].equals(".") && !tmpCp[t].equals("lib/")) {
                    res.add(tmpCp[t]);
                }
            }
        }
        String[] result;
        if (res.isEmpty()) {
            result = null;
        } else {
            result = new String[res.size()];
            res.toArray(result);
        }
        return result;
    }
    
    /**
     * Splits a bundle list specificiation into bundle names with version information etc.
     * 
     * @param text the text to be splitted
     * @return the bundle lists
     */
    private List<String> splitBundleList(String text) {
        List<String> tmp = new ArrayList<String>();
        int pos = 0;
        int lastCut = 0;
        boolean inQuote = false;
        while (pos < text.length()) {
            char c = text.charAt(pos);
            if ('"' == c) {
                inQuote = !inQuote;
            } else if (',' == c) {
                if (!inQuote) {
                    tmp.add(text.substring(lastCut, pos));
                    lastCut = pos + 1;
                }
            }
            pos++;
        }
        if (lastCut != text.length()) {
            tmp.add(text.substring(lastCut, text.length()));
        }
        return tmp;
    }
    
    /**
     * Parses a bundle list from <code>attributes</code>.
     * 
     * @param attributes the attributes to be considered
     * @param key the attribute key
     * @return the parsed bundle list, may be <b>null</b>
     * @throws BundleException in case that the bundle information object cannot be created due to missing or 
     *     illegal information
     */
    private BundleInfo[] parseBundleList(Attributes attributes, String key) throws BundleException {
        BundleInfo[] result = null;
        String tmp = attributes.getValue(key);
        if (null != tmp) {
            List<String> bundles = splitBundleList(tmp);
            if (null != bundles && bundles.size() > 0) {
                List<BundleInfo> tmpResult = new ArrayList<BundleInfo>();
                for (int i = 0; i < bundles.size(); i++) {
                    String bundle = bundles.get(i);
                    String name = null;
                    EasyDependency versionSpec = new EasyDependency("bundle-symbolic-name:=" + bundle);
                    int pos = bundle.indexOf(";");
                    if (pos > 0) {
                        name = bundle.substring(0, pos);
                    } else {
                        name = bundle;
                    }
                    boolean optional = false;
                    if (null != versionSpec) {
                        optional = !versionSpec.getMandatory();
                    }
                    if (!optional) {
                        BundleInfo info = createInstance(name, versionSpec);
                        if (null != info) {
                            tmpResult.add(info);
                        }
                    }
                }
                result = new BundleInfo[tmpResult.size()];
                tmpResult.toArray(result);
            } 
        }
        return result;
    }
    
    /**
     * Parses the symbolic name and the singleton attribute.
     * 
     * @param attributes the Manifest attributes to be analyzed
     * @return the symbolic name
     * @throws BundleException in case that the analysis fails, in particular if no symbolic name is given
     */
    static String parseSymbolicName(Attributes attributes) throws BundleException {
        String tmp = attributes.getValue("Bundle-SymbolicName");
        if (null == tmp) {
            throw new BundleException("no symbolic name given");
        }
        int pos = tmp.indexOf(";");
        if (pos > 0) {
            tmp = tmp.substring(0, pos);
        } 
        return tmp;
    }
    
    /**
     * Parses the attributes whether the current bundle is a singleton.
     * 
     * @param attributes the Manifest attributes to be analyzed
     * @param 
     * @return <code>true</code> if this bundle is a singleton, <code>false</code> else
     * @throws BundleException in case that the analysis fails, in particular if no symbolic name is given
     */
    private static boolean parseSingleton(Attributes attributes) throws BundleException {
        String tmp = attributes.getValue("Bundle-SymbolicName");
        if (null == tmp) {
            throw new BundleException("no symbolic name given");
        }
        String symName = parseSymbolicName(attributes);
        boolean singleton = false;
        if (tmp.length() > symName.length() + 1) {
            singleton = tmp.substring(symName.length() + 1).matches(".*singleton\\s*:=\\s*(\"?)true(\"?).*");
        }
        return singleton;
    }
    
    /**
     * Returns the symbolic name of the bundle.
     * 
     * @return the symbolic name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns whether the represented bundle is a singleton.
     * 
     * @return <code>true</code> if it is a singleton, <code>false</code> else
     */
    public boolean isSingleton() {
        return singleton;
    }
    
    /**
     * Returns the version of the represented bundle.
     * 
     * @return the version, may be <b>null</b>
     */
    public Version getVersion() {
        return version;
    }
    
    /**
     * Returns the activator class name.
     * 
     * @return the class name of the activator, may be <b>null</b> if not present
     */
    public String getActivatorClassName() {
        return activator;
    }
    
    /**
     * Returns the activation policy.
     * 
     * @return the activation policy, may be <b>null</b> if not stated
     */
    public String getActivationPolicy() {
        return activationPolicy;
    }
    
    /**
     * Returns the path to the DS specification within the JAR file.
     * 
     * @return the path to the DS specification, may be <b>null</b> if not present
     */
    public String getDsSpec() {
        return dsSpec;
    }
    
    /**
     * Returns the underlying JAR file.
     * 
     * @return the underlying JAR file if this bundle is actually resolved, <b>null</b> else
     */
    public File getResolvedJar() {
        return resolved;
    }
    
    /**
     * Tags this bundle information object with an arbitrary tag object.
     * 
     * @param tag the tag (may be <b>null</b>)
     */
    public void tag(Object tag) {
        this.tag = tag;
    }

    /**
     * Returns the tag of this bundle information object.
     * 
     * @return the tag (may be <b>null</b>)
     */
    public Object getTag() {
        return tag;
    }
    
    /**
     * Returns the class loader being responsible for loading this bundle.
     * 
     * @param loader the responsible class loader
     */
    public void setClassloader(ClassLoader loader) {
        this.loader = loader;
    }

    /**
     * Returns the responsible class loader.
     * 
     * @return the class loader (may be <b>null</b>)
     */
    public ClassLoader getClassloader() {
        return loader;
    }


    /**
     * Resolves this bundle.
     * 
     * @param file the JAR file resolving this bundle
     * @param manifest the manifest containing the bundle information
     * @throws BundleException in case that analyzing the manifest fails
     */
    public void resolve(File file, Manifest manifest) throws BundleException {
        // this overwrites the information including the version - ok for our case but far from being correct in OSGi
        if (null == resolved) {
            resolved = file;
            Attributes attributes = getAttributes(manifest);
            name = parseSymbolicName(attributes);
            singleton = parseSingleton(attributes);
            version = parseVersion(attributes);
            activator = attributes.getValue("Bundle-Activator");
            activationPolicy = attributes.getValue("Bundle-ActivationPolicy");
            importPackages = parsePackageList(attributes, "Import-Package");
            exportPackages = parsePackageList(attributes, "Export-Package");
            requiredBundles = parseBundleList(attributes, "Require-Bundle");
            dsSpec = attributes.getValue("Service-Component");
            doBundleClassPath = parseDoBundleClassPath(attributes); 
            origClasspath = parseClasspath(attributes);
            if (!doBundleClassPath) {
                classpath = null;
            } else {
                classpath = origClasspath;
            }
        }
    }
    
    /**
     * Returns those paths in the bundle that shall be excluded from a Jar.
     * 
     * @return the paths to be excluded, <b>null</b> if all shall be included
     */
    public Set<String> excludeFromJar() {
        Set<String> result = null;
        if (!doBundleClassPath && null != origClasspath) {
            result = new HashSet<String>();
            for (String path : origClasspath) {
                result.add(path);
            }
        }
        return result;
    }
    
    /**
     * Parses the the EASy-specific flag whether the class path shall be bundled.
     * 
     * @param attributes the attributes
     * @return <code>true</code> if the classpath shall be bundled
     */
    private static boolean parseDoBundleClassPath(Attributes attributes) {
        String tmp = attributes.getValue("EASyLoader-BundleClassPath");
        return (null == tmp || Boolean.valueOf(tmp));
    }
    
    /**
     * Returns the number of bundles required by this bundle.
     * 
     * @return the number of required bundles
     */
    public int getRequiredBundlesCount() {
        return null == requiredBundles ? 0 : requiredBundles.length;
    }
    
    /**
     * Returns the specified required bundle.
     * 
     * @param index the 0-based index of the required bundle
     * @return the specified bundle
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getRequiredBundlesCount()}</code>
     */
    public BundleInfo getRequiredBundle(int index) {
        if (null == requiredBundles) {
            throw new IndexOutOfBoundsException();
        }
        return requiredBundles[index];
    }
    
    /**
     * Returns the number of DS classes to be loaded by this bundle.
     * 
     * @return the number of required bundles
     */
    public int getDsClassesCount() {
        return null == dsClasses ? 0 : dsClasses.length;
    }
    
    /**
     * Returns the specified DS class.
     * 
     * @param index the 0-based index of the required bundle
     * @return the specified DS class name
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getDsClassesCount()}</code>
     */
    public String getDsClass(int index) {
        if (null == dsClasses) {
            throw new IndexOutOfBoundsException();
        }
        return dsClasses[index];
    }
    
    /**
     * Returns the number of classpath entries in this bundle.
     * 
     * @return the number of classpath entries
     */
    public int getClasspathEntryCount() {
        return null == classpath ? 0 : classpath.length;
    }
    
    /**
     * Returns the specified classpath entry.
     * 
     * @param index the 0-based index of the required bundle
     * @return the specified classpath entry
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getClasspathEntryCount()}</code>
     */
    public String getClasspathEntry(int index) {
        if (null == classpath) {
            throw new IndexOutOfBoundsException();
        }
        return classpath[index];
    }

    
    /**
     * Returns (a copy of) the DS class names.
     * 
     * @return the DS class names (may be <b>null</b>)
     */
    public String[] getDsClasses() {
        return dsClasses == null ? null : dsClasses.clone();
    }
    
    /**
     * Parses a DS specification into class names to be loaded and instantiated. Currently,
     * we ignore the more sophisticated capabilities of DS and rely on the implementation element only.
     * 
     * @param is the input stream to load (will not be closed by this method)
     * @throws IOException in case that loading or parsing fails
     */
    void parseDsSpec(InputStream is) throws IOException {
        List<String> tmp = new ArrayList<String>();
        try {
            DocumentBuilder builder = XML_FACTORY.newDocumentBuilder();
            Document doc = builder.parse(is);
            NodeList nodes = doc.getElementsByTagName("implementation");
            for (int n = 0; n < nodes.getLength(); n++) {
                Node node = nodes.item(n);
                Node className = node.getAttributes().getNamedItem("class");
                if (null != className) {
                    String value = className.getNodeValue();
                    if (null != value) {
                        tmp.add(value);
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            LoaderLog.writeLn(e.getMessage());
            throw new IOException(e);
        } catch (SAXException e) {
            LoaderLog.writeLn(e.getMessage());
            throw new IOException(e);
        }
        if (!tmp.isEmpty()) {
            dsClasses = new String[tmp.size()];
            tmp.toArray(dsClasses);
        }
    }

    /**
     * Analyzes this bundle for cyclic dependencies.
     * 
     * @return messages pointing to cyclic dependencies
     */
    public List<String> analyzeForCyclicDependencies() {
        List<String> messages = new ArrayList<String>();
        Set<BundleInfo> known = new HashSet<BundleInfo>();
        analyzeForCyclicDependencies(known, messages, "");
        return messages;
    }

    /**
     * Analyzes this bundle for cyclic dependencies.
     * 
     * @param known already visited and known bundles
     * @param messages messages collected so far
     * @param path the dependency path to this bundle visited so far
     */
    private void analyzeForCyclicDependencies(Set<BundleInfo> known, List<String> messages, String path) {
        if (path.length() > 0) {
            path += " -> ";
        }
        path += toString();
        if (known.contains(this)) {
            messages.add(path);
        } else {
            known.add(this);
            if (null != requiredBundles) {
                for (BundleInfo info : requiredBundles) {
                    info.analyzeForCyclicDependencies(known, messages, path);
                }
            }
            known.remove(this);
        }
    }
    
    /**
     * Returns the sample class of this bundle.
     * 
     * @return the sample class, i.e., one of the classes defined by this bundle (may be <b>null</b>)
     */
    public String getSampleClass() {
        return sampleClass;
    }
    
    /**
     * Changes the sample class.
     * 
     * @param sampleClass the new sample class
     */
    private void setSampleClass(String sampleClass) {
        this.sampleClass = sampleClass;
    }

    @Override
    public String toString() {
        String result = getName();
        if (null != version) {
            result += " " + version;
        }
        return result;
    }

}
