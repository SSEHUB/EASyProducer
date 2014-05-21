package de.uni_hildesheim.sse.translation;

import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;
import de.uni_hildesheim.sse.ivml.Type;

/**
 * Thrown in case of an unknown type.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class UnknownTypeException extends TranslatorException {

    public static final int CODE = 20002;

    /**
     * Creates an unknown type exception.
     * 
     * @param type the unknown type
     * @param cause the causing type (Ecore object)
     * @param causingFeature the causing Ecore feature
     */
    public UnknownTypeException(String type, Type cause,
            EStructuralFeature causingFeature) {
        super(composeMessage(type), cause, causingFeature, CODE);
    }
    
    /**
     * Composes the message for a given <code>type</code>.
     * 
     * @param type the unknown type
     * @return the message indicating an unknown type
     */
    public static String composeMessage(String type) {
        return "type '" + type + "' is unknown"; // TODO I18N
    }

}
