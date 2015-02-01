package de.uni_hildesheim.sse.easy.loader;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.easy.loader.framework.BundleInfo;
import de.uni_hildesheim.sse.easy.loader.framework.BundleRegistry;
import de.uni_hildesheim.sse.easy.loader.framework.Utils;

/**
 * The standalone loader class. Basically, it emulates some very core functions of OSGi/Equinox and 
 * Eclipse Declarative Services to dynamically determine the bundle depedency hierarchy, the activators (although 
 * standalone EASy core bundles shall not have activators) and the dynamic initializers expressed as Declarative 
 * Services. Currently, due to the design of EASy, this Loader just ignores the class loader separation performed by
 * OSGi and loads all classes into the same Classloader.
 * 
 * @author Holger Eichelberger
 */
public class Loader extends AbstractLoader {

    private List<BundleInfo> data;
    private ClassLoader loader;
    
    /*private static final IBundleFilter FILTER_EASY_BUNDLES 
        = new SimpleManifestNameFilter(EASY_NAME_PATTERN);*/

    /**
     * Creates a new loader with default base ".".
     */
    public Loader() {
        this(new File("."));
    }
    
    /**
     * Creates a new loader.
     * 
     * @param base the base folder where the plugins are located in
     */
    public Loader(File base) {
        super(base);
    }
    
    /**
     * Starts the loader for testing.
     * 
     * @param args ignored
     */
    public static void main(String[] args) {
        Loader loader = new Loader();
        loader.bootstrap(null);
        loader.shutdown();
    }
    
    static {
        initializeRegistry();
    }
    
    /**
     * Bootstraps EASy.
     * 
     * @param jarToExecute an optional URL containing executable code
     */
    public void bootstrap(URL jarToExecute) {
        bootstrap(null, null, null);
        List<BundleInfo> roots = BundleRegistry.getInstance().getRootBundles();

        List<URL> urls = new ArrayList<URL>();
        data = new ArrayList<BundleInfo>();
        Set<BundleInfo> done = new HashSet<BundleInfo>();
        Utils.sortByContainment(roots);
        for (BundleInfo info : roots) {
            collectBootstrapData(info, urls, data, done, TAG_EASY);                    
        }
        if (null != jarToExecute) {
            urls.add(jarToExecute);
        }
        //printBootstrapData(urls, data);
        loadAndInitialize(urls, data);
    }

    /**
     * Executes a user command.
     * 
     * @param arg the argument for the command.
     * @throws CommandExecutionException in case that execution fails
     */
    public void executeCommand(String arg) throws CommandExecutionException {
        try {
            Class<?> cls = loader.loadClass("Command");
            Method method = cls.getDeclaredMethod("execute", String.class);
            method.invoke(null, arg);
        } catch (ClassNotFoundException e) {
            throw new CommandExecutionException(e);
        } catch (NoSuchMethodException e) {
            throw new CommandExecutionException(e);
        } catch (InvocationTargetException e) {
            throw new CommandExecutionException(e);
        } catch (IllegalAccessException e) {
            throw new CommandExecutionException(e);
        }
    }
    
    /**
     * Loads and initializes the bundles.
     * 
     * @param urls the URLs of the jars to be turned into a class loader
     * @param infos the bundles to be initialized
     * @return the class loader if successful, <b>null</b> else
     */
    public ClassLoader loadAndInitialize(List<URL> urls, List<BundleInfo> infos) {
        if (!urls.isEmpty()) {
            loader = new URLClassLoader(Utils.toArray(urls));
            for (int i = 0; i < infos.size(); i++) {
                BundleInfo info = infos.get(i);
                System.out.println("activating " + info.getName() + " " + info.getTag());
                if (null != info.getActivatorClassName()) {
                    Utils.startBundle(loader, info.getActivatorClassName());
                }
                // DS-methods are optional
                for (int c = 0; c < info.getDsClassesCount(); c++) {
                    Utils.activateDsInstance(loader, info.getDsClass(c));
                }
                info.setClassloader(loader);
            }
        } else {
            loader = getClass().getClassLoader();
        }
        return loader;
    }
    
    /**
     * Performs a shutdown.
     */
    public void shutdown() {
        if (null != loader && null != data) {
            boolean successful = true;
            for (int i = 0; successful && i < data.size(); i++) {
                BundleInfo info = data.get(i);
                ClassLoader loader = info.getClassloader();
                if (null != loader) {
                    System.out.println("shutting down " + info.getName() + " " + info.getTag());
                    for (int c = 0; c < info.getDsClassesCount(); c++) {
                        Utils.deactivateDsInstance(loader, info.getDsClass(c));
                    }
                    // DS-methods are optional
                    if (null != info.getActivatorClassName()) {
                        Utils.stopBundle(loader, info.getActivatorClassName());
                    }
                }
            }
        }
    }
    
    /**
     * Prints the bootstrap data.
     * 
     * @param urls the jar files to load (modified as a side effect)
     * @param instantiate the bundles to instantiate, either via activator or DS (modified as a side effect)
     */
    @SuppressWarnings("unused")
    private void printBootstrapData(List<URL> urls, List<BundleInfo> instantiate) {
        System.out.println("\nClasspath:");
        for (URL url : urls) {
            System.out.println("  " + url);
        }
        System.out.print("\nInstantiate");
        System.out.println(":");
        for (BundleInfo data : instantiate) {
            System.out.println("  bundle: " + data.getName());
            if (null != data.getActivatorClassName()) {
                System.out.println("    activator: " + data.getActivatorClassName());
            }
            if (data.getDsClassesCount() > 0) {
                System.out.println("    DS: ");
                for (int d = 0; d < data.getDsClassesCount(); d++) {
                    System.out.println("      " + data.getDsClass(d));
                }
            }
        }
    }

    
}