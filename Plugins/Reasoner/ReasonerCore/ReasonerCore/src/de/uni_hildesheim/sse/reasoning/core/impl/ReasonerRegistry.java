package de.uni_hildesheim.sse.reasoning.core.impl;

import java.util.ArrayList;

import de.uni_hildesheim.sse.reasoning.core.frontend.IMessageListener;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage.IType;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerRegistry;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;

/**
 * A class for registering installed reasoners.
 * 
 * @author Patrick Jähne
 * @author Holger Eichelberger
 */
public class ReasonerRegistry implements IReasonerRegistry {

    private static ReasonerRegistry reasonerRegistry = null;
    private ArrayList<IReasoner> reasoner = new ArrayList<IReasoner>();
    private ArrayList<IMessageListener> listener = new ArrayList<IMessageListener>();

    /**
     * Avoids multiple instantiation of this singleton class.
     */
    private ReasonerRegistry() {
    }

    /**
     * Singleton access for this class.
     * @return The singleton instance of this class.
     */
    public static ReasonerRegistry getInstance() {
        if (null == reasonerRegistry) {
            reasonerRegistry = new ReasonerRegistry();
        }
        return reasonerRegistry;
    }

    @Override
    public void register(IReasoner reasoner) {
        this.reasoner.add(reasoner);
    }

    @Override
    public void unregister(IReasoner reasoner) {
        this.reasoner.remove(reasoner);
    }

    /**
     * Registers a message listener.
     * 
     * @param listener the listener to register
     */
    public void register(IMessageListener listener) {
        this.listener.add(listener);
    }

    /**
     * Unregisters a message listener.
     * 
     * @param listener the listener to unregister
     */
    public void unregister(IMessageListener listener) {
        this.listener.remove(listener);
    }

    @Override
    public void notifyAllReasoners(IReasoner source, IType type) {
        IReasonerMessage message = new ReasonerMessage(source, type);
        for (IReasoner r : reasoner) {
            if (source != reasoner) {
                r.notify(message);
                for (IMessageListener listener : this.listener) {
                    listener.notify(source.getDescriptor(), type);
                }
            }
        }
    }

    /**
     * Returns the number of registered reasoners.
     * @return The number of reasoners registered to this registry
     */
    public int getReasonerCount() {
        return reasoner.size();
    }

    /**
     * Returns the {@link IReasoner} at the specified position in this list.
     *
     * @param  index index of the {@link IReasoner} to return
     * @return {@link IReasoner} at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (<tt>index &lt; 0 || index &gt;= {@link #getReasonerCount} </tt>)
     */
    public IReasoner getReasoner(int index) {
        return reasoner.get(index);
    }

    /**
     * Returns the reasoner which provides the given <code>descriptor</code>.
     * 
     * @param descriptor
     *            the descriptor to search for
     * @return the reasoner or <b>null</b> if none matches
     */
    public IReasoner findReasoner(ReasonerDescriptor descriptor) {
        IReasoner result = null;
        int size = reasoner.size();
        for (int r = 0; null == result && r < size; r++) {
            IReasoner tmp = reasoner.get(r);
            ReasonerDescriptor dsc = reasoner.get(r).getDescriptor();
            if (null != dsc && dsc.equals(descriptor)) {
                result = tmp;
            }
        }
        return result;
    }
    
    /**
     * Returns the first version with given <code>name</code> and <code>version</code>.
     * @param name the name of the reasoner as given in its descriptor
     * @param version the version of the reasoner as given in its descriptor (ignored if <b>null</b>)
     * @return the first reasoner matching the criteria or <b>null</b>
     */
    public IReasoner findReasoner(String name, String version) {
        IReasoner result = null;
        if (null != name) {
            int size = reasoner.size();
            for (int r = 0; null == result && r < size; r++) {
                IReasoner tmp = reasoner.get(r);
                ReasonerDescriptor dsc = reasoner.get(r).getDescriptor();
                if (name.equals(dsc.getName())) {
                    if (null == version || version.equals(dsc.getVersion())) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }

}
