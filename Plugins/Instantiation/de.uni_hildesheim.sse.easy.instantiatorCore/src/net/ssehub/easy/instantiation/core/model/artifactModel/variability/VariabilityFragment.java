package net.ssehub.easy.instantiation.core.model.artifactModel.variability;

import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;

/**
 * A top-level class for variability fragments, i.e., fragments combined with other
 * types of fragments to explicitly express variability in generic artifacts.
 * 
 * @author Holger Eichelberger
 */
public abstract class VariabilityFragment extends FragmentArtifact {

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitVariabilityFragment(this);
    }

}
