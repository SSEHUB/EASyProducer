package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ArtifactChangedListenerQueue;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactChangedListenerQueue;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * An abstract implementation of artifact representations which cares for modifiability and
 * for listeners.
 *  
 * @author Holger Eichelberger
 */
public abstract class AbstractArtifactRepresentation implements IArtifactRepresentation {

    private boolean triggerEnabled = true;
    private boolean modifiable;
    private ArtifactChangedListenerQueue listeners = new ArtifactChangedListenerQueue();

    /**
     * Creates a artifact representation and sets the modifiability flag.
     * 
     * @param modifiable whether the representation is modifiable
     */
    protected AbstractArtifactRepresentation(boolean modifiable) {
        this.modifiable = modifiable;
    }

    /**
     * Returns whether the representation is modifiable.
     * 
     * @return <code>true</code> if it is modifiable, <code>false</code> else
     */
    protected boolean isModifiable() {
        return modifiable;
    }
    
    @Override
    @Invisible
    public IArtifactChangedListenerQueue getListeners() {
        return listeners;
    }
    
    /**
     * Triggers all registerered listeners in {@link #getListeners()}.
     * 
     * @throws ArtifactException in case that some listeners fail
     */
    public void triggerArtifactChanged() throws ArtifactException {
        if (triggerEnabled) {
            listeners.triggerArtifactChanged(this);
        }
    }

    /**
     * May be used to avoid superfluous listener triggers.
     * 
     * @param triggerEnabled enabled if <code>true</code>, disabled if <code>false</code>
     */
    @Invisible
    public void setTriggerEnabled(boolean triggerEnabled)  {
        // TODO consider this in IVML workflows
        this.triggerEnabled = triggerEnabled;
    }

}
