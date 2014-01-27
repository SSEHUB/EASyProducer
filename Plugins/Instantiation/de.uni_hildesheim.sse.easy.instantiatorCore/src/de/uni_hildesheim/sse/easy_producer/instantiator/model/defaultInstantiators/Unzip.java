package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Unpacks ZIP files.
 * 
 * @author Holger Eichelberger
 * @author kroeher
 */
@Instantiator("unzip")
public class Unzip implements IVilType {

    /**
     * Unpacks files in <code>zip</code> into <code>target</code>.
     * 
     * @param zip the ZIP file to be unpacked
     * @param target the target path to unpack to
     * @return the created artifacts
     * @throws ArtifactException in case of unpacking problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> unzip(Path zip, Path target) throws ArtifactException {
        return unpack(zip, target, new ZipHandler());
    }

    /**
     * Unpacks files in <code>zip</code> into <code>target</code>.
     * 
     * @param zip the ZIP file to be unpacked
     * @param target the target path to unpack to
     * @param handler the ZIP/JAR handler
     * @return the created artifacts
     * @throws ArtifactException in case of unpacking problems
     */
    @Invisible
    public static Set<FileArtifact> unpack(Path zip, Path target, ZipHandler handler) throws ArtifactException {
        List<File> files = new ArrayList<File>();
        try {
            handler.unpack(zip.getAbsolutePath(), target.getAbsolutePath(), null, files);
        } catch (IOException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        }
        return Zip.toFileArtifactSet(files, target.getArtifactModel());
    }
    
    /**
     * Unpacks files in <code>zip</code> that matches the given
     * <code>filter</code> into <code>target</code>.
     * 
     * @param zip the ZIP file to be unpacked
     * @param target the target path to unpack to
     * @param pattern an optional ANT pattern used as a filter expression, typically a specific folder or package. 
     *   May be <code>null</code> if no filter is required.
     * @param handler the ZIP/JAR handler
     * @return the created artifacts
     * @throws ArtifactException in case of unpacking problems
     */
    @Invisible
    public static Set<FileArtifact> unpack(Path zip, Path target, String pattern, ZipHandler handler)
        throws ArtifactException {
        List<File> files = new ArrayList<File>();
        try {
            handler.unpack(zip.getAbsolutePath(), target.getAbsolutePath(), pattern, files);
        } catch (IOException e) {
            throw new ArtifactException(e, ArtifactException.ID_IO);
        }
        return Zip.toFileArtifactSet(files, target.getArtifactModel());
    }

}
