package de.uni_hildesheim.sse.easy.java.artifacts;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * The interface of an artifact / fragment which may act as the parent of a Java element.
 * 
 * @author Holger Eichelberger
 */
interface IJavaParent {

    /**
     * Notifies the parent that one of its childs changed.
     * 
     * @param child the child which changed
     */
    public void notifyChildChanged(FragmentArtifact child);

    /**
     * Notifies the parent that the given child shall be deleted. The 
     * parent is notified implicitly about the "change" so that {@link #notifyChildChanged(FragmentArtifact)}
     * is not needed
     * 
     * @param child the child to be deleted
     * @throws ArtifactException in case that deletion fails
     */
    public void deleteChild(FragmentArtifact child) throws ArtifactException;
    
    /**
     * Stores the artifact / fragment.
     * 
     * @throws ArtifactException in case that storing fails
     */
    public void store() throws ArtifactException;
    
}
