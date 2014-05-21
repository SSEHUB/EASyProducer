package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;

/**
 * The interface for a simple bundle filter.
 * 
 * @author Holger Eichelberger
 */
public interface IBundleFilter {

    /**
     * Returns whether the given <code>jar</code> shall be accepted.
     * 
     * @param jar the JAR to be analyzed
     * @return <code>true</code> if it shall be accepted, <code>false</code> else
     */
    public boolean acceptJar(File jar);

    /**
     * Returns whether the given symbolic <code>name</code> shall be accepted.
     * 
     * @param name the name to be analyzed
     * @return <code>true</code> if it shall be accepted, <code>false</code> else
     */
    public boolean acceptSymbolicName(String name);

}
