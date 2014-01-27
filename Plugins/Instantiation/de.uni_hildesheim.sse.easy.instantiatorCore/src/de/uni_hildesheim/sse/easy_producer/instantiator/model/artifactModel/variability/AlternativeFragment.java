package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.variability;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Describes an alternative fragment.
 * 
 * @author Holger Eichelberger
 */
public class AlternativeFragment extends VariabilityFragment {

    private FragmentArtifact thenFragment;
    private FragmentArtifact elseFragment;
    // then/else condition
    
    /**
     * Creates a new alternative fragment.
     * 
     * @param thenFragment the then-fragment
     * @param elseFragment the else-fragment
     */
    AlternativeFragment(FragmentArtifact thenFragment, FragmentArtifact elseFragment) {
        this.thenFragment = thenFragment;
        this.elseFragment = elseFragment;
    }
    
    /**
     * Returns the then-fragment.
     * 
     * @return the then-fragment
     */
    public FragmentArtifact getThenFragment() {
        return thenFragment;
    }

    /**
     * Returns the else-fragment.
     * 
     * @return the else-fragment
     */
    public FragmentArtifact getElseFragment() {
        return elseFragment;
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
        visitor.visitAlternativeFragment(this);
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
    }

}
