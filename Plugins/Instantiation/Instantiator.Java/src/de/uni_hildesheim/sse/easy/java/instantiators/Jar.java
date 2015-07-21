package de.uni_hildesheim.sse.easy.java.instantiators;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.Zip;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Creates JAR files.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("jar")
public class Jar implements IVilType {

    /**
     * Packs <code>source</code> files into <code>target</code>. Manifest files is assumed to be the
     * default (empty) one.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param jar the target jar file
     * @return the created artifacts
     * @throws VilException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> jar(Path base, Collection<FileArtifact> artifacts, Path jar) 
        throws VilException {
        return jar(base, artifacts, jar, null);
    }

    /**
     * Packs <code>source</code> files into <code>target</code>.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param jar the target jar file
     * @param manifest the manifest file
     * @return the created artifacts
     * @throws VilException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> jar(Path base, Collection<FileArtifact> artifacts, Path jar, Path manifest) 
        throws VilException {
        return Zip.add(base, artifacts, jar, createJarHandler(manifest));
    }

    /**
     * Packs <code>source</code> files into <code>target</code>. Manifest files is assumed to be the
     * default (empty) one.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param jar the target jar file
     * @return the created artifacts
     * @throws VilException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> jar(Path base, Path artifacts, Path jar) 
        throws VilException {
        // needed as paths are typically expressed as strings and string->path->collection conversion is not supported
        return jar(base, artifacts.selectAll(), jar, null);
    }

    /**
     * Packs <code>source</code> files into <code>target</code>.
     * 
     * @param base the base path used to make the paths of the <code>artifacts</code> relative, may
     *   be the source or target project
     * @param artifacts the artifacts to be handled
     * @param jar the target jar file
     * @param manifest the manifest file
     * @return the created artifacts
     * @throws VilException in case that processing the JAR file fails for some reason
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> jar(Path base, Path artifacts, Path jar, Path manifest) 
        throws VilException {
        // needed as paths are typically expressed as strings and string->path->collection conversion is not supported
        return Zip.add(base, artifacts.selectAll(), jar, createJarHandler(manifest));
    }
    
    /**
     * Creates the JarHandler for creating a new JAR archive.
     * @param manifest A path for a manifest file which shall be included in the jar. Maybe <tt>null</tt>, than a
     * default manifest file will be created.
     * @return A {@link JarHandler} which will use the given manifest file or create a new one if <tt>manifest</tt>
     * was <tt>null</tt>.
     */
    private static JarHandler createJarHandler(Path manifest) {
        return null == manifest ? new JarHandler() : new JarHandler(manifest.getAbsolutePath(), false);
    }

}
