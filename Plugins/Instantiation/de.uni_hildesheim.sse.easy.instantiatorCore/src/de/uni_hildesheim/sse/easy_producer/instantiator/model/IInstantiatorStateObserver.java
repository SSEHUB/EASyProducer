package de.uni_hildesheim.sse.easy_producer.instantiator.model;

/**
 * This interface enables instantiators to send messages to the console of the
 * currently running Eclipse instance, e.g., for displaying information to the
 * user.
 * 
 * @author Sascha El-Sharkawy
 *
 */
public interface IInstantiatorStateObserver {

    /**
     * This method sends a message to the console of the running Eclipse-instance.
     * 
     * @param msg the message the should be displayed in the console.
     */
    public void sendMessage(String msg);
}
