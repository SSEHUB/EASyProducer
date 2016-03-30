package de.uni_hildesheim.sse.easy.java.instantiators;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.Unzip;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Unpacks JAR files.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
@Instantiator("unjar")
public class Unjar implements IVilType {

    /**
     * Packs <code>source</code> files into <code>target</code> without unpacking the manifest.
     * 
     * @param jar the JAR file to be unpacked
     * @param target the target path to unpack to
     * @return the created artifacts
     * @throws VilException in case of unpacking problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> unjar(Path jar, Path target) throws VilException {
        return unjar(jar, target, false);
    }
    
    /**
     * Packs <code>source</code> files into <code>target</code>.
     * 
     * @param jar the JAR file to be unpacked
     * @param target the target path to unpack to
     * @param includeManifest whether the manifest shall also be unpacked
     * @return the created artifacts
     * @throws VilException in case of unpacking problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> unjar(Path jar, Path target, boolean includeManifest) throws VilException {
        return Unzip.unpack(jar, target, new JarHandler(includeManifest));
    }
    
    /**
     * Packs <code>source</code> files which matches <code>filter</code>
     * into <code>target</code> without unpacking the manifest.
     * 
     * @param jar the JAR file to be unpacked
     * @param target the target path to unpack to
     * @param pattern an optional ANT pattern used as a filter expression, typically a specific folder or package. 
     *   May be <code>null</code> if no filter is required.
     * @return the created artifacts
     * @throws VilException in case of unpacking problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> unjar(Path jar, Path target, String pattern) throws VilException {
        return Unzip.unpack(jar, target, pattern, new JarHandler(false));
    }

    /**
     * Packs <code>source</code> files which matches <code>filter</code>
     * into <code>target</code> without unpacking the manifest.
     * 
     * @param jar the JAR file to be unpacked
     * @param target the target path to unpack to
     * @param pattern an optional ANT pattern used as a filter expression, typically a specific folder or package. 
     *   May be <code>null</code> if no filter is required.
     * @param includeManifest whether the manifest shall also be unpacked
     * @return the created artifacts
     * @throws VilException in case of unpacking problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> unjar(Path jar, Path target, String pattern, boolean includeManifest) 
        throws VilException {
        return Unzip.unpack(jar, target, pattern, new JarHandler(includeManifest));
    }

}
