package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Defines an artifact for VTL.
 * 
 * @author Holger Eichelberger
 */
@ArtifactCreator(VtlFileArtifactCreator.class)
public class VtlFileArtifact extends FileArtifact {

    /**
     * Creates a new file artifact.
     * 
     * @param file the physical file of this artifact
     * @param model the artifact model to create this folder artifact within
     */
    protected VtlFileArtifact(File file, ArtifactModel model) {
        super(file, model);
    }

    /**
     * Conversion operation.
     * 
     * @param path the path to be converted
     * @return the converted value
     * @throws ArtifactException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(Path path) throws ArtifactException {
        // conversion to parent type required!!!
        return ArtifactFactory.createArtifact(VtlFileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws ArtifactException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws ArtifactException {
        Path path = Path.convert(val);
        return convert(path);
    }

}
