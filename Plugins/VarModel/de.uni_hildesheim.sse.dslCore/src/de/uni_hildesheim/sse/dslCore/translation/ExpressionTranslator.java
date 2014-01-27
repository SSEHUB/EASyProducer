package de.uni_hildesheim.sse.dslCore.translation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A basic implementation of an expression translator, i.e., a basic class for translating
 * individual expressions into model instances. As a basic class, the expression translator 
 * is 
 * 
 * @author Holger Eichelberger
 */
public abstract class ExpressionTranslator extends MessageReceiver {

    /**
     * Stores the messages.
     */
    private List<Message> messages = new ArrayList<Message>();
    
    /**
     * Stores the number of errors.
     */
    private int errorCount = 0;

    /**
     * Creates an expression translator (to be used within this package only).
     */
    public ExpressionTranslator() {
    }
    
    /**
     * {@inheritDoc}
     */
    public int getMessageCount() {
        return messages.size();
    }

    /**
     * {@inheritDoc}
     */
    public int getErrorCount() {
        return errorCount;
    }

    /**
     * {@inheritDoc}
     */
    public Message getMessage(int index) {
        return messages.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        messages.add(new Message(message, Status.ERROR, cause, causeFeature, code));
        errorCount++;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        messages.add(new Message(message, Status.WARNING, cause, causeFeature, code));
    }

    /**
     * Adds a diagnostic error, typically from a standalone parser
     * configuration.
     * 
     * @param diagnostic
     *            the diagnostic to be added
     */
    public void error(Diagnostic diagnostic) {
        error(diagnostic.getMessage(), null, null, ErrorCodes.FROM_PARSER);
    }

}
