package net.ssehub.easy.instantiation.core.internal;

import net.ssehub.easy.instantiation.core.model.IInstantiatorStateObserver;

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
