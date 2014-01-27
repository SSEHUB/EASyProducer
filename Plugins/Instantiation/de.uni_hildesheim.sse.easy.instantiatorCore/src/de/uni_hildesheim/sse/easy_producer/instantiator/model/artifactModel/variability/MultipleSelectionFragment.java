package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.variability;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a multiple selection fragment.
 * 
 * @author Holger Eichelberger
 */
public class MultipleSelectionFragment extends VariabilityFragment {

    // conditions/cases
    private FragmentArtifact[] alternatives;
    
    /**
     * Creates a new fragment artifact from given alternative fragments.
     * 
     * @param alternatives the alternative fragments
     */
    MultipleSelectionFragment(FragmentArtifact[] alternatives) {
        assert null != alternatives;
        this.alternatives = alternatives;
    }
    
    /**
     * Returns the number of alternative fragments.
     * 
     * @return the number of alternatives
     */
    public int getAlternativesCount() {
        return alternatives.length;
    }
    
    /**
     * Returns the specified alternative fragment.
     * 
     * @param index the index of the alternative to be returned
     * @return the specified alternative fragment
     * @throws IndexOutOfBoundsException if <code>0 &lt; index || index &gt;={@link #getAlternativesCount()}</code>
     */
    public FragmentArtifact getAlternative(int index) {
        return alternatives[index];
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
        visitor.visitMultipleSelectionFragment(this);
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
    }

}
