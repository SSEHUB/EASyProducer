package de.uni_hildesheim.sse.reasoning.core.frontend;

import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage.IType;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;

/**
 * Defines a lister to be notified in case that reasoner messages are issued.
 * 
 * @author Holger Eichelberger
 * 
 */
public interface IMessageListener {

    /**
     * Is called when a reasoner message is issued.
     * 
     * @param reasoner
     *            the descriptor of the issuing reasoner (may be <b>null</b>)
     * @param type
     *            the type of the message
     */
    public void notify(ReasonerDescriptor reasoner, IType type);
}
