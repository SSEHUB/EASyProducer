package de.uni_hildesheim.sse.easy.java.artifacts;

import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;

/**
 * A Java source fragment which has a {@link IJavaParent parent}.
 * 
 * @author Holger Eichelberger
 */
abstract class JavaFragmentArtifact extends FragmentArtifact implements IStringValueProvider {

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
    public void update() throws VilException {
        // called from the ArtifactFactory on file change - not needed in Java Fragments
    }
    
    @Override
    public void delete() throws VilException {
        getParent().deleteChild(this);
    }
    
    /**
     * Notifies the parent about a change in this artifact.
     */
    protected void notifyChanged() {
        getParent().notifyChildChanged(this);
    }
    
    @Override
    public void store() throws VilException {
        getParent().store();
    }
    
    /**
     * Returns the name of the artifact ignoring the exception.
     * 
     * @return the name of the artifact
     */
    protected String getNameSafe() {
        String result;
        try {
            result = getName();
        } catch (VilException e) {
            result = "";
        }
        return result;
    }
    
}
