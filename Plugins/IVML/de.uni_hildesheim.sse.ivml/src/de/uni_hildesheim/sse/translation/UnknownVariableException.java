package de.uni_hildesheim.sse.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.dslCore.translation.TranslatorException;

/**
 * Thrown in case of an unknown variable.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class UnknownVariableException extends TranslatorException {

    public static final int CODE = 20002;

    /**
     * Creates an unknown type exception.
     * 
     * @param name the name of the unknown variable
     * @param cause the causing type (Ecore object)
     * @param causingFeature the causing Ecore feature
     */
    public UnknownVariableException(String name, EObject cause,
            EStructuralFeature causingFeature) {
        super("variable '" + name + "' is unknown", cause, causingFeature, CODE);
    }

}
