package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

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
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(Path path) throws VilException {
        // conversion to parent type required!!!
        return ArtifactFactory.createArtifact(VtlFileArtifact.class, path.getAbsolutePath(), path.getArtifactModel());
    }

    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return convert(path);
    }

}
