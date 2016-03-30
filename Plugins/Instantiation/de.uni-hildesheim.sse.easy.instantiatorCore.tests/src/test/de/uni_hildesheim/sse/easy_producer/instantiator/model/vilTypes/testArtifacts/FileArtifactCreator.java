package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import java.io.File;

import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.DefaultFileArtifactCreator;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * A specific file artifact creator for the test artifact.
 * 
 * @author Holger Eichelberger
 */
public class FileArtifactCreator extends DefaultFileArtifactCreator {

    @Override
    public FileArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new FileArtifact((File) real, model);
    }

}
