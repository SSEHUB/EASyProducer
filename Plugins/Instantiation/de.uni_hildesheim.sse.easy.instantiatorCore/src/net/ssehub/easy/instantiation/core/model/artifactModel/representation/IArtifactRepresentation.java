package net.ssehub.easy.instantiation.core.model.artifactModel.representation;

import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactChangedListenerQueue;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * The common interface for all artifact representations.
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactRepresentation extends IVilType {

    /**
     * Returns whether this artifact representation is empty.
     * 
     * @return <code>true</code> if it is empty, <code>false</code> else
     */
    public boolean isEmpty();
    
    /**
     * Returns the change listeners.
     * 
     * @return the change listeners
     */
    @Invisible(inherit = true)
    public IArtifactChangedListenerQueue getListeners();
    
    /**
     * Updates the contents.
     * 
     * @throws VilException in case that reading fails for some reason
     */
    @Invisible(inherit = true)
    public void updateContents() throws VilException;

}
