package de.uni_hildesheim.sse.dslCore.translation;

/**
 * Defines error codes for messages used in unit testing.
 * 
 * @author Holger Eichelberger
 */
public class ErrorCodes {

    /**
     * Unknown types.
     */
    public static final int UNKNOWN_TYPE = 20200;

    /**
     * Structural error in initializer, e.g. missing names.
     */
    public static final int INITIALIZER_CONSISTENCY = 20202;

    /**
     * Elements of different types cannot be assigned.
     */
    public static final int TYPE_CONSISTENCY = 20203;
    
    /**
     * An element is defined multiple times.
     */
    public static final int REDEFINITION = 20205;

    /**
     * Errors when names clash.
     */
    public static final int NAME_CLASH = 20210;

    /**
     * Error received from parser and added to message list.
     */
    public static final int FROM_PARSER = 20211;

    /**
     * Errors when a given format is not fulfilled.
     */
    public static final int FORMAT_ERROR = 20212;

    /**
     * Unknown elements such as compound slots (but not types).
     */
    public static final int UNKNOWN_ELEMENT = 20207;

    /**
     * Errors during project import.
     */
    public static final int IMPORT = 20209;

    /**
     * Errors during rules.
     */
    public static final int RULES = 20210;

    /**
     * In case that the identifier "ITER" cannot be resolved (collection iteration).
     */
    public static final int CANNOT_RESOLVE_ITER = 20211;

    /**
     * In case of problems with an initializer container dimension.
     */
    public static final int DIMENSION = 20212;

    /**
     * In case of syntax problems leading to missing parts in the AST.
     */
    public static final int SYNTAX = 20213;

    /**
     * Discouraged use (usually a warning).
     */
    public static final int DISCOURAGED = 20214;
    
    /**
     * A semantically missing element, such as a return expression.
     */
    public static final int MISSING = 20215;
    
    /**
     * Prevents creating instances of this class.
     */
    protected ErrorCodes() {
    }
}
