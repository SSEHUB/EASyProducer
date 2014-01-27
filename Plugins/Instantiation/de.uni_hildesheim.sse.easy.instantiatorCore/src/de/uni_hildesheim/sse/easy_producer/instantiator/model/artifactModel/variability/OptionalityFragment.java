package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.variability;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Describes an optional fragment.
 * 
 * @author Holger Eichelberger
 */
public class OptionalityFragment extends VariabilityFragment {

    private FragmentArtifact optional;
    // condition

    /**
     * Creates a new optionality fragment.
     * 
     * @param optional the optional fragment
     */
    public OptionalityFragment(FragmentArtifact optional) {
        this.optional = optional;
    }

    /**
     * Returns the optional fragment.
     * 
     * @return the optional fragment
     */
    public FragmentArtifact getOptionalFragment() {
        return optional;
    }

    @Override
    public void delete() throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getName() throws ArtifactException {
        return "";
    }

    @Override
    public void rename(String name) throws ArtifactException {
        // TODO Auto-generated method stub
    }

    @Override
    public Text getText() throws ArtifactException {
        return Text.CONSTANT_EMPTY; // TODO let's see
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        return Binary.CONSTANT_EMPTY; // TODO let's see
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitOptionalityFragment(this);
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
    }

}
