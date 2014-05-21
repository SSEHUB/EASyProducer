package de.uni_hildesheim.sse.utils.messages;

/**
 * Defines a message.
 * 
 * @author Holger Eichelberger
 */
public interface IMessage {

    /**
     * Returns the message description.
     * 
     * @return the message description
     */
    public String getDescription();
    
    /**
     * Returns the status of this message.
     * 
     * @return the status of this message
     */
    public Status getStatus();
    
}
