package de.uni_hildesheim.sse.dslCore.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.utils.messages.IIdentifiable;

/**
 * Defines a specific model translator exception which carries information about
 * the context where the error occurred.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class TranslatorException extends Exception implements IIdentifiable {

    public static final int CONSUME = 20101;
    public static final int INTERNAL = 20100;

    private EObject cause;
    private EStructuralFeature causingFeature;
    private int code;

    /**
     * Creates a translator exception upon an IVML exception.
     * 
     * @param ex
     *            the causing exception
     * @param cause
     *            the Ecore language model element for which the exception was
     *            caused
     * @param causingFeature
     *            the specific language feature within <code>cause</code> which
     *            caused the exception
     */
    public TranslatorException(IIdentifiable ex, EObject cause,
            EStructuralFeature causingFeature) {
        this(ex.getMessage(), cause, causingFeature, ex.getId());
    }

    /**
     * Creates a translator exception upon a given message string.
     * 
     * @param message
     *            the message string
     * @param cause
     *            the Ecore language model element for which the exception was
     *            caused
     * @param causingFeature
     *            the specific language feature within <code>cause</code> which
     *            caused the exception
     * @param code
     *            a numerical code representing the problem
     */
    public TranslatorException(String message, EObject cause,
            EStructuralFeature causingFeature, int code) {
        super(message);
        this.cause = cause;
        this.causingFeature = causingFeature;
        this.code = code;
    }

    /**
     * Returns the Ecore language model element for which the exception was
     * caused.
     * 
     * @return the Ecore language model
     */
    public EObject getECause() {
        return cause;
    }

    /**
     * Returns the the specific language feature within {@link #getECause()}
     * which caused the exception.
     * 
     * @return the language feature
     */
    public EStructuralFeature getCausingFeature() {
        return causingFeature;
    }

    /**
     * Returns a numerical code representing the problem.
     * 
     * @return a numerical code
     */
    public int getCode() {
        return code;
    }

    @Override
    public int getId() {
        return code;
    }
    
    /**
     * Returns whether this exception shall be consumed and not passed to the
     * user.
     * 
     * @return <code>true</code> if it shall be consumed, <code>false</code>
     *         else
     */
    public boolean consume() {
        return CONSUME == code;
    }

}
