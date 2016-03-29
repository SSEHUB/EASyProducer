package net.ssehub.easy.reasonerCore.reasoner;

import net.ssehub.easy.reasonerCore.reasoner.IReasonerMessage.IType;

/**
 * Public interface for this reasoner registry capable of handling multiple reasoners.
 * @author El-Sharkawy
 *
 */
public interface IReasonerRegistry {
    /**
     * Adds a new Reasoner to the registry.
     * @param reasoner The Reasoner which should be added to the registry.
     */
    public void register(IReasoner reasoner);

    /**
     * Removes the specified reasoner from the registry, if the reasoner was added before.
     * @param reasoner The reasoner which should be removed from the registry.
     */
    public void unregister(IReasoner reasoner);

    /**
     * Notifies all reasoners about a given event.
     * 
     * @param source the reasoner causing the event
     * @param type the type of the event
     */
    public void notifyAllReasoners(IReasoner source, IType type);
}
