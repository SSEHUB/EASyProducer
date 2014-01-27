package de.uni_hildesheim.sse.reasoning.core.impl;

import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasoner;
import de.uni_hildesheim.sse.reasoning.core.reasoner.IReasonerMessage;

/**
 * Implements the internal message among reasoners.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerMessage implements IReasonerMessage {

    private IReasoner source;
    private IType type;

    /**
     * Creates a reasoner message.
     * 
     * @param source
     *            the source reasoner issuing the message
     * @param type
     *            the type of the message
     */
    public ReasonerMessage(IReasoner source, IType type) {
        this.source = source;
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    public IReasoner getSource() {
        return source;
    }

    /**
     * {@inheritDoc}
     */
    public IType getType() {
        return type;
    }

}
