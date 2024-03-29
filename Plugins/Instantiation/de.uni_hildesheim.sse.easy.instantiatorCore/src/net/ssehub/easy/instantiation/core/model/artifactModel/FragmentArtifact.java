package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * The (abstract) top-level fragment artifact.
 * 
 * @author Holger Eichelberger
 */
@Fragment
public abstract class FragmentArtifact implements IArtifact {

    @Override
    public long lastModification() {
        return 0; // TODO -> just for the moment
    }
    
    @Override
    public boolean exists() {
        return true;
    }
    
    @Override
    public void store() throws VilException {
        // default implementation, fragments are stored with containing artifact
    }
    
}
