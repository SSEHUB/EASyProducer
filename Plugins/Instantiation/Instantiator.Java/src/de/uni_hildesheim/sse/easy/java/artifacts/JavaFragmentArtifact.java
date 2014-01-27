package de.uni_hildesheim.sse.easy.java.artifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * A Java source fragment which has a {@link IJavaParent parent}.
 * 
 * @author Holger Eichelberger
 */
abstract class JavaFragmentArtifact extends FragmentArtifact {

    private IJavaParent parent;

    /**
     * Creates a Java fragment artifact.
     * 
     * @param parent the parent
     */
    protected JavaFragmentArtifact(IJavaParent parent) {
        this.parent = parent;
    }
    
    /**
     * Returns the parent of this fragment.
     * 
     * @return the parent
     */
    protected IJavaParent getParent() {
        return parent;
    }
    
    @Override
    public void update() throws ArtifactException {
        // called from the ArtifactFactory on file change - not needed in Java Fragments
    }
    
    @Override
    public void delete() throws ArtifactException {
        getParent().deleteChild(this);
    }
    
    /**
     * Notifies the parent about a change in this artifact.
     */
    protected void notifyChanged() {
        getParent().notifyChildChanged(this);
    }
    
    @Override
    public void store() throws ArtifactException {
        getParent().store();
    }
    
}
