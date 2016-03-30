package net.ssehub.easy.instantiation.core.model.artifactModel;

/**
 * Defines the interface for a set of listeners (observer part).
 * 
 * @author Holger Eichelber
 */
public interface IArtifactChangedListenerQueue {

    /**
     * Registers a <code>listener</code>. A <code>listener</code> will only be registered if
     * it is not <b>null</b> and if it was not already registered.
     * 
     * @param listener the listener to be registered
     */
    public abstract void registerListener(IArtifactChangedListener listener);

    /**
     * Unregisters a listener.
     * 
     * @param listener the listener to be unregistered
     * @return <code>true</code> if unregistering was successful, <code>false</code> else
     */
    public abstract boolean unregisterListener(IArtifactChangedListener listener);

}