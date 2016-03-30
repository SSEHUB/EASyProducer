package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;


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
     * @throws VilException in case of serious problems
     */
    public abstract void acticate() throws VilException;

    /**
     * Deactivates this component.
     * 
     * @throws VilException in case of serious problems
     */
    public abstract void deactivate() throws VilException;

    /**
     * Updates this component.
     * 
     * @param artifact the component to update this component with
     * 
     * @throws VilException in case of serious problems
     */
    public abstract void update(ComponentArtifact artifact) throws VilException;
    
}
