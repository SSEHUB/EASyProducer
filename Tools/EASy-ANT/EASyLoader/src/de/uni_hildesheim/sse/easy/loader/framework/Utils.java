package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * Some basic utility functions. Some may be present in existing libraries,
 * but we aim at avoiding the use of libraries in this loader in order to
 * avoid class loading conflicts.
 * 
 * @author Holger Eichelberger
 */
public class Utils {

    public static final String CLASS_SUFFIX = ".class";
    private static final String TEXT_CANNOT_INITIALIZE = "Cannot initialize";
    private static File temp;

    /**
     * Prevents external creation.
     */
    private Utils() {
    }

    /**
     * Closes the given JAR file without throwing an exception.
     * 
     * @param file the JAR file to be closed, may be <b>null</b>
     */
    public static void closeQuietly(JarFile file) {
        if (null != file) {
            try {
                file.close();
            } catch (IOException e) {
            }
        }
    }
    
    /**
     * Closes the given input stream without throwing an exception.
     * 
     * @param is the input stream to be closed, may be <b>null</b>
     */
    public static void closeQuietly(InputStream is) {
        if (null != is) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
    
    /**
     * Closes the given output stream without throwing an exception.
     * 
     * @param os the output stream to be closed, may be <b>null</b>
     */
    public static void closeQuietly(OutputStream os) {
        if (null != os) {
            try {
                os.close();
            } catch (IOException e) {
            }
        }
    }
    
    /**
     * Turns a list of URLs into an array of URLS.
     * 
     * @param urls the URLs to be turned into an array
     * @return the related URL array
     */
    public static final URL[] toArray(List<URL> urls) {
        URL[] result = new URL[urls.size()];
        urls.toArray(result);
        return result;
    }
    
    /**
     * Copies <code>is</code> to <code>os</code>.
     * 
     * @param is the input stream
     * @param os the output stream
     * @throws IOException in case of I/O problems
     */
    public static void copy(InputStream is, OutputStream os) throws IOException {
        byte[] buffer = new byte[1024];
        int count = 0;
        do {
            count = is.read(buffer);
            if (count > 0) {
                os.write(buffer, 0, count);
            }
        } while (count > 0);
    }
    
    /**
     * Analyzes the given bundles for cyclic dependencies.
     * 
     * @param infos the bundle information objects to be analyzed
     * 
     * @return empty if there are no cyclic dependencies, the dependency paths leading to cyclic dependencies else
     */
    public static List<String> analyzeForCyclicDependencies(List<BundleInfo> infos) {
        List<String> messages = new ArrayList<String>();
        for (BundleInfo info : infos) {
            messages.addAll(info.analyzeForCyclicDependencies());
        }
        return messages;
    }
    
    /**
     * Compares bundle information objects according to the containment of their
     * bundles to initialize.
     * 
     * @author Holger Eichelberger
     */
    private static class ContainmentComparator implements Comparator<BundleInfo> {

        @Override
        public int compare(BundleInfo bundle1, BundleInfo bundle2) {
            int result;
            List<BundleInfo> init1 = bundle1.getBundlesToInitialize();
            List<BundleInfo> init2 = bundle2.getBundlesToInitialize();
            if (init2.containsAll(init1)) {
                result = -1;
            } else if (init1.containsAll(init2)) {
                result = 1;
            } else {
                result = 0;
            }
            return result;
        }
        
    }

    /**
     * Sorts the given bundle informations according to the containment of their bundles to initialize.
     * 
     * @param infos the information objects to be sorted
     */
    public static void sortByContainment(List<BundleInfo> infos) {
        try {
            Collections.sort(infos, new ContainmentComparator());
        } catch (IllegalArgumentException e) {
            Log.error("Error in Sorting: " + e.getMessage());
            throw e;
        }
    }

    /**
     * Activates a DS class / instance.
     * 
     * @param loader the class loader to find the DS class
     * @param className the class name of the class to activated in (simple) DS way
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public static boolean activateDsInstance(ClassLoader loader, String className) {
        return callMethod(loader, className, "activate", FakeComponentContext.INSTANCE, "DS");
    }

    /**
     * Deactivates a DS class / instance.
     * 
     * @param loader the class loader to find the DS class
     * @param className the class name of the class to de-activated in (simple) DS way
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public static boolean deactivateDsInstance(ClassLoader loader, String className) {
        return callMethod(loader, className, "deactivate", FakeComponentContext.INSTANCE, "DS");
    }

    /**
     * Calls a DS method.
     * 
     * @param loader the class loader to find the DS class
     * @param className the class name of the class to de-activated in (simple) DS way
     * @param methodName the name of the method to be called (1-parameter ComponentContext)
     * @param param the only param to be passed in, must not be <b>null</b>
     * @param callType additional info to be printed out in case of problems
     * @return <code>true</code> if successful, <code>false</code> else
     */
    private static boolean callMethod(ClassLoader loader, String className, String methodName, Object param, 
        String callType) {
        boolean successful = false;
        try {
            Class<?> cls = loader.loadClass(className);
            Method method = findMethod(cls, methodName, param);
            Object instance = cls.newInstance();
            if (null != method) { // DS method calls are optional, don't care for activators
                method.setAccessible(true);
                method.invoke(instance, param);
            }
            successful = true;
        } catch (ClassNotFoundException e) {
            Log.warn(TEXT_CANNOT_INITIALIZE + " " + className + ": not found");
        } catch (IllegalAccessException e) {
            Log.warn(TEXT_CANNOT_INITIALIZE + " " + className + ": " + callType 
                + " method " + methodName + " cannot be accessed");
        } catch (InstantiationException e) {
            Log.warn(TEXT_CANNOT_INITIALIZE + " " + className + ": cannot execute argument-less constructor");
        } catch (InvocationTargetException e) {
            String msg = e.getMessage();
            if (null != e.getCause()) {
                msg = e.getCause().getMessage();
            }
            Log.warn(TEXT_CANNOT_INITIALIZE + " " + className + ": during " + callType + " " + methodName + " " + msg);
            e.printStackTrace();
        }
        return successful;
    }

    /**
     * Searches for the specified method in the given class or (if available) the super classes.
     * 
     * @param cls the class to search in
     * @param methodName the method name to search for
     * @param param the param (and type) to search for
     * @return the found method (may be <b>null</b> if not found)
     */
    private static Method findMethod(Class<?> cls, String methodName, Object param) {
        Method[] methods = cls.getDeclaredMethods();
        Method method = null;
        for (int m = 0; null == method && m < methods.length; m++) {
            Method tmp = methods[m];
            if (tmp.getName().equals(methodName)) {
                Class<?>[] params = tmp.getParameterTypes();
                if (1 == params.length && params[0].isInstance(param)) {
                    method = tmp;
                }
            }
        }
        if (null == method && null != cls.getSuperclass()) {
            method = findMethod(cls.getSuperclass(), methodName, param);
        }
        return method;
    }
    
    /**
     * Starts the bundle activator given by <code>className</code>.
     * 
     * @param loader the class loader to find the DS class
     * @param className the class name of the class to de-activated in (simple) DS way
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public static boolean startBundle(ClassLoader loader, String className) {
        return callMethod(loader, className, "start", FakeBundleContext.INSTANCE, "Activator");
    }

    /**
     * Stops the bundle activator given by <code>className</code>.
     * 
     * @param loader the class loader to find the DS class
     * @param className the class name of the class to de-activated in (simple) DS way
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public static boolean stopBundle(ClassLoader loader, String className) {
        return callMethod(loader, className, "stop", FakeBundleContext.INSTANCE, "Activator");
    }

    /**
     * Loads the bundles from the given file folder.
     * 
     * @param files the files to load from
     * @param filter an optional bundle filter determining the actual bundles to load (may be <b>null</b>)
     * @param tag an optional tag to identify bundles for later use
     */
    public static void loadBundles(List<File> files, IBundleFilter filter, Object tag) {
        for (File f : files) {
            String fileName = f.getName();
            if (!fileName.contains(".source_") && fileName.endsWith(".jar")) {
                if (null == filter || filter.acceptJar(f)) {
                    try {
                        BundleInfo info = BundleInfo.createInstance(f);
                        if (null != info) { // may be ignored!
                            info.tag(tag);
                        }
                    } catch (BundleException e) {
                        Log.warn("while loading " + f, e);
                    }
                }
            }
        }
    }
    
    /**
     * An internal data structure for storing information about a JAR Manifest file.
     * 
     * @author Holger Eichelberger
     */
    private static class JarInfo {
        private Version version;
        private File jar;

        /**
         * Creates a new instance.
         * 
         * @param version the Bundle version of <code>jar</code> 
         * @param jar the jar file
         */
        JarInfo(Version version, File jar) {
            this.version = version;
            this.jar = jar;
        }
    }

    /**
     * Returns all recent bundles in <code>folder</code>.
     * 
     * @param folder the folder to analyze
     * @return all recent JAR files in <code>folder</code> (oder versions of the same bundle are skipped)
     */
    public static List<File> findRecentBundles(File folder) {
        List<File> result = new ArrayList<File>();
        Map<String, JarInfo> map = new HashMap<String, JarInfo>();
        File[] plugins = folder.listFiles();
        if (null != plugins) {
            for (File f : plugins) {
                if (f.getName().endsWith(".jar")) {
                    JarFile jarFile = null;
                    try {
                        jarFile = new JarFile(f);
                        Manifest manifest = jarFile.getManifest();
                        Attributes attributes = BundleInfo.getAttributes(manifest);
                        String name = BundleInfo.parseSymbolicName(attributes);
                        Version version = BundleInfo.parseVersion(attributes);
                        JarInfo info = map.get(name);
                        if (null == info || info.version.compareTo(version) < 0) {
                            map.put(name, new JarInfo(version, f));
                        }
                        jarFile.close();
                    } catch (BundleException e) {
                        Utils.closeQuietly(jarFile);
                        Log.warn("while parsing manifest of " + f + ": " + e.getMessage());
                    } catch (IOException e) {
                        Utils.closeQuietly(jarFile);
                        Log.warn("while parsing manifest of " + f + ": " + e.getMessage());
                    } catch (NumberFormatException e) {
                        Utils.closeQuietly(jarFile);
                        Log.warn("while parsing manifest of " + f + ": " + e.getMessage());
                    }
                }
            }
        }
        for (JarInfo info : map.values()) {
            result.add(info.jar);
        }
        return result;
    }
    
    /**
     * Returns all JAR files in <code>folder</code>.
     * 
     * @param folder the folder to analyze
     * @return all JAR files in <code>folder</code>
     */
    public static List<File> findJars(File folder) {
        List<File> result = new ArrayList<File>();
        File[] plugins = folder.listFiles();
        if (null != plugins) {
            for (File f : plugins) {
                if (f.getName().endsWith(".jar")) {
                    result.add(f);
                }
            }
        }
        System.out.println("JARS found: " + result.toString());
        return result;
    }

    
    /**
     * Filters the given <code>infos</code> according to <code>filter</code>.
     * 
     * @param infos the bundle information objects to be filtered
     * @param filter the {@link IBundleFilter} to be applied
     * @return the filtered bundle information objects
     */
    public static List<BundleInfo> filter(List<BundleInfo> infos, IBundleFilter filter) {
        List<BundleInfo> result = new ArrayList<BundleInfo>();
        for (BundleInfo info : infos) {
            if (filter.acceptSymbolicName(info.getName())) {
                result.add(info);
            }
        }
        return result;
    }
    
    /**
     * Turns files into an URL array.
     * 
     * @param files the files to be turned into URLs
     * @return the resulting URLs
     * @throws MalformedURLException in case that at least one of the files cannot be turned into an URL
     */
    public static URL[] toURLs(List<File> files) throws MalformedURLException {
        URL[] urls = new URL[files.size()];
        for (int f = 0; f < files.size(); f++) {
            urls[f] = files.get(f).toURI().toURL();
        }
        return urls;
    }

    /**
     * Sets the temp directory for extracting and reading temporary files.
     * @param tempDir A folder used by the unpacking process.
     */
    public static void setTempDir(File tempDir) {
        if (null == temp) {
            if (tempDir.mkdir() || tempDir.isDirectory()) {
                temp = tempDir;
                temp.deleteOnExit();
            }
        }
    }
    
    /**
     * Creates a temp file.
     * 
     * @param name the name/subpath of the temp file to be created
     * @return the temp file
     * @throws IOException in case of I/O problems
     */
    public static File createTempFile(String name) throws IOException {
        if (null == temp) {
            temp = new File(System.getProperty("java.io.tempdir"), "easyLoader");
            temp.delete();
            temp.mkdirs();
            temp.deleteOnExit();
        }
        File result = new File(temp, name);
        result.getParentFile().mkdirs();
        result.deleteOnExit();
        return result;
    }

    /**
     * Copies the contents of a JAR entry to the given <code>target</code> file.
     * 
     * @param jarFile the JAR file being processed
     * @param entry the JAR entry
     * @param target the target file
     * @return <code>true</code> if successful, <code>false</code> else
     */
    public static boolean jarEntryToFile(JarFile jarFile, JarEntry entry, File target) {
        boolean success = false;
        OutputStream os = null;
        InputStream is = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(target));
            is = jarFile.getInputStream(entry);
            copy(is, os);
            is.close();
            os.close();
            success = true;
        } catch (IOException e) {
            closeQuietly(is);
            closeQuietly(os);
        }
        return success;
    }

}
