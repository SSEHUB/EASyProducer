package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import java.io.PrintStream;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.AbstractException;

/**
 * Defines a specific exception issued when building up the model fails for some reason.
 * 
 * @author Holger Eichelberger
 */
public class VilException extends AbstractException {

    /**
     * Defines an identifier if something cannot be found.
     */
    public static final int ID_NOT_FOUND = 50000;

    /**
     * Defines an identifier if something with I/O goes wrong.
     */
    public static final int ID_IO = 50001;

    /**
     * Defines an identifier if something is constant.
     */
    public static final int ID_IS_CONSTANT = 50002;

    /**
     * Defines an identifier if something is wrong with the start rule.
     */
    public static final int ID_RUNTIME_STARTRULE = 50003;

    /**
     * Defines an identifier if something is wrong with the runtime parameter.
     */
    public static final int ID_RUNTIME_PARAMETER = 50004;

    /**
     * Defines an identifier if a Java extension class cannot be resolved.
     */
    public static final int ID_CANNOT_RESOLVE_JAVA_EXTENSION = 50005;

    /**
     * Defines an identifier if something goes into cycles while runtime.
     */
    public static final int ID_RUNTIME_CYCLE = 50006;

    /**
     * Defines an identifier if rules failed at runtime.
     */
    public static final int ID_RUNTIME_RULE_FAILED = 50007;

    /**
     * Defines an identifier if something is wrong a value to type assignment at runtime.
     */
    public static final int ID_RUNTIME_TYPE = 50008;

    /**
     * Defines an identifier if something is wrong with a resolvable element, such as a missing import (whyever).
     */
    public static final int ID_RUNTIME_NOT_RESOLVED = 50009;
    
    /**
     * Defines an identifier if something does not work properly during a system execution call.
     */
    public static final int ID_SYSTEM_EXEC = 50501;

    /**
     * Defines an identifier if something does not work properly during runtime.
     */
    public static final int ID_RUNTIME = 50502;

    /**
     * Defines an identifier if a type cannot be instantiated.
     */
    public static final int ID_CANNOT_INSTANTIATE = 50503;

    /**
     * Defines an identifier if a null value occurs at runtime.
     */
    public static final int ID_NULL_VALUE = 50504;
    
    /**
     * In case that an artifact type is already registered.
     */
    public static final int ID_ALREADY_REGISTERED = 40001;

    /**
     * In case that registering an artifact type fails due to incompatibilities with existing types.
     */
    public static final int ID_TYPE_INCOMPATIBILITY = 40002;

    /**
     * In case that registering an artifact operation was not found.
     */
    public static final int ID_OP_NOT_FOUND = 40003;

    /**
     * In case that an operation returns no result.
     */
    public static final int ID_NO_RESULT = 40004;
    
    /**
     * In case that an operation execution fails.
     */
    public static final int ID_EXECUTION_ERROR = 40005;

    /**
     * In case that an operation execution fails due to security reasons.
     */
    public static final int ID_SECURITY_ERROR = 40006;

    /**
     * In case that relevant data is missing.
     */
    public static final int ID_MISSING_DATA = 40007;

    /**
     * In case that relevant data is invalid.
     */
    public static final int ID_INVALID_DATA = 40008;

    /**
     * In case that the class structure of an instantiator is invalid.
     */
    public static final int ID_INVALID_INSTANTIATOR = 40009;

    /**
     * In case that a static access cannot be handled.
     */
    public static final int ID_STATIC = 40010;
    
    /**
     * The actual kind of problem is not known (may only appear in case 
     * of multiple but empty causes).
     */
    public static final int ID_UNKNOWN = -1;
    
    /**
     * An I/O problem.
     */
    //public static final int ID_IO = 30000;
    
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
     * Defines an identifier if access to a field fails due to read/write restrictions.
     */
    public static final int ID_RUNTIME_READ_WRITE = 30016;
    
    /**
     * Use of an invalid iterator combination.
     */
    public static final int ID_INVALID_ITERATOR = 30017;
    
    /**
     * If an element is not visible.
     */
    public static final int ID_NOT_VISIBLE = 30018;

    /**
     * For serialization.
     */
    private static final long serialVersionUID = 7163856811115265216L;

    /**
     * Optional additional causes.
     */
    private VilException[] additionalCauses;
    
    /**
     * Creates a buildlang exception based on a given <code>message</code>.
     * 
     * @param message the message of the exception
     * @param id the identifier (see constants above)
     */
    public VilException(String message, int id) {
        super(message, id);
    }
    
    /**
     * Creates a buildlang exception from a message and an optional cause.
     * 
     * @param message the message of the exception
     * @param cause the originally causing exception
     * @param id the identifier (see constants above) 
     */
    public VilException(String message, Throwable cause, int id) {
        super(message, cause, id);
    }

    /**
     * Creates an exception from a known exception as cause.
     * Note that the identification from <code>cause</code> is taken over
     * as identification.
     * 
     * @param cause the causing exception 
     */
    public VilException(AbstractException cause) {
        super(cause);
    }
    
    /**
     * Creates an exception from a throwable.
     * 
     * @param throwable the throwable representing cause and message
     * @param id the identifier (see constants above) 
     */
    public VilException(Throwable throwable, int id) {
        super(throwable.getMessage(), throwable, id);
    }

    
    /**
     * Creates a new exception.
     *
     * @param causes the multiple causes causing this exception
     */
    public VilException(List<VilException> causes) {
        super(getFirstMessage(causes), getFirstCause(causes), getFirstId(causes));
        if (causes.size() > 1) {
            additionalCauses = new VilException[causes.size() - 1];
            for (int i = 1; i < causes.size(); i++) {
                additionalCauses[i - 1] = causes.get(i);
            }
        }
    }

    /**
     * Returns the first message in case of multiple <code>causes</code>.
     * 
     * @param causes the causes
     * @return the first message or an empty string
     */
    private static String getFirstMessage(List<VilException> causes) {
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
    private static VilException getFirstCause(List<VilException> causes) {
        VilException result;
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
    private static int getFirstId(List<VilException> causes) {
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
