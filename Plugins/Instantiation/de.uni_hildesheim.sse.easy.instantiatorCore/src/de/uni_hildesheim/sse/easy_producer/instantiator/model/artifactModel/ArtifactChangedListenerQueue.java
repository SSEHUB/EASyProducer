package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Handles {@link IArtifactChangedListener}.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactChangedListenerQueue implements IArtifactChangedListenerQueue {

    private List<IArtifactChangedListener> listeners = new ArrayList<IArtifactChangedListener>();

    @Override
    public synchronized void registerListener(IArtifactChangedListener listener) {
        if (null != listener && !listeners.contains(listener)) {
            listeners.add(listener);
        }
    }
    
    @Override
    public synchronized boolean unregisterListener(IArtifactChangedListener listener) {
        return listeners.remove(listener);
    }
    
    /**
     * Triggers the {@link IArtifactChangedListener#artifactChanged()} method on all
     * registered listeners.
     * 
     * @param cause the cause for the event
     * 
     * @throws ArtifactException in case that some listeners fail
     */
    public synchronized void triggerArtifactChanged(Object cause) throws ArtifactException {
        List<ArtifactException> caught = null;
        int size = listeners.size();
        for (int l = 0; l < size; l++) {
            try {
                listeners.get(l).artifactChanged(cause);
            } catch (ArtifactException e) {
                if (null == caught) {
                    caught = new ArrayList<ArtifactException>();
                }
                caught.add(e);
            }
        }
        if (null != caught) {
            throw new ArtifactException(caught);
        }
    }
    
}
