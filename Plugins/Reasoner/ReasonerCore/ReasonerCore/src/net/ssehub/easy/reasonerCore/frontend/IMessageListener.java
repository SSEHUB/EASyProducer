package net.ssehub.easy.reasonerCore.frontend;

import net.ssehub.easy.reasonerCore.reasoner.ReasonerDescriptor;
import net.ssehub.easy.reasonerCore.reasoner.IReasonerMessage.IType;

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
