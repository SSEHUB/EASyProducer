package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.SimpleArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * An abstract default implementation just to avoid code duplication in test artifacts.
 * 
 * @author Holger Eichelberger
 */
abstract class DefaultSimpleArtifact extends SimpleArtifact {

    @Override
    public void delete() throws ArtifactException {
    }

    @Override
    public String getName() throws ArtifactException {
        return "";
    }

    @Override
    public void rename(String name) throws ArtifactException {
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
    }

}
