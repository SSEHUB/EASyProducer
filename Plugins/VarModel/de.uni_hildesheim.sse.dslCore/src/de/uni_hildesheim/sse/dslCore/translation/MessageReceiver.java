package de.uni_hildesheim.sse.dslCore.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * A class which is able to receive and handle messages. Unifies expression
 * translator and model translator in this regard and may be used to realize
 * other message handling strategies in future.
 * 
 * @author Holger Eichelberger
 */
public abstract class MessageReceiver {

    /**
     * Receives an error message.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     * @param code
     *            a numerical identification of the error
     */
    public abstract void error(String message, EObject cause,
            EStructuralFeature causeFeature, int code);

    /**
     * Receives an warning message.
     * 
     * @param message
     *            the message
     * @param cause
     *            the cause (as instance of the EMF grammar model)
     * @param causeFeature
     *            the cause of the feature as an appropriate constant from
     *            {@link de.uni_hildesheim.sse.ivml.IvmlPackage.Literals}
     * @param code
     *            a numerical identification of the warning
     */
    public abstract void warning(String message, EObject cause,
            EStructuralFeature causeFeature, int code);

    /**
     * Receives an error message in terms of a {@link TranslatorException}.
     * 
     * @param exception
     *            the exception to be used to derive the error cause and
     *            location from
     */
    public void error(TranslatorException exception) {
        if (!exception.consume()) {
            error(exception.getMessage(), exception.getECause(),
                    exception.getCausingFeature(), exception.getCode());
        }
    }

    /**
     * Returns the number of messages.
     * 
     * @return the number of messages
     */
    public abstract int getMessageCount();

    /**
     * Returns the number of errors.
     * 
     * @return the number of errors
     */
    public abstract int getErrorCount();

    /**
     * Returns the specified message.
     * 
     * @param index
     *            the position of the message to be returned
     * @return the specified message
     * @throws IndexOutOfBoundsException
     *             if
     *             <code>index&lt;0 || index&gt;={@link #getMessageCount()}</code>
     */
    public abstract Message getMessage(int index);

    /**
     * Adds a diagnostic error, typically from a standalone parser
     * configuration.
     * 
     * @param diagnostic
     *            the diagnostic to be added
     */
    public abstract void error(Diagnostic diagnostic);

}
