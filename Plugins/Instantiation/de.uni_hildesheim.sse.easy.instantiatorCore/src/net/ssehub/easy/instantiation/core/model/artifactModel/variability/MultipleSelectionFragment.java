package net.ssehub.easy.instantiation.core.model.artifactModel.variability;

import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;

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
    public void delete() throws VilException {
        // TODO Auto-generated method stub
    }

    @Override
    public String getName() throws VilException {
        return "";
    }

    @Override
    public void rename(String name) throws VilException {
        // TODO Auto-generated method stub
    }

    @Override
    public Text getText() throws VilException {
        return Text.CONSTANT_EMPTY; // TODO let's see
    }

    @Override
    public Binary getBinary() throws VilException {
        return Binary.CONSTANT_EMPTY; // TODO let's see
    }
    
    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitMultipleSelectionFragment(this);
    }

    @Override
    public void update() throws VilException {
        // TODO Auto-generated method stub
    }

}
