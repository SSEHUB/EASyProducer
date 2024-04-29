package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;

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
     * Triggers the {@link IArtifactChangedListener#artifactChanged(Object)} method on all
     * registered listeners.
     * 
     * @param cause the cause for the event
     * 
     * @throws VilException in case that some listeners fail
     */
    public synchronized void triggerArtifactChanged(Object cause) throws VilException {
        List<VilException> caught = null;
        int size = listeners.size();
        for (int l = 0; l < size; l++) {
            try {
                listeners.get(l).artifactChanged(cause);
            } catch (VilException e) {
                if (null == caught) {
                    caught = new ArrayList<VilException>();
                }
                caught.add(e);
            }
        }
        if (null != caught) {
            throw new VilException(caught);
        }
    }
    
}
