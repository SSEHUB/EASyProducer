package test.de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.testArtifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.SimpleArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * An abstract default implementation just to avoid code duplication in test artifacts.
 * 
 * @author Holger Eichelberger
 */
abstract class DefaultSimpleArtifact extends SimpleArtifact {

    @Override
    public void delete() throws VilException {
    }

    @Override
    public String getName() throws VilException {
        return "";
    }

    @Override
    public void rename(String name) throws VilException {
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws VilException {
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
    }

}
