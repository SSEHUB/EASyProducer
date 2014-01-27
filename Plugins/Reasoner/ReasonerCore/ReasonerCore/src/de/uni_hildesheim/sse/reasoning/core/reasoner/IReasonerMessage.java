package de.uni_hildesheim.sse.reasoning.core.reasoner;

/**
 * Defines a message for internally sending signals among reasoners.
 * 
 * @author Holger Eichelberger
 */
public interface IReasonerMessage {

    /**
     * Defines the type of message types.
     * 
     * @author Holger Eichelberger
     */
    public interface IType {
    }

    /**
     * Defines basic message types.
     * 
     * @author Holger Eichelberger
     */
    public enum Type implements IType {

        /**
         * Signals that the source of the message became available.
         */
        AVAILABLE,

        /**
         * Signals that the source of the message became unavailable.
         */
        UNAVAILABLE;

    }

    /**
     * Returns the message source.
     * 
     * @return the message source
     */
    public IReasoner getSource();

    /**
     * Returns the type of the message.
     * 
     * @return the type of the message
     */
    public IType getType();

}
