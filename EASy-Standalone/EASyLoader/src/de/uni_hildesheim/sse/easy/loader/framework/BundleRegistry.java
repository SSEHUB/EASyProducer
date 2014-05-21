package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * A registry of created bundle information objects supporting the resolution of bundles.
 * 
 * @author Holger Eichelberger
 */
public class BundleRegistry {
    
    private static final Set<String> IGNORE = new HashSet<String>();

    private static BundleRegistry instance = new BundleRegistry();
    
    private boolean emitIgoredWarnings = true;
    private final Map<String, List<BundleInfo>> bundles = new HashMap<String, List<BundleInfo>>();
    private BundleRegistry parent;

    /**
     * Creates the root bundle registry.
     */
    private BundleRegistry() {
    }
    
    /**
     * Creates a delegating bundle registry which asks <code>parent</code> if bundles cannot be found.
     * 
     * @param parent the parent registry
     */
    public BundleRegistry(BundleRegistry parent) {
        this.parent = parent;
    }
    
    /**
     * Adds a symbolic bundle name to the global ignore list.
     * 
     * @param name the name of the bundle (<b>null</b> will be ignored)
     */
    public static void addGlobalIgnore(String name) {
        if (null != name) {
            IGNORE.add(name);
        }
    }
    
    /**
     * Returns the current instance of this registry.
     * 
     * @return the current instance
     */
    public static BundleRegistry getInstance() {
        return instance;
    }
    
    /**
     * Redefines the current bundle registry.
     * 
     * @param registry the current registry (<b>null</b> will be ignored)
     */
    public static void setInstance(BundleRegistry registry) {
        if (null != registry) {
            instance = registry;
        }
    }
    
    /**
     * Returns whether the given bundle shall be ignored.
     * 
     * @param name the name of the bundle
     * @return <code>true</code> if it shall be ignored, <code>false</code> else
     */
    boolean ignoreBundle(String name) {
        return IGNORE.contains(name);
    }
    
    /**
     * Defines whether ignored warnings shall be emitted.
     * 
     * @param emit <code>true</code> if these warnings are emitted, <code>false</code> else
     */
    public void setEmitIgoredWarnings(boolean emit) {
        emitIgoredWarnings = emit;
    }
    
    /**
     * Adds a bundle information object to this registry.
     * 
     * @param info the information object
     */
    void add(BundleInfo info) {
        String name = info.getName();
        List<BundleInfo> sameName = getInfoSafe(name);
        if (sameName.isEmpty()) {
            sameName.add(info);
        } else {
            if (emitIgoredWarnings) {
                Log.warn("Multiple bundles with symbolic name " + name + " being registered. ("
                    + collectVersions(sameName) 
                    + ") This is currently not supported and version " + info.getVersion() + " is ignored.");
            }
            //sameName.get(0).resolve(info);
            //sameName.remove(0);
            sameName.add(info); //patrik: added these lines to add them anyways since version should be checked now!
        }
    }
    
    /**
     * Collects the version information from <code>infos</code>.
     * 
     * @param infos the information instances to be considered
     * @return the version information as String
     */
    private static String collectVersions(List<BundleInfo> infos) {
        StringBuilder tmp = new StringBuilder();
        for (BundleInfo info : infos) {
            Version version = info.getVersion();
            if (tmp.length() > 0) {
                tmp.append(", ");
            }
            if (null == version) {
                tmp.append("?");
            } else {
                tmp.append(version);
            }
        }
        return tmp.toString();
    }
    
    /**
     * Returns the list of bundles with the same <code>name</code>.
     * 
     * @param name the symbolic bundle name
     * @return the list of bundles (created and hooked in if required)
     */
    private List<BundleInfo> getInfoSafe(String name) {
        List<BundleInfo> sameName = bundles.get(name);
        if (null == sameName) {
            sameName = new ArrayList<BundleInfo>();
            bundles.put(name, sameName);
        }
        return sameName;
    }

    /**
     * Returns a bundle information instance with the specified <code>name</code>.
     * If multiple bundle versions for the same name are registered, the first is returned 
     * (version specification is currently not supported).
     * 
     * @param name the symbolic name
     * @param versionSpec the version specification (currently not considered in resolution, just stored)
     * @return the related bundle information object, resolved or unresolved or <b>null</b> if not found
     */
    public BundleInfo get(String name, EasyDependency versionSpec) {
        BundleInfo result;
        List<BundleInfo> sameName = bundles.get(name);
        if (null == sameName || sameName.isEmpty()) {
            if (null != parent) {
                result = parent.get(name, versionSpec);
                if (null != result) {
                    add(result);
                }
            } else {
                result = null;
            }
        } else {
            //versionSpec needs to be supported here!
            result = null;
            for (int i = 0; i < sameName.size(); i++) {
                if (sameName.get(i).getVersion()
                    .isInRange(versionSpec.getBundleVersionMin(), versionSpec.getBundleVersionMax())) {
                    if (null == result || result.getVersion()
                            .compareTo(sameName.get(i).getVersion()) == -1) {
                        result = sameName.get(i);
                    }
                }
            }
        
            //result = sameName.get(0);
        }
        return result;
    }

    /**
     * Returns all bundles known to this registry.
     * 
     * @return all bundles
     */
    public List<BundleInfo> getAllBundles() {
        List<BundleInfo> roots = new ArrayList<BundleInfo>();
        for (List<BundleInfo> sameName : bundles.values()) {
            for (BundleInfo info : sameName) {
                roots.add(info);
            }
        }
        return roots;
    }

    /**
     * Returns the root bundles, i.e., those without required bundles.
     * 
     * @return the root bundles (may be empty)
     */
    public List<BundleInfo> getRootBundles() {
        List<BundleInfo> roots = new ArrayList<BundleInfo>();
        Set<BundleInfo> unused = new HashSet<BundleInfo>();
        // initialize with all
        for (BundleInfo info : getAllBundles()) {
            unused.add(info);
        }
        // remove used
        for (BundleInfo info : getAllBundles()) {
            for (int p = 0; p < info.getRequiredBundlesCount(); p++) {
                unused.remove(info.getRequiredBundle(p));
            }
        }
        // now unused are roots
        for (BundleInfo info : unused) {
            roots.add(info);
        }
        return roots;
    }
    
    /**
     * Returns currently unresolved bundles, i.e., those without resolving JAR file.
     * 
     * @return the unresolved bundles (may be empty)
     */
    public List<BundleInfo> getUnresolvedBundles() {
        List<BundleInfo> roots = new ArrayList<BundleInfo>();
        for (BundleInfo info : getAllBundles()) {
            if (null == info.getResolvedJar()) {
                roots.add(info);
            }
        }
        return roots;
    }
        
}