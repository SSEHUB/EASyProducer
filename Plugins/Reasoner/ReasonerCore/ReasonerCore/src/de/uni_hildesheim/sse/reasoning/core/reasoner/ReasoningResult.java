package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Result of (one) reasoning step.
 * @author El-Sharkawy
 *
 */
public class ReasoningResult {

    private List<Message> messages = new ArrayList<Message>();
    private boolean hasConflict;

    /**
     * General constructor for new ReasoningResults.
     */
    public ReasoningResult() {
        hasConflict = false;
    }

    /**
     * Constructor for a result denoting the the chosen constructor is not able to handle the called operation.
     * @param reasonerName The name of the reasoner, which was called.
     */
    public ReasoningResult(String reasonerName) {
        this();
        // Create ResuningResult denoting that the current Reasoner is not able to handle the desired Reasoning step.
        String message = "Reasoning not supported by " + reasonerName;
        Message unsupportedReasoning = new Message(message, null, Status.UNSUPPORTED);
        addMessage(unsupportedReasoning);
    }

    /**
     * Adds a new Message to the current result, e. g. an Error or Warning
     * @param message The new message which should be added to this result.
     */
    public void addMessage(Message message) {
        messages.add(message);
        if (Status.ERROR == message.getStatus()) {
            hasConflict = true;
        }
    }

    /**
     * Denotes whether this reasoning result represents an error/conflict.
     * @return <tt>true</tt> if the reasoning result represents an error, otherwise <tt>false</tt>.
     */
    public boolean hasConflict() {
        return hasConflict;
    }
    
    /**
     * Checks whether this result contains any {@link Status#INFO} messages, indicating that the configuration
     * was changed.
     * @return <tt>true</tt> if this result contains at least one {@link Status#INFO} message, <tt>false</tt> otherwise.
     */
    public boolean hasInfo() {
        boolean hasInfo = false;
        for (int i = 0; i < messages.size() && !hasInfo; i++) {
            if (Status.INFO == messages.get(i).getStatus()) {
                hasInfo = true;
            }
        }
        
        return hasInfo;
    }

    /**
     * Returns whether the called reasoning step is supported by this reasoner.
     * 
     * @return <tt>true</tt> if the reasoning was not supported, otherwise <tt>false</tt>.
     */
    public boolean reasoningUnsupported() {
        boolean unsupported = false;

        if (1 == messages.size() && Status.UNSUPPORTED == messages.get(0).getStatus()) {
            unsupported = true;
        }

        return unsupported;
    }

    /**
     * Returns the number of messages related to this reasoning result.
     * @return the number of messages in this result
     */
    public int getMessageCount() {
        return messages.size();
    }

   /**
    *  Returns the message specified by <code>index</code>.
    * 
    * @param index a 0-based index specifying the message to be returned
    * @return the message
    * @throws IndexOutOfBoundsException if 
    *   <code>index&lt;0 || index&gt;={@link #getMessageCount}</code>
    */
    public Message getMessage(int index) {
        return messages.get(index);
    }
}
