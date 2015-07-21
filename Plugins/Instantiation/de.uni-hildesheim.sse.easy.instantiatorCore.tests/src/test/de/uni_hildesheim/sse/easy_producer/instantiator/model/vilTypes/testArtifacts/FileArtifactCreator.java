package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.DefaultFileArtifactCreator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

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
