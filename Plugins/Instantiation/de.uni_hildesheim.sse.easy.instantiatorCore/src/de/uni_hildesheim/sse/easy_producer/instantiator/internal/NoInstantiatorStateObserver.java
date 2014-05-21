package de.uni_hildesheim.sse.easy_producer.instantiator.internal;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorStateObserver;

/**
 * This class implements an empty observer for instantiator states. This isused in case
 * that no other oberver is available.
 *    
 * @author Sascha El-Sharkawy
 *
 */
public class NoInstantiatorStateObserver implements IInstantiatorStateObserver {

    @Override
    public void sendMessage(String msg) {
        // No Operation needed
    }
}
