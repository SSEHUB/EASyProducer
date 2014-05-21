package de.uni_hildesheim.sse.utils.messages;


/**
 * Defines a message to be emitted during runtime. 
 * 
 * @author Holger Eichelberger
 */
public class Message implements IMessage {
    private String description;
    private Status status;
    
    /**
     * Creates a message.
     * 
     * @param description the message description
     * @param status the status of the message
     */
    public Message(String description, Status status) {
        this.description = description;
        this.status = status;
    }
    
    /**
     * Returns the message description.
     * 
     * @return the message description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Returns the status of this message.
     * 
     * @return the status of this message
     */
    public Status getStatus() {
        return status;
    }
    
}

