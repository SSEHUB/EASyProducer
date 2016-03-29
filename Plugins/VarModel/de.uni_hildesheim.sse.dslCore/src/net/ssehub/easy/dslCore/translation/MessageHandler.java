package net.ssehub.easy.dslCore.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.ssehub.easy.basics.messages.IMessageHandler;

/**
 * Implements a message handler for xText delegating to {@link MessageReceiver}.
 * 
 * @author Holger Eichelberger
 */
public class MessageHandler implements IMessageHandler {

    private MessageReceiver receiver;
    private EObject cause;
    private EStructuralFeature feature;

    /**
     * Creates the message handler.
     * 
     * @param receiver the message receiver
     * @param cause the causing grammar object
     * @param feature the causing grammar feature
     */
    public MessageHandler(MessageReceiver receiver, EObject cause, EStructuralFeature feature) {
        this.receiver = receiver;
        this.cause = cause;
        this.feature = feature;
    }
    
    @Override
    public void handle(String message, boolean error, int code) {
        if (error) {
            receiver.error(message, cause, feature, code);
        } else {
            receiver.warning(message, cause, feature, code);
        }
    }
    
}