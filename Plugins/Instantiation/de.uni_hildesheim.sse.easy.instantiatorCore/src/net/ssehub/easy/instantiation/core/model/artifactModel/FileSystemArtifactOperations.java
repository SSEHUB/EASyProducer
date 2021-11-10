package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * The file system artifact operations which cannot be implemented in an interface.
 * 
 * @author Holger Eichelberger
 */
public class FileSystemArtifactOperations {

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case of problems
     */
    @Invisible
    @Conversion
    public static Path convert(IFileSystemArtifact val) throws VilException {
        return val.getPath();
    }

    /**
     * Enables the (operation system specific) execution flag for the given artifact.
     * 
     * @param art the artifact
     * @param ownerOnly whether all users or just the owner shall be allowed to exectue this artifact
     * @throws VilException if the executable flag cannot be set.
     */
    @Invisible
    static void setExecutable(IFileSystemArtifact art, boolean ownerOnly) throws VilException {
        try {
            File file = art.getPath().getAbsolutePath();
            file.setExecutable(true, ownerOnly);
        } catch (SecurityException e) {
            throw new VilException(e, VilException.ID_SECURITY);
        }
    }

}
