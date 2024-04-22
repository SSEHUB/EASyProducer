package net.ssehub.easy.reasoning.core.reasoner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration.IAdditionalInformationLogger;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.Project;

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
    private Map<IMeasurementKey, Number> measures;

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
     * @return {@code true} if the reasoning result represents an error, otherwise {@code false}.
     * 
     * @see #hasTimeout
     */
    public boolean hasConflict() {
        return hasConflict;
    }
    
    /**
     * Checks whether this result contains any {@link Status#INFO} messages, indicating that the configuration
     * was changed.
     * @return {@code true} if this result contains at least one {@link Status#INFO} message, {@code false} otherwise.
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
     * @return {@code true} if the reasoning was not supported, otherwise {@code false}.
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
    
    /**
     * Sets a reasoner-specific measure.
     * 
     * @param key the key (<b>null</b> is ignored)
     * @param value the measure (may be <b>null</b>)
     */
    public void setMeasure(IMeasurementKey key, Number value) {
        if (null != key) {
            if (null == measures) {
                measures = new HashMap<IMeasurementKey, Number>();
            }
            measures.put(key, value);
        }
    }

    /**
     * Returns the measure for a specific <code>key</code>.
     * 
     * @param key the key (<b>null</b> is ignored)
     * @return the measure (may be <b>null</b>)
     */
    public Number getMeasure(IMeasurementKey key) {
        return (null == key || null == measures) ? null : measures.get(key);
    }
    
    /**
     * Returns all measurement keys.
     * 
     * @return the keys, may be <b>null</b> if there are none
     */
    public Set<IMeasurementKey> measurementKeys() {
        return null == measures ? null : measures.keySet();
    }

    /**
     * Logs reasoning summary based on <code>prj</code>, the measures and the messages. Reasoners shall not produce
     * output except for debugging stuff. If explicit output is required, call this method after reasoning. Logs
     * with reasoner messages by default.
     * 
     * @param prj the project representing the model
     * @param rConfig the configuration containing the information logger
     */
    public void logInformation(Project prj, ReasonerConfiguration rConfig) {
        logInformation(prj, rConfig, true);
    }

    /**
     * Logs reasoning summary based on <code>prj</code>, the measures and the messages. Reasoners shall not produce
     * output except for debugging stuff. If explicit output is required, call this method after reasoning.
     * 
     * @param prj the project representing the model
     * @param rConfig the configuration containing the information logger
     * @param withMessages include the reasoner messages (may be time consuming)
     */
    public void logInformation(Project prj, ReasonerConfiguration rConfig, boolean withMessages) {
        logInformation(prj, rConfig.getLogger(), withMessages);
    }
 
    /**
     * Logs reasoning summary based on <code>prj</code>, the measures and the messages. Reasoners shall not produce
     * output except for debugging stuff. If explicit output is required, call this method after reasoning.
     * 
     * @param prj the project representing the model
     * @param infoLogger the information logger
     * @param withMessages include the reasoner messages (may be time consuming)
     */
    public void logInformation(Project prj, IAdditionalInformationLogger infoLogger, boolean withMessages) {
        infoLogger.info("Model: " + prj.getName());
        if (null != measures) {
            Set<IMeasurementKey> keys = measures.keySet();
            IMeasurementKey[] sortedKeys = new IMeasurementKey[keys.size()];
            keys.toArray(sortedKeys);
            Arrays.sort(sortedKeys, new Comparator<IMeasurementKey>() {

                @Override
                public int compare(IMeasurementKey o1, IMeasurementKey o2) {
                    return -Integer.compare(o1.outputPos(), o2.outputPos());
                }
            });
            for (int k = 0; k < sortedKeys.length; k++) {
                IMeasurementKey key = sortedKeys[k];
                infoLogger.info(key.getExplanation() + ": " + getMeasure(key));
            }
        }
        if (withMessages && !messages.isEmpty()) {
            infoLogger.info("");
            for (int m = 0; m < messages.size(); m++) {
                infoLogger.info(messages.get(m));
            }
        }
        infoLogger.info("");
    }
    
}
