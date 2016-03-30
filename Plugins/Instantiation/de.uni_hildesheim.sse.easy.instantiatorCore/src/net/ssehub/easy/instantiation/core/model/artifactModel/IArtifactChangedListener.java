package net.ssehub.easy.instantiation.core.model.artifactModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * A listener which notifies interested parties about a changed artifact.
 * 
 * @author Holger Eichelberger
 */
public interface IArtifactChangedListener {

    /**
     * Is called when the artifact was changed, e.g., to trigger a reanalysis 
     * of substructures.
     * 
     * @param cause the cause for the change, e.g., an artifact representation
     * 
     * @throws VilException in case that the required operations fail for some reason
     */
    @Invisible(inherit = true)
    public void artifactChanged(Object cause) throws VilException;
    
}
