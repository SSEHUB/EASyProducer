package net.ssehub.easy.instantiation.core.model.vilTypes.testArtifacts;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.SimpleArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;

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
