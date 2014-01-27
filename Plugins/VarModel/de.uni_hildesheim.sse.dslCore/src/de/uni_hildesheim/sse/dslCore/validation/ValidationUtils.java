package de.uni_hildesheim.sse.dslCore.validation;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;

/**
 * Some validation helper methods.
 * 
 * @author Holger Eichelberger
 */
public class ValidationUtils {

    /**
     * Processes messages.
     * 
     * @param result the translation result to take the messages from
     * @param diagnostic the diagnostic instance to add messages to
     */
    public static void processMessages(TranslationResult<?> result, BasicDiagnostic diagnostic) {
        for (int m = 0; m < result.getMessageCount(); m++) {
            Message message = result.getMessage(m);
            diagnostic.add(ValidationUtils.processMessage(message));
        }
    }
    
    /**
     * Processes a <code>message</code>.
     * 
     * @param message the message to be processed
     * @return the related Eclipse diagnosic instance
     */
    public static Diagnostic processMessage(Message message) {
        Severity severity;
        switch (message.getStatus()) {
        case ERROR:
            severity = Severity.ERROR;
            break;
        case WARNING:
            severity = Severity.WARNING;
            break;
        default:
            severity = Severity.INFO;
            break;
        }
        return createDiagnostic(severity, message.getDescription(),
                message.getCause(), message.getCausingFeature(),
                message.getCode(), /* offset, length, */null);
    }

    // checkstyle: stop parameter number check
    
    /**
     * Creates an EMF Eclipse diagnostic instance.
     * 
     * @param severity the severity of the diagnostic
     * @param message the message
     * @param object the causing EMF element in the parse tree
     * @param feature the causing grammar feature
     * @param index an optional index value (aka code)
     * @param code a textual description of the code (may be <b>null</b>)
     * @param issueData optional user specific data
     * @return the created diagnostic element
     */
    private static Diagnostic createDiagnostic(Severity severity, String message,
            EObject object, EStructuralFeature feature, int index, String code,
            String... issueData) {
        int diagnosticSeverity = toDiagnosticSeverity(severity);
        Diagnostic result = new FeatureBasedDiagnostic(diagnosticSeverity,
                message, object, feature, index, CheckType.NORMAL, code,
                issueData);
        return result;
    }
    
    // checkstyle: resume parameter number check

    /**
     * Converts an xText severity into a diagnostic severity.
     * 
     * @param severity the xText severity
     * @return the diagnostic severity
     */
    private static int toDiagnosticSeverity(Severity severity) {
        int diagnosticSeverity = -1;
        switch (severity) {
        case ERROR:
            diagnosticSeverity = Diagnostic.ERROR;
            break;
        case WARNING:
            diagnosticSeverity = Diagnostic.WARNING;
            break;
        case INFO:
            diagnosticSeverity = Diagnostic.INFO;
            break;
        default:
            throw new IllegalArgumentException("Unknow severity " + severity);
        }
        return diagnosticSeverity;
    }
    
}
