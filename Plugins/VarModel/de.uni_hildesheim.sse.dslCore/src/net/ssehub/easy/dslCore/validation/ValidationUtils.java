package net.ssehub.easy.dslCore.validation;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.Arrays;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.FeatureBasedDiagnostic;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.dslCore.BundleId;
import net.ssehub.easy.dslCore.ModelUtility;
import net.ssehub.easy.dslCore.TranslationResult;
import net.ssehub.easy.dslCore.translation.Message;

/**
 * Some validation helper methods.
 * 
 * @author Holger Eichelberger
 */
public class ValidationUtils {

    /**
     * Perform Xtext validation or emulate problem markers on editor save (partial parsing problem).
     */
    private static boolean performValidationOnSave = false; // set true if validation does not work through xtext
    private static List<String> pathPrefixes = new ArrayList<>();

    /**
     * Enables/disables validation on save, e.g., to handle xText conflicts.
     * 
     * @param enable enable or disable
     * @return the previous state
     */
    public static boolean enableOnSave(boolean enable) {
        boolean old = performValidationOnSave;
        performValidationOnSave = enable;
        return old;
    }
    
    public static boolean isOnSaveEnabled() {
        return performValidationOnSave;
    }
    
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
         * @param result the translation result obtained from {@link #createModel(Object, java.net.URI)}
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
    
    /**
     * Returns whether a (model) URI is excluded as it is located in "bin" or "target" to speed
     * up building/validation.
     * 
     * @param uri the URI to check, may be <b>null</b>
     * @return {@code true} for exclusion or <b>null</b>, {@code false} else
     */
    public static boolean excludeBinTarget(URI uri) { // keep it for now, shall be superseded by add/removePath
        boolean result = true;
        if (null != uri) {
            String[] segments = uri.segments();
            if ("platform".equals(uri.scheme()) && segments.length >= 3) {
                String topFolderInProject = segments[2];
                result = "target".equals(topFolderInProject) || "bin".equals(topFolderInProject);
            } else {
                result = Arrays.contains(segments, "target") || Arrays.contains(segments, "bin");
            }
        }
        return result;
    }
    
    /**
     * Turns a file into a matchable URI prefix.
     * 
     * @param file the file 
     * @return the prefix
     */
    private static String toPrefix(File file) {
        URI uri = URI.createFileURI(file.getAbsolutePath());
        String result = uri.toString();
        if (file.isDirectory() && !result.endsWith("/")) {
            result += "/";
        }
        return result;
    }

    /**
     * Adds a {@code file}, usually a model location, as information/prefix which files to validate/process as 
     * resources. Shall be called from Eclipse plugin code only.
     *  
     * @param file the file to add
     */
    public static void addPath(File file) {
        String prefix = toPrefix(file);
        pathPrefixes.add(prefix);
    }
    
    /**
     * Removes a {@code file}, usually a model location, as information/prefix which files to validate/process as 
     * resources. Shall be called from Eclipse plugin code only.
     *  
     * @param file the file to add
     */
    public static void removePath(File file) {
        String prefix = toPrefix(file);
        pathPrefixes.remove(prefix);
    }
    
    /**
     * Returns whether the given EMF resource URI is in a path specified by {@link #addPath(File)}.
     *  
     * @param uri the URI to look for
     * @return {@code true} for in path, {@code false} else
     */
    public static boolean isInPath(URI uri) {
        boolean found = false;
        
        String u = CommonPlugin.asLocalURI(uri).toString();
        for (int p = 0; !found && p < pathPrefixes.size(); p++) {
            found = u.startsWith(pathPrefixes.get(p));
        }
        return found;
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
    public static <R extends EObject, T> void checkModel(R unit, IModelValidationCallback<R, T> callback, 
        boolean debug) {
        if (performValidationOnSave) {
            java.net.URI uri = null;
            URI eURI = null;
            if (null != unit.eResource() && null != unit.eResource().getURI()) {
                try {
                    eURI = unit.eResource().getURI();
                    uri = ModelUtility.toNetUri(unit.eResource().getURI());
                    if (!"file".equals(uri.getScheme())) {
                        uri = null; // initializer may yet not be present, xText does not work with other URI schemes
                    }
                } catch (URISyntaxException e) {
                    getLogger().error("error translating '" + unit.eResource().getURI() 
                        + "' during validation" + e.getMessage());
                }
            }
            if (null != uri && callback.isValidationEnabled(uri) && !excludeBinTarget(eURI) && isInPath(eURI)) {
                String uriText = "";
                if (null != unit.eResource() && null != unit.eResource().getURI()) {
                    uriText = " " + unit.eResource().getURI().toString();
                }
                try {
                    TranslationResult<T> result = callback.createModel(unit, uri);
                    for (int m = 0; m < result.getMessageCount(); m++) {
                        Message message = result.getMessage(m);
                        try {
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
                        } catch (Throwable t) {
                            // in single file validation, EASy messages may not fit to the actual Resource
                            System.out.println("while creating marker (desc: " + message.getDescription() + ", cause: " 
                                + message.getCause() + ", feature: " + message.getCausingFeature() + ", code: "
                                + message.getCode() + "):" + t.getMessage() + uriText);
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
                } catch (Throwable e) { // to be on the safe side
                    getLogger().error("while validating:" + e.getMessage() + uriText);
                    e.printStackTrace();
                }
            }
        }
    }
    
    // checkstyle: resume exception type check
    
}
