package net.ssehub.easy.instantiation.core.model.artifactModel.variability;

import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;

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
        visitor.visitAlternativeFragment(this);
    }

    @Override
    public void update() throws VilException {
        // TODO Auto-generated method stub
    }

}
