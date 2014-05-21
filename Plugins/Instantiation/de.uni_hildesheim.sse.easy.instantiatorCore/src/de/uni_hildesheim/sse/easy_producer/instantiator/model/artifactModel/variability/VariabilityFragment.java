package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.variability;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;

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
