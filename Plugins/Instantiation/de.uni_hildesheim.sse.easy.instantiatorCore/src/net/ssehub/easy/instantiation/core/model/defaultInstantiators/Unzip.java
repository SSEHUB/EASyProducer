package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

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
     * @throws VilException in case of unpacking problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> unzip(Path zip, Path target) throws VilException {
        return unpack(zip, target, new ZipHandler());
    }

    /**
     * Unpacks files in <code>zip</code> into <code>target</code>.
     * 
     * @param zip the ZIP file to be unpacked
     * @param target the target path to unpack to
     * @param handler the ZIP/JAR handler
     * @return the created artifacts
     * @throws VilException in case of unpacking problems
     */
    @Invisible
    public static Set<FileArtifact> unpack(Path zip, Path target, ZipHandler handler) throws VilException {
        List<File> files = new ArrayList<File>();
        try {
            handler.unpack(zip.getAbsolutePath(), target.getAbsolutePath(), null, files);
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
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
     * @throws VilException in case of unpacking problems
     */
    @Invisible
    public static Set<FileArtifact> unpack(Path zip, Path target, String pattern, ZipHandler handler)
        throws VilException {
        List<File> files = new ArrayList<File>();
        try {
            handler.unpack(zip.getAbsolutePath(), target.getAbsolutePath(), pattern, files);
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
        }
        return Zip.toFileArtifactSet(files, target.getArtifactModel());
    }

}
