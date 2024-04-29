package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * The (abstract) composite fragment artifact.
 * 
 * @author Holger Eichelberger
 */
public abstract class CompositeFragmentArtifact extends FragmentArtifact {

    /**
     * Returns all artifacts this composite artifact is composed of.
     * 
     * @return all fragments
     * @throws VilException in case that this element or query is invalid
     */
    @ReturnGenerics(FragmentArtifact.class)
    public abstract Set<? extends FragmentArtifact> selectAll() throws VilException;
     
}
