package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.PrintStream;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * Defines a specific exception for artifacts.
 * 
 * @author Holger Eichelberger
 */
public class ArtifactException extends AbstractException {

    /**
     * The actual kind of problem is not known (may only appear in case 
     * of multiple but empty causes).
     */
    public static final int ID_UNKNOWN = -1;
    
    /**
     * An I/O problem.
     */
    public static final int ID_IO = 30000;
    
    /**
     * Some kind of security / access problem.
     */
    public static final int ID_SECURITY = 30001;
    
    /**
     * Some kind of (matching) pattern syntax problem.
     */
    public static final int ID_PATTERN = 30002;

    /**
     * Use of an invalid (deleted) object.
     */
    public static final int ID_INVALID = 30003;

    /**
     * No artifact creator is registered to handle a real (underlying) artifact.
     */
    public static final int ID_NO_ARTIFACT_CREATOR = 30004;

    /**
     * An unexpected null value.
     */
    public static final int ID_IS_NULL = 30005;

    /**
     * Use of an invalid type.
     */
    public static final int ID_INVALID_TYPE = 30006;

    /**
     * Use of an invalid character.
     */
    public static final int ID_INVALID_CHARACTER = 30007;

    /**
     * Use of an insufficient argument.
     */
    public static final int ID_INSUFFICIENT_ARGUMENT = 30008;

    /**
     * Use of an invalid pattern.
     */
    public static final int ID_INVALID_PATTERN = 30009;

    /**
     * Happened during instantiation.
     */
    public static final int ID_WHILE_INSTANTIATION = 30010;

    /**
     * Defines an identifier if something about an iterator does not work properly during runtime.
     */
    public static final int ID_RUNTIME_ITERATOR = 30011;

    /**
     * Defines an identifier if something during runtime execution for creating an artifact or a set of artifacts fails.
     */
    public static final int ID_RUNTIME_EXECUTION = 30012;

    /**
     * Defines an identifier if something during runtime execution for creating an artifact or a set of artifacts fails.
     */
    public static final int ID_RUNTIME_RESOURCE = 30013;
    
    /**
     * Defines an identifier if a version string is illegally formatted.
     */
    public static final int ID_INVALID_VERSION = 20014;
    
    /**
     * Defines an identifier if something (unspecified) is wrong in an artifact, e.g., its syntax or semantic.
     */
    public static final int ID_ARTIFACT_INTERNAL = 20015;
    
    /**
     * Identification for serialization.
     */
    private static final long serialVersionUID = 3937309784181227307L;
    
    
    /**
     * Optional additional causes.
     */
    private ArtifactException[] additionalCauses;
    
    /**
     * Creates a new artifact exception.
     * 
     * @param message the message describing the exception
     * @param id the unique id (for testing)
     */
    public ArtifactException(String message, int id) {
        this(message, null, id);
    }

    /**
     * Creates a new artifact exception.
     *
     * @param cause the cause represented by a nested throwable
     * @param id the unique id (for testing)
     */
    public ArtifactException(Throwable cause, int id) {
        super(cause.getMessage(), cause, id);
    }
    
    /**
     * Creates a new artifact exception.
     *
     * @param causes the multiple causes causing this exception
     */
    public ArtifactException(List<ArtifactException> causes) {
        super(getFirstMessage(causes), getFirstCause(causes), getFirstId(causes));
        if (causes.size() > 1) {
            additionalCauses = new ArtifactException[causes.size() - 1];
            for (int i = 1; i < causes.size(); i++) {
                additionalCauses[i - 1] = causes.get(i);
            }
        }
    }
    
    /**
     * Creates a new artifact exception.
     *
     * @param message the message describing the exception
     * @param cause the cause represented by a nested throwable
     * @param id the unique id (for testing)
     */
    public ArtifactException(String message, Throwable cause, int id) {
        super(message, cause, id);
    }

    /**
     * Returns the first message in case of multiple <code>causes</code>.
     * 
     * @param causes the causes
     * @return the first message or an empty string
     */
    private static String getFirstMessage(List<ArtifactException> causes) {
        String result;
        if (null != causes && !causes.isEmpty()) {
            result = causes.get(0).getMessage();
        } else {
            result = "";
        }
        return result;
    }

    /**
     * Returns the first cause in case of multiple <code>causes</code>.
     * 
     * @param causes the causes
     * @return the first cause or <b>null</b>
     */
    private static ArtifactException getFirstCause(List<ArtifactException> causes) {
        ArtifactException result;
        if (null != causes && !causes.isEmpty()) {
            result = causes.get(0);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the first cause in case of multiple <code>causes</code>.
     * 
     * @param causes the causes
     * @return the first cause or {@link #ID_UNKNOWN}
     */
    private static int getFirstId(List<ArtifactException> causes) {
        int result;
        if (null != causes && !causes.isEmpty()) {
            result = causes.get(0).getId();
        } else {
            result = ID_UNKNOWN;
        }
        return result;
    }
    
    @Override
    public void printStackTrace(PrintStream stream) {
        super.printStackTrace(stream);
        if (null != additionalCauses) {
            synchronized (stream) {
                for (int i = 0; i < additionalCauses.length; i++) {
                    additionalCauses[i].printStackTrace(stream);
                }
            }
        }
    }
    
}
