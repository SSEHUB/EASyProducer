package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

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
     * @throws ArtifactException in case that this element or query is invalid
     */
    @OperationMeta(returnGenerics = FragmentArtifact.class)
    public abstract Set<? extends FragmentArtifact> selectAll() throws ArtifactException;
     
}
