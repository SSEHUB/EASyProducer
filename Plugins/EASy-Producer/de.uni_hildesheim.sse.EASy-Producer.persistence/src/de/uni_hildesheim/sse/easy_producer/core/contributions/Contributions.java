package de.uni_hildesheim.sse.easy_producer.core.contributions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * For contributions to the EASY core. (preliminary, to be aligned with self-bootstrapping 
 * capabilities in future)
 * Please do not change the name or the location of this class as it is populated via OSGI-DS.
 * 
 * @author Holger Eichelberger
 */
public abstract class Contributions {

    /**
     * Stores the registered UI contributions.
     */
    private static final List<Contributions> REGISTERED = new ArrayList<Contributions>();

    /**
     * Registers a particular contribution.
     * 
     * @param contribution the new contribution
     */
    public static synchronized void register(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.add(contribution);
    }

    /**
     * Unregisters a particular contribution.
     * 
     * @param contribution the contribution to be unregisted
     */
    public static synchronized void unregister(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.remove(contribution);
    }
    
    /**
     * Updates product line dependencies.
     * 
     * @param project the folder representing a project
     * @param classpath the classpath of the project (needed in case of importing product line models, may be 
     *   <b>null</b> or empty)
     * @throws IOException in case that extracting dependent models failed
     */
    public static void updateDependencies(File project, String... classpath) throws IOException {
        for (int c = 0; c < REGISTERED.size(); c++) {
            REGISTERED.get(c).updateDependenciesImpl(project, classpath);
        }
    }

    
    /**
     * Updates product line dependencies.
     * 
     * @param project the folder representing a project
     * @param classpath the classpath of the project (needed in case of importing product line models, may be 
     *   <b>null</b> or empty)
     * @throws IOException in case that extracting dependent models failed
     */
    public abstract void updateDependenciesImpl(File project, String[] classpath) throws IOException;
    
}
