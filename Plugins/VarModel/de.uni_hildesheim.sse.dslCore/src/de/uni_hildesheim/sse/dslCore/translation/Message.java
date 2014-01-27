package de.uni_hildesheim.sse.dslCore.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Implements a message issues by the model translator (in order to provide
 * feedback on multiple issues at once).
 * 
 * @author Holger Eichelberger
 */
public class Message extends de.uni_hildesheim.sse.utils.messages.Message {
    // this inner class is just here due to OSGi exports - should be in
    // translation

    /**
     * Defines the code used for messages which can be ignored.
     */
    public static final int CODE_IGNORE = 0;
    
    /**
     * Stores the ECore element causing the error.
     */
    private EObject cause;

    /**
     * Stores the (sub-)feature of {@link #cause}.
     */
    private EStructuralFeature causingFeature;

    /**
     * A code representing the message.
     * 
     * @see #CODE_IGNORE
     */
    private int code;

    /**
     * Creates a message object.
     * 
     * @param message
     *            the message text
     * @param status
     *            the message status
     * @param cause
     *            the ECore element causing the message
     * @param causingFeature
     *            the feature within <code>cause</code>
     * @param code
     *            a numerical code representing the message (see {@link #CODE_IGNORE})
     */
    public Message(String message, Status status, EObject cause,
            EStructuralFeature causingFeature, int code) {
        super(message, status);
        this.cause = cause;
        this.code = code;
        this.causingFeature = causingFeature;
    }

    /**
     * Returns the cause of the message (in terms of the causing ECore element).
     * 
     * @return the cause of the message
     */
    public EObject getCause() {
        return cause;
    }

    /**
     * Returns the causing feature (within {@link #getCause()}).
     * 
     * @return the causing feature
     */
    public EStructuralFeature getCausingFeature() {
        return causingFeature;
    }

    /**
     * Returns a code for the message.
     * 
     * @return the code
     */
    public int getCode() {
        return code;
    }
    
    /**
     * Returns whether this message can be igored.
     * 
     * @return <code>true</code> if it can be ignored, <code>false</code> else
     */
    public boolean ignore() {
        return 0 == code;
    }
    
}
