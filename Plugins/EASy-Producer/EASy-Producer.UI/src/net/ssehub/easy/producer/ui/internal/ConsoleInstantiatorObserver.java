package net.ssehub.easy.producer.ui.internal;

import net.ssehub.easy.instantiation.core.model.IInstantiatorStateObserver;

/**
 * This class represents an observer that listens for new messages send from the instantiators.
 * These messages will be send to the console of the running Eclipse-instance, e.g., to
 * display information about the instantiation process to the user.
 *
 * @author kroeher
 *
 */
public class ConsoleInstantiatorObserver implements IInstantiatorStateObserver {

    @Override
    public void sendMessage(String msg) {
        // Currently disables to avoid problems with VIL
        //EclipseConsole.INSTANCE.writeToConsole(msg, true);
    }

}
