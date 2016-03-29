package net.ssehub.easy.reasoning.core.impl;

import net.ssehub.easy.reasoning.core.reasoner.IReasoner;
import net.ssehub.easy.reasoning.core.reasoner.IReasonerMessage;

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

    @Override
    public IReasoner getSource() {
        return source;
    }

    @Override
    public IType getType() {
        return type;
    }

}
