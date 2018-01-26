package net.ssehub.easy.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Result of (one) reasoning step.
 * @author El-Sharkawy
 *
 */
public class ReasoningResult {

    private List<IDecisionVariable> affected = null;
    private List<Message> messages = new ArrayList<Message>();
    private boolean hasConflict;
    private boolean hasTimeout;
    private boolean wasStopped;

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
     * Adds a variable affected by reasoning. A reasoner may use this method to communicate
     * affected variables and, thus, support further language mechanisms, such as runtime instantiation.
     * 
     * @param var the affected variable
     */
    public void addAffected(IDecisionVariable var) {
        if (null == affected) {
            affected = new ArrayList<IDecisionVariable>();
        }
        affected.add(var);
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
     * Changes whether reasoning was stopped due to a timeout.
     * 
     * @param hasTimeout <code>true</code> for timeout, <code>false</code> else
     */
    public void setTimeout(boolean hasTimeout) {
        this.hasTimeout = hasTimeout;
    }

    /**
     * Changes whether reasoning was stopped due to a user request.
     * 
     * @param wasStopped <code>true</code> for stopped, <code>false</code> else
     */
    public void setStopped(boolean wasStopped) {
        this.wasStopped = wasStopped;
    }

    /**
     * Returns whether reasoning was stopped due to a timeout.
     * 
     * @return <code>true</code> for timeout, <code>false</code> else
     */
    public boolean hasTimeout() {
        return hasTimeout;
    }

    /**
     * Returns whether reasoning was stopped due to a user request.
     * 
     * @return <code>true</code> for stopped, <code>false</code> else
     */
    public boolean wasStopped() {
        return wasStopped;
    }

    /**
     * Denotes whether this reasoning result represents an error/conflict.
     * @return <tt>true</tt> if the reasoning result represents an error, otherwise <tt>false</tt>.
     * 
     * @see #hasTimeout
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
    * Returns the message specified by <code>index</code>.
    * 
    * @param index a 0-based index specifying the message to be returned
    * @return the message
    * @throws IndexOutOfBoundsException if 
    *   <code>index&lt;0 || index&gt;={@link #getMessageCount}</code>
    */
    public Message getMessage(int index) {
        return messages.get(index);
    }
    
    /**
     * Returns whether information on affected variables is provided.
     * 
     * @return <code>true</code> if information of affected variables is provided, 
     *   <code>false</code> else (then {@link #getAffectedVariablesCount()} will always be <code>0</code>).
     */
    public boolean providesInformationOnAffectedVariables() {
        return affected != null;
    }
    
    /**
     * Return the number of affected variables.
     * 
     * @return the number of affected variables
     */
    public int getAffectedVariablesCount() {
        return null != affected ? affected.size() : 0;
    }
    
    /**
     * Returns the affected variable specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the variable to be returned
     * @return the affected variable
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAffectedVariablesCount()}</code>
     */
    public IDecisionVariable getAffectedVariable(int index) {
        return affected.get(index);
    }
    
}
