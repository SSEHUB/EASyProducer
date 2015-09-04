package de.uni_hildesheim.sse.dslCore.validation;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

import de.uni_hildesheim.sse.dslCore.BundleId;
import de.uni_hildesheim.sse.dslCore.ModelUtility;
import de.uni_hildesheim.sse.dslCore.TranslationResult;
import de.uni_hildesheim.sse.dslCore.translation.Message;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

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

    /**
     * Defines common xText error types.
     * 
     * @author Holger Eichelberger
     */
    public enum MessageType {
        ERROR,
        WARNING,
        INFO;
    }

    /**
     * Defines a validation callback to provide the information required for validation.
     * @author Holger Eichelberger
     *
     * @param <R> the model root type
     * @param <T> the transformation result type
     */
    public interface IModelValidationCallback<R, T> {
        
        /**
         * Returns whether (interactive) validation is enabled. Typically, all model files in a project are considered.
         * However, some build processes such as Maven may copy a model for packaging it. Then the copy of the model may
         * not be valid, as it is not in a model location.
         * 
         * @param uri the URI
         * @return <code>true</code> if validation is enabled, <code>false</code> else
         */
        public boolean isValidationEnabled(java.net.URI uri);
        
        /**
         * Creates a model for validation.
         * 
         * @param root the model root 
         * @param uri the model URI
         * @return the model translation result
         */
        public TranslationResult<T> createModel(R root, java.net.URI uri);
        
        /**
         * Handles a message.
         * 
         * @param type the message type
         * @param message the message text
         * @param source the message source
         * @param feature the feature within <code>source</code>
         * @param identifier an numerical identifier for the message / for testing
         */
        public void message(MessageType type, String message, EObject source, EStructuralFeature feature, 
            int identifier);

        /**
         * Prints out the translation result.
         * 
         * @param result the translation result obtained from {@link #createModel(Object, java.net.URI)
         * @param out the output writer
         */
        public void print(TranslationResult<T> result, Writer out);
    }
    
    /**
     * Returns the responsible logger.
     * 
     * @return the responsible logger
     */
    private static final EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(ValidationUtils.class, BundleId.ID);
    }
    
    // checkstyle: stop exception type check

    /**
     * Checks the model on top-level element layer. 
     * 
     * @param <R> the model root type
     * @param <T> the transformation result type
     * @param unit the variability unit to start tests with
     * @param callback the callback providing relevant model information
     * @param debug shall debug information be emitted
     */
    @Check
    public static <R extends EObject, T> void checkModel(R unit, IModelValidationCallback<R, T> callback, 
        boolean debug) {
        java.net.URI uri = null;
        if (null != unit.eResource() && null != unit.eResource().getURI()) {
            try {
                uri = ModelUtility.toNetUri(unit.eResource().getURI());
                if (!"file".equals(uri.getScheme())) {
                    uri = null; // initializer may yet not be present, xText does not work with other URI schemes
                }
            } catch (URISyntaxException e) {
                getLogger().error("error translating '" + unit.eResource().getURI() 
                    + "' during validation" + e.getMessage());
            }
        }
        if (null != uri && callback.isValidationEnabled(uri)) {
            try {
                TranslationResult<T> result = callback.createModel(unit, uri);
                for (int m = 0; m < result.getMessageCount(); m++) {
                    Message message = result.getMessage(m);
                    switch (message.getStatus()) {
                    case ERROR:
                    case UNSUPPORTED:
                        callback.message(MessageType.ERROR, message.getDescription(), message.getCause(),
                            message.getCausingFeature(), message.getCode());
                        break;
                    case WARNING:
                        callback.message(MessageType.WARNING, message.getDescription(), message.getCause(),
                            message.getCausingFeature(), message.getCode());
                        break;
                    default:
                        callback.message(MessageType.INFO, message.getDescription(), message.getCause(),
                                message.getCausingFeature(), message.getCode());
                        break;
                    }
                }
                if (debug && 0 == result.getMessageCount()) {
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    PrintWriter pOut = new PrintWriter(out);
                    pOut.println(">TRANSLATED MODEL");
                    callback.print(result, pOut);
                    pOut.println("<TRANSLATED MODEL");
                    getLogger().info(out.toString());
                }
            } catch (Exception e) {
                String uriText = "";
                if (null != unit.eResource() && null != unit.eResource().getURI()) {
                    uriText = " " + unit.eResource().getURI().toString();
                }
                getLogger().error("while validating:" + e.getMessage() + uriText);
                e.printStackTrace();
            }
        }
    }
    
    // checkstyle: resume exception type check
    
}
