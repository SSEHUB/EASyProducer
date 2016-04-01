package de.uni_hildesheim.sse.easy.loader.framework;

/**
 * Some global options.
 * 
 * @author Holger Eichelberger
 */
public class Options {

    private static boolean considerLoadedClasses = true;

    /**
     * Whether already loaded classes shall be considered and not reloaded.
     * 
     * @param considerLoaded <code>true</code> if known classes shall be considered, <code>false</code> if everything 
     *   shall be loaded in the loader classloader
     */
    public static final void setConsiderLoadedClasses(boolean considerLoaded) {
        considerLoadedClasses = considerLoaded;
    }

    /**
     * Whether already loaded classes shall be considered and not reloaded.
     * 
     * @return <code>true</code> if known classes shall be considered, <code>false</code> if everything 
     *   shall be loaded in the loader classloader
     */
    public static final boolean considerLoadedClasses() {
        return considerLoadedClasses;
    }

}
