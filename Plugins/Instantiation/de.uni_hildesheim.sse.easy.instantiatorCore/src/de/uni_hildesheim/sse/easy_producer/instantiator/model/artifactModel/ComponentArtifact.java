package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;


/**
 * Represents a runtime component. This class currently acts as a stub and shall be 
 * refined in future.
 * 
 * @author Holger Eichelberger
 */
public abstract class ComponentArtifact implements IRuntimeArtifact {

    /**
     * Activates this component.
     * 
     * @throws ArtifactException in case of serious problems
     */
    public abstract void acticate() throws ArtifactException;

    /**
     * Deactivates this component.
     * 
     * @throws ArtifactException in case of serious problems
     */
    public abstract void deactivate() throws ArtifactException;

    /**
     * Updates this component.
     * 
     * @param artifact the component to update this component with
     * 
     * @throws ArtifactException in case of serious problems
     */
    public abstract void update(ComponentArtifact artifact) throws ArtifactException;
    
}
