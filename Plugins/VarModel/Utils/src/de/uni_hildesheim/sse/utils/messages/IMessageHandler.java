package de.uni_hildesheim.sse.utils.messages;

/**
 * Passes on messages.
 * 
 * @author Holger Eichelberger
 */
public interface IMessageHandler {

    /**
     * Handle the given message.
     * 
     * @param message the message
     * @param error error or warning
     * @param code the message code
     */
    public void handle(String message, boolean error, int code);
}
