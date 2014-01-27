package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

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
     * @throws ArtifactException in case that the required operations fail for some reason
     */
    @Invisible(inherit = true)
    public void artifactChanged(Object cause) throws ArtifactException;
    
}
