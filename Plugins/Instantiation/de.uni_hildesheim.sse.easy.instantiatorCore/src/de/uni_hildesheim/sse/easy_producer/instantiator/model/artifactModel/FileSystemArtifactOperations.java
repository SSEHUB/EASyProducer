package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

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
     * @throws ArtifactException in case of problems
     */
    @Invisible
    @Conversion
    public static Path convert(IFileSystemArtifact val) throws ArtifactException {
        return val.getPath();
    }

}
