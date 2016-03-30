package net.ssehub.easy.instantiation.core.model.artifactModel;

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

}
