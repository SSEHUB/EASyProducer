package net.ssehub.easy.dslCore.translation;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.modelManagement.ModelInfo;

/**
 * A basic implementation of an expression translator, i.e., a basic class for translating
 * individual expressions into model instances.
 * 
 * @author Holger Eichelberger
 */
public abstract class ExpressionTranslator extends MessageReceiver {

    /**
     * Stores the messages.
     */
    private List<Message> messages = new LinkedList<Message>();
    private Map<Message, Message> map = new HashMap<Message, Message>();
    
    /**
     * Stores the number of errors.
     */
    private int errorCount = 0;

    /**
     * Creates an expression translator (to be used within this package only).
     */
    public ExpressionTranslator() {
    }
    
    @Override
    public int getMessageCount() {
        return messages.size();
    }

    @Override
    public int getErrorCount() {
        return errorCount;
    }

    @Override
    public Message getMessage(int index) {
        return messages.get(index);
    }

    /**
     * Returns the resource URI of <code>object</code>.
     * 
     * @param object the object
     * @return the resource URI (may be <b>null</b>)
     */
    private static org.eclipse.emf.common.util.URI getURI(EObject object) {
        org.eclipse.emf.common.util.URI result = null;
        if (object instanceof InternalEObject) {
            // typically the case, but contains fragment ref
            result = ((InternalEObject) object).eProxyURI();
            if (null != result) {
                result = result.trimFragment();
            }
        } else if (null != object) {
            if (null != object.eResource()) {
                result = object.eResource().getURI();
            }
            if (null == result) {
                result = getURI(object.eContainer());
            }
        }
        return result;
    }
    
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
     * @return the created/stored message
     */
    private Message errorImpl(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        Message msg = new Message(message, Status.ERROR, cause, causeFeature, code);
        messages.add(msg);
        errorCount++;
        return msg;
    }

    /**
     * Receives a warning message.
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
     * @return the created/stored message
     */
    private Message warningImpl(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        Message msg = new Message(message, Status.WARNING, cause, causeFeature, code);
        messages.add(msg);
        return msg;
    }

    @Override
    public void error(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        errorImpl(message, cause, causeFeature, code);
    }

    @Override
    public void warning(String message, EObject cause, EStructuralFeature causeFeature, int code) {
        warningImpl(message, cause, causeFeature, code);
    }
    
    @Override
    public void collect(IMessage message, EObject cause, EStructuralFeature causeFeature, int code) {
        Message msg = null;
        switch (message.getStatus()) {
        case ERROR:
            msg = errorImpl(message.getDescription(), cause, causeFeature, code);
            break;
        case WARNING:
            msg = warningImpl(message.getDescription(), cause, causeFeature, code);
            break;
        default:
            msg = null;
            break;
        }
        if (null != msg && message instanceof Message) {
            Message orig = (Message) message;
            map.put(orig, msg);
        }
    }

    /**
     * Adds a diagnostic error, typically from a standalone parser
     * configuration.
     * 
     * @param diagnostic
     *            the diagnostic to be added
     */
    public void error(Diagnostic diagnostic) {
        error(diagnostic.getMessage() + " in line " + diagnostic.getLine(), null, null, ErrorCodes.FROM_PARSER);
    }
    
    /**
     * Clears all messages registered for <code>info</code>.
     * 
     * @param info the information object to clear the messages for
     */
    public void clearMessages(ModelInfo<?> info) {
        clearMessages(info.getLocation());
    }
    
    /**
     * Clears all messages registered for the resource <code>uri</code>.
     * 
     * @param uri the URI to clear the messages for
     */    
    public void clearMessages(URI uri) {
        if (null != uri) {
            if (!messages.isEmpty()) {
                Iterator<Message> iter = messages.iterator();
                while (iter.hasNext()) {
                    Message msg = iter.next();
                    EObject cause = msg.getCause();
                    if (sameURIs(uri, cause)) {
                        iter.remove();
                    }
                }
            }
            if (!map.isEmpty()) {
                // TODO not efficient, revise
                Iterator<Map.Entry<Message, Message>> iter = map.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<Message, Message> ent = iter.next();
                    Message original = ent.getKey();    
                    if (sameURIs(uri, original.getCause())) {
                        messages.remove(ent.getValue());
                        iter.remove();
                    }
                }
            }
        }
    }

    /**
     * Checks whether <code>uri</code> and the URI of <code>cause</code> are the same.
     * 
     * @param uri the URI to check
     * @param cause the cause object to check
     * @return <code>true</code> if both are the same, <code>false</code> else also if <b>null</b>
     */
    private static boolean sameURIs(URI uri, EObject cause) {
        boolean same = false;
        if (null != cause) {
            org.eclipse.emf.common.util.URI cUri = getURI(cause);
            if (null != cUri) {
                String u1 = uri.toString();
                String u2 = cUri.toString();
                same = u1.equals(u2);
            }
        }
        return same;
    }

}
