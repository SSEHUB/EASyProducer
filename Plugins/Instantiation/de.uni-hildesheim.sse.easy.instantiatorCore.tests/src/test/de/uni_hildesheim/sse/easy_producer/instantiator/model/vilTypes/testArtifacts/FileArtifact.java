package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;

/** 
 * A new file artifact that does not conflict with an existing artifact.
 */
@ArtifactCreator(FileArtifactCreator.class)
public class FileArtifact extends net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact {

    /**
     * Creates a new file artifact from <code>file</code>.
     * 
     * @param file the file to derive the artifact from
     * @param model the artifact model to create this folder artifact within
     */
    protected FileArtifact(File file, ArtifactModel model) {
        super(file, model);
    }

}
