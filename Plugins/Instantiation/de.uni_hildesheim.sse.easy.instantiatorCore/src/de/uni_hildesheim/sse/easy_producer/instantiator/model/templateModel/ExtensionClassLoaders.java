package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Allows to register extension class loaders to be considered by {@link JavaExtension}.
 * 
 * @author Holger Eichelberger
 */
public class ExtensionClassLoaders {

    private static List<ClassLoader> loaders = new ArrayList<ClassLoader>();
    
    static {
        loaders.add(ClassLoader.getSystemClassLoader());
    }
    
    /**
     * Registers the given loader.
     * 
     * @param loader the class loader to be registered (<b>null</b> is ignored)
     */
    public static void registerLoader(ClassLoader loader) {
        if (null != loader && !loaders.contains(loader)) {
            loaders.add(loader);
        }
    }
    
    /**
     * Unregisters the specified loader.
     * 
     * @param loader the loader to be removed (<b>null</b> is ignored)
     */
    public static void unregisterLoader(ClassLoader loader) {
        if (null != loader) {
            loaders.remove(loader);
        }
    }
    
    /**
     * Returns the number of registered loaders.
     * 
     * @return the number of loaders
     */
    public static int getLoaderCount() {
        return loaders.size();
    }
    
    /**
     * Returns the specified loader.
     * 
     * @param index the index of the loader to be returned
     * @return the specified loader
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getLoaderCount()}</code>
     */
    public static ClassLoader getLoader(int index) {
        return loaders.get(index);
    }
    
    /**
     * Returns all loaders in terms of an iterator.
     * 
     * @return the iterator
     */
    public Iterator<ClassLoader> getLoaders() {
        return Collections.unmodifiableList(loaders).iterator();
    }
    
}
